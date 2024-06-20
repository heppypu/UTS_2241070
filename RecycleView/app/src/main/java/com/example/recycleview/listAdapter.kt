package com.example.recycleview

import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ListAdapter
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

//Extend ke Class RV Adapter
class listAdapter(private val arraylist : ArrayList<classPahlawan>)
    :RecyclerView.Adapter<ListAdapter.ViewHolder>(){

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgView : ImageView = itemView.findViewById(R.id.imgView)
        val textName: TextView  = itemView.findViewById(R.id.textNama)
        val textDes : TextView  = itemView.findViewById(R.id.textDesk)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListAdapter.ViewHolder {
        //inflate layout item data
        val v : View = LayoutInflater.from(parent.context).inflate(R.layout.item_data,parent,false)
       return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ListAdapter.ViewHolder, position: Int) {
        // Menempatkan data resources yang kita punya kedalam arraylist
        val(nama,deskripsi,foto) = arraylist[position]

        // Mengatur tata letaknya sesuai item data>>>findviewbyid-->class viewholder>>dihubungkan ke onBind
        holder.imgView.setImageResource(foto)
        holder.textName.text = nama
        holder.textDesk.text = deskripsi
    }

    override fun getItemCount(): Int {
        return arraylist.size
    }
}