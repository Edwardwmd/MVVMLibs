package com.edw.mvvmlibs.bean

/**
 * Author: EdwardWMD
 * Data: 2021/3/15
 * Project: MVVMLibs
 * Website: https://github.com/Edwardwmd
 * Desc: File Information!
 */

data class Categories(
    val alias: Any,
    val bgColor: String,
    val bgPicture: String,
    val defaultAuthorId: Int,
    val description: String,
    val headerImage: String,
    val id: Int,
    val name: String,
    val tagId: Int
)