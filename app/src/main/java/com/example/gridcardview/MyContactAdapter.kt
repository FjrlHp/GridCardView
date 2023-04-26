package com.example.gridcardview

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gridcardview.databinding.MyKontakItemBinding


class MyContactAdapter (private val context : Context, private val listStudent : ArrayList<KontakKu>) :
    RecyclerView.Adapter<MyContactAdapter.ViewHolder>(){
    class ViewHolder(val binding: MyKontakItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = MyKontakItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listStudent.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.nim.text = listStudent[position].nim
        holder.binding.nama.text = listStudent[position].nama
        holder.binding.notelp.text = listStudent[position].notelp
        holder.binding.itemView.setOnClickListener{
            val inten = Intent(context, DetailActivity::class.java)
            inten.putExtra("nim", listStudent[position].nim)
            inten.putExtra("nama", listStudent[position].nama)
            inten.putExtra("no telp", listStudent[position].notelp)
            inten.putExtra("foto", listStudent[position].foto)
            context.startActivity(inten)
        }

    }
}