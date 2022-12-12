package edu.wccnet.amiller.contacts
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contacts")
class Contact {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "contactId")
    var id: Int = 0

    @ColumnInfo(name = "contactName")
    var contactName: String? = null

    @ColumnInfo(name = "contactNumber")
    var contactNumber: String? = null

    constructor() {}

    /*SHOWN IN BOOK BUT DOES NOT SEEM TO BE NEEDED
    constructor(id: Int, productname: String, quantity: Int) {
        this.productName = productname
        this.quantity = quantity
    }*/

    constructor(contactName: String, contactNumber: String) {
        this.contactName = contactName
        this.contactNumber = contactNumber
    }
}