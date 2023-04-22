package com.example.food4thought

import android.content.ActivityNotFoundException
import android.content.Intent
import android.content.SharedPreferences
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import kotlin.math.log

class hoteldash : AppCompatActivity() {


    var sharedpreferences: SharedPreferences? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hoteldash)



    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId)
        {
            R.id.add->{
                sharedpreferences = getSharedPreferences("My", MODE_PRIVATE)
                val add = sharedpreferences!!.getString("add", "")
                Toast.makeText(applicationContext,"NGO Address "+add.toString(),Toast.LENGTH_LONG).show()
//            val add = "katraj"

//                sharedpreferences = getSharedPreferences("My", MODE_PRIVATE)
//                val useradd = sharedpreferences!!.getString("address", "")
//            val useradd="akrudi"

                try {
                    val uri = Uri.parse("https://www.google.co.in/maps/dir/"+"/"+ add)

                    val intent = Intent(Intent.ACTION_VIEW,uri)
                    intent.setPackage("com.google.android.apps.maps")
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                    startActivity(intent)

                }catch (e: ActivityNotFoundException)
                {
                    val uri = Uri.parse("https://play.google.com/store/apps/details?id=com.google.android.apps.maps")
                    val intent = Intent(Intent.ACTION_VIEW,uri)
                    intent.setPackage("com.google.android.apps.maps")
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                    startActivity(intent)
                }

            }

            R.id.phistory->{
                val intent = Intent(applicationContext,AddUserFood::class.java)
            startActivity(intent)
            }

            R.id.logout->{
                val intent = Intent(applicationContext, MainActivity::class.java)
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}