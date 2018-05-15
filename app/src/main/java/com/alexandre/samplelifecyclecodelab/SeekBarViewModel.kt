package com.alexandre.samplelifecyclecodelab

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.MutableLiveData

class SeekBarViewModel : ViewModel() {
    var seekbarValue = MutableLiveData<Int>()
}