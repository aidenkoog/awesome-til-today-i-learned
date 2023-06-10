#### 안드로이드

- 2005년에 구글 사가 인수 (원래는 android라는 회사에서 개발한 모바일 운영체제임)
- 리눅스 커널 기반으로 제작된 모바일 운영체제와 미들웨어, 각종 어플리케이션을 포함한 소프트웨어 집합을 지칭하는 용어
- GPL 라이센스 준수하여 버전 업그레이드 될 때 마다 소스코드도 함께 제공 (오픈 소스 기반)
- 안드로이드 어플리케이션을 개발한다는 의미는 어플리케이션 프레임워크가 제공하는 기능을 사용해야 한다는 것을 의미
- 어플리케이션 프레임워크란 응용 프로그램의 표준 구조를 구현하는 라이브러리와 클래스의 집합체
- 스마트폰 뿐만 아니라 웨어러블 기기, 티비, 자동차 등 다양한 플랫폼에서 동작할 수 있는 OS
- 스마트폰의 안드로이드 점유율이 약 70%
- 안드로이드 리눅스 커널 위에는 라이브러리와 안드로이드 런타임이라는 개념 존재
  - 상위 개념부터 나열하면 애플리케이션 > 애플리케이션 프레임워크 > 라이브러리 / 안드로이드 런타임 > 리눅스 커널
- 안드로이드 구성 요소
  - 액티비티: 사용자가 눈으로 볼 수 있는 화면 구성 요소
  - 프래그먼트: 액티비티 내에서 독자적으로 동작 가능한 화면 구성 요소, 재사용 가능, 한 개의 액티비티 내에서 여러개의 프래그먼트 표시 가능
  - 브로드캐스트 리시버: 시스템에서 제공하는 정보 수신 / 특정 정보를 수신
  - 서비스: 백그라운드에서 실행되는 구성요소
  - 콘텐트 프로바이더: 안드로이드 애플리케이션 간의 데이터 공유를 위해 표준화된 인터페이스 제공
  - 노티피케이션: 사용자에게 특정 이벤트를 알림
  - 인텐트: 안드로이드 구성요소에 다양한 정보를 전달하기 위한 객체
  - 인텐트 필터: 다양한 인텐트를 필터링하여 원하는 인텐트만 수신 가능하도록 하는 구성요소
- 안드로이드 출시 버전
  - Android 1.5 (Cupcake)
  - Android 1.6 (Donut)
  - Android 2.0 ~ 2.1 (Eclair)
  - Android 2.2 (Proyo)
  - Android 2.3 (Gingerbread)
  - Android 3.0 (HoneyComb)
  - Android 4.0 (Ice Cream Sandwich)
  - Android 4.1 ~ 4.3 (Jelly Bean) <-- 나는 여기 버전부터 안드로이드 개발을 시작
  - Android 4.4 (KitKat)
  - Android 5.0 ~ 5.1 (Lollipop)
  - Android 6.0 (Marshmallow)
  - Android 7.0 ~ 7.1 (Nougat)
  - Android 8.0 ~ 8.1 (Oreo)
  - Android 9.0 (Pie)

#### 안드로이드 4대 요소 (구성 요소 / 주요 컴포넌트)

- 앱 구성요소
  - 앱의 필수 구성 요소, 각각은 시스템이나 사용자가 앱에 들어올 수 있는 진입점
- 액티비티: UI 화면을 담당하는 컴포넌트
  - 앱과 사용자가 상호작용을 하기 위한 진입점
  - 실제 화면에 보이는 것으로 사용자와 상호작용하는 컴포넌트
  - 같은 앱 내의 다른 액티비티 뿐만 아니라 완전히 분리된 다른 앱의 액티비티와도 상호작용 가능
  - 앱이 실행되면 화면 표시
  - 사용자의 입력값을 받음
- 서비스: 화면에 존재하지 않고 백그라운드에서 실행되는 컴포넌트
  - 백그라운드에서 오래 실행되는 작업 수행을 위한 컴포넌트
  - UI 없음
  - 포그라운드: 알림을 표시해 놓고 사용자 상호작용 없이도 계속 실행 (예. 음악 재생)
    - startService()
  - 백그라운드: 사용자가 직접 알지 못하는 작업을 수행할 때 사용 (저장소 압축 / 게임 업데이트 / 파일 압축 등)
    - startService()
    - API 레벨 26 이상
      - 즉시 실행해야 하는 작업 : Work Manager
      - 지연 작업 : Alarm Manager
  - 바운드: 앱 내 서비스를 사용하여 간단한 클라이언트 - 서버 환경 구성을 의미 (특정 컴포넌트와 서비스 간 상호작용)
- 브로드캐스트 리시버: 단말기에서 발생하는 다양한 이벤트, 정보를 받고 반응하는 컴포넌트
  - OS 에서 발생하는 이벤트와 정보를 앱에서 수신할 수 있도록 하는 구성 요소
  - 예: 화면 꺼짐 / 배터리 부족 / 사진 캡쳐 등
- 컨텐트 프로바이더: 데이터를 저장하고 가져오고 모든 앱에서 접근할 수 있도록 하는 컴포넌트
  - 파일 시스템, SQLite DB, 웹 상이나 앱이 액세스할 수 있는 다른 모든 영구 저장 위치에 저장 가능한 앱 데이터의 공유형 집합을 관리
  - 디바이스에 저장되어 있는 모든 데이터에 접근하는 것을 관리
  - 다른 앱은 컨텐츠 프로바이더를 통해 해당 데이터를 질의 또는 수정 가능
  - 예: 연락처 정보 / 갤러리 이미지 및 비디오
  - 접근 방법:
    - 다른 앱에서 URI를 이용하여 컨텐츠 리졸버를 통해 다른 앱의 콘텐츠 프로바이더에게 데이터 요청.
    - 요청 받은 컨텐츠 프로바이더는 URI를 확인하고 내부에서 데이터를 꺼내어 컨텐츠 리졸버에게 전달.
- (참고) 프래그먼트 (안드로이드 3.0 이후)

#### 안드로이드 서비스 라이프사이클

- startService()
  - onCreate => onStartCommand => onDestroy
- bindService()
  - 더 이상 바인딩 할 클라이언트가 없을 때 서비스 종료
  - onCreate => onBind => 클라이언트가 없다면? => onUnbind => onDestory

#### 안드로이드 Activity 클래스 / 라이프사이클

- 통상적으로 하위 버전과의 호환성을 고려하여 만든 AppCompatActivity 또는 FragmentActivity 중 하나의 서브 클래스로 생성
- 리눅스 커널 프로세스로 실행
- 하나의 UI (단위 기능의 화면)
- 여러 개의 액티비티 연계 시 인텐트 사용하여 처리
- 하나의 액티비티에서 여러 개의 프래그먼트를 가지는 것도 가능
- Activity 클래스 종류
  - android.app.Activity: 해당 안드로이드 버전의 기본 라이브러리 액티비티 클래스, 모든 다른 액티비티 클래스는 이 클래스의 서브 클래스
  - android.support.v4.app.FragmentActivity: 과거 버전과의 호환성을 유지하면서 프래그먼트를 사용할 때 필요한 액티비티 클래스
  - android.app.support.v7.app.AppCompatActivity: 과거 안드로이드 버전과의 호환성을 유지하면서 새로운 버전의 기능도 사용 가능한 액티비티 클래스
- 안드로이드 런타임이 자동으로 호출하는 메소드 보유 (생명주기 메소드)
- 생명주기 관리의 주된 목적
  - 적시에 액티비티 상태를 저장 또는 복원하기 위한 목적
  - 상태: 액티비티가 현재 보존하고 있는 데이터, 현재 보이는 사용자 인터페이스 데이터를 의미
  - 앱의 완성도와 안정성 증대를 위해 라이프 사이클에 대한 이해가 필요, 아래 이슈들을 방지 가능
    - 다른 앱 전환 시 비정상 종료 이슈
    - 사용자가 앱을 사용하지 않는 데 시스템 리소스가 소비되는 이슈 (텍스트 와쳐)
    - 사용자가 앱을 나갔다가 돌아왔을 때 진행 상태가 저장되지 않는 이슈
    - 화면 가로 / 세로 전환될 때 비정상 종료되거나, 진행상태가 저장되지 않는 이슈
