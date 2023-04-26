package com.example.gridcardview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.bumptech.glide.Glide
import com.example.gridcardview.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    lateinit var binding : ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val nim = intent.getStringExtra("nim")
        val nama = intent.getStringExtra("nama")
        val notelp = intent.getStringExtra("notelp")
        val foto = intent.getStringExtra("foto")

        binding.nim.text = nim
        binding.nama.text = nama
        binding.notelp.text = notelp
        Glide.with(this).load(foto).into(binding.images)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            android.R.id.home->{
                onBackPressed()
                true
            }else -> super.onOptionsItemSelected(item)
        }
    }
}