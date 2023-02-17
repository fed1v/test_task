package com.example.test_task.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.test_task.R
import com.example.test_task.activities.MainActivity.Companion.FIRST_ACTIVITY_NUMBER
import com.example.test_task.activity_lifecycle_observers.ActivityLifecycleObserver

class SecondActivity : AppCompatActivity() {
    private lateinit var textViewNumber: TextView
    private lateinit var buttonGoToFirstActivity: Button

    private lateinit var lifecycleObserver: ActivityLifecycleObserver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        initLifecycleObserver()
        initView()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        lifecycleObserver.onSaveInstanceState()
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        lifecycleObserver.onRestoreInstanceState()
    }

    private fun initLifecycleObserver() {
        lifecycleObserver = ActivityLifecycleObserver("SecondActivity")

        lifecycle.addObserver(lifecycleObserver)
    }

    private fun initView() {
        textViewNumber = findViewById(R.id.textview_number_2)
        buttonGoToFirstActivity = findViewById(R.id.btn_go_to_first_activity)

        val firstActivityNumber = intent.getIntExtra(FIRST_ACTIVITY_NUMBER, 0)

        textViewNumber.text = (firstActivityNumber * firstActivityNumber).toString()

        buttonGoToFirstActivity.setOnClickListener {
            startActivity(
                Intent(this, MainActivity::class.java)
            )
        }
    }
}