- 생명주기 메소드
  - 액티비티의 상태가 변경된다는 것을 액티비티에 알려주기 위해 안드로이드 런타임이 자동으로 호출하는 메소드를 의미
  - [onCreate]
    - 액티비티 인스턴스가 최초 생성될 때 호출
    - 초기화 작업 진행
      - 멤버 변수 정의 / UI 정의 (setContentView)
    - saveInstanceState 매개변수 수신: 이전 저장 상태가 포함된 번들 객체
    - 동적 상태 정보를 포함할 수 있는 번들 객체 전달됨
    - 동적 상태 정보는 직전에 생성되었다가 소멸된 동일한 액티비티의 인스턴스로부터 받으며 사용자 인터페이스의 상태와 관련되는 데이터임
  - [onStart]
    - onCreate / onRestart 메소드가 호출된 후 바로 호출됨
    - 사용자 인터페이스가 곧 사용자에게 보이게 될 것이라고 액티비티에게 알려줌
    - 액티비티 스택의 맨위로 이동하면 onStart 호출 후 onResume이 호출됨
  - [onRestart]
    - 런타임에 의해 이전에 중단되었다가 막 다시 시작될 때 호출
  - [onResume]
    - 액티비티 스택의 맨 위에 있고 현재 상호 동작하는 즉, 실행 중인 액티비티임을 알리는 용도
    - 앱에서 포커스가 떠날 때 까지 onResume 상태에 머무름
  - [onPause]
    - 사용자가 액티비티를 떠나는 첫 번째 신호
    - 매우 짧은 상태, 데이터 저장 / 네트워크 호출 / DB IO 작업은 하면 안됨
    - 반투명 액티비가 띄워져 포커스는 없지만 화면에 보이는 상태일 때 호출
    - onPause 다음에 onResume 또는 onStop 메소드 중 하나가 호출
    - 포그라운드로 돌아가는 경우: onResume 호출
    - 사용자 인터페이스를 사용자가 볼 수 없게 되면 중단되면서 onStop 호출
  - [onStop]
    - 액티비티가 더 이상 사용자에게 보이지 않는 시점
    - onStop 이 후 onRestart 또는 onDestroy 가 호출
    - CPU를 비교적 많이 소모하는 종료 작업을 실행해야 함 (DB 저장)
    - 안드로이드 OS에서 리소스 관리를 위해 해당 액티비티가 포함된 프로세스를 소멸시킬 수 있음
  - [onDestroy]
    - 액티비티가 막 소멸되려고 하거나 자발적으로 소멸될 때 호출 (완전히 종료되기 전에 실행)
    - finish를 호출했거나 메모리 해제 또는 구성 변경 (가로/세로 화면 변경, 멀티 윈도우)이 생겨 런타임이 액티비티를 종결하는 경우 호출
      - (참고) 폴더블 폰, 대형 화면 기기 등장으로 멀티 윈도우 케이스가 추가 되었음
    - 예외. 액티비티가 종료될 때 항상 호출되는 것은 아님
  - 액티비티의 동적 상태를 저장, 복원하기 위한 용도의 메소드
    - [onRestoreInstanceState]
      - 상태 정보가 저장되었던 이전 액티비티 인스턴스로부터 액티비티가 다시 시작하는 경우에 onRestoreInstanceState 는 onStart 메소드가 호출된 후 바로 호출됨
      - onCreate와 유사하게 이전 상태 데이터를 포함하는 번들 객체를 매개변수로서 받음
      - 액티비티 초기화 후 이전 상태 데이터를 복원하는 것이 더 나을 때 이 메소드가 사용됨
    - [onSaveInstanceState]
      - 현재 동적 상태 데이터가 저장될 수 있게끔 액티비티가 소멸되기 전에 호출됨
      - 동적 상태 데이터는 주로 사용자 인터페이스와 관련된 데이터
      - 번들 객체를 매개변수로서 받으며 저장되어야 하는 데이터를 번들 객체에 삽입
      - 저장된 번들 데이터는 액티비티가 다시 시작될 때 onCreate와 onRestoreInstanceState 메소드에 전달됨
      - 동적 상태 데이터가 저장될 필요가 있다는 것을 런타임이 알 경우에만 이 메소드가 호출됨
  - 액티비티 Lifetime
    - [전체] Lifetime: onCreate ~ onDestroy 사이
    - [가시적] Lifetime: onStart ~ onStop 사이 (액티비티는 자신을 사용자에게 화면으로 표시 가능)
    - [포그라운드] Lifetime: onResume ~ onPause 사이
  - 호출 순서 정리
    - onCreate --> onStart --> onRestoreInstanceState --> onResume --> onSaveInstanceState --> onPause --> onStop --> onDestroy
    - onStop --> onRestart --> onStart --> ...
  - 용어 정리
    - 영속적 상태: 앱이 실행되는 동안 파일 / 데이터베이스 등에 저장해야 하는 데이터
    - 동적 상태: 현재 화면에 보이는 사용자 인터페이스와 관련되는 데이터 및 액티비티 내부에서만 보존해야 하는 변수들의 데이터를 의미
  - 추가 설명
    - 홈 버튼 누를 때: onPause => onStop / 다시 진입하면 onRestart => onStart => onResume
    - 다른 액티비티 실행 시
      - 기존: 1. onPause => 5. onStop
      - 신규: 2. onCreate => 3. onStart => 4. onResume
    - 다른 액티비티 보이는 상태에서 다시 백키 눌러서 원래 화면으로 돌아갈 때
      - 기존: 1. onPause => 5. onStop => 6. onDestroy
      - 신규: 2. onRestart => 3. onStart => 4. onResume

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

- 구성요소간의 통신을 가능케 하는 역할
- 다른 앱의 구성요소와도 통신 가능
- Messaging Object (메세지 객체)
  - 이 객체를 통해 다른 컴포넌트 간에 정보를 서로 주고 받는 것이 가능
- 인텐트 타입
  - [명시적-인텐트]
    - 클래스 객체나 컴포넌트 이름을 지정.
    - 호출할 대상을 정확하게 알 수 있는 경우에 사용 (A Activity 에서 B Activity 호출 등)
    - 주로 앱 내부에서 사용
  - [암시적-인텐트]
    - 호출할 대상이 달라질 수 있는 경우에 사용
    - 안드로이드 시스템이 인텐트를 이용해 요청한 정보를 처리할 수 있는 적절한 컴포넌트를 찾아 사용자에게 그 대상과 처리 결과를 보여줌
    - 특정 URL을 실행 이라는 액션을 요청하는 경우, 웹 브라우저 기능을 가진 다수의 앱이 호출될 수 있음 (크롬, 네이버, 사파리 등)
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

#### Context 종류 및 설명

- Context
  - Context는 리소스에 접근하거나, 데이터베이스나 프리퍼런스에 접근하는 등 기타 등등 역할들을 제공
  - 아래에서 비교할 다른 Context와 다른 중요한 점은 애플리케이션에서 현재 실행되고 있는 환경을 가지고 있다는 것
- Application Context
  - 애플리케이션 라이프 사이클에 종속되어 있음(애플리케이션이 만들어지고 유지되다가, 종료될 때 없어진다) 
  - 애플리케이션 컨텍스트는 라이프사이클이 현재 컨텍스트와 상관없는 다른 컨텍스트가 필요하거나 액티비티 활동 범위를 벗어난 컨텍스트를 필요할 때 사용할 수 있음
  - ex. Dialog는 액티비티 Context 가 필요하고, Toast 는 Application Context로 사용 가능 (Toast는 액티비티와 별개로 Window를 가지고 있음)
- Activity Context
  - 액티비티 안에서 사용할 수 있는 Context로 액티비티 라이프 사이클에 종속되어 있음
  - 액티비티의 라이프사이클과 맞물리는 작업에서 필요할 때 사용
  - 제일 많이 사용하는 화면이동에서 A에서 B로 이동할 경우, 이때 A의 액티비티 컨텍스트가 필요
  - 물론 Application Context로도 화면을 실행시킬 수 있지만, 이때는 인텐트에 Intent.FLAG_ACTIVITY_NEW_TASK 플래그가 필요

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
- Java는 객체 지향(Object-Oriented)의 프로그래밍 언어이므로 객체 지향이 아닌 다른 프로그래밍을 하기 위해서는 별도의 도구가 필요
- RxJava는 Java를 이용해 Reactive Programming을 할 수 있도록 도와주는 라이브러리
- 리액티브 프로그래밍(Reactive Programming) 역시 함수형 프로그래밍의 일종
- Reactive Programming이란 데이터의 흐름과 전달을 중심으로 하는 프로그래밍 패러다임으로, 프로그래머가 코드상으로 입력한 절차에 따라 순서대로 동작하는 명령형 프로그래밍과는 달리 데이터의 흐름을 먼저 작성하고 데이터의 흐름에서 발생하는 다양한 이벤트에 따라 수식이나 함수가 실행되는 방식
- Model이나 UI의 이벤트에 따라 View를 자동으로 업데이트하기 위해 안드로이드 프로그래밍에서 주목받게 되었음
- 특징
  - RxJava는 넷플릭스 개발팀에 의해 만들어진 라이브러리
  - 다음과 같은 이유로 만들었다고 함
    - 동시성을 적극적으로 활용하기 위한 목적
    - Java의 Future를 조합하기 어렵다는 점을 해결하기 위한 목적
    - Callback 방식의 문제를 해결하기 위한 목적
  - RxJava는 다양한 요청을 비동기로 생성하고 모든 값을 취합하여 최종 리턴하는 방식으로 진행
  - 리액티브 연산자를 통해 비동기의 흐름을 조합할 수 있는 방법을 제공하며, Callback을 사용하지 않는 방향으로 설계되었음
