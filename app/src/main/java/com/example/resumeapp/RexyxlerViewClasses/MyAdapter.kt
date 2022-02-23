package com.example.resumeapp.RexyxlerViewClasses

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.resumeapp.R
import com.example.resumeapp.RoomClasses.Entities

class MyAdapter(context:Context,list:List<Entities>):RecyclerView.Adapter<MyAdapter.MyViewHolder>(){

    val context = context
    val list = list

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view =  LayoutInflater.from(context).inflate(R.layout.details_list_item,parent,false)
    return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val entity = list.get(position)
        holder.nameTextView.text = entity.name

        holder.Gender_AgeTextview.setText(dateToAge(entity.dob).toString() + " | " + entity.gender)
    }

    override fun getItemCount(): Int {
        return  list.size
    }

    class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {

        var nameTextView: TextView = itemView.findViewById(R.id.nameTextview)
        var Gender_AgeTextview: TextView = itemView.findViewById(R.id.Gender_AgeTextview)
    }
    fun dateToAge(date:String):Int{
        Log.d("dinsd",date)
        val list = date.split("-")
        val year = list.get(0)
        val age = 2022 - year.toInt()
        Log.d("sjdbs",age.toString())
        return age
    }
}