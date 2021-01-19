package com.example.dataclassroomstorage.Adapter

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.EditText
import com.example.dataclassroomstorage.Model.User1
import com.example.dataclassroomstorage.R
import kotlinx.android.synthetic.main.row_layout.view.*

class ListUserAdapter (internal var activity: Activity,
                       internal var lstUser: List<User1>,
                       internal var edit_id : EditText,
                       internal var edit_sid : EditText,
                       internal var edit_name : EditText,
                       internal var edit_adr : EditText): BaseAdapter()
{
    internal var inflater: LayoutInflater

    init {
        inflater = activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    }

    override fun getCount(): Int {
        return lstUser.size
    }

    override fun getItem(position: Int): Any {
        return lstUser[position]
    }

    override fun getItemId(position: Int): Long {
        return lstUser[position].id.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val rowView: View
        rowView = inflater.inflate(R.layout.row_layout, null)

        rowView.txt_id.text = lstUser[position].id.toString()
        rowView.txt_sid.text = lstUser[position].sid.toString()
        rowView.txt_name.text = lstUser[position].name.toString()
        rowView.txt_adr.text = lstUser[position].adr.toString()

        rowView.setOnClickListener {
            edit_id.setText(rowView.txt_id.text.toString())
            edit_sid.setText(rowView.txt_sid.text.toString())
            edit_name.setText(rowView.txt_name.text.toString())
            edit_adr.setText(rowView.txt_adr.text.toString())

        }
        return rowView
    }

}