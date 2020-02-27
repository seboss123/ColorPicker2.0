package com.example.colorpicker10

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.SeekBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File
import java.io.PrintWriter


class MainActivity : AppCompatActivity() {
    var redVal = 127
    var greenVal = 127
    var blueVal = 127
    var alpha = 255
    var colorName = ""
    val fileName = "TestFile"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val redSeek = findViewById<SeekBar>(R.id.redSeekBar)
        val greenSeek = findViewById<SeekBar>(R.id.greenSeekBar)
        val blueSeek = findViewById<SeekBar>(R.id.blueSeekBar)

        setSupportActionBar(findViewById(R.id.my_toolbar))



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

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.toolbarmenu, menu)
        return true
    }

    fun saveText(text: String) {
        val path = filesDir
        val letDirectory = File(path, "LET")
        letDirectory.mkdirs()
        val file = File(letDirectory, "Colors.txt")

        file.appendText(text)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {


        when (item.itemId) {
            R.id.saveButton -> {
                val colorTextView = findViewById<TextView>(R.id.colorName)



                colorName = colorTextView.text.toString()

                saveText(colorName + "," + redVal + "," + greenVal + "," + blueVal + "\n")

                Log.e("It worked!!", colorName + " " + redVal + " " + greenVal + " " + blueVal)
                return true
            }
            R.id.clearButton -> {
                val path = filesDir
                val letDirectory = File(path, "LET")
                letDirectory.mkdirs()
                val file = File(letDirectory, "Colors.txt")
                val pw = PrintWriter(file)
                pw.close()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
