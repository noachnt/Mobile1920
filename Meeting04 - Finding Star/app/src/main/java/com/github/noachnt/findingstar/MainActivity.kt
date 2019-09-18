package com.github.noachnt.findingstar

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.github.noachnt.findingstar.databinding.ActivityMainBinding
import kotlin.random.Random



class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val bigStarShineId = 17301516
    private val bigStarNotShineResId = 17301515
    private lateinit var selectedView: View
    private var selectedId = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val boxesId: List<Int> = listOf(

            binding.boxOneText.id,
            binding.boxTwoText.id,
            binding.boxThreeText.id,
            binding.boxFourText.id,
            binding.boxFiveText.id,
            binding.boxFiveText2.id,
            binding.boxFourText2.id,
            binding.boxThreeText2.id,
            binding.boxThreeText3.id,
            binding.boxThreeText4.id,
            binding.boxFourText3.id,
            binding.boxFiveText4.id,
            binding.boxFiveText5.id


        )
        selectedId = boxesId[Random.nextInt(0, 13)]
        Log.d("ActivityMain :: ", "SelectedID: ${selectedId}; From: ${boxesId}")
        setListeners()
    }

    private fun setRules(view: View) {
        if(view.id == selectedId) {
            setButtonBackground(view, bigStarShineId)
            selectedView = view
            winHandler()
        } else setButtonBackground(view, bigStarNotShineResId)
    }

    private fun setButtonBackground(view: View, buttonIcon: Int) {
        view.setBackgroundResource(buttonIcon)
    }

    private fun winHandler() {
        Toast.makeText(this, "YAY YOU WIN :> ! Tap the shining star to play again", Toast.LENGTH_LONG).show()
        selectedView.setOnClickListener {
            resetGame()
        }
    }

    private fun resetGame() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val boxesId: List<Int> = listOf(
            binding.boxOneText.id,
            binding.boxTwoText.id,
            binding.boxThreeText.id,
            binding.boxFourText.id,
            binding.boxFiveText.id,
            binding.boxFiveText2.id,
            binding.boxFourText2.id,
            binding.boxThreeText2.id,
            binding.boxThreeText3.id,
            binding.boxThreeText4.id,
            binding.boxFourText3.id,
            binding.boxFiveText4.id,
            binding.boxFiveText5.id
        )
        selectedId = boxesId[Random.nextInt(0, 13)]
        Log.d("ActivityMain :: ", "SelectedID: ${selectedId}; From: ${boxesId}")

        val boxOneText = findViewById<TextView>(R.id.box_one_text)
        val boxTwoText = findViewById<TextView>(R.id.box_two_text)
        val boxThreeText = findViewById<TextView>(R.id.box_three_text)
        val boxFourText = findViewById<TextView>(R.id.box_four_text)
        val boxFiveText = findViewById<TextView>(R.id.box_five_text)
        val boxFiveText2 = findViewById<TextView>(R.id.box_five_text2)
        val boxFourText2 = findViewById<TextView>(R.id.box_four_text2)
        val boxThreeText2 = findViewById<TextView>(R.id.box_three_text2)
        val boxThreeText3 = findViewById<TextView>(R.id.box_three_text3)
        val boxThreeText4 = findViewById<TextView>(R.id.box_three_text4)
        val boxFourText3 = findViewById<TextView>(R.id.box_four_text3)
        val boxFiveText4 = findViewById<TextView>(R.id.box_five_text4)
        val boxFiveText5 = findViewById<TextView>(R.id.box_five_text5)


        val clickableViews: List<View> =
            listOf(boxOneText, boxTwoText, boxThreeText,
                boxFourText, boxFiveText, boxFiveText2, boxFourText2, boxThreeText2,
                boxThreeText3, boxThreeText4, boxFourText3, boxFiveText4, boxFiveText5)

        for (item in clickableViews) {
            item.setOnClickListener {
                setRules(it)
            }
            item.setBackgroundColor(Color.WHITE)
        }
    }

    private fun setListeners() {
        val boxOneText = findViewById<TextView>(R.id.box_one_text)
        val boxTwoText = findViewById<TextView>(R.id.box_two_text)
        val boxThreeText = findViewById<TextView>(R.id.box_three_text)
        val boxFourText = findViewById<TextView>(R.id.box_four_text)
        val boxFiveText = findViewById<TextView>(R.id.box_five_text)
        val boxFiveText2 = findViewById<TextView>(R.id.box_five_text2)
        val boxFourText2 = findViewById<TextView>(R.id.box_four_text2)
        val boxThreeText2 = findViewById<TextView>(R.id.box_three_text2)
        val boxThreeText3 = findViewById<TextView>(R.id.box_three_text3)
        val boxThreeText4 = findViewById<TextView>(R.id.box_three_text4)
        val boxFourText3 = findViewById<TextView>(R.id.box_four_text3)
        val boxFiveText4 = findViewById<TextView>(R.id.box_five_text4)
        val boxFiveText5 = findViewById<TextView>(R.id.box_five_text5)

        val clickableViews: List<View> =
            listOf(boxOneText, boxTwoText, boxThreeText,
                boxFourText, boxFiveText, boxFiveText2, boxFourText2, boxThreeText2,
                boxThreeText3, boxThreeText4, boxFourText3, boxFiveText4, boxFiveText5)

        for (item in clickableViews) {
            item.setOnClickListener {
                setRules(it)
            }
        }
    }
}
