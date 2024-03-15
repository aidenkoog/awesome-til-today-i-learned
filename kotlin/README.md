#### 코틀린의 타켓 플랫폼 설명 / 자바와 서로 상호 운용에 대한 설명

- JVM이 코틀린의 타켓 플랫폼
- 코틀린은 컴파일 시 바이트 코드를 생성하므로 자바와 100% 상호 운용 가능
- 따라서 자바 <-> 코틀린 코드 간 상호 참조 / 호출 가능

#### 코틀린 특징

- 자료형에 대한 오류를 미리 잡을 수 있는 정적 언어
- 코틀린은 프로그램이 컴파일될 때 자료형을 검사하여 확정하는 정적 언어
- 즉 자료형 오류를 초기에 발견할 수 있어 프로그램의 안정성이 증가
- 널 포인터로 인한 프로그램의 중단을 예방 가능
- 널 포인터 오류는 프로그램이 실행되는 도중에 발생하기 때문에 언제 어디서 어떻게 발생할지 아무도 알 수 없음. 코틀린은 널 포인터 오류를 미리 예방 가능
- NPE에서 자유로움
- 간결하고 효율적
- 함수형 프로그래밍과 객체지향 프로그래밍이 모두 가능
- 함수를 변수에 저장하거나 함수를 다른 함수의 매개변수로 넘길 수 있는 함수형 프로그래밍과 클래스를 사용하는 객체지향 프로그래밍을 모두 가능
  - 멀티 패러다임 언어
- 세미콜론을 생략 가능

#### 코틀린 초기화 지연 개념 (by lazy 와 lateinit 설명)

- 변수를 선언할 때 값을 지정하지 않고 나중에 지정할 수 있는 방법
- 메모리 효율적 사용을 위해서 또는 널 세이프한 값을 사용하지 위한 목적
- 일반적인 방법
  - var text: String? = null
  - fun main() { text = "tester" }
  - 문제점
    - 타입이 널이 아닌 것이 좋은 방향, 초기화가 반드시 된다는 보장이 있다면 굳이 널로 초기화할 필요가 있을까?
    - 사용할 때 변수 뒤에 ?를 계속 붙여줘야 하는 이슈 있음
- lateinit: var 에서만 사용 가능, 반드시 타입 명시 필요
  - 언제든 초기화 변경 가능
  - null 통한 초기화 불가능
  - 초기화 전 접근 불가능 (lateinit property subject has not been initialized 에러)
    - UninitializedPropertyAccessException 발생
  - 변수에 대한 setter/getter 프로퍼티 정의 불가능
  - 원시 타입 (Primitive Type)에 대해서는 활용 불가능
    - Int 불가능 => Integer로 사용해야 함
  - 초기화 확인 방법 => ::변수.isInitialized
- by lazy: val 에서만 사용 가능, 반드시 변수 타입 지정 필요
  - lazy {}에 생성과 동시에 값을 초기화 하는 방법 사용
    - val test : Int by lazy { println("initializing...") 100 }
  - 호출 시점에 by lazy 정의에 의해 초기화 진행
  - val 에서만 사용 가능
  - 값 교체 불가능
  - 기본 Synchronized 로 동작

#### 동일성 (===)과 동등성 (==) 비교 방법 설명

- 동일성 (equality)
  - 두 개의 오브젝트가 완전히 동일한 것을 의미
- 동등성 (identity)
  - 동일한 정보를 가지고 있는 오브젝트를 의미

#### Companion Object 설명

- 클래스가 메모리에 적재되면서 함께 생성되는 객체 (자바 Static 처럼 사용 가능)
- Static 과 다름 (Static 보다 더 많은 일)
- Companion Object 는 변수에 할당 가능, 변수를 통해 멤버 참조도 가능
- 객체 생성 없이 변수와 메소드 등을 선언하여 사용하기 위해 사용
- 클래스 내에 하나만 생성 가능
- 사용법
  - companion object { const val NAME = "koo" fun mockBook() = Book() }
- 추가 설명
  - import 해보면 Book.Companion.NAME 으로 import 됨
  - 실제로는 companion object => object Companion { }
  - 만약에 companion object 뒤에 이름을 명시적으로 지정하면, 예를 들어 companion object Test 라고 명시하면 Book.Test.NAME 으로 import 됨

#### object 설명

- 싱글턴 패턴을 적용하여 객체를 한번만 생성하도록 하기 위해 사용하거나 익명 클래스의 생성을 위해 사용
- 클래스를 정의함과 동시에 객체를 생성
  - 싱글턴을 쉽게 만들 수 있는 키워드
  - 생성자 사용 불가능
  - 프로퍼티, 메소드, 초기화 블록은 사용 가능
  - 다른 클래스나 인터페이스를 상속받을 수 있음
- 에러 코드를 정의할 때 주로 많이 사용됨
- 사용법
  - object Counter { init { } var count = 0 fun countUp() { count++ } }
  - Counter.count / Counter.countUp()

#### 접근 제한자 설명

- private
  - 해당 파일 또는 클래스에서만 사용 가능
- public
  - 어디서든 접근 가능, 함수 또는 클래스 앞에 아무 접근자도 붙이지 않으면 자동으로 기본 지정되어서 따로 명시할 필요 없음
- protected
  - 상속받는 인터페이스, 클래스 또는 자식 클래스에서만 접근 가능
- internal
  - 같은 모듈 안에서는 다 접근 가능

#### Mutable과 Immutable 의미 및 존재 이유 설명

- 코틀린 콜렉션에서 제공하는 2가지 타입의 인터페이스
- 변경 가능 여부에 따라 2가지로 구분
- 코틀린은 불변성을 권장
- 불변성이 중요한 함수형 프로그래밍을 돕기 위해 사용

#### 코틀린 기본 문법 정리

- 함수
  - 함수는 모두 리턴형을 가지는데 특별한 지정이 없으면 기본적으로 Unit을 반환 (void)
  - 오버로딩 필요 시 자바처럼 오버로딩 할 필요없이 매개변수에 디폴트 값을 지정하면 됨
    - fun test(a: Int, b: Int = 3, c: Int = 4) : Int
    - val result = test(1, c = 5)
  - 플러터나 리액트처럼 어떤 변수에 어떤 값을 넣을 것인지에 대한 작성이 가능하여 전달하는 인자의 순서를 맞출 필요 없음
    - 마치 네임드 아규먼트처럼 사용 가능
    - 마지막 위치에 ,가 있어도 컴파일 에러 발생하지 않음
  - fun testCal(a: Int, b: Int) { return a + b } => fun testCal(a: Int, b: Int) = a + b 형태의 Single expression 가능
- 변수 정의
  - val = value, var = variable (변경가능한) 줄임말
  - 타입 추론 (val name = "이름")
- 클래스
  - 구현부가 없으면 생략 가능 (class TestClass(val name: String))
  - 디폴트 값 지정 가능
  - 상속
    - open을 사용하면 변수 재사용이 가능
    - open class User(open val name) / class Kid(override val name: String): User(name)
    - 기본적으로 상속은 닫혀있음. 상속을 하고자 할 때 명시적으로 클래스 앞에 open을 붙여줘야 함
    - 주 생성자, 부 생성자 개념 존재
    - init (클래스 안에서 가장 먼저 호출되는 곳) - init 호출 후 부 생성자 호출됨
- 조건식
  - 조건문 작성 후 변수에 저장 가능
  - 자바에서는 조건문이고 코틀린에서는 조건식이라 이해 (Statement가 아니라 Expression임)
  - switcha문: when, -> else
  - Expression으로 사용할 경우는 else 키워드 반드시 정의 필요
  - when에서 변수 선언 / 초기화 가능 (when (val data = 3))
  - when in <-- 범위를 나타낼 때 사용 (when (data) { in 2..4 })
- 반복문
  - for(i in 1..10)
  - IntRange(1, 10) == in 1..10
  - until
    - for (i in 1 until 10), until은 끝 숫자를 포함하지 않음
  - for (i in 1..10 step(2))
  - for (i in 10 downTo 1) 내림차순
  - for (i in 10 downTo 1 step(2)) - step 안에는 양의 정수만 가능
  - while 

#### 코틀린 컬렉션 재정리

- mutableListOf
  - add 가능
- listOf
  - add 불가능 (함수 보이지 않음)
- joinToString(",") 로 각 요소들을 출력 가능
  - list.joinToString(",")
- mapOf((1 to "Hello"), (2 to "Hi"))
  - 추가 불가능
- mutableMapOf((1 to "Hello"), (2 to "Hi"))
  - put 사용 가능 / map[3] = "" <= 맵도 배열처럼 사용 가능 (인덱스 오퍼레이터 사용)
- list.get(0) => list[0]로 배열처럼 사용 가능
- 자바와 다르게 다양한 타입의 값을 리스트에 삽입 가능
  - listOf("test", 1, 0.77)
- 다양한 확장함수 존재 (스트림처럼 사용가능한 함수도 존재)
  - list.first { id = 10 }
  - list.map { it * 10 }.joinToString("/")

#### 코틀린 null 관련 재정리

- 런타임에서의 널 예외상황 발생은 이슈 파악 / 처리를 힘들게 만듬
- 변수 타입으로 애초에 널 삽입 자체를 막는 것이 가능
- 널 허용을 위해서는 해당 타입 뒤에 ? 추가
- 코틀린은 코틀린 언어 단에서 널인것과 널이 아닌 것을 나눔으로서 컴파일 단계에서 에러를 발생시킴 (런타임이 아닌)
- ?: 해당 값이 널이면 뒤의 값을 사용 (엘비스 연산자), 약 5줄 가량의 코드를 줄일 수 있음
  - val result = nickName ?: "default-value"
- ? 해당 변수값이 널이면 더이상 진행하지 않고 널을 반환하고 널이 아니면 뒤의 변수 / 함수를 실행
  - val size = nickName?.length, nickName이 널이면 size는 널 값으로 초기화
- !! 반드시 null이 아님을 나타내기 위한 연산자 (가능한 사용 지양)
  - 타입을 선언할 때 널 세이프하게 선언하려고 노력하는 것이 중요
- 널 세이프 강화는 코틀린을 사용해야 되는 이유 중 가장 큰 이유임

#### 타입 체킹 / 캐스팅 재정리

- instanceof = is
- (Object) = as Object
- as?: 형변환이 불가능하면 널 반환
  - as? String ?: "Failed" 로 응용도 가능
- Smart Cast
  - is로 형변환 체크를 완료한 후에는 as 사용없이 바로 해당 타입의 함수 사용 가능

#### String Template 재정리

- 기존 방식
  - 플러스 기호 활용한 문자열 및 값들 연결
  - String.format("%s, "%d, ...)
- 스트링 템플릿
  - 쌍따옴표 내 $변수의 형태로 바로 출력 가능 (toString 없이 달러 기호로 해당 변수 값 호출 가능)
  - {}을 넣으면 식의 결과값 출력도 가능 (${name.length})

#### 람다

- 함수형 프로그래밍 특징
- 조건문이 아니라 조건식인것, 변수자체를 Immutable 하게 잘 선언하는 것 등이 함수형 패러다임의 예
- 람다 특징 
  - 익명 함수
    - fun()
  - 하나의 변수처럼 사용 가능 (함수의 아규먼트, 함수의 리턴값으로 활용)
    - val funVal = fun() { println("test") }
    - val funVal2 : (String) -> Int = { it * 10 }
      - String 입력값과 Int 아웃풋 타입을 갖는 함수라는 의미
      - 인자가 1개이면 it으로 받음
      - 바디 (함수의 구현부) 에서 맨마지막 줄이 반환값이 됨
      - it * 10 이 리턴값
      - 실행을 할 때는 funVal2("test")로 실행
    - val funVal3 = { i : Int, j : Int -> i * j } 와 같이 선언도 가능, i, j 둘 중 하나에는 타입 명시 필요
    - val funVal4 = (Int, String, Boolean) -> String = { _, b, _ -> b }
      - 사용하지 않는 입력값이 있으면 언더 스코어로 작성해줘야 Warning 제거가 가능
    - 함수를 그냥 출력하면 코드 조각이 출력되므로 fun() 와 같이 작성해야 함
  - 아래와 같이 함수의 아규먼트 그리고 리턴값으로도 활용 가능
    - fun hello(a: Int, b: (Int) -> Int) : (Int) -> Int { return b }
  - 한 번 사용되고, 재사용되지 않는 함수 만들 때 사용
    - SAM 개념 (추가 스터디 및 개념 정리 필요)
      - Single Abstract Method 단일 추상 메소드
      - 코틀린에는 SAM Conversions 가 제공됨
      - 하나의 추상 메서드에 대해서 함다식을 제공, 단, 자바에서 작성한 인터페이스 정의와 이를 활용하는 setOnClickListener를 코틀린에서 부르는 경우에만 이에 해당함
      - val view = View(this)
      - view.setOnClickListener( {println("Hello")} )
        - = view.setOnClickListener { println("Hello") }
      - 함수형 인터페이스인, 즉 구현해야 되는 메소드가 1개인 함수형 인터페이스는 코틀린에서 람다식으로 대체 가능

