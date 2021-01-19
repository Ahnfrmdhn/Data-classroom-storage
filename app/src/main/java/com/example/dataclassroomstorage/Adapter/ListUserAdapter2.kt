package com.example.dataclassroomstorage.Adapter

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.EditText
import com.example.dataclassroomstorage.Model.User2
import com.example.dataclassroomstorage.R
import kotlinx.android.synthetic.main.row_layout2.view.*

class ListUserAdapter2 (internal var activity: Activity,
                        internal var lstUser: List<User2>,
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
        return lstUser[position].id2.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val rowView: View
        rowView = inflater.inflate(R.layout.row_layout2, null)

        rowView.txt_id2.text = lstUser[position].id2.toString()
        rowView.txt_sid2.text = lstUser[position].sid2.toString()
        rowView.txt_name2.text = lstUser[position].name2.toString()
        rowView.txt_adr2.text = lstUser[position].adr2.toString()

        rowView.setOnClickListener {
            edit_id.setText(rowView.txt_id2.text.toString())
            edit_sid.setText(rowView.txt_sid2.text.toString())
            edit_name.setText(rowView.txt_name2.text.toString())
            edit_adr.setText(rowView.txt_adr2.text.toString())

        }
        return rowView
    }

}