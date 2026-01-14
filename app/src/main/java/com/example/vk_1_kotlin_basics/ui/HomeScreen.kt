package com.example.vk_1_kotlin_basics.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.vk_1_kotlin_basics.domain.*
import java.time.LocalDate

@Composable
fun HomeScreen() {
    var tasks by remember { mutableStateOf(TaskRepository.mockTasks) }
    var showOnlyDone by remember { mutableStateOf(false) }

    val visibleTasks = if (showOnlyDone) filterByDone(tasks, true) else tasks

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Vk 1: Kotlin basics",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(12.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Button(onClick = {
                val nextId = (tasks.maxOfOrNull { it.id } ?: 0) + 1
                val newTask = Task(
                    id = nextId,
                    title = "Task #$nextId",
                    description = "Added from button",
                    priority = Priority.LOW,
                    dueDate = LocalDate.now().plusDays(10),
                    done = false
                )
                tasks = addTask(tasks, newTask)
            }) {
                Text("Add")
            }

            Button(onClick = { tasks = sortByDueDate(tasks) }) {
                Text("Sort")
            }

            Button(onClick = { showOnlyDone = !showOnlyDone }) {
                Text(if (showOnlyDone) "Show All" else "Show Done")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
            visibleTasks.forEach { task ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column(modifier = Modifier.weight(1f)) {
                        Text(text = "${task.title} (${task.priority})")
                        Text(text = "Due: ${task.dueDate} | Done: ${task.done}")
                    }
                    Button(onClick = { tasks = toggleDone(tasks, task.id) }) {
                        Text(if (task.done) "Undo" else "Done")
                    }
                }
                Divider()
            }
        }
    }
}
