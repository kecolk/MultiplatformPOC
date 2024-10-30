package eu.feg.kmp.pos.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import api.Sport
import api.SportsData
import api.Tournament
import eu.feg.kmp.pos.viewmodels.TournamentsViewModel
import org.koin.compose.currentKoinScope
import org.koin.core.parameter.parametersOf

@Composable
fun Tournaments(sportId: String, name: String, goBack: () -> Unit) {
    val viewModel = koinViewModel(sportId = sportId)
    val tournaments = viewModel.tournaments.collectAsState(SportsData(Sport(), listOf()))

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = name) },
                backgroundColor = Color.White,
                navigationIcon = {
                    IconButton(onClick = goBack) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                },
            )
        }
    ) {
        Column(
            modifier = Modifier.fillMaxSize().background(Color.LightGray)
        ) {
            TournamentList(tournaments = tournaments.value.tournaments)
        }
    }
}

@Composable
fun TournamentList(tournaments: List<Tournament>) {
    LazyColumn(
        modifier = Modifier.padding(8.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(Color.White)
    ) {
        items(tournaments) { tournament ->
            TournamentItem(tournament = tournament)
            Divider(color = Color.LightGray, thickness = 1.dp)
        }
    }
}

@Composable
fun TournamentItem(tournament: Tournament) {

    val navController = LocalNavController.current

    Row(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .clickable {
                navController.navigate(FixturesParams(tournament.id, tournament.name))
            }
    ) {
        Text(
            text = tournament.name,
            style = MaterialTheme.typography.body1.copy(fontSize = 18.sp, fontWeight = FontWeight.Medium),
            color = Color.Black,
            modifier = Modifier.weight(1f)
        )
        Text(text = tournament.fixturesCount.toString(), style = MaterialTheme.typography.body1, color = Color.Gray)
    }
}

@Composable
private fun koinViewModel(sportId: String): TournamentsViewModel {
    val scope = currentKoinScope()
    return viewModel {
        scope.get<TournamentsViewModel>(parameters = { parametersOf(sportId) })
    }
}
