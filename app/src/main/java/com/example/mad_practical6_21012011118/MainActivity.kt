package com.example.mad_practical6_21012011118

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val playBtn:FloatingActionButton = findViewById(R.id.play)
        val stopBtn:FloatingActionButton = findViewById(R.id.stop)

        playBtn.setOnClickListener {
            playPauseMusic()
        }

        stopBtn.setOnClickListener {
            stopMusic()
        }
    }

    fun playPauseMusic()
    {
        Intent(applicationContext,MyService::class.java).putExtra(MyService.PLAYERKEY, MyService.PLAYERVALUE).apply {
            startService(this)
        }
    }

    fun stopMusic()
    {
        Intent(applicationContext,MyService::class.java).putExtra(MyService.PLAYERKEY, MyService.PLAYERVALUE).apply {
            stopService(this)
        }
    }
}