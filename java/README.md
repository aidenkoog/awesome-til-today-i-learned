#### 자바의 특징 설명

- 자바는 객체지향 프로그래밍 언어
- 기본 자료형을 제외한 모든 요소들이 객체로 표현
- 캡슐화, 상속, 다형성이 잘 적용된 언어
- 장점
  - JVM 위에서 동작하므로 OS에 독립적
  - GarbageCollector 통한 자동적인 메모리 관리 가능
- 단점
  - JVM 위에서 동작하므로 상대적으로 실행 속도 느림
  - 다중 상속이나 타입에 엄격, 제약이 많음

#### JVM의 역할에 대한 설명

- JVM은 스택 기반으로 동작
- 자바 바이트 코드를 운영체제에 맞게 해석해주는 역할
- 가비지 컬렉션 통한 자동적인 메모리 관리 수행

#### 자바의 컴파일 과정에 대한 설명

- 자바 파일 작성
- 빌드 수행
- Javac 명령 통한 바이트코드 (.class) 생성
- 클래스 로더 통해 JVM 메모리 내로 로드
- 실행엔진(JVM)을 통해 컴퓨터가 읽을 수 있는 기계어로 해석 (각 OS에 맞는 기계어)
- (참고) 바이트 코드를 완전한 기계코드로 변환하는 과정에서 일반적인 컴파일 언어보다 속도가 많이 느리다는 단점 있음

#### GC 설명

- Garbage Collector
- JVM의 Heap 영역에서 사용하지 않는 객체를 제거해주는 프로세스
- 동적으로 할당했던 메모리 영역 중에 필요없어진 영역을 해제하는 기능
- C는 사용자가 메모리를 사용 후 해제해줘야 하나 자바는 자동으로 메모리에서 제거
- 제거 방식
  - Mark and Sweep 알고리즘 기반 동작
    - 스택의 모든 변수를 스캔
    - 각각 어떤 오브젝트를 레퍼런스 하고 있는 검색 / Mark
    - Mark 되어 있지 않은 모든 오브젝트 (Unreachable) 들을 힙에서 제거 (Sweep 과정)
    - GC 알고리즘에 따라 파편화된 메모리 정리를 위한 Compact 동작 수행
      - Compact: Heap의 시작 주소로 모아서 메모리가 할당된 부분과 아닌 부분으로 나누는 과정 (조각모음의 느낌)
    - Marking 작업을 위해 모든 스레드는 중단되는데 이를 Stop the world라 함
- Stop the world 설명
  - GC 실행 전 JVM 이 GC 실행 쓰레드를 제외하고 다른 쓰레드의 모든 작업을 멈추는 것
  - 어떤 GC 알고리즘을 사용하더라도 Stop the world는 발생. 이 시간을 줄이는 것이 관건

#### Heap 구조

- Young Generation
  - 새로운 객체들이 할당되는 영역
  - Eden, Survivor 0 / 1 영역 존재
- Old Generation
  - 오랫동안 계속 살아남은 객체들이 있는 영역
- Meta Space
  - GC 발생 시 필요한 클래스와 메소드의 메타 정보가 있는 영역

#### GC 관련 객체들의 참조 방식의 종류

- 힙 내에 있는 다른 객체에 의한 참조
- 자바 스택, 즉, 메소드 내의 지역 변수나 파라미터들에 의한 참조
- JNI에 의해 생성된 객체에 대한 참조
- 메소드 영역의 Static 변수에 의한 참조
- (참고) 유효한 참조가 있는 객체: Reachable 객체 (없는 경우: Unreachable 객체)

#### GC 과정 설명

