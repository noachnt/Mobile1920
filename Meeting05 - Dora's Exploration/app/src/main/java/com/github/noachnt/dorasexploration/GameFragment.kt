package com.github.noachnt.dorasexploration

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ScrollView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.github.noachnt.dorasexploration.databinding.FragmentGameBinding

class GameFragment : Fragment() {

    // Variables
    private val scenes = MainStory.scenes
    lateinit var currentScene: MainStory.Scene
    private var selectedActionId: Int = 0

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val binding = DataBindingUtil.inflate<FragmentGameBinding>(
            inflater, R.layout.fragment_game, container, false)

        currentScene = scenes[0]


        binding.scene = this

        binding.actionButton.setOnClickListener {

            if(binding.actions.checkedRadioButtonId != -1) {

                when (binding.actions.checkedRadioButtonId) {
                    binding.actionOne.id -> selectedActionId = 0
                    binding.actionTwo.id -> selectedActionId = 1
                    binding.actionThree.id -> selectedActionId = 2
                    binding.actionFour.id -> selectedActionId = 3
                }

                when (currentScene) {
                    scenes[0] -> currentScene = scenes[1] // Intro
                    scenes[1] -> { // BOOTS CRAVINGS
                        when(selectedActionId) {
                            0 -> currentScene = scenes[2]
                            1 -> currentScene = scenes[3]
                            2 -> currentScene = scenes[4]
                            3 -> currentScene = scenes[7]
                        }
                    }
                    scenes[2] -> { //BOOTS LIKES YOU

                        when(selectedActionId) {
                            0 -> currentScene = scenes[6]
                            1 -> currentScene = scenes[7]
                        }
                    }
                    scenes[3] -> { //HIT BOOTS
                        when(selectedActionId) {
                            0 -> currentScene = scenes[5]
                            1 -> currentScene = scenes[7]
                        }
                    }
                    scenes[4] -> { // IGNORE BOOTS
                        when(selectedActionId) {
                            0 -> currentScene = scenes[1]
                            1 -> currentScene = scenes[7]
                        }
                    }
                    scenes[5] -> { //
                        when(selectedActionId) {
                            0 -> currentScene = scenes[2]
                            1 -> currentScene = scenes[10]
                        }
                    }
                    scenes[6] -> { // DORA AND BOOTS ENTER THE AMAZON
                        when(selectedActionId) {
                            0 -> currentScene = scenes[8]
                            1 -> currentScene = scenes[11]
                            2 -> currentScene = scenes [7]
                        }
                    }
                    scenes[7] -> { // BAD ENDING 1 (LEFT BOOTS ALONE)
                        MainStory.badEnding1 = true
                        ending()
                    }
                    scenes[8] -> { // SWIPER LEFT
                        when(selectedActionId) {
                            0 -> currentScene = scenes[9]
                            1 -> currentScene = scenes[10]
                        }
                    }
                    scenes[9] -> { // NORMAL ENDING 2 (DORA & BOOTS FINISH THE ADV)
                            MainStory.normalEnding1 = true
                            ending()

                    }
                    scenes[10] -> { // BAD ENDING 2
                        MainStory.badEnding2 = true
                        ending()
                    }

                    scenes[11] -> { // BEST ENDING
                        MainStory.bestEnding = true
                        ending()
                    }

                }

                // Disabling option
                if (currentScene.actions[0] == "") binding.actionOne.isEnabled = false else binding.actionOne.isEnabled = true
                if (currentScene.actions[1] == "") binding.actionTwo.isEnabled = false else binding.actionTwo.isEnabled = true
                if (currentScene.actions[2] == "") binding.actionThree.isEnabled = false else binding.actionThree.isEnabled = true
                if (currentScene.actions[3] == "") binding.actionFour.isEnabled = false else binding.actionFour.isEnabled = true

                binding.actions.clearCheck()
                binding.scrollView.fullScroll(ScrollView.FOCUS_UP)
                binding.invalidateAll()
            } else {
                Toast.makeText(this.activity, "Select one of the actions to continue!", Toast.LENGTH_SHORT).show()
            }
        }

        return binding.root
    }

    private fun ending() {
        when(selectedActionId) {
            0 -> this.activity!!.onBackPressed()
            1 -> currentScene = scenes[0]
        }
    }

}