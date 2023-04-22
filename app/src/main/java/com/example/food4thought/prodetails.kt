package com.example.food4thought

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class prodetails : AppCompatActivity() {

    var proname:String?=null
    var address:String?=null
    var area:String?=null
    var criteria:String?=null
    var contactno:String?=null
    var time:String?=null
    var hname:String?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_prodetails)

        val txtproname = findViewById<TextView>(R.id.txtproname)

        val txtaddress = findViewById<TextView>(R.id.txtaddress)

        val txtarea = findViewById<TextView>(R.id.txtarea)

        val txtcontact = findViewById<TextView>(R.id.txtcontct)


        val txtcrteri = findViewById<TextView>(R.id.txtcriteria)

        val txttime = findViewById<TextView>(R.id.txttime)


        val mSharedPreference = PreferenceManager.getDefaultSharedPreferences(baseContext)
        val value = mSharedPreference.getString("student-email", "DEFAULT")

        val bundle = intent.extras

        proname = bundle?.getString("proname")
        address = bundle?.getString("address")
        area=bundle?.getString("area")
        contactno=bundle?.getString("contact")
        criteria=bundle?.getString("criteria")
        time = bundle?.getString("chapati")
        hname = bundle?.getString("hrname")


        txtproname.setText("Hotel Name:" +proname)
        txtaddress.setText("Dal: "+address)
        txtarea.setText("Sabji: "+area)
        txtcontact.setText("Status"+contactno)
        txtcrteri.setText("Time:"+ criteria)

        txttime.setText("Chapati: "+ time)


        val btn = findViewById<Button>(R.id.btnpay)

        btn.setOnClickListener {

            val sharedpreferences = getSharedPreferences("My", MODE_PRIVATE)
            val email = sharedpreferences!!.getString("mail", "default")

            val msg = "I Want Food Please Help Us"

            val s = send(applicationContext,email.toString(),"Food",msg)
            s.execute()


            updatedata()
        }

    }

    private fun updatedata() {
        val mDatabaseRef = FirebaseDatabase.getInstance().getReference("UserFood").orderByChild("hotelname").equalTo(proname)
        mDatabaseRef.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
//                println(snapshot)
                for(obj in snapshot.children)
                {
//                   println(obj)
                    println(obj.key)

                    val key = obj.key

                    val databaseReference = FirebaseDatabase.getInstance().getReference("UserFood").child(key!!)
                    databaseReference.child("hotelname").setValue(proname)
                    databaseReference.child("status").setValue("Deactive")
                    Toast.makeText(applicationContext,"Updated",Toast.LENGTH_LONG).show()
//                    databaseReference.child("totalsolt").setValue(manifacute)
//                    databaseReference.child("freesolt").setValue(value.toString())
////                   databaseReference.child("Contactnumber").setValue(ucontact)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }
}