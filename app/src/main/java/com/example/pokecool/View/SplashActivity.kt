package com.example.pokecool.View

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import com.example.pokecool.R
/**
 * View Class for main Splash Screen
 */
class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        setupView()
    }

    /**
     * Sets up the view elements and starts a 3 second counter.
     * WHen the timer is finished, the MainActivity is launched
     */
    private fun setupView() {
        val intent = Intent(this, MainActivity::class.java)
        object : CountDownTimer(3000, 1000) {
            override fun onTick(millisUntilFinished: Long) {}
            override fun onFinish() {
                startActivity(intent)
            }
        }.start()
    }
}