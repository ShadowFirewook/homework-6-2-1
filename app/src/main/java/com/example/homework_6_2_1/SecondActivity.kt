package com.example.homework_6_2_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.homework_6_2_1.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding
    private var imageList:ArrayList<Int> =  arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getData()
        val imageAdapter = ImageAdapter(list = imageList, null,null)
        binding.recyclerViewSecond.apply {
            layoutManager = GridLayoutManager(this@SecondActivity,3)
            adapter = imageAdapter
        }
        initClick()
    }

    private fun getData() {
        val result = intent.getIntegerArrayListExtra(MainActivity.SELECTED_IMAGES)
        if (result != null) {
            imageList = result
        }
    }
    private fun initClick(){
        binding.back.setOnClickListener {
            finish()
        }
    }
}