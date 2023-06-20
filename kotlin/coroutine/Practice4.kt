import kotlin.random.Random
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

fun flowSomething(): Flow<Int> = flow {
    repeat(10) {
        emit(Random.nextInt(0, 100))
        delay(10L)
    }
}

fun main() {
    runBlocking {
        flowSomething().collect {
            value -> println(value)
        }
    }
}