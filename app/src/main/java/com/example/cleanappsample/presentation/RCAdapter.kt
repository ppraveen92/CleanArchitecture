package com.example.cleanappsample.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cleanappsample.Employee
import com.example.cleanappsample.R
import kotlinx.android.synthetic.main.row.view.*

class RCAdapter : RecyclerView.Adapter<RCAdapter.MyViewHolder>() {


    var list = emptyList<Employee>()
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val view=LayoutInflater.from(parent.context).inflate(R.layout.row,parent,false)
        return MyViewHolder(view)

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val item = list.get(position)
        holder.itemView.txt_Id.text = item.id.toString()
        holder.itemView.txt_name.text = item.name
        holder.itemView.txt_design.text = item.designation
        holder.itemView.txt_sal.text = item.salary.toString()
    }

    fun setValue(items : List<Employee>){
        list=items
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
       return list.size
    }
}