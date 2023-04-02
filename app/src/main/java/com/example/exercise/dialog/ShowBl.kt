package com.example.exercise.dialog

import android.Manifest
import android.annotation.SuppressLint
import android.app.AlertDialog
import android.app.Dialog
import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.RecyclerView
import com.example.exercise.R
import com.example.exercise.model.Bluetooth
import com.example.exercise.readapter.BlAdapter

class ShowBl : DialogFragment() {

    // get item from xml file
    var reView : RecyclerView? = null
    var infoTextView : TextView? = null
    private var adapter: BlAdapter? = null
    private val noteList = ArrayList<Bluetooth>()
    private val listBl = ArrayList<BluetoothDevice>()

    // for bluetooth
    lateinit var blAdapter : BluetoothAdapter
    private val REQUEST_CODE_ENABLE_BT: Int = 1
    private val REQUEST_CODE_DISCOVERABLE_BT: Int = 1

    @SuppressLint("SetTextI18n")
    override fun onCreateDialog(savedInstanceState: Bundle?): AlertDialog? {
        val builder = AlertDialog.Builder(this.requireActivity())
        val myInfalter = this.requireActivity().layoutInflater
        val myView = myInfalter.inflate(R.layout.show_bl, null)

        reView = myView.findViewById(R.id.recyclerView)
        infoTextView = myView.findViewById(R.id.blStatus)

        blAdapter = BluetoothAdapter.getDefaultAdapter()
        if(blAdapter == null){
            Toast.makeText(this.requireActivity(), "Bluetooth Adapter Is Not Available", Toast.LENGTH_LONG).show()
        }else{
            Toast.makeText(this.requireActivity(), "Bluetooth Adapter Is Available", Toast.LENGTH_LONG).show()
        }

        if(blAdapter.isEnabled){
            infoTextView?.text = "Already Conected"
        }else{
            infoTextView?.text = "Not Yet Conected"
        }
        if (ActivityCompat.checkSelfPermission(
                this.requireActivity(),
                Manifest.permission.BLUETOOTH_SCAN
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return null
        }
        if(blAdapter.getScanMode()!=BluetoothAdapter.SCAN_MODE_CONNECTABLE_DISCOVERABLE){
            System.out.println(BluetoothAdapter.SCAN_MODE_CONNECTABLE_DISCOVERABLE);
        }

        if (ContextCompat.checkSelfPermission(this.requireActivity(),
                Manifest.permission.ACCESS_FINE_LOCATION)
            != PackageManager.PERMISSION_GRANTED) {

            Log.i("info", "No fine location permissions")

            ActivityCompat.requestPermissions(this.requireActivity(),
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                1)
        }



        builder.setView(myView)

        return builder.show()
    }
}