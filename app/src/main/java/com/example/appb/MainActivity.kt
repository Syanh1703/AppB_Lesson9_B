package com.example.appb

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import androidx.appcompat.app.ActionBar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    companion object
    {
        const val TESTING = "Testing"
        const val NAME = "Name"
        const val ADDRESS = "Addr"
        const val PHONE = "Phone"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val actionBar = supportActionBar
        actionBar!!.setDisplayShowHomeEnabled(true)
        actionBar.setDisplayHomeAsUpEnabled(true)
        actionBar.displayOptions = ActionBar.DISPLAY_SHOW_CUSTOM
        actionBar.setCustomView(R.layout.center_app_name)

        val intentFilter = IntentFilter()
        intentFilter.addAction(TESTING)
        registerReceiver(broadcastReceiver,intentFilter)
    }

    private val broadcastReceiver :BroadcastReceiver = object :BroadcastReceiver()
    {
        override fun onReceive(context: Context?, intent: Intent?) {
            val name :String = intent?.getStringExtra(NAME).toString()
            val addr :String = intent?.getStringExtra(ADDRESS).toString()
            val phone :String = intent?.getStringExtra(PHONE).toString()
            Log.d("SyAnh", "The name is $name \n" +
                    "The address is $addr \n" +
                    "The phone is $phone \n")
            tvName.setText(name)
            tvAddr.setText(addr)
            tvPhone.setText(phone)
        }

    }
}