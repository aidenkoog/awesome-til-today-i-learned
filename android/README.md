#### 안드로이드 4대 요소 (구성 요소 / 주요 컴포넌트)

- 액티비티: UI 화면을 담당하는 컴포넌트
  - 실제 화면에 보이는 것으로 사용자와 상호작용하는 컴포넌트
  - 같은 앱 내의 다른 액티비티 뿐만 아니라 완전히 분리된 다른 앱의 액티비티와도 상호작용 가능
- 서비스: 화면에 존재하지 않고 백그라운드에서 실행되는 컴포넌트
  - 포그라운드: 알림을 표시해 놓고 사용자 상호작용 없이도 계속 실행
  - 백그라운드: 사용자가 직접 알지 못하는 작업을 수행할 때 사용
  - 바운드: 앱 내 서비스를 사용하여 간단한 클라이언트 - 서버 환경 구성을 의미 (특정 컴포넌트와 서비스 간 상호작용)
- 브로드캐스트 리시버: 단말기에서 발생하는 다양한 이벤트, 정보를 받고 반응하는 컴포넌트
- 컨텐트 프로바이더: 데이터를 저장하고 가져오고 모든 앱에서 접근할 수 있도록 하는 컴포넌트
  - 접근 방법:
    - 다른 앱에서 URI를 이용하여 컨텐츠 리졸버를 통해 다른 앱의 콘텐츠 프로바이더에게 데이터 요청.
    - 요청 받은 컨텐츠 프로바이더는 URI를 확인하고 내부에서 데이터를 꺼내어 컨텐츠 리졸버에게 전달.
- (참고) 프래그먼트 (안드로이드 3.0 이후)

#### 라이센스 종류 / 설명

- GPL v2: 소스를 수정할 경우 공개 필수
  - 안드로이드 운영체제 수정하는 경우에는 소스 공개 필수
- Apache2: 소스 수정하더라도 공개 의무 없음
  - 애플리케이션은 소스 공개 불필요

#### 안드로이드 플랫폼 특징

- 라이센스 사용료나 개발/배포 비용 없음
- 카메라, 센서, GPS, Wi-Fi 등의 하드웨어 접근 가능
- 구글 맵 지원
- 백그라운드 서비스 지원
- SQLite 데이터베이스 지원
- 공유 데이터와 애플리케이션 간의 통신 지원
- 2D / 3D 지원
- 최적화된 메모리와 프로세스 관리

#### 액티비티와 프래그먼트 간 차이점

- 액티비티는 독립적으로 활용 가능
- 프래그먼트는 액티비티에 종속
- 액티비티는 전체 화면을 차지하지만 프래그먼트는 전체 화면이 아니여도 되며 디자인에 많은 유연성이 있음
- 액티비티는 자동적으로 스택에 넣어지고 프래그먼트는 트랜잭션을 통해서 명시적으로 요청해야 함

#### 액티비티와 프래그먼트 라이프사이클 설명

- 액티비티 라이프사이클
  - 액티비티가 시작되고 종료되는 시점까지의 상태
  - 라이프사이클
    - onCreate() => onStart() => onResume() => Activity Running.
    - onPause() => onStop() => onDestroy() => Activity Shutdown.
    - onPause() => onResume() => Activity Running.
    - onStop() => onRestart() => onStart() => onResume() => Activity Running.
- 프래그먼트 라이프사이클
  - 프래그먼트가 시작되고 종료될 때 까지 상태
  - 라이프사이클
    - onAttach() => onCreate() => onCreateView() => onActivityCreated() => onStart() => onResume() => Fragment Active.
    - onPause() => onStop() => onDestroyView() => onDestroy() => onDetach() => Fragment Destroyed.
    - onDestroyView() => onCreateView() => onActivityCreated() => onStart() => onResume() => Fragment Active.

#### View 라이프사이클 설명

- Button, TextView, ImageView 등의 위젯을 작성하는데 사용되는 기본 클래스이자 이 모든 것이 View
- View의 서브 클래스인 ViewGroup은 보이지 않는 컨테이너로써 다른 View들을 다른 View (또 다른 ViewGroup)에 포함 가능
- 라이프사이클
  - 노말 케이스
    - Constructors
    - onAttachedToWindow()
    - measure()
    - onMeasure()
    - layout()
    - onLayout()
    - dispatchToDraw()
    - draw()
    - onDraw()
  - invalidate 호출
    - dispatchToDraw()
    - draw()
    - onDraw()
  - requestLayout 호출
    - measure()
    - onMeasure()
    - layout()
    - onLayout()
    - dispatchToDraw()
    - draw()
    - onDraw()

#### Intent 설명

- Messaging Object (메세지 객체)
  - 이 객체를 통해 다른 컴포넌트 간에 정보를 서로 주고 받는 것이 가능
- 인텐트 타입
  - 명시적
    - 클래스 객체나 컴포넌트 이름을 지정.
    - 호출할 대상을 정확하게 알 수 있는 경우에 사용
    - 주로 앱 내부에서 사용
  - 암시적
    - 호출할 대상이 달라질 수 있는 경우에 사용
    - 안드로이드 시스템이 인텐트를 이용해 요청한 정보를 처리할 수 있는 적절한 컴포넌트를 찾아 사용자에게 그 대상과 처리 결과를 보여줌
- 인텐트 필터
  - 암시적 인텐트를 통해 사용자로 하여금 어느 앱을 사용할 지 선택하도록 할 때 필요
- Pending 인텐트
  - 주로 노티피케이션 이벤트 처리 때 사용
    - Notification은 안드로이드 시스템의 NotificationManager가 인텐트를 실행하는데 다른 프로세스에서 수행하기 때문에 Notification으로 인텐트 수행 시 Pending 인텐트의 사용이 필수
  - 인텐트를 가지고 있는 클래스

#### ANR (Application Not Responding) 설명

- 안드로이드 앱의 UI 스레드가 오랫동안 차단되면 ANR 오류 발생
- 앱이 포그라운드에 있으면 시스템에서 사용자에게 다이얼로그를 표시
  - XXX isn't responding.
- 안드로이드 프레임워크 내 관련 정보
  - 패키지: com.android.server.am.ActivityManagerService
    - system_server 프로세스에서 실행
  - 타임아웃
    - 포그라운드: 10초
    - 백그라운드: 60초
    - 키 처리: 5초

