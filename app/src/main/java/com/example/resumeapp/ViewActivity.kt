package com.example.resumeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.resumeapp.RexyxlerViewClasses.MyAdapter
import com.example.resumeapp.RoomClasses.MyRoom
import com.example.resumeapp.RoomClasses.MyViewModel
import com.example.resumeapp.RoomClasses.MyViewmodelFactory
import com.example.resumeapp.RoomClasses.ResumeRepositry
import com.example.resumeapp.databinding.ActivityViewBinding

class ViewActivity : AppCompatActivity() {

    var binding:ActivityViewBinding?=null

    var factory:MyViewmodelFactory?=null
    var myViewmodel:MyViewModel?=null
    val myRoom: MyRoom by lazy{
        MyRoom.getInstance(this)
    }

    var myAdapter:MyAdapter?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewBinding.inflate(LayoutInflater.from(this))
        setContentView(binding?.root)

        //setting backbutton on Actionbar
        supportActionBar?.title = "Add"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        //Initializing instanceFactory with ViewModel
        factory = MyViewmodelFactory(ResumeRepositry(myRoom.getDao()))
        myViewmodel = ViewModelProvider(this,factory!!).get(MyViewModel::class.java)

        myViewmodel?.resumesList?.observe(this, Observer {

            myAdapter = MyAdapter(this,it)
            binding?.recyclerView?.layoutManager = LinearLayoutManager(this)
            binding?.recyclerView?.adapter = myAdapter
        })
    }//end of oncreate


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.getItemId()) {
            android.R.id.home -> {
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

}