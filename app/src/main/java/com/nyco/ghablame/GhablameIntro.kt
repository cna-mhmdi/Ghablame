package com.nyco.ghablame

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.WindowInsets
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.nyco.ghablame.utility.Utils
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class GhablameIntro : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.insetsController?.hide(WindowInsets.Type.statusBars())
        } else {
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
        }
        supportActionBar?.hide()
        setContentView(R.layout.layout_ghablame_intro)

        lifecycleScope.launch {
            delay(5000)
            if (Utils.isConnected(this@GhablameIntro)) {
                startActivity(Intent(this@GhablameIntro, MainActivity::class.java))
                finish()
            } else {
                Toast.makeText(
                    this@GhablameIntro,
                    "از اتصال دستگاه خود به اینترنت مطمعن شوید",
                    Toast.LENGTH_SHORT
                ).show()
                delay(2000)
                finish()
            }
        }
    }
}