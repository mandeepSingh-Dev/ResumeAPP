package com.example.resumeapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.MenuItem
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import com.example.resumeapp.RoomClasses.*
import com.example.resumeapp.databinding.ActivityAddDetailsBinding


class AddDetailsActivity : AppCompatActivity() ,MyDialogFragment.MyDateListener {
    var binding:ActivityAddDetailsBinding?=null

    private var name:String?=null
    private var dob:String?=null
    private var gender:String?=null
    private var current_ctc:String?=null
    private var expected_ctc:String?=null
    private var skills:String?=null

    var dialogFragment:DialogFragment?=null
    var year:Int = 0
    var month:Int = 0
    var day:Int = 0

    var factory:MyViewmodelFactory?=null
    var myViewmodel:MyViewModel?=null
    val myRoom: MyRoom by lazy{
        MyRoom.getInstance(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddDetailsBinding.inflate(LayoutInflater.from(this))
        setContentView(binding?.root)

        //setting backbutton on Actionbar
        supportActionBar?.title = "Add"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        //Initializing instanceFactory with ViewModel
        factory = MyViewmodelFactory(ResumeRepositry(myRoom.getDao()))
        myViewmodel = ViewModelProvider(this,factory!!).get(MyViewModel::class.java)

        binding?.DOBeditext?.setOnClickListener {
            dialogFragment?.show(supportFragmentManager,dialogFragment?.tag)
        }

        binding?.AddButton?.setOnClickListener {
            binding?.let {
                name = it.nameTextLayout.editText?.text.toString()
                dob = it.DOBTextLayout.editText?.text.toString()
                gender = it.genderTextLayout.editText?.text.toString()
                current_ctc = it.currentCTCTextLayout.editText?.text.toString()
                expected_ctc = it.expectedCTCTextLayout.editText?.text.toString()
                skills = it.skillsTextLayout.editText?.text.toString()
            }
            //show error when any of the field is empty
                name?.let { if(it.isEmpty()) { binding?.nameTextLayout?.error = "This is Mandatory field" } else{ binding?.nameTextLayout?.isErrorEnabled = false }
                dob?.let { if(it.isEmpty()) { binding?.DOBTextLayout?.error = "This is Mandatory field" }else{ binding?.DOBTextLayout?.isErrorEnabled = false } }
                gender?.let { if(it.isEmpty()) { binding?.genderTextLayout?.error = "This is Mandatory field" } else{ binding?.genderTextLayout?.isErrorEnabled = false }}
                current_ctc?.let { if(it.isEmpty()) { binding?.currentCTCTextLayout?.error = "This is Mandatory field" }else{ binding?.currentCTCTextLayout?.isErrorEnabled = false } }
                expected_ctc?.let { if(it.isEmpty()) { binding?.expectedCTCTextLayout?.error = "This is Mandatory field" } else{ binding?.expectedCTCTextLayout?.isErrorEnabled = false }}
                skills?.let { if(it.isEmpty()) { binding?.skillsTextLayout?.error = "This is Mandatory field" }else{ binding?.skillsTextLayout?.isErrorEnabled = false } }
                }

            //save candidate data only if all the fields are filled
            if((!name?.isEmpty()!!) && (!dob?.isEmpty()!!) && (!gender?.isEmpty()!!)&& (!current_ctc?.isEmpty()!!)&& (!expected_ctc?.isEmpty()!!)&& (!skills?.isEmpty()!!))
            { //inserting data into Database
                   myViewmodel?.insert(Entities(name!!, dob!!, gender!!, current_ctc!!, expected_ctc!!, skills!!))
                startActivity(Intent(baseContext,ViewActivity::class.java))
            }

        }





    }//end of onCreate

    override fun onResume() {
        super.onResume()
        //set arrayentries to gender spinner
        val adapter = ArrayAdapter<String>(this,R.layout.spinner_item,resources.getStringArray(R.array.Gender))
        binding?.genderAutoCompleSpinner?.setAdapter(adapter)

        //set arrayentries to skills spinner
        val adapter2 = ArrayAdapter<String>(this,R.layout.spinner_item,resources.getStringArray(R.array.Skills))
        binding?.skillsAutoCompleSpinner?.setAdapter(adapter2)

        //initialize dialogFragment
         dialogFragment = MyDialogFragment()

    }

    //interface method in MyDialogFragment
    override fun onDateSelected(year: Int, month: Int, day: Int) {
    this.year = year
    this.month = month
    this.day = day
        binding?.DOBTextLayout?.editText?.setText("$year-$day-$month")
    }

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