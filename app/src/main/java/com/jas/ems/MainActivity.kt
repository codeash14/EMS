package com.jas.ems

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.jas.ems.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var user: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        user=FirebaseAuth.getInstance()

        setSupportActionBar(findViewById(R.id.toolbar))



    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.signOut->{
                user.signOut()
                startActivity(
                    Intent(this, SplashActivity::class.java)
                )
                Toast.makeText(this, "Sign Out Successful!", Toast.LENGTH_SHORT).show()
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }


    }
}