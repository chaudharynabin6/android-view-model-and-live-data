package com.chaudharynabin6.viewmodelandlivedata

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class UserViewModel : ViewModel() {
    private val users: MutableLiveData<List<User>> by lazy {
        MutableLiveData<List<User>>().apply {
//            asynchronous function
            initialLoad()
        }
    }

    private fun initialLoad() {
        viewModelScope.launch {
            delay(1)
            this@UserViewModel.users.value = listOf(
                User(1, "initial data"),
                User(2, "initial data")
            )
        }

    }

    fun getUserList(): MutableLiveData<List<User>> {
        return users
    }

    fun loadUsers() {
        this@UserViewModel.users.value = listOf(
            User(1, "nabin"),
            User(2, "naresh")
        )
    }


}