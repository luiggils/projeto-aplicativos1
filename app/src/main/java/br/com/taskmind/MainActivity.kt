package br.com.taskmind

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.taskmind.ui.theme.TaskmindTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            @Composable
            fun TaskOrganizerApp() {
                var tasks by remember { mutableStateOf(listOf<Task>()) }

                Column {
                    TaskEntryScreen({ task, priority ->
                        tasks = tasks + Task(task, priority)
                    })
                    TaskListScreen(tasks, { task ->
                        // Implement task editing or deletion here
                    })
                }
            }
}
