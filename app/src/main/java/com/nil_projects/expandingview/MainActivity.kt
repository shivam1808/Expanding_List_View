package com.nil_projects.expandingview


import android.app.AlertDialog
import android.content.DialogInterface
import android.media.Image
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

import com.diegodobelo.expandingview.ExpandingItem
import com.diegodobelo.expandingview.ExpandingList


class MainActivity : AppCompatActivity() {
    private var mExpandingList: ExpandingList? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mExpandingList = findViewById(R.id.expanding_list_main)
        createItems()
    }

    private fun createItems() {
        addItem("Apple", arrayOf("Apple Scab", "Black Rot", "Cedar Rust", "Healthy"), R.color.a1, R.drawable.apple)
        addItem("Blueberry", arrayOf("Healthy"), R.color.b1, R.drawable.blueberry)
        addItem("Cherry", arrayOf("Powdery Mildew", "Healthy"), R.color.a1, R.drawable.cherry)
        addItem("Corn", arrayOf("Cercospora Leaf Spot Gray", "Common Rust","Northern Leaf Blight", "Healthy"), R.color.b2, R.drawable.corn)
        addItem("Grapes", arrayOf("Black Rot", "Esca Black Measles", "Blight Isariopsis Leaft Spot", "Healthy"), R.color.g1, R.drawable.grape)
        addItem("Orange", arrayOf("Citrus Greening"), R.color.o1, R.drawable.orange)
        addItem("Peach", arrayOf("Bacterial Spot", "Healthy"), R.color.p2, R.drawable.peach)
        addItem("Pepper", arrayOf("Bell Bacterial Spot ", "Healthy"), R.color.p1, R.drawable.pepper)
        addItem("Potato", arrayOf("Early Blight", "Late Blight", "Healthy"), R.color.p3, R.drawable.potato)
        addItem("Raspberry", arrayOf("Healthy"), R.color.p1, R.drawable.raspberry)
        addItem("Soybean", arrayOf("Healthy"), R.color.s2, R.drawable.soybean)
        addItem("Squash", arrayOf("Powdery Mildew"), R.color.p3, R.drawable.squash)
        addItem("Strawberry", arrayOf("Leaf Scorch", "Healthy"), R.color.s1, R.drawable.strawberry)
        addItem("Tomato", arrayOf("Bacterial Spot", "Early Blight", "Late Blight", "Leaf Mold"
        , "Septoria Leaf Spot", "Spider Mites", "Target Spot", "Yellow Leaf Curl Virus", "Tomato Mosaic", "Healthy"), R.color.t1, R.drawable.tomato)

    }

    private fun addItem(title: String, subItems: Array<String>, colorRes: Int, iconRes: Int) {
        //Let's create an item with R.layout.expanding_layout
        val item = mExpandingList!!.createNewItem(R.layout.expanding_layout)

        //If item creation is successful, let's configure it
        if (item != null) {
            item.setIndicatorColorRes(colorRes)
            item.setIndicatorIconRes(iconRes)
            //It is possible to get any view inside the inflated layout. Let's set the text in the item
            (item.findViewById(R.id.title) as TextView).text = title

            //We can create items in batch.
            item.createSubItems(subItems.size)
            for (i in 0 until item.subItemsCount) {
                //Let's get the created sub item by its index
                val view = item.getSubItemView(i)

                //Let's set some values in
                configureSubItem(item, view, subItems[i], title)
            }
        }
    }

    private fun configureSubItem(item: ExpandingItem?, view: View, subTitle: String, title: String) {
        (view.findViewById(R.id.sub_title) as TextView).text = subTitle
        view.findViewById<ImageView>(R.id.remove_sub_item)
                .setOnClickListener(View.OnClickListener {
                    Toast.makeText(this, "$title-$subTitle",Toast.LENGTH_LONG).show()
                })
    }
}
