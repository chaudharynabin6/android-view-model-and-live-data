package com.chaudharynabin6.viewmodelandlivedata

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import com.chaudharynabin6.viewmodelandlivedata.databinding.UserListItemBinding


class UserListViewAdapter(var users : List<User>) : BaseAdapter() {
    override fun getCount(): Int {
       return users.size
    }

    override fun getItem(position: Int): Any {
        return users[position]
    }

    override fun getItemId(position: Int): Long {
       return position.toLong()
    }



    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val binding = UserListItemBinding.inflate(LayoutInflater.from(parent?.context),parent,false)
        binding.userName.text = users[position].name
        return binding.root
    }

}