package eu.feg.kmp.pos.ui

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
import api.Sport
import api.Sports
import coil3.compose.AsyncImage
import eu.feg.kmp.pos.viewmodels.SportsViewModel
import eu.feg.kmp.pos.utils.getIconPath

@Composable
fun SportsList() {
    val viewModel = koinViewModel<SportsViewModel>()

    val events = viewModel.sports.collectAsState(Sports())
    Column(
        modifier = Modifier.fillMaxSize().background(Color.LightGray)
    ) {
        SportListInternal(sports = events.value.items)
    }
}

@Composable
private fun SportListInternal(sports: List<Sport>) {
    LazyColumn(
        modifier = Modifier.padding(8.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(Color.White)
    ) {
        items(sports) { sport ->
            SportItem(sport = sport)
            Divider(color = Color.LightGray, thickness = 1.dp)
        }
    }
}

@Composable
fun SportItem(sport: Sport) {

    val navController = LocalNavController.current

    Row(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .clickable {
                navController.navigate(TournamentsParams(sport.id, sport.name))
            },
        verticalAlignment = androidx.compose.ui.Alignment.CenterVertically,
    ) {
        AsyncImage(
            modifier = Modifier.size(32.dp),
            model = getIconPath(sport.icon, "sports"),
            contentDescription = null,
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = sport.name,
            style = MaterialTheme.typography.body1.copy(fontSize = 18.sp, fontWeight = FontWeight.Medium),
            color = Color.Black,
            modifier = Modifier.weight(1f)
        )
        Text(text = sport.fixturesCount.toString(), style = MaterialTheme.typography.body1, color = Color.Gray)
    }
}
