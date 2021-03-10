package com.edw.mvvmlibs.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.edw.mvvmlibs.R
import com.edw.mvvmlibs.databinding.ActivityShowListBinding

class ShowListActivity : AppCompatActivity() {
    private var databinding: ActivityShowListBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_list)
        databinding= ActivityShowListBinding.inflate(layoutInflater)
        databinding?.apply {
        }
    }
}