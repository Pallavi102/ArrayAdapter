package com.rare.arrayadapter

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import com.rare.arrayadapter.databinding.ActivityMainBinding
import com.rare.arrayadapter.databinding.CustomDialogBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    var userList= ArrayList<String>()
    lateinit var arrayAdapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        val item= arrayOf("pallavi","neha","sakshi","sarb")
        arrayAdapter=ArrayAdapter(this,android.R.layout.simple_list_item_1,userList)
        binding.listView.adapter=arrayAdapter
        binding.fabBtn.setOnClickListener {
            val bindingDialog=CustomDialogBinding.inflate(layoutInflater)
            val dialog = Dialog(this)
            dialog.setContentView(bindingDialog.root)
            bindingDialog.btnSave.setOnClickListener {
                if(bindingDialog.etName.text.isEmpty())
                {
                    bindingDialog.etName.error="please enter your name"
                }
                else{
                    val name = bindingDialog.etName.text.toString()
                    userList.add(name)
                    dialog.dismiss()

                }
            }
            dialog.show()
        }
       binding.listView.setOnItemClickListener { adapterView, view,position, l ->
           val bindingDialog=CustomDialogBinding.inflate(layoutInflater)
           val dialog=Dialog(this)
           dialog.setContentView(bindingDialog.root)
           bindingDialog.etName.setText(userList[position].toString())
           bindingDialog.btnSave.setOnClickListener {
               if(bindingDialog.etName.text.isEmpty())
               {
                   bindingDialog.etName.error="please enter your name"
               }
               else{
                   val name = bindingDialog.etName.text.toString()
                   userList.set(position,name)
                   dialog.dismiss()

               }
           }
           dialog.show()

       }
    }
}


