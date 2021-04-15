package com.captaindeer.loginlocaldatabase.presentation.slotA

import android.content.Context
import com.captaindeer.loginlocaldatabase.data.local.AppDatabase
import com.captaindeer.loginlocaldatabase.data.local.entities.SlotA

class SlotAPresenter(private val context: Context, private val view: SlotAInterface.View) : SlotAInterface.Presenter {

    private val database = AppDatabase(context)

    override fun getAllTask() {
        var taskList = database.taskDao().onBoardTask() as ArrayList
        view.setUpdateData(taskList)
    }


    override fun checked(task: SlotA) {
        database.taskDao().update(task)
    }

    override fun getCheckedTask(): List<SlotA> {
        return database.taskDao().taskChecked() as ArrayList
    }

    override fun delete(task: SlotA) {
        database.taskDao().delete(task)
    }


}