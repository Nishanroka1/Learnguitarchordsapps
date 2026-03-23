package np.com.nishanroka.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlayScreen(onBack: () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Play Guitar") },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { padding ->
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(horizontal = 32.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            val strings = listOf("E", "A", "D", "G", "B", "E")
            strings.forEach { note ->
                GuitarString(note = note)
            }
        }
    }
}

@Composable
fun GuitarString(note: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxHeight()
    ) {
        Text(text = note, style = MaterialTheme.typography.labelLarge)
        Box(
            modifier = Modifier
                .width(4.dp)
                .fillMaxHeight()
                .background(Color.Gray)
                .clickable { /* Play sound logic */ }
        )
    }
}
