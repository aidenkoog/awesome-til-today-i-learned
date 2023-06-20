import kotlinx.coroutines.*

// 코루틴 스코프의 코루틴은 부모 코루틴 => launch 는 자식 코루틴
// 부모 코루틴을 Cancel 하면 자식 코루틴들도 Cancel 됨
// coroutineScope 는 코루틴 빌더를 수행하기 위해 존재
suspend fun doOneTwoThree() = coroutineScope {	// this: 코루틴
    val job = launch {	// this: 코루틴
        println("launch1: ${Thread.currentThread().name}")
        delay(200L) // suspension point + suspend function
        println("3!")
    }
    job.join()
    
    launch {	// this: 코루틴
        println("launch2: ${Thread.currentThread().name}")
        println("1!")
    }
    repeat(1000) {	// 100_000, 10_000 등의 가독성 숫자 사용 가능
        launch {	// this: 코루틴
            println("runBlocking: ${Thread.currentThread().name}")
            delay(500L)	// suspension point
            println("2!")
        }
    }
}

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
    runBlocking<Unit> {
        doOneTwoThree()
    }
    //     runBlocking<Unit> { // this: 코루틴
    //         launch {	// launch는 반드시 코루틴 안에서 호출 필요, this: 코루틴, Receiver, 수신객체
    //             doThree() // suspension point
    //         }
    //         launch {
    //             doOne()
    //         }
    // 		doTwo()
    //         delay(100L)	// suspension point
    //     }
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