- 2가지 핵심 API
  - 1. Observable
    - Observable은 데이터의 흐름에 맞게 알림을 보내 구독자가 데이터를 처리할 수 있도록 함
    - Observable은 동기적, 비동기적으로 모두 작동가능하고 아래와 같은 3가지의 알림을 구독자에게 전달
      - onNext: 데이터의 발행을 알림
      - onComplete: 모든 데이터의 발행이 완료되었음을 알림. 이후에 모든 구독은 끝나게 됨
      - onError: 데이터의 흐름 중에 에러가 발생하였음을 알림. 이후에 Observable 동작이 끝남
    - Observable의 다양한 함수들
      - Just
        - 기존에 존재하는 자료구조를 사용하여 데이터를 발행하는 함수
        - 인자로 넣은 데이터를 차례로 발행하는 Observable을 생성
        - 타입이 같은 데이터를 최소 1개부터 최대 10개까지 넣을 수 있음
      - Subscribe
        - 데이터의 흐름을 구독하는 함수
        - onNext, onComplete, onError에 대한 리스너를 설정하고, 데이터의 흐름에서 일어나는 3개의 이벤트에 대한 로직을 실행하도록 만듬
      - unsubscribe
        - Fragment나 Activity에서 생명주기를 처리하던 Subscribe()를 중지하기 위해서는 이벤트를 만드는 Observable들을 모두 취소해야 함. 그렇지 않으면 Memory Leak이 생길 가능성 존재
      - Disposable
        - Subscribe()는 모두 Disposable Interface 객체를 반환하며, 이를 통해 데이터의 흐름을 중단 가능함
        - Observable에서 onComplete가 실행되면 자동으로 dispose()를 호출하여 구동을 종료시킴
      - subscribeOn, observeOn
        - subscribeOn(): observable의 작업을 시작하는 쓰레드를 선택
        - observeOn(): 이후에 나오는 Operator로, Subscribe()의 Scheduler를 변경 가능
  - 2. Single
    - Observable은 0~N개의 Item을 전파할 수 있는 작업 흐름.
    - 하지만 작업이 종료되고, 1개의 Item 만을 전파하는 경우에는 Single을 사용하는데 (복잡하지 않은) 대부분의 작업을 처리하는 경우 
    - ex) dao 등을 통해 데이터를 비동기로 불러오고자 하는 경우에 적절. 
    - Single은 Observable과는 다르게 onSuccess(item)과 onError(throwable) 만을 가짐.

#### 반응형 프로그래밍 특징

- for if while같은 것이 아니라 sql 쿼리 같은 선언형으로 구성
- 함수를 단지 호출하는 대상이 아니라 변수로도, 혹은 인자로도 전달 가능
- 함수형 언어의 도구들을 자유롭게 활용해야 함 (Java8의 람다 표현식)

#### 안드로이드 상태 관리 방법 설명

- State 패턴 사용한 UI 상태 관리
- 액티비티 + 프래그먼트 구조일 때 각각의 화면에서 공통적으로 사용하는 전역 상태는 액티비티 뷰 모델에 저장헤놓는 것도 방법

#### 안드로이드 레이아웃 종류와 각각에 대한 설명

- Layout: View 위젯들을 그룹화하여 배치하기 위한 용도로 사용되는 ViewGroup
- ViewGroup: 다른 View를 포함 가능한 View, 컨테이너 역할 수행
- LinearLayout
  - 여러 View 위젯들을 가로/세로 방향으로 나열할 때 사용하는 레이아웃
  - orientation 속성 통한 가로, 세로 방향 설정 가능
  - 자식 뷰들은 중첩이 아닌 지정한 방향으로 차례대로 쌓이는 형태
  - Weight 속성으로 가중치 설정 가능 (비율)
    - 다양한 디바이스 환경에 dp가 아닌 비율에 따른 대응이 가능하나 onLayout()을 자주 호출하여 서로 간의 상관관계를 파악하므로 (내부적으로) 성능 상 좋지 않음
- RelativeLayout
  - 자식 뷰 위젯들이 서로 간의 상대적 배치 관계에 따라 화면에 표시될 위치가 결정되도록 만들어주는 레이아웃
  - 상대적인 배치 기준 설정이 없으면 내부에서 중첩되어 표시됨
  - 특정 위젯을 기준으로 배치
  - 아무런 조작하지 않으면 왼쪽 상단부터 위젯이 쌓임
- ConstraintLayout
  - 레이아웃에 배치되는 뷰들에 여러 제약을 적용하여 각 뷰의 위치와 크기를 결정하는 레이아웃
  - RelativeLayout의 상대적 위치 관계에 따른 배치 + LinearLayout의 가중치 설정 + Chain 사용을 다른 레이아웃 없이 요소들을 그룹화 가능
  - 성능 향상 장점 (Depth 1로 모든 레이아웃 구성이 가능)
  - 레이아웃에 배치되는 뷰들에 여러 제약을 적용하여 각 뷰의 위치와 크기 결정
  - onMeasure() 메소드 호출 횟수에 있어서 장점
- FrameLayout
  - 주로 하나의 자식 뷰 위젯만 표시할 때 사용하는 레이아웃
  - 추가된 순서대로 쌓이므로 마지막에 추가된 뷰가 가장 상단에 표시
  - 여러 프래그먼트를 동일한 위치 내에서 교체하여 표시하고자 할 때, 프래그먼트의 컨테이너 역할로써 프레임 레이아웃을 주로 사용 (통상적인 예: 로딩 중 프로그레스 바를 보여주고자 할 때 등)

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
- MVVM에서 가장 중요한 핵심은 DataBinding 기술
- DataBinding을 이용함으로써 View는 ViewModel을 Observing하고 있다가, Model의 데이터가 변경되면 ViewModel로부터 알림을 받아 화면을 갱신
- 이러한 구조를 통해 ViewModel은 View의 존재를 모르게 되어 의존성을 낮출 수 있고, 유지보수성을 높일 수 있게 됨
- 이러한 MVVM 아키텍쳐 패턴은 Android에서 LiveData와 RxJava 등을 통해 구현 가능

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

- 앱의 이름, 버전, 구성요소(4대 컴포넌트 의미), 권한등 앱의 실행에서 꼭 필요한 정보가 저장되어 있는 파일 (앱의 필수적인 정보 존재)
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

#### 안드로이드 Launch 모드 종류 및 설명

- 런치모드란 액티비티가 어떤 방식으로 실행되어야 하는지에 대한 방식들
- Standard : 시스템이 액티비티가 시작된 작업(Task)에서 액티비티의 새 인스턴스를 만들고 인텐트의 경로를 이것으로 지정
  - 액티비티는 여러 번 인스턴스화될 수 있고, 각 인스턴스는 서로 다른 작업에 속할 수 있으며 한 작업에 여러 개의 인스턴스가 존재 가능
  - 예. 현재 A -> B -> C 로 쌓여있는 액티비티 스택이 있다고 가정했을 때 현재 B를 다시 실행하고 싶은 상태이고, 이를 standard 로 액티비티 B를 실행할 경우 A -> B -> C -> B 이 됨
- SingleTop : 액티비티의 인스턴스가 이미 현재 작업의 맨 위에 존재하는 경우, 시스템은 새 액티비티 인스턴스를 만드는 대신 onNewIntent() 메서드를 호출하여 인텐트를 해당 인스턴스로 라우팅
  - 액티비티는 여러 번 인스턴스화될 수 있고, 각 인스턴스는 서로 다른 작업에 속할 수 있으며 한 작업에 여러 개의 인스턴스가 있을 수 있다(다만 백 스택의 맨 위에 있는 액티비티가 액티비티의 기존 인스턴스가 아닌 경우에만 이것이 적용).
  - 실행하는 액티비티가 액티비티 스택의 Top 일 때 새로운 인스턴트를 만드는 것이 아니라. 현재 인스턴스의 onNewIntent()를 호출 
  - 예. 현재 A -> B 로 이루어진 액티비티 스택이 있다고 가정했을 때 만약 C 액티비티를 SingleTop 으로 실행하면 A -> B -> C로 정상적으로 쌓임
    - 그리고 현재 A -> B -> C 로 이루어진 액티비티 스택에서 C를 SingleTop 으로 다시 실행하면 A -> B -> C -> C가 되는 것이 아니고 여전히 A -> B -> C로 유지