#### Dialog, Toast, SnackBar 차이점 설명

- 다이얼로그: 사용자에게 추가정보를 입력 또는 결정을 내릴때 표시하는 작은 화면
- 토스트: 작은 팝업으로 메세지에 필요한 공간만을 차지하고 진행 중인 작업을 그대로 표시되고 사용자와 상호작용도 유지됨
  - 토스트 메세지는 시간이 초과하면 자동으로 사라짐
- 스낵바: 토스트와 유사하지만 사용자가 메세지에 응답 가능

#### Annotation 설명

- 주석이라는 의미
- 특정 클래스, 변수, 메소드 등에 붙이는 코드로 해당 타켓의 기능을 좀 더 명확하게 해주는 역할

#### Context 설명

- 여러 컴포넌트들의 상위 클래스
- 컨텍스트가 없다면 액티비티, 서비스, 브로드캐스트 시작/발생 불가능
- 리소스 접근 시에도 Context 통해서만 접근 가능
- 추상 클래스
- Context를 직접 상속한 것은 ContextWrapper
- ContextWrapper를 상속한 것은 Activity, Service, Application
  - BroadcastReceiver와 ContentProvider는 Context를 상속한 것이 아님
- 안드로이드 시스템이 어플리케이션이나 컴포넌트 등을 관리하기 위한 것
- 리눅스에서 프로세스에 아이디를 붙여 관리하듯 안드로이드 시스템은 어플리케이션 또는 컴포넌트 등을 컨텍스트로 관리

#### LayoutInflater 설명

- XML에 정의된 Resource(자원)들을 View의 형태로 반환
- 자바코드에서 View, ViewGroup을 사용하거나 Adapter의 getView() 등 배경화면이 될 Layout을 만들어놓고 View의 형태로 반환받아 Activity, Fragment에서 실행하게 됨
- Activity onCreate 내 setContentView 메소드와 같은 원리

#### LiveData 개념 / 사용법 / 동작 원리 설명

- Observer 패턴 활용
- 항상 최신 데이터를 보증
- 액티비티나 프래그먼트의 라이프사이클을 따라 메모리 릭 발생하지 않음
- 라이프사이클 내에서 관찰할 수 있는 데이터 홀더 클래스
- Observer, LifecycleOwner와 쌍으로 추가 가능
- Observer에서 래핑된 데이터의 수정에 대해 알림을 받음
- LifecycleOwner 상태가 Lifecycle.State.STARTED or RESUMED 일때 알림 받기 가능
- observeForever는 항상 액티브 상태로 간주하여 항상 알림 받기 가능
- 수동으로 removeObserver로 옵저버 제거 가능
- 메모리 누수의 위험 없음
- 라이프사이클에 추가된 관찰다는 Lifecycle.State.DESTROYED 로 이동되면 옵저버가 즉시 구독 취소됨

#### 안드로이드 앱 만들 때 중요 파일과 폴더에 대해 설명 (과거 버전)

- src
  - .java / .kt 파일 포함
  - 코드 작성 위치
  - 프로젝트 패키지 이름으로 사용 가능
- gen
  - R.java 소스 파일들 포함
  - 프로젝트에 있는 모든 자원을 참조하는 컴파일러가 생성한 파일
  - 수정하면 안되는 파일
- assets
  - HTML, Text 파일 / 데이터베이스와 같은 정보를 가지고 있음
- bin
  - 빌드 과정에서 ADT에 의해 생성된 .APK 파일 존재
    - .APK는 바이너리 파일, 실행하기 위한 모든 것을 포함하고 있음
- res
  - 안드로이드 어플리케이션에 쓰이는 모든 Resource 파일들을 가지고 있음

#### AIDL 설명

- Android Interface Definition Language
- IPC를 통한 동일한 레벨로 통신하는 클라이언트와 서비스 간 인터페이스 요구사항들을 처리
- IPC 통신을 위해 Parcel을 이용해 데이터들을 원시 타입으로 주고 받음

#### ObservableField와 LiveData 차이점

- LiveData는 라이프사이클을 알고 있음

#### String과 StringBuffer의 차이점

- String: 불변, 문자를 수정하려면 지우고 다시 생성 (new)
  - 문자열 연산이 많으면 기능 저하
- StringBuffer: 가변, 한번 생성 후 필요할 때 크기를 변경하여 문자를 변경
  - append()
- StringBuilder: 동기화 지원 X, 멀티스레드 환경에 부적합
  - 싱글스레드에서는 StringBuffer 보다 성능 좋음

#### RxJava 설명

- Reactive Extensions의 JVM 구현체
- 상태 변화를 관찰하고 있다가 능동적으로 동작하는 프로그램을 작성할 수 있게 도움 (반응형 프로그래밍)
- 복잡한 비동기 에러 처리를 간단하게 구현
- 다양한 플랫폼과 언어 지원 (크로스 플랫폼)
- Observer Pattern + Iterator Pattern + Functional Programming

#### 반응형 프로그래밍 특징

- for if while같은 것이 아니라 sql 쿼리 같은 선언형으로 구성
- 함수를 단지 호출하는 대상이 아니라 변수로도, 혹은 인자로도 전달 가능
- 함수형 언어의 도구들을 자유롭게 활용해야 함 (Java8의 람다 표현식)

#### 안드로이드 상태 관리 방법 설명

- State 패턴 사용한 UI 상태 관리
- 액티비티 + 프래그먼트 구조일 때 각각의 화면에서 공통적으로 사용하는 전역 상태는 액티비티 뷰 모델에 저장헤놓는 것도 방법

#### 안드로이드 레이아웃 종류와 각각에 대한 설명

- LinearLayout
- RelativeLayout
- ConstraintLayout
- TableLayout
- GridLayout
- FrameLayout

#### ListView 와 RecyclerView 차이점

