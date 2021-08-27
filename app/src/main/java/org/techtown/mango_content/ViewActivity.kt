package org.techtown.mango_content

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import org.w3c.dom.Text

class ViewActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view)

        auth = Firebase.auth

        val webview = findViewById<WebView>(R.id.webview)
        webview.loadUrl(intent.getStringExtra("url").toString())

        //url을 데베에 저장하기
        val database = Firebase.database
        val myRef = database.getReference("bookrmark_ref")

        val url = intent.getStringExtra("url").toString()
        val title = intent.getStringExtra("title").toString()
        val imageUrl = intent.getStringExtra("imageUrl").toString()

        val saveText = findViewById<TextView>(R.id.savetext)
        saveText.setOnClickListener{
            myRef.child(auth.currentUser!!.uid).push()
                .setValue(ContentsModel(url,imageUrl,title))
        }


    }
}