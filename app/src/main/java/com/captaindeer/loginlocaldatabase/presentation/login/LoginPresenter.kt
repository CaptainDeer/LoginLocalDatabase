package com.captaindeer.loginlocaldatabase.presentation.login

import android.content.Context
import com.captaindeer.loginlocaldatabase.data.local.AppDatabase
import kotlinx.android.synthetic.main.activity_login.*

class LoginPresenter(private val context: Context, private val view: LoginActivity) :
    LoginInterface.Presenter {

    private val database = AppDatabase(context)
    override fun verifyLogin(): Boolean {

        var user = database.userDao().compareUser(view.etEmail.text.toString(), view.etPassword.text.toString())
        return user != null

    }

}