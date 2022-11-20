package edu.wccnet.amiller.lifecycle

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.OnLifecycleEvent

class LifeObserver : LifecycleObserver {
    private var observed: MutableLiveData<String> = MutableLiveData<String>("test")

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onStart() {
        observed.value += "onStart\r\n";
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onStop() {
        observed.value += "onStop\r\n";
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onPause() {
        observed.value += "onPause\r\n";
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResume() {
        observed.value += "onResume\r\n";
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {
        observed.value += "onCreate\r\n";
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy() {
        observed.value += "onDestroy\r\n";
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
    fun onAny() {
        observed.value += "onAny\r\n";
    }

    fun getObserved(): MutableLiveData<String> {
        return observed;
    }
}