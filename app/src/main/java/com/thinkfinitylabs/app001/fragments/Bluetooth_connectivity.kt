package com.thinkfinitylabs.app001.fragments

import android.app.Activity
import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice
import android.content.Context
import android.content.Intent
import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.thinkfinitylabs.app001.FragmentChangeListener
import com.thinkfinitylabs.app001.R
import com.thinkfinitylabs.app001.ScanActivity

import java.io.IOException


@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class Bluetooth_connectivity : Fragment() {


    lateinit var scanToConnectBtn:Button
    val REQUEST_CONN_CODE = 200
    var bluetoothMACaddress:String = ""
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? { // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_bluetooth_connectivity, container, false)
        scanToConnectBtn = view.findViewById(R.id.scan_connect_button)
        scanToConnectBtn.setOnClickListener {
            val requestIntent = Intent(activity,ScanActivity::class.java)
            startActivityForResult(requestIntent,REQUEST_CONN_CODE)
        }

        return view
    }



    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if(requestCode==REQUEST_CONN_CODE&&resultCode==Activity.RESULT_OK){
            if (data != null) {
                bluetoothMACaddress = data.getStringExtra("bluetoothMAC_ADDRESS")
            }
        }
    }








}