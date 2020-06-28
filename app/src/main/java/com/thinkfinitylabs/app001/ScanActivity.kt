package com.thinkfinitylabs.app001

import android.app.Activity
import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice
import android.bluetooth.BluetoothSocket
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.VibrationEffect
import android.os.Vibrator
import android.util.Log
import android.widget.Button
import android.widget.ProgressBar
import android.widget.Toast
import com.budiyev.android.codescanner.AutoFocusMode
import com.budiyev.android.codescanner.CodeScanner
import com.budiyev.android.codescanner.DecodeCallback
import com.budiyev.android.codescanner.ErrorCallback
import com.budiyev.android.codescanner.ScanMode
import com.google.zxing.BarcodeFormat
import kotlinx.android.synthetic.main.activity_scan.*
import java.util.*

class ScanActivity : AppCompatActivity() {
    private lateinit var codeScanner:CodeScanner


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scan)
        supportActionBar?.hide()

        // Init the CodeScanner
        codeScanner = CodeScanner(this,scanner_view)
        // Parameters (default values)
        codeScanner.camera = CodeScanner.CAMERA_BACK  // You can change it to CAMERA_FRONT, but nobady scans qr code from front camera! hehe. therefore i used camera back!. give any camera id you wish to choose for

        // You can scan all the codes, not limited to qr code, refer : https://github.com/yuriy-budiyev/code-scanner to know how to use it
        // codeScanner.formats = CodeScanner.ALL_FORMATS // will be useful when you are targetting to scan all types of code formats! lol, but yeah
        codeScanner.formats = listOf(BarcodeFormat.QR_CODE)

        codeScanner.autoFocusMode = AutoFocusMode.SAFE // or CONTINUOUS
        codeScanner.scanMode = ScanMode.SINGLE // or CONTINUOUS OR PREVIEW
        codeScanner.isAutoFocusEnabled = true // Whether to enable auto focus
        codeScanner.isFlashEnabled = false // whether to enable flash or not

        //Callbacks
        codeScanner.decodeCallback = DecodeCallback {

            runOnUiThread{
                val vibrator = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
                if(Build.VERSION.SDK_INT >= 26){
                    vibrator.vibrate(VibrationEffect.createOneShot(60,VibrationEffect.DEFAULT_AMPLITUDE))
                }else{
                    vibrator.vibrate(60)
                }

                val returnIntent = Intent().putExtra("bluetoothMAC_ADDRESS",it.text)
                setResult(Activity.RESULT_OK,returnIntent)
                finish()
            }
        }
        codeScanner.errorCallback = ErrorCallback {
            runOnUiThread{
                Log.e("CodeScanner","message : ${it.message}")
            }
        }
        scanner_view.setOnClickListener{
            codeScanner.startPreview()
        }

        cancel_intent_button.setOnClickListener {
            codeScanner.releaseResources()
            finish()
        }


    }



    override fun onResume() {
        super.onResume()
        codeScanner.startPreview()
    }

    override fun onPause() {
        codeScanner.releaseResources()
        super.onPause()
    }

    override fun onBackPressed() {
        codeScanner.releaseResources()
        super.onBackPressed()
    }


}