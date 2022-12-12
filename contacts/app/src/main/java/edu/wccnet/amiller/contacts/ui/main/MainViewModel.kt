package edu.wccnet.amiller.contacts.ui.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import edu.wccnet.amiller.contacts.Contact
import edu.wccnet.amiller.contacts.ContactRepository

class MainViewModel(application: Application) : AndroidViewModel(application)  {
    private val repository: ContactRepository = ContactRepository(application)
    private val allContacts: LiveData<List<Contact>>? = repository.allContacts
    private val searchResults: MutableLiveData<List<Contact>> = repository.searchResults
    private val contactAscRes: LiveData<List<Contact>>? = repository.contactAscRes
    private val contactDescRes: LiveData<List<Contact>>? = repository.contactDescRes

    fun insertContact(Contact: Contact) {
        repository.insertContact(Contact)
    }

    fun findContact(name: String) {
        repository.findContact(name)
    }
    fun getAsc() {
        repository.getAsc()
    }
    fun getDesc() {
        repository.getAsc()
    }
    fun deleteContact(id: Int) {
        repository.deleteContact(id)
    }

    fun getSearchResults(): MutableLiveData<List<Contact>> {
        return searchResults
    }

    fun getAscResults(): LiveData<List<Contact>>? {
        return contactAscRes
    }
    fun getDescResults(): LiveData<List<Contact>>? {
        return contactDescRes
    }

    fun getAllContacts(): LiveData<List<Contact>>? {
        return allContacts
    }
}