- ListView
  - ViewHolder 패턴이 강제가 아니고 선택적 구현
  - 세로만 지원
  - 아이템 애니메이션 처리 클래스 없음, 애니매이션 처리 어려움
  - 다양한 소스에 대한 아답터 존재
  - 클릭 이벤트에 바인딩 하기 위한 인터페이스 존재
  - 최초 생성이나 스크롤 시 아이템을 생성할 때 마다 뷰 바인딩을 해서 성능 저하 발생
  - 스크롤 시 안 보이던 아이템은 매번 getView() 재호출
  - 아이템 내 뷰들을 매번 findViewById()로 재연결 (자원 낭비)
  - BaseAdapter를 상속받은 ArrayAdapter나 CursorAdapter 등을 사용
  - ViewHolder 패턴을 구현한다면 성능에 관해서는 RecylerView와 비슷하나 뷰 커스텀 작업에 대한 유연성이 낮음
  - 텍스트만 있는 리스트는 빠르게 구현 가능
  - 리스트에는 한 개 이상의 View가 필요한 경우가 있지만 커스텀으로 작업하기 어려움
- RecyclerView
  - ViewHolder 패턴 강제 => 뷰 바인딩 한번만 수행 => 재활용 가능
  - 가로/세로/지그재그 모두 지원
  - 아이템 애니메이션 처리 클래스 존재
  - 데이터 제공을 위해 아답터 직접 구현 필수
  - 개별 터치 이벤트 관리 가능, 클릭 처리 기능 없음
  - 아답터 클래스를 직접 구현하기 때문에 뷰 커스텀 작업에 대한 유연성이 리스트뷰보다 쉽고 편함

#### AsyncTask Deprecate 된 이유

- 따로 명시해주지 않으면 액티비티가 종료되도 메모리에 계속 남아 메모리 누수 발생
- 오직 한번 실행되고 재사용 불가능한 구조, 비효율적
- Configuration 변경이 일어났을 때 Crash 가능성
- 대체 방안
  - RxJava / Coroutine

#### Application 클래스 설명

- 안드로이드 기본 클래스
- 앱에 대한 모든 컴포넌트, 액티비티와 서비스를 포함하고 있는 클래스
- 어플리케이션 클래스는 응용 프로그램/패키지에 대한 프로세스가 생성될 때 다른 클래스보다 먼저 인스턴스화됨

#### View.GONE 과 View.INVISIBLE 차이점

- INVISIBLE: 뷰를 그려놓고 보이지 않으나 레이아웃에 공간을 차지
- GONE: 아답터에 getView()가 호출되지 않아 뷰를 그리지 않고 공간도 차지 하지 않음
- 예외 상황
  - View.GONE 으로 초기화 하면 뷰가 초기화 되지 않아 임의의 오류 발생 가능성 있음
  - 뷰 처리 (이동, 크기 조절, 애니매이션 처리) 전 View.VISIBLE / View.INVISIBLE 로 선 초기화하여 렌더링 한 다음에 처리 필요

#### Jetpack 설명

- 높은 퀄리티 앱을 쉽게 개발할 수 있도록 도와주는 라이브러리
- 분류
  - Foundation Components
  - Architecture Components
  - Behavior Components
  - UI Components

#### 메인 스레드 설명

- 핸들러 스레드이므로 활성화된 루퍼를 가지고 있음

#### 서비스와 스레드 차이점

- 서비스는 메인스레드 / 스레드는 별도의 스레드에서 동작
- 서비스는 4대 구성요소로 강제 종료되어도 시스템이 자동 시작해주나 스레드는 자동 시작 되지 않음
- 참고.
  - 안드로이드 실행 => 메인스레드 생성 => 이벤트 발생 => 스레드에서 이벤트 처리

#### SharedPreferences 설명

- 안드로이드에서 사용 가능한 데이터 저장소
- 데이터를 파일로 저장 (XML) / 파일이 앱 폴더 내에 저장되므로 앱 삭제 시 데이터도 삭제됨
- Key Value 형태로 원시 데이터 형태로만 저장 가능
- 단순 저장 용도일 때 자주 사용
  - 자동로그인 플래그 저장

#### MVVM 설명

- 디자인 패턴 일종으로 Model-View-ViewModel로 구성
- View 에는 Activity와 Fragment 등이 속함. 사용자의 액션을 받고 ViewModel의 데이터를 관찰하여 View를 갱신
- ViewModel은 뷰가 요청한 데이터를 Model로 요청하고 Model한테 요청한 데이터를 받음
- Model은 ViewModel이 요청한 데이터를 반환하고 DB 사용 또는 HTTP API 호출 등을 담당
- 기능별로 모듈화가 잘 되므로 개발 및 유지 보수에 용이하고 UI 업데이트가 간편

#### ViewModel 설명

- 라이프 사이클을 고려하여 UI 관련된 데이터를 저장, 관리하기 위해 사용
- 화면 전환과 같이 설정이 변경되는 상황에서도 데이터를 유지
- 액티비티가 끝날 때까지 사라지지 않고 뷰의 생명주기와는 별개로 흘러감

#### 데이터 바인딩과 뷰 바인딩 차이

- 뷰 바인딩
  - 기존에 불편했던 findViewById의 대안책
  - 뷰의 개수대로 코드 추가가 불필요해서 편리하고 Null Safety
  - 데이터 바인딩에 비해 간단하고 효율 좋고 용량도 절약되는 장점
  - 단순 findViewById 대체 용도라면 사용 권장
- 데이터 바인딩
  - 뷰 바인딩 역할 수행
  - 동적 UI 선언 가능
  - 양방향 데이터 결합 지원
  - 데이터와 뷰를 연결하는 작업을 레이아웃에서 처리

#### Intent 설명

- 앱 컴포넌트 간에 작업 수행을 위한 정보를 전달하는 역할
- 액티비티 간의 화면 전환 작업에도 많이 사용
- 명시적 인텐트
  - 클래스 객체나 컴포넌트 이름을 지정하여 호출 대상을 확실히 알 수 있는 경우를 의미
- 암시적 인텐트
  - 호출 대상의 속성들을 지정했지만 그것을 처리하는 대상은 달라질 수 있는 경우를 의미

#### Bundle 설명

- Map 형태로 구현된 데이터의 묶음
- 데이터의 저장 객체로 상태 저장 및 복구에 사용

#### OOM (Out Of Memory) 설명

