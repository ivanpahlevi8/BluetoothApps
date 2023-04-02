package com.example.exercise.readapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.exercise.MainActivity
import com.example.exercise.R
import com.example.exercise.model.Bluetooth

class BlAdapter(private val mainActivity: MainActivity,
                private val blList : List<Bluetooth>) : RecyclerView.Adapter<BlAdapter.ListItemHolder>() {

    inner class ListItemHolder(view: View): RecyclerView.ViewHolder(view), View.OnClickListener{
        var blNameText : TextView? = null
        var blCodeText : TextView? = null

        init {
            view.isClickable = true
            view.setOnClickListener(this)

            // get bluetooth\
            blNameText = view.findViewById(R.id.textView)
            blCodeText = view.findViewById(R.id.textView2)
        }
        override fun onClick(p0: View?) {
            // if item clicked
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListItemHolder {
        val itemHolder = LayoutInflater.from(parent.context).inflate(R.layout.list_bl, parent, false)
        return ListItemHolder(itemHolder)
    }

    override fun onBindViewHolder(holder: ListItemHolder, position: Int) {
        var myBluetooth : Bluetooth = blList[position]

        holder.blCodeText?.text = myBluetooth.bluetoothCode.toString()
        holder.blNameText?.text = myBluetooth.bluetoothName.toString()
    }

    override fun getItemCount(): Int {
        return blList.size
    }
}