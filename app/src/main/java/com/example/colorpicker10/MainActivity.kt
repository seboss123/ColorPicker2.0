package com.example.colorpicker10

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var redVal = 127
    var greenVal = 127
    var blueVal = 127
    var alpha = 255

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val redSeek = findViewById<SeekBar>(R.id.redSeekBar)
        val greenSeek = findViewById<SeekBar>(R.id.greenSeekBar)
        val blueSeek = findViewById<SeekBar>(R.id.blueSeekBar)

        redSeek.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                redVal = progress
                redValue.text = redVal.toString()
                showColor.setBackgroundColor(Color.argb(alpha,redVal,greenVal,blueVal))

            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }

        })
        greenSeek.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                greenVal = progress
                greenValue.text = greenVal.toString()
                showColor.setBackgroundColor(Color.argb(alpha,redVal,greenVal,blueVal))

            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }

        })
        blueSeek.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                blueVal = progress
                blueValue.text = blueVal.toString()
                showColor.setBackgroundColor(Color.argb(alpha,redVal,greenVal,blueVal))

            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }

        })
    }
}
