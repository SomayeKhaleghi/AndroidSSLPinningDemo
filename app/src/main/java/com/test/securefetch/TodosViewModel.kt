package com.test.securefetch

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class TodosViewModel : ViewModel() {
    var todos = mutableStateListOf<Tods>()
        private set

    init {
        fetchTodos()
    }

    private fun fetchTodos() {
        viewModelScope.launch {
            try {
                val response = RetrofitClient.api.getTodos()
                todos.addAll(response)
            } catch (e: Exception) {
                // handle error
                e.printStackTrace()
            }
        }
    }
}