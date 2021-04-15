package com.captaindeer.loginlocaldatabase.presentation.main

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.captaindeer.loginlocaldatabase.R
import com.captaindeer.loginlocaldatabase.presentation.addTask.AddTaskActivity
import com.captaindeer.loginlocaldatabase.presentation.addTaskSlotB.AddTaskSlotBActivity
import com.captaindeer.loginlocaldatabase.presentation.slotA.SlotAFragment
import com.captaindeer.loginlocaldatabase.presentation.slotB.SlotBFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var slotAFragment: SlotAFragment
    private lateinit var slotBFragment: SlotBFragment
    private var slot: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottom_navigation_view.background = null
        bottom_navigation_view.menu.getItem(2).isEnabled = false


        fab.setOnClickListener(this)

        slotAFragment = SlotAFragment()
        slotBFragment = SlotBFragment()


        bottom_navigation_view.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.item_slot_a -> {
                    slot = 1
                    supportFragmentManager.beginTransaction().apply {
                        replace(R.id.fl_main, slotAFragment)
                        addToBackStack(null)
                        commit()
                    }
                }

                R.id.item_slot_b -> {
                    slot = 2
                    supportFragmentManager.beginTransaction().apply {
                        replace(R.id.fl_main, slotBFragment)
                        addToBackStack(null)
                        commit()
                    }
                }
            }
            true
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.fab -> {
                when(slot){
                    1 -> {
                        var intent = Intent(this, AddTaskActivity::class.java)
                        startActivity(intent)
                        finish()
                    }
                    2 -> {
                        var intent = Intent(this, AddTaskSlotBActivity::class.java)
                        startActivity(intent)
                        finish()
                    }
                }


            }
        }
    }
}