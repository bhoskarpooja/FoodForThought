package com.example.food4thought

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*
import java.util.ArrayList

class checklist : AppCompatActivity() {

    private var database: FirebaseDatabase? = null
    private var ref: DatabaseReference? = null

    private var adapter:VAdapter?=null
    private var list: ArrayList<Userfood>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checklist)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        recyclerView.setHasFixedSize(true)
        recyclerView.setLayoutManager(LinearLayoutManager(this))

        list = ArrayList()


        val mSharedPreference = PreferenceManager.getDefaultSharedPreferences(baseContext)
        val value = mSharedPreference.getString("vacancy", "DEFAULT")

        Toast.makeText(applicationContext,value.toString(), Toast.LENGTH_LONG).show()
        database = FirebaseDatabase.getInstance()
        ref = database!!.getReference("UserFood")

        val mDatabaseRef = FirebaseDatabase.getInstance().getReference("UserFood")

        val query: Query = mDatabaseRef.orderByChild("status").equalTo("Active")

        query.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                for (data in dataSnapshot.children) {
                    println(data)

                    val models: Userfood? = data.getValue(Userfood::class.java)
                    println(models)
                    if (models != null) {
                        list!!.add(models)
                    }



                }

                adapter = VAdapter(list,applicationContext)
                recyclerView.adapter = adapter

            }

            override fun onCancelled(databaseError: DatabaseError) {}
        })
    }
}