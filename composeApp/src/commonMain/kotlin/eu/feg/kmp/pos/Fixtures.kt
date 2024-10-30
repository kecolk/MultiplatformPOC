package eu.feg.kmp.pos

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil3.compose.AsyncImage
import eu.feg.kmp.poc.shared.*
import org.koin.compose.currentKoinScope
import org.koin.core.parameter.parametersOf

@Composable
fun Fixtures(tournamentId: String, name: String, goBack: () -> Unit) {
    val viewModel = koinViewModel(tournamentId = tournamentId)
    val fixtures = viewModel.fixtures.collectAsState(FixturesData(Tournament(), listOf()))

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
            FixturesList(fixtures = fixtures.value.fixtures)
        }
    }
}

@Composable
fun FixturesList(fixtures: List<Fixture>) {
    LazyColumn(
        modifier = Modifier.padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        items(fixtures) { fixture ->
            FixtureItem(fixture = fixture)
            Divider(color = Color.LightGray, thickness = 1.dp)
        }
    }
}

@Composable
fun FixtureItem(fixture: Fixture) {
    Column(
        modifier = Modifier.clip(RoundedCornerShape(10.dp))
            .background(Color.White).padding(8.dp),
    ) {
        Row(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            AsyncImage(
                modifier = Modifier.size(24.dp),
                model = getIconPath(fixture.participants.first().icon),
                contentDescription = null,
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = fixture.participants.first().name,
                style = MaterialTheme.typography.body1.copy(fontSize = 18.sp, fontWeight = FontWeight.Medium),
                color = Color.Black,
                modifier = Modifier.weight(1f)
            )
        }
        Row(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            AsyncImage(
                modifier = Modifier.size(24.dp),
                model = getIconPath(fixture.participants.last().icon),
                contentDescription = null,
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = fixture.participants.last().name,
                style = MaterialTheme.typography.body1.copy(fontSize = 18.sp, fontWeight = FontWeight.Medium),
                color = Color.Black,
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Composable
private fun koinViewModel(tournamentId: String): FixturesViewModel {
    val scope = currentKoinScope()
    return viewModel {
        scope.get<FixturesViewModel>(parameters = { parametersOf(tournamentId) })
    }
}
