package com.jshvarts.githubkmp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.jshvarts.Greeting
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        greeting.text = Greeting().greeting()
    }
}
