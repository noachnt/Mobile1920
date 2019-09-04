package com.github.noachnt.coinflip

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.util.*


class MainActivity : AppCompatActivity() {

    lateinit var resultText: TextView
    lateinit var rollButton: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        resultText = findViewById(R.id.result_text) as TextView
        rollButton = findViewById(R.id.roll_button) as Button
        rollButton.setOnClickListener {
            rollCoin()
            Toast.makeText(this, "Coin Flipped", Toast.LENGTH_SHORT).show()
        }
    }

    private fun rollCoin() {
        val randomint = Random().nextInt(2)+ 1

        if(randomint == 2){
            resultText.text = "(H)"

        } else{
            resultText.text = "(T)"
        }
    }



}