#### 코틀린 확장함수 (Extension Function)

- 클래스에는 다양한 매소드(함수)들이 존재하는데, 이때 기존의 클래스에 내가 원하는 새로운 함수를 추가(확장)하려고 할 때 사용하는 함수
- 기존의 클래스에 새로운 함수를 확장한다라는 의미
- 만약 모든 클래스에 내가 만든 확장함수를 추가하고 싶다면 최상위 클래스인 'Any'에 확장 함수를 구현하면 가능
- 코틀린의 최상위 요소는 'Any'이기 때문에 Any에 확장 함수를 추가하면 코틀린의 모든 요소에 상속되기 때문에 모든 클래스에 내가 만든 확장함수를 추가 가능
- 개발 시 확장함수를 잘 설계해서 정의해놓으면 효율적인 코드 작성 가능
- 기존에 정의된 클래스에 함수를 추가하는 기능
- 보통 자기가 만든 클래스에 함수를 추가하려면 [클래스명].[함수명]을 할 수 있지만 기존에 정의된 클래스에 함수를 추가하기 위해선 확장함수를 정의해야 함
- 우리가 변경할 수 없는 클래스가 있다고 가정할 때 해당 클래스를 상속 등의 방법으로 커스터마이징해서 함수를 추가해야 하는 불편함이 있었음
  - 클래스.함수명 = 로직 의 형식으로 원하는 새로운 함수를 추가 가능
  - 코드량 감소 효과

#### Kotlin Scope Function 설명

- 코틀린 표준 라이브러리에서 제공하는 함수
- 객체에 쉽게 접근할 수 있도록 해주는 함수
- 어떤 사람이 풍선을 크게 불면 그 안에서는 그 사람을 누구인지 몰라도 그 사람이 가진 정보를 사용할 수 있는 개념
- 코드가 간결해지고 가독성, 유지보수 용이성 증대 효과
- 객체의 컨텍스트 내에서 실행 가능한 코드 블럭을 만드는 함수, 호출 시 임시 범위가 생성되며, 이 범위 안에서는 이름 없이 객체에 접근 가능
- 수신 객체: 확장 함수가 호출되는 대상이 되는 값 (객체)
- 코드 블럭을 수신 객체 지정 람다라 함 (수신 객체를 명시하지 않고 람다의 본문 안에서 해당 객체의 메서드를 호출할 수 있게 하는 것)
- 시용 시 리시버와 람다 함수를 넘겨줌
- Scope 함수는 어떠한 새로운 기술적인 능력을 가져다주는 것이 아닌, 코드를 좀 더 간결하고 읽기 쉽게 만들어주는 것
- Scope Function에는 서로 다른 두 가지 주요 차이점
  - Context Object를 참조하는 방법 (this, it)
  - Return value
- [apply]
  - this로 Context 객체 참조
    - val user = User("tester", 10, 10)
    - val name = user.apply { name }
    - val tester = User("tester", 20, false, true)
    - val testerValue = tester.apply { hasTool = false } <= 변수 (var 타입) 초기화 용도
    - println(testerValue.hasTool)
  - Context 객체 반환
  - 객체의 상태를 변화시키고 그 객체를 다시 반환할 때 사용 (자기 자신 즉, 수신객체 반환)
  - 객체 초기화 할 때 사용
- [with]
  - this로 Context 객체 참조
    - with(수신객체) { } <= 마지막 줄 반환
    - val result = with(tester) { hasTool = false true }
  - 람다식 결과 반환
  - 인수로 전달되는 자기자신을 this로 참조.
  - this 키워드를 생략할 수도 있고, 리턴값 생략을 권장
  - let은 리시버의 확장함수로 쓰이지만 with은 그렇지 않음.
  - 리시버객체는 with(리시버객체){람다함수}로 인자로만 전달 가능
  - 객체 초기화, 람다 리턴 값이 필요 없을 때 사용
- [run] *
  - this로 Context 객체 참조
    - val user = User("tester", 10, 10)
    - val age = user.run { this.age }
    - println(age)
  - 람다식 결과 반환 (맨 마지막 줄 결과 반환)
  - with과 다르게 확장함수로 쓸 수 있음
  - 리시버객체를 리시버객체.run{람다함수}처럼 함수처럼 사용 가능
  - run()함수는 람다함수에서 여러값을 초기화하고, 리턴값을 어떤 객체의 초기값으로 사용
  - let()함수로 똑같이 쓸 수도 있는데 차이점이라면 run()함수는 굳이 확장함수로 사용하지 않을때도 사용 가능
    - ex. run {}
  - run()함수는 익명함수처럼 사용하거나 객체에서 호출하는 방법 모두 제공
  - 객체를 초기화하고 리턴 값이 있을 때 사용
- [let] *
  - it으로 Context 객체(리시버) 참조 (전달 인자명 지정 안하면 it)
    - .let { user -> user.name }
    - val age = user.let { user -> user.gender }
  - 람다식 결과 반환 (맨 마지막 줄 결과 반환)
  - 한번에 여러 함수를 호출할 때 사용
  - ?키워드와 같이 쓰이면서 널이 아닐 때만 리시버가 동작하도록 할때 사용
  - 널 체크를 해야할 때, 지역 변수를 명시적으로 표현해야 할 때 사용
    - var user: User? = User("tester", 10, 10)
    - val age = user?.let { it.age }
- [also]
  - it으로 Context 객체(리시버) 참조 (전달 인자명 지정 안하면 it)
    - val male = User("tester", 10, false, true)
    - val maleValue = male.also { user -> user.name user.hasTool = false }
    - println(maleValue) <= 수신객체 반환
  - Context 객체 반환
  - let()과 기능은 비슷하지만, apply처럼 객체의 상태를 변화시키고 그 객체(자기 자신 즉, 수신객체)를 다시 반환할때 사용
  - 리시버 스스로를 리턴하기 때문에 연속적으로 객체 호출 가능
  - 수신 객체를 명시적으로 사용하고자 할 때, 로그를 남길 때 사용 (권장사항, 초기화할 때는 잘 사용하지 않음)

#### 코틀린 장점 설명

- 기존의 자바 코드의 보일러 플레이트 구문 최소화 가능
- 자바 8 / RxJava / 람다 등의 활용을 통해 코드 간소화가 가능하나 라이브러리들의 의존성문제와 기존 라이브러리에 대한 학습등이 부담으로 다가오는 문제점 존재
- NullPointerException 핸들링
- 보일러 플레이트 개선 (데이터 클래스 등)
- Collections에 filter, map, foreach 같은 고차함수를 적용 가능
- 변경 가능한 컬렉션과 불가능한 컬렉션을 엄격히 구분
- 서버에서 수신받은 데이터를 컬렉션으로 다룰 일이 많기때문에 코드를 보다 간결하고, 안전하게 만드는 데 도움이 됨 - 확장함수(이미 존재하는 클래스에 새로운 함수를 추가)라는 기능 제공
- 자바와 호환성이 무척 좋고 기존의 라이브러리를 제약없이 사용 가능

#### 코틀린 inline 함수 / 클래스 설명 (스터디 및 추가 정리 필요)

- 자바에서는 제공하지 않음
- 람다식 사용 시 무의미한 객체 생성 방지
- 람다식 내 로컬 변수 추가되는 것에 대한 개선
- public inline 함수는 private 함수 호출 불가능
- 참고. 람다의 경우 컴파일 단계에서 파라미터 개수에 따라 Function 형태의 인터페이스로 변환됨
- inline 키워드를 사용하면 함수를 호출하는 모든 문장을 함수 본문에 해당하는 바이트코드로 바꿔주기 때문에 오버헤드를 감소시킴

#### 코루틴 정리

- co : with, together 
- routine : 규칙적으로 하는일의 통상적인 순서와 방법
- coroutine : co + routine의 합성어로 협동루틴
- 즉, 코루틴이란 함께 동작하면서 규칙이 있는 일의 순서를 의미
- 코루틴은 실행이 마지막으로 중단되었던 지점의 바로 다음장소에서 실행을 재개
- 동기는 launch, 비동기는 async로 표현
  - Builder: launch, async, 코루틴을 실행하는 함수
- Main: 메인 스레드. 화면 UI 작업 등을 하는 곳
- IO: 네트워크, DB 등 백그라운드에서 필요한 작업을 하는 곳
- Default: 정렬이나 무거운 계산 작업 등을 하는 곳
- Coroutines simplify async code by replcaing callbacks
- 구글에서는 코루틴을 비동기처리에서 쓰면 코드를 간단하게 작성할 수 있다고 함
- 코루틴이 메인스레드가 blocking되는 부분에 대해서도 도움을 주고 비동기 처리코드를 순차적인 코드로 만들수 있게 해줌
- delay는 no blocking, sleep은 blocking 함수
- CoroutineScope: 코루틴을 제어할 수 있는 범위
- CoroutineContext: 코루틴이 실행될 Context, 코루틴의 실행 목적에 맞게 실행될 특정 스레드풀을 지정

#### 고차함수 (higher-order functions)

- 함수의 인자로 함수를 넘기거나 함수를 리턴할 수 있는 기능
- 인자로 함수를 넘길때 함수의 타입 명시 필요, ex. func: ()->String 처럼 함수의 타입이 String
- ->를 기준으로 왼쪽은 파라미터(인자), 오른쪽은 리턴값을 의미
- 리턴값이 없으면 Unit으로 표기

#### 코틀린 runCatching

- inline 키워드가 붙어 있고 내부적으로 try-catch를 쓰고 있음
- 리턴 타입은 매개변수로 받은 함수 타입이 반환하는 값과 같은 값을 갖는 Result 타입
- 성공 시 Result.success() 안에서 함수 타입 매개변수를 실행해 리턴하고 실패 시 Result.failure()로 Throwable을 넘김
- runCatching {} 안에는 예외가 발생할 수 있는 코드를 삽입
- 그리고 뒤에 잇따르는 onSuccess, onFailure 블록에선 각각 성공, 실패한 경우 수행할 처리들을 삽입
- 마지막에 result 변수를 출력하면 Success()에 감싸여 있는 걸 볼 수 있음
- 위에서 말한 대로 호출이 성공해서 Result 타입으로 캡슐화된 응답이 반환된 것임
- try-catch 보다 간결한 형태로 예외처리 코드를 쓸 수 있어 상대적으로 가독성이 좋음
- onSuccess, onFailure, getOrElse 등의 함수를 연달아 쓸 수 있는 함수 체이닝이 가능
- Result 타입을 사용해 성공 / 실패를 리턴하기 때문에 try-catch보다 상대적으로 성능 저하가 일어날 수 있음

#### Android Studio 팁 재정리

- Kotlin Bytecode 통해 코틀린으로 짠 코드를 자바로 보는 것이 가능
  - Tool > Kotlin > Show Kotlin Bytecode
- Java Snippet 복사 시 코틀린 코드로 변경 가능

#### 코틀린 로깅

- println("logging")

#### Coroutine Context, Dispatcher

- 코루틴은 항상 코틀린 표준 라이브러리에 정의되어 있는 CoroutineContext 타입의 특정 Context 안에서 실행됨
  - 대표적으로 Job, Dispatcher 로 구성되어 있음
- CoroutineContext는 내부적으로 4개의 메소드를 가짐
- [CoroutineContext] 를 구성하는 Element
  - CoroutineId
  - CoroutineName
  - CoroutineDispatcher
  - CoroutineIntercepter
  - CoroutineExceptionHandler
    - 이 요소들은 Element 인터페이스를 구현하고 있음
    - 각각의 키를 기반으로 CoroutineContext에 등록 가능
  - plus 메서드 사용을 통해 각각의 Element를 + 로 매핑 가능, 이 병합된 Context는 CombinedContext를 생성
    - ex. launch(B + C)
