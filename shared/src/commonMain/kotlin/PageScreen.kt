import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun PageScreen(
    number: Int, onBack: () -> Unit,
    onBackToHome: () -> Unit,
    onNextPage: (Int) -> Unit,
) {
    Column(
        Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text("page number: $number")
        Button(onClick = onBack) {
            Text("戻る")
        }
        Button(onClick = { onNextPage(number + 1) }) {
            Text("次へ")
        }
        Button(onClick = onBackToHome) {
            Text("ホームに戻る")
        }
    }
}