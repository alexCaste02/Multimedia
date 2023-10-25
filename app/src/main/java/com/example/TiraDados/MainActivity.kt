package com.example.TiraDados

import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.media.MediaPlayer
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var images = arrayOf(
            R.drawable.d1,
            R.drawable.d2,
            R.drawable.d3,
            R.drawable.d4,
            R.drawable.d5,
            R.drawable.d6
        )

        val button: Button = findViewById(R.id.button)
        val imagen: ImageView = findViewById(R.id.topImage)
        val resultTextView: TextView = findViewById(R.id.textView)

        // Initialize MediaPlayer with the sound file
        var mediaPlayer = MediaPlayer.create(this, R.raw.dice) // Replace "your_sound_file" with your sound file name

        button.setOnClickListener {

            mediaPlayer?.start()

            object : CountDownTimer(3000, 250) {

                override fun onTick(millisUntilFinished: Long) {
                    var n = roll6()
                    imagen.setImageResource(images[n])
                    resultTextView.text = ((n + 1).toString())
                }

                override fun onFinish() {

                }

            }.start()
        }
    }



    private fun roll6(): Int {
        return (0..5).random()
    }
}