- 새로운 객체 생성
- Heap의 Young Generation 내 Eden에 삽입
- Eden이 Full 상태가 되면 Minor GC 발생
- Reachable 객체 판단 후 Reachable 객체들은 Survivor 0 영역으로 이동
- Sweep 동작에 의해 Unreachable 객체들 제거
- 살아남은 객체들의 Age 값 증가 (0 -> 1)
- 또 다른 새로운 객체 생성 및 Eden 영역 Full 상태 발생
- Minor GC 발생
- Eden 영역 외 다른 영역에 대해서도 Mark 진행
- Reachable 객체들을 Survivor 1 영역으로 이동
- 반복하다보면 객체들의 Age가 임계점에 도달
- 임계점에 도달한 객체들을 Old Generation 영역으로 이동 (Promoted)
- 위 과정 반복되다가 Old Generation도 Full 상태가 되면 Major GC (Full GC) 수행
- GC 발생 시 GC 수행하는 스레드 외 나머지 스레드들에 대해 JVM이 작업을 중단 시킴 (stop-the-world)
- Minor GC 의 경우 잠깐 멈추나 Major GC 의 경우 소요되는 시간이 길므로 처리 중 앱에서 에러로 이어지는 경우 발생 (흔히 보는 GC에 의한 처리 에러)
  - 개발 레벨에서 긴 참조 지양, 사용한 뒤에 초기화 등의 작업 반드시 필요

#### GC 알고리즘 종류 설명

- Serial GC
- Parallel GC
- Parallel Old GC
- CMD(Concurrent Mark Sweep) GC
- G1(Garbage First) GC

#### 자바 메모리 구성 설명

- 스택
  - 힙 영역에 생성된 오브젝트 타입 데이터의 참조값이 할당
  - 원시타입의 데이터가 값과 함께 할당 (실제값 저장)
  - 쓰레드 하나당 하나씩 할당
- 힙
  - 모든 오브젝트 타입 / 오브젝트를 상속받은 것들은 힙 영역에 할당
  - 단 하나의 힙 영역 존재 (쓰레드들은 힙 영역 공유)

#### 추상 클래스와 인터페이스 공통점, 차이점 설명

- 공통점
  - 추상 메소드를 가지고 있어야 함
  - 인스턴스화 불가능 (new 생성자 사용 X)
  - 인터페이스 혹은 추상 클래스를 상속받아 구현한 구현체의 인스턴스를 사용해야 함
  - 인터페이스와 추상클래스를 구현 / 상속한 클래스는 추상 메소드를 반드시 구현해야 함
- 차이점
  - 추상클래스
    - abstract 키워드 사용
    - 일반 변수 사용 가능
    - 다른 클래스가 추상 클래스 상속받을 때 extends 키워드 사용
    - 생성자 사용 가능
    - 사용 가능 메소드 제한 없음
    - 접근 제어자 사용 제한 없음 (abstract final 동시에 표기 불가)
    - 다중 상속 불가능
    - 상속의 목적: 클래스 확장 및 코드의 재사용
  - 인터페이스
    - interface 키워드 사용
    - interface 내 정의된 메소드들을 반드시 구현해야 함
    - 일반 변수 사용 불가능, static final 상수 사용 가능
    - 생성자 사용 불가능
    - 접근 제어자 public
    - 사용 가능 메소드: abstract method, default method, static method, private method
    - 상속 키워드 implements
    - 다중 상속 가능
    - 상속의 목적: 요구사항 구현

#### 람다 함수 설명

- 익명 함수 (Anonymous functions)를 지칭하는 용어, 익명 함수들은 공통으로 일급객체라는 특징을 지님
- 람다 대수: 수학에서 사용하는 함수를 보다 단순하게 표현하는 방법
- 장점
  - 코드의 간결성
  - 지연연산 수행
  - 병렬처리 가능
- 단점
  - 호출 까다로움
  - 람다 Stream 사용 시 단순 for / while문 사용 시 성능 감소
  - 과도한 사용은 오히려 가독성을 낮춤

#### 일급 객체 (First Class Citizen) 설명

- 아래 3가지 조건을 충족한 객체를 의미
  - 모든 일급 객체는 변수나 데이터에 담을 수 있어야 함
  - 함수의 파라미터로 전달 가능해야 함
  - 함수의 리턴값으로 사용 가능해야 함
- 자바스크립트, 파이썬이 일급객체 언어이고 C/C++은 아님 (자바의 경우 람다로 일급객체 개념 지원)

#### 스트림 설명 *

- 연속된 데이터를 처리하는 오퍼레이션들의 모음
  - (중요) 데이터를 담고 있는 저장소 (컬렉션)이 아님
  - 스트림으로 전달받은 데이터를 변경하는 것 아님
  - 함수형
- 무제한일 수 있음
  - Short Circuit 메소드를 사용해서 제한 가능
