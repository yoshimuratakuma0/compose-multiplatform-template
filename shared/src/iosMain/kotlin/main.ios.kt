import androidx.compose.ui.window.ComposeUIViewController

actual fun getPlatformName(): String = "iOS"

fun MainViewController(homeViewModel: HomeViewModel) =
    ComposeUIViewController { App(homeViewModel) }