- Out Of Memory 약자
- 메모리 릭이 발생 후 계속 증가하면 발생하는 오류
- 가비지 컬렉션으로 메모리 릭을 계속 방지해야 발생하지 않음
- 주로 액티비티에서 Inner Class를 사용하거나 Handler 를 액티비티가 종료된 후에도 사용하는 경우 발생

#### Android Architecture (안드로이드 자체 아키텍쳐) 설명

- Linux Kernel
  - 메모리 관리 / 보안 설정 / 네트워크 시스템 관리 등 수행
- Libraries And Runtime
  - 안드로이드 기능 라이브러리와 가상머신의 역할 수행 / 모바일 DB와 그래픽 등을 담당
- Android Framework
  - 생명 주기와 환경 설정 등의 역할 수행
  - Ex. GPS, 리소스 관리 등
- Android Applications
  - 기본 제공하는 역할
  - 전화걸기, 웹 브라우저 등

#### 안드로이드의 메니페이스 파일에 대한 설명

- 앱의 이름, 버전, 구성요소, 권한등 앱의 실행에서 꼭 필요한 정보가 저장되어 있는 파일
- xml파일로 프로젝트의 최상위에 존재
- 태그 구성으로 가장 위는 manifest 태그가 존재하고 패키지명, 버전 등이 기재됨
- application 태그에는 앱 아이콘, 앱 이름등의 정보가 저장
- activity 태그에는 액티비티 클래스명과 액티비티 이름을 정의
- activity 하위에는 intent-filter태그를 이용하여 엑티비티에 대한 인텐트 작업시 필요한 action과 category를 정의
- permission 태그에는 앱에서 필요한 권한을 정의
- 그밖에 sdk버전을 지칭하는 uses-sdk와 다른 패키지를 등록할 수 있는 uses-library등이 존재

#### SQLite와 Realm 비교 설명

- SQLite, Realm은 안드로이드 단말에서 사용하는 관계형 데이터베이스
- SQLite는 오픈소스 데이터베이스로 OS와 상호 작용하기 위해 SQLiteOpenHelper인터페이스를 이용
  - SQLite는 C언어로 되어있고 경량데이터베이스이며 하나의 디스크 파일에 모든 데이터를 저장 가능
- Realm은 크로스 플랫폼 기반의 모바일 데이터베이스
  - IOS와 Android에서 모두 사용이 가능하며 성능 및 효율성이 우수
  - 설치도 간편하며 쿼리 응답속도도 기타 ORMLite나 SQLite보다 더 좋음
  - 크로스 플랫폼이기 때문에 협업에서 유용
  - zero-copy모델을 사용하기 때문에 데이터 객체 자체에서 그대로 작업이 가능
  - 크로스 플랫폼이기 때문에 특정 OS를 가리지 않고 동기화 가능
  - ACID 준수 (원자성, 일관성, 고립성, 지속성)
- 정리
  - Realm은 데이터베이스 컨테이너의 인스턴스
  - SQLite 기반의 ORM 프레임워크

#### WebView 설명

- 안드로이드 프레임워크에 내장된 컴포넌트, View의 형태로 임베딩 가능한 형태
- 웹페이지를 출력 또는 앱 안에서 HTML을 호출하여 앱을 구현하는 하이브리드 형태의 앱 개발하는 데에도 많이 사용

#### 안드로이드의 Task에 대한 설명

- 어플리케이션에서 실행되는 액티비티를 관리하는 스택
- 액티비티를 보관/관리하고 스택 형태의 연속된 액티비티로 구성
- FILO 형태로 나중에 적재된 액티비티가 가장 먼저 사용
- 최초 적재된 액티비티는 Root Activity라고 하고 마지막에 적재된 액티비티는 Top Activity라 함
- Flag 사용하여 액티비티의 흐름 제어 가능

#### 안드로이드 인텐트 플래그 정리

- AndroidManifest에서 플래그를 사용하는 방법과 Intent 소스코드로 사용하는 2가지 방법 존재
- **AndroidManifest**
  - standard
  - singleTop
  - singleTask
  - singleInstance
- **Intent**
  - FLAG_ACTIVITY_BROUGHT_TO_FRONT
  - FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET
    - 테스크가 리셋될 때 플래그가 사용된 액티비티부터 위의 액티비티가 모두 삭제됨
    - Ex. ABCD -> B call - > AB
  - FLAG_ACTIVITY_RESET_TASK_IF_NEEDED
  - FLAG_ACTIVITY_CLEAR_TOP
  - FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS
  - FLAG_ACTIVITY_FORWARD_RESULT
  - FLAG_ACTIVITY_LAUNCHED_FROM_HISTORY
  - FLAG_ACTIVITY_MULTIPLE_TASK
  - FLAG_ACTIVITY_NEW_TASK
  - FLAG_ACTIVITY_NO_ANIMATION
  - FLAG_ACTIVITY_NO_HISTORY
  - FLAG_ACTIVITY_NO_USER_ACTION
  - FLAG_ACTIVITY_REORDER_TO_FRONT
  - FLAG_ACTIVITY_SINGLE_TOP

#### FCM 구동 원리 설명

- 베경
  - 서버 본래의 기능 수행하면서 복잡한 알림 기능까지 수행하려면 서버 속도는 많은 처리량으로 인해 느려질 가능성 존재
- 전체 구조
  - 알림의 기능은 다른 서버가 제공해주고 본 서버는 알림 기능을 제공하는 서버에 알림이 있는지 요청을 해서 정보를 가져오는 구조
- 필요 사항
  - HTTP / XMPP로 FCM과 통신하는 서버와 클라이언트 앱 필요
- 동작 순서
  - 앱 설치 후 최초 실행 시 고유 식별자 토큰 발급
  - 토큰을 서버에 등록
  - 앱 서버에서 FCM 연결 서버로 PUSH 알림을 요청 (토큰 + API 서버 키를 가지고)
  - FCM 연결 서버는 토큰을 대상으로 알림 메세지를 PUSH

#### 하이브리드 앱 설명

- 네이티브 앱처럼 하드웨어 기능 사용 가능
- 마켓 등록 가능
- 배포 후에도 웹만 연결되어 있다면 수정/보완 가능
- 하나의 소스로 iOS와 안드로이드에 맞게 패키징 가능
- 핵심 부분은 웹 앱 기술로 빠르게 제작 가능하여 개발 비용 감소 효과
- 실제 핵심 기능은 코드로 구현하고 지속적으로 업데이트 할 부분은 웹에서 관리하는 기능
- Ex. 멜론챠트 등