- 중개 오퍼레이션들은 lazy 한 특성 지님
- 오퍼레이션 스타일
  - 중개
    - 스트림을 리턴 (Stateless / Stateful 로 상세 구분도 가능)
    - list.stream().map(s -> {}) 여기까지만 작성하면 실행하지 않음
      - 즉 터미널 오퍼레이터가 오기 전까지는 실행되지 않음 (lazy한 특성)
    - 대부분 Stateless 이나 distinct 나 sorted 처럼 이전 소스 데이터를 참조해야 하는 오퍼레이션은 Stateful
    - filter, map, limit, skip, sorted etc.
  - 종료
    - 스트림 리턴하지 않음
    - collect, allMatch, count, forEach, min, max etc.
- 자바 8에서 새로 추가된 기능
- 탄생 배경
  - 기존 루프문 처리 문제 (컬렉션 크기가 커지면 루프문의 사용은 성능 저하를 유발)
- 컬렉션 데이터를 선언형으로 쉽게 처리 가능
- 병렬 처리를 별도의 멀티스레드 구현없이도 쉽게 구현 가능
  - stream() / parallelStream()
    - parallelStream() : 데이터가 엄청 방대한 경우에 성능 향상의 효과를 보임 / Thread.currentThread.getName()으로 확인해보면 매번 스레드가 변경되면서 병렬적으로 내부적으로 처리되는 것을 확인 가능
- Ex.
  - 기존 방식
    - OK 여부 필터링 (for문)
    - 이름 순서대로 배열 정렬 (for문)
    - 고유 번호 출력 (for문)
  - 스트림 방식
    - 위 세가지 단계를 한줄로 표현 가능
    - stream().filter(..).sorted(..).map(..)
- 스트림 API 특정 정리
  - 선언형: 간결하고 가독성 증대
  - 함수의 조립: 유연성 증가
  - 병렬화: 성능 향상
  - 파이프라이닝: 서로 연결하여 큰 파이프 라인을 구성할 수 있도록 스트림 자신을 반환
- 추가 설명
  - 스트림 파이프라인 (Stream Pipeline)
    - 0 또는 다수의 중개 오퍼레이션 (Intermediate) 과 한개의 종료 오퍼레이션 (Terminal) 으로 구성
    - 스트림의 데이터 소스는 오직 터미널 오퍼레이션을 실행할 때만 처리함.

#### 스트림과 컬렉션 차이점

- 둘 다 연속된 요소형식의 값을 저장하는 자료구조 인터페이스를 제공
- 차이점
  - 데이터 계산 시점: 컬렉션은 모든 요소가 컬렉션에 추가하기 전에 계산되어져야 하고 스트림은 요청할 때만 요소를 계산하는 고정된 자료구조
  - 반복의 일회성: 스트림은 단 한번만 반복문을 처리 가능, Consumer 개념을 사용해서 한번 소비한 요소에 대해서는 접근 불가능
  - 외부 / 내부 반복
    - 외부반복: 컬렉션은 개발자가 직접 for/foreach 문법을 사용하여 반복문을 명시해야 하는데 이를 외부 반복이라 함.
    - 내부반복: 스트림은 라이브러리를 사용하는 내부반복 개념 / 작업을 병렬로 처리할 수 있고 더 최적화된 다양한 순서로 처리 가능

#### 스트림 연산 종류 설명

- **중간연산**
  - Ex. filter, map, limit
  - 다른 스트림을 반환하기 때문에 여러개의 중간연산을 연결하여 질의 생성 가능
  - 최종연산 실행 전까지는 아무 연산도 수행하지 않음
- **최종연산**
  - Ex. collect
  - 파이프라인 연산의 결과를 출력
  - 리스트 형태 외 Integer, void 등 다양한 형태로 출력 가능

#### 스트림 사용하는 단계 요약

- 질의 수행할 데이터 소스 (어떤 컬렉션 자료구조인가)
- 스트림 파이프라인을 구성할 중간 연산 (filter, map, limit 등)
- 스트림 연산을 실행하고 결과로 출력할 최종 연산

#### Annotation 설명

- 주석이란 뜻, 인터페이스를 기반으로 한 문법
- 주석처럼 코드에 달아 클래스에 특별한 의미를 부여하거나 기능 주입 가능
- 해석되는 시점 결정도 가능
- 종류
  - Build-In Annotation
    - JDK에 내장 (Ex. @Override)
  - Meta Annotation
    - 어노테이션에 대한 정보를 나타내기 위한 어노테이션
  - Custom Annotation
    - 개발자가 직접 만들어 내는 어노테이션

