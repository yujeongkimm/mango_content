package org.techtown.mango_content

import android.content.Context
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class RVAdapter(val context : Context, val List : MutableList<ContentsModel>) : RecyclerView.Adapter<RVAdapter.ViewHolder>() {
    //1.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RVAdapter.ViewHolder {
        //rv_item layout inflate
        val v= LayoutInflater.from(parent.context).inflate(R.layout.rv_item, parent, false)
        return ViewHolder(v)
    }

    // 부가적
    interface ItemClick
    {
        fun onClick(view : View, position: Int)
    }
    var itemClick : ItemClick ?= null


    //2.ViewHolder가 Hold하고 있는 위젯에 데이터를 설정하는 형태
    override fun onBindViewHolder(holder: RVAdapter.ViewHolder, position: Int) {
        holder.binditmes(List[position])

        if(itemClick != null) {
            holder?.itemView.setOnClickListener { v->
                itemClick!!.onClick(v,position)
            }
        }

    }

    //3.
    override fun getItemCount(): Int {
        return List.size
    }


    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

        fun binditmes(item : ContentsModel) {

            val rv_text = itemView.findViewById<TextView>(R.id.rvTextArea)
            val rv_img = itemView.findViewById<ImageView>(R.id.rvImageArea)

            //item: List[position]
            rv_text.text = item.titleText

            //Glide : 이미지 로딩 라이브러리
            Glide.with(context)
                .load(item.ImageUrl)
                .into(rv_img)

        }
    }
}