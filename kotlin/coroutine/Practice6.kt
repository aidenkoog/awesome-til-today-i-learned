import kotlin.random.Random
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

fun main() = runBlocking<Unit> {
    listOf(1, 2, 3, 4, 5).asFlow().collect {
        println(it)
    }
    (6..10).asFlow().collect {
        println(it)
    }
    flowOf(1,2,3,4,5,6,7,8,9,10).collect { println(it) }
    flow {
        emit(1)
        emit(2)
    }.collect {
        println(it)
    }
}

import kotlin.random.Random
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

fun flowSomething(): Flow<Int> = flow {
    repeat(10) {
        emit(Random.nextInt(0, 500))
        delay(10L)
    }
}

fun main() = runBlocking {
    flowSomething().map {
        "$it $it"
    }.collect { value ->
        println(value)
    }
}