package com.febryan.foodmvp.main

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.febryan.foodmvp.R
import com.febryan.foodmvp.model.DataItem
import com.febryan.foodmvp.updatedelete.UpdateDeleteActivity
import java.text.NumberFormat
import java.util.Locale

class FoodAdapter(val dataMakanan: List<DataItem?>?, val context: Context)
    : RecyclerView.Adapter<FoodAdapter.MyViewHolder>() {

    class MyViewHolder(v: View) : RecyclerView.ViewHolder(v){
        val image = v.findViewById<ImageView>(R.id.item_image)
        val namaMakanan = v.findViewById<TextView>(R.id.tv_nama_makanan)
        val hargaMakanan = v.findViewById<TextView>(R.id.tv_harga_makanan)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodAdapter.MyViewHolder {
        val v = LayoutInflater.from(context).inflate(R.layout.item_row_makanan, parent, false)
        return MyViewHolder(v)
    }

    override fun onBindViewHolder(holder: FoodAdapter.MyViewHolder, position: Int) {
        holder.namaMakanan.text = dataMakanan?.get(position)?.menuNama
//        holder.hargaMakanan.text = dataMakanan?.get(position)?.menuHarga
        val harga = dataMakanan?.get(position)?.menuHarga
        holder.hargaMakanan.text = NumberFormat.getCurrencyInstance(Locale("in", "ID")).format(Integer.valueOf(harga))
        Glide.with(context)
            .load(dataMakanan?.get(position)?.menuGambar)
            .error(R.drawable.ic_launcher_background)
            .into(holder.image)

        holder.itemView.setOnClickListener {
            val i = Intent(context, UpdateDeleteActivity::class.java)
            i.putExtra("DTL", dataMakanan?.get(position))
            context.startActivity(i)
        }
    }

    override fun getItemCount(): Int {
        return dataMakanan?.size!!
    }
}