package com.captaindeer.loginlocaldatabase.presentation.slotB

import com.captaindeer.loginlocaldatabase.data.local.entities.SlotB

interface SlotBInterface {
    interface Presenter {
        fun getAllTask()
    }

    interface View {
        fun setUpdateData(tasks: ArrayList<SlotB>)

    }
}