package com.nguonchhay.androidcomponents.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nguonchhay.androidcomponents.R
import com.nguonchhay.androidcomponents.dataclasses.ToDoData

class ToDoAdapter(var todos: List<ToDoData>): RecyclerView.Adapter<ToDoAdapter.ToDoViewHolder>() {

    inner class ToDoViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToDoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_todo, parent, false)
        return ToDoViewHolder(view)
    }

    override fun onBindViewHolder(holder: ToDoViewHolder, position: Int) {
        val todoItem = todos.get(position)

        val textTitle = holder.itemView.findViewById<TextView>(R.id.textTitle)
        textTitle.text = todoItem.title

        val chkDone = holder.itemView.findViewById<CheckBox>(R.id.chkDone)
        chkDone.isChecked = todoItem.isDone
    }

    override fun getItemCount(): Int {
        return todos.size
    }
}