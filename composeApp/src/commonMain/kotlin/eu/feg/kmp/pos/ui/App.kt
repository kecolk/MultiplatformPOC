package eu.feg.kmp.pos.ui

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import org.koin.compose.KoinContext
import org.koin.compose.currentKoinScope

@Composable
fun App() {
    MaterialTheme {
        KoinContext {
            val navController = rememberNavController()
            CompositionLocalProvider(LocalNavController provides navController) {
                NavHost(
                    navController = navController,
                    startDestination = "home",
                    ) {
                        composable("home") {
                            SportsList()
                        }
                        composable<TournamentsParams> { backStackEntry ->
                            val params: TournamentsParams = backStackEntry.toRoute()
                            Tournaments(params.sportId, params.name){
                                navController.popBackStack()
                            }
                        }
                        composable<FixturesParams> { backStackEntry ->
                            val params: FixturesParams = backStackEntry.toRoute()
                            Fixtures(params.tournamentId, params.name){
                                navController.popBackStack()
                            }
                        }
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