#### 제네릭 (Generic) 설명

- 자바에서 안정성 담당
- 다양한 타입의 객체들을 다루는 메소드나 컬렉션 클래스에서 사용하는 것으로, 컴파일 과정에서 타입체크를 해주는 기능
- 컴파일 타임 때 객체 타입을 체크하기 때문에 타입 안정성을 높이고 형변환의 수고로움을 감소시킴
- 코드의 간결함 유지

#### 자바 라이브러리 설명 및 정적 라이브러리와 공유 라이브러리의 차이점 설명

- 자바 라이브러리
  - Java에서는 미리 자주사용되고 유용한 기능을 하는 class들을 만들어 놓고 제공하는데 이때 이 클래스들을 관련된 기능별로 분류하여 패키지단위로 묶어서 관리하는데 이 패키지 파일을 라이브러리라고 함
    Java API는 이러한 클래스들의 코드를 문서로 제공
- 정적 링크 라이브러리(Static Link Library)
  - .lib으로 표현하며 컴파일 시에 함수가 실행파일에 연결됨
  - 실행 파일에 함수의 코드가 복사되기 때문에 실행파일의 크기가 커지는 단점이 있지만 실행 파일은 완전한 단독 실행 파일이 됨
  - 실행파일에 함수의 코드가 포함되어 있기 때문에 컴파일이 끝나면 lib 파일이 없어도 프로그램 실행 가능
- 동적 링크 라이브러리(Dynamic Link Library)
  - .dll로 표현하며 정적 라이브러리처럼 컴파일 시에 함수가 연결되는 방식이 아닌 런타임시에 함수가 실행파일에 연결됨
  - 실행파일에는 호출할 함수의 정보만 포함되고 실제 함수 코드는 복사되지 않으므로 실행 파일의 크기가 작아짐
  - 실행 파일은 함수에 대한 정보만 가지고 있을 뿐 실제 코드를 가지고 있지 않기 때문에 프로그램 실행시에는 dll 파일이 항상 존재해야 함

#### 전역변수와 지역변수 설명과 용법 정리

- 전역변수
  - 함수 바깥에 선언하여 클래스 전체에서 사용가능한 변수
  - 여러 메소드에서 공통적으로 사용 가능
- 지역변수
  - 함수 속에 선언하여 해당 함수 속에서만 사용가능한 변수
  - 해당 메소드가 호출되어 메모리를 할당받은 후 종료되면 소멸되어 다시 사용 불가능

#### Java EE와 SE 차이

- Java SE (Java Platform Standard Edition)
  - 데스크탑, 서버, 임베디드를 위한 표준 자바 플랫폼
  - 안드로이드 개발 시 보통 Java SE 사용
- Java EE (Java Platform EnterPrise Edition)
  - 자바를 이용한 서버측 개발을 위한 플랫폼
  - SE에 서버측을 위한 기능 추가하여 SE의 모든 기능 이용 가능

#### getter와 setter를 사용하는 이유 설명

- 메소드를 통해 접근하기 때문에 메소드 안에서 매개변수같이 어떤 올바르지 않은 입력에 대해 사전에 처리할 수 있게 제한하거나 조절 가능하기 때문에 사용

#### DAO와 DTO 개념 설명

- DAO (Data Access Object)
  - 데이터베이스의 데이터에 접근을 위한 객체
  - 데이터베이스에 접근을 하기 위한 로직과 비즈니스 로직을 분리하기 위해서 사용
  - DB를 사용해 데이터를 조회 / 조작하는 기능을 전담하도록 만든 오브젝트
- DTO (Data Transfer Object)
  - VO (Value Object)로 바꾸어 말할 수 있는데 계층간 데이터 교환을 위한 JavaBean을 의미
  - 각 계층간 데이터 교환을 위한 객체를 DTO 또는 VO라고 말함
  - VO는 DTO와 동일 개념이지만 Read Only 속성을 가짐

#### Iterator 설명

