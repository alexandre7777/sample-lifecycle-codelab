package com.alexandre.samplelifecyclecodelab

import android.support.v4.app.Fragment;
import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.Observer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import android.arch.lifecycle.ViewModelProviders





class SeekBarFragment : Fragment() {

    private lateinit var mSeekBar: SeekBar

    private var mSeekBarViewModel: SeekBarViewModel? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_seekbar, container, false)
        mSeekBar = root.findViewById(R.id.seekBar)

        mSeekBarViewModel = activity?.let { ViewModelProviders.of(it).get(SeekBarViewModel::class.java) }

        subscribeSeekBar()

        return root
    }

    private fun subscribeSeekBar() {

        // Update the ViewModel when the SeekBar is changed.

        mSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                mSeekBarViewModel?.seekbarValue?.setValue(progress);
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {}

            override fun onStopTrackingTouch(seekBar: SeekBar) {}
        })

        // TODO: Update the SeekBar when the ViewModel is changed.
        mSeekBarViewModel?.seekbarValue?.observe(activity as LifecycleOwner, object : Observer<Int> {
            override fun onChanged(value: Int?) {
                if (value != null) {
                    mSeekBar.progress = value
                }
            }
        })
    }
}