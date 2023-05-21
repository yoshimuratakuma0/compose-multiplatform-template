import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.saveable.rememberSaveable

@Composable
fun App(homeViewModel: HomeViewModel) {
    val navController = rememberSaveable(saver = DestinationsSaver) {
        NavController(
            startDestination = Destination(path = "home")
        )
    }
    MaterialTheme {
        when (navController.currentDestination.value.path) {
            "page" -> {
                PageScreen(
                    number = requireNotNull(navController.currentDestination.value.args?.toInt()),
                    onBack = {
                        navController.popBackStack()
                    },
                    onNextPage = {
                        navController.navigate(
                            Destination(
                                "page",
                                it.toString(),
                            )
                        )
                    },
                    onBackToHome = {
                        navController.popBackTo(Destination("home"))
                    },
                )
            }

            "home" -> {
                HomeScreen(
                    homeViewModel,
                    onMoveToDetail = { number ->
                        navController.navigate(
                            Destination(path = "page", args = number)
                        )
                    },
                )
            }
        }
    }
}

expect fun getPlatformName(): String