package com.captaindeer.loginlocaldatabase.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.captaindeer.loginlocaldatabase.data.local.dao.TaskDao
import com.captaindeer.loginlocaldatabase.data.local.dao.UserDao
import com.captaindeer.loginlocaldatabase.data.local.entities.SlotA
import com.captaindeer.loginlocaldatabase.data.local.entities.SlotB
import com.captaindeer.loginlocaldatabase.data.local.entities.User

@Database(entities = [User::class, SlotA::class, SlotB::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao
    abstract fun taskDao(): TaskDao

    companion object {
        @Volatile
        private var instance: AppDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buildDatabase(context).also { instance = it }
        }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(context, AppDatabase::class.java, "TaskAssistantLogin.db")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build()
    }
}