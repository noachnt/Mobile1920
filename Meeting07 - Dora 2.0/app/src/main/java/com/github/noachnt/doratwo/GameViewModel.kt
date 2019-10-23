package com.github.noachnt.doratwo

import android.util.Log
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.ScrollView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel() {
    init {
        Log.i("GameViewModel", "GameViewModel created")
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("GameViewModel", "GameViewModel destroyed!")
    }


    private var _scene = MutableLiveData<MainStory.Scene>()
    val scene: LiveData<MainStory.Scene>
        get() = _scene

    private var _goToMainMenu = MutableLiveData<Boolean>()
    val goToMainMenu: LiveData<Boolean>
        get() = _goToMainMenu

    val scenes = MainStory.scenes
    var selectedActionId = -1

    init {
        _scene.value = scenes[0]
        _goToMainMenu.value = false
    }

    fun onAction(actions: RadioGroup, opt1: RadioButton, opt2: RadioButton, opt3: RadioButton, opt4: RadioButton, scrollView: ScrollView) {
        val checkedRadioButtonId = actions.checkedRadioButtonId

        when (checkedRadioButtonId) {
            opt1.id -> selectedActionId = 0
            opt2.id -> selectedActionId = 1
            opt3.id -> selectedActionId = 2
            opt4.id -> selectedActionId = 3
        }

        if (checkedRadioButtonId != -1) {

            when (checkedRadioButtonId) {
                opt1.id -> selectedActionId = 0
                opt2.id -> selectedActionId = 1
                opt3.id -> selectedActionId = 2
                opt4.id -> selectedActionId = 3
            }

            when (_scene.value) {
                scenes[0] -> _scene.value = scenes[1] // Intro
                scenes[1] -> { // BOOTS CRAVINGS
                    when (selectedActionId) {
                        0 -> _scene.value = scenes[2]
                        1 -> _scene.value = scenes[3]
                        2 -> _scene.value = scenes[4]
                        3 -> _scene.value = scenes[7]
                    }
                }
                scenes[2] -> { //BOOTS LIKES YOU

                    when(selectedActionId) {
                        0 -> _scene.value = scenes[6]
                        1 -> _scene.value = scenes[7]
                    }
                }
                scenes[3] -> { //HIT BOOTS
                    when(selectedActionId) {
                        0 -> _scene.value = scenes[5]
                        1 -> _scene.value = scenes[7]
                    }
                }
                scenes[4] -> { // IGNORE BOOTS
                    when(selectedActionId) {
                        0 -> _scene.value = scenes[1]
                        1 -> _scene.value = scenes[7]
                    }
                }
                scenes[5] -> { //
                    when(selectedActionId) {
                        0 -> _scene.value = scenes[2]
                        1 -> _scene.value = scenes[10]
                    }
                }
                scenes[6] -> { // DORA AND BOOTS ENTER THE AMAZON
                    when(selectedActionId) {
                        0 -> _scene.value = scenes[8]
                        1 -> _scene.value = scenes[11]
                        2 -> _scene.value = scenes [7]
                    }
                }
                scenes[7] -> { // BAD ENDING 1 (LEFT BOOTS ALONE)
                    MainStory.badEnding1 = true
                    ending()
                }
                scenes[8] -> { // SWIPER LEFT
                    when(selectedActionId) {
                        0 -> _scene.value = scenes[9]
                        1 -> _scene.value = scenes[10]
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

            if (_scene.value!!.actions[0] == "") opt1.isEnabled = false else opt1.isEnabled = true
            if (_scene.value!!.actions[1] == "") opt2.isEnabled = false else opt2.isEnabled = true
            if (_scene.value!!.actions[2] == "") opt3.isEnabled = false else opt3.isEnabled = true
            if (_scene.value!!.actions[3] == "") opt4.isEnabled = false else opt4.isEnabled = true

            actions.clearCheck()
            scrollView.fullScroll(ScrollView.FOCUS_UP)

        }
    }
    private fun ending() {
        when(selectedActionId) {
            0 -> _goToMainMenu.value = true
            1 -> _scene.value = scenes[0]
        }
    }

}