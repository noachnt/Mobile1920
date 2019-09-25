package com.github.noachnt.dorasexploration

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.github.noachnt.dorasexploration.databinding.FragmentHowToPlayBinding

class HowToPlay : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentHowToPlayBinding>(inflater,
            R.layout.fragment_how_to_play, container, false)

        return binding.root
    }


}