- [Dispatcher]
  - 스레드에 코루틴을 보냄 => 코루틴에서는 스레드 풀을 생성, Dispatcher를 통해 코루틴을 배분
  - 코루틴을 Dispatcher에 전송하면 Dispatcher는 자신이 관리하는 스레드풀 내의 스레드의 부하 상황에 맞춰 코루틴을 배분
  - 상세 스텝
    - 유저가 코루틴을 생성 후 디스패쳐에 전송
    - 디스패처는 자신이 잡고 있는 스레드 풀에서 자원이 남는 스레드가 어떤 스레드인지 확인한 후 해당 스레드에 코루틴을 전송
    - 분배받은 스레드는 해당 코루틴을 수행
  - 코루틴은 스레드 풀을 만들지만 직접 스레드 풀을 제어하지 않음 (디스패쳐를 통해 제어 / 스레드 풀 제어는 모두 디스패처에게 위임)
    - 디스패쳐에 코루틴을 보내기만 하면, 디스패쳐는 스레드에 코루틴을 분산시킴  
  - 안드로이드 특이사항
    - 안드로이드에는 이미 디스패쳐가 생성되어 있어서 별도로 생성 / 정의할 필요 없음
    - Main (UI), IO (파일 / 네트워크), Default (CPU 부하가 있는 작업을 기본 스레드 외부에서 실행, 정렬 또는 JSON 파싱) 존재
  - ContinuationInterceptor 인터페이스를 구현하고 있고 이 인터페이스가 CoroutineContext의 Element
  - Default, Main, Unconfined, IO 디스패처 존재
  - launch 파라미터로 Dispatcher 넣는 것 가능, launch 외에도 async, withContext 등 다른 빌더에서도 사용 가능 (CoroutineContext를 구성하는 Element에 디스패쳐도 포홤되기 때문)
    - Dispatcher 없는 경우: 부모 컨텍스트 상속하여 수행, runBlocking 컨텍스트에서 수행
    - [Default]: DefaultDispatcher에서 수행, 메인이 아닌 워커 스레드를 통해 동작, 코어 수에 비례하는 쓰레드 풀에서 수행
      - DefaultDispatcher-worker-1
    - [IO]: DefaultDispatcher에서 수행, 워커 스레드를 통해 동작, 코어 수보다 훨씬 많은 스레드를 갖는 쓰레드 풀에서 수행
      - DefaultDispatcher-worker-1
      - Default, IO는 워커 스레드를 사용하지만 얼마만큼 스레드를 생성할 지에 대한 정책적인 차이가 있음
      - Default는 IO 보다 더 복잡한 연산 수행 가능 (JSON 파싱 / 정렬) - 여러 개의 스레드를 만들면 효율적이지 않음
      - (중요) IO는 CPU 소모가 덜 한 연산에 적합 (파일 / 네트워크, 스레드를 여러 개 만들더라도 영향이 크지 않음)
    - [Unconfined]: 메인 스레드에서 동작, 부모가 메인에서 동작하면 메인에서 수행, 어떤 스레드에서 실행될 지는 예측 불가능
      - 한번 suspension point에 오면 스레드가 바뀌게 될 수 있음, 사용 지양
    - [Main]: 메인 스레드에서 코루틴 실행, 뷰와 상호작용하는 작업 실행할 때 사용
      - main @coroutine#2
    - [newSingleThreadContext]: 항상 새로운 스레드 생성
      - KooThread @coroutine#6
      - 생성한 스레드 이름 명시 가능
  - Dispatcher는 async, withContext와 같은 코루틴 빌더에서도 사용 가능
  - launch 때 CoroutineContext를 명시하지 않는 경우엔 EmptyCoroutineContext 가 적용

#### 코루틴 - 부모가 있는 Job과 없는 Job 설명

- 코루틴 스코프, 코루틴 컨텍스트는 구조화되어 있고 부모에게 계층적으로 구성
- 코루틴 컨텍스트의 Job 또한 부모에게 의존적
- 만약 코루틴 빌더에서 Job을 새로 생성하면 그 Job은 누가 부모인지 모르는 새로운 Job이 되며 코루틴 구조적인 특성을 지니지 않게 됨 (부모는 해당하는 자식을 기다리지 않음)

#### 코루틴 엘리먼트 결합

- 여러 코루틴 엘리먼트 (컨텍스트 엘리멘트)를 한번에 결합하여 사용 가능 (+ 연산 사용)
- 기본적으로 부모 컨텍스트와 자식 컨텍스트는 합쳐짐
- 사용법 예
  - launch (Dispatchers.IO + CoroutineName("TestThread"))
  - 조회할 때: coroutineContext[CoroutineDispatcher] / coroutineContext[CoroutineName] 사용

#### Kotlin Data Class / Sealed Class

- Data Class
  - toString() / hashCode() / equals() / copy() 메소드를 자동으로 생성
    - 오버라이딩하면 직접 구현한 코드 사용 가능
  - 1개 이상의 프로퍼티가 있어야 함
  - 데이터 클래스는 abstract, open, sealed, inner 붙이는 것이 불가능
  - 상속 불가능
  - 사용 예
    - val testObj = TestObj("tester", 10)
    - testObj.copy(age = 3) <= 일부 프로퍼티만 바꾼 객체를 얻고 싶을 때 사용
- Sealed Class
  - 추상 클래스, 상속받은 자식 클래스의 종류를 제한
  - 컴파일러가 sealed 클래스의 자식 클래스가 어떤 것인지 인지
  - when과 함께 쓰일 때 장점 부각
  - 실 사용 예
    - 에러 케이스 체킹
    - 리사이클러뷰에서 뷰타입 체킹
  - abstract class 와의 차이점
    - abstract class Test를 상속한 A, B, C가 있다고 가정
    - val test: Test = A()
    - when(test) { is TestObj1 -> "1" is TestObj2 -> "2" else -> "None" }
    - 컴파일러는 Test가 어떤 자식들을 가지고 있는 지 알 수 없으므로 when 문을 사용할 때 else 문이 반드시 필요
    - sealed class 를 사용하면 else 문 불필요 (else 라는 모호한 부분 사용을 안해도 됨)
    - 컴파일러가 sealed class의 자식을 인지하고 있으므로 구현되지 않은 when case 문이 있으면 컴파일 오류가 발생하고 else 문은 제거 가능

#### callbackFlow

- Flow라기 보다는 Flow 빌더라고 이해하는 것이 좋은 방향
- callback을 flow로 변경
  - 여타 라이브러리들이나 SDK들이 콜백으로 응답을 주는 경우가 많기 때문에 이를 중간에서 Flow로 변환하기 위해 사용
- callbackFlow에 전달되는 block은 ProducerScope
  - 즉, 내부적으로 Channel을 생성한다는 의미, block은 CallbackFlowBuilder()의 인자로서 들어감
  - buffer는 기본값 사용 (64개)
  - BufferOverflow.SUSPEND 옵션에 따라 Channel에 쌓여진 데이터가 64개가 넘어가면 suspending 되어 send가 block됨
- callbackFlow로 생성되는 CoroutineScope는 ProducerScope이므로 기본적인 Channel API를 사용하여 데이터의 방출을 처리
  - trySend() 이용한 성공과 실패일 때 각각 데이터를 전달하도록 처리의 예
  - trySend()는 코루틴 1.5.0부터 offer 를 대신하는 API, buffer가 꽉 찬 상태에서는 false 리턴

#### Coroutine - Dispatchers.Main, Dispatchers.Main.immediate

- 호출 순서를 보장해야 할 경우에는 Dispatchers.Main.immediate 사용
- Dispatchers.Main은 단순히 Context Switching에서 필요할 경우 사용
  - Dispatchers.IO를 사용하는 경우 CoroutineScope 내에서는 withContext를 사용하여 Context Switching이 가능한데 이 때 withContext(Dispatchers.Main)을 사용하나 withContext(Dispatchers.Main.immediate)을 사용하나 결과는 동일하므로 이런 단순 스위칭의 상황에서는 그냥 Dispatchers.Main 사용하면 됨
- lifecycleScope을 사용하면 Dispatchers.Main.immediate를 사용했을 때와 동일 결과 출력됨
  - Lifecycle.kt 파일 참고 시 LifecycleScope는 Dispatchers.Main.immediate에 묶여 있다고 설명되어 있음
- 결론
  - LifecycleScope를 사용하던지 Dispatchers.Main.immediate를 사용해서 코드의 순차적인 호출을 보장하는 방향 지향

#### 코루틴 사용 이유

- 동시성, 비동기, 병렬성
  - 동시성 없이는 사용성 불편 => 과거 IO 작업할 때 IO 작업 중에는 아무런 작업도 할 수가 없었음
  - 동시성이 없다면 하드웨어 측면에서도 낭비
- 코루틴
  - 비동기와 병렬성을 순차적으로 짤 수 있는 코드 방법 제공, 순차적인게 맞는 부분은 코루틴을 사용
- Flow
  - 비동기와 병렬성을 스트림의 형태로 풀 수 있는 형태를 보여줌
- 과거 방식 문제점
  - 콜백 사용 시 코드 Depth 문제 (콜백 => 콜백 응답 분기 => 분기에 따른 또 다른 콜백 => ...)
  - Rx 사용 시 무조건 데이터를 스트림화해야 하는 문제
- 참고. 
  - bps (초당 전송될 수 있는 비트), mips 단위, 1mips = 초당 100만개 명령어 처리 가능
  - 비선점형 멀티태스킹, 선점형 멀티태스킹 (도구: 프로세스, 스레드 / 중재자를 두는 개념 (운영체제)) - OS는 1개 이상의 프로세스를 시분할에 의해 번갈아서 동작 시킴
    - 참고. 프로세스: 코드, 데이터, 힙, 스택 등의 자료구조 가짐
    - 참고. 스레드: 프로세스는 1개 이상의 스레드를 가지며 시분할에 의해 번갈아서 동작
  - SMP (Symmetric Multiprocessor)와 가시성
  - 지금 현재 우리가 사용하는 프로세서는 명령을 주면 순서대로 수행하지 않음
    - 아웃 오브 오더 방식
    - 명령어의 순서를 바꿔서 효율을 내는 방식

#### 코루틴 기초 설명

- 코루틴 빌더 (함수)
  - 코루틴을 만드는 함수
- runBlocking 
  - 코루틴 빌더의 수신객체는 코루틴
  - 수신객체는 extension 람다
  - 코드블럭이 마치 코루틴을 확장한 것처럼 사용할 수 있는 개념 <== 이 말은 즉, 이 코드 블럭에서 코루틴의 모든 기능들을 사용할 수 있다는 의미
  - 코루틴을 만들고 코드 블록 수행이 끝날 때까지 runBlocking 다음의 코드를 수행하지 못하게 막음 (Blocking)
  - 참고. 코루틴 블록 내에서 스레드 이름 출력 방법
    - Thread.currentThread().name
  - 참고. 일반적으로 함수는 중괄호가 있는 형태이나 함수 안에 단 한줄밖에 없다면 Expression 바디 타입으로 지정해서 코드를 간결화 시키는 것이 가능
    - 예. test() = runBlocking { }
  - BlockingCoroutine은 CoroutineScope의 자식, 코틀린 코루틴을 사용하는 모든 곳에는 코루틴 스코프 (CoroutineScope)가 있음. 
- 중요: 
  - 코루틴의 시작은 코루틴 스코프
- CoroutineContext
  - 코루틴 스코프는 코루틴을 처리하기 위해서 필요 정보를 가지고 있는데 이를 코루틴 컨텍스트라 함
- launch 코루틴 빌더
  - runBlocking이 메인 스레드를 수행하고 있다면 runBlocking 안에 있는 launch 빌더는 runBlocking이 끝날 때까지 기다림
  - runBlocking 내 코드 수행 => launch block 내 코드 수행
- delay: 양보의 개념으로 이해, suspension point (중단점)
- 코루틴이 단일 스레드만 사용한다고 해도 서로 양보하면서 로직을 수행하므로 유용
- sleep과 delay의 차이
  - delay는 양보
    - 현재 스레드를 다른 코드가 수행할 수 있도록 양보를 하는 형태로 되어 있음
  - sleep은 양보하지 않음
    - sleep은 잠시 쉴뿐 다른 코드에게 스레드를 넘겨주지 않음
  - 참고. delay도 역시 suspend function
- 상위 코루틴은 하위 코루틴을 책임짐 (계층적, 구조적)
  - 하위 코루틴이 모두 다 끝날때까지 기다림 즉, 상위 코루틴 바로 아래 코드는 상위 코루틴이 완료되어야만 호출됨
  - 상위 코루틴을 Cancel하면 하위 코루틴도 같이 Cancel 됨
  - runBlocking 밖의 바로 아래 코드는 runBlocking과 그안의 launch 블록이 다 수행이 되어야만 수행됨
- suspend 함수 (중단 가능한 함수라는 뜻)
  - delay는 코루틴이나 suspend 함수 안에서만 사용 가능
  - 코루틴 내부가 복잡할 때 suspend 함수로 로직을 나눠서 유지보수가 용이하게 만드는 작업 필요
  - suspend 함수 리턴값이 없는 경우 코틀린은 알아서 리턴 타입이 Unit 임을 인지
  - 함수 진입 입구와 출구가 여러개
  - 스레드를 블러킹하는 것이 아닌 suspend 처리함.
