import kotlinx.coroutines.*

suspend fun doThree() {
    println("launch1: ${Thread.currentThread().name}")
    delay(200L) // suspension point + suspend function
    println("3!")
}

suspend fun doOne() {
    println("launch2: ${Thread.currentThread().name}")
    println("1!")
}

suspend fun doTwo() {
    println("runBlocking: ${Thread.currentThread().name}")
    delay(500L)	// suspension point
    println("2!")
}

fun main() {
    runBlocking<Unit> { // this: 코루틴
        launch {	// launch는 반드시 코루틴 안에서 호출 필요, this: 코루틴, Receiver, 수신객체
            doThree() // suspension point
        }
        launch {
            doOne()
        }
		doTwo()
        delay(100L)	// suspension point
    }
    println("4!")
   
    val a = 3
    a.let {

    }
    val user = User("tester", 10, true)
    val age = user.let {
        user.age
        user.gender
    }
    println(age)

}

class User(
    val name: String,
    val age: Int,
    val gender: Boolean,
)