- SingleTask : 시스템이 새 작업을 만들고 새 작업의 루트에 있는 액티비티를 인스턴스화함
  - 하지만, 액티비티의 인스턴스가 이미 별개의 작업에 존재하는 경우, 시스템은 인텐트의 경로를 기존 인스턴스로 지정
  - 이때 새 인스턴스를 만들지 않고, 해당 인스턴스의 onNewIntent() 메서드를 호출하는 방법을 사용
  - 한 번에 액티비티 인스턴스 한 개씩만 존재할 수 있음
  - 예. A -> B -> C -> D 로 이루어진 액티비티 스택이 있다고 가정했을 때 현재 액티비티 D를 SingleTask 모드로 실행하면, A -> B -> C -> D이고 D의 onNewIntent() 가 호출됨
    - 그리고 액티비티 B를 SingleTask 로 실행하면, 액티비티 스택은 A -> B 로 바뀌고, 액티비티 C, D 는 소멸됨
- SingleInstance : "singleTask"와 동일
  - 단, 인스턴스가 있는 작업에 대해 시스템이 어떤 액티비티도 시작하지 않은 경우는 예외
  - 액티비티는 언제나 자신의 작업의 유일무이한 멤버이고, 이것으로 시작한 액티비티는 모두 별개의 작업에서 열림.
  - 예. A -> B -> C -> D로 이루어진 액티비티 스택이 있을 때 만약 액티비티 D를 singleInstance 모드로 실행할 경우, 아래와 같이 작업이 분리됨
    - Task 1 - A -> B -> C
    - Task 2 - D

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

#### Android Compose 개요

- 2018년도에 구글 IO에서 처음 공개
- 코틀린으로 제작되는 라이브러리 (자바에서는 사용 불가능)
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
- UI와 기능을 한번에 코딩 => 옵저빙하여 상태 갱신하는 컨셉은 장점
- 기존에 주로 사용되던 라이브러리와 함께 사용 가능
  - 이미지 라이브러리: Glide / Coil
  - DI: Dagger, Hilt
  - 비동기 처리: Coroutines, Flow
  - 네트워크: Retrofit, Ktor
  - 애니매이션: Lottie

#### Android Compose 실제 사용에 관련된 내용 정리

- Surface
- Text
  - style / maxLines / overflow
- @Composable
- @Preview
- Modifier
  - Modifier.padding
- Column
- Divider
- Compose는 기존의 옵저버 패턴과 같이 앱 데이터의 변경 사항을 관찰하기 위한 도구를 제공하여 자동으로 기능을 호출하는데 이를 recomposing이라 함
- Compose는 데이터가 변경된 구성 요소만 재구성, 영향을 받지 않은 구성 요소를 건너뛸 수 있도록 개별 구성 가능에 필요한 데이터를 확인함
- remember (데이터가 변경될 때의 상태를 유지 가능)
- State hoisting (내부 상태를 호출한 함수에 의해 제어 가능하게 만드는 방법?)
- Modifier.weight, Modifier.fillMaxHeight 
- Button (colors 속성, ButtonDefaults.buttonColors)
- LazyColumn (RecyclerView와 동일한 기능, 뷰를 재활용하지는 않음)
  - 스크롤할 때 새로운 Composable을 내보내고 그것이 기존 방법인 View를 인스턴스화하는 것에 비해 상대적으로 효율적
- animateColorAsState

#### UI 렌더링

- 앱에서 프레임을 생성하여 화면에 표시하는 작업
- 사용자와 앱의 상호작용이 원활하게 이루어지도록 하려면 앱이 16ms 미만으로 프레임을 렌더링하여 초당 60프레임을 달성해야 함
- 앱의 UI 렌더링 속도가 느리면 시스템에서 프레임을 건너뛰게 되고 사용자는 앱에서 끊김을 인식
- UI Thread 와 Render Thread(롤리팝 이후) 의 최상의 컨디션으로 초당 60프레임을 달성해야 함

#### RecyclerView 성능 개선

- ViewHolder 내부에서 뷰 애니매이션 사용 지양 (예. itemView.animate() 호출)
- 변경이 된 데이터에 대해서만 Adapter 업데이트 지향 (예. notifyItemChanged(4))
- NotifyItemRangeChanged()는 전체 뷰를 업데이트하므로 많은 사용은 지양 필요
- DiffUtil 사용한 Adapter 성능 측정 가능
- onBindViewHolder 내부에서 View.OnClickListener Set 지양
- setHasStableIds와 getItemId 사용
  - 성능향상의 핵심은 onBindViewHolder 호출을 최소화하는 것
  - setHasStableIds(true) 사용 시 각각 아이템 position에 지정된 id를 기준으로 상황에 따라 onBindViewHolder() 호출을 제외시킴
  - 값이 변경된 id만 onBindViewHolder를 호출하거나 호출된 아이템의 id가 이전 position 아이템에 이미 존재할 시 onBindViewHolder 함수를 호출하지 않고 이전에 같은 id를 가진 뷰를 대신 보여줌
- 새로운 데이터 추가 / 삭제 시 특정 포지션 변경 함수 사용
  - 데이터 변경: notifyItemChanged, notifyItemRangeChanged
  - 데이터 추가: notifyItemInserted, notifyItemRangeInserted
  - 데이터 삭제: notifyItemRemoved, notifyItemRangeRemoved
  - 데이터 이동: notifyItemMoved
- 위의 설명대로 구현 시 코드량 증가가 문제가 되므로 이를 해결하기 위해서는 DiffUtil을 사용
  - DiffUtil을 사용한다면 setHasStableIds(true)와 getItemid()는 사용하지 않아도 됨
- 고정된 크기의 아이템 UI를 사용한다면 setHasFixedSize를 true로 설정
  - false 일 경우 requestLayout() 호출이 이루어져 아이템의 레이아웃 계산이 다시 이루어짐
- setItemViewCacheSize 통한 캐시 크기 조정
  - 스크롤을 통해 화면에서 UI가 사라졌을 때 사라진 뷰를 다시 사용하는 Recycled View Pool에 들어가지 않고, Cache에 저장되어 다시 화면에 나왔을 때 onBindViewHolder 호출없이 뷰가 보여짐
  - 동일한 뷰를 다시 그리지 않음
- 끝없는 스크롤을 해야하는 리스트라면 애니매이션을 제거
  - recyclerView.setItemAnimator(null)
- 중첩된 리싸이클러뷰를 사용한다면 서로간의 Pool을 공유하여 성능 향상 가능
- onBindViewHolder 최적화
  - 순수 데이터 Set만 하는 것이 가장 이상적
  - 외부에서 데이터를 미리 가공해서 사용만 하는 뱡향 지향
  - for, while 문 지양
  - 콜백 / 리스너 정의 지양
- viewHolder 및 onCreateViewHolder에서 가능하면 미리 값을 처리해놓는 방향 지향
  - ViewHolder의 init{} 안 또는 onCreateViewHolder에서 미리 값을 처리
- onBindViewHolder 내에서 Html.fromHtml() 사용 지양
- ConstraintLayout 활용한 1Depth의 XML 작성 필요
  - Depth가 깊어질 수록 UI 연산이 배로 증가
- 부모 뷰 그룹이 스크롤 뷰 또는 리싸이클러 뷰인 경우
  - recyclerView.setNestedScrollingEnabled(false) 설정
- item에 복잡한 Drawable 사용 지양
  - layout-list 로 이루어진 복잡한 drawable은 저가용 기기에서 GPU에 부하를 줌
- ViewStub 사용
- 투명색 사용 지양
  - 저가용 기기에서 부하가 심함
- Image 최적화
  - 캐시 사용, Glide의 경우 기본적으로 캐시 처리되어 있음
    - .skipMemoryCacheOf(false)
  - RGB 565 사용
    - 최근 이미지 라이브러리는 기본적으로 ARGB_8888 이 적용되어 있음
    - 565로 변경한다면 메모리 효율을 50% 정도 증가 가능하나 이미지 색상 품질 저하 문제 발생함, 썸네일 수준의 정도면 565로 처리하는 것이 바람직함
  - ImageView의 크기를 match_parent 또는 고정으로 지정
  - 이미지 해상도에 대한 정보를 모를 때 .centerInside 사용
  - .override(200, 200)를 통해서 직접 이미지 사이즈 조절하여 성능 개선 가능
  - 리싸이클러뷰의 onViewDetachedFromWindow 함수 내에서 수동으로 Glide 이미지 로딩 취소 (.clear)
  - OutOfMemory 방지를 위해 Application 클래스 내 onLowMemory, onTrimMemory를 오버라이드하여 .clearMemory 또는 trimMemory를 호출

#### Cold / Hot Stream

