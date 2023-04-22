package com.example.food4thought

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Hotelngonotify : AppCompatActivity() {

    var txtchapatii: TextView? = null
    var txtdal: TextView? = null
    var txtsabji: TextView? = null
    var txtaddres: TextView? = null
    var txttime: TextView?=null
    var txtname: TextView?=null
    var txtnumber: TextView?=null



    var chapati: String? = null
    var dal:String? = null
    var sabji:String? = null
    var address:String? = null
    var time:String?=null
    var name:String?=null
    var number:String?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hotelngonotify)

        txtchapatii = findViewById<TextView>(R.id.txtchapati)
        txtdal = findViewById<TextView>(R.id.txtdal)
        txtsabji = findViewById<TextView>(R.id.txtsabji)
        txtaddres = findViewById<TextView>(R.id.txtaddress)
        txttime = findViewById(R.id.txttime)
        txtname = findViewById(R.id.txtname)
        txtnumber = findViewById(R.id.txtnumber)



        chapati = intent.getStringExtra("chapati")
        dal = intent.getStringExtra("dal")
        sabji = intent.getStringExtra("sabji")

        address = intent.getStringExtra("address")
        time=intent.getStringExtra("time")
        name = intent.getStringExtra("name")
        number = intent.getStringExtra("number")


        txtchapatii!!.setText("Chapati: $chapati")
        txtdal!!.setText("Dal/Rice: $dal")
        txtsabji!!.setText("Sabji: $sabji")
        txtaddres!!.setText("Address:  + $address")
        txttime!!.setText("Time: "+time)
        txtname!!.setText("name"+name)
        txtnumber!!.setText("number"+number)

    }

}