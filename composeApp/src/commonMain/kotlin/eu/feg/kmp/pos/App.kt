package eu.feg.kmp.pos

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import multiplatfompoc.composeapp.generated.resources.Res
import multiplatfompoc.composeapp.generated.resources.compose_multiplatform
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
                    val viewModel = koinViewModel<SportsViewModel>()
                    Box(
                        modifier = Modifier
                            .fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Sports()
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