- Cold Stream
  - 하나의 소비자에게 값을 전달
  - 생성된 이후 소비하기 시작하면 데이터를 발행 시작
  - 데이터베이스를 읽거나 URL을 통해 서버의 값을 읽는 경우가 대표적
- Hot Stream
  - 하나 이상의 소비자에게 값 전달
  - 데이터 발행이 시작된 이후 부터 모든 소비자에게 같은 데이터를 발행하고 구독자가 없는 경우에도 데이터를 발행
  - 상태가 변하는 값을 읽을 때 또는 네트워크 상태 정보 등의 값을 읽어올 때 사용 가능

#### Hot / Cold Observable

- Cold Observable
  - Observable에 구독을 요청하면 아이템을 발행하기 시작
  - 새로운 구독자로 다시 구독했을 때도 처음부터 다시 아이템을 발행함
- Hot Observable
  - 아이템 발행이 시작된 이후에 모든 구독자에게 동시에 같은 아이템을 발행
  - 새로운 구독자가 구독을 시작했을 때 구독 전에 발행된 아이템을 놓칠 수 있음 (비슷한 예: 브로드캐스트 리시버)

#### map, filter, reduce, flatMap

- map: 데이터 변환 연산자, 원하는 Observable로 만드는 연산
- flatMap: 데이터를 Observable로 변환시키는 함수를 받고, 각 변환된 Observable에서 나온 데이터를 하나로 취합하여 새로운 Observable을 만드는 함수
- filter: if와 같은 분기 / 필터링하는 함수
- reduce: Observable에서 나온 데이터를 순서대로 처리하여 하나의 값으로 만들어내는 함수

#### subscribeOn, observeOn

- subscribeOn
  - 최초 호출에만 적용, 그 뒤 호출은 무시
  - Observable이 데이터 흐름을 발생시키고 연산하는 스레드 지정 가능
  - 호출 시점 상위에 해당하는 부분의 스레드 설정
- observeOn
  - 횟수 제한 없이 호출 가능, 사용 위치가 중요
  - Observable이 Observer에게 알림을 보내는 스레드 지정이 가능
  - 호출 시점 하위 스트림의 스레드 설정

#### just, subscribe, fromArray

- fromArray
  - 숫자, 객체까지 넣을 수 있음
  - int[] 배열은 사용 불가, Integer[] 타입으로 변경하여 사용 가능
- just
  - 인자로 삽입된 데이터를 차례대로 발행하려고 Observable을 생성
  - 최대 10개의 값 삽입이 가능하고 타입이 같아야지만 가능
- subscribe
  - RxJava는 내가 동작시키기 원하는 것을 사전에 정의해 둔 다음에 실제 그것이 실행되는 시점을 조절이 가능한데 이때 사용하는 것이 subscribe()
  - 인자가 없는 경우: onNext(), onComplete 이벤트 무시, onError 이벤트가 발생했을 때만 onErrorNotImplementedException을 던짐
    - 보통 작성한 코드를 테스트할 때 주로 사용
  - 인자가 1 또는 2개 있는 경우: onNext와 onError 이벤트를 처리
  - 인자가 3개 있는 경우: onNext, onError, onComplete 이벤트 모두 처리 가능

#### fromIterable, fromCallable, fromFuture

- fromIterable: ArrayList, HashSet처럼 Iterable을 구현한 모든 객체를 ObservableSource 로 변환하여 아이템을 순차적으로 발행
- fromCallable: Callable을 Observable로 변환
- fromFuture: Future 인터페이스를 지원하는 모든 객체를 ObservableSource로 변환하고 Future.get() 메소드를 호출한 값으로 변환

#### Disposable, CompositeDisposable

- Disposable
  - 구독 해제도 가능케 하기 위한 인터페이스
  - 인터페이스로 정의되어 있으며 2개의 메소드 정의 (dispose, isDisposed)
  - 무한적으로 아이템을 발행하거나 오래 실행되는 Observable의 경우 제대로 종료하지 않으면 메모리 누수의 위험이 있으므로 명시적으로 Disposable.dispose()를 사용해서 언제든 아이템 발행을 중단 가능
- CompositeDisposable
  - 구독자가 하나가 아닌 여러명인 경우에 해당
  - Disposable을 각각 일대일 대응되게 만들어서 처리하는 것이 번거로우므로 각각의 Disposable을 .add 해서 관리하기 위한 목적
  - Retrofit과 RxJava를 같이 사용해서 서버 통신을 한 화면에서 여러 번 수행하는 경우 사용자가 화면 이탈 시 한꺼번에 구독 해제시키기 위해 CompositeDisposable에 넣고 onDestroy()에서 dispose()를 호출하는 방법 등이 존재

#### WorkManager

- 앱이 종료되거나 기기가 다시 시작되어도 실행 예정인 지연 가능한 비동기 작업을 쉽게 예약할 수 있게 해줌
- 안드로이드의 백그라운드 작업을 처리하는 방법 중 하나
- Android Jetpack 아키텍처의 구성 요소 중 하나
- 하나의 코드로 API Level 마다 비슷한 동작을 보장
- 처리해야 하는 작업을 자신의 큐에 넣고 관리
- 싱글턴으로 구현
- Worker, WorkRequest, WorkState로 구성
- Worker
  - Abstract class
  - 클래스를 상속받고 백그라운드에서 실행하고자 하는 코드를 doWork() 메소드에 정의
  - 작업 상태를 나타내는 Result에 정의된 success(), failure(), retry() 등의 메소드를 통해 결과를 반환
  - 반환된 값에 따라서 이후 동작 결정 가능 (재시도, 중단 등)
  - Result.Sucesss / Result.Failure / Result.Retry
- WorkRequest
  - Worker에 정의된 task를 작동시키기 위한 request를 나타냄
  - WorkRequest를 생성할 때 반복 여부, 제약 사항 등의 정보를 담음
  - OneTimeWorkRequest: 한번만 실행할 작업 요청을 나타내는 WorkRequest
  - PeriodicWorkRequest: 일정 주기로, 여러번 실행할 작업 요청을 나타내는 WorkRequest
- WorkManager
  - 실제로 WorkRequest를 스케줄링하고 실행하며 관리하는 클래스
  - 인스턴스를 받아와 WorkRequest를 큐에 추가하여 실행되도록 함

#### Jetpack Paging 라이브러리

- Android Jetpack에서는 페이징을 위한 Paging3 라이브러리를 제공
- Paging3 라이브러리는 로컬 저장소에서나 네트워크를 통해 데이터를 나누어 효율적으로 로딩할 수 있게 도와줌
- Paging3는 구글에서 권장하는 Android 앱 아키텍처에 맞게 설계되었으며, 다른 Jetpack 컴포넌트와 잘 동작할 수 있도록 설계됨
- 페이징 된 데이터의 메모리 내 캐싱
- 앱이 페이징 데이터로 작업하는 동안 시스템 리소스를 효율적으로 사용 가능
- 요청 중복 제거 기능이 기본으로 제공되어 앱에서 네트워크 대역폭과 시스템 리소스를 효율적으로 사용 가능
- 사용자가 로드된 데이터의 끝까지 스크롤할 때 구성 가능한 RecyclerView 어댑터가 자동으로 데이터를 요청
- Kotlin 코루틴 및 Flow뿐만 아니라 LiveData 및 RxJava를 최고 수준으로 지원
- 새로고침 및 재시도 기능을 포함하여 오류 처리를 기본으로 지원
- 3개의 레이어로 구성
  - Repository
  - ViewModel
  - UI
- 주요 클래스
  - PagingSource
  - RemoteMediator
  - Pager
  - PagingConfig
  - PagingData
  - PagingDataAdapter

#### Paging

- 페이징이란 데이터를 가져올 때 한 번에 모든 데이터를 가져오는 것이 아니라 일정한 덩어리로 나눠서 가져오는 것을 의미.
- 페이징을 사용하면 성능, 메모리, 비용 측면에서 굉장히 효율적

#### Jetpack 자체에 대한 개념 재정리

