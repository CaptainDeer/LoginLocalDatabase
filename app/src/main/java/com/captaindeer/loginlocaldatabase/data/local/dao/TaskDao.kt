package com.captaindeer.loginlocaldatabase.data.local.dao

import androidx.room.*
import com.captaindeer.loginlocaldatabase.data.local.entities.SlotA
import com.captaindeer.loginlocaldatabase.data.local.entities.SlotB

@Dao
interface TaskDao {

    //Slot A
    @Insert
    fun insert(task: SlotA)
    @Delete
    fun delete(task: SlotA)
    @Update
    fun update(task: SlotA)
    @Query(value = "select * from SlotA")
    fun onBoardTask(): List<SlotA>
    @Query(value = "select * from SlotA where isChecked = 1")
    fun taskChecked():List<SlotA>

    //Slot B
    @Insert
    fun insertB(task: SlotB)
    @Query(value = "select * from SlotB")
    fun onBoardTaskB(): List<SlotB>

}