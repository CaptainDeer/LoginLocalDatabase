package com.captaindeer.loginlocaldatabase.presentation.addTaskSlotB

import android.content.Context
import com.captaindeer.loginlocaldatabase.data.local.AppDatabase
import com.captaindeer.loginlocaldatabase.data.local.entities.SlotB

class AddTaskSlotBPresenter(private val context: Context) : AddTaskSlotBInterface.Presenter {

    private val database = AppDatabase(context)

    override fun addTask(task: SlotB) {
        var task = task
        database.taskDao().insertB(task)
    }
}