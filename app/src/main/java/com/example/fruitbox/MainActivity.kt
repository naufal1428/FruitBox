package com.example.fruitbox

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fruitbox.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fruitList = listOf(
            Fruit(R.drawable.banana, "Pisang", "Kuning"),
            Fruit(R.drawable.apple, "Apel", "Merah"),
            Fruit(R.drawable.grape, "Anggur", "Ungu"),
            Fruit(R.drawable.orange, "Jeruk", "Orange"),
            Fruit(R.drawable.avocado, "Alpukat", "Hijau")
        )

        val adapter = FruitAdapter(fruitList, this)
        binding.rvFruit.adapter = adapter
        binding.rvFruit.layoutManager = LinearLayoutManager(this)

    }

    fun onItemClick(data: Fruit) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra(DetailActivity.EXTRA_FRUIT, data)
        startActivity(intent)
    }
}