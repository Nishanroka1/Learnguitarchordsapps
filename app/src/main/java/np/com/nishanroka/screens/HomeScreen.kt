package np.com.nishanroka.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    onPlayClick: () -> Unit,
    onLearnClick: () -> Unit,
    onAboutClick: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Guitar Chords App") })
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = onPlayClick,
                modifier = Modifier.fillMaxWidth(0.8f).padding(8.dp)
            ) {
                Text("Play Guitar")
            }
            Button(
                onClick = onLearnClick,
                modifier = Modifier.fillMaxWidth(0.8f).padding(8.dp)
            ) {
                Text("Learn Chords")
            }
            Button(
                onClick = { /* Tuner logic */ },
                modifier = Modifier.fillMaxWidth(0.8f).padding(8.dp)
            ) {
                Text("Tuner")
            }
            Button(
                onClick = onAboutClick,
                modifier = Modifier.fillMaxWidth(0.8f).padding(8.dp)
            ) {
                Text("About")
            }
        }
    }
}
