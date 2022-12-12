package edu.wccnet.amiller.contacts

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import edu.wccnet.amiller.contacts.Contact
import edu.wccnet.amiller.contacts.ContactDao
import edu.wccnet.amiller.contacts.ContactRoomDatabase

import kotlinx.coroutines.*
import java.util.Observable

class ContactRepository(application: Application) {

    val searchResults = MutableLiveData<List<Contact>>()
    private var ContactDao: ContactDao?
    private val coroutineScope = CoroutineScope(Dispatchers.Main)
    val allContacts: LiveData<List<Contact>>?
    var contactAscRes: LiveData<List<Contact>>?
    var contactDescRes: LiveData<List<Contact>>?

    init {
        val db: ContactRoomDatabase? =  ContactRoomDatabase.getDatabase(application)
        ContactDao = db?.contactDao()
        contactAscRes = ContactDao?.getContactsAsc()
        contactDescRes = ContactDao?.getContactsDesc()
        allContacts = ContactDao?.getAllContacts()
    }

    fun insertContact(newContact: Contact) {
        coroutineScope.launch(Dispatchers.IO) {
            asyncInsert(newContact)
        }
    }

    private suspend fun asyncInsert(Contact: Contact) {
        ContactDao?.insertContact(Contact)
    }

    fun deleteContact(id: Int) {
        coroutineScope.launch(Dispatchers.IO) {
            asyncDelete(id)
        }
    }

    private suspend fun asyncDelete(id: Int) {
        ContactDao?.deleteContact(id)
    }

    fun getAsc() {
        coroutineScope.launch(Dispatchers.Main) {
            contactAscRes = asyncAsc()
        }
    }

    private suspend fun asyncAsc(): LiveData<List<Contact>>? =

        coroutineScope.async(Dispatchers.IO) {
            return@async ContactDao?.getContactsAsc()
        }.await()

    fun getDesc() {
        coroutineScope.launch(Dispatchers.Main) {
            contactAscRes = asyncAsc()
        }
    }

    private suspend fun asyncDesc(): LiveData<List<Contact>>? =

        coroutineScope.async(Dispatchers.IO) {
            return@async ContactDao?.getContactsDesc()
        }.await()

    fun findContact(name: String) {
        coroutineScope.launch(Dispatchers.Main) {
            searchResults.value = asyncFind("%$name%").await()
        }
    }

    private suspend fun asyncFind(name: String): Deferred<List<Contact>?> =

        coroutineScope.async(Dispatchers.IO) {
            return@async ContactDao?.findContact(name)
        }

}