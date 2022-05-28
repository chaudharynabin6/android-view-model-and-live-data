package com.chaudharynabin6.viewmodelandlivedata

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.chaudharynabin6.viewmodelandlivedata.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val model: UserViewModel by viewModels()

        model.getUserList().observe(this) { users ->
            // update UI
            binding.listView.adapter = UserListViewAdapter( users)

        }
        binding.loadUser.setOnClickListener{
            model.loadUsers()
        }


    }

}