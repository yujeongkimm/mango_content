package org.techtown.mango_content

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private val items = mutableListOf<ContentsModel>()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bookmarkBtn = findViewById<TextView>(R.id.bookmarkBtn)
        bookmarkBtn.setOnClickListener {
            val intent= Intent(this, BookmarkActivity::class.java)
            startActivity(intent)
        }


        items.add(
            ContentsModel(
                "https://www.mangoplate.com/restaurants/LIakXRkYhiQ2",
                "https://mp-seoul-image-production-s3.mangoplate.com/333500/465017_1596542599031_34420?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "King수제만두"
            )
        )

        items.add(
            ContentsModel(
                "https://www.mangoplate.com/restaurants/mrRRAMenpscd",
                "https://mp-seoul-image-production-s3.mangoplate.com/365877/1601611_1580881025165_20835?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "초원샤브샤브뷔페"
            )
        )

        items.add(
            ContentsModel(
                "https://www.mangoplate.com/restaurants/RZtDXQuloF38",
                "https://mp-seoul-image-production-s3.mangoplate.com/382404/172778_1599266560896_70079?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "후라토식당"
            )
        )

        items.add(
            ContentsModel(
                "https://www.mangoplate.com/restaurants/FULimTkj6Xis",
                "https://mp-seoul-image-production-s3.mangoplate.com/383001/1829944_1608745967201_10564?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "피그인더가든"
            )
        )

        items.add(
            ContentsModel(
                "https://www.mangoplate.com/restaurants/LIakXRkYhiQ2",
                "https://mp-seoul-image-production-s3.mangoplate.com/333500/465017_1596542599031_34420?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "King수제만두"
            )
        )

        items.add(
            ContentsModel(
                "https://www.mangoplate.com/restaurants/mrRRAMenpscd",
                "https://mp-seoul-image-production-s3.mangoplate.com/365877/1601611_1580881025165_20835?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "초원샤브샤브뷔페"
            )
        )

        items.add(
            ContentsModel(
                "https://www.mangoplate.com/restaurants/RZtDXQuloF38",
                "https://mp-seoul-image-production-s3.mangoplate.com/382404/172778_1599266560896_70079?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "후라토식당"
            )
        )

        items.add(
            ContentsModel(
                "https://www.mangoplate.com/restaurants/FULimTkj6Xis",
                "https://mp-seoul-image-production-s3.mangoplate.com/383001/1829944_1608745967201_10564?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "피그인더가든"
            )
        )

        items.add(
            ContentsModel(
                "https://www.mangoplate.com/restaurants/LIakXRkYhiQ2",
                "https://mp-seoul-image-production-s3.mangoplate.com/333500/465017_1596542599031_34420?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "King수제만두"
            )
        )

        items.add(
            ContentsModel(
                "https://www.mangoplate.com/restaurants/mrRRAMenpscd",
                "https://mp-seoul-image-production-s3.mangoplate.com/365877/1601611_1580881025165_20835?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "초원샤브샤브뷔페"
            )
        )

        items.add(
            ContentsModel(
                "https://www.mangoplate.com/restaurants/RZtDXQuloF38",
                "https://mp-seoul-image-production-s3.mangoplate.com/382404/172778_1599266560896_70079?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "후라토식당"
            )
        )

        items.add(
            ContentsModel(
                "https://www.mangoplate.com/restaurants/FULimTkj6Xis",
                "https://mp-seoul-image-production-s3.mangoplate.com/383001/1829944_1608745967201_10564?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "피그인더가든"
            )
        )

        //adapter연결
        val recyclerView = findViewById<RecyclerView>(R.id.rv)
        val rvAdapter = RVAdapter(baseContext, items)
        recyclerView.adapter = rvAdapter
        recyclerView.layoutManager = GridLayoutManager(this, 2)

        rvAdapter.itemClick = object : RVAdapter.ItemClick {
            override fun onClick(view: View, position: Int) {

                val intent = Intent(baseContext, ViewActivity::class.java)
                intent.putExtra("url", items[position].url)
                intent.putExtra("title", items[position].titleText)
                intent.putExtra("imageUrl", items[position].ImageUrl)

                startActivity(intent)
            }
        }
    }
}