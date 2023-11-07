package com.example.fruitbox

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fruitbox.databinding.ItemFruitBinding

class FruitAdapter(private val listFruit: List<Fruit>, private val listener: MainActivity) :
    RecyclerView.Adapter<FruitAdapter.ItemFruitViewHolder>(){

        inner class ItemFruitViewHolder(val binding: ItemFruitBinding): RecyclerView.ViewHolder(binding.root){
            fun bind(data: Fruit){
                with(binding){
                    fruitImg.setImageResource(data.image)
                    nameTxt.text = data.name
                    colorTxt.text= data.color

                    itemView.setOnClickListener{
                        listener.onItemClick(data)
                    }
                }
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemFruitViewHolder {
        val binding = ItemFruitBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemFruitViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listFruit.size
    }

    override fun onBindViewHolder(holder: ItemFruitViewHolder, position: Int) {
        val fruit = listFruit[position]
        holder.bind(fruit)

        val labelWarna = when (fruit.color.toLowerCase()) {
            "kuning" -> Color.rgb(204, 204, 0)
            "merah" -> Color.RED
            "hijau" -> Color.rgb(0, 102, 0)
            "ungu" -> Color.rgb(108, 0, 171)
            "orange" -> Color.rgb(255, 128, 0)

            else -> Color.BLACK
        }

        holder.binding.colorTxt.setTextColor(labelWarna)
    }
}