package com.captaindeer.loginlocaldatabase.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.captaindeer.loginlocaldatabase.data.local.entities.User

@Dao
interface UserDao {

    @Insert
    fun insertUser(user: User)

    @Query(value = "select name from users")
    fun usersList(): List<String>

    @Query("SELECT * FROM users WHERE email LIKE :email and password LIKE :password")
    fun compareUser(email: String, password: String): User

}