import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import kotlin.system.*
import kotlinx.coroutines.channels.*

fun main() = runBlocking<Unit> {
    val channel = Channel<Int>()
    launch {
        for (x in 1..10) {
            channel.send(x)
        }
    }
    repeat(10) {
        println(channel.receive())
    }
    println("completed")
}