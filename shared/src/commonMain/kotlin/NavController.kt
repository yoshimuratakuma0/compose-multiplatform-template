import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.Saver


class NavController(
    val startDestination: Destination,
    val destinationStack: MutableList<Destination> = mutableListOf(startDestination),
) {
    val currentDestination = mutableStateOf(destinationStack.last())

    fun popBackStack() {
        if (destinationStack.size <= 1) {
            return
        }
        destinationStack.removeLast()
        currentDestination.value = destinationStack.last()
    }

    fun navigate(destination: Destination, type: NavType = NavType.SuppressTheSameDestination) {
        when (type) {
            NavType.SuppressTheSameDestination -> {
                if (destination == currentDestination.value) {
                    return
                }
                destinationStack.add(destination)
                currentDestination.value = destination
            }
        }
    }

    fun popBackTo(destination: Destination) {
        while (destinationStack.removeLast() != destination) {
            // nop
        }
        destinationStack.add(destination)
        currentDestination.value = destination
    }
}

val DestinationsSaver = Saver<NavController, List<Pair<String, String?>>>(
    save = {
        it.destinationStack.map { destination ->
            destination.path to destination.args
        }.toList()
    },
    restore = {
        val stack = it.map {
            Destination(path = it.first, args = it.second)
        }
        NavController(
            destinationStack = stack.toMutableList(),
            startDestination = stack.first(),
        )
    },
)

data class Destination(
    val path: String,
    val args: String? = null,
)

enum class NavType {
    SuppressTheSameDestination,
}