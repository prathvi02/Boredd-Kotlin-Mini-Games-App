package com.example.boredd

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.firebase.auth.FirebaseAuth

class HomeActivity : AppCompatActivity() {

    lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val button2=findViewById<Button>(R.id.game1)
        button2.setOnClickListener {
            val intent = Intent(this, Game1Activity::class.java)
            // start your next activity
            startActivity(intent)
        }
        val paintbt=findViewById<Button>(R.id.paint)
        paintbt.setOnClickListener {
            val intent = Intent(this, PaintActivity::class.java)
            // start your next activity
            startActivity(intent)
        }
        val memorybt=findViewById<Button>(R.id.memorybt)
        memorybt.setOnClickListener {
            val intent = Intent(this, MemoryActivity::class.java)
            // start your next activity
            startActivity(intent)
        }


        auth= FirebaseAuth.getInstance()
        var currentUser=auth.currentUser

//        Reference
        val logout=findViewById<Button>(R.id.idLogout)

        if(currentUser==null){
            startActivity(Intent(this,LoginActivity::class.java))
            finish()
        }

        logout.setOnClickListener{
            auth.signOut()
            startActivity(Intent(this,LoginActivity::class.java))
            finish()
        }

    }
}