package com.captaindeer.loginlocaldatabase.presentation.registry

import com.captaindeer.loginlocaldatabase.data.local.entities.User

interface RegistryInterface {

    interface Presenter{
        fun saveUser(user: User)
    }
    interface View{
        fun getUser():User
    }
}