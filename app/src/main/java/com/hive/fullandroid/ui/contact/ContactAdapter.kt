package com.hive.fullandroid.ui.contact

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.hive.fullandroid.R
import com.hive.fullandroid.repository.local.entity.Contact

class ContactAdapter(private val context: Context?,
                     private val contacts: List<Contact>) : RecyclerView.Adapter<ContactAdapter.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): Holder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_contact, parent, false)
        return Holder(view)
    }

    override fun getItemCount(): Int {
        return contacts.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val contact = contacts[position]

        setLabel(contact, holder)
    }

    private fun setLabel(contact: Contact, holder: Holder) {
        holder.label.text = contact.email
    }


    class Holder(view: View) : RecyclerView.ViewHolder(view) {
        val label = view.findViewById(R.id.item_label) as TextView
    }

}