- Jetpack은 개발자가 관심 있는 코드에 집중할 수 있도록 권장사항 준수, 상용구 코드 제거, 모든 Android 버전과 기기에서 일관되게 작동하는 코드 작성을 돕는 라이브러리
- 안드로이드 Jetpack은 개발에 자주 쓰이는 여러 라이브러리들과 툴들을 묶어놓은 모음집
- 개발자들이 더욱더 편리하게, 빠르게, 쉽게 높은 퀄리티의 앱을 개발하도록 돕는 모음 도구
- androidx.\*로 패키지화되어 있기 때문에 안드로이드 기본 API와 분리되어 있음
- 구성 요소
  - Architecture
    - Data Binding: xml파일에 Data를 연결해서 사용할 수 있게 도와줌
    - Lifecycles: 안드로이드 activity 생명주기 관련 유틸리티
    - LiveData: 데이터가 변경될때 실시간으로 view에 알려줌
    - Navigation: activity, fragment간 이동을 쉽게 도와줌
    - Paging: 대량의 데이타를 관리해주는 유틸리티
    - Room: Database를 보다 쉽게 사용할 수 있게 도와줌
    - WorkManager: 백그라운드 작업을 보다 쉽게 도와줌
  - Foundation
    - AppCompat: 하위 안드로이드 앱에서 최신버전 sdk를 사용할 수 있도록 도와줌
    - Android KTX: 코틀린 코드를 더욱 간결하게 만들어 줌
    - Multidex: dex 관리 관련 유틸리티
    - Test: 안드로이드 테스티관련 유틸리티
  - Behavior
    - Download manager: 큰 파일 다운로드를 service 차원에서 관리함
    - Media & Playback: 미디어 파일 재생 관련 유틸리티
    - Permissions: 안드로이드 권한 관련 유틸리티
    - Notifications: 안드로이드 notification 관련 유틸리티
    - Sharing: Actionbar에서 데이터를 보다 쉽게 공유할 수 있도록 도와줌
  - UI
    - 앱에서의 다양한 애니메이션, 이모지 또는 다양한 플랫폼 (TV, 워치) 관련 유틸리티를 사용할 수 있는 컴포넌트.
    - Jetpack의 컴포넌트는 안드로이드 API 플랫폼의 일부가 아니기 때문에 원하는 컴포넌트를만 androidx.\* 패키지에서 선택해서 사용 가능

#### 안드로이드 파이어베이스 클라우드 메세징 처리

- PUSH 알림 흐름 요약
  - FCM에 앱을 등록하고, 앱도 FCM과 연동
  - 앱 프론트는 필요할 때 FCM 토큰을 발급받고 백엔드로 토큰을 송신
  - 백엔드는 토큰을 유저 정보와 연동하여 DB에 보관하다가, 필요할 때 조회해서 Notification Provider에 푸시 알림을 요청
  - FCM 토큰이란?
    - 푸시 알림을 보낼 디바이스들을 식별하기 위해 존재
    - 각각의 디바이스에 어떻게 개별적으로 푸시 알림을 보내는 가?
      - FCM 토큰으로 디바이스를 구분
      - 디바이스마다 별도의 FCM 토큰이 존재
      - 따라서 DB의 유저 테이블에 FCM 토큰 필드를 추가하고, 푸시 알람을 줄 때 유저의 토큰 필드를 조회하여 보내는 식
  - FCM 토큰을 DB에 저장해야 할까?
    - 구현 방식에 따라 다름
    - 아무래도 DB는 Client로부터 거리가 멈
    - 성능이 크리티컬한 요소라면 In-memory 저장소를 고려 가능
  - FCM 토큰 생성 및 삭제
    - 토큰의 생성
      - 앱을 처음 실행할 때 FCM SDK는 클라이언트 앱 인스턴스에 대한 등록 토큰을 생성
    - 토큰의 만료(Expire)
      - FCM 토큰은 정해진 수명이나 갱신 주기가 없음
      - 시간과 관계없이 아래 이벤트가 발생하지 않는다면 만료되지 않음
        - 앱이 인스턴스 ID를 삭제한 경우
        - 앱이 새 기기에서 복원되었을 경우
        - 사용자가 앱을 제거 / 재설치한 경우
        - 사용자가 앱 데이터를 지운 경우
    - 토큰의 갱신(Refresh)
      - onTokenRefresh() 메서드는 토큰이 갱신될 때마다 호출
      - 갱신될 때마다 동작해야 하는 로직이 있다면, 해당 메서드를 오버라이딩하여 구현
- 토큰 관리
  - 서버에 등록 토큰 저장
    - 서버의 역할: 각 클라이언트의 토큰 추적 / 활성 토큰의 업데이트된 목록 유지 / 토큰 타임스탬프를 구현하고 이 타임 스탬프를 정기적으로 업데이트 필요
  - 토큰의 최신화 보장 (핵심)을 위해 오래된 등록 토큰 제거
  - 토큰 송신 시점
    - 로그인 할 때 / 앱 실행할 때마다
  - 토큰 삭제 시점
    - 프로바이더가 노티피케이션 서버로 푸시 요청을 했을 때, 토큰이 만료되어 에러 메세지가 나오는 경우, 핸들링하여 그 토큰을 삭제
  - 통상적으로 서버에서 토큰 관리
    - 데이터베이스의 유저 테이블에 FCM 토큰 필드 추가
    - 로그인 시 서버에 유저 토큰 저장
    - PUSH 알림 송신 때 이를 조회하여 노티피케이션 서버에 요청
- 예외 상황에 대해 고려해야 할 부분
  - 같은 기기에서 다른 아이디를 사용하는 경우
    - 로그아웃 때 서버에서 유저 토큰을 삭제
  - 같은 아이디로 다른 기기를 사용하는 경우
    - 하나의 유저가 여러 토큰을 보유할 수 있께 스키마 구성
  - 토큰이 갱신되어 서버와 동기화가 필요한 경우
    - 프론트에서 onTokenRefresh() 메소드를 오버라이딩하여 로그인된 유저의 토큰이 갱신될 경우 서버로 토큰을 업데이트하는 API를 호출
  - 오래된 등록 토큰이 있는 비활성 장치에 메세지를 전송하여 리소스 낭비가 되는 경우
    - 서비스의 규모가 커진 다면 발생할 수 있는 문제
    - 데이터베이스에 토큰이 쌓이다 보면 주기적 알림 서비스의 경우에 발생할 수 있는 이슈 존재
    - 푸시 알림의 전송 속도가 느려질 수 있음
    - 정기적으로 토큰의 타임 스탬프를 업데이트하는 서버 로직을 추가하고 오래된 토큰 판단을 위해 임계 기간 (예. 2~3개월 이상) 동안 앱을 사용하지 않은 유저의 토큰은 삭제하고 서버의 모든 등록 토큰을 주기적으로 검색하고 업데이트 하는 방향 권장
- 전체 정리
  - 프론트엔드
    - FCM에 앱 등록
    - 앱에 FCM 연동
    - 서버에 로그인 요청 시 FCM 토큰 전송
    - 서버에 로그아웃 요청 시 FCM 토큰 삭제
    - 앱 실행 시 로그인 되어 있다면 FCM 토큰을 서버에 전송 (타임스탬프 갱신)
    - FCM 토큰이 갱신될 때 로그인되어 있으면 FCM 토큰을 서버에 전송
  - 백엔드
    - 로그인 시 유저의 FCM 토큰 저장
    - 로그아웃 시 유저의 FCM 토큰 삭제
    - 앱 실행 시 유저의 FCM 토큰 타임스탬프 갱신
    - 토큰의 최신화 유지
    - 노티피케이션 서버에 푸시 알림 요청
    - 요청 시 토큰 만료 에러 발생할 경우 해당 유저의 토큰 삭제 처리

#### 플레이스토어 앱 배포 과정 정리

- 등록할 앱 업로드
- 작성 필수 항목
  - 기본 스토어 등록정보: 앱 정보 / 그래픽 리소스 (스크린샷, 주요화면)
  - 스토어 설정
    - 링크
    - 앱 또는 게임 항목 설정
    - 카테고리 설정
    - 이메일 주소 설정
    - 웹사이트 설정
  - 새 버전 만들기: 앱은 플레이 스토어 정책 변경으로 APK 파일이 아닌 AAB 로 앱 빌드하여 업로드 필수
    - 출시노트: 간략한 앱 관련된 노트 작성 (예. 신규 앱 XXX 출시 또는 앱 버그 수정 등)
  - 앱 콘텐츠
    - 링크
    - 개인정보처리방침
    - 광고 여부
    - 앱 액세스 권한: 정책 강화로 사용자가 앱에 진입할 수 있는 방법을 제시하여야 함
      - 이름: 한국 사용자 대상 등
      - 사용자 이름/전화번호: 아이디 또는 전화번호 등
      - 비밀번호: 앱 로그인 비밀번호
      - 다른 안내: 상세 진입 방법 작성 (예. 로그인하여 버튼을 눌러서 튜토리얼 화면을 지나고 확인을 누르면 홈 화면으로 진입 가능의 식으로 작성)
    - 컨텐츠 등급 설정: 설문지 작성 완료하면 자동으로 컨텐츠 등급이 매겨짐
    - 타켓층 / 콘텐츠: 앱의 이용약관 참고하여 대상 연령 지정
    - 뉴스 앱 여부
    - 코로나 19 접촉자 추적 앱 및 이력 앱 여부
    - 데이터 보안
      - 개인정보 수집 상세 내용
      - 위치 (대략적인 위치, 정확한 위치 - COARSE, FINE LOCATION 권한 참고)
    - 광고 ID 사용 여부

