package com.example.test_task.activity_lifecycle_observers

import android.util.Log
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner

class ActivityLifecycleObserver(
    private val activityName: String
) : DefaultLifecycleObserver {

    companion object {
        const val TAG = "lifecycle"
    }

    override fun onCreate(owner: LifecycleOwner) {
        super.onCreate(owner)
        Log.d(TAG, "$activityName: onCreate")
    }

    override fun onStart(owner: LifecycleOwner) {
        super.onStart(owner)
        Log.d(TAG, "$activityName: onStart")
    }

    override fun onResume(owner: LifecycleOwner) {
        super.onResume(owner)
        Log.d(TAG, "$activityName: onResume")
    }

    override fun onPause(owner: LifecycleOwner) {
        super.onPause(owner)
        Log.d(TAG, "$activityName: onPause")
    }

    override fun onStop(owner: LifecycleOwner) {
        super.onStop(owner)
        Log.d(TAG, "$activityName: onStop")
    }

    override fun onDestroy(owner: LifecycleOwner) {
        super.onDestroy(owner)
        Log.d(TAG, "$activityName: onDestroy")
    }

    fun onSaveInstanceState(){
        Log.d(TAG, "$activityName: onSaveInstanceState")
    }

    fun onRestoreInstanceState(){
        Log.d(TAG, "$activityName: onRestoreInstanceState")
    }
}