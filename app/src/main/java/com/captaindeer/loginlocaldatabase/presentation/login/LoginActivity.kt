package com.captaindeer.loginlocaldatabase.presentation.login

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.captaindeer.loginlocaldatabase.R
import com.captaindeer.loginlocaldatabase.presentation.main.MainActivity
import com.captaindeer.loginlocaldatabase.presentation.registry.RegistryActivity
import com.captaindeer.loginlocaldatabase.presentation.registry.RegistryPresenter
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), LoginInterface.View, View.OnClickListener {

    lateinit var presenter: LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        presenter = LoginPresenter(this,this)

        btnLogin.setOnClickListener(this)
        tvRegistry.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btnLogin -> {
                if (presenter.verifyLogin()){
                    finish()
                    var intent = Intent(this,MainActivity::class.java)
                    startActivity(intent)
                }else
                    Toast.makeText(this,"User not found",Toast.LENGTH_SHORT).show()
            }
            R.id.tvRegistry -> {
                finish()
                var intent = Intent(this,RegistryActivity::class.java)
                startActivity(intent)
            }
        }
    }
}