package eu.feg.kmp.pos

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import eu.feg.kmp.poc.shared.SportEvent
import eu.feg.kmp.poc.shared.SportEvents

@Composable
fun Sports() {
    val viewModel = koinViewModel<SportsViewModel>()

    val events = viewModel.sports.collectAsState(SportEvents())

    SportEventList(sportEvents = events.value.items)
}

@Composable
fun SportEventList(sportEvents: List<SportEvent>) {
    LazyColumn {
        items(sportEvents) { sportEvent ->
            SportEventItem(sportEvent = sportEvent)
        }
    }
}