#### XML CDATA 설명

- xml 태그 사이 문서 내용에 <b> 또는 <strong> 태그들은 XML의 구조를 위한 것이 아님에도 불구하고 XML을 파싱해주는 프로그램의 경우 관련 태그들 역시 XML의 요소로 인식하여 잘못된 파싱 결과를 불러 일으키게 됨
- 실제로 XML 파서를 통해 해당 내용을 파싱해보려고 하면 파싱이 되지 않는 것을 확인할 수 있음
- XML에서 파싱할 대상으로 인식하지 하지 않도록 그 구역을 지정해주는 것이 CDATA
- XML로 파싱을 원하지 않는 구간의 시작에 <![CDATA[ 를 붙여주고, 구간의 끝에 ]]>를 추가하면 해당 구역이 파싱되지 않도록 설정할 수 있음

#### 안드로이드 센서 설명

- 움직임 감지 센서
  - 세 축을 따라 가속력과 회전력을 측정
  - 가속도계, 중력 센서, 자이로스코프 및 회전 벡터 센서가 포함
- 환경 센서
  - 주변 기온 및 압력, 조도, 습도와 같은 다양한 환경 매개변수를 측정
  - 기압계, 광도계, 온도계가 포함
- 위치 센서
  - 기기의 물리적 위치를 측정
  - 방향 센서와 자기계가 포함

#### 안드로이드 다이얼로그 박스 설명

- AlertDialaog
  - 제목 한개, 버튼 최대 3개, 선택 가능한 항목 목록 또는 맞춤 레이아웃 한개를 표시할 수 있는 대화상자
- DatePickerDialog / TimePickerDialog
  - 미리정의한 UI가 있는 대화상자이며, 사용자가 날짜 또는 시간을 선택 가능
- ProgressDialog
  - API 26에서 Deprecated 되었음
  - ProgressBar를 사용 필수

#### 안드로이드 데이터 전달법

- 액티비티 간: 인텐트
- 프래그먼트 간, 액티비티-프래그먼트 간: 번들

#### Okhttp, Retrofit 라이브러리

- 클라이언트와 서버간 http 통신을 쉽게 하기 위해 사용
- Retrofit은 OkHttp라는 Http 통신 라이브러리 바탕으로 구성
  - Annotation을 사용하여 가독성 제공
- OkHttp는 Interceptor를 통해 로그인을 위한 jwt 토큰을 자동으로 헤더에 붙여주는 등의 편리 제공

#### JWT 토큰

- 서버와 클라이언트 간 정보를 주고 받을 때 Http 리퀘스트 헤더에 JSON 토큰을 넣어서 보내면, 서버는 별도의 인증 과정없이 헤더에 포함되어 있는 JWT 정보를 통해 인증

#### 자바 기본형과 Wrapper 클래스 차이

- 8개의 기본 데이터를 객체 형식으로 다루기 위해 JDK에 의해 지원되는 8개의 클래스(Byte, Short, Integer, Long, Character, Double, Float, Boolean)를 통칭하여 Wrapper 클래스라고 말함
- int, double 등 자바 기본 데이터 타입은 클래스가 아님
- 따라서 기본 데이터 값도 객체가 아님

#### ARM64-v8a(64), ARMv7, ARMx86 등과 같은 ABI(Application binary interface)에 대한 설명

- 안드로이드 디바이스는 다양한 CPU 를 사용하여 만들고, CPU에서 제공하는 명령셋은 다양
- 대표적인것이 ARMv7이 있고, 우리가 작성한 코드가 javac에 의해 바이트 코드(.class)로 바뀌고, Dalvik VM(현재는 ART VM)안에서 JIT 컴파일을 통해 기계어로 번역 되는데, 이때 이 기계어를 해석하고 명령하는데, 이때 CPU 마다 명령을 실행하는 방법이 다르고, 실행 가능한 바이너리 형식, 명령 집합 등이 정의되어 있는 것이 애플리케이션 바이너리 인터페이스(ABI)

#### 액티비티에서 onPause나 onStop이 호출되지 않고 onDestroy가 바로 호출되는 경우에 대한 설명

- onCreate()함수 안에서, finish()를 호출할 경우 시스템은 직접 onDestroy() 를 호출

#### LMK란?

- LMK(Low Memory Killer)
- 안드로이드에서 가용 메모리(available memory)가 부족할 때 프로세스들을 죽이는 동작
 
#### LMK의 목적

- LMK의 목적은 바로 가용 메모리를 확보하는 것
- 이것이 부족하면, PC나 휴대폰 등과 같은 시스템들의 성능이 크게 떨어지고 앱 하나 띄우는데 몇 초 이상의 시간이 걸릴 수도 있는데 이런 문제를 방지하기 위해서 안드로이드는 사용하지 않는 프로세스들을 메모리에서 지워야 함
- 안드로이드 폰들에서 LMK가 바로 이러한 역할을 수행하고 있음
 
#### LMK의 Priority

- LMK는 우선순위를 가지며 우선순위가 낮은 경우 부터 메모리에서 해제
  - 1. foreground process (현재 포그라운드에 올라온 애플리케이션, 현재 동작하고 있는 서비스)
  - 2. visible process (사용자가 화면에서 볼 수 있지만 포그라운드가 아닌 경우 ex. 다이얼로그 에 가려진 onPause 상황 )
  - 3. service process (직접 화면에 보이지는 않지만, 백그라운드에서 동작하는 데이터 업로드 또는 다운로드 경우, 오랫동안 동작한 서비스)
  - 4. cached process (현재 사용하지는 않지만, 메모리에 적재되어 있는 프로그램)
 
#### OOM Killer와 LMK

- 안드로이드는 먼저 LMK로 진행하다가, 더 이상 내릴 프로그램이 없을 때 OOM 순서를 밟음

#### Activity의 onCreate안에서 setContentView를 호출해야 되는 이유

- 액티비티의 onCretate() 메소드는 액티비티 불릴 때 한번만 호출이 되기 때문에, 초기화에 자주 사용
- onResume() 또는 onStart() 같이 여러번 호출 될 수 있는 곳에서 호출하는 것은 매우 비효율적인 코드

#### 화면 회전 시 동작과 상황 대응

- 화면 회전을 했을 때, 현재 만들어진 액티비티 인스턴스는 소멸되고 새로운 Orientation 을 가진 액티비티 인스턴트가 생성됨
- 그렇기 때문에 데이터를 백업해두지 않으면, 메모리에서 해제되기 때문에 이를 유의하여 개발 필수
- 화면 회전이 되었을 때, 데이터가 초기화 되는 것을 막는 방법
  - 기본적인 문제 해결 접근으로는 ViewModel, onSavedInstanceState() 두 방법을 사용하는 방식이 존재
  - 사용 방법
    - ViewModel : 뷰모델은 라이프 사이클을 인지하고 있음
    - 앱의 Configuration (rotation 등) 이 바뀌어 액티비티가 소멸될 때, 사라지지 않고 액티비티가 재생성되었을 때 다시 연결됨
    - 만약에 화면 회전을 3번하면 액티비티 인스턴스의 소멸/생성은 3번 이루어지기 때문에 다 다른 인스턴스이나 뷰모델 인스턴스는 하나임
    - 뷰모델 클래스에 데이터를 저장하면 자연스럽게 해결 가능
    - 또는 onSaveInstanceState() 메소드를 사용하는 방법도 가능

#### 액티비티 클래스의 onSavedInstanceState(), onRestoreInstanceState() 메소드의 역할 재정리

- onSaveInstanceState()
  - 액티비티가 pause 되기 전에 데이터를 저장하는데 사용
- onRestoreInstanceState()
  - 액티비티가 소멸되고 다시 재생성될 때, 액티비티가 가지고 있는 번들로부터 데이터를 회복 가능
  - 또한 onCreate() 와 onRestoreInstanceState() 콜백 메서드는 같은 번들 객체를 전달 받음
  - 보통은 데이터를 회복하는 코드를 onRestoreInstanceState() 에 많이 작성함
  - onCreate 에서 savedInstance를 받아 처리하는 경우에는 처음 실행이 되는지, 재생성되는 것인지 판단하기 위해서, 데이터의 null check 가 필요
    - null 이라면 처음 생성되는 것이고, 아니라면 재생성의 의미

#### 안드로이드 인앱 리뷰 (In App Review)

- Google Play In-App Review API를 사용하면 앱 또는 게임을 종료하는 불편함 없이 
- Play 스토어 평점 및 리뷰를 제출하도록 요청하는 메시지를 사용자에게 표시 가능
- 기기 요구 사항
  - Google Play 스토어가 설치되었으며 Android 5.0(API 수준 21) 이상을 실행하는 Android 기기(스마트폰 및 태블릿)