#### Looper 설명

- 스레드간의 신호
- 핸들러에 보낸다고 해서 바로 처리되는 것은 아님
- 동시다발적인 메세지 발생 가능성으로 메세지 큐에 적재했다가 하나씩 처리
- 큐에 들어 있는 내용을 하나씩 꺼내어 처리
- 메인 스레드가 Looper를 가지고 있으며 무한 루프를 돌며 큐의 내용을 처리

#### 안드로이드 스레드 간 통신 방법 설명

- Java IO에서 제공하는 파이프 이용
- 스레드 간 공유 메모리 통한 접근 (인스턴스 멤버변수 / 클래스 멤버 변수)
- synchronized 이용한 시그널링
- BlockingQueue 이용
- 추가 지식
  - 핸들러 - 루퍼 - 메세지 큐 - 메세지
  - (참고) 생산자 스레드: 큐에 메세지 삽입
  - (참고) 소비자 스레드: 데이터(메세지) 읽음
  - android.os.Looper: UI 스레드 (메인 스레드)에 1개 존재, 메시지 발송자 (데이터를 읽는 역할)
  - android.os.Handler: 생산자 스레드를 위한 인터페이스 / 소비자 스레드 메세지 처리 / Looper 객체는 많은 핸들러를 갖지만 모두 같은 큐에 메세지 삽입
  - android.os.MessageQueue: 처리할 메세지들이 담긴 무제한의 연결 리스트 (모든 Looper와 스레드는 최대 하나의 메세지 큐를 가짐)
  - android.os.Message: 실행 메세지

#### 안드로이드 HTTP 라이브러리 히스토리 정리

- 2007
  - 안드로이드 발표, HttpClient, Apache의 DefaultHttpClient 등 사용
  - HttpClient의 여러 버그 존재
- 2011
  - Google Developer 에서 HttpUrlConnection 사용 권장
- 2012 ~ 2013
  - Volley / Square의 OkHttp 등장
- 2014
  - Lolipop 버전 이후 HttpClient의 Deprecated
  - HttpClient를 베이스로 하는 Volley도 Deprecated
- 2014 ~ 현재
  - OkHttp와 Wrapper인 Retrofit 인기
  - Retrofit은 클라이언트 부분과 콜백 형식 등을 플러그인으로 변경할 수 있다는 점에서 장점

#### PendingIntent에 대한 설명

- Intent를 직접 보내지 않고 다른 클래스에서 인텐트를 위임해주기 위한 클래스
- 보통 NotificationBar 와 상호작용하는 앱 작성 시 사용 (노티피케이션 클릭 시 PendingIntent에 작성된 액티비티로 이동)
- 알림바 또는 다른 앱에서 startActivity, sendBroadCast, startService가 실행되게 하고 싶을 때 인텐트를 PendingIntent에 담아서 호출

#### Zygote 에 대해 설명

- 자바로 작성되는 안드로이드 앱의 실행 속도를 빠르게 하기 위해서 앱이 실행되기 전에 가상 머신의 코드 / 메모리 정보를 공유함으로서 앱 실행을 단축
- 안드로이드 프레임워크에서 필요로 하는 클래스와 자원을 미리 메모리에 로딩, 연결 정보를 구성
- 달빅(Dalvik) 초기화 수행
- System Server 실행
- 자바로 작성되어 있음
- app_process 역할
  - 자바로 작성되어 있기 때문에 클래스가 동작하려면 Dalvik 가상 머신이 생성되어야 하고 생성된 가상 머신 위에서 ZygoteInit 클래스를 로딩하고 실행해야 함
  - app_process 실행
    - init (app_process 서비스 시작)
    - app_process 에서 JNI_CreateJavaVM() 호출
    - Dalvik VM 생성
    - ZygoteInit.main() 호출
      - ZygoteInit 클래스 기능 (main() 메소드 기능 요약)
        - 새로운 안드로이드 앱의 실행 요청을 받기 위한 소켓 바인딩, registerZygoteSocket()
          - dev/socket/zygote 소켓 바인딩
        - 안드로이드 앱 프레임워크에서 사용할 클래스들과 리소스 로딩, preloadClasses() / preloadResources()
        - SystemServer 시작, startSystemServer()
          - zygote에서 달빅 가상 머신 구동 => 시스템 서버라는 자바 서비스를 실행하기 위해 새로운 달빅 가상 머신 인스턴스 생성
          - Audio Flinger, Surface Flinger 네이티브 서비스 실행, 필요한 서비스를 실행하고 나면 안드로이드 프레임워크 서비스를 시작
        - 새로운 안드로이드 앱 실행 요청에 대한 처리, runSelectLoopMode()
- 안드로이드 초기 시작 과정 (Zygote 실행)
  - init 실행
  - Daemon (Native Services) 실행
  - Zygote 실행

#### 안드로이드 프레임워크 시작 과정

- Native Service
  - init
  - daemons / runtime / Zygote
  - runtime => Service Manager
- Virtual Machine
  - Zygote => Dalvik VM
- System Server
- Surface Flinger
- Java Service
  - WindowManager / ActivityManager / PackageManager / PowerManager / ContentManager / BluetoothManager / ...

#### 새로운 안드로이드 앱 실행 시 내부적으로 이루어지는 과정 설명

- Process 클래스에서 ZygoteInit 클래스 connect
  - start() => startViaZygote() => zygoteSendArgsAndGetPid()
  - zygoteSendArgsAndGetPid() 실행 시점에 connect
  - framework/base/core/java/android/os/Process.java
- ZygoteInit 클래스는 ZygoteConnection 벡터 배열을 가지고 있음
- ZygoteConnection 객체 생성
- Process 클래스의 zygoteSendArgsAndGetPid() 호출 때 Process 생성 arguments 를 ZygoteConnection 객체로 전달
- ZygoteConnection 내 runOnce() 메소드 통해 새로운 프로세스 생성 (fork process)
- Process 클래스에 생성된 프로세스 PID 정보 반환

#### 바인더 (Binder) 설명

