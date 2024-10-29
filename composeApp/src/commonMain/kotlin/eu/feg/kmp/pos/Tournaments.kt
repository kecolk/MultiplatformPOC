package eu.feg.kmp.pos

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import eu.feg.kmp.poc.shared.Sport
import eu.feg.kmp.poc.shared.SportsData
import eu.feg.kmp.poc.shared.Tournament
import org.koin.compose.currentKoinScope
import org.koin.core.parameter.parametersOf

@Composable
fun Tournaments(sportId: String) {
    val viewModel = koinViewModel(sportId = sportId)
    val tournaments = viewModel.tournaments.collectAsState(SportsData(Sport(), listOf()))
    TournamentList(tournaments = tournaments.value.tournaments, showTournament = {})

}

@Composable
fun TournamentList(tournaments: List<Tournament>, showTournament: (String) -> Unit) {
    LazyColumn {
        items(tournaments) { tournament ->
            TournamentItem(tournament = tournament, showTournament = showTournament)
        }
    }
}

@Composable
fun TournamentItem(tournament: Tournament, showTournament: (String) -> Unit) {
    Column(modifier = Modifier
        .padding(16.dp)
        .fillMaxWidth()
        .clickable { showTournament(tournament.id) }
    ) {
        Text(text = tournament.name, style = MaterialTheme.typography.h6, color = Color.Black)
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = tournament.id, style = MaterialTheme.typography.body2, color = Color.Gray)
    }
}

@Composable
private fun koinViewModel(sportId: String): TournamentsViewModel {
    val scope = currentKoinScope()
    return viewModel {
        scope.get<TournamentsViewModel>(parameters = { parametersOf(sportId) })
    }
}
