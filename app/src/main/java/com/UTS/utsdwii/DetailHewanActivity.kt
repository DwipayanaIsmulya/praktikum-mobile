package com.UTS.utsdwii

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import com.andrirahmadani.animaldri.R

class DetailHewanActivity : AppCompatActivity() {
    companion object {
        const val SEARCH_PREFIX = "https://www.google.com/search?q=lebih+tau+tentang+"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_hewan)

        val namaDiLayout = findViewById<TextView>(R.id.tv_nama)

        val deskripsiDiLayout = findViewById<TextView>(R.id.tv_item_description)

        val gambarDiLayout = findViewById<ImageView>(R.id.img_item_photo)
        val buttonn = findViewById<Button>(R.id.button_id)

        val actionBar: ActionBar? = supportActionBar
        actionBar!!.setDisplayHomeAsUpEnabled(true)
        actionBar!!.setDisplayHomeAsUpEnabled(true)

        //get data from putExtra
        var intent = intent
        val nama = intent.getStringExtra("Nama")
        val gambar = intent.getIntExtra("Gambar", 0)
        val deskripsi = intent.getStringExtra("Deskripsi")


        actionBar.setTitle(nama)
        namaDiLayout.text = nama


        deskripsiDiLayout.text = deskripsi
        gambarDiLayout.setImageResource(gambar)
//        ilmiahDiLayout.text = ilmiah

        buttonn.setOnClickListener {
            val queryUrl: Uri = Uri.parse("${DetailHewanActivity.SEARCH_PREFIX}${nama}")
            val intent = Intent(Intent.ACTION_VIEW, queryUrl)
            startActivity(intent)
        }



    }
}