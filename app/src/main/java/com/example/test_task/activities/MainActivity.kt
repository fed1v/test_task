package com.example.test_task.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.test_task.R
import com.example.test_task.activity_lifecycle_observers.ActivityLifecycleObserver

class MainActivity : AppCompatActivity() {
    private lateinit var textViewNumber: TextView
    private lateinit var buttonGoToSecondActivity: Button

    private lateinit var lifecycleObserver: ActivityLifecycleObserver

    private var number = 0

    companion object {
        const val FIRST_ACTIVITY_NUMBER = "first_activity_number"
        const val SAVE_NUMBER_TAG = "number"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initLifecycleObserver()
        initView(savedInstanceState)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(SAVE_NUMBER_TAG, number)
        lifecycleObserver.onSaveInstanceState()
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        lifecycleObserver.onRestoreInstanceState()
    }

    private fun initLifecycleObserver() {
        lifecycleObserver = ActivityLifecycleObserver("MainActivity")

        lifecycle.addObserver(lifecycleObserver)
    }

    private fun initView(savedInstanceState: Bundle?) {
        textViewNumber = findViewById(R.id.textview_number_1)
        buttonGoToSecondActivity = findViewById(R.id.btn_go_to_second_activity)

        buttonGoToSecondActivity.setOnClickListener {
            startActivity(
                Intent(this, SecondActivity::class.java)
                    .putExtra(FIRST_ACTIVITY_NUMBER, number)
            )
        }

        if (savedInstanceState != null) {
            number = savedInstanceState.getInt(SAVE_NUMBER_TAG) + 1
        }

        textViewNumber.text = number.toString()
    }
}