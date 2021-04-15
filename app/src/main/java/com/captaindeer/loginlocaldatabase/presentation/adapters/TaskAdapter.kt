package com.captaindeer.loginlocaldatabase.presentation.adapters

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.captaindeer.loginlocaldatabase.R
import com.captaindeer.loginlocaldatabase.data.local.entities.SlotA
import com.captaindeer.loginlocaldatabase.presentation.adapters.listeners.TaskListener
import com.captaindeer.loginlocaldatabase.presentation.adapters.viewHolders.TaskViewHolder
import kotlinx.android.synthetic.main.task_fragment.view.*

class TaskAdapter(private var tasks: MutableList<SlotA>, private val listener: TaskListener) :
    RecyclerView.Adapter<TaskViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        return TaskViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.task_fragment, parent, false)
        )
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val task = tasks[position]

        holder.itemView.apply {
            tv_task.text = task.task.toString()
            checkbox.isChecked = task.isChecked
            toggleStrikeTrough(tv_task, task.isChecked)
            checkbox.setOnCheckedChangeListener { _, isChecked ->
                toggleStrikeTrough(tv_task, isChecked)
                task.isChecked = !task.isChecked
                if (isChecked){
                    listener.changeCheckbox(task)
                }else
                    listener.changeCheckbox(task)
            }
        }
    }

    override fun getItemCount(): Int = tasks.size

    fun updateData(tasks: MutableList<SlotA>) {
        this.tasks = tasks
        notifyDataSetChanged()
    }

    private fun toggleStrikeTrough(task: TextView, isChecked: Boolean) {
        if (isChecked) {
            task.paintFlags = task.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG

        } else
            task.paintFlags = task.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
    }


}