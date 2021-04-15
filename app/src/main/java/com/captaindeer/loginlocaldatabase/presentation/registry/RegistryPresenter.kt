package com.captaindeer.loginlocaldatabase.presentation.registry

import android.content.Context
import com.captaindeer.loginlocaldatabase.data.local.AppDatabase
import com.captaindeer.loginlocaldatabase.data.local.entities.User
import kotlinx.android.synthetic.main.activity_registry.*
import java.util.*

class RegistryPresenter(private val context: Context): RegistryInterface.Presenter {

    private val database = AppDatabase(context)

    override fun saveUser(user: User) {
        database.userDao().insertUser(user)
    }

}