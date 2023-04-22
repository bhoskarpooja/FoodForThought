package com.example.food4thought

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.content.SharedPreferences
import android.location.Geocoder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.app.NotificationCompat
import com.google.firebase.database.FirebaseDatabase
import java.util.*

class AddUserFood : AppCompatActivity() {

    var sharedpreferences: SharedPreferences? = null

    var chapati:String?=null
    var dal:String?=null
    var sabji:String?=null
    var conaddress:String?=null
    var time:String?=null
    var name:String?=null
    var number:String?=null
    var hotelname:String?=null

    var email:String?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_user_food)


        sharedpreferences = getSharedPreferences("My", MODE_PRIVATE)

        email = sharedpreferences!!.getString("email","default")

        Toast.makeText(applicationContext,email, Toast.LENGTH_LONG).show()


        val edchapati = findViewById<EditText>(R.id.edchapati)
        val eddal = findViewById<EditText>(R.id.eddal)
        val edbhaji = findViewById<EditText>(R.id.edsabji)
        val edaddress = findViewById<EditText>(R.id.edaddress)
        val edexpiry = findViewById<EditText>(R.id.edtime)
        val hname = findViewById<EditText>(R.id.edname)



        val btn = findViewById<Button>(R.id.btnsubmit)

        btn.setOnClickListener {

            chapati = edchapati.text.toString()
            dal = eddal.text.toString()
            sabji = edbhaji.text.toString()

            conaddress = edaddress.text.toString()
            time=edexpiry.text.toString()

            hotelname=hname.text.toString()

            val geocode = Geocoder(this, Locale.getDefault())

            val addlist = geocode.getFromLocationName(conaddress,1)
            val lat = addlist[0].latitude.toString()
            val lng = addlist[0].longitude.toString()


            val data = FirebaseDatabase.getInstance().reference.child("UserFood")
            val user = Userfood(hotelname,chapati,dal,sabji,lat,lng,time,"Active")
            data.push().setValue(user)
            sharedata(conaddress!!)
            Toast.makeText(applicationContext,"Uploaded", Toast.LENGTH_LONG).show()
            sendnotify()
        }


    }

    private fun sendnotify() {

        val msg = "hotel name $hotelname \n chapati $chapati \n dal $dal \n sabji $sabji \n time $time"


        val s = send(applicationContext,email.toString(),"Food",msg.toString())

        s.execute()
        

    }

    private fun sharedata(conaddress: String) {
        sharedpreferences = getSharedPreferences("My", MODE_PRIVATE)
        val editor = sharedpreferences!!.edit()

        editor.putString("address", conaddress)

        editor.commit()
        editor.apply()

    }
}