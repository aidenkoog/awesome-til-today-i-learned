import kotlin.system.measureTimeMillis
import kotlinx.coroutines.*
import kotlin.random.Random

fun main() {
    runBlocking<Unit> {
        launch(Dispatchers.IO) {
            println("IO")
        }
    }
}