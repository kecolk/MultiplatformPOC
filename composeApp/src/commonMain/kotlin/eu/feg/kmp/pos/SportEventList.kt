package eu.feg.kmp.pos

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import eu.feg.kmp.poc.shared.SportEvent
import eu.feg.kmp.poc.shared.SportEvents

@Composable
fun Sports(showTournaments: (String) -> Unit) {
    val viewModel = koinViewModel<SportsViewModel>()

    val events = viewModel.sports.collectAsState(SportEvents())

    SportEventList(sportEvents = events.value.items, showTournaments = showTournaments)
}

@Composable
fun SportEventList(sportEvents: List<SportEvent>, showTournaments: (String) -> Unit) {
    LazyColumn {
        items(sportEvents) { sportEvent ->
            SportEventItem(sportEvent = sportEvent, showTournaments = showTournaments)
        }
    }
}

@Composable
fun SportEventItem(sportEvent: SportEvent, showTournaments: (String) -> Unit) {
    Column(modifier = Modifier
        .padding(16.dp)
        .fillMaxWidth()
        .clickable { showTournaments(sportEvent.id) }
    ) {
        Text(text = sportEvent.name, style = MaterialTheme.typography.h6, color = Color.Black)
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = sportEvent.id, style = MaterialTheme.typography.body2, color = Color.Gray)
    }
}
