package com.alexandre.samplelifecyclecodelab

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.MutableLiveData
import android.os.SystemClock
import java.util.*
import android.arch.lifecycle.LiveData

class LiveDataTimerViewModel : ViewModel () {

    private val ONE_SECOND : Long = 1000

    private val mElapsedTime = MutableLiveData<Long>()

    private var mInitialTime: Long = 0

    init {
        mInitialTime = SystemClock.elapsedRealtime()
        val timer = Timer()

        // Update the elapsed time every second.
        timer.scheduleAtFixedRate(object : TimerTask() {
            override fun run() {
                val newValue = (SystemClock.elapsedRealtime() - mInitialTime) / 1000

                mElapsedTime.postValue(newValue)
            }
        }, ONE_SECOND, ONE_SECOND)
    }

    fun getElapsedTime(): LiveData<Long> {
        return mElapsedTime
    }
}