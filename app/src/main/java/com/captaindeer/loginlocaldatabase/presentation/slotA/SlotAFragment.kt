package com.captaindeer.loginlocaldatabase.presentation.slotA

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.captaindeer.loginlocaldatabase.R
import com.captaindeer.loginlocaldatabase.data.local.entities.SlotA
import com.captaindeer.loginlocaldatabase.presentation.adapters.TaskAdapter
import com.captaindeer.loginlocaldatabase.presentation.adapters.listeners.TaskListener
import kotlinx.android.synthetic.main.fragment_slot_a.*

class SlotAFragment : Fragment(), SlotAInterface.View, View.OnClickListener, TaskListener{

    lateinit var taskAdapter: TaskAdapter
    lateinit var presenter: SlotAPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        taskAdapter = TaskAdapter(mutableListOf(),this)
        presenter = SlotAPresenter(requireContext(), this)
        presenter.getAllTask()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_slot_a, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fab_del.setOnClickListener(this)

        rv_category.apply {
            layoutManager = LinearLayoutManager(activity)
            rv_category.setHasFixedSize(true)
            rv_category.layoutManager = LinearLayoutManager(requireContext())
            rv_category.adapter = taskAdapter

        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.fab_del -> {
                var tasksChecked = presenter.getCheckedTask()
                for (element in tasksChecked){
                    presenter.delete(element)
                    presenter.getAllTask()
                }

            }
        }
    }

    override fun setUpdateData(tasks: ArrayList<SlotA>) {
        taskAdapter.updateData(tasks)
    }

    override fun changeCheckbox(task: SlotA) {
        presenter.checked(task)
    }

}