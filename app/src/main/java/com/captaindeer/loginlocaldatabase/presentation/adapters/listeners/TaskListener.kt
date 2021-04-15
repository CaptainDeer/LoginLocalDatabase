package com.captaindeer.loginlocaldatabase.presentation.adapters.listeners

import com.captaindeer.loginlocaldatabase.data.local.entities.SlotA
import com.captaindeer.loginlocaldatabase.data.local.entities.SlotB

interface TaskListener {

    fun changeCheckbox(task: SlotA)
}