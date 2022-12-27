package com.example.homework_6_2_1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.homework_6_2_1.databinding.ImageItemBinding

class ImageAdapter(
    private var list: ArrayList<Int>,
    private val selectItem: ((image: Int) -> Unit)?,
    private val deleteItem: ((image: Int) -> Unit)?
):
    RecyclerView.Adapter<ImageAdapter.ImageViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        return ImageViewHolder(ImageItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class ImageViewHolder(private val binding: ImageItemBinding): ViewHolder(binding.root){
        fun bind(image: Int){
            binding.imageView.setImageResource(image)

            binding.imageView.setOnClickListener{
                if (binding.viewDark.visibility == View.GONE) {
                    selectItem?.let { it1 -> it1(image) }
                    binding.viewDark.visibility = View.VISIBLE
                } else {
                    deleteItem?.let { it1 -> it1(image) }
                    binding.viewDark.visibility = View.GONE
                }
            }
        }
    }

}