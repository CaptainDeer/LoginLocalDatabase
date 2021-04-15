package com.captaindeer.loginlocaldatabase.presentation.addTask

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.captaindeer.loginlocaldatabase.R
import com.captaindeer.loginlocaldatabase.data.local.entities.SlotA
import com.captaindeer.loginlocaldatabase.presentation.main.MainActivity
import kotlinx.android.synthetic.main.activity_add_task.*

class AddTaskActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var presenter: AddTaskPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_task)

        presenter = AddTaskPresenter(this)

        btn_cancel.setOnClickListener(this)
        btn_check.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btn_cancel -> {

            }
            R.id.btn_check -> {
                val task = et_new_task.text.toString()
                presenter.addTask(SlotA(task,false))
                var intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }
}