- IPC (Inter Process Communication) 도구
- 안드로이드에서 다른 프로세스에 있는 함수를 마치 현재 프로세스에 존재하는 함수처럼 사용 가능하게 해주는 RPC를 지원하는 데에 이용
  - RPC: Remote Procedure Call
- 안드로이드에서 Binder Driver를 추가해서 프로세스 간 통신 수행하는 이유
  - 리눅스의 좋은 메모리 관리 기법 그대로 활용 목적
  - 커널 공간을 통한 데이터 전달 시 데이터 신뢰성 확보 목적
  - 사용자 공간에서 접근 불가능한 커널 공간 활용해 데이터 통신을 하기 때문에 IPC간 보안 문제 해결
  - (참고) 안드로이드 커널
    - Display Driver / Camera Driver / Bluetooth Driver / Shared Memory Drivers / Binder (IPC) Driver / USB Driver / Keypad Driver / WiFi Driver / Audio Drivers / Power Management

#### 직렬화와 역직렬화 설명

- 직렬화 (Serialization)
  - 객체를 직렬화하여 전송 가능한 형태로 만드는 것
  - 데이터를 연속적인 데이터로 변형하여 Stream을 통해 데이터를 읽도록 해줌
- 역직렬화 (Deserialization)
  - 직렬화된 파일 등을 역으로 다시 객체의 형태로 만드는 것
  - 저장된 파일을 읽거나 전송된 Stream 데이터를 읽어 원래 객체의 형태로 복원

#### Serializable와 Parcelable 설명

- Serializable
  - 표준 Java 인터페이스
  - 자바 기본 타입과 java.io.Serializable 인터페이스를 상속 받은 객체는 직렬화를 위한 기본 조건을 충족
  - 단순 마커 인터페이스 (직렬화 대상이라고 알려주는 역할)
  - 내부적으로 Reflection을 사용 (처리 과정 중 추가 객체 생성함을 의미)
    - 생성된 추가 객체들은 GC의 타겟이 되고 GC의 과도한 동작으로 성능 저하 및 배터리 소모 등으로 이어짐 (시스템 비용 발생)
- Parcelable
  - 직렬화를 위한 Android SDK 인터페이스
  - Reflection 사용하지 않고 프로그래머가 직접 설정해주기 때문에 속도가 상대적으로 빠름
  - IPC에 최적화된 기능 제공
  - 구현 및 유지 보수 비용 발생

#### 안드로이드에서 메모리 누수를 줄일 수 있는 방법 설명

- 메모리 누수 발생 원인
  - 정적 뷰에 Activity를 참조
  - 작업 스레드에 대한 Activity 누수
  - 스레드 자체 누수
- 메모리 누수 줄이는 방법
  - onDestroy에서 정적 변수 참조를 끊음 (Null로 초기화)
  - Inner Class를 만들 때 가능한 한 정적으로 생성

#### 안드로이드 APK 파일의 크기를 줄일 수 있는 방법 설명

- 사용하지 않는 리소스 삭제
- 불필요한 종속성 제거
- 여러 개의 APK를 화면 밀도에 맞춰 생성
  - Density 지정
- 특정 ABI(Application Binary Interface)를 지원하는 하나의 APK 생성
  - ARM, API, MIPS, NVS64
- 사용하지 않는 선택적 리소스 삭제
- 리소스 축소 사용
  - minifyEnabled (소스코드를 난독화해서 보안을 강화하거나 앱의 크기를 줄이고 싶으면 true로 설정)
  - shrinkResources 속성을 true로 하게 되면 minify 작업 후 사용하지 않는 리소스를 삭제
- Shape Drawable 사용

#### AsyncTask Deprecated 된 이유

- Context Leak이나 콜백을 빼먹거나 설정 변화의 충돌로 많은 이슈 야기
- AsyncTask가 동작 중일 때 UI의 변화, 즉, 완료된 시점에 UI가 존재하지 않을 때에 대한 문제가 있음 (NPE발생 등)
  - onPostExecute에서 항상 View를 체크해야 되는 번거로움

#### 프래그먼트 생성 시 기본 생성자 사용하는 이유

- 프래그먼트 소스 코드 중 instantiate를 보면 새로운 인스턴스 생성 시 인자가 없는 생성자를 사용하여 초기화
- 생성 시 파라미터를 전달하고 싶으면 Bundle에 담아 setArgument 함수를 호출하는 것이 일반적
- 구글 공식 문서에서도 newInstance()를 통해 Fragment를 생성하는 것을 가이드 및 권장

#### Gradle, Ant, Maven 설명

- Gradle
  - Groovy 기반으로 한 빌드 도구
  - Ant와 Maven 같은 이전 세대 빌드 도구의 단점을 보완, 장점 취합하여 만든 오픈소스로 공개된 빌드 도구
  - XML이 아닌 JVM에서 동작하는 Groovy 기반의 DSL(Domain Specific Language)를 사용
  - Groovy는 자바 문법과 유사, 자바 개발자에 한해서 러닝커브 낮음
  - Gradle wrapper를 시용하면 Gradle이 설치되지 않은 시스템에서도 프로젝트 빌드 가능
- Ant
  - XML 기반으로 빌드 스크립트를 작성
  - 자유로운 빌드 단위 지정 가능
  - 간단, 사용 용이
  - 유연하나 프로젝트 방대해지는 경우 스크립트 관리나 빌드 과정이 복잡
  - 생명주기를 갖지 않아 각각의 결과물에 대한 의존관계 등을 정의해야 함
- Maven
  - XML 기반으로 작성
  - 생명주기, 프로젝트 객체 모델 (POM, Project Object Model) 개념 도입
  - 빌드 스크립트 개선
  - Pom.xml에 필요한 라이브러리 선언하면 자동으로 해당 프로젝트로 불러옴
  - 러닝 커브 높음
  - 라이브러리가 서로 의존하는 경우 복잡해질 수 있음

#### 안드로이드 Repository 패턴에 대한 설명

