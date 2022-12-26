package com.example.homework_6_2_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.GridView
import com.example.homework_6_2_1.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding
    private lateinit var imageList:ArrayList<Int>
    private lateinit var gridView: GridView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        gridView= findViewById(R.id.gridViewSecond)
        val result = intent.getIntegerArrayListExtra(MainActivity.SELECTED_IMAGES)
        if (result != null) {
            imageList = result
        }
        val adapter = ImageAdapter(imageList = imageList, context = this@SecondActivity)
        gridView.adapter = adapter
    }
}