package com.captaindeer.loginlocaldatabase.data.local.entities

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "SlotB")
class SlotB(
    @ColumnInfo(name = "task") @NonNull val task: String,
    @ColumnInfo(name = "isChecked") var isChecked: Boolean = false
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}