- 컬렉션 클래스에 저장된 요소들을 나열하는 방법 제공
- 컬렉션 클래스의 iterator()를 호출해서 Iterator를 구현한 객체를 얻음
- hasNext()
- next() (호출하기 전에 hasNext()호출해서 확인 필요)
- remove(): next()로 읽어 온 요소를 삭제

#### Wrapper Class 사용 이유

- 프로그램에 따라 기본 타입의 데이터를 객체로 취급해야 하는 경우 존재
- 기본 자료형에 대해 객체로서 인식되도록 포장하기 위해 Wrapper Class를 사용

#### 컴파일 에러와 런타임 에러를 비교하여 설명

- 컴파일 에러
  - 구문 오류로 프로그램 컴파일 불가능함을 의미
  - 문법상의 오류로 발생, 에러 발생 포인트를 개발자에게 알려줌
  - 유형
    - 구문 에러
    - 괄호 등의 구문 에러
    - 클래스패스에 누락된 클래스
- 런타임 에러
  - 실행하면서 에러 발생
  - 논리적 결함으로 인해 발생하는 에러, 에러 발생 시 개발자가 역추적하여 원인 파악 필요
  - 유형
    - NPE
    - 0으로 나누는 경우
    - 무한 루프

#### String

- 글자, 단어, 문장, 문서 등 문자로 구성된 자료형
- Java.lang Package로 제공되는 자바 문자열 클래스
- 별도 import 없이 사용 가능
- 한번 인스턴스가 생성되면 수정 불가능 (immutable object)
  - 배열로 접근하는 방법을 제공하지 않음.
  - char[] char_arr 는 수정 가능
- 수정하는 방법
  - 새 문자열로 교체
  - toCharArray() 함수 통해 수정 후 다시 new String(temp_arr) 사용하여 문자열로 변경
  - substring 사용한 조합
  - StringBuilder 사용한 조합
- == 연산으로 비교 불가
  - 참고. 자바 힙 영역이 있고 그 안에 Constant String Pool 영역이 있음
  - 리터럴로 선언된 문자열, 리터럴 스트링은 Constant String Pool 영역에 저장
  - new String("") 으로 생성한 문자열, 오브젝트 스트링은 자바 힙 영역에 저장
- == 은 주소 비교, equals 는 주소 내 실제 값 비교

#### String 함수

- charAt(int index)
- length()
- equals
- compareTo(String string)
  - -1, 0, 1
- toCharArray()
- toLower / UpperCase()
- contains(CharSequence s)
- replace(target, replacement)
- split(String regex)
- substring(index, index)
- indexOf

#### 아스키 코드

- 'A': 65, 'a': 97, 'Z': 90, 'z': 122, '9': 57
- (ref. 알파벳 개수: 26개)
- char x = 65;
- println('Z' - 'A'); => 25
- println(x); => A
- println((int)x); => 65
- println((char)x); => A
- println(x + 25); => 90
- println((char)(x + 25)); => Z

#### foreach 문의 한계 / 장점

- 반복문 내에서 배열이나 리스트의 값을 변경하거나 추가 불가능
- 배열 역순 탐색 불가능
- 가변하는 복잡한 배열이나 리스트의 크기를 일일이 구할 필요 없음
- 이중 for문이나 복잡한 반복문에 적합
- 인덱스를 생성해 접근하는 단순 for문 보다 수행속도가 빠름

#### 자바 컬렉션 특징

- 리스트, 스택, 큐, Set 등 존재
- 요소 개수에 따라 크기 자동 조절
- 요소의 삽입, 삭제에 따른 요소의 위치 자동 이동
- 고정 크기의 배열을 다루는 어려움 해소
- 다양한 객체들의 삽입, 삭제, 검색 등의 관리 용이
- 제네릭을 이용해 저장될 데이터의 자료형을 정할 수 있음

#### 자바 컬렉션 리스트

- ArrayList
  - 빠르고 크기를 자유롭게 조절 가능한 배열
- Vector
  - ArrayList의 구형 버전, 모든 메소드가 동기화 되어 있음
  - ArrayList와 Vector 차이점 검토 필요.
- LinkedList
  - 목록 끝에 원소를 추가하거나 끝에 있는 원소를 쉽게 제거할 수 있는 메소드 제공
  - 스택, 큐, 양방향 큐 등을 만들기 위한 용도

#### Collection Set

- HashSet
  - 객체들이 순서 없이 저장되며 중복 저장하지 않음
