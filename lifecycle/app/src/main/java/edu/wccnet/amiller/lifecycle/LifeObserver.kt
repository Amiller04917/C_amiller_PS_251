package edu.wccnet.amiller.lifecycle

<<<<<<< HEAD
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.OnLifecycleEvent

class LifeObserver : LifecycleObserver {
    private var observed: MutableLiveData<String> = MutableLiveData<String>("test")

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onStart() {
        observed.value += "onStart\r\n";
=======
import androidx.lifecycle.*
import edu.wccnet.amiller.lifecycle.ui.main.MainViewModel

class LifeObserver : LifecycleObserver {
    var mv = MainViewModel

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onStart() {
        mv.appendLifeVal("onStart")
>>>>>>> 67b09fb9078468529495c9f135f1f2f55d8ccfde
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onStop() {
<<<<<<< HEAD
        observed.value += "onStop\r\n";
=======
        mv.appendLifeVal("onStop")
>>>>>>> 67b09fb9078468529495c9f135f1f2f55d8ccfde
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onPause() {
<<<<<<< HEAD
        observed.value += "onPause\r\n";
=======
        mv.appendLifeVal("onPause", Lifecycle.Event.ON_PAUSE)
>>>>>>> 67b09fb9078468529495c9f135f1f2f55d8ccfde
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResume() {
<<<<<<< HEAD
        observed.value += "onResume\r\n";
=======
        mv.appendLifeVal("onResume", Lifecycle.Event.ON_RESUME)
>>>>>>> 67b09fb9078468529495c9f135f1f2f55d8ccfde
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {
<<<<<<< HEAD
        observed.value += "onCreate\r\n";
=======
        mv.appendLifeVal("onCreate")
>>>>>>> 67b09fb9078468529495c9f135f1f2f55d8ccfde
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy() {
<<<<<<< HEAD
        observed.value += "onDestroy\r\n";
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
    fun onAny() {
        observed.value += "onAny\r\n";
    }

    fun getObserved(): MutableLiveData<String> {
        return observed;
    }
=======
        mv.appendLifeVal("onDestroy", Lifecycle.Event.ON_DESTROY)
    }

    // Any observer is causing everything to be double logged.
    // I could make it so that the events we already declared are ignored,
    // but I see that you also commented it out in your example.
//    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
//    fun onAny(owner: LifecycleOwner, event: Lifecycle.Event) {
//        mv.appendLifeVal(owner.lifecycle.currentState.name + "\r\n")
//    }
>>>>>>> 67b09fb9078468529495c9f135f1f2f55d8ccfde
}