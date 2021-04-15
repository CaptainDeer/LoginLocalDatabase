package com.captaindeer.loginlocaldatabase.presentation.adapters.viewHolders

import android.view.View
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.captaindeer.loginlocaldatabase.R
import com.captaindeer.loginlocaldatabase.presentation.slotA.SlotAInterface
import kotlinx.android.synthetic.main.task_fragment.view.*

class TaskViewHolder(view: View): RecyclerView.ViewHolder(view) {

    val tvTask = view.findViewById(R.id.tv_task) as TextView
    var checkBox = view.findViewById(R.id.checkbox) as CheckBox

}