- TreeSet
  - 정렬 방법 설정 가능

#### Collection Map

- HashMap
  - 키와 값의 쌍으로 구성되어 요소를 다루는 컬렉션, null 값 가능
- TreeMap
  - 정렬된 순서대로 키와 값을 저장하여 검색이 빠름

#### StringBuffer, StringBuilder

- StringBuffer와 StringBuilder는 concat 혹은 +를 하지 않으려고 사용하는 것
- String은 불변(immutable)하기 때문에 값을 변경할 수 없어서 .concat 혹은 +를 이용한 값 변경은 기존 String에 들어있던 값을 버리고 새로 값을 할당하는 것이므로 성능에 좋지 않음
- StringBuffer는 공통 메소드가 동기화되므로 멀티 스레드 환경에서 사용
- 멀티 스레드 환경을 고려하지 않아도 된다면 더 성능이 좋은 StringBuilder 사용이 권장

#### Java Stream

- stream
  - 원본 데이터를 읽기만 하지, 원본 데이터 변경은 하지 않음
  - 정렬된 결과를 컬렉션이나 배열에 담아 반환 가능
  - 내부 반복문 (반복문이 코드 상에 노출되지 않음)
- filter
  - 스트림 내에 있는 요소에 대해 필터링
- map
  - 요소들을 조건에 맞게 변환 가능
- collect
  - 스트림 데이터를 원하는 자료형으로 변환

#### Java 8

- 2014.03 출시
- 83% 사용 중
- 주요 기능
  - 람다 표현식
  - 메소드 레퍼런스
  - 스트림 API
  - Optional<T>

#### Optional<T>

- NPE 방지를 위한 장치
- 널이 올 수 있는 값을 감싸는 Wrapper 클래스로 참조하더라도 NPE가 발생하지 않도록 처리
- Wrapper 클래스이기 때문에 빈 값이 올 수도 있으며, 빈 객체는 empty() 메소드로 생성 가능
- orElse / orElseGet 메소드로 널인 경우라도 다른 값을 리턴 가능

#### LTS, 비-LTS 버전 차이

- 실제 서비스 운영환경 (Production)에서는 LTS 버전 권장
- 지원 기간은 5년 이상, 벤더와 이용하는 서비스에 따라 달라질 수 있음
- 배포주기 3년, 매 6번째 배포판이 LTS가 됨
- JDK 17 이후 2년 주기로 전환 (2023년 9월로 예상)
- 현 시점에는 자바 8, 11이 LTS 둘 중 하나를 써야 하는게 바람직
- 다음 LTS: 자바 17
- 매년 3월과 9월에 새 버전 배포
- LTS 버전과의 차이점
  - 얼마나 오래 지원을 하는가?
- 비-LTS
  - 업데이트 제공 기간이 짧음
  - 배포 주기 6개월
  - 지원 기간: 배포 이후 6개월
- Moving Java Forward Faster

#### 스레드풀 (Thread poop)

- 스레드 풀 탄생 배경
  - 프로세스 내에서 스레드 생성 및 수거 작업이 자주 일어나게 된다면 메모리 할당 비용 증가
- 스레드 풀 정의
  - 스레드 제어 문제 해결의 방법으로 스레드 풀 사용
  - 매번 생성 및 수거 요청이 들어올 때마다 스레드를 생성하고 수거하는 것이 아닌 스레드를 사용하는 사용자가 설정해 둔 개수만큼 미리 생성해두는 것
- 풀 (Pool)
  - 필요할 때마다 개체를 할당하고 파괴하는 대신, 사용 준비된 상태로 초기화된 개체 집합
- 기타 설명
  - 스레드는 동일한 메모리 영역에서 생성 및 관리가 이루어지나 생성 및 수거할 때 커널 오브젝트를 동반하는 리소스 이므로 생성 비용이 큼
  - 스레드를 계속 생성하게 되면 리소스가 빠르게 소진되는 상황 발생 가능성도 있음
  - 효과적으로 스레드를 제어하기 위해 스레드 풀 개념 도입
  - 컨텍스트 스위치 발생하는 상황에서 딜레이 감소 효과
  - 스레드 풀에 너무 많은 스레드를 만들어둔다면 메모리 낭비가 심해질 수 있음
