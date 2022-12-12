package edu.wccnet.amiller.contacts.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import edu.wccnet.amiller.contacts.Contact
import edu.wccnet.amiller.contacts.R


class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    companion object {
        private var contacts: List<Contact> = listOf()
    }

    constructor(cont: List<Contact>): super() {
        contacts = contacts;
    }
    constructor(): super() {
    }

    interface onItemClickListener {
        fun onClick(id: Int)
    }

    var listener: onItemClickListener? = null
    fun settingListener(listener: onItemClickListener?) {
        this.listener = listener
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int):
            ViewHolder {
        val v = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.card_layout, viewGroup, false)
        return ViewHolder(v)
    }

    fun setContactList(conts: List<Contact>) {
        contacts = conts
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.name.text = contacts[i].contactName
        viewHolder.number.text = contacts[i].contactNumber

        viewHolder.delete.setOnClickListener{
            listener?.onClick(contacts[i].id)
        }
    }

    override fun getItemCount(): Int {
        return contacts.size
    }

    inner class ViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var name: TextView
        var number: TextView
        var delete: ImageButton
        init {
            name = itemView.findViewById(R.id.name)
            number = itemView.findViewById(R.id.number)
            delete = itemView.findViewById(R.id.imageButton)
        }
    }
}