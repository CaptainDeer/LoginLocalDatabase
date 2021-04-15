package com.captaindeer.loginlocaldatabase.presentation.login

interface LoginInterface {
    interface Presenter {
        fun verifyLogin(): Boolean
    }

    interface View {

    }
}