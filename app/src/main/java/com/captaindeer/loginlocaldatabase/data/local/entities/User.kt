package com.captaindeer.loginlocaldatabase.data.local.entities

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Users")
class User (
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id")@NonNull val id: String,
    @ColumnInfo(name = "name") @NonNull val name: String,
    @ColumnInfo(name = "email") @NonNull val email: String,
    @ColumnInfo(name = "password") @NonNull val password: String
        )