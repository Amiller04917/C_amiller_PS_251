package edu.wccnet.amiller.addnamesave.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import edu.wccnet.amiller.addnamesave.databinding.MainFragmentBinding

class MainViewModel : ViewModel() {
    private var names: MutableLiveData<String> = MutableLiveData<String>("")

    fun addName(binding: MainFragmentBinding) {
        if (binding.editTextTextPersonName.text.isEmpty())
            return

        names.value += binding.editTextTextPersonName.text.toString() + "\r\n"
    }

    fun getName(): MutableLiveData<String> {
        return names;
    }
}