#### 코틀린의 타켓 플랫폼 설명 / 자바와 서로 상호 운용에 대한 설명

- JVM이 코틀린의 타켓 플랫폼
- 코틀린은 컴파일 시 바이트 코드를 생성하므로 자바와 100% 상호 운용 가능
- 따라서 자바 <-> 코틀린 코드 간 상호 참조 / 호출 가능

#### Kotlin Scope Function 설명

- apply
- also
- with
- run
- let

#### by lazy 와 lateinit 설명

- lateinit: var 에서만 사용 가능
  - 언제든 초기화 변경 가능
  - null 통한 초기화 불가능
  - 초기화 전 접근 불가능 (lateinit property subject has not been initialized 에러)
  - 변수에 대한 setter/getter 프로퍼티 정의 불가능
  - 원시 타입에 대해서는 활용 불가능
  - 초기화 확인 방법 => ::변수.isInitialized
- by lazy: val 에서만 사용 가능
  - lazy {}에 생성과 동시에 값을 초기화 하는 방법 사용
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
