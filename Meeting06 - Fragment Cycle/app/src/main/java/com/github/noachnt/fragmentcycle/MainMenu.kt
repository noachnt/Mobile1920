package com.github.noachnt.fragmentcycle

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.github.noachnt.fragmentcycle.databinding.FragmentMainMenuBinding
import timber.log.Timber

class MainMenu : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        Timber.plant(Timber.DebugTree())
        val binding = DataBindingUtil.inflate<FragmentMainMenuBinding>(inflater,
            R.layout.fragment_main_menu, container, false)

        binding.startButton.setOnClickListener {
            it.findNavController().navigate(R.id.action_mainMenu_to_gameFragment)
        }

        return binding.root
    }

    override fun onStart(){
        super.onStart()
        Timber.i("onStart Called")
    }

    override fun onResume() {
        super.onResume()
        Timber.i("onResume Called")
    }

    override fun onPause() {
        super.onPause()
        Timber.i("onPause Called")
    }

    override fun onStop() {
        super.onStop()
        Timber.i("onStop Called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Timber.i("onDestroy Called")
    }


}