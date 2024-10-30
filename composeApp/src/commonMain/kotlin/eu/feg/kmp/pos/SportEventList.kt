package eu.feg.kmp.pos

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import eu.feg.kmp.poc.shared.SportEvent
import eu.feg.kmp.poc.shared.SportEvents

@Composable
fun Sports(showTournaments: (String, String) -> Unit) {
    val viewModel = koinViewModel<SportsViewModel>()

    val events = viewModel.sports.collectAsState(SportEvents())
    Column(
        modifier = Modifier.fillMaxSize().background(Color.LightGray)
    ) {
        SportEventList(sportEvents = events.value.items, showTournaments = showTournaments)
    }
}

@Composable
fun SportEventList(sportEvents: List<SportEvent>, showTournaments: (String,String) -> Unit) {
    LazyColumn(
        modifier = Modifier.padding(8.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(Color.White)
    ) {
        items(sportEvents) { sportEvent ->
            SportEventItem(sportEvent = sportEvent, showTournaments = showTournaments)
            Divider(color = Color.LightGray, thickness = 1.dp)
        }
    }
}

@Composable
fun SportEventItem(sportEvent: SportEvent, showTournaments: (String, String) -> Unit) {
    Row(modifier = Modifier
        .padding(8.dp)
        .fillMaxWidth()
        .clickable { showTournaments(sportEvent.id, sportEvent.name) }
    ) {
        Text(
            text = sportEvent.name,
            style = MaterialTheme.typography.body1.copy(fontSize = 18.sp, fontWeight = FontWeight.Medium),
            color = Color.Black,
            modifier = Modifier.weight(1f))
        Text(text = sportEvent.fixturesCount.toString(), style = MaterialTheme.typography.body1, color = Color.Gray)
    }
}