- 자바 예
  - int NUMBER_OF_CORES = Runtime.getRuntime().availableProcessors()
  - ExecutorService service = Executors.newFixedThreadPool(NUMBER_OF_CORES)

#### 자바 동기화

- synchronized를 이용하는 방법은 2가지 존재
  - 1. synchronized method 방법
    - 메소드에 락을 걸고자 할 때
    - Runnable을 구현힌 구현체 내 run 안에서 synchronized function 호출
    - 동기화 적용이 필요한 로직을 함수화하고 synchronized 키워드를 붙임
  - 2. synchronized block 방법
    - 특정 객체에 락을 걸고지 할때

#### 함수형 인터페이스

- 인터페이스 안에 추상 메소드가 하나인 인터페이스
  - abstract가 생략된 것이라 생각하면 됨
- 자바 8에서는 static 메소드 정의 가능 / default 메소드도 정의 가능
  - 다른 형태의 메소드가 있더라도 추상 메소드가 하나이면 그것은 함수형 인터페이스
- @FunctionalInterface 를 정의해두면 추상 메소드 하나 더 추가 시 컴파일 에러 발생 (이 어노테이션을 정의하고 있는 추상메소드가 하나인 인터페이스를 함수형 인터페이스)
- 사용하는 부분
  - 보통 전통적으로 익명 함수 구현으로 사용
  - 람다로 변경 가능, 람다는 특수한 형태의 오브젝트라 보면 됨 (일급 객체)
- 같은 값을 인자로 전달했을 때 똑같은 결과를 얻어야 함수형 프로그래밍이라 볼 수 있음 (순수 함수)
  - 위반 케이스: 함수 바깥의 변수를 가져다 쓰는 경우, 상태값을 가지고 있는 경우
    - 단순히 가져다 쓰는 경우는 상관없음. final 변수를 가져다 쓰는 경우는 괜찮음
  - 위반 케이스: 멤버 변수를 사용하는 상황 하 멤버 변수 변경을 가하는 경우
  - 추가 설명
    - 사이드 이펙트 만들 수 없음 (함수 밖에 있는 값을 변경하지 못함)
    - 상태가 없음
    - 함수가 전달하는 파라미터만 사용해야 함
- 고차 함수
  - 함수가 함수를 매개변수로 받을 수 있고 함수를 리턴하는 것도 가능한 함수

#### 자바가 기본으로 제공하는 함수형 인터페이스

- java.util.function 패키지
  - apply 메소드 오버라이드
- Function<Integer, Integer>
- 함수 결합도 가능
  - Function<Integer, Integer> funcTest = (i) -> i + i;
  - Function<Integer, Integer> funcTest2 = (i) -> i * 2;
  - Function<Integer, Integer> funcTest3 = funcTest.compose(funcTest2);
    - println(funcTest3.apply(2));
    - andThen 도 존재
  - BiFunction 인자 2개
  - Consumer<T> 리턴 없음
    - Consumer<Integer> printT = (i) -> println(i);
    - printT.accept(10)
    - IntConsumer printInt = (i) -> println(i);
    - printInt.accept(10);
  - Supplier 인자 없고 리턴만 존재
    - Supplier<Integer> get10 = () -> 10;
    - println(get10.get())
  - Predicate 인자를 받아서 true / false를 리턴
    - or, and 등의 오퍼레이터 사용 가능
    - ex. Predicate.not(TestingClass::isOpened)
  - UnaryOperator<T> 인자값과 리턴값 형이 같은 경우
    - Function<T, T> 상속하고 있음
  - BinaryOperator<T> 3개의 타입이 모두 같은 경우 
    - ex. BinaryOperator<Integer> sum = (a, b) -> a + b;

#### effective final (사실상 final) / 변수 캡쳐 (Variable Capture)

- 자바 8부터 해당
- 해당 지역 변수가 사실상 파이널일 때 이 키워드를 생략 가능
- 변수 캡쳐
  - 자바 8 이전에 익명 클래스와 내부 클래스에서도 쓰이던 기능, 이때는 final 키워드가 필수적이었음
  - 자바 8부터는 사실상 파이널이면 변수 캡쳐 가능 (즉, 변수 참조 가능)

#### Shadowing 개념

- 메소드 내부에서 멤버 변수와 동일한 변수 이름을 정의할 때 이 메소드 내부에서 멤버 변수가 가려지는 현상

