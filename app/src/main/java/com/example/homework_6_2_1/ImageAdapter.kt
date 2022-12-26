package com.example.homework_6_2_1

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView

class ImageAdapter(
    private val context: Context,
    private val imageList:List<Int>
): BaseAdapter() {
   private var layoutInflater: LayoutInflater? = null
    var selectedPositions = arrayListOf<Int>()

    override fun getCount(): Int {
        return imageList.size
    }

    override fun getItem(position: Int): Any? {
        return null
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getView(position: Int, view: View?, viewGroup: ViewGroup?): View {
        var convertView = view
        if (layoutInflater == null) {
            layoutInflater =
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        }
        if (convertView == null) {
            convertView = layoutInflater!!.inflate(R.layout.gridview_item,null)
        }
        val imageView:ImageView = convertView?.findViewById(R.id.imageView) as ImageView
        imageView.setImageResource(imageList[position])
        return convertView
    }
}


