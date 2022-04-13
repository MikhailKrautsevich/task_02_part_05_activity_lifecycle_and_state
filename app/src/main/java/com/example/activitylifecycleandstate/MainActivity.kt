package com.example.activitylifecycleandstate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    companion object {
        private const val COUNT_KEY: String = "com.example.activitylifecycleandstate.COUNT_KEY"
    }

    private lateinit var mTextView: TextView
    private lateinit var mBtnCountUp: Button
    private var mCount: Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mTextView = findViewById(R.id.textview)
        mBtnCountUp = findViewById(R.id.btn_count)
        mBtnCountUp.setOnClickListener {
            mCount++
            showCount()
        }
        savedInstanceState?.let { mCount = savedInstanceState.getInt(COUNT_KEY) }
        showCount()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(COUNT_KEY, mCount)
    }

    private fun showCount() {
        mTextView.text = mCount.toString()
    }
}