Google Play 스토어가 설치된 Chrome OS 기기
- Play Core 라이브러리 요구사항
  - 앱에 인앱 리뷰를 통합하려면 앱이 Play Core 라이브러리 1.8.0 이상 버전을 사용해야 함
- play:review dependency 필요
- ReviewManagerFactory 통한 ReviewManager 생성
- Review 요청에 성공 시 ReviewInfo 객체 반환
  
#### Coroutine supervisorScope / coroutineScope

- 코루틴에서 Exception은 자식, 부모 양방향으로 전부 전달됨
  - ex. UI component 에서 하나의 Job을 사용하면 UI 자체를 Destroy하거나 화면을 떠나는 경우 모든 자식들을 취소시킬 수 있음 (자식 중 하나가 실패하게 되면 모든 UI component가 취소되는 상황도 일어남)
- 양방향으로 예외가 발생하는 것을 한 방향으로만 전달하기 위해 SupervisorJob 사용
  - ex. launch 블럭 2개가 있다고 가정할 때 첫번째 launch에서 Exception이 발생을 해도 부모로 전달되지 않으므로 두번째 launch 블럭은 정상적으로 수행되며 첫번째 launche는 예외 발생과 관계없이 완료가 됨
- SupervisorScope
  - SupervisorScope 자체에서 예외가 발생하면 자식 코루틴을 모두 취소시킨 후 부모로 예외를 전달
  - SupervisorScope의 자식 코루틴에서 예외가 발생하는 경우 자식 스스로 예외를 처리해야 함
  - 자식이 핸들러 장착 또는 자식 내부에서 try-catch 처리 등
  - 만약 자식이 핸들러 없이 예외를 발생시킨다면 외부에서는 try-catch로는 이 예외를 핸들링하는 것이 불가능
  - 외부에서 CoroutineExceptionHandler를 이용해서 처리해야 함
  - 여러개의 launch 블럭 즉, 여러개의 코루틴 빌더가 중첩되어 있고 이 중 안쪽에서 예외가 발생하는 경우 핸들러는 가장 바깥쪽에 위치해있어야만 예외를 전달받는 것이 가능
- coroutineScope
  - Exception 발생 시 자식 코루틴을 모두 취소 후 부모로 예외를 전달시킴
  - 부모로 전달된 예외는 try-catch로 처리해야 함 (Exception Handler로는 처리 불가능)
  - 단, try-catch 는 해당 스코프 내부에 존재하면 예외 핸들링이 불가능
  - 실패가 부모 스코프로 전달되는 특성 때문에 try-catch 하는 부분은 예외 발생한 곳과 다른 coroutineScope이어야 함

#### 도메인 레이어에 대한 고찰 (UseCase)
  
- UI 레이어와 데이터 레이어 사이에 있는 선택적 레이어 (Optional)
- 복잡한 비즈니스 로직이나 여러 뷰모델에서 재사용되는 간단한 비즈니스 로직의 캡슐화를 담당
- 복잡성을 처리하거나 재사용성을 선호하는 등 필요한 경우에만 도메인 레이어를 사용해야 함
- 코드 중복 방지 (ex. 여러 뷰모델에서 같은 레파지토리의 모듈을 사용하는 경우 등)
- 도메인 레이어 유스케이스 클래스를 사용하는 클래스, 즉 뷰모델 등의 클래스에서의 가독성 개선
- 앱 테스트 가능성 증대
- 책임 분할 / 대형 클래스 방지
- 도메인 클래스를 간단하고 가볍게 유지하려면 각각의 클래스 내에서는 기능 하나만 담당해야 하며 변경 가능한 데이터를 포함하지 않도록 유지
- 유스케이스 작명 규칙, ex. 동사 + 명사/대상(선택사항) + UseCase => MakeLoginRequestUseCase
- UI 레이어와의 통신은 콜백 또는 코루틴 활용
- 코틀린에서는 UseCase에서 operator와 invoke 함수를 정의하여 UseCase 클래스 인스턴스를 함수처럼 호출 가능하게 만드는 것이 가능
- 클래스 인스턴스를 마치 함수인 것처럼 호출 가능
- invoke는 오버로드도 가능
- 백그라운드 스레드에서 작업을 실행하는 UseCase 정의도 가능
  - CoroutineDispatcher 활용한 처리, 기본 디스패처 사용하면 백그라운드 스레드로 작업을 옮길 수 있음
- 재사용 가능한 간단한 비즈니스 로직 생성 가능
- Repository 들의 결합 가능

#### SuspendCancellableCoroutine
  
- 코틀린의 코루틴 라이브러리 내에서는 일시중단 기능과 함께 콜백함수를 Wrapping하여 사용할 수 있도록 많은 코루틴 빌더들을 제공하고 있음
- 주요 API들
  - suspendCoroutine()
  - suspendCancellableCoroutine() (권장, 양방향으로 취소를 핸들링 가능하므로 사용 추천)
- (참고 지식) 비동기 작업이 펜딩될 때 코루틴은 취소될 수 있음
  - 코루틴이 현재 작업하고 있는 스코프 단위에 의존적이고, 코루틴은 뷰가 계층 구조에서 제거되는 경우 취소될 수 있음
  - 예. 프래그먼트가 스택으로부터 제거될 때 이때 비동기 작업을 취소할 수 있고 진행 중인 리소스들을 정리할 수 있음
- 작업이 취소될 때 추가적인 처리를 수행하는 invokeOnCancellation api 제공
  - 파일 시스템을 사용하거나 리소스의 해제, 소켓 닫기 등의 처리를 위해서는 SuspendCancellableCoroutine을 사용하는 것이 안정적
- (참고) resumeWithException
  - Continuation에서 제공되는 api로 block을 해제하고 외부로 Exception을 Throw 해주는 역할 담당

#### Repository 패턴 재정리

- 데이터의 출처에 관계없이 동일한 인터페이스로 데이터에 접근할 수 있도록 하는 패턴
- 데이터 소스를 캡슐화 (데이터 레이어를 캡슐화 시키는 것이 주된 목적)
- Repository의 Interface는 Domain Layer에 존재하지만, 실제로 데이터는 Data Layer에 존재하기 때문에 Interface의 구현부는 Data Layer에서 작성이 되어야 함
- 왜 구현부와 Repository가 다른 부분에 선언하여 사용하는지?
  - Clean Architecture 구조에서 Domain Layer는 참조를 당할 뿐, 다른 계층을 참조하지 않아야 함
    - View => Domain <= Data
  - Repository가 Domain Layer외에 존재하게 되면 해당 모듈을 참조 받아야하는데, 상호참조가 발생하기 때문에 다른 모듈에 선언할 수 없음
- Repository의 구현부는 Data Layer에 존재해야 하는데, 그 이유는?
  - Repository가 Domain에 존재해야 하는 이유를 생각해보면 간단히 알 수 있음
  - 구현부는 직접 데이터를 가져와서 Control해야 하는데, Domain Layer에서는 Data Layer에 있는 데이터를 가져올 수 없으며 그 반대는 가능
  - Data Layer에 선언하여 Domain Layer에 존재하는 Repository를 상속 받아서 사용하도록 구현을 해야하
- 주된 장점
  - Data Layer에 대한 의존성을 줄일 수 있음
    - 즉, Data Layer와 Presentation Layer 간의 Coupling이 줄어듬
  - Presentation Layer에서 Data Layer에 직접 접근하지 않으므로, 새로운 Data의 추가가 용이함
  - Presentation Layer에서는 Repository에 데이터 요청만 하면 되므로, 일관된 인터페이스로 데이터를 요청 가능
  - Unit Test를 통한 검증이 수월함
- 단점
  - 하나의 허브를 추가하는 것과 마찬가지이기 때문에 관리가 필요한 코드와 파일들이 증가
- ViewModel에서는 직접적으로 DataSource에 접근하지 않고 Repository를 통해 DataSource에 접근하여 데이터를 가져옴
- Usecase에서 Repository를 통해 DataSource에 접근하여 데이터를 가져옴
- Repository를 호출하는 UseCase는 Repository에서 어떠한 데이터를 사용해서 가져오는지 알 필요 없으며, 원하는 데이터만 Return받으면 됨
- ViewModel에서 데이터를 가져와서 UI에 뿌려주는 부분을 보면 단순히 UseCase를 호출하여 return된 값으로만 UI를 뿌려주고 있음
  - Repository의 구현부분을 어떻게 변경하여도 Return 타입에 문제가 발생하지 않으면 빌드 시 오류는 발생하지 않으며, 정상적인 데이터만 return 해준다면 구현 부분은 어떤게 추가/삭제 되어도 영향이 없음
- Presentation Layer와 Data Layer간의 의존성이 낮아지도록 하여 다양한 이점을 얻을 수 있는 디자인 패턴이 Repository Pattern
