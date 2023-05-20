import kotlinx.coroutines.CoroutineScope

actual abstract class CommonViewModel actual constructor() {
    actual val viewModelScope: CoroutineScope
        get() = TODO("Not yet implemented")

    protected actual open fun onCleared() {
    }
}