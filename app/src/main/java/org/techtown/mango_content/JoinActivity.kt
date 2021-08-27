package org.techtown.mango_content

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class JoinActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_join)

        val button = findViewById<Button>(R.id.button)

        auth = Firebase.auth

        button.setOnClickListener {

            val email = findViewById<EditText>(R.id.email)
            val password = findViewById<EditText>(R.id.password)


            auth.createUserWithEmailAndPassword(email.text.toString(), password.text.toString())
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        Log.d("JOINActivity","createUserWithEmail:success")
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                    } else {
                        Log.w("JOINActivity","createUserWithEmail:failure", task.exception)
                        Toast.makeText(baseContext, "회원가입 실패!", Toast.LENGTH_SHORT).show()
                    }
                }
        }


    }
}