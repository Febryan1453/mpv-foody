package com.febryan.foodmvp.updatedelete

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.bumptech.glide.Glide
import com.febryan.foodmvp.R
import com.febryan.foodmvp.databinding.ActivityUpdateDeleteBinding
import com.febryan.foodmvp.model.DataItem

class UpdateDeleteActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUpdateDeleteBinding
    var updateDeletePresenter : UpdateDeletePresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateDeleteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val terimaData = intent.getParcelableExtra<DataItem>("DTL")

        Glide.with(this)
            .load(terimaData?.menuGambar.toString())
            .error(R.drawable.ic_launcher_background)
            .into(binding.imgUpdate)

        binding.edtUpdtMakanan.setText(terimaData?.menuNama.toString())
        binding.edtUpdtHarga.setText(terimaData?.menuHarga.toString())
        binding.edtUpdtUrlGambar.setText(terimaData?.menuGambar.toString())

        binding.btnUpdatee.setOnClickListener {
            updateDeletePresenter?.updateDataFood(terimaData?.menuId.toString(),
                                                    binding.edtUpdtMakanan.text.toString(),
                                                    binding.edtUpdtHarga.text.toString(),
                                                    binding.edtUpdtUrlGambar.text.toString())
        }

        val dlt = "Delete ${terimaData?.menuId.toString()}"
        binding.btnDelete.setText(dlt)
        binding.btnDelete.setOnClickListener {
            updateDeletePresenter?.deleteDataFood(terimaData?.menuId.toString())
        }

    }

    fun showMessage(msg : String){
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show()
    }

    fun taskEnd() {
        finish()
    }
}