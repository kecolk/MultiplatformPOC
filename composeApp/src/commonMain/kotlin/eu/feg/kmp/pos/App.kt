package eu.feg.kmp.pos

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import eu.feg.kmp.poc.shared.TournamentsParams

import org.koin.compose.KoinContext
import org.koin.compose.currentKoinScope

@Composable
fun App() {
    MaterialTheme {
        KoinContext {
            val navController = rememberNavController()
            NavHost(
                navController = navController,
                startDestination = "home",
            ) {
                composable("home") {
                    Sports(){ sportId ->
                        navController.navigate(TournamentsParams(sportId))
                    }
                }
                composable<TournamentsParams> { backStackEntry ->
                    val params: TournamentsParams = backStackEntry.toRoute()
                    Tournaments(params.sportId)
                }
            }
        }
    }
}

@Composable
inline fun <reified T : ViewModel> koinViewModel(): T {
    val scope = currentKoinScope()
    return viewModel {
        scope.get<T>()
    }
}