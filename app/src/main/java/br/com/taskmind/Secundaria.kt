package br.com.taskmind

@Composable
fun TaskListScreen(tasks: List<Task>, onTaskClicked: (Task) -> Unit) {
    LazyColumn {
        items(tasks) { task ->
            TaskItem(task, onTaskClicked)
        }
    }
}

@Composable
fun TaskItem(task: Task, onTaskClicked: (Task) -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onTaskClicked(task) }
            .padding(16.dp)
    ) {
        Column {
            Text(task.description, fontWeight = FontWeight.Bold)
            Text("Priority: ${task.priority.name}")
        }
    }
}

data class Task(val description: String, val priority: Priority)