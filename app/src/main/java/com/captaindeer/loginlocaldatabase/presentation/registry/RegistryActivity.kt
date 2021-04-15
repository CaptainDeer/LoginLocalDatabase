package com.captaindeer.loginlocaldatabase.presentation.registry

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.captaindeer.loginlocaldatabase.R
import com.captaindeer.loginlocaldatabase.data.local.entities.User
import com.captaindeer.loginlocaldatabase.presentation.login.LoginActivity
import kotlinx.android.synthetic.main.activity_registry.*
import java.util.*


class RegistryActivity : AppCompatActivity(), RegistryInterface.View, View.OnClickListener {

    private lateinit var presenter: RegistryPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registry)

        presenter = RegistryPresenter(this)

        registry_btnRegistry.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.registry_btnRegistry -> {
                if (registry_etName.text!!.isEmpty() || registry_etEmail.text!!.isEmpty() || registry_etPassword.text!!.isEmpty()) {
                    Toast.makeText(this,"Please fill all the fields",Toast.LENGTH_SHORT).show()
                }else{
                    presenter.saveUser(getUser())
                    registry_etName.text!!.clear()
                    registry_etEmail.text!!.clear()
                    registry_etPassword.text!!.clear()
                    finish()
                    var intent = Intent(this,LoginActivity::class.java)
                    startActivity(intent)
                    Toast.makeText(this,"Login with your new account",Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun getUser(): User {
        val name = registry_etName.text.toString()
        val email = registry_etEmail.text.toString()
        val password = registry_etPassword.text.toString()
        return User(UUID.randomUUID().toString(),name,email,password)
    }
}