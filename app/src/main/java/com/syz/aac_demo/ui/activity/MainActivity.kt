package com.syz.aac_demo.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.syz.aac_demo.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private val userViewModel by lazy {
        com.syz.aac_demo.vm.UserViewModel()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        userViewModel.data?.observe(this, Observer {
            textView2.text = it.toString()
        })
        textView.setOnClickListener {
            val id = Random.nextInt()
            userViewModel.updateUserName("name:$id")
        }
    }
}
