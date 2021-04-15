package com.captaindeer.loginlocaldatabase.presentation.addTask

import android.content.Context
import com.captaindeer.loginlocaldatabase.data.local.AppDatabase
import com.captaindeer.loginlocaldatabase.data.local.entities.SlotA

class AddTaskPresenter(private val context: Context): AddTaskInterface.Presenter {

    private val database = AppDatabase(context)

    override fun addTask(task: SlotA) {
        var task = task
        database.taskDao().insert(task)
    }
}