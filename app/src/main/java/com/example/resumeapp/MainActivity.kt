package com.example.resumeapp

import android.R
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.resumeapp.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity(){

    var binding:ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding?.root)

        supportActionBar?.title = "Homepage"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding?.addTextView?.setOnClickListener {
            startActivity(Intent(this,AddDetailsActivity::class.java))
        }
        binding?.viewTextView?.setOnClickListener {
            startActivity(Intent(this,ViewActivity::class.java))
        }
    }//end of onCreate

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.getItemId()) {
            R.id.home -> {
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }



}