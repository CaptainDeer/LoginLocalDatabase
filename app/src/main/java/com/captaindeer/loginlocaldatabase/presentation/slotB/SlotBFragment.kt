package com.captaindeer.loginlocaldatabase.presentation.slotB

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.captaindeer.loginlocaldatabase.R
import com.captaindeer.loginlocaldatabase.data.local.entities.SlotB
import com.captaindeer.loginlocaldatabase.presentation.adapters.SlotBAdapter
import com.captaindeer.loginlocaldatabase.presentation.addTaskSlotB.AddTaskSlotBActivity
import kotlinx.android.synthetic.main.fragment_slot_a.*

class SlotBFragment : Fragment(), SlotBInterface.View, View.OnClickListener {

    private lateinit var slotBAdapter: SlotBAdapter
    lateinit var presenter: SlotBPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        slotBAdapter = SlotBAdapter(mutableListOf())
        presenter = SlotBPresenter(requireContext(), this)
        presenter.getAllTask()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_slot_b, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fab_del.setOnClickListener(this)

        rv_category.apply {
            layoutManager = LinearLayoutManager(activity)
            rv_category.setHasFixedSize(true)
            rv_category.layoutManager = LinearLayoutManager(requireContext())
            rv_category.adapter = slotBAdapter

        }
    }

    override fun setUpdateData(tasks: ArrayList<SlotB>) {
        slotBAdapter.updateData(tasks)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.fab_del -> {

            }
        }
    }

}