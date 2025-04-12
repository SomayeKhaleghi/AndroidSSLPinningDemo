package com.test.securefetch

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Surface
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp


class MainActivity : ComponentActivity() {

    private val todosViewModel by viewModels<TodosViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                   TodosListScreen(todosViewModel)
                }
            }
        }
    }
}

@Composable
fun TodosListScreen(viewModel: TodosViewModel) {
    val todos = viewModel.todos
    LazyColumn(modifier = Modifier.padding(16.dp)) {
        items(todos) { todo ->
            TodosItem(todo)
        }
    }
}

@Composable
fun TodosItem(todos: Tods) {
    Card(
        modifier = Modifier
            .padding(vertical = 8.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text ="Todo Task: " + todos.id.toString(), style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Completed: "+todos.completed.toString())
        }
    }
}