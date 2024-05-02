package br.com.taskmind

@Composable
fun TaskEntryScreen(onTaskAdded: (String, Priority) -> Unit) {
    var task by remember { mutableStateOf("") }
    var priority by remember { mutableStateOf(Priority.LOW) }

    Column {
        TextField(
            value = task,
            onValueChange = { task = it },
            label = { Text("Task") }
        )
        Row {
            PriorityButton(Priority.LOW, priority, { priority = Priority.LOW })
            PriorityButton(Priority.MEDIUM, priority, { priority = Priority.MEDIUM })
            PriorityButton(Priority.HIGH, priority, { priority = Priority.HIGH })
        }
        Button(onClick = { onTaskAdded(task, priority) }) {
            Text("Add Task")
        }
    }
}

enum class Priority { LOW, MEDIUM, HIGH }

@Composable
fun PriorityButton(priority: Priority, selectedPriority: Priority, onClick: () -> Unit) {
    val backgroundColor = if (priority == selectedPriority) Color.Blue else Color.LightGray
    Button(onClick = onClick, backgroundColor = backgroundColor, color = Color.White) {
        Text(priority.name)
    }
}