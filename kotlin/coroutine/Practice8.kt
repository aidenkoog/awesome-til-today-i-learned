import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import kotlin.system.*

fun log(msg: String) = println("[$(Thread.currentThread().name)] $msg")

fun simple(): Flow<Int> = flow {
    for (i in 1..10) {
        delay(100L)
        log("$i emit")
        emit(i)
    }	// 업 스트림
}

fun main() = runBlocking<Unit> {
    val time = measureTimeMillis {
        simple().buffer().collect {
            delay(300L)
            log("$it received")
        }
    }
    println("collected in $time")
}