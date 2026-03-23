package np.com.nishanroka.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LearnChordsScreen(onBack: () -> Unit) {
    val chords = listOf("C Major", "D Major", "G Major", "A Minor", "E Minor")

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Learn Chords") },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            items(chords) { chord ->
                ListItem(
                    headlineContent = { Text(chord) },
                    trailingContent = {
                        IconButton(onClick = { /* Play sound */ }) {
                            Icon(Icons.Default.PlayArrow, contentDescription = "Play Sound")
                        }
                    },
                    modifier = Modifier.clickable { /* Show chord diagram */ }
                )
                HorizontalDivider()
            }
        }
    }
}
