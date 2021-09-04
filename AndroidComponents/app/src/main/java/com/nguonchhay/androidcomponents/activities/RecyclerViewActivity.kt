package com.nguonchhay.androidcomponents.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.nguonchhay.androidcomponents.adapters.ToDoAdapter
import com.nguonchhay.androidcomponents.databinding.ActivityRecyclerViewBinding
import com.nguonchhay.androidcomponents.dataclasses.ToDoData

class RecyclerViewActivity : AppCompatActivity() {

    lateinit var binding: ActivityRecyclerViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecyclerViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var todoList = mutableListOf(
            ToDoData("Eat", false),
            ToDoData("Sleep", false),
            ToDoData("Walk", true),
            ToDoData("Listening to music", true),
            ToDoData("Exercise", false),
        )

        val todoAdapter = ToDoAdapter(todoList)
        binding.recycleView.adapter = todoAdapter
        binding.recycleView.layoutManager = LinearLayoutManager(this)

        binding.btnAdd.setOnClickListener {
            val itemText = binding.editItem.text.toString()
            if (itemText != "") {
                todoList.add(ToDoData(itemText, false))
                todoAdapter.notifyItemInserted(todoList.size - 1)

                binding.editItem.text.clear()
                Toast.makeText(this, "Item is saved!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Text is required!", Toast.LENGTH_LONG).show()
            }
        }
    }
}