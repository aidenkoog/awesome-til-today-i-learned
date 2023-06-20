import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import kotlin.system.*
import kotlinx.coroutines.channels.*

fun main() = runBlocking<Unit> {
    val oneToTen = produce {
        for (x in 1..10) {
            channel.send(x)
        }
    }
    oneToTen.consumeEach {
        println(it)
    }
    println("completed!")
}