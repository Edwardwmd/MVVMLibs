package com.edw.mvvmlibs.net.client

import com.google.gson.Gson
import com.google.gson.TypeAdapter
import com.google.gson.reflect.TypeToken
import com.google.gson.stream.JsonReader
import com.google.gson.stream.JsonWriter
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.ResponseBody
import okio.Buffer
import retrofit2.Converter
import retrofit2.Retrofit
import java.io.IOException
import java.io.OutputStreamWriter
import java.io.Writer
import java.lang.reflect.Type

import java.nio.charset.Charset
import kotlin.jvm.Throws


/**
 * Author: EdwardWMD
 * Data: 2021/3/14
 * Project: MVVMLibs
 * Website: https://github.com/Edwardwmd
 * Desc: File Information!
 */
class LenientGsonConverterFactory constructor(gson: Gson) : Converter.Factory() {
    private var gson: Gson? = null

    companion object {
        fun create(): LenientGsonConverterFactory {
            return create(Gson())
        }

        fun create(gson: Gson): LenientGsonConverterFactory {
            return LenientGsonConverterFactory(gson)
        }
    }

    init {
        this.gson = gson
    }

    override fun requestBodyConverter(
        type: Type,
        parameterAnnotations: Array<out Annotation>,
        methodAnnotations: Array<out Annotation>,
        retrofit: Retrofit
    ): Converter<*, RequestBody>? {
        val adapter: TypeAdapter<*> = gson!!.getAdapter(TypeToken.get(type))

        return LenientGsonRequestBodyConverter(gson!!, adapter)
    }

    override fun responseBodyConverter(
        type: Type,
        annotations: Array<out Annotation>,
        retrofit: Retrofit
    ): Converter<ResponseBody, *>? {
        val adapter: TypeAdapter<*> = gson!!.getAdapter(TypeToken.get(type))
        return LenientGsonResponseBodyConverter(gson!!, adapter)
    }


    inner class LenientGsonRequestBodyConverter<T> constructor(
        gson: Gson,
        adapter: TypeAdapter<T>
    ) : Converter<T, RequestBody> {

        private val MEDIA_TYPE: MediaType = "application/json; charset=UTF-8".toMediaTypeOrNull()!!
        private val UTF_8: Charset = Charset.forName("UTF-8")

        private var gson: Gson? = null
        private var adapter: TypeAdapter<T>? = null

        init {
            this.gson = gson
            this.adapter = adapter
        }

        @Throws(IOException::class)
        override fun convert(value: T): RequestBody? {
           val buffer= Buffer()
            val writer: Writer = OutputStreamWriter(buffer.outputStream(), UTF_8)
            val jsonWriter: JsonWriter = gson!!.newJsonWriter(writer)
            jsonWriter.isLenient = true
            adapter!!.write(jsonWriter, value)
            jsonWriter.close()
            return buffer.readByteString().toRequestBody(MEDIA_TYPE)

        }

    }


    inner class LenientGsonResponseBodyConverter<T> constructor(gson: Gson, adapter: TypeAdapter<T>):Converter<ResponseBody, T>{
        private var gson: Gson? = null
        private var adapter: TypeAdapter<T>? = null

        init {
            this.gson=gson
            this.adapter=adapter
        }

        @Throws(IOException::class)
        override fun convert(value: ResponseBody): T? {
            val jsonReader: JsonReader = gson!!.newJsonReader(value.charStream())
            jsonReader.isLenient = true
            return try {
                adapter!!.read(jsonReader)
            } finally {
                value.close()
            }

        }


    }
}