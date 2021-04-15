package com.captaindeer.loginlocaldatabase.presentation.addTask

import com.captaindeer.loginlocaldatabase.data.local.entities.SlotA

interface AddTaskInterface {

    interface Presenter{
        fun addTask(task: SlotA)

    }
    interface View{

    }
}