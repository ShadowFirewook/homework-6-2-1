package com.example.homework_6_2_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.homework_6_2_1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var imageList: ArrayList<Int> = arrayListOf()
    private var selectedImages: ArrayList<Int> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fillList()

        val imageAdapter = ImageAdapter(list = imageList,this::selectItem,this::deleteItem)
        binding.recyclerView.apply {
            layoutManager = GridLayoutManager(this@MainActivity,3)
            adapter = imageAdapter
        }

        initClick()
    }

    private fun selectItem(image: Int){
        selectedImages.add(imageList[imageList.indexOf(image)])
    }

    private fun deleteItem(image: Int){
        selectedImages.remove(imageList[imageList.indexOf(image)])
    }

    private fun fillList() {
        imageList = arrayListOf(
            R.drawable.img_1,
            R.drawable.img_2,
            R.drawable.img_3,
            R.drawable.img_1,
            R.drawable.img_2,
            R.drawable.img_3,
            R.drawable.img_1,
            R.drawable.img_2,
            R.drawable.img_3,
            R.drawable.img_1,
            R.drawable.img_2,
            R.drawable.img_3,
            R.drawable.img_1,
            R.drawable.img_2,
            R.drawable.img_3,
        )
    }

    private fun initClick() {
        binding.btnSend.setOnClickListener {
            Intent(this,SecondActivity::class.java).apply {
                putIntegerArrayListExtra(SELECTED_IMAGES,selectedImages)
                startActivity(this)
            }
        }
    }

    companion object{
        const val SELECTED_IMAGES = "selected images"
    }
}
