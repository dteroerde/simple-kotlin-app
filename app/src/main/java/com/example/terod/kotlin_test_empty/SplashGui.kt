package com.example.terod.kotlin_test_empty

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.Handler

class SplashGui : Activity() {

    private val SPLASH_DISPLAY_LENGTH = 1500

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_gui)
            Handler().postDelayed(Runnable {
            val mainIntent = Intent(this@SplashGui, MainActivity::class.java)
            this@SplashGui.startActivity(mainIntent)
            this@SplashGui.finish()
        }, SPLASH_DISPLAY_LENGTH.toLong())
    }
}