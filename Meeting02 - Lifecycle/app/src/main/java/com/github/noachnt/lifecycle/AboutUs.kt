package com.github.noachnt.lifecycle

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class AboutUs: AppCompatActivity() {

    val TAG="About Us"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        Log.d(TAG, "Inside onCreate")
        Toast.makeText(this,"Your are under about us",Toast.LENGTH_LONG).show()
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG,"In OnStart")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG,"In OnStop")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG,"In OnPause")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG,"In OnDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG,"In OnRestart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG,"In OnResume")
    }
}