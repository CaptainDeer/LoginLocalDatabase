package com.captaindeer.loginlocaldatabase.presentation.slotB

import android.content.Context
import com.captaindeer.loginlocaldatabase.data.local.AppDatabase

class SlotBPresenter(private val context: Context, private val view: SlotBInterface.View): SlotBInterface.Presenter {

    private val database = AppDatabase(context)

    override fun getAllTask() {
        var taskList = database.taskDao().onBoardTaskB() as ArrayList
        view.setUpdateData(taskList)
    }
}