package edu.wccnet.amiller.lifecycle.ui.main

<<<<<<< HEAD
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    // TODO: Implement the ViewModel
    var struc: String = "Organization Structure"

=======
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class MainViewModel : ViewModel() {
    companion object{
        private var lifeVal: MutableLiveData<String> = MutableLiveData("")

        fun appendLifeVal(value: String, event: Lifecycle.Event? = null){
            lifeVal.value += value + " was fired on " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss.SSS")) + "\r\n"

            if(event == Lifecycle.Event.ON_DESTROY ||
                event == Lifecycle.Event.ON_RESUME ||
                event == Lifecycle.Event.ON_PAUSE)
                lifeVal.value += "*******************\r\n"
        }
    }

    fun getLifeVal(): MutableLiveData<String>{
        return lifeVal
    }
>>>>>>> 67b09fb9078468529495c9f135f1f2f55d8ccfde
}