- runBlocking<Int>의 형식으로 반환값 지정도 가능, 반환값이 없다면 <Unit>
- runCatching
  - Kotlin 1.3 부터 제공하는 API
  - 사용 예
    - runCatching {}.onSuccess s{}.onFailure {e -> }.also { Log.d("tag", "xxx")}
    - runCatching { value ?: throw NullPointerException("Value is NULL")}.mapCatching { "Value is $value}.recoverCatching { e -> when(e) { is NullPointerException -> "good" else -> throw e}}.onSuccess {}.onFailure { e -> }

#### 코루틴 추가 기초 내용

- suspend fun 내 launch 사용 불가능
  - launch는 코루틴 안에서만 사용 가능, 만약 사용하고 싶다면 launch 밖에 코루틴 정의를 해야 사용 가능
  - suspend fun 은 중단 가능한 함수 / 잠들 수 있는 함수 (suspension point) 라는 뜻일 뿐이고 코루틴 함수 즉, delay와 같은 함수는 사용 가능하나 launch 코루틴 사용은 불가능
  - coroutineScope expression 사용해서 launch 사용 가능하게 하는 방법 존재 (coroutineScope 는 코루틴 빌더를 수행하기 위해 존재)
- 참고.
  - 10만개의 코루틴 생성 시 스레드를 10만개 생성하지 않고 양보의 개념으로 동작
    - 코루틴은 협력적으로 동작하기 때문에 여러 코루틴을 만드는 것이 큰 비용이 들지 않음

#### runBlocking 과 CoroutineScope 간 차이점

- runBlocking, withContext는 현재 쓰레드를 멈추게 만들고 기다림
- coroutineScope는 현재 스레드를 멈추게 하지 않고 호출한 쪽이 suspend 되고 시간이 되면 다시 활동함

#### 코루틴 - Job을 이용한 제어

- 코루틴 빌더 launch 는 Job 객체를 반환하며 이를 통해 종료될 때까지 기다릴 수 있음
  - 예. val job = launch { }
  - 예. job.join() <= join은 기다리게 하는 것 (suspension point)
    - join한 job은 잠시 중단되고 잠에서 깨어나면 그 다음 코루틴 빌더가 수행됨 (양보가 가능한 delay가 있다 하더라도 아래 빌더들은 수행이 끝날 때까지 기다림)
    - join이 된 시점 부터는 기다린다라고 이해
- 여기서도 부모 코루틴은 자식 코루틴이 끝날 때까지 기다림

#### 코루틴 - 취소와 타임아웃

- 취소
  - job.cancel
  - ex. var job = launch {} / job.cancel()
- 취소 + Join
  - job.cancel()
  - job.join() <= 취소에 시간이 걸리는 경우에도 코루틴을 기다림
    - job.cancelAndJoin() 으로 대체 가능
- 취소가 불가능한 코루틴 로직을 취소 가능하게 만드는 방법
  - 코루틴 로직 내 while 등의 루프가 있는 경우 취소되지 않음
  - 실제 루프 로직 내 isActive 사용하면 취소 가능
    - ex. while (i <= 10 && isActive) {}
- 취소를 할 때 자원 해제를 해야 하는 경우
  - suspend 함수들은 취소가 되었을 때 jobCancellationException을 발생시키기 때문에 표준 try catch finally로 대응 가능
- 취소 불가능한 블록 설정
  - launch { withContext(NonCancellable) { } }
  - finally 절 수행 중에도 취소가 될 수 있기 때문에 finally 블럭 안에서도 withContext(Noncancellable){} 사용 가능
- 타임아웃
  - withTimeout()
    - ex. runBlocking { withTimeout(500L) { }}
    - TimeoutCancellationException 발생
  - withTimeoutOrNull
    - try, catch 문 사용 없이 예외처리 가능
    - ex. val result = withTimeoutOrNull(500L) {} ?: false
    - println(result)

#### 코루틴 서스펜딩 함수 활용

- measureTimeMillis
  - block을 실행하는데 소요된 시간을 Long 형식으로 반환
- async 코루틴
  - 동시에 다른 블록 수행 가능하며 await 키워드를 통해 결과를 받을 수 있음 (동시에 수행한다는 점이 중요)
    - 예. runBlocking 블럭안에서 suspend 함수 2개를 단순히 순차적으로 호출하는 것과 async 사용하여 호출하는 경우 퍼포먼스 차이가 나타남 (전자: 2초, 후자: 1초)
    - 결과를 받아야 한다면 async, 결과를 받지 않아도 된다면 launch 선택 가능
  - await를 만나면 async 블록이 끝났는지 확인하고 아직 진행 중이면 suspend 되었다가 나중에 다시 깨어나고 반환값을 받아옴
  - this: 코루틴
  - await: job.join() + 결과도 가져옴
  - 늦게 수행되었으면 할때?
    - val value = async(start = CoroutineStart.LAZY)는 코루틴이 만들어는 지지만 수행 예약까지는 이루어지지 않음
    - value.start()를 해줘야 수행 예약 즉, 수행 처리를 위한 큐에 쌓이게 됨 (큐에 수행 예약을 함)
- async를 사용한 구조적인 동시성
  - 코드 수행하다 보면 예외 발생할 수 있음. 예외가 발생하면 위쪽과 아래쪽 코루틴 스코프가 취소됨 (부모, 자식에게 전파)
  - async 1, 2가 있을 때 2에서 예외 발생 시 1도 취소됨

#### 코루틴 trySendBlocking

- send와 유사, 일시중단 대신에 블로킹 처리
- suspend 함수가 아닌 일반 함수에 사용 가능
- sendBlocking은 채널이 닫혔거나 더 일반적으로 취소된 경우 예외 발생하고 non-blocking 코드의 취소 예외는 예상치 못한 것이며 자주 내부 오류를 유발
  - 위의 오류를 잡아주도록 개발된 코드가 trySendBlocking

#### 코루틴 Basic 재정리

- 어느 한 스레드에 종속되지 않고 이리저리 옮겨다니면서 실행되는 suspend 기능을 갖춘 인스턴스
- launch 는 코루틴을 생성하는 빌더. 코드 블록 내에서 launch 블록은 독립적으로 동작
- runBlocking은 coroutine 블록이 아닌 공간에 코루틴이 동작하는 다리 역할을 하는 코루틴 빌더
- runBlocking은 비용 문제가 있음. 주로 어플리케이션 Top Level에서 주로 사용 가능하며 코드 내부에서 사용하는 것은 지양
- suspend function은 코루틴 블록 내에서 동작하며 다른 suspend 함수 사용 가능
- runBlocking 함수는 작업이 끝날 때까지 현재 스레드를 Blocking 함
- coroutineScope는 다른 사용을 위해 스레드를 Blocking 하지 않고 단지 suspend만 시키므로 coroutineScope는 suspending function의 어디에서든 사용 가능
- coroutineScop 안에서 launch 된 것은 동시에 실행됨
- launch block은 Job을 반환하며 외부에서 이를 호출 가능
- 코루틴은 경량 쓰레드이므로 다수의 코루틴 Block을 launch해도 문제 없음

#### CEH, Coroutine Exception Handler 개념 (더 스터디하고 개념 정리 필요)

- exception을 핸들링할 때 기본적으로 수행해야 하는 로직들을 처리하기에 수월함
- 예외가 전파되는 것을 막지는 않으나 예외 발생했을 때 수행해야 할 로직들을 설정 가능 (로깅 등)
- 보통 CoroutineExceptionHandler + SupervisorJob 조합으로 예외 전파를 막고 로깅을 하는 방법을 사용
- Exception Propagation
  - 코루틴 빌더들은 예외 처리 방식에 따라 2가지 타입으로 나뉨 (전파와 노출의 차이)
    - Exception을 외부로 전파 (Propagation): launch, actor
    - Exception 노출: async, produce
- launch의 경우 exception이 발생하면 바로 예외 발생
- async의 경우 exception이 있더라도 실제로 exception이 발생되는 부분은 await()를 만날 때임
- 전파와 노출 둘 다 콘솔에 exception 발생, 이를 방지하기 위해 CoroutineExceptionHandler를 이용하여 코루틴 내부의 기본 catch block으로 사용 가능
  - Java 스레드에 사용하는 Thread.defaultUncaughtExceptionHandler 와 유사
  - 참고. 안드로이드에서는 기본으로 uncaughtExceptionPreHandler가 코루틴의 exception 처리를 할 수 있도록 설정되어 있음

#### CEH (Coroutine Exceptio Handler), Supervisor Job 설명

- GlobalScope
  - 어디에도 속하지 않는 스코프, 전역 스코프
  - 계층적으로 관리되지 않고 글로벌 스코프 자체에서 수행됨
  - 사용이 간편하나 관리가 어려움
  - 예. GlobalScope.launch(Dispatchers.IO)
- CoroutineScope
  - 권장 사항
  - 하나의 코루틴 컨텍스트를 인자로 받음
    - 예. CoroutineScope(Dispatchers.Default + CoroutineName("Scope"))
- CEH (코루틴 익셉션 핸들러)
  - 체계적인 예외 핸들링을 위한 방법 (로깅, 팝업 표시 등)
    - 매번 해당 부분에 try-catch를 코딩하는 것은 비효율적
  - CEH를 만든 다음 상위 코루틴 빌더의 컨텍스트에 핸들러를 등록
  - CEH 정의
    - val ceh = CoroutineExceptionHandler { _, exception -> println("error happend: $exception") }
  - CEH 적용 및 실행 코드
    - val scope = CoroutineScope(Dispatchers.IO)
    - val job = scope.launch(ceh) { launch {} }
- CEH와 runBlocking
  - runBlocking에서는 CEH 사용 불가능
  - runBlocking은 자식이 예외로 종료되면 항상 종료되고 CEH를 호출하지 않음
- SupervisorJob
  - 예외에 의한 Cancel을 아래쪽으로만 전파
  - CEH와 컴비네이션
    - val scope = CoroutineScope(Dispatchers.IO + SupervisorJob() + ceh)
  - joinAll(job1, job2)과 같이 여러 조인 로직을 하나로 합칠 수 있음
- supervisorScope
  - suspend function에 쉽게 붙여서 사용 가능
  - supervisorScope를 가지는 suspend 함수 내의 코루틴 빌더에서는 반드시 CEH가 등록되어 있어야 하거나 try-catch 블럭을 필수적으로 구현해줘야 함
    - 등록되어 있지 않으면 에러 발생
    - supervisorScope 에서 에러 발생 시 에러를 처리하지 않으면 외부에 에러를 전파하게 됨

#### 공유 객체 문제

- 사전 지식
  - withContext: 수행이 완료될 때까지 기다리는 코루틴 빌더
  - 예제
    - runBlocking { withContext(Dispatchers.Default) {}}
      - withContext 빌더가 실행되면 runBlocking 블럭은 잠이 들게 되고 withContext 빌더 수행이 완료가 되면 runBlocking 블럭 내용이 다시 수행되는 구조
  - withContext와 runBlocking 차이점
    - withContext는 바깥의 코루틴을 잠들게 함
    - runBlocking은 블럭 내용 수행될 때까지 스레드 자체를 잡고 있음
- 동시성 문제 해결
  - 1. [volatile]: 가시성을 제공해주는 어노테이션 (@Volatile)
    - 가시성이라는 것은 한쪽에서 수정했을 때 다른쪽에서 그 값을 제대로 볼 수 있는 것을 의미
    - 동시에 읽고 수정해서 생기는 문제는 해결하지 못함
  - 2. 스레드 안전한 자료구조 사용 방법 ([AtomicInteger])
    - incrementAndGet() 함수 이용
  - 3. 스레드 한정 ([newSingleThreadContext])
    - 스레드를 생성해서 연산을 할 때 그 스레드만 사용하게 하는 방법
    - 예. val counterContext = newSingleThreadContext("CounterContext")
    - 예. withContext(counterContext) { counter++ }
  - 4. 액터 사용
  
#### 뮤텍스 (Mutual exclusion)

- 상호배제
- 공유 상태를 수정할 때 Critical Section을 이용하게 하며, 임계 영역을 동시에 접근하는 것을 허용치 않음
- 사용법 (Mutex Block 사용)
  - val mutex = Mutex()
  - mutex.withLock { counter++ }

#### 액터 (Actor)

- Actor가 독점적으로 자료를 가지며 그 자료를 다른 코루틴과 공유하지 않고 액터를 통해서만 접근하게 만드는 것
- 구현 순서
  - sealed class 생성 (sealed class CounterMsg)
  - 값 변경을 위한 object 정의 (object IncCounter: CounterMsg())
  - 값을 읽어올 때 사용할 GetCounter 정의 (Deferred 오브젝트 response 인자 사용)
  - Actor 내에서는 channel을 사용하여 신호를 받음

#### Flow

- 코루틴으로 만들어진 코틀린에서 사용할 수 있는 [비동기스트림]
- 반환 타입은 Flow<Type>
- [emit]: 값을 흘려보낸다는 의미
- flow 빌더 함수
  - 코드 블록 구성하고 emit을 호출해서 스트림에 데이터를 흘려보냄 (플로우 빌더 함수를 이용해서 플로우를 생성)
- flow는 Cold Stream 이기 때문에 요청하는 사이드에서 collect를 호출해야 값을 emit 하기 시작
  - 참고
    - Cold Stream: 요청이 있는 경우에 보통 1:1로 값 전달하기 시작
    - Hot Stream: 0개 이상의 상대를 향해 지속적으로 값 전달
- withTimeoutOrNull 활용한 취소 처리 가능
  - withTimeoutOrNull(500L) { flowObj {} }
  - 500 밀리세컨드 이상이 되었을 때 타임아웃 발생
- [플로우-빌더] (플로우를 실제로 생성)
  - 코드 블록을 가지고 있음
  - collect 블록 내 기본 인자는 it
    - it을 그대로 사용한다면 value -> 와 같이 사용할 필요 없음
  - [flowOf], [flow{}] - 아래 2가지는 동일
    - flowOf(1,2,3).collect( value -> println(value))
    - flow { emit(1), emit(2), emit(3)}.collect { println(it)}
  - [asFlow]
    - Collection 이나 시퀀스를 전달해 플로우 생성 가능
    - 내부적으로는 forEach로 아이템들을 emit해 줌
    - listOf(1,2,3).asFlow().collect(value -> println(value))
    - (6..10).asFlow().collect { println(it)}

#### Flow 연산

- 플로우와 [맵(map)]
  - 데이터 가공
  - 예제: flow{}.map{}.collect{}
- [filter]
  - 조건에 맞는 데이터만 남김
  - 예제: (1..20).asFlow().filter { it % 2 == 0}.collect{ }
  - filter 블럭 안에 들어가는 내용을 술어 또는 predicate라 일컬음
- [filterNot]
  - 술어 즉 predicate 로직을 그대로 남겨 두고 싶을 때, 반대의 값을 필터하고 싶을 때 사용
  - 예제: (1..20).asFlow{}.filterNot{}.collect{}
- [transform]
  - 중간 연산자(map, filter)같이 단순한 변환보다 복잡한 변환 처리를 위한 연산자
  - map은 요소마다 1개의 변환만이 가능하나 transform은 emit()을 추가하여 요소마다 여러 개의 변환을 가능케 만들어 줌
- [take]
  - 몇 개의 수행 결과만 취함
  - 예제: 100개를 방출하는 플로우에서 take(5).collect{} 와 같이 구현하면 5개의 값만 가져옴
- [takeWhile]
  - 조건을 만족하는 동안만 값을 가져옴
  - 예제: flow{}.takeWhile{it < 15}.collect{}
- [drop]
  - 처음 몇 개의 결과를 버림 (take와 반대 기능), [dropWhile] 연산자도 존재
- [reduce]
  - 참고
    - collect, reduce, fold, toList, toSet, count와 같은 연산자는 플로우를 끝내는 종단 연산자 (terminal operator)
      - 특정 값이나 컬렉션 등의 결과 리턴
      - 반면, 중간 연산자는 결과 리턴 X, collect를 사용해서 결과를 가져와야지만 이용 가능 
    - reduce는 함수형 언어의 오래된 메커니즘
    - 첫번째 값을 결과에 넣은 후 각 값을 가져와 누진적으로 계산
    - 예제
      - (1..10).asFlow().reduce {a,b -> a+b}
      - 누진적 계산 과정
        - a:1, b:2 => 3 => a = 3
        - a:3, b:3 => 6 => a = 6
        - a:6, b:4 => 10 => a = 10
        - a:10, b:5 => 15 => a = 15
        - a:15, b:6 => 21 => a = 21
        - a:21, b:7 => 28 => a = 28
        - a:28, b:8 => 36 => a = 36
        - a:36, b:9 => 45 => a = 45
        - a:45, b:10 => 55 => a = 55
        - ... 이런식으로 계산이 진행되어 최종적으로 1~10까지 합인 55가 출력됨
- [fold]
  - reduce와 유사하나 초기값이 있음
  - 예제
    - (1..10).asFlow().fold(10) {a,b -> a + b}
    - 초기값 10이 더 추가된 65가 반환
- [count]
  - 종단 연산자 (terminal operator)
  - 술어를 만족하는 자료의 개수를 반환
  - 예제: (1..10).asFlow().filter {(it % 2 == 0)}.count()

#### 플로우 컨텍스트

- 플로우는 기본적으로 코루틴의 컨텍스트에서 호출됨
- 다른 컨텍스트로의 이동 불가능, 플로우 내에서는 컨텍스트 변경 불가능
  - 예제
    - 메인에서 Dispatchers.IO 로 플로우 수집 후 실제 플로우 내에서 withContext(Dispatchers.Default) 설정하는 경우 에러 발생

#### flowOn 연산자

- flowOn을 통해 컨텍스트 변경 가능
- flowOn 기준으로 위쪽은 업스트림, 아래쪽은 다운스트림 (상대적 기준)
  - 자신을 기준으로 위에서 흘러들어오는 스트림을 업스트림, 아래로 흘러내려가는 스트림을 다운스트림
- flowOn(Dispatchers.Default) 라고 설정을 했다면 업스트림은 Default 디스패쳐로 동작하게 됨
  - context() 오퍼레이터는 자신보다 위의 연산자들 업스트림에만 영향을 줌
- 만약 스트림에 따라 각각 다른 디스패쳐를 사용하고 싶다면 flowOn을 여러 개 붙일 수 있음

#### 플로우 버퍼 (buffer(), 모든 데이터 처리)

- buffer() 로 버퍼를 추가해 보내는 측이 더 이상 기다리지 않게 됨
  - 데이터를 보내는 쪽과 받는 쪽 둘다 작업이 오래 걸린다면 그 두개의 시간을 합한 만큼 시간이 소요됨
  - buffer()를 붙이게 되면 collect 쪽에 준비 여부에 관계없이 계속 데이터를 보낼 수 있음 (emit 할 수 있음)

#### conflate (중간 처리값 무시)

- conflate: 융합?
- 처리보다 빨리 발생한 데이터의 중간 값들을 누락시킴
- 처리 부분(수집 측)에서 처리하지 못하는 값들 (딜레이나 작업 시간 소요로 인한)은 누락시킴

#### collectLatest (마지막 값만 처리) *

- 값을 처리하는 과정에 새 값이 들어오면 이전에 처리하던 내용들을 다 없애버리고 새 값을 처리 (마지막 값만 처리)
- 바뀐 값을 바로 화면에 표시해줘야 하는 경우에 사용
- 제공된 작업으로 지정된 flow를 수집하는 말단 flow 연산자
- collect와의 차이점: flow가 새 값을 내보내면 이전 값에 대한 작업 블록이 취소된다는 것

#### 2개의 flow 묶는 방법

- [zip]
  - 양쪽의 데이터를 한꺼번에 묶어 새로운 데이터를 생성
    - 예제: 플로우1.zip(플로우2) { 플로우1값, 플로우값 -> "" }
  - zip은 두개의 데이터가 동시에 준비가 된 상태일 때 사용
- [combine]
  - 양쪽의 데이터를 같은 시점에 묶지 않고 한 쪽이 갱신되면 새로 묶어서 데이터를 생성
  - 최신의 데이터가 중요한 경우에 사용
  - 하나의 UI가 있고 여러 데이터가 존재할 때 데이터가 업데이트 될 때마다 UI 갱신이 필요하다면 combine 사용을 권장

#### onEach

- 주어진 action 즉, 주어진 suspend 함수 (블록)를 실행하는 플로우를 반환
  - 예제: (1..3).asFlow().onEach { delay(100L) }
- addEventListener 대신 플로우의 onEach를 사용 가능 (이벤트마다 onEach가 대응)
- collect()가 호출되기 전에는 동작하지 않음

#### 생명주기 기반 컴포넌트 - DefaultLifecycleObserver

- 구성요소
  - Owner: Activity / Fragment
  - Observer: Activity / Fragment의 생명주기 처리를 담당
- 보통 DefaultLifecycleObserver 또는 LifecycleEventObserver 사용
- DefaultLifeCycleObserver
  - LifecycleEventObserver와 DefaultLifecycleObserver 모두 구현했다면 DefaultLifecycleObserver의 메소드들이 먼저 호출되고 그 다음에 LifecycleEventObserver.onStateChanged의 호출이 이루어짐

#### Flow 플래트닝 **

- 묶음을 풀어낸다는 뉘앙스로 이해 (리스트 덩어리를 각각 아이템의 나열로 표현)
- (참고) 플래트닝: 리스트가 있다면 그안의 모든 아이템들을 하나하나씩 꺼내어 풀어내는 (나열하는) 것
- [flatMapConcat]
  - 블록 호출한 결과 (flow)를 합침
  - 이어 붙인다는 의미, 첫 요소의 작업이 끝날 때까지 기다림
- [flatMapMerge]
  - 첫 요소의 플래트닝을 시작하고 바로 이어 다음 요소의 플래트닝을 시작
  - 플래트닝이 끝나기 전에 다음 플래트닝을 시작해서 결과를 머지해서 하나로 만들어냄
  - 첫 요소의 작업이 끝날 때까지 기다리지 않음
  - 예제
    - (1..3).asFlow().onEach {delay(100)}.flatMapMerge { requestFlow(it) }
- [flatMapLatest] *
  - 다음 요소의 플래트닝을 시작하며 이전에 진행 중이었던 플래트닝 작업을 취소
  - 플래트닝 중에 다른 플래트닝 작업이 생기면 이전의 플래트닝을 취소하고 마지막만 남김
  - Flow 값이 바뀔 때마다 새 Flow를 만들고 이전 flow의 작업을 취소
  - 예로 키워드 검색 등이 있음, 검색어가 바뀌면 이전 쿼리를 사용한 데이터 요청을 취소하고 새 검색어에 대한 데이터 요청을 시작해야 하므로 flatMapLatest를 사용하면 적절함

#### flow 예외처리

- 수집기 측에서 예외처리 ([try-catch])
  - 참고. 블럭 내 check 함수로 앱 예외 발생 처리 가능
  - flow 안에서 발생한 에러로 수집기에 구현된 try-catch로 예외 처리 가능
- [catch] 연산자 사용
  - 빌더 코드 블록 내에서 예외를 처리하는 것은 예외 투명성을 어기는 것
  - 플로우에서는 catch 연산자 이용이 권장됨
  - catch 블록에서 예외를 새로운 데이터로 만들어 emit 하거나 다시 예외를 던지거나 로그를 남기는 것이 가능
  - 예제
    - runBlocking { simple().catch { e -> emit("caught $e")}}.collect {}
- [catch-투명성]
  - catch 연산자는 catch 연산자를 쓰기 전의 코드 즉 업스트림에만 영향을 미치고 다운스트림에는 영향을 미치지 않음 <= catch 투명성

#### 플로우 완료 처리 (완료된 이후의 동작을 핸들링해야 할때)

- [try-finally] 블록 사용
- [onCompletion] 선언적으로 완료 처리
  - 예제: simple().onCompletion { println("complete")}
  - 예제2: simple().onCompletion { cause -> if (cause != null) { 문제로 인한 종료} else { 문제가 없음}}
  - 장점: 종료 처리할 때 예외가 발생되었는지에 대한 여부를 알 수 있음

#### collect() 사용한 플로우 런칭

- collect()는 지속적으로 들어오는 이벤트 처리에는 적합하지 않음
- collect()는 플로우가 끝날 때까지 계속 기다리며 기다리는 동안 그 아래에 있는 코드는 동작될 수 없음

#### launchIn 사용한 플로우 런칭

- 별도의 코루틴에서 플로우를 런칭, 새로운 코루틴을 생성
- 첫번째 인자로 코루틴 스코프를 설정
- 다른 코루틴에서 우리 이벤트를 감시할 로직을 동작시킴, 이벤트와 같이 상태가 바뀌는 것을 추적할 때 주로 사용
- 즉, 레거시 방법을 비추어봤을 때 별개의 스레드를 생성해서 그 안에서 동작하게 하는 개념

#### 코루틴 채널 개념

- [channel]
  - 파이프라인, 채널을 열고 한쪽에서 값을 보내면 다른 쪽에서 수신하는 개념
  - send, receive 하는 부분은 suspension point라 볼 수 있음
    - 송/수신할 데이터가 없는 경우에는 잠이 들었다가 유효한 데이터 발생 시 깨어나서 처리
    - (대체) trySend, tryReceive
    - (과거) offer, poll
      - 반환값을 null로 가지고 있어서 널 체크를 해서 성공이냐 실패를 판단했었음
    - send, receive가 suspension point이고 서로에게 의존적이기 때문에 같은 코루틴에서 사용하는 것은 지양 필요
    - 별도의 코루틴을 만들어서 각각의 코루틴이 서로 잠이 들어도 상대방의 실행에는 문제가 없게 코드 작성 필요
- [channel.close]
  - channel.receive() 불필요해짐
  - 데이터를 다 보냈으면 close 처리하고 receive 함수 호출 없이 채널을 사용하는 부분은 close가 되면 처리하지 않게 됨

#### 채널 프로듀서

- 생산자, 소비자 패턴
- 채널 이용해서 한 쪽에서 데이터를 만들고 다른 쪽에서 받는 것을 도와주는 [확장함수] 존재
- [사용법]
  - [produce] 코루틴 생성하여 채널 제공
  - [consumeEach] 채널에서 반복해서 데이터를 수집
- [ProducerScope] --> CoroutineScope (I) --> SendChannel (I)
  - 코루틴 컨텍스트 + 채널 인터페이스 같이 사용 가능한 스코프
  - produce를 사용하면 ProducerScope를 상속받은 ProducerCoroutine 코루틴을 얻게 됨
- [참고]
  - runBlocking --> BlockingCoroutine --> [AbstractCoroutine] --> JobSupport, Job(I), Continuation(I), CoroutineScope(I)
    - 코루틴 빌더는 코루틴을 생성 (코루틴 스코프이기도 함)
    - [Continuation]: 다음에 무엇을 할지
    - [Job]: 제어를 위한 정보와 제어
    - [CoroutineScope]: 컨텍스트 제공
    - [JobSupport]: 실제 Job 동작 관련 지원
- [예제]
  - val test = produce { channel.send(x) }
  - test.consumeEach { println(it) }

#### 채널 파이프라인

- 파이프라인: 일반적인 패턴
  - 하나의 스트림을 프로듀서가 만들고, 다른 코루틴에서 그 스트림을 읽어 새로운 스트림을 만드는 패턴
  - 예제
    - CoroutineScope 확장함수 정의 후 produce 사용하여 ProducerScope 생성 후 데이터 send
    - CoroutineScope 확장함수 하나 더 정의 후 send한 값들을 ReceiveChannel로 받게 정의하고 produce 사용하여 ProducerScope 생성 후 데이터 2차 send
      - ReceiveChannel 이라는 것은 receive()를 호출할 수 있다는 것을 의미
      - 그냥 Channel은 receive(), send() 둘 다 호출 가능
    - 수집 측에서 ReceiveChannel object의 receive() 활용하여 데이터 수집/로깅 처리
  - coroutineContext.cancelChildren() : 코루틴 취소

#### 코틀린 A to B (to)

- 튜플 타입인 Pair 생성
  - Pair<A, B> 
  - val map = mapOf(1 to "x", 2 to "y", 3 to "z")
  - testData1, testData2 -> testData1 to testData2
    - it.first / it.second

#### 코틀린 by 키워드 재정리

- delegate pattern 기반의 키워드
- delegate pattern은 많은 코드 유발 (보일러 플레이트 코드)
- 보일러 플레이트 코드없이 class delegate와 property delegate를 지원

#### 코틀린 vararg (가변 인자) 지원

- 가변 인자를 사용하면 함수를 호출할 때 인자 개수를 유동적으로 지정 가능
  - 내부적으로 배열로 처리하는 것으로 판단됨
- 이미 존재하는 배열을 vararg 함수 인자로 넘겨야할 때는 배열 변수 이름 앞에 *를 붙여주면 됨
  - val testArray = arrayOf("A", "B")
  - showAll(*testArray)
- vararg 파라미터가 제네릭 타입일 경우는 *을 생략해도 Array<out T> 타입은 인자로 수용 가능

#### 코틀린 in, out, where, relified, star projection

- [out] (covariance)
  - 공변성 사용
  - out 키워드가 사용된 변수는 Read-Only, 수정 불가능
- [in] (contravariance)
  - 반공변성 사용
  - 함수가 파라미터에 값을 설정할 수 있게 만들고 값을 읽을 수 없게 만듬
- [where]
  - 제네릭에서 하나의 제약 조건을 넣기 위해서는 파라미터 타입 뒤에 콜론(:)을 넣은 후 제약조건을 정의하면 되나 여러 개의 제약 조건을 넣을 때는 where 사용 필요
    - fun <T> useAndClose(input: T) where T: AutoCloseable, T: Appendable
- [reified]
  - 구체화된 타입 파라미터
  - 인라인 함수에서만 사용 가능
  - 인라인이므로 함수의 바디가 함수 호출하는 부분에서 확장되는데 확장될 때 타입 T는 컴파일 시간에 확인되는 실제 타입으로 대체됨
  - reified 타입 파라미터는 함수에 추가적인 클래스 정보를 전달하지 않도록 만들어주고 코드에서 캐스팅을 안전하게 하는 데 도움을 주고 컴파일 시간 안정성을 확보한 채로 리턴 타입을 커스터마이징 가능케 함
  - 대표 예시: listOf<T>(), mutableListOf<T>()
- [star-projection]
  - 파라미터 타입 정의 <*>
  - 제네릭 읽기전용 타입과 raw 타입을 위한 코틀린의 기능
  - 타입에 대해 정확히는 알 수 없지만 타입 안정성을 유지하면서 파라미터를 전달할 때 사용

#### 인라인 함수 정리

- 람다의 부가 비용 없애기의 목적
- 참고. 컴파일 시 람다의 경우 파라미터 개수에 따라 FunctionN 형태의 인터페이스로 변환이 됨
  - 일반 함수 구현에 비해 부가적인 비용 발생, 똑같은 작업을 하는 일반 함수보다 덜 효율적
- 인라인 키워드
  - 인라인 키워드를 붙이면 컴파일러는 그 함수를 호출하는 모든 문장을 함수 본문에 해당하는 바이트코드로 바꿔치기 해주기 때문에 오버헤드 감소시키는 것이 가능
  - 컴파일 단계에서 함수를 호출하는 코드 대신 함수 본문 코드 자체가 삽입되는 방식
  - 바이트코드 자체가 호출부로 바로 삽입되므로 더 이상 람다를 인터페이스로 구현하는 FunctionN 객체는 생기지 않음
  - 바이트코드에서 각 함수 호출 지점을 함수 본문으로 대치하기 때문에 코드 중복 발생
  - noinline 키워드
    - 모든 람다식에 인라인을 쓰고 싶지 않을 때 해당하는 람다식에 noinline 키워드 삽입하여 인라이닝 막는 것이 가능
  - 실 사용 예: 코틀린 filter, use 함수 (리소스 관리, close)
- 인라인 키워드 선언 필요 시점
  - 람다를 파라미터로 받는 함수의 경우
    - 함수 호출 비용 + 람다 표현 클래스 + 객체 생성이 불필요
    - JVM은 함수 호출과 람다를 인라이닝해 줄 정도로 뛰어나지 않음
    - 코드 크기가 큰 함수의 경우 오히려 더 성능을 악화시킬 수 있기 때문에 가급적이면 코드 크기가 작은 부분에만 인라인 함수 사용 지향
  - 참고 내용
    - 일반 함수 호출의 경우 JVM은 이미 인라이닝을 지원
    - JVM은 코드 실행을 분석해서 가장 유리한 방향으로 호출을 인라이닝 해줌
      - 바이트코드를 실제 기계어 코드로 번역하는 과정(JIT)에서 일어남

#### Non-Local 반환

- 자신을 둘러싸고 있는 블록보다 더 바깥에 있는 다른 블록을 반환하게 만든 return 문을 Non-local return
- return이 바깥쪽 함수를 반환시킬 수 있는 때는 함다를 인자로 받는 함수가 인라인 함수인 경우
  - 예: forEach, custom inline function
- 인라이닝되지 않는 함수에 전달되는 람다에서는 return 사용 불가능
- 가능한 리턴 방법
  - 레이블 사용한 리턴, 예: .forEach label@ .... return@label
  - 인라인 함수의 이름을 레이블로 사용한 리턴, 예: return@forEach
  - 무명 함수, 기본 return
    - 여러 곳에서 리턴을 해야 하는 경우 무명 함수 사용
    - 코드 블록을 함수에 넘길 때 사용할 수 있는 다른 방법
    - 일반 함수와의 차이점
      - 함수 이름 또는 파라미터 생략 가능
      - 반환 타입 지정 필요 (블록이 본문인 무명함수에 해당)

#### 타입 이레이저 개념

- 제네릭을 사용하면 컴파일러는 컴파일 시점에 제네릭에 대해서 type erasure 라는 프로세스 적용
- 타입을 소거하는 프로세스이며 컴파일이 끝난 이후에는 제네릭 타입의 정보를 알 수 없게 됨 (정보가 없어짐)
- 컴파일 시점에만 타입에 대한 제약 조건을 설정하고, 런타임에는 해당 정보를 소거하는 프로세스
- 제네릭이 도입되기 전 즉, JDK 1.5 이전의 소스 코드와의 호환성 유지를 위해 사용
  - 컴파일 후에도 타입 지정이 되어 있는 경우에는 하위 호환이 되지 않을 것임

#### 팬 아웃 / 팬 인

- 팬 아웃 (Fan out)
  - 여러 코루틴이 동시에 채널 구독 가능
  - launch { channel.consumeEach { } }
- 팬 인 (Fan in)
  - 반대로 생산자가 많은 것

#### 공정한 채널

- 두 개의 코루틴에서 채널을 서로 사용할 때 공정하게 기회를 배분

#### Select

- 먼저 끝나는 요청을 처리하는 것이 중요할 수 있는 데 이 경우에 select 사용 가능
- 먼저 끝내는 애만 듣겠다 라고 할 때 사용
- 채널 말고도 Job / Deferred 등에도 사용 가능
  - Deferred: Async가 반환하는 것이 Deferred

#### 채널 버퍼링

- 채널은 기본적으로 suspension point를 가지고 있고 send를 하면 받을 때 까지 잠이 들고 receive를 하면 데이터가 올 때까지 잠이 들게 됨
- 버퍼링 이용 시 자유롭게 보내고 받는 것 가능 (중단되지 않으면서 채널 사용 가능)
- Channel 생성자는 인자로 버퍼의 사이즈를 지정받음 (지정하지 않으면 버퍼 생성은 하지 않음)
- 버퍼 사이즈 랑데뷰(Channel.RENDEZVOUS)
  - 채널 사이즈 0으로 설정의 의미 (버퍼없는 없는 것)
- UNLIMITED: 채널의 버퍼 사이즈가 정해지지 않은 것, 무제한
  - 실제로 무제한은 아니고 메모리가 허용하는 범위까지 가능하다는 의미
- CONFLATED: 오래된 값이 지워짐
- BUFFERED: 기본적으로 64개 버퍼 가짐
  -  오버플로우 발생할 때는 잠이 들게 됨

#### 버퍼 오버플로우

- 버퍼의 오버플로우 정책에 따라 다른 결과가 나올 수 있음
- 사용 예.
  - Channel<Int>(2, BufferOverflow.DROP_OLDEST)
- SUSPEND: 잠이 들었다 깨어남
- DROP_OLDEST: 예전 데이터를 삭제
- DROP_LATEST: 새 데이터를 삭제

#### Kotlin DSL (Domain Specific Language)

- 특정 도메인에 국한해 사용하는 언어
- 프레임워크나 라이브러리들을 사용하면서 제공되는 DSL을 사용하게 되는데 이러한 DSL들은 General Purpose Language가 아니기 때문에 사용법을 찾아보기 위해서는 특정 언어의 명세가 아니라 해당 DSL을 정의한 프레임워크나 라이브러리의 가이드에서 찾아야 함
- Kotlin으로 안드로이드를 개발하면서 DSL 접하는 것이 가능
  - 예. 빌드 스크립트에서 안드로이드 관련 옵션을 명시 / 특정 라이브러리 사용 시 그 라이브러리 사용에 필요한 옵션을 명시
- 빌더나 팩토리를 이용하여 필요한 옵션을 명시하고 객체를 생성하는 구현 패턴과 비교하여 더 간략하고 읽기 쉽게 작성
- 라이브러리 개발 시 DSL을 적절히 활용하여 제공하면 라이브러리 사용자는 보다 쉽고 간결하게 호출 코드들 작성 가능
- 잘 정의된 DSL은 상대적으로 자연어에 가까워 가독성도 높이는 데에 도움
- 코틀린 DSL은 코틀린 언어가 제공하는 몇 가지 기능들을 조합하여 간단히 DSL을 정의하고 사용 가능
  - 고차함수: 하나 이상의 함수를 파라미터로 갖거나, 함수를 반환하는 함수
  - 람다 표현식: 어떤 함수를 파라미터와 반환값 만으로 나타낸 표현식
  - 확장함수: 이미 정의된 클래스나 인터페이스에 상속 없이 함수를 추가 정의할 수 있도록 Kotlin에서 제공되는 기능

#### 코루틴 내부 구조 관련 내용 / 키워드 정리

- 모나드 (Monad) 1950년 후반, 로제 고드망이 만든 개념
- 모나드 : 파라미터 이름, (T) -> Box<U>
  - 값을 받아서 박스를 반환하는 함수
  - Null의 추상 (Optional / Option / Maybe), 에러 추상 (Either), 비동기 실행 (IO Monad) 에 사용
  - (1930년) 인자 하나를 받는 함수를 칭하는 말로 일컬어지기도 했었음
  - flatMap (bind, chain) 함수의 인자 => 모나드
    - 모나드는 플랫맵의 파라미터
- 모나드의 규칙
  - 좌항등원
  - 우항등원
  - 교환법칙
- Functor
  - 값을 받아 값을 리턴하는 파라미터
  - 값을 바로 리턴
  - map 함수의 인자는 Functor
- 연속적인 모나드 체인 (연속적인 호출 가능)
- Either (성공: Right, 실패: Left)
- Functor와 모나드 자체는 Async할 수도 Sync할 수도 있음
- Haskell (하스켈)
- CPS (Continuation Passing Style, 1975)
  - 계속 Continuation을 전달하는 방식
  - 콜백가 유사한 느낌
  - Continuation은 Last Call
  - Last Call Optimization 가능
  - LLVM Tail Call
  - 자바에서는 최적화 되지 않음 (CPS 사용 어려움)
  - CPS 단점: 끝없는 들여쓰기, 이해 어려움
  - CALL/CC (Call with Concurrent Continuation)
  - CPS 장점: 모든 제어 흐름 생성 가능
    - 없는 것이 있으면 Continuation을 통해 만든다는 개념, Schema 프로그래밍
- Direct Style (Return based)
- Continuation
  - 다음에 수행해야 할 내용을 의미
  - 다음에 수행해야 할 함수를 의미 (실체화된 Continuation)
- Coroutine (1958), 멜빈 콘웨이
  - Direct Style 같은 Straight forward한 프로그래밍
  - suspend / resume 반복
  - Kotlin Coroutine 특이점: Promise-free
  - Coroutine의 지배적인 모델: C#이 설립한 Async / Await 모델
  - Go언어, Colorless 모델, 비동기 함수와 동기 함수 구분이라는 색상 구분이 없음
  - 코틀린은 자바와의 호환성 때문에 async (suspend)는 유지
  - Suspension points: 중단 가능 함수 호출 때 마다 블록을 나눔
  - 상태머신: 중단 가능한 함수들은 상태머신으로 변경
  - LLVM에서 코루틴 다루는 방식
  - suspend 함수는 내부적으로 cont: Continuation 이라는 인자가 하나 더 추가됨
    - 다시 진입했을 때 동작을 위해 Continuation으로 관리
    - 코루틴의 Continuation: 컨텐스트와 남은 일에 대한 인터페이스, context, resumeWith
  - 컴파일러가 Continuation과 상태머신을 생성
  - Continuation Lowering
    - 하위 수준의 언어로의 변경을 의미, IR: 중간언어 의미, 사실상 Desugaring 의미
    - Desugaring: 사람들이 쓰기 편했던 속성 제거
    - Sugaring: 고수준 언어 특성 추가 
  - 코루틴 밖과 연결도 Continuation으로 처리
    - 외부에서 자신의 결과를 Continuation으로 처리
  - Continuation 최적화: 마커를 넣고 나중에 로어링때 최적화 수행, 로어링에서 여러 호출이 제거됨
    - FixStackMethodTransformer
- 어떻게 멀티스레드로 수행?
  - intercept라는 메소드를 오버라이딩해 동작 변경 가능
  - fold는 reduce와 비슷하나 초기값 존재
  - ThreadContinuaion
    - interceptContinuation이 ThreadContinuation 삽입
    - resume 상황에서 executor를 사용해서 다른 코드들을 다른 스레드에서 수행하게 됨
- 코루틴 내부 = 상태머신 + Continuation (다른 언어와도 유사)

#### 코틀린 코루틴 플로우 실제 사용 정리

- 뷰모델 내 count 변수 생성
- 외부 노출용 countFlow 생성 (countFlow: Flow<Int> = flow { emit(count)...})
  - 코루틴 블록으로 호출됨
- 뷰에서 뷰모델 가져오기 위해 androidx.lifecycle...viewmodel 의존성 추가
- 뷰 내에서 뷰모델 가져오기
- count 상태값을 읽기
  - val countState = viewModel.countFlow.collectAsState(0)
- 참고: suspend 함수는 코루틴 블럭에서 실행해야 함
- 참고: collectLatest 사용 시 무한히 처리하게 되는 이슈가 발생할 수 있음, 가장 마지막 값만 취함
  - 데이터가 나가는 상황보다 소비하는게 더 오래 걸린다면 이슈 발생 가능성 있음

#### 코루틴 사용 시 세가지 순서

- 어떤 쓰레드에서 실행할 것 인지 Dispatchers 를 정하고 (Dispatchers.Main, Dispatchers.IO, Dispatchers.Default)
- 코루틴이 실행될 Scope를 정하고 (CoroutineScope, ViewModelScope, LifecycleScope, liveData...)
- launch 또는 async로 코루틴을 실행
- 즉, Context로 Scope를 만들고, Builder를 이용하여 코루틴을 실행

#### CoroutineScope와 RunBlocking 차이점

- RunBlocking은 suspend 함수가 아님
- CoroutineScope는 suspend 함수
- 왜 RunBlocking이 존재?
  - 개발하다보면 스레드를 블락해야하는 상황이 생김
  - suspend 함수는 스레드를 블락시키지는 않지만 메인 스레드가 그대로 흘러가서 앱이 죽을 수도 있는 단점도 존재

#### Annotation 정리

- [@JvmName]
  - 코틀린을 바이트코드로 변환할 때 JVM 시그니쳐를 변경하는 용도로 사용
  - 자바에서 호출되는 코틀린 함수, 파일의 이름을 변경하는 용도
  - 코틀린에서 해당 함수를 사용할 때는 @JvmName의 이름이 아닌 원래의 이름으로 사용
- [@JvmMultifileClass]
  - @file:JvmName()으로 여러 코틀린 파일들이 동일한 이름으로 Rename 되었을 때 사용하는 애노테이션
  - 두 개의 파일이 있을 때 두 파일들 안에서 @file:JvmName("Test") 라고 명시해주게 되면 자바에서는 같은 파일명 즉, Test로 접근하게 됨. (같은 파일명으로 서로 다른 두 파일의 접근이 가능해짐)
- [@JvmStatic]
  - Static 변수의 Getter, Setter 함수를 자동으로 만들라는 의미
  - 전역변수의 Getter, Setter를 정적함수 (Static)로 설정
- [@JvmField]
  - Getter, Setter를 생성하지 말라는 의미의 애노테이션
- [@Throws]
  - 코틀린 함수가 예외를 던질 수 있다는 것을 의미하는 애노테이션
  - 코틀린에는 throws가 없음
- [@JvmOverloads]
  - 코틀린 함수의 오버로딩 메서드들을 생성해주는 애노테이션
  - 코틀린에만 기본인자 개념이 있어서 자바에는 이것을 이해하지 못하므로 JvmOverloads 애노테이션을 사용하면 알아서 여러 스타일의 생성자를 생성해 줌

#### 코틀린에서 널 처리 방법

- Nullable 타입 선언
  - 변수 또는 반환 타입에 ?를 붙여 Nullable 타입을 선언
  - Nullable 타입은 해당 변수 또는 표현식이 null일 수 있다는 것을 나타냄
  - var name: String? = null
- 안전 호출 연산자
  - Nullable 객체의 프로퍼티나 메서드에 접근할 때, 안전 호출 연산자를 사용하여 null 체크를 수행
  - 이 연산자는 객체가 null이 아닌 경우에만 접근을 시도하고, null인 경우에는 null을 반환
  - val length = name?.length
- 엘비스 연산자
  - Nullable 객체가 null인 경우, 엘비스 연산자를 사용하여 기본값을 지정할 수 있음
  - 엘비스 연산자는 Nullable 객체가 null인 경우, 우측에 있는 기본값을 반환
  - val length = name?.length ?: 0
- 안전한 캐스트
  - Nullable 객체를 캐스트할 때, 안전한 캐스트를 사용하여 캐스트가 실패할 경우 null을 반환
  - val number: Any? = "123"
  - val intValue: Int? = number as? Int
- Non-null 단언
  - Nullable 객체를 Non-null 타입으로 강제로 캐스트
  - 이 연산자는 객체가 null인 경우 NullPointerException을 발생시킬 수 있으므로 주의해야 함
val length = name!!.length

#### const val vs val 재정리

- const val 는 컴파일 시간에 결정되는 상수. 
- 런타임에 할당되는 val 와 달리 컴파일 시간 동안 할당이 되어야 함
- const 는 함수나 어떤 클래스의 생성자에게도 결코 할당 될 수 없고 오직 문자열이나 기본 자료형으로 할당

#### 스레드, 코루틴 차이

- 스레드
  - 여러 개의 스레드 사용하여 작업을 병렬로 수행하여 비동기적으로 작동
  - 네트워크 처리 서브 스레드가 작업할 동안 UI스레드는 특별한 처리 활동 없이 대기만 하게 되는 문제가 있음
- 코루틴
  - 실제로 병렬로 작업되는 것이 아니고 여러 개의 작업을 잘게 쪼개서 나눠서 작업을 수행하는 방식
  - 특정 스레드에 종속적이지 않음, 그때그때마다 상황에 맞는 적절한 스레드에서 실행이 됨
  - 각 작업에 대해 Thread 를 할당하는 것이 아니라 작은 Object 만을 할당해주고 이 Object 들을 자유자재로 스위칭함으로써 Switching 비용이 줄어듬
  - 자바 힙에 오브젝트를 적재
  - 프로그래머의 코딩을 통해 Switching 시점을 마음대로 정함으로써 Concurrency 를 보장
  - Suspend (Non-Blocking): 작업 1(Object) 이 작업 2(Object) 의 결과가 나오기까지 기다려야한다면 작업 1 Object 는 Suspend 되지만 작업 1 을 수행하던 Thread 는 그대로 유효하기 때문에 작업 2 도 작업 1 과 동일한 Thread 에서 실행될 수 있음

#### 코루틴 장점 및 단점

- 코루틴의 장점
  - 메모리 사용량이 적음. 코루틴은 일반적인 스레드처럼 많은 메모리를 필요로 하지 않음
  - 코루틴은 다른 작업과 함께 동작 가능. 이는 비동기 작업을 수행하면서 다른 작업을 동시에 수행할 수 있도록 해주어 프로그램의 성능을 향상시킬 수 있음
  - 코루틴은 더 높은 수준의 추상화를 제공. 이는 프로그래밍의 복잡도를 낮추고 코드의 가독성을 높일 수 있음
- 코루틴의 단점
  - 코루틴은 일반적으로 스레드보다 느림. 이는 코루틴이 단일 스레드에서 실행되는 반면, 스레드는 여러 개의 코어를 사용하여 병렬로 실행될 수 있기 때문임
  - 코루틴은 동시에 실행되는 코드 블록의 수를 제한함. 이는 코루틴이 오버헤드를 줄이기 위해 한 번에 동시에 실행할 수 있는 코드 블록 수를 제한하기 때문임

#### in, out

- out 키워드는 슈퍼 클래스에 서브 클래스를 대입할 수 있게 해줌
  - 부모 변수에 자식 할당
- in 키워드는 서브 클래스에 슈퍼 클래스를 대입할 수 있게 해줌
  - 자식 변수애 부모 할당

#### Kotlin flow

- 배경
  - 기존 명령형 프로그래밍에서는 데이터가 필요할 때마다 결과값을 매번 요청해야했었다는 점에서 비효율적
  - 그러한 문제를 해결하기 위해 나온게 리액티브 프로그래밍이라는 건데 이것이 반응형 프로그래밍
- Flow
  - Flow가 바로 코루틴상에서 리액티브 프로그래밍을 지원하기 위한 구성요소
- 리액티브 프로그래밍 설명
  - 리액티브 프로그래밍에서는 데이터를 만드는 생산자(발행자)가 존재하고 소비자는 데이터의 생산자(발행자)에게 그 구독을 요청하게 되면 데이터를 만드는 생산자(발행자)는 새로운 데이터가 생산or발행 되면 소비자에게 새로운 데이터를 지속적으로 발행
  - 하나의 데이터를 발행하는 발행자가 있고, 해당 발행자는 데이터의 소비자에게 지속적으로 데이터를 전달하는 역할을 한다 - > 이것이 데이터 스트림
- 코루틴에서 이러한 데이터 스트림을 구현하기 위해서 Flow를 사용
- 데이터 스트림의 구성요소 <-> Flow에서의 구성요소
  - 1. 이벤트소스
    - flowOf(): 주어진 값으로 Flow를 생성
    - asFlow(): 기존의 컬렉션, 시퀀스, 배열 등의 데이터를 Flow로 변환
    - callbackFlow(): 콜백을 사용하여 Flow를 생성, 이 방법은 비동기적인 작업을 수행할 때 유용
  - 2. 연산자
    - map: 각각의 이벤트를 다른 이벤트로 변환
    - filter: 주어진 조건에 맞지 않는 이벤트를 제거
    - transform: 이벤트를 다른 Flow로 변환
    - take: 주어진 수 만큼의 이벤트를 가져옴
    - zip: 두 개 이상의 Flow를 결합하여 새로운 Flow를 생성
    - onEach: 각 이벤트에 대해 수행할 작업을 정의
  - 3. 구독자
    - collect: Flow의 모든 이벤트를 소비
    - toList: Flow의 모든 이벤트를 리스트로 수집
    - toSet: Flow의 모든 이벤트를 세트로 수집
    - first: 첫 번째 이벤트를 반환
    - reduce: Flow의 이벤트를 축소하여 하나의 결과를 생성
    - fold: 초기값을 기반으로 Flow의 이벤트를 축소하여 하나의 결과를 생성
    - catch: 예외를 처리하고 대체 값을 반환
    - onCompletion: Flow의 실행이 완료되면 수행할 작업을 정의

#### Coroutine Channel

- BlockingQueue와 매우 유사
- 중요한 차이점은 차단하는 넣기(put) 작업 대신 일시중지하는 보내기(suspending send)가 있고 차단하는 take 작업 대신 일시중지하는 수신(suspending receive)이 있다는 것
- 블로킹큐 설명
  - 특정 상황에 쓰레드를 대기하도록 하는 큐. 
  - 큐에서 엘레멘트를 빼려고 시도했는데(디큐) 큐가 비어있다거나, 큐에 엘레멘트를 넣으려 했는데(인큐) 큐에 넣을 수 있는 공간이 없다거나 할 때 디큐/인큐 호출 쓰레드를 대기
  - 비어있는 큐에서 엘레멘트를 빼려고 시도하는 쓰레드의 대기 상태는 다른 쓰레드가 이 큐에 엘레멘트를 넣을 때까지 지속
  - 꽉 찬 큐에 엘레멘트를 넣으려 시도하는 쓰레드의 대기 상태는 다른 쓰레드가 큐에서 엘레멘트를 빼거나 큐를 정리하여(clean) 큐의 공간이 확보될 때까지 지속

#### Coroutine Thread 재정리

- Coroutine은 실행중인 스레드를 Block(차단)하는 대신 Suspend(정지)
- 즉 단일 스레드에서 많은 코루틴을 실행하는 것
- Thread의 생성 Cost(비용)은 비싸며, 다른 Thread로 부터 결과를 전달받아야 할 때, Blocking이 발생하면 아무 작업없이 다른 작업이 끝날 때 까지 자원은 낭비되는 문제가 있음
- 또 다른 스레드를 생성하는 것이 아니라 스레드 안에 여러개의 코루틴이 존재한다고 생각하면 됨
- 코루틴은 스레드 안에서 수행되는 일시 중단 가능한 작업의 단위
- 하나의 스레드에 여러 코루틴이 들어갈 수 있음
- 정리
  - 스레드
    - Task 단위: Thread
    - 작업 단위로 Thread를 할당 & 해제
    - Thread는 Stack 메모리를 가지며, JVM Stack 영역 점유
  - 코루틴
    - Task 단위: Job(Coroutine)
    - 작업 단위로 Coroutine 할당
    - Coroutine은 JVM Heap 영역에 쌓임, Job Object라 생각하면 됨
   
#### 코루틴 스코프빌더 재정리*

- launch
  - 호출하는 쪽의 스레드를 중단 없이 시작시킬 수 있으며(안드로이드라면 주로 UI스레드), 결과를 호출한 쪽에 반환하지 않음
  - 일반 함수 내부 → launch 빌더 내부 → suspend함수 호출
- async
  - launch와 마찬가지로 현재 스레드를 중단시키지 않고 실행
  - 결과를 호출한쪽에 반환
  - 오로지 suspend함수 내부에서만 사용이 가능
  - suspend함수 내부에서만 사용 가능하단 뜻은 다른 빌더로 또다시 감싸줘야만 한다는걸 의미
  - 일반 함수 내부 → launch빌더 내부 → suspend함수 호출 → async빌더
- withContext
  - async빌더와 상당히 유사
  - withContext빌더는 Deferred<T>형태의 객체를 반환하지 않고, T형태의 객체를 그대로 반환
  -  withContext도 async처럼 suspend함수 안에서 선언되어야만 하는데, 이때 부모 빌더와는 다른 coutine context를 사용하여 실행시킴
- coroutineScope
  - 병행으로 실행되는 코루틴이 모두 완료되어야만 하는 처리를 할때 유용.
  -  모든 코루틴이 실행이 완료되어야만 하며, 하나라도 실패시 작업은 모두 취소됨
- viewModelScope
  - ViewModel의 라이프사이클에 맞춰 Scope을 적절히 cancel시켜줄 수 있는 스코프
  - 예를들어, 사용자가 api를 호출하자마자 액티비티를 onDistroy했다고 가정했을 때 그럼 이때 ViewModel도 onCrear되는데, 이때 ViewModelScope도 이에 맞추어 비동기코드를 종료시켜 줌
- GlobalScope
  - 프로그램 전체에서 싱글톤으로 진행시킬 수 있는 스코프
- runBlocking
  - 실행시킨 코루틴 작업이 끝날때까지 호출한 곳의 메인스레드가 끝나길 대기
  -  메인스레드는 UI스레드를 의미 (그래서 UI스레드에선 해당 스코프 호출보단 다른 방법을 찾아보는게 좋은 방향)

#### Continuation Passing Style
- 결과를 호출자에게 직접 반환하는 대신 Callback같은 것 continuation으로 결과를 전달하는 것을 의미
- suspend function
  - 내부적으로는 JVM에 들어갈 때 바이트코드로 컴파일되면서 같은 xxx(…)인데 Continuation이 생성되어 Continuation Passing Style로 변환됨
- 호출했던 함수의 끝에 매개변수가 하나 추가되서 Continuation이라는 객체를 넘겨주는 것으로 변환되는 것임
- 레이블링 작업 때문에 특정 지점 파악이 가능

#### get()과 직접 참조(=)의 차이

```kotlin
val a = MutableLiveData<String>()
val b: LiveData<String> = a
val c: LiveData<String>
	get() = a
```
- 직접 선언하는 것(b)과 get() = ... 으로 선언하는 것(c)의 차이점은, 
- 직접 선언하면 b 와 a 는 서로 동일한 객체를 바라보게 되는 것
- get() 으로 선언할 경우엔 내부적으로 함수가 호출되고, 해당 함수의 결과 값으로 a 객체를 리턴하는 것.

#### Lambda Function 과 High Order Function 설명 재정리*
​
- Kotlin에서는 함수형 프로그래밍을 지원
- High Order Function(고차함수) 란 , 함수를 인수로 취하거나 함수를 결과로 반환할 수 있는 함수를 의미
  - Android Studio 에서 자주 사용하는 Call-Back Method 등이 고차함수
- 고차함수에서 매개변수로 주어지는 식을 Lambda Expression ( 람다 표현식 ) 이라고 부름

#### inline, crossinline, noinline, reified

- inline 키워드
  - 고차 함수를 사용하면 런타임 패널티가 있기 때문에 함수 구현 자체를 코드에 넣음으로써 오버헤드를 없앨 수 있음
  - 내부적으로 객체 생성과 함께 함수 호출을 하게 되어 있어서, 이런 부분에서 오버헤드가 생길 수 있음
  - inline 키워드는 이런 오버헤드를 없애기 위해 사용
- noinline
  - 이 키워드가 붙은 인자는 다른 함수의 인자로 전달이 가능
- crossinline
  - 고차함수에서 함수를 인자로 받아 setOnClickListener 내부에서 호출해야 하는데 일반적인 코드는 동작하지 않음. 
  - inline 함수는 인자로 받은 함수를 다른 실행 컨텍스트를 통해 호출할 때는 함수 안에서 비-로컬 흐름을 제어할 수 없음
  - 이럴 때 사용하는 것이 crossinline 키워드
- reified
  - inline 함수에서 특정 타입을 가졌는지 판단할 수 없기 때문임
  - 이럴 때 reified 키워드를 사용
  - 타입 파라미터에 reified 키워드를 붙여주면 마치 클래스처럼 타입 파라미터에 접근 가능
  - 참고로 reified는 inline이 아닌 일반 함수에서는 사용할 수 없음

#### CoroutineScope vs GlobalScope 설명

- CoroutineScope
  - 라이프사이클을 별도로 가지고 종료 가능 	
- GlobalScope
  - 싱글톤으로 만들어져 있음
  - 어플리케이션의 라이프사이클에 따라 동작
  - 취소 처리가 복잡 (누락 가능성)
  - throw exception 처리 복잡 (누락 가능성)
  - 글로벌 스코프 사용 시 내부의 서로 다른 런치 동작에 대한 영향을 다른 자식의 런치에 영향이 가지 않도록 하기 위해서는 2개의 코드 추가 가능
    - SupervisorJob : 예외상황을 상위 부모에게 통지하지 않음 --> 자식들에서 발생한 예외 상황이 다른 자식에게 영향을 주지 않음
    - CoroutineExceptionHandler: Exception을 글로벌하게 받아서 처리
    - GlobalScope.launch (exception + SupervisorJob()) {}
  - Activity, Fragment가 즉시 종료되어 뷰를 날렸을 경우 오류 발생 가능성 있음
    - GlobalScope.launch(exception + SupervisorJob())
    - onCleared() --> job.cancel() 필요

#### 코루틴 내부 구조

- 코루틴은 디컴파일되면 일반 코드
- Continuation Passing Style(CPS, 연속 전달 방식) 이라는 형태의 코드로 전환
- Continuation Passing Style은 결과를 호출자에게 직접 반환하는 대신 Callback같은 것 continuation으로 결과를 전달하는 것을 의미
- suspend fun은 내부적으로는 JVM에 들어갈 때 바이트코드로 컴파일되면서 같은 함수인데 Continuation이 생성되어 Continuation Passing Style로 변환
- 호출했던 함수의 끝에 매개변수가 하나 추가되서 Continuation이라는 객체를 넘겨주는 것으로 변환
- 일시 중단과 재개를 위해서 suspention point를 label로 표시해두는 Labeling 작업이 이루어짐
- 작성했던 함수가 내부적으론 switch-case문처럼 바뀌어 case문이 생성되고 실행
- Label들이 다 완성되고 나면 Continuation Passing Style로 변환
- Continuation이라는 객체가 있고, 매 번 함수를 호출할 때마다 continuation을 넘김
- continuation은 Callback 인터페이스 같은 것으로, 재개를 해주는 인터페이스를 가진 객체
- sm이라고 하는 것은 state machine을 의미하는데, 각각의 함수가 호출될 때 상태(지금까지 했던 연산의 결과)를 같이 넘겨줘야 함
- 이 state machine의 정체는 결국 Continuation이고, Continuation이 어떠한 정보값을 가진 형태로 Passing이 되면서 코루틴이 내부적으로 동작하게 되는 것

#### Pair, Triple

- Pair는 객체를 생성하고 두개의 객체를 넣을 수 있음
- 원래는 따로 클래스를 만들어서 처리해야 하나 Pair, Triple 등을 사용하면 번거로움 없이 설정이 가능
- 안에 들어가는 객체의 클래스 또는 자료형은 중요하지 않음
- 두개가 동일해도 되고 달라도 됨
- Pair 옆에 <타입, 타입>을 명시적으로 작성하는 것도 가능
- pair.component1, 2 등으로 읽는 것도 가능
- val (hello, number) = Pair("Hello", 1234) 이런식도 가능
- val (hello, world) = "Hello" to "World"
- Triple은 first, second, third 로 접근 가능