- DataSource 캡슐화
  - 도메인과 연관된 모델을 가져오기 위해 필요한 DataSource가 무엇인지 Presenter 계층에서는 알 필요가 없음
  - DataSource를 새롭게 추가하는 것이 부담이 없음
  - DataSource 변경이 일어나도 다른 계층에 영향 없음
  - Client는 Repository 인터페이스에 의존하기 때문에 테스트에 용이
  - Presenter 계층과 Data 계층의 Coupling을 느슨하게 해줌

#### Android.mk 작성법

- LOCAL_PATH
  - Ex. LOCAL_PATH := \$(call my-dir)
  - 개발 트리에 있는 소스 파일의 위치 표시
  - 빌드 시스템이 제공하는 매크로 함수 my-dir은 현재 디렉토리 경로를 반환 (Android.mk 파일 자체를 포함한 디렉토리 경로)
- include \$(CLEAR_VARS)
  - LOCAL_XXX 변수를 자동 삭제하는 GNU Makefile
    - Ex. LOCAL_MODULE / LOCAL_SRC_FILES / LOCAL_STATIC_LIBRARIES 등
  - LOCAL_PATH는 삭제하지 않음
- LOCAL_MODULE
  - Ex. LOCAL_MODULE := hello-jni
  - 빌드하려는 모듈 이름
  - 이름에 알맞는 접두사와 접미사를 자동으로 추가하여 so파일의 라이브러리 생성
    - libhello-jni.xo 생성
- LOCAL_SRC_FILES
  - Ex. LOCAL_SRC_FILES := hello-jni.c hello2-jni.c
  - 공백으로 여러파일 구분
  - C / C++ 파일 목록 포함
- include \$(BUILD_SHARED_LIBRARY)
  - 시스템이 모든 것을 하나로 연결하게 도와줌
  - 빌드 시스템이 .so 확장자를 가진 라이브러리 파일을 생성
- LOCAL-CFLAGS
  - C / C++ 소스파일 빌드할 때 빌드 시스템에 전달할 컴파일러 플래그 설정
  - C++ 용 플래그만 지정하려면 LOCAL_CPPFLAGS 사용

#### 4대 컴포넌트 중 브로드캐스트 리시버 설명

- OS로부터 발생하는 각종 이벤트와 정보를 받아와 핸들링하는 컴포넌트
- 네트워크 끊김, 문자 메세지 수신 등과 같은 정보를 받아 처리해야 할 필요가 있을 때 동작
- 이런 메세지를 받기 위해 브로드캐스트 리시버를 구현하면 되고 해당 정보가 오면 이벤트
  처리 가능

#### 컨텐트 프로바이더 (Content Provider) 설명

- 데이터를 관리하고 다른 앱의 데이터를 제공하는 데 사용되는 컴포넌트
- 앱 간의 데이터 공유를 위해 표준화된 인터페이스를 제공
- 앱 계층과 데이터 계층 분리하여 중간 가교 역할 담당
- 앱은 컨텐트 프로바이더에 접근하면 필요한 데이터를 얻어 올 수 있음

#### 안드로이드 멀티스레드

- 기존 방식
  - Thread를 직접 사용하는 방식
  - Runnable을 만든 후, Thread에 Runnable을 넘겨서 실행하도록 한 방식
  - Executor Service를 활용해 Thread Pool을 만들어 Runnable을 submit 하는 방식
  - Rx 라이브러리를 이용하는 방식

#### 안드로이드 화면 전환 시의 함수 호출

- 화면 회전 시 onDestroy 호출 후 onCreate 가 호출

#### Coroutine Flow

- 순차적으로 값을 내보내고 정상적으로 또는 예외로 완료되는 비동기적인 데이터 스트림
- 코루틴 상에서 리액티브 프로그래밍 지원하기 위한 구성요소
- 추가 설명:
  - 데이터 스트림: 리액티브 프로그래밍에는 하나의 데이터를 발행하는 발행자가 있고 해당 발행자는 데이터의 소비자에게 지속적으로 데이터를 전달하는 역할을 하는데 이것을 데이터 스트림이라 함
  - 구성 요소
    - Producer (생산자)
    - Intermediary (중간 연산자)
    - Consumer (소비자)
- Producer (생산자) 는 flow {} 블록 내부에서의 emit()을 통해 데이터를 생성
  - flow{} 블록 선언
  - 실제 API 호출
  - API Result를 emit()
- Intermediary (중간 연산자) 에서는 생성된 데이터를 수정
  - 연산자 예: 자바 8 스트림, RxJava와 유사한 쓰임새로 생각됨
    - map (데이터 변형) / filter (데이터 필터링) / onEach (모든 데이터마다 연산 수행) 등
- Consumer (소비자)
  - collect 이용해 전달된 데이터를 소비 가능
  - 안드로이드 상에서 데이터의 소비자는 보통 UI 구성요소

#### Coroutine Flow 단점 / StateFlow 설명

- Flow 단점
  - Flow 는 데이터의 흐름이고 흐름을 발생시키기만 할 뿐 데이터가 저장되지는 않음
  - UI 업데이트를 위해서는 2가지 방법 존재
    - 화면 재구성 때마다 다시 서버 또는 DB에서 데이터 가져오기
      - 비효율적 방법, 예를 들어 화면 회전 시 onDestroy 호출 후 다시 onCreate 가 호출되는데 이때마다 새로운 데이터를 가져와야 함
    - Flow로부터 collect한 데이터를 ViewModel에 저장해놓고 사용
      - 데이터를 저장하고 있으려면 별도의 데이터 홀더 변수 생성 필요
      - 데이터 홀더 변수는 리액티브 하지 않기 때문에 UI에서 해당 데이터 홀더 변수를 구독하기 위해서는 별도의 fetching 로직 생성 필요
      - 또 다른 방법은 ViewModel에서 데이터 홀더 변수와 flow를 같이 사용하는 것
      - UI에서는 flow에서 값을 발행하기 전에는 마지막으로 발행한 데이터를 저장하고 있는 데이터 홀더 변수의 값을 사용하면 됨
        - 단점: 보일러 플레이트 코드 양산, UIState가 여러가지 인데 모두를 구독하기 위해서 비슷한 코드를 매번 작성해 가독성 저하의 위험 있음
