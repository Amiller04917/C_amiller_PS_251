package edu.wccnet.amiller.lifecycle

import androidx.lifecycle.*
import edu.wccnet.amiller.lifecycle.ui.main.MainViewModel

class LifeObserver : LifecycleObserver {
    var mv = MainViewModel

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onStart() {
        mv.appendLifeVal("onStart")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onStop() {
        mv.appendLifeVal("onStop")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onPause() {
        mv.appendLifeVal("onPause", Lifecycle.Event.ON_PAUSE)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResume() {
        mv.appendLifeVal("onResume", Lifecycle.Event.ON_RESUME)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {
        mv.appendLifeVal("onCreate")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy() {
        mv.appendLifeVal("onDestroy", Lifecycle.Event.ON_DESTROY)
    }

    // Any observer is causing everything to be double logged.
    // I could make it so that the events we already declared are ignored,
    // but I see that you also commented it out in your example.
//    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
//    fun onAny(owner: LifecycleOwner, event: Lifecycle.Event) {
//        mv.appendLifeVal(owner.lifecycle.currentState.name + "\r\n")
//    }
}