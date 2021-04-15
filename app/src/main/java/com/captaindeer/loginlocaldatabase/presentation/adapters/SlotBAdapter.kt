package com.captaindeer.loginlocaldatabase.presentation.adapters

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.captaindeer.loginlocaldatabase.R
import com.captaindeer.loginlocaldatabase.data.local.entities.SlotA
import com.captaindeer.loginlocaldatabase.data.local.entities.SlotB
import com.captaindeer.loginlocaldatabase.presentation.adapters.viewHolders.SlotBViewHolder
import kotlinx.android.synthetic.main.task_fragment.view.*

class SlotBAdapter(private var tasks: MutableList<SlotB>) :
    RecyclerView.Adapter<SlotBViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SlotBViewHolder {
        return SlotBViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.slot_b_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: SlotBViewHolder, position: Int) {
        val task = tasks[position]
        holder.itemView.apply {
            tv_task.text = task.task.toString()
            checkbox.isChecked = task.isChecked
            toggleStrikeTrough(tv_task, task.isChecked)
            checkbox.setOnCheckedChangeListener { _, isChecked ->
                toggleStrikeTrough(tv_task, isChecked)
                task.isChecked = !task.isChecked
            }
        }
    }

    override fun getItemCount(): Int = tasks.size

    fun updateData(tasks: MutableList<SlotB>) {
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