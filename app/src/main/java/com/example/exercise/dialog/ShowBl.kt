package com.example.exercise.dialog

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.RecyclerView
import com.example.exercise.R

class ShowBl : DialogFragment() {

    // get item from xml file
    var reView : RecyclerView? = null

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(this.requireActivity())
        val myInfalter = this.requireActivity().layoutInflater
        val myView = myInfalter.inflate(R.layout.show_bl, null)

        reView = myView.findViewById(R.id.recyclerView)



        builder.setView(myView)

        return builder.show()
    }
}