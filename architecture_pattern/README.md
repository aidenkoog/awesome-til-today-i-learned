#### 아키텍쳐 패턴 개념

- 주어진 상황에서의 소프트웨어 아키텍쳐에서 일반적으로 발생하는 문제점들에 대한 일반화되고 재사용 가능한 솔루션
- 디자인 패턴과 유사하나 더 큰 범주에 속함
- 경계선을 나누는 기준 / 기술
- 인터페이스가 핵심
- 내부 데이터와 로직들은 안쪽, 요청은 안쪽으로 들어오는 방향
  - Ex. View => ViewModel => UseCase => Repository => Source
- 프리젠터 / 유스케이스 클래스 이름만 보고도 대략적인 기능 파악 가능

#### 아키텍쳐 패턴 대표적인 10가지 설명

- 계층화 패턴 (Layered Pattern)
  - n-티어 아키텍쳐 패턴
  - 계층 4가지
    - 프리젠테이션 - UI 계층
    - 애플리케이션 - 서비스 계층
    - 비즈니스 논리 - 도메인 계층
    - 데이터 접근 - 영속 계층
- 클라이언트 - 서버 패턴
- 마스터 - 슬레이브 패턴
- 파이프 - 필터 패턴
- 브로커 패턴
- 피어 투 피어 패턴
- 이벤트-버스 패턴
- MVC 패턴
- 블랙보드 패턴
- 인터프리터 패턴

#### 아키텍쳐 관련 용어 설명

- Model: 데이터 / 데이터 생성 또는 업데이트
- View: UI / 화면 표시
- Presentation Login: 실제 눈에 보이는 GUI 화면 구성 코드
- Business Logic: 데이터 표시를 위해 데이터베이스 검색하는 코드 및 GUI에서 새롭게 발생된 데이터를 데이터베이스에 저장하는 코드 등의 실제적인 작업

#### MVVM (Model-View-ViewModel) 설명

- 디자인 패턴 일종으로 Model-View-ViewModel로 구성
- 모든 입력은 View로 전달
- ViewModel은 입력에 해당하는 Presentation Logic을 처리하여 View에 데이터 전달
- ViewModel은 View를 참조하지 않기 때문에 독립적 (1:N 관계)
- View는 자신이 이용할 ViewModel을 선택해 바인딩하여 업데이트를 받게 됨
  - Command 패턴이나 Data Binding을 이용하여 V-VM간 의존성 제거 가능
- Model 변경 시 해당하는 ViewModel을 이용하는 View가 자동 업데이트
- ViewModel은 View를 나타내주기 위한 Model이자 View의 Presentation Logic을 처리
- View 에는 Activity와 Fragment 등이 속함. 사용자의 액션을 받고 ViewModel의 데이터를 관찰하여 View를 갱신
- ViewModel은 뷰가 요청한 데이터를 Model로 요청하고 Model한테 요청한 데이터를 받음
- Model은 ViewModel이 요청한 데이터를 반환하고 DB 사용 또는 HTTP API 호출 등을 담당
- 기능별로 모듈화가 잘 되므로 개발 및 유지 보수에 용이하고 UI 업데이트가 간편

#### Command 패턴 설명

- 객체의 행위(메소드)를 클래스로 만들어 캡슐화하는 패턴
- 특정 행위가 명세된 인터페이스를 구현하는 클래스들을 정의 후 실제 행위를 하는 부분에 해당 클래스의 객체를 설정 후 범용적인 메소드(run / invoke() 등)를 호출

#### MVC (Model-View-Controller) 설명

- 모든 입력은 Controller로 전달
- Contoller는 입력에 해당하는 Model을 업데이트
- 업데이트 결과에 따라 View 선택 (1:n 관계로 여러 개의 View 관리 가능)
- Controller는 View를 선택만 할 뿐 직접적인 업데이트는 하지 않음 (View는 Controller를 알지 못함)
- View 업데이트 방법
  - View가 Model을 직접 이용하여 업데이트
    - View 에서 직접 모델 업데이트 후 결과값을 가지고 UI 업데이트
  - Model에서 View에서 Notify 하여 업데이트
    - Interface 통한 onNotify 식의 이벤트 전달
  - View가 Polling하여 Model의 변화를 감지해서 업데이트
    - Polling 또는 Database Observing 등의 방법
- 단점
  - Model <-> View 사이에 의존성 존재하여 앱 규모가 커질수록 유지보수 어려움
  - 안드로이드의 경우 액티비티 (또는 프래그먼트)가 Controller와 View 모두를 처리하기 때문에 한 클래스에서 MVC 모두 처리하게 되는 문제 발생

#### MVP (Model-View-Presenter) 설명