#### 람다 표현식

- effective final 인 경우 로컬클래스, 익명클래스, 람다 모두에서 참조 가능
  - 사실 상 final 이라는 의미
  - 만약 final 처럼 람다안에서 쓰고 있는데 어디선가에서 변수 값을 변경하는 코드가 존재한다면 컴파일 에러 발생
  - 로컬 / 익명 클래스는 쉐도잉됨, 각각은 부모와는 다른 스코프임, 따라서 부모에서 선언한 변수와 똑같은 변수를 선언/정의 함으로서 부모 변수를 가릴 수 있음
  - (중요) 람다는 쉐도잉 되지 않음, 스코프가 부모 함수와 동일, 같은 스코프 내 똑같은 이름의 변수 정의 불가능 

#### 메소드 레퍼런스

- 클래스 이름 :: 메소드 이름 형식으로 입력
- 메소드를 호출하는 것이지만 괄호는 생략
- 많은 코드가 생략되어 있으므로 사용하려는 메소드의 인자와 리턴 타입을 알고 있어야 함
- 사용의 이유
  - 메소드 레퍼런스 형태로 작성되는 람다식이 많으며 모든 코드를 다 작성하는 것이 번거로움
- 사용 패턴에 따라 아래와 같이 분류 가능
  - Static Method 레퍼런스
  - Instance Method 레퍼런스
  - Constructor Method 레퍼런스
- 사용 예
  - Class이름::testFunc;
  - Class이름::testFunc::test2
  - 생성자 사용
    - Supplier<Testing> testing = Testing::new;
    - Testing object = testing.get();
    - Function<String, Testing> testing2 = Testing::new;
    - Testing object = testing2.apply("testing");
    - println(object.getName());
- 람다를 넣을 수 있다는 것은 메소드 레퍼런스를 쓸 수 있다라고 이해

#### 인터페이스 기본 메소드와 스태틱 메소드 설명 (자바 8)

- default 키워드 활용하여 기본 구현체를 만들 수 있음
  - 구현하는 쪽에서 해당하는 인터페이스 메소드를 구현하지 않아도 컴파일 에러 발생하지 않음
  - 과거에 컴파일 에러 때문에 인터페이스를 상속하는 추상클래스를 구현하여 빈 함수를 구현해서 최종적으로 API 를 제공하는 형태였으나
  - default 키워드 사용하면 추상클래스 레이어는 불필요
  - 그리고 가장 큰 장점은 implements 로 구현하기 때문에 다른 클래스의 상속도 가능해진다는 큰 장점이 있음 (상속이 강제되지 않음, 비침투성, 비침투적인 방법)
- 템플릿 메소드 처럼 구현 시 어떠한 값이 처리될지 불분명하므로
- @implSpec 어노테이션을 통해 주석을 강화
- Object 에서 정의된 즉, equals, hashcode, toString 등은 재 정의 불가능
- 부모 인터페이스에서 정의한 default 메소드를 사용하고 싶지 않을 때는 자식 인터페이스에서 추상 메소드로 다시 정의해주면 됨
- 동일한 default 메소드를 가진 2개의 인터페이스를 구현하는 경우 컴파일 에러 발생
  - 충돌되는 경우에는 구현하는 측에서 그냥 직접 구현을 해서 새로 작성해야 함 <-- 이렇게 하면 컴파일 에러 처리 가능
- 자주 사용하는 유용한 유틸리티 함수를 인터페이스 내에 정의하여 사용하는 것도 가능
  - 인터페이스.유틸리티 함수명으로 호출

#### 자바 8에서 추가된 기본 메소드로 인한 API 변화

- Iterable
  - forEach: list.forEach(s -> {}), list.forEach(System.out::println)
  - spliterator: list.spliterator()
- Collection
  - list.stream(): spliterator를 사용하고 있음
  - long count = list.stream().map(String::toUpperCase).filter(s -> s.startWith("K)).count();
    - list.stream().map(String::toUpperCase).filter(s -> s.startWith("K)).collect(Collectors.toSet());
  - list.removeIf(s -> s.startWith("K));
- Comparator
  - list.sort(String::compareToIgnoreCase);
  - list.sort(String::compareToIgnoreCase.reversed().thenComparing(...));