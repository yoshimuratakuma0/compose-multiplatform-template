import androidx.compose.runtime.mutableStateOf
import domain.usecases.GetSampleTextUseCase

class HomeViewModel(
    getSampleTextUseCase: GetSampleTextUseCase,
) : CommonViewModel() {
    val text = mutableStateOf(getSampleTextUseCase())
}