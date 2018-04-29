package com.alexandre.samplelifecyclecodelab

import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import android.os.SystemClock



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // The ViewModelStore provides a new ViewModel or one previously created.
        val chronometerViewModel = ViewModelProviders.of(this).get(ChronometerViewModel::class.java)

        if(chronometerViewModel.mStartTime == 0L)
        {
            val startTime = SystemClock.elapsedRealtime()
            chronometerViewModel.mStartTime = startTime
            chronometer.base = startTime
        }
        else
        {
            chronometer.base = chronometerViewModel.mStartTime
        }

        chronometer.start()
    }
}
