package com.example.mad_practical6_21012011118

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    var flag=1;
    lateinit var playBtn:FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val stopBtn:FloatingActionButton = findViewById(R.id.stop)
        playBtn = findViewById(R.id.play)

        playBtn.setOnClickListener {
            playPauseMusic()
        }

        stopBtn.setOnClickListener {
            stopMusic()
        }
    }

    fun playPauseMusic()
    {
      //  val playBtn:FloatingActionButton = findViewById(R.id.play)

        if(flag==1)
        {
            playBtn.setImageResource(R.drawable.baseline_pause_24)
            flag=2
        }
        else
        {
            playBtn.setImageResource(R.drawable.baseline_play_arrow_24)
            flag=1
        }
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