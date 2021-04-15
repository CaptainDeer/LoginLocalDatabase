package com.captaindeer.loginlocaldatabase.presentation.adapters.viewHolders

import android.view.View
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.captaindeer.loginlocaldatabase.R

class SlotBViewHolder(view: View): RecyclerView.ViewHolder(view) {

    val tvTask = view.findViewById(R.id.tv_task) as TextView
    val checkBox = view.findViewById(R.id.checkbox) as CheckBox

}