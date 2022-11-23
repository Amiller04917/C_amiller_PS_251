package edu.wccnet.amiller.coroutine

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView


class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    companion object {
        private var namesAndDelay = arrayOf<Pair<String, Long>>()
    }

    constructor(nad: Array<Pair<String, Long>>): super() {
        namesAndDelay = nad;
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int):
            ViewHolder {
        val v = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.card_layout, viewGroup, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.name.text = "The name is " + namesAndDelay[i].first + " And the delay was " + namesAndDelay[i].second + " Milliseconds."
    }

    override fun getItemCount(): Int {
        return namesAndDelay.size
    }

    inner class ViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var name: TextView
        init {
            name = itemView.findViewById(R.id.name)
        }
    }
}