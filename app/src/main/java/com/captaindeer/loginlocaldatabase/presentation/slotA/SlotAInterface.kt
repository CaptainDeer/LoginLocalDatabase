package com.captaindeer.loginlocaldatabase.presentation.slotA

import com.captaindeer.loginlocaldatabase.data.local.entities.SlotA

interface SlotAInterface {

    interface Presenter{
        fun getAllTask()
        fun checked(task: SlotA)
        fun getCheckedTask(): List<SlotA>
        fun delete(task: SlotA)
    }
    interface View{
        fun setUpdateData(tasks: ArrayList<SlotA>)
    }
}