- StateFlow

  - 데이터 홀더 역할 + Flow의 데이터 스트림 역할까지 수행
  - 구조
    - 다수의 Flow 들 ==> StateFlow <== (구독 / 발행) ==> UI
    - Flow를 StateFlow로 변환하는 로직 필요
    - StateFlow가 항상 Flow를 구독하고 있으면 메모리 누수가 발생하므로 StateFlow가 살아있어야 하는 CoroutineScope를 명시할 수 있어야 함
    - StateFlow는 Cold Stream이 아니라 Hot Stream, 마지막 홀딩하고 있는 데이터를 구독하는 구독자에게 전달할 뿐, 구독자가 구독할 때 발행을 위한 로직을 트리거하지는 않음
  - stateIn 함수 사용을 통해 Flow를 StateFlow로 변환 가능
    - scope: StateFlow가 Flow로부터 데이터를 구독받을 CoroutineScope를 명시
    - started: Flow로부터 언제부터 구독을 할 지 명시 가능
    - initialValue: StateFlow에 저장될 초기값 설정

#### Android Apollo GraphQL

- 사용 관련 정보
  - GraphQL 파일 저장을 위한 디렉토리 생성
  - GraphQL 파일 생성 (예. result.graphql)
  - Retrofit2에 비해 초기 설정 복잡하나 RxJava나 코루틴 같이 사용하는 것이 가능하며 Request 요청 부분이 간단하고 명시한 필요 데이터만 받을 수 있어서 효율적

#### 딥링크 (Deeplink)

- 안드로이드에서 이 링크를 클릭하면 앱이 실행되지만 앱이 설치되어 있지 않으면 웹브라우저에서 실행
- 사용 방법 설명
  - intentfilter 설정
    - action
    - category BROWSABLE
    - data host와 scheme 설정
- 딥링크로 실행되지 않은 경우에 data 는 null이므로 앱에서 해당값으로 딥링크인지 앱인지 여부 핀단 가능
- scheme://host/{parameter} 형식으로 추가적인 정보 전달도 가능
- 사용 이유
  - 딥링크가 없다면 사용자는 필수적으로 앱을 검색해서 설치하는 작업을 해야하는데 딥링크를 사용하면 한번의 클릭으로 앱의 원하는 페이지까지 바로 이동

#### UI 렌더링

- 앱에서 프레임을 생성하여 화면에 표시하는 작업
- 사용자와 앱의 상호작용이 원활하게 이루어지도록 하려면 앱이 16ms 미만으로 프레임을 렌더링하여 초당 60프레임을 달성해야 함
- 앱의 UI 렌더링 속도가 느리면 시스템에서 프레임을 건너뛰게 되고 사용자는 앱에서 끊김을 인식
- UI Thread 와 Render Thread(롤리팝 이후) 의 최상의 컨디션으로 초당 60프레임을 달성해야 함

#### ExoPlayer

- 안드로이드 어플리케이션 레벨의 미디어 플레이어
- Android의 미디어 플레이어 대신 사용 가능
- HTTP (DASH) / SmoothStreaming 같은 기능 지원
- 커스터마이징 용이
- 기본 요소
  - ExoPlayer
  - TrackSelector
  - MediaSource
  - DataSource
  - Renderer
  - LoadControl
  - PlayerView

#### Ktor

- JetBrains에서 만들어진 Kotlin을 사용하여 연결된 시스템에서 비동기 서버 / 클라이언트를 구축하기 위한 Open Source Framework
- 서버와 클라이언트 두 가지 모듈 제공 (안드로이드에서 사용할 것은 클라이언트)
- Request를 만들고, Response를 처리하고 인증, JSON 직렬화 등과 같은 플러그인으로 기능을 확장할 수 있는 멀티플랫폼 비동기 HTTP 클라이언트가 포함되어 있음
- JVM, Javascript, Android, iOS 등의 여러 플랫폼을 대상
- 주요 기능
  - 라우팅
  - 요청, 응답 처리
  - 템플릿
  - 컨텐츠 Negotiation / 직렬화
  - 인증 및 권한 부여
  - ions
  - HTTP
  - Socket
  - Monitoring
  - 관리
- 필요 종속성 예.
  - implementation "io.ktor:ktor-client-core:1.6.3"
  - implementation "io.ktor:ktor-client-android:1.6.3"
  - implementation "io.ktor:ktor-client-serialization:1.6.3"
  - implementation "io.ktor:ktor-client-logging:1.6.3"
  - implementation "io.ktor:ktor-client-gson:1.6.3"
- 사용 방법
  - Request, Response 데이터 클래스 정의
  - API URL 정의
  - API 서비스, 즉, 인터페이스 정의 (HttpClient 생성, 로그 레벨 설정, 직렬화 설정, suspend 함수 정의)
  - API 서비스 인터페이스를 구현하는 클래스 정의
  - UI Component에서 CoroutineScope 활용하여 HttpClient 함수를 요청하도록 구현 후 결과값 처리

#### Android Compose

- 2018년도에 구글 IO에서 처음 공개
- 코틀린으로 제작되는 라이브러리
- 기존 XML 방식은 findViewById, ViewBinding, DataBinding 등이 필수적으로 필요했음
- 선언형 프로그래밍 사용
- 리액트 등의 선언형 방식과 유사
- 불필요한 보일러 플레이트 코드 감소
- 직관적인 코드로 UI 생성 가능
- 클래스에서 실시간 미리보기 지원
- 컴포즈 프로젝트 처음 진입법
  - MainActivity 내 setContentView 제거 / XML 제거
  - setContent 함수 사용 => setContent { TextCreate() }
  - @Composable, @Preview 작성한 함수 내 Text, Image 등의 컴포넌트 작성
- Modifier 설명
  - 컴포즈의 UI 구성 요소들을 꾸미거나 행동을 추가하기 위한 요소들의 모음
  - 크기(너비, 높이) 조절 / 패딩, 오프셋 설정 / 배경색 및 라운딩 설정 / 그라데이션 / 알파값 설정 / 보더 설정 등 지원

#### RecyclerView 성능 개선 관련 정보

-

#### Cold / Hot Stream

#### Hot / Cold Observable

#### map, filter, reduce, flatMap

#### interval, zip, combineLatest, switchMap

#### subscribeOn, observeOn

#### just, subscribe, create, fromArray

#### fromIterable, fromCallable, fromFuture

#### disposable, composite dispoable