- 모든 입력은 View로 전달
- Presenter는 입력에 해당하는 Model을 업데이트
- Model 업데이트 결과를 기반으로 View 업데이트
- Presenter는 해당 View를 참조 (1:1 관계)
- Presenter는 View와 Model 인스턴스를 가지고, Model과 View 사이의 매개체 역할
- M-V 사이의 의존성은 없으나 앱 규모가 커질수록 V-P 간 의존성이 강해짐
- 1:1 관계이므로 필요한 클래스 개수가 많아짐

#### MVI (Model-View-Intent) 설명

- 요소들 설명
  - Model: UI에 반영될 상태
  - View: UI 자체 (액티비티 / 프래그먼트 / 뷰 / 컴포즈 등)
  - Intent: 사용자 액션 / 시스템 이벤트에 따른 결과 의미
    - Facebook Flux, Javascript Redux에서의 Action과 의미 유사
    - 데이터 방향 흐름: View -> Intent -> Model 순으로 순환
- 상관관계
  - 순수함수 형식 : view ( model ( intent() ) )
  - view에서 UI events 들을 Intent로 전달
  - Intent로 부터 Model을 변경 (Actions to manipulate model)
  - 변경된 Model을 가지고 view 변경 (New model to display)
  - 단방향 순환구조
    - View => User => Intent => Model => View
- Intent가 User를 관찰하고, Model이 Intent를 관찰하고, View가 Model을 관찰하고 User가 View를 관찰하는 Reactive 요소로 구성
- 안드로이드에서는 RxJava 등의 Observable한 외부 라이브러리 사용 필수적
- UI 이벤트 발생 => 모델로 액션 전달 => 새 모델 생성 => 새 모델을 뷰에 표시
- Model은 미들웨어의 개념, 앱 상태와 비즈니스 로직 관리
- Model은 불변의 신규 모델 생성 (변경 불가한 데이터)
  - 단방향 흐름에서 Intent로부터 Model을 생성할 때만 새로운 Model 객체를 생성
  - 예측 가능하도록 상태 설정이 가능하고 이로 인해 디버깅이 수월해지는 효과 발생
- 단방향(Uni-directional) 데이터 흐름과 불변성(Immutability)으로 예측 가능한 상태 생성 가능 => 유지보수 용이
- 디버깅 / 테스트 용이
- 스레드 안정성 보장
- 상태 관리 용이
- 각 파트 간 의존성 없음
- View => ViewModel (Intent => Model) => View
- 작은 변경도 Intent로 처리해야 하는 단점 존재
- Intent, State, Side Effect 등 모든 상태에 대한 객체를 생성해야 하므로 파일 / 메모리 관리에 유의 필요
  - 상태를 변경할 필요가 없는 이벤트 즉, 화면 전환 / 로깅 / Analytics / 토스트 표시 등의 이벤트 처리를 위해서는 Side Effects 개념을 사용해야 함
  - 실제 함수 호출을 위한 Flow 변수 외에 Side Effects 처리용 채널 변수 추가 정의하여 필요한 부분에서 _sideEffects.send("...") 의 방식으로 호출을 해주어야 함
- 실 예제
  - 1. Event 발생 => State 변경 => View 반영 순서
    - StateFlow 정의
    - 함수 호출될 때 StateFlow 변수 값을 업데이트
    - 동시성 오류 발생
  - 2. 동시성 오류 개선을 위한 코드 작성
    - StateFlow 정의
    - 이벤트 채널 정의 후 이벤트 Flow 셋업
    - 함수 호출될 때 이벤트 채널 변수 활용하여 send 함수 호출
    - 기존에 이벤트 Flow 셋업된 코드에서 정의된 함수 호출
    - 함수 내에서 이벤트에 따라 해당하는 값을 StateFlow에 업데이트
    - 동시성, 즉, 스레드 안정성 보장됨
    - StateFlow 변수 접근이 특정 함수 통해서만 되는 것이 아닌 함수 바깥에서도 접근이 가능하다는 이슈 발생
  - 3. State Reducer 개념 적용
    - Reducer = (State, Event) -> State
      - 현재 상태와 전달받은 이벤트를 참고하여 새로운 상태를 만드는 것
      - 이벤트 채널 정의
      - 이벤트 채널 Flow 셋업 (State Reducer 셋업)
      - State Reducer 셋업된 코드에서 정의된 함수가 호출되면
      - 현재 상태와 전달된 이벤트를 참고하여 새로운 상태 생성
        - ex. state.copy(count = state.count + 1)

#### 단방향 아키텍쳐 (Data Uni-Directino-Architecture) 특징

- View는 State를 통해 변경되며 오직 한 방향으로만 수정 가능
- 상태는 불변적인 특성을 지님
- Model은 State를 변화시키며 View는 State만 참조
- 여러 입력 또는 이벤트에 대해서 한 곳에서 관리 가능
- State가 명확하므로 디버깅 수월
- 간단한 토스트 메세지 표시 등의 작업에도 상태를 순환해야 하는지에 대한 의문 존재
- 데이터 흐름 제어를 위한 라이브러리 필요 (Rx, Coroutine Flow 등)
- 물리적인 클래스 개수의 증가