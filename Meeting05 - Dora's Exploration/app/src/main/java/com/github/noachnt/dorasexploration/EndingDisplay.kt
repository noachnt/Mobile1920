package com.github.noachnt.dorasexploration

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.github.noachnt.dorasexploration.databinding.FragmentEndingDisplayBinding


class EndingDisplay : Fragment() {

    val currentEnding: MainStory.Scene = MainStory.currentDisplayedEnding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentEndingDisplayBinding>(inflater,
            R.layout.fragment_ending_display, container, false)

        binding.endingDisplay = this

        return binding.root
    }


}