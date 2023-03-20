#### 안드로이드 4대 요소 (구성 요소 / 주요 컴포넌트)

- 액티비티: UI 화면을 담당하는 컴포넌트
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

#### 안드로이드 상태 관리 방법 설명

#### 안드로이드 레이아웃 종류와 각각에 대한 설명

#### ListView 와 RecyclerView 차이점

#### AsyncTask Deprecate 된 이유
