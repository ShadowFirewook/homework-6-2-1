package com.example.homework_6_2_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.GridView
import androidx.activity.result.contract.ActivityResultContracts
import com.example.homework_6_2_1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var imageList:ArrayList<Int>
    private lateinit var gridView: GridView
    private lateinit var selectedImages:ArrayList<Int>
    private  val activityLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
       /* if (result.resultCode == RESULT_OK) {

        }*/
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        gridView= findViewById(R.id.gridView)
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
        val adapter = ImageAdapter(imageList = imageList, context = this@MainActivity)
        gridView.adapter = adapter
        gridView.setOnItemClickListener { parent, view, position, id ->
            val selectImage = imageList[position]
            adapter.selectedPositions.add(selectImage)
            Log.e("ololo",adapter.selectedPositions.toString())
        }
        selectedImages = adapter.selectedPositions
        initClick()
    }
    private fun initClick(){
        binding.btnSend.setOnClickListener {
            activityLauncher.launch(Intent(this,SecondActivity::class.java).apply {
                putIntegerArrayListExtra(SELECTED_IMAGES,selectedImages)
            })
        }
    }
    companion object{
        const val SELECTED_IMAGES = "selected images"
    }
}
