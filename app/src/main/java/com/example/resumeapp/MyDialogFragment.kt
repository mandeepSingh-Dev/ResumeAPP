package com.example.resumeapp

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.resumeapp.databinding.FragmentMyDialogBinding

class MyDialogFragment : DialogFragment() {

    var binding:FragmentMyDialogBinding?=null

    var datelistner:MyDateListener?=null
    interface MyDateListener {
        fun onDateSelected(year:Int,month:Int,day:Int)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = FragmentMyDialogBinding.inflate(inflater)
        dialog!!.setTitle("Date")

        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.buttonAccept?.setOnClickListener {
            val year = binding?.datePicker?.year
            val month = binding?.datePicker?.month?.plus(1) // months start in 0

            val day = binding?.datePicker?.dayOfMonth
            //set arguments in interface method that is defined in AddActivity
            datelistner?.onDateSelected(year!!,month!!,day!!)

            dialog?.dismiss()
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        datelistner = context as MyDateListener
    }


}