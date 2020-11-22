package com.example.cleanappsample.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cleanappsample.R
import kotlinx.android.synthetic.main.fragment_list.view.*


class ListFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    lateinit var  viewModel:EmployeeViewModel



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_list, container, false)
        val adapter = RCAdapter()
        val rcview = view.rcview
        viewModel = ViewModelProvider(this).get(EmployeeViewModel::class.java)
        viewModel.allEmployee.observe(viewLifecycleOwner, Observer { user ->
            adapter.setValue(user)
        })

        rcview.adapter = adapter
        rcview.layoutManager=LinearLayoutManager(requireContext())


        view.addbutton.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_addFragment)
        }
        return view
    }


}