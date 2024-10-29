package eu.feg.kmp.pos

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import eu.feg.kmp.poc.shared.SportEvent

@Composable
fun SportEventItem(sportEvent: SportEvent) {
    Column(modifier = Modifier
        .padding(16.dp)
        .fillMaxWidth()
    ) {
        Text(text = sportEvent.name, style = MaterialTheme.typography.h6, color = Color.Black)
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = sportEvent.id, style = MaterialTheme.typography.body2, color = Color.Gray)
    }
}



