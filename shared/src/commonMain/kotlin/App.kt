import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import domain.HomeScreen

@Composable
fun App(homeViewModel: HomeViewModel) {
    MaterialTheme {
        HomeScreen(homeViewModel)
    }
}

expect fun getPlatformName(): String