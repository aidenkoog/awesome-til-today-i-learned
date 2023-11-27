#### 안드로이드

- 2005년에 구글 사가 인수 (원래는 android라는 회사에서 개발한 모바일 운영체제임)
- 리눅스 (Linux) 커널 기반으로 제작된 모바일 운영체제와 미들웨어, 각종 어플리케이션을 포함한 소프트웨어 집합을 지칭하는 용어
- GPL 라이센스 준수하여 버전 업그레이드 될 때 마다 소스코드도 함께 제공 (오픈 소스 기반)
- 안드로이드 어플리케이션을 개발한다는 의미는 어플리케이션 프레임워크가 제공하는 기능을 사용해야 한다는 것을 의미
- 어플리케이션 프레임워크란 응용 프로그램의 표준 구조를 구현하는 라이브러리와 클래스의 집합체
- 스마트폰 뿐만 아니라 웨어러블 기기, 티비, 자동차 등 다양한 플랫폼에서 동작할 수 있는 OS
  - 앱 개발 != 안드로이드 OS
- 버저닝은 디저트 이름으로 명명
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
- 액티비티: UI 화면을 담당하는 컴포넌트*
  - 앱과 사용자가 상호작용을 하기 위한 진입점*
    - 앱 실행 시 앱을 전체적으로 호출하는 것이 아니라 앱의 액티비티를 호출하는 것임
  - 실제 화면에 보이는 것으로 사용자와 상호작용하는 컴포넌트
  - 같은 앱 내의 다른 액티비티 뿐만 아니라 완전히 분리된 다른 앱의 액티비티와도 상호작용 가능
  - 앱이 실행되면 화면 표시
  - 사용자의 입력값을 받음
- 서비스: 화면에 존재하지 않고 백그라운드에서 실행되는 컴포넌트
  - 백그라운드에서 오래 실행되는 작업 수행을 위한 컴포넌트*
  - UI 없음*
  - 포그라운드: 사용자에게 잘 보이는 작업, 알림을 표시해 놓고 사용자 상호작용 없이도 계속 실행 (예. 음악 재생)
    - startService()
  - 백그라운드: 사용자가 직접 알지 못하는 작업을 수행할 때 사용 (저장소 압축 / 게임 업데이트 / 파일 압축 등)
    - startService()
    - API 레벨 26 이상
      - 즉시 실행해야 하는 작업 : Work Manager
      - 지연 작업 : Alarm Manager
  - 바인드 서비스*
    - 앱 컴포넌트가 *bindService를 호출해 서비스를 호출하면 서비스가 바인딩됨
    - 바인딩된 서비스는 클라이언트 - 서버 인터페이스를 제공해 서비스와 상호 작용 (AIDL, Messenger)
      - 예전에 임베디드 안드로이드 했을 때 많이 구현했던 것들.
    - 여러개가 한꺼번에 바인딩 가능하고 바인딩 된 컴포넌트가 모두 종료되면, 서비스도 종료됨
    - 바운드: 앱 내 서비스를 사용하여 간단한 클라이언트 - 서버 환경 구성을 의미 (특정 컴포넌트와 서비스 간 상호작용)
- 브로드캐스트 리시버: 단말기에서 발생하는 다양한 이벤트, 정보를 받고 반응하는 컴포넌트*
  - OS 에서 발생하는 이벤트와 정보를 앱에서 수신할 수 있도록 하는 구성 요소*
  - UI 없음
  - 예: 화면 꺼짐 / 배터리 부족 / 사진 캡쳐 등
- 컨텐트 프로바이더: 데이터를 저장하고 가져오고 모든 앱에서 접근할 수 있도록 하는 컴포넌트*
  - 파일 시스템, SQLite DB, 웹 상이나 앱이 액세스할 수 있는 다른 모든 영구 저장 위치에 저장 가능한 앱 데이터의 공유형 집합을 관리*
  - 디바이스에 저장되어 있는 모든 데이터에 접근하는 것을 관리**
  - 다른 앱은 컨텐츠 프로바이더를 통해 해당 데이터를 질의 또는 수정 가능*
  - 예: 연락처 정보 / 갤러리 이미지 및 비디오
  - 접근 방법: (ContentResolver*)
    - 다른 앱에서 URI를 이용하여 컨텐츠 리졸버*를 통해 다른 앱의 콘텐츠 프로바이더에게 데이터 요청.
    - 요청 받은 컨텐츠 프로바이더는 URI를 확인하고 내부에서 데이터를 꺼내어 컨텐츠 리졸버에게 전달.
- (참고) 프래그먼트 (안드로이드 3.0 이후)

#### Manifest

- 앱의 필수적인 정보를 담고 있는 파일
   - 앱 패키지 이름
   - 앱 구성요소
   - 권한
   - 필요한 기능

#### Intent

- 구성요소 간 통신을 할 수 있게 하는 역할
- 앱에 포함된 구성요소 외에 다른 앱의 구성요소와도 통신 가능
  - 명시적 인텐트 (특정 컴포넌트 / 액티비티를 명확히 특정해 실행할 경우)
  - 암시적 인텐트 (동작을 특정하긴 했지만 실행될 대상이 달라질 수 있는 경우)

#### 안드로이드 서비스 라이프사이클

- startService()*
  - onCreate => onStartCommand => onDestroy
- bindService()*
  - 더 이상 바인딩 할 클라이언트가 없을 때 서비스 종료, 여러개 한꺼번에 바인딩 가능
  - onCreate => onBind => 클라이언트가 없다면? => onUnbind => onDestory

#### 안드로이드 Activity 클래스 / 라이프사이클

- 통상적으로 하위 버전과의 호환성을 고려하여 만든 AppCompatActivity 또는 FragmentActivity 중 하나의 서브 클래스로 생성
- 리눅스 커널 프로세스로 실행
- 하나의 UI (단위 기능의 화면)
- 사용자가 앱과 상호작용하기 위한 진입점
- 여러 개의 액티비티 연계 시 인텐트 사용하여 처리
- 하나의 액티비티에서 여러 개의 프래그먼트를 가지는 것도 가능
- Activity 클래스 종류
  - android.app.Activity: 해당 안드로이드 버전의 기본 라이브러리 액티비티 클래스, 모든 다른 액티비티 클래스는 이 클래스의 서브 클래스
  - android.support.v4.app.FragmentActivity: 과거 버전과의 호환성을 유지하면서 프래그먼트를 사용할 때 필요한 액티비티 클래스
  - android.app.support.v7.app.AppCompatActivity: 과거 안드로이드 버전과의 호환성을 유지하면서 새로운 버전의 기능도 사용 가능한 액티비티 클래스
- 안드로이드 런타임이 자동으로 호출하는 메소드 보유 (생명주기 메소드)
- 생명주기 관리의 주된 목적*
  - 적시에 액티비티 상태를 저장 또는 복원하기 위한 목적
  - 상태: 액티비티가 현재 보존하고 있는 데이터, 현재 보이는 사용자 인터페이스 데이터를 의미
  - 앱의 완성도와 안정성 증대를 위해 라이프 사이클에 대한 이해가 필요, 아래 이슈들을 방지 가능*
    - 다른 앱 전환 시 비정상 종료 이슈
    - 사용자가 앱을 사용하지 않는 데 시스템 리소스가 소비되는 이슈 (텍스트 와쳐)
    - 사용자가 앱을 나갔다가 돌아왔을 때 진행 상태가 저장되지 않는 이슈
    - 화면 가로 / 세로 전환될 때 비정상 종료되거나, 진행상태가 저장되지 않는 이슈
- 생명주기 메소드
  - 액티비티의 상태가 변경된다는 것을 액티비티에 알려주기 위해 안드로이드 런타임이 자동으로 호출하는 메소드를 의미
  - [onCreate]
    - 필수적으로 구현
    - 생명주기 중 한 번만 발생해야하는 로직을 실행
    - 액티비티 인스턴스가 최초 생성될 때 호출
    - 초기화 작업 진행
      - 멤버 변수 정의 / UI 정의 (setContentView)
    - saveInstanceState 매개변수 수신: 이전 저장 상태가 포함된 번들 객체 (상태가 없으면 null)
    - 동적 상태 정보를 포함할 수 있는 번들 객체 전달됨
    - 동적 상태 정보는 직전에 생성되었다가 소멸된 동일한 액티비티의 인스턴스로부터 받으며 사용자 인터페이스의 상태와 관련되는 데이터임
  - [onStart]
    - onCreate / onRestart 메소드가 호출된 후 바로 호출됨
    - 액티비티가 사용자에게 표시
    - 사용자 인터페이스가 곧 사용자에게 보이게 될 것이라고 액티비티에게 알려줌
    - 액티비티 스택의 맨위로 이동하면 onStart 호출 후 onResume이 호출됨
  - [onRestart]
    - 런타임에 의해 이전에 중단되었다가 막 다시 시작될 때 호출
  - [onResume]
    - 액티비티가 포그라운드에 표시되어 사용자와 상호 작용할 수 있는 상태
    - 액티비티 스택의 맨 위에 있고 현재 상호 동작하는 즉, 실행 중인 액티비티임을 알리는 용도
    - 앱에서 포커스가 떠날 때 까지 onResume 상태에 머무름
  - [onPause]
    - 사용자가 액티비티를 떠나는 첫 번째 신호
    - 매우 짧은 상태, 데이터 저장 / 네트워크 호출 / DB IO 작업은 하면 안됨
    - 반투명 액티비가 띄워져 포커스는 없지만 화면에 보이는 상태일 때 호출
    - onPause 다음에 onResume 또는 onStop 메소드 중 하나가 호출
    - 포그라운드로 돌아가는 경우: onResume 호출
    - 사용자 인터페이스를 사용자가 볼 수 없게 되면 중단되면서 onStop 호출
    - 실행 중이지 않을 때 필요하지 않는 리소스 해지 가능
  - [onStop]
    - 액티비티가 더 이상 사용자에게 보이지 않는 시점
    - onStop 이 후 onRestart 또는 onDestroy 가 호출 (onRestart --> onStart --> onResume)
    - CPU를 비교적 많이 소모하는 종료 작업을 실행해야 함 (DB 저장)
    - 안드로이드 OS에서 리소스 관리를 위해 해당 액티비티가 포함된 프로세스를 소멸시킬 수 있음
  - [onDestroy]
    - 액티비티가 막 소멸되려고 하거나 자발적으로 소멸될 때 호출 (완전히 종료되기 전에 실행)
    - finish를 호출했거나 메모리 해제 또는 구성 변경 (가로/세로 화면 변경, 멀티 윈도우) ConfigurationChange가 생겨 런타임이 액티비티를 종결하는 경우 호출
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

#### 프래그먼트 라이프사이클 다시 정리

- Created
  - onCreate
  - onCreateView
  - onViewCreated
  - onViewStateRestored
- Started
  - onStart
- Resumed
  - onResume

#### 프래그먼트 라이프사이클 콜백 설명

- onAttach()
  - 프래그먼트가 액티비티에 연결될 때 호출되는 메서드
- onCreate()
  - 프래그먼트가 생성될 때 호출되는 메서드.
  - 초기화 작업이나 인터페이스 설정 등 수행
- onCreateView()
  - 프래그먼트의 레이아웃을 그리는 메서드
- onViewCreated()
  - onCreateView() 후에 호출되는 메서드
  - 프래그먼트의 UI가 만들어진 후에 호출됨
- onStart()
  - 프래그먼트가 화면에 보여지기 직전에 호출되는 메서드
  - 프래그먼트가 사용자에게 보여지기 시작
- onResume()
  - 프래그먼트가 사용자와 상호작용을 시작하고 활동 상태에 들어갈 때 호출되는 메서드.
  - 프래그먼트가 포그라운드에 있으며 사용자 입력을 받을 수 있음

#### View 라이프사이클 설명

- Button, TextView, ImageView 등의 위젯을 작성하는데 사용되는 기본 클래스이자 이 모든 것이 View
- View의 서브 클래스인 ViewGroup은 보이지 않는 컨테이너로써 다른 View들을 다른 View (또 다른 ViewGroup)에 포함 가능
- 전위순회 방식 사용, 부모 부터 자식 뷰 순서로 그려지게 됨.
  - Top-Down 방식이므로 아래로 내려갈수록 뷰가 많아지게 됨.
  - 그래서 플랫한 즉, 깊지 않는 뎁스의 UI를 작성해야 함. 그렇지 않으면 쓸떼없는 계산이 많아서 성능이 지장
- [라이프사이클]
  - 노말 케이스: onMeasure -> onLayout -> onDraw
    - Constructors
    - onAttachedToWindow()
    - #measure() <-- 핵심 메소드 1: 뷰 크기 계산
    - onMeasure()
    - #layout() <-- 핵심 메소드 2: 뷰 크기와 위치 할당
    - onLayout()
    - dispatchToDraw()
    - #draw() <-- 핵심 메소드 3: 뷰를 실제로 그리는 단계
    - onDraw()
  - invalidate 호출 <-- 런타임에 뷰를 다시 그리게 하는 함수, invalidate -> onDraw
    - dispatchToDraw()
    - draw()
    - onDraw()
  - requestLayout 호출 <-- 런타임에 뷰를 다시 그리게 하는 함수
    - measure()
    - onMeasure()
    - layout()
    - onLayout()
    - dispatchToDraw()
    - draw()
    - onDraw()
- 추가 설명
  - 부모부터 자식 순서로, 탑 다운 순서로 뷰 렌더링
  - [measure]
    - 뷰의 크기 계산 / 모든 뷰는 각각 자신의 가로, 세로 (width, height) 계산
    - measure 과정에서 부모 - 자식 뷰 간의 크기 정보 전달을 위해 2가지 클래스 사용
      - ViewGroup.LayoutParams: 자식 뷰가 부모 뷰에게 자신이 어떻게 측정되고 위치를 정할 지를 요청할 때 사용
        - dp, px: 자식이 원하는 사이즈
        - Match parent: 부모 뷰 사이즈와 똑같이 사이즈 지정
        - Wrap content: 부모 뷰 안에서 컨텐츠를 표현할 수 있는 fit한 사이즈 지정
      - ViewGroup.MeasureSpecs : 부모 뷰가 자식 뷰에게 요구사항을 전달할 때 사용*
        - UNSPECIFIED: 자식이 원하는 사이즈로 결정
        - EXACTLY: 자식의 사이즈를 정확히 지정
        - AT_MOST: 자식 뷰의 최대 사이즈를 지정
  - [layout]
    - 뷰의 크기, 위치를 할당
    - 부모 기준의 상대적 위치 (left, top, right, bottom)을 계산
    - measure, layout 까지는 아직 뷰가 그려진 단계는 아님
  - [draw]
    - 뷰를 실제로 그리는 단계
      - Canvas, Paint (색상)
    - measure에서 측정한 크기로, layout에서 계산한 위치에 뷰를 렌더링
    - onDraw 는 언제든 다시 호출 가능
      - 스크롤 / 스와이프 동작 시 뷰는 onDraw 호출
      - 주의: 객체 할당 또는 리소스 소모가 심한 로직 추가는 지양, 왜냐면 여러번 호출되기 때문
  - [invalidate]
    - 뷰에 변화 발생하여 다시 그려야 할 때 (color 변화 등), 위치나 크기 변경은 아닌 변경 의미
    - 예: 텍스트 컬러 변경 --> invalidate -> onDraw
  - [requestLayout]
    - 크기가 변화해서 measure부터 다시 수행해야 할 때
    - 예: 텍스트 변경 --> requestLayout -> invalidate -> onMeasure -> onLayout -> onDraw

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
  - 액티비티, 프래그먼트, 서비스 등 다른 앱 구성요소의 생명 주기를 고려
- 라이프사이클 내에서 관찰할 수 있는 데이터 홀더 클래스
- Observer, LifecycleOwner와 쌍으로 추가 가능
- Observer에서 래핑된 데이터의 수정에 대해 알림을 받음
- LifecycleOwner 상태가 Lifecycle.State.STARTED or RESUMED 일때 알림 받기 가능
- observeForever는 항상 액티브 상태로 간주하여 항상 알림 받기 가능
- 수동으로 removeObserver로 옵저버 제거 가능
- 메모리 누수의 위험 없음
- 라이프사이클에 추가된 관찰다는 Lifecycle.State.DESTROYED 로 이동되면 옵저버가 즉시 구독 취소됨
- LiveData는 아키텍처 패턴의 일부
- 기본적으로 기본/컬렉션(primitive/collection) 타입을 포함하는 데이터 홀더
- 뷰의 변경 사항을 관찰하고 ACTIVE일 경우에만 뷰를 업데이트하는 데 사용
- Android LiveData는 생명주기를 인식한다는 걸 빼면 RxJava와 다소 유사
- 뷰가 백그라운드에 있으면 뷰의 데이터를 업데이트하지 않음
  - IllegalStateException 같은 예외를 피하는 데 도움
- MutableLiveData 클래스는 LiveData 객체의 값을 설정할 수있는 두 개의 공용 메서드인 setValue(T) 및 postValue(T)를 추가
- MutableLiveData는 일반적으로 ViewModel에서 사용되며 ViewModel은 관찰자에게 변경 불가능한 LiveData 개체만 노출

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
- [LinearLayout]
  - 여러 View 위젯들을 가로/세로 방향으로 나열할 때 사용하는 레이아웃
  - orientation 속성 통한 가로, 세로 방향 설정 가능 (vertical, horizontal)
  - 자식 뷰들은 중첩이 아닌 지정한 방향으로 차례대로 쌓이는 형태
  - layout_width, layout_height 속성은 필수 속성
  - Linear : 선형
  - layout_gravity 제공
  - 자식 뷰에서 layout_weight 속성 지정 가능 (float 값 범위)
    - 상대적인 값
    - 자식이 2개가 있을 때 두개 다 웨이트값을 2로 설정하면 둘 다 같은 크기를 가짐
    - weight 값을 지정하고 나면 width 또는 height 값을 0dp로 지정해야 weight 값이 잘 지정됨 (orientation 에 따라 width를 0으로 할지, height를 0으로 할지 결정)
  - Weight 속성으로 가중치 설정 가능 (비율)
    - 다양한 디바이스 환경에 dp가 아닌 비율에 따른 대응이 가능하나 onLayout()을 자주 호출하여 서로 간의 상관관계를 파악하므로 (내부적으로) 성능 상 좋지 않음
- [RelativeLayout]
  - 자식 뷰 위젯들이 서로 간의 상대적 배치 관계에 따라 화면에 표시될 위치가 결정되도록 만들어주는 레이아웃
  - 상대적인 배치 기준 설정이 없으면 내부에서 중첩되어 표시됨
  - 특정 위젯을 기준으로 배치
  - 아무런 조작하지 않으면 왼쪽 상단부터 위젯이 쌓임
- [ConstraintLayout]
  - 레이아웃에 배치되는 뷰들에 여러 제약을 적용하여 각 뷰의 위치와 크기를 결정하는 레이아웃
  - RelativeLayout의 상대적 위치 관계에 따른 배치 + LinearLayout의 가중치 설정 + Chain 사용을 다른 레이아웃 없이 요소들을 그룹화 가능
  - 성능 향상 장점 (Depth 1로 모든 레이아웃 구성이 가능)
    - Flat한 구조로 레이아웃 배치 가능
  - 레이아웃에 배치되는 뷰들에 여러 제약을 적용하여 각 뷰의 위치와 크기 결정
  - onMeasure() 메소드 호출 횟수에 있어서 장점
  - 가로 및 세로 제약 조건을 각각 하나 이상 추가해야 함 (start, top / end, bottom)
  - bias (0 ~ 1) - 참고. 치우침, 기울임 등의 뜻
    - 0: 시작점
    - 1: 끝점
    - 0.5: 가운데 위치
  - constraintBaseline_toBaselineOf
- [FrameLayout]
  - 주로 하나의 자식 뷰 위젯만 표시할 때 사용하는 레이아웃
  - 추가된 순서대로 쌓이므로 마지막에 추가된 뷰가 가장 상단에 표시
  - 여러 프래그먼트를 동일한 위치 내에서 교체하여 표시하고자 할 때, 프래그먼트의 컨테이너 역할로써 프레임 레이아웃을 주로 사용 (통상적인 예: 로딩 중 프로그레스 바를 보여주고자 할 때 등)

#### EditText

- TextView를 상속받으므로 gravity 등의 TextView에서 사용하는 속성들을 사용 가능
- inputType 설정 가능
  - ex. inputType="number" / numberDecimal로 하면 소수점까지 표시 가능
- hint
- textColorHint
- textStyle

#### 이미지 아이콘

- File => New => Vector Asset

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
- ViewModel 클래스를 상속하여 정의한 클래스는 개발자가 직접 생성자를 통해 생성할 수 없고, ViewModelProvider.Factory 인터페이스를 필요로 함
- ViewModel은 ViewModelStore 객체에서 관리됨
  - 내부적으로 HashMap<String, ViewModel>을 두어 ViewModel 관리
- ViewModelStore 객체는 ViewModelStoreOwner 인터페이스 통해 만들고 관리됨
  - ComponentActivity와 Fragment 클래스가 ViewModelStoreOwner Interface를 구현
- 액티비티와 프래그먼트가 ViewModelStoreOwner를 구현하고 있기 때문에 뷰 모델 생성시 액티비티나 프래그먼트 정보가 필요 --> 어떤 Owner를 통해 생성하냐에 따라 뷰모델의 스코프가 결정
- 참고. ViewModelProvider 내에는 Factory Interface가 정의

#### ViewModel 생성 방법

- ViewModelProviders (Deprecated)
  - ex. ViewModelProviders.of(this).get(AnyViewModel::class.java)
- 파라미터가 없는 뷰모델 생성 1
  - lifecycle-extensions 모듈 등록
  - ex. ViewModelProvider(this).get(NoParamViewModel::class.java)
- 파라미터가 없는 뷰모델 생성 2
  - lifecycle-extensions 모듈 필요없음
  - ex. ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())
            .get(NoParamViewModel::class.java)
- 파라미터가 없는 뷰모델 생성 3
  - 직접 ViewModelProvider.Factory 인터페이스를 구현하는 방법
  - 하나의 팩토리로 다양한 뷰모델 클래스 관리가 가능하고 예외 상황에 대한 컨트롤 가능
- 파라미터가 있는 뷰모델 생성 1
  - 위 3번의 연장선으로서 Factory 클래스에 파라미터를 넘겨주어 create()내에서 인스턴스를 생성할 때 활용 가능
- 파라미터가 없는 안드로이드 뷰모델 생성 1
  - AndroidViewModel
  - ViewModel 클래스에서 컨텍스트 객체 소유 또는 접근에 대해서 권장하고 있지 않음
  - 불가피하게 필요한 경우 안드로이드 뷰 모델을 사용
  - ViewModelProvider.AndroidViewModelFactory 라는 별도의 팩토리 제공
    - 참고. NewInstanceFactory를 상속한 코드
- 파라미터가 있는 안드로이드 뷰모델 생성 1
  - ViewModelProvider.NewInstanceFactory 를 구현하는 클래스 정의 후 아래처럼 뷰모델 생성
  - ex. return modelClass.getConstructor(Application::class.java, String::class.java).newInstance(application, param)

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

#### Coroutine Flow (코틀린, 코루틴 플로우)

- 순차적으로 값을 내보내고 정상적으로 또는 예외로 완료되는 비동기적인 데이터 스트림
- 코루틴 상에서 리액티브 프로그래밍 지원하기 위한 구성요소
- 추가 설명:
  - 데이터 스트림: 리액티브 프로그래밍에는 하나의 데이터를 발행하는 발행자가 있고 해당 발행자는 데이터의 소비자에게 지속적으로 데이터를 전달하는 역할을 하는데 이것을 데이터 스트림이라 함
  - 구성 요소
    - Producer (생산자)
    - Intermediary (중간 연산자)
    - Consumer (소비자)
- [Producer] (생산자) 는 flow {} 블록 내부에서의 [emit()]을 통해 데이터를 생성
  - flow{} 블록 선언
  - 실제 API 호출
  - API Result를 emit()
- [Intermediary] (중간 연산자) 에서는 생성된 데이터를 수정
  - 연산자 예: 자바 8 스트림, RxJava와 유사한 쓰임새로 생각됨
    - map (데이터 변형) / filter (데이터 필터링) / onEach (모든 데이터마다 연산 수행) 등
- [Consumer] (소비자)
  - [collect] 이용해 전달된 데이터를 소비 가능
    - Flow는 emit을 통해서 데이터를 발행하는 역할
    - Flow에서 발행하는 데이터들은 collect의 action에서 데이터를 순차적으로 받아 suspend fun을 실행하도록 구성되어 있음
    - collect: 새로운 데이터가 발행되더라도 이전 데이터의 처리가 끝날 때까지 대기
    - collectLatest: 새로운 데이터가 발행되면 이전 데이터의 처리를 취소하고 새로운 데이터의 처리 시작
      - Android 공식 문서 상 UI에 보여줘야 하는 데이터의 경우 collectLatest 사용을 권장
    - collectIndexed: 새로운 데이터가 들어오면 데이터와 인덱스 값도 발행
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
- Scaffold
  - modifier
  - scaffoldState: 화면 상태 기억, drawer 및 snackbarHost에 대한 정보가 포함
  - floatingActionButtonPosition: floating action 버튼의 위치, 가능한 값은 Center / End
  - isFloatingActionButtonDocked: Boolean 매개 변수
  - drawerGestureEnabled
  - drawerShape
  - drawerElevation
  - drawerScromColor
  - topBar: AppBar
  - bottomBar
  - Scaffold는 무조건 content가 들어가야만 함. content()를 만들어 줘야 하는데 람다로 전달함
- Snackbar

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
    - Flow의 경우 collect로 값을 요청하지 않는 한 값을 방출하지 않음
  - 데이터베이스를 읽거나 URL을 통해 서버의 값을 읽는 경우가 대표적
  - collect() 또는 subscribe를 호출할 때마다 flow block 이 재 실행됨
    - 1~10까지 emit 하는 로직이라 가정한다면 collect 할 때마다 매번 1~10을 전달 받음
    - 1개의 스트림에는 1명의 구독자 존재
- Hot Stream
  - 하나 이상의 소비자에게 값 전달
  - 데이터 발행이 시작된 이후 부터 모든 소비자에게 같은 데이터를 발행하고 구독자가 없는 경우에도 데이터를 발행
    - 요청이 있건 없건 간에 계속 값을 방출하는 것을 의미
  - 상태가 변하는 값을 읽을 때 또는 네트워크 상태 정보 등의 값을 읽어올 때 사용 가능
  - collect() 또는 subscribe를 호출할 때마다 flow block이 호출되지 않고 collect()가 한번 실행된 이후에 emit된 데이터를 전달받게 됨
    - 한개의 스트림에서 다중 구독자한테 전달, 구독자가 없어도 전달 가능

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

#### Jetpack Paging 라이브러리 *

- Android Jetpack에서는 페이징을 위한 Paging3 라이브러리를 제공
- Paging3 라이브러리는 로컬 저장소에서나 네트워크를 통해 데이터를 나누어 효율적으로 로딩할 수 있게 도와줌
- Paging3는 구글에서 권장하는 Android 앱 아키텍처에 맞게 설계되었으며, 다른 Jetpack 컴포넌트와 잘 동작할 수 있도록 설계됨
- 페이징 된 데이터의 메모리 내 캐싱
- 앱이 페이징 데이터로 작업하는 동안 시스템 리소스를 효율적으로 사용 가능
- 요청 중복 제거 기능이 기본으로 제공되어 앱에서 네트워크 대역폭과 시스템 리소스를 효율적으로 사용 가능
- 사용자가 로드된 데이터의 끝까지 스크롤할 때 구성 가능한 RecyclerView 어댑터가 자동으로 데이터를 요청
- Kotlin 코루틴 및 Flow뿐만 아니라 LiveData 및 RxJava를 최고 수준으로 지원
- 새로고침 및 재시도 기능을 포함하여 오류 처리를 기본으로 지원
- 라이브러리 내부적으로 3개의 레이어로 구성
  - Repository (PagingSource + RemoteMediator)
  - ViewModel (Pager => Flow<PagingData>)
  - UI (PagingDataAdapter)
- 주요 클래스
  - PagingSource
    - 특정 페이지 쿼리의 데이터 청크를 로드하는 기본 클래스, 데이터 레이어의 일부, 일반적으로는 데이터 소스 클래스에서 확인 가능하며 이 후에는 뷰 모델에서 사용하기 위해 레파지토리에서 사용됨
    - 네트워크 소스 / 로컬 데이터베이스 등의 단일 소스에서 데이터 로드 가능
    - PagingSource 빌드를 위해서는 다음 항목 정의 필요
        - Paging 키 타입: 추가 데이터를 요청하는 데에 사용하는 페이지 쿼리 유형 정의
        - 로드된 데이터 타입
        - 데이터를 가져오는 위치 지정
  - RemoteMediator
    - 로컬 데이터베이스 캐시가 있는 네트워크 데이터 소스와 같은 계층화된 데이터 소스의 페이징 처리
  - Pager
    - PagingData를 생성하는 클래스 (PagingData: 리턴받는 객체)
    - 페이징 소스에 따라 다르게 실행되고 뷰 모델에서 생성되어야 함
  - PagingConfig
    - 페이징 동작 결정하는 매개변수를 정의하는 클래스
    - 페이지 크기, placeholder 사용 여부 포함
  - PagingData
    - 페이징된 데이터의 스냅샷을 가진 컨테이너
    - 데이터 새로고침할 때마다 자체 페이징 소스로 지원되는 상응 PagingData가 별도로 생성
    - PagingSource 객체를 쿼리해 결과를 저장한다는 의미
  - PagingDataAdapter
    - RecyclerView.Adapter의 서브 클래스
    - RecyclerView에 PagingData 출력
    - factory 메소드 사용해 코틀린 플로우 / 라이브데이터 / RxJava Flowable / Observable 혹은 정적 목록에도 연결 가능

#### Paging *

- 페이징이란 데이터를 가져올 때 한 번에 모든 데이터를 가져오는 것이 아니라 일정한 덩어리로 나눠서 가져오는 것을 의미.
- 페이징을 사용하면 성능, 메모리, 비용 측면에서 굉장히 효율적
- 정보를 점진적으로 가져오는 프로세스
- 각 페이지는 데이터 청크에 상응
- 페이지를 요청하려면 페이징되는 데이터 소스에 필요한 정보를 정의하는 쿼리가 필요

#### PagingSource load() 개념

- 사용자가 스크롤할 때 출력할 데이터를 비동기식으로 가져오기 위해 사용
- 상응하는 데이터 소스에서 페이징된 데이터를 검색하는 방법을 나타내기 위해 재정의 필수
- 매개변수
  - LoadParams: 로드작업과 관련된 정보 저장
- 반환값
  - LoadResult
    - LoadResult.Page: 로드 성공 (data: 가져온 데이터)
      - prevKey: 현재 페이지 앞에 아이템을 가져와야 하는 경우
      - nextKey: 현재 페이지 뒤에 아이템을 가져와야 하는 경우
    - LoadResult.Error: 오류 발생
    - LoadResult.Invalid: PagingSource가 더 이상 결과의 무결성을 보장할 수가 없어 무효화되는 경우

#### Paging, getRefreshKey() 개념

- PagingState 객체를 매개변수로 취급하고 데이터가 첫 로드된 후 새로고침되거나 무효화되었을 때 키를 반환하여 load()로 전달
- 페이징 라이브러리가 화면을 새로고침해야 할 때 호출됨
- 사용자가 새로고침 후 목록에서 현재 위치를 잃지 않도록 새 PagingSource 가 로드를 시작해야 하는 키를 제공해야 하기 때문.
- 참고.
  - 무효화 상황: PagingSource의 기본 데이터가 변경되었으며 UI에서 업데이트 해야 하는 상황
    - 무효화가 되면 페이징 라이브러리가 데이터를 새로고침할 때 신규 PagingSource를 만들고 PagingData를 내보내 UI에 알림
  - 무효화가 발생하는 이유
    - PagingAdapter에서 refresh()를 호출
    - PagingSource에서 invalidate()를 호출

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

#### Android AWS Amplify (더 검토 필요)

- 설정 필요한 빌드 그래들 의존성
  - implementation('com.amazonaws:aws-android-sdk-mobile-client:2.8.+@aar') { transitive = true }
  - implementation('com.amazonaws:aws-android-sdk-auth-userpools:2.8.+@aar') { transitive = true }
  - implementation('com.amazonaws:aws-android-sdk-auth-ui:2.8.+@aar') { transitive = true }
- AWS 모바일 클라이언트 생성 및 사용법 예
  - var client = AWSMobileClient.getInstance()
  - var userName = client.username.toString()
  - client.signOut()
 
#### 안드로이드 Hilt 재정리

- 구글의 Dagger를 기반으로 만든 DI 라이브러리
- implementation과 annotation을 위해서 사용할 kapt를 추가
- Hilt를 사용하기 위해서는 ApplicationClass가 필요
- Hilt라이브러리는 ApplicationClass와 ApplicationContext에 접근해서 많은 일들을 뒤에서 수행함
- Custom Application 클래스에 "@HiltAndroidApp" 이라는 Annotation을 추가해 주어야 함
- 앱이 살아있는 동안 Dependency를 제공하는 역할을 하는, 애플리케이션 레벨의 Component

#### Hilt Annotation에 대한 추가 설명

- @HiltAndroidApp
  - 앱의 Application 클래스에 이 어노테이션을 지정하여 Hilt를 초기화
  - Hilt가 앱의 컴포넌트 계층 구조를 구성하고 DI를 가능하게 함
- @AndroidEntryPoint
  - Android Framework 클래스들인 Activity, Fragment, Service, BroadcastReceiver 등에 이 어노테이션을 지정하여 Hilt가 해당 클래스의 종속성을 주입할 수 있도록 함
- @Inject
  - 이 어노테이션은 주입할 필드, 생성자 또는 메서드에 지정됨. 
  - Hilt는 해당 필드나 생성자에 대한 인스턴스를 자동으로 생성하고 주입
- @Module
  - 이 어노테이션은 Hilt 모듈을 정의하는 클래스에 지정. 
  - 모듈은 주입할 종속성을 제공하는 방법을 정의
- @Provides
  - 이 어노테이션은 모듈 내의 메서드에 지정됨
  - 해당 메서드는 종속성을 제공하고 Hilt에 의해 주입될 수 있도록 함
- @InstallIn
  - 모듈을 특정 컴포넌트에 설치하는 데 사용
  - @InstallIn 어노테이션은 모듈 클래스 위에 지정되며, @SingletonComponent, @ActivityRetainedComponent, @ActivityComponent 등과 같은 Hilt 컴포넌트를 대상으로 함

#### Hilt에서 SingletonComponent 설명

- Hilt 컴포넌트 중 하나로, 앱의 전역 범위에서 단일 인스턴스를 유지하는 데 사용되는 컴포넌트
- 앱의 라이프사이클 동안 단 한번만 생성되고 유지됨

#### Debounce, Throttle 이해

- 사전 백그라운드 지식 / 상황 정리
  - 안드로이드 / 프론트엔드 개발 시 사용자 작용작용에 따른 이벤트 처리가 중료
  - 상호작용 시 마다 API 서버 호출해야하는 경우 모든 이벤트를 그대로 전달하면 서버 리소스 낭비와 과부하로 이어질 가능성 존재
  - 자주 발생하는 이벤트들을 필터링해서 처리할 필요성 존재
- debounce
  - Debouncing
    - Debounce는 발생하는 이벤트를 그룹화하여, 일정 시간동안 이벤트가 발생하지 않으면 마지막 이벤트를 전달하는 기법
    - 이벤트가 발생하다가 잠시 멈추는 시점이 일정 딜레이 만큼의 텀을 갖게 되면 마지막 이벤트를 전달
      - 자바에서 핸들러, postDelayed 처리 방법과 유사
    - 사용 예시
      - 순간 검색 기능 또는 회원가입 필드 유효성 검사 (딜레이 통한 마지막 이벤트만 처리하도록 구성)
      - KOO 를 검색한다면 K -> O -> O 의 방식이 아닌 KOO만 전달하는 방식으로 이해
    - Flow는 debounce 메소드를 자체적으로 제공
      - 파라미터로 타임아웃을 명시적으로 지정 가능 또는 방출되는 데이터에 따라 타임아웃을 다르게 지정도 가능
      - 내부적으로 debounceInternal을 통해 동작
- throttle
  - Throttling
    - Throttle은 일정 주기마다 이벤트를 캐치해 전달하는 기법
    - 이벤트와 관계없이 타이머가 이미 돌고 있는 상태에서 그 주기 안에서 발생하는 이벤트를 처리하는 방식
    - 주기를 1000ms로 설정한 타이머를 돌린다면 해당 주기동안 여러 이벤트가 발생하더라도 단 한나의 이벤트만 전달
    - 구현 방식 종류
      - throttleFirst (발생하는 이벤트 중 첫 번째 이벤트만 전달)
      - throttleLast (마지막 이벤트 전달)
    - 사용 예시
      - 버튼 중복 클릭 방지 및 활성화 처리
      - 메세지 전송 기능에서 전송 버튼이 항상 활성화되어 있으면 빈 텍스트가 전송될 가능성 존재
      - 불필요한 API 호출로 인해 리소스를 낭비하게 될 수도 있는데 throttleLast를 이용해 텍스트 입력의 마지막 이벤트를 받아서 해당 텍스트가 비어 있으면 전송 버튼 비활성화, 유효한 텍스트가 있는 경우는 전송 버튼을 활성화하여 불필요한 API 호출을 방지하고 사용자에게 더 좋은 UX 제공도 가능
    - throttle은 Flow에서 자체적으로 지원하지 않음 (RxJava에는 throttle 관련 메소드 존재)
      - sample 이라는 메소드 사용 통한 throttleLast 대체 가능, 이는 직접 확장 함수 형태로 구현 필요
      - 시간을 파라미터로 넘기나 debounce와는 달리 해당 시간 파라미터를 기반으로 ticker(timer)를 만들어 동작시킴
        - 즉, 지정된 샘플링 주기에 해당하는 데이터를 수집한다는 방향으로 이해
      - throttleFirst 구현에 대한 건
        - 마지막 발행 시간과 현재 시간 비교하여 데이터 발행하고 나머지 데이터 무시하는 방향의 구현 방법

#### 안드로이드 환경설정 재정리

- [ktlint] 핀터레스트 사에서 만들었음
  - lint: 코드 분석하여 프로그램 오류, 버그, 스타일 오류, 구조적 문제점을 확인하는 도구, 정적 프로그램 분석
    - 코딩 컨벤션 (코드를 작성하는 규칙) 에 따라 코드를 작성했는지 확인해주는 도구
    - 공식 코틀린, 안드로이드 코틀린 스타일 가이드에 따라 만들어짐
    - 참고. Android lint: 폴더 선택 > 마우스 우클릭 > Analyze > Inspect Code*
  - 적용법 
    - configurations { ktlint } 추가
    - dependencies 내 com.pinterest.ktlint:0.47.1 추가
    - task 정의 (task ktlintFormat(type:...))
    - task 부분에서 ktlint 실행 가능
- [detekt]
  - 정적 프로그램 분석 (static program analysis): 프로그램을 실행하지 않고 소프트웨어를 분석하는 것
  - 코틀린을 위한 정적 분석 툴
  - ktlint와의 차이점
    - ktlint는 코딩 컨벤션을 중점적으로 보고, detekt는 코드의 전체적인 질을 높이기 위한 분석 수행
    - 예. 메소드 길이, 메소드 Depth 등의 분석 수행 (코드 스멜 - 리팩토링 관점)
  - 적용법
    - configurations { detekt } 추가
    - dependencies 내 io.gitlab.arturbosch.detekt: detekt-cli:1.22.0-RC3 추가
    - task 정의
    - ROOT/detekt.yml <-- 설정파일, task에서 def config: GString = "$rootDir/detekt.yml" 로 설정 가능
      - lint를 더 강화하거나 아니면 불필요한 체크 항목을 해제도 가능

#### TextView 기초 내용 정리

- textStyle
  - ex. "bold|italic"
- gravity: 텍스트 정렬 속성
  - ex. center_horizontal, center_vertical, center etc.
  - ex. center_horizontal | center_vertical => center
- layout_margin / padding
- layout_marginStart / layout_marginLeft (아랍 또는 타 국가의 글자 읽기 순서에 따른 UI 마진 지정 방법)

#### UI 크기 단위 재정리

- [dp]
  - 밀도가 서로 다른 즉, 픽셀이 서로 다른 화면에서 UI 표시 크기를 유지하려면 밀도 독립형 픽셀 (DP)을 측정 단위로 사용해서 UI 디자인 필요
  - 1dp는 중밀도 화면 (160dpi 기준 밀도)의 1픽셀과 거의 동일한 가상 픽셀 단위
- [px]
  - 픽셀
- [sp]
  - scalable pixel
  - sp, dp 는 기본적으로 동일
  - sp, dp 차이
    - 안드로이드 시스템 설정에서 폰트 크기를 설정했을 때 dp는 글자 크기가 변경되지 않고 시스템 폰트 크기 설정에 따라 sp로 지정한 글자는 크기가 변경됨

#### viewModelScope 설명

- 코루틴도 더 이상 작업이 필요없을 때 cancel 동작을 해줘야 하는데 이렇 때 viewModel과 연계되어 있으면 ViewModel 라이프사이클에 맞추어서 코루틴도 관리 가능
- 참고. 코루틴의 관리 단위: Scope, Scope가 끝나면 그 안의 코루틴들도 끝남
- View가 onDestroy 일 때 ViewModel도 onClear가 되는데 이때 Scope도 Cancel 해주어야 함
- 위의 작업을 도와주는 라이브러리가 viewModelScope임
- 사용 예. viewModelScope.launch { }
- 특별히 관리해주지 않아도 ViewModel onClear가 호출될 때 코루틴 리소스 정리가 이루어짐
- 내부적으로 Closable을 구현하고 있어서 close 호출 시 coroutineContext를 cancel 시킴
- 기본적으로 Main에 바운드 되어 있으며 다른 스레드에서 실행을 원하면 withContext 메소드를 사용하면 됨
- ViewModelScope는 앱의 각 ViewModel을 대상으로 함
- 이 범위에서 시작된 모든 코루틴은 ViewModel이 삭제되면 자동으로 취소
- 코루틴은 ViewModel이 활성 상태인 경우에만 실행해야 할 작업이 있을 때 유용
- viewModelScope를 사용하지 않으면 ViewModel onCleared()를 오버라이딩해서 그 안에서 코루틴 Job을 cancel 시켜줘야 함

#### Flow vs LiveData

- LiveData
  - 생명주기를 가진 데이터 홀더
  - 메인 스레드에서 동작, 워커 스레드에서 작업을 처리해야 하는 데이터 레이어에서는 사용하기 적절치 않음
  - 자바 / 코틀린 레이어 (도메인)가 아니고 안드로이드에 종속성이 있기 때문에 테스트가 까다로움
- Flow
  - Coroutine Scope
    - Flow는 코루틴 스코프 내에서 동작
    - viewModelScope나 lifeCycleScope와 함께 사용하면 라이브 데이터처럼 뷰모델 또는 액티비티나 프래그먼트 라이프사이클을 감지하고 맞춰서 동작 실행 또는 정제가 가능
  - Operator
    - 라이브 데이터에는 연산자들이 많이 없으나 Flow에는 많은 연산자들이 있어서 데이터를 필요에 따라 유연하게 변환 가능
    - 예. 다양한 함수 활용 가능 => zip, flatMapMerge 등
  - Android 의존성
    - Flow는 코틀린 언어에 내장된 기능이므로 안드로이드 의존성으로부터 자유로움
  - Cold Stream (Collect가 되어야만 값을 방출함)
  - 상태가 없음
    - 상태가 없으므로 value를 통해 값 가져오는 것이 불가능

#### SharedFlow로 LiveData 대체하는 과정 중 필요한 SharedFlow, StateFlow 개념 정리

- SharedFlow *
  - Hot Stream으로 동작하게 하는 Flow의 종류 (HotFlow)
    - 데이터를 소비하는 곳과 무관하여 데이터를 흘려보내는 API.
    - 컬렉터들이 준비가 되어 있을 때 데이터가 생성되면 아무것도 받지 못하게 됨
    - Buffer라는 것이 있어서 위의 문제, 데이터를 받지 못하는 이슈 방지가 가능
    - extraBufferCapacity 설정해주는 경우는 받을 수 있음
    - 예를 들어 emit 개수가 5개, buffer 개수가 3개인 경우 버퍼 개수가 부족한데 이 경우는 기본적으로 emit을 잠시 suspend 하게 됨. 버퍼 3개가 다 차면 emit을 멈추었다가 받을 수 있는 상황일 때 emit 하게 됨
    - 데이터 실시간성이 중요한 경우는 버퍼를 사용하는 것이 데이터 시간차를 유발하므로 무조건 지양해야 하는 방향은 아님
  - Collector가 여러 개인 경우, Collector 들이 emit된 값들을 동시에 소비할 수 있도록 공유(Share)되는 Flow의 API
  - value 값 존재하지 않고 replayCache가 존재
  - replayCache는 몇 개의 값을 저장해 두고 받을지에 대해 설정 가능
  - replay
    - 가장 최근의 데이터를 새로운 컬렉터가 컬렉트를 시작할 때 보내줌
    - 디폴트: 0
    - 리플레이 공간이 꽉차게 되면 가장 오래된 값이 제거됨
    - 모든 값을 받을 수 있었던 버퍼를 사용한 케이스와는 다른 양상
  - Flow => SharedFlow => StateFlow
  - emit 시 바로 collect 되므로 클릭 이벤트, 전환 등의 이벤트 처리에 적합
- StateFlow
  - 현재 상태와 새로운 상태 업데이트를 Collector에 내보내는 Observable한 상태 홀더 Flow
    - LiveData처럼 값을 가지고 있음
  - SharedFlow의 한 종류임
  - StateFlow 내부 코드 내 value 라는 값을 가지고 있으며 이전에 있던 값과 다른 값이 들어왔을 때 collect로 수집이 가능해진다는 특정 존재, 오직 한가지 값을 가짐
  - 초기값이 존재해야 함
  - collector의 수에 상관없이 항상 구독하고 있는 것의 가장 최신 값을 가져올 수 있음
  - Hot Stream 데이터 홀더 클래스
  - 상태 값, 화면을 구성하는 데이터들에 대해서 사용하는 것이 좋을 것 같음
  - SharedFlow에 상태를 부여해서 현재 값을 얻을 수 있게 제한을 적용한 것
  - 뷰가 Stopped 상태가 되면 LiveData.observe()는 Consumer를 자동으로 등록 취소하는 반면, StateFlow 또는 다른 Flow에서 수집하는 경우는 자동으로 수집을 중지하지 않음
  - 라이브 데이터처럼 동일하게 동작을 만드려면 Lifecycle.repeatOnLifecycle 블록에서 흐름을 수집해야 함
  - stateIn (Scope, SharingStarted, InitialValue) <= Flow를 StateFlow로 변환하는 작업
    - SharingStarted
      - SharingStarted.Eagerly
        - collector가 존재하지 않더라도 바로 sharing이 시작되고 중간에 중지되지 않음
      - SharingStarted.Lazily
        - collector가 등록된 이후부터 sharing이 시작되며 중간에 중지되지 않음
      - SharingStarted.WhileSubscribed
        - collector가 등록되면 바로 sharing을 시작하며 collector가 전부 없어지면 바로 중지됨
        - 구글에서는 WhileSubscribed(5000)을 권장 (Flow의 중단 타이밍과 관련)
        - 화면 방향 전환 및 기타 이유로 액티비티가 onDestroy 되었다가 다시 생성되는 경우 등을 구분하기 위해 딜레이를 5초로 주면 어떤 상황인지 구분이 가능해 Flow를 중지할 지 말지 결정할 수가 있어서 권장하고 있음

#### asSharedFlow

- 캡슐화 하기 위해서 사용하는 확장함수 (API)
- ex. 초기에 MutableSharedFlow로 내부 변수 선언하고 asSharedFlow 사용해서 readOnly타입의 SharedFlow로부터 컬렉터들이 값을 컬렉트하도록 해줌

#### tryEmit()

- 코루틴의 suspend 함수 없이도 값을 방출할 수 있게 해줌
- 이유: 컬렉트하는 영역에서 코루틴을 사용하기 어려운 경우도 있으므로 탄생
- SharedFlow 처럼 여러곳에서 컬렉트해서 사용하는 API라면 필요성이 있을 수도 있음
- emit 성공 시 boolean true를 리턴
- 버퍼 사이즈가 꽉 차게 되서 emit에 실패하는 경우는 false 리턴
  - 원래는 버퍼가 꽉 차게 되면 emit을 suspend 하는데 tryEmit은 suspend가 작동하지 않으므로
  - 데이터 유실이 발생할 수 있음

#### Flow => StateFlow 변환

- stateIn: Flow를 StateFlow로 변환하는 작업
- scope: StateFlow가 Flow로부터 데이터를 받을 CoroutineScope
  - scope = lifecycleScope
- started: Flow로부터 언제부터 데이터를 받을 지 멈출 지를 명시
  - started = SharingStarted.WhileSubscribed(1000),
- initialValue: StateFlow에 저장될 초기값

#### Flow => SharedFlow 변환

- sharedIn: Flow를 SharedFlow로 변환하는 작업
- scope: SharedFlow가 Flow로부터 데이터를 받을 CoroutineScope
- started: Flow로부터 언제부터 데이터를 받을지 멈출 지를 명시
- replay: 이전 이벤트를 방출

#### Flow 관련 라이프사이클 인식 문제를 위해 나온 키워드

- launchWhenStarted
- repeatOnLifeCycle
  - 시작 => 정지 => 재시작
- launchWhenResumed
- launchWhenCreated

#### LiveData => Flow 마이그레이션에 대한 고찰

- 라이브데이터 활용
  - 뷰 => 뷰모델 (LiveData) => 뷰모델 (MutableLiveData) => Repository (suspend fun...)
- Flow 활용
  - 뷰 => 뷰모델 (StateFlow) => 뷰모델 (MutableStateFlow) => Repository (suspend fun...)
- StateFlow는 라이브데이터와 가장 유사
- UI 상태를 뷰에 노출시킬 때는 StateFlow 사용 (UI 상태를 유지하도록 설계된 가장 안전하고 효율적인 옵저버)

#### buildSrc를 통한 dependency 관리

- Gradle이 수행되면 buildSrc 디렉토리가 존재하는지 체크
- 이 경우에 Gradle은 자동적으로 코드를 컴파일하고 테스트한 뒤 빌드 스크립트의 classpath에 삽입
- 이 방법은 유지 보수, 리팩토링 및 코드 테스트가 더 쉬워지게 만듬
- 적용법
  - 루트 폴더에 buildSrc 폴더 생성
  - buildSrc 폴더 안에 build.gradle.kts 파일을 생성한 뒤, kotlin-dsl를 enable
  - 그리고 gradle sync를 하여 이 plugin을 활성화
    - plugins { `kotlin-dsl` }, repositories { jcenter() }
  - src > main > java 폴더를 생성
  - java 폴더안에 Kotlin 파일을 생성하고, 원하는 이름을 지정
  - 생성한 Kotlin 파일에 dependency를 지정
- buildSrc를 사용하면 좋은 점이 Kotlin을 사용해 관리해주기 때문에 Auto Complete 지원 가능
- Reference
  - https://github.com/tkdgusl94/blog-source/tree/master/buildSrc

#### viewLifeCycleOwner 설명

- 실 사용 예
  - viewLifecycleOwner.lifecycleScope.launch { }
- Fragment 생명주기
  - onAttach ~ onDestory 에서 끝남
  - viewLifecycleOwner 사용 시 프래그먼트 생명주기 중 onCreateView ~ OnDestroyView 까지의 생명주기만 사용
  - onCreateView 이전, onDestroyView 이 후에 viewLifecycleOwner 호출 시 IllegalStateException 발생
- 액티비티와 다르게 프래그먼트에서는 onDestroy 호출 이전에 onCreateView가 여러번 호출 가능함
  - 만약 LiveData 관찰을 위한 옵저버를 두어야 할 때 lifecycleOwner를 this로 작성한다면 복수의 옵저버 할당이 이루어질 문제가 있음
  - viewLifecycleOwner 사용한 메모리 누수 문제 해결이 가능

#### AccessibilityService 활용한 다른 앱의 뷰 레이아웃 정보 얻는 방법 설명

- 활성화된 스크린 안의 뷰 레이아웃 정보를 가져오는 방법
  - 해당 서비스를 상속하는 커스텀 서비스 생성 후 onAccessibilityEvent 오버라이드
  - eventType이 AccessibilityEvent.TYPE_WINDOW_CONTENT_CHANGED 일 때 rootInActiveWindow (getRootInActiveWindow) 함수 이용하여 현재 보이는 화면의 가장 최상단 루트 노트를 가져올 수 있음
  - 루트 노드로부터 자식 노드를 검색이 가능하며 텍스트뷰에 설정된 스트링 리소스도 볼 수 있음
  - AndroidManifest에 BIND_ACCESSIBILITY_SERVICE 퍼미션 추가 필요
  - accessibility_service_config.xml도 추가로 정의 필요
    - description
    - accessibilityEventTypes
    - canRequestFilterKeyEvents
    - accessibilityFlags
    - accessibilityFeedbackType
    - notificationTimeout
    - canRetrieveWindowContent

#### OverlayView 표시를 위해 필요한 절차

- AndroidManifest에 SYSTEM_ALERT_WINDOW 권한 추가 / FOREGROUND_SERVICE 권한도 추가
- WindowManager 활용하여 LayoutParams 설정
- LayoutInflater 활용하여 커스텀 뷰 inflate 하기 위한 준비
- 표시하고자 하는 뷰 (xml) 정의
- 생성한 커스텀 뷰를 inflate하고 해당 객체를 윈도우 매니저에 addView 처리
- addView 하게 되면 해당 커스텀 뷰가 화면에 보이게 됨
- 참고
  - Android 11부터 ACTION_MANAGE_OVERLAY_PERMISSION 인텐트는 항상 앱에 대한 SYSTEM_ALERT_WINDOW 권한을 부여하거나 취소할 수 있는 최상위 설정 화면으로 사용자를 안내 (패키지 설정 관련하여 인텐트의 데이터 무시됨)
  - 이전 버전에서는 인텐트가 권한 관리를 위해 사용자를 앱별 화면으로 이동시키는 패키지 지정이 가능했으나 정책 강화로 인하여 현재는 불가능

#### OverlayView 표시를 위한 추가 설명

- 마시멜로우 6.0 API 23 부터는 권한 설정 필요
  - <uses-permission android:name="android.permission.SYSTEM_ALERT_WINDOW" />
  - Android Marshmallow에서는 기본 권한 획득 외에도 SYSTEM_ALERT_WINDOW 사용을 위한 별도 권한 추가가 필요
  - SYSTEM_ALERT_WINDOW는 WindowManager를 이용하여 최상위 뷰에 화면을 노출하는 뷰의 옵션
  - 참고.
    - Play store 다운 앱의 경우 draw 권한이 true 상태로 설치되며, 사용자가 변경이 가능
    - Play store에서 받을 경우 Yes 직접 설치할 경우 No이므로 다음의 Overlay 권한 획득 요청이 필요
    - Play store에서 true로 설정해주더라도, 사용자가 언제든 끌 수 있음
    - SYSTEM_ALERT_WINDOW 권한을 요청하고 Play 스토어(버전 6.0.5 이상 필요)를 통해 설치된 모든 앱은 해당 앱에 대해 자동으로 권한이 부여됨
      - 업데이트가 아닌 오로지 클린 설치인 경우에만 해당하는 것으로 보임
- 서비스에서 오버레이뷰를 표시하는 경우에는 Android O 이상에서는 포그라운드 서비스로 실행해야 함
- 참고. 뷰에 아래 속성 추가 시 터치 이벤트 발생
  - android:filterTouchesWhenObscured="true"
- 오버레이뷰 권한 획득 여부 판별
  - Settings.canDrawOverlays(this)

#### 안드로이드 플랫폼 - 스마트폰 기기 내 설정된 최초 향 정보 추출

- 기기 자체에 설정된 ro 프로퍼티 등이 존재
  - read-only 프로퍼티로서 펌웨어 빌드 시 처음이자 마지막으로 설정되는 값 (고유한 값)
  - ro.boot.carrierid 프로퍼티도 있으나 이 프로퍼티는 없을 수도 있으므로 ro.oem.key1 프로퍼티를 사용하여 값을 추출
- 참고.
  - sys.smf.mnoname0 / 1
    - 현재 장착된 유심에 따라 가변적으로 값이 변하는 sys 프로퍼티
    - persist.sys 와 다르게 재부팅하면 값이 지워지고 부팅하면서 다시 설정되는 프로퍼티
  - SKT, KT, LGU+ 등의 통신사가 존재하는데 실제 설정되는 값은 아래와 같음
    - SKT --> SKC
    - KT --> KTC
    - LGU+ --> LUC
    - 자급제폰 --> KOO

#### AccessibilityService 활용한 사용자 인풋 이벤트 감지 방법

- 필요 권한: 오버레이뷰 그리는것과 동일하게 "접근성" 권한 설정 필요
- 감지 과정: 사용자 입력이 되면 onAccessibilityEvent 메소드로 TYPE_VIEW_TEXT_CHANGED 이벤트가 들어옴
- 필요 서비스 : AccessibilityService 상속하는 커스텀 서비스 필요
- EditText 에서 텍스트 입력 / 수정 / 삭제 할 때 해당 텍스트값 Catch 가능

#### ComponentActivity와 AppCompatActivity 설명

- AppCompatActivity는 FragmentActivity를 상속하고 FragmentActivity는 ComponentActivity를 상속, 그리고 ComponentActivity는 androidx.core.app.ComponentActivity 상속, androidx.core.app.ComponentActivity는 Activity 상속
  - AppCompatActivity --> FragmentActivity --> ComponentActivity --> androidx.core.app.ComponentActivity --> Activity
- ComponentActivity는 Compose 앱에서 사용
  - 컴포즈 UI 관련 필요한 것들을 가지고 있음

#### XML 에서 String 포맷 사용하는 방법 다시 정리

- 포맷 형식은 %d, %s, %f, %2d 등 사용 가능
- 예제
  - <string name="test">result: %d.</string>
  - val text = String.format(resources.getString(R.string.test), 100)

#### 노티피케이션 바 컨트롤 (Notification Bar Control)

- Notification Bar 정보 가져오기 가능
- 앱 당 24개 정도로 최대 표시 개수 제한이 있음
  - 제조사 마다 AOSP에서 설정 가능
- 노티피케이션 바 개수가 가득 찼을 때 가장 오래된 것부터 삭제하는 로직 추가 필요
- 안드로이드 노티피케이션 특성 상 3개까지는 각각 표시되다가 그 이후부터는 그루핑이 됨
- 그루핑이 될때 해당 앱의 노티피케이션 아이템이 하나 더 증가하게 되고 문제는 그룹타입인 아이템도 포스팅 시간 정보가 있음
  - 즉 아이템1, 2, 3, 4, GroupBar, ...
- 활성화된 노티피케이션 정보들에서 해당 앱의 패키지명으로 필터링하여 리스트를 만들 때 item.tag가 널이 아닌 것은 그룹이라는 의미
- 그러므로 이 아이템은 리스트 항목에서 제외시켜야 추가/삭제 동작 시 제대로 동작함
- 삭제 처리
  - notificationManager.cancel(id)

#### 노티피케이션 채널 중요도, 우선순위 importance 속성

- 안드로이드 Notification의 중요도, 우선순위 즉, NotificationManager의 importance 속성에 차이가 발생하면 노티바 동작이 예상과는 다를 수 있음
- None (0) --> min -> low -> ... -> High 순으로 기억
- 안드로이드 노티피케이션에는 Importance 속성이라는 게 존재하여 속성값이 High 일 수록 노티바 표시의 우선순위가 높아짐
- Importance: 알림이 사용자를 시각적으로 또는 청각적으로 방해하는 수준 의미
- 높다고 해서 무조건적으로 최상단의 노티바 위치를 보장하는 것은 아님
- 프레임워크에서 상대적으로 우선순위를 높게 처리하는 방향으로 이해함
- 높은 우선순위의 노티바가 있는 상황에서 디폴트 노티를 수신했을 때 디폴트 노티바가 높은 우선순위의 바 아래로 갈수도 있고 위로 갈 수도 있음
- 현재까지의 검토 결론
  - 안드로이드 노티바 디스플레이 동작 영역은 프레임워크 레이어에서 처리하는 영역으로서 보호자 앱과 같은 일반 앱 레이어에서는 상세한 노티바 이동 동작에 대한 커스터마이징이 불가능

#### BaseActivity, BaseFragment 사용

- BaseActivity, BaseFragment 를 통해 보일러 플레이트 코드(반복되는 코드)를 정리하기 위한 목적
- 코드의 중복을 줄이고 가독성을 높이기 위해서 프로젝트의 뼈대로 사용되는 클래스
- 보통 binding이나 그 외 여러 activity/fragment 걸처 공통적으로 수행하는 코드에 대하여 초기화나 이벤트 등을 정리해둠으로서 나중에 다른 activity/fragment에서 이를 상속하여 사용
- BaseActivity 정의하여 사용하다보면 내용이 많아져서 베이스의 의미를 잃는 경우 발생
  - 이런 경우 베이스 액티비티도 분리를 해야 함
  - BindActivity <|-- MvvmActivity <|-- MainActivity
- 바인딩 클래스를 템플릿으로 지정하고 파라미터로 레이아웃 리소스를 설정하는 형태로 베이스 클래스를 주로 작업
- 공통적인 코드라고 무조건 베이스에 넣는 방법은 지양, 차라리 Util 관련 클래스를 만들어 띠로 빼서 쓰는 것이 이상적
- 라이프사이클 준수하는 것에 초점
- 몇개가 만들어질지 모르는 변수들 즉 뷰모델, 기타 변수들은 베이스 부분에 넣지 않는 것을 추천
- 코틀린에서 상속은 open class 나 abstract class 만 가능
- DataBinding과 ViewModel의 강제는 지양
- Presenter의 경우 1:1관계, 뷰모델의 경우 n:n관계를 생성할 수 있는 게 좋음
- 베이스 코드가 정립되고나면 코루틴 스코프 등 관련 델리게이션 사용하는 방향도 좋은 방향
  - 예로 UICoroutineScope의 정의

#### Livedata 활용한 FCM (Firebase Cloud Messaging) 처리 방법

- 이벤트 전달을 위한 라이브데이터 오브젝트 클래스와 함수 정의
  - object Events { val serviceEvent: MutableLiveData<String> by lazy { MutableLiveData<String>() }}
- 라이브데이터 데이터 설정 (postValue)
- 데이터를 받고지 하는 화면 액티비티나 프래그먼트에서 라이브데이터 옵저빙하여 데이터 처리

#### 데이터 홀더 클래스 개념

- UI의 역할은 화면에 애플리케이션의 데이터를 표시하고 
- 사용자와의 상호작용의 기본이 되는 지점
- 사용자 상호작용(Ex: 버튼 누르기) 또는 외부 I/O 작업(네트워크 응답)으로 인해 
- 데이터가 변할 때마다 변경사항을 반영하도록 UI가 업데이트되어야 하는데
- 업데이트를 위해 필요한 관찰 가능한 데이터 홀더가 필요한데 이를 데이터 홀더 클래스라 함

#### repeatOnLifecycle 와 flow 사용 관련 내용

- repeatOnLifecycle 블록 내부에 있는 flow에 대한 collect는 View가 포그라운드에 있을 때만 진행
- 백그라운드에서 수행되어야 하는 무거운 작업은 repeatOnLifecycle에서 수행하면 안됨
- 확장함수 활용해서 코드 라인 줄이는 작업 마지막에 필수

#### AndroidManifest XML 속성 설명 *

- allowBackup
  - ADB 를 통해서 앱 백업과 복구를 사용 가능하는 설정
- fullBackupContent
  - 안드로이드 6.0 (API 레벨 23부터)부터 구글 클라우드를 이용해 앱의 데이터를 자동 백업하도록 하는 설정
- 안드로이드 스튜디오 매니페스트를 보면 기본 설정은 true 로 설정되어 있음
- 추가 설명
  - 백업되는 파일
    - 공유 환경 설정 파일
    - getFilesDir() / getDir()을 사용하여 액세스하는 앱의 내부 저장소에 저장된 파일
    - getDatabasePath()에서 반환한 디렉터리의 파일 (SQLiteOpenHelper 클래스 사용하여 생성한 파일도 포함)
    - getExternalFilesDir() 에서 반환한 디렉터리의 외부 저장소에 있는 파일
- 문제점
  - 앱 삭제 후 재설치해도 전에 있던 데이터들이 남아있는 문제 존재
  - 보안 이슈 존재 --> 사용 지양 (false로 설정 권장)

#### Gradle 빌드 속도 개선

- Legacy Multidex 
  - 라이브러리 사용 때문에 우리가 사용하게 되는 메소드 개수는 65536개는 넘게 되었음
  - 버전에 따라 멀티 덱스 다루는 방법이 상이
    - Android 5.0 (API 21) 미만: 앱 코드 실행을 위해 달빅 런타임 사용 / 기본적으로 달빅에서는 APK 당 하나의 classes.dex 바이트코드 파일로 앱을 제한
    - Android 5.0 (API 21) 이상: ART 런타일 사용 / APK로부터 여러개의 덱스 파일을 로드하는 것을 지원
  - 21 이상으로 설정하면 빠르게 빌드 가능
    - 과거 버전에 대한 호환성을 맞춰야 한다면 flavor로 설정 부분 나눠서 개발 권장
- APK 파일의 크기가 클때 abi별 / density별로 APK파일을 나누어서 용량 줄이기 가능
  - 많은 서비스에서 x86용, x86_64용, armeabi-v7a용, arm64-v8a용으로 APK를 분할해서 제공 (이런 split작업은 빌드시간을 증가시키는 원인)
  - 개발 단계에서는 abi별로 split하는 작업을 하지 않게 만들어주어야 함
- 리소스 축소 / PNG 최적화 (Crunching) 기능 OFF
  - 보통 개발 시 1개의 폰을 사용
  - 예를 들어 한국어 이면서 xxxhdpi이거나 특정 해상도의 테스트 폰만을 사용할 것으로 추측되는 상황
    - 특정 언어와 해상도로 고정을 해주면 빌드 시간 감축에 도움
  - 기본적으로 안드로이드에서는 PNG를 최적화하는 기능이 켜져 있는데 이를 끄면 빌드 시간 감축에 도움
  - 예. dev { dimension "stage" aaptOptions.cruncherEnabled = false resConfigs "ko", "xxxhdpi" }
- 고정된 버전코드 사용
  - 빌드 시간을 버전 코드로 사용하는 등의 작업 지양
- Fabric 활용한 사용자 분석 또는 오류 로그 분석 기능을 OFF
- 라이브러리 버전을 끝까지 명시
  - x.x.+ (26.+) 로 명시할 경우 24시간마다 최신버전을 알아오기 때문에 빌드시간이 늘어나는 원인이 됨

#### Deprecated 된 API 찾기

- 안드로이드 스튜디오 메뉴에서 Analyze -> Run Inspection by Name
- 검색창에 Deprecated API usage 검색
- Run 'Deprecated API usage'창 뜨면 OK 누름
- 로딩 후 결과 볼 수 있음

#### 안드로이드 커스텀 린트 (Custom Lint) 만들기

- Android Lint는 앱을 구성하는 코드(소스, 리소스, manifest를 포함)들을 정적 분석하는 도구
- Test Code의 작성 없이 코드의 구조적 품질 문제를 식별하고 수정 가능
- Lint 검사 도구에서 감지된 각 문제는 설명 메시지 및 심각도 수준과 함께 보고되므로 개선이 시급한 순서대로 우선순위를 정할 수 있음
- lint.xml 파일은 제외하려는 린트 검사를 지정하고 문제 심각도 수준 등을 변경하여 맞춤 설정하는 데에 사용할 수 있는 구성 파일
- 사용 이유
  - 다수의 인원이 작업하는 프로젝트에 있어서 공통으로 지켜야 하는 룰 중에서 강제화할 필요가 있는 것들에 대해서는 Custom Lint를 사용하면 좋은 경우
- 커스텀 린트 적용 구조
  - Custom Lint를 구현하고 적용하기 위해서는 2개의 모듈을 추가해야 함
  - 앱은 library 모듈에 dependency를 가지면 되고, library 모듈은 checks 모듈에 dependency를 가지면 됨
  - 실제 린트 검사를 위해 필요한 내용들은 checks에 있고 library는 이 checks 모듈을 lintPublish dependency를 가짐. (이름은 자유 선택 가능)
  - 문서나 자료들을 찾다 보면 lintPublish 말고 lintChecks가 있는데 특정 버전 이후부터는 lintPublish만 사용하면 됨
    - 최근에는 lintPublish를 사용하면 됨
  - ToDo
    - Lint Version
    - Checks Module
    - META INF 등록
    - Issue Registry 구현
    - Lint Publisher Module
    - Lint Checks
    - lint-baseline.xml

#### 안드로이드에서 제공하는 테스트

- Instrumented test
  - AndroidTest 디렉토리에 존재
  - 하드웨어나 에뮬레이터에서 실행되는 테스트
- Unit test
  - test 디렉토리에 존재
  - JVM에서 실행되는 테스트
  - Android OS 프레임워크 관련 의존성이 없는 경우 실행하면 실행시간을 최소화 시키는 것이 가능

#### Soft / Hard Assertion

- Soft Assertion
  - 테스트가 중간에 검증에 실패하더라도 이후 검증 동작을 수행하기 때문에
  - 한 테스트에서 여러 개의 검증 동작이 있는 경우 하나가 실패하더라도 다른 검증을 진행 가능
- Hard Assertion
  - 테스트 중간에 검증이 실패할 경우 그 즉시 종료됨

#### 테스트 목 Mock 라이브러리에서 Mock에 대한 설명

- Mock은 가짜 객체 인스턴스를 만드는 기능
- 인터페이스가 아닌 클래스를 넣어서 가짜 클래스의 인스턴스를 얻을 수 있음
- 객체 간 의존성이 강해 구현하기 힘든 경우 실제 객체를 만들어 사용하기에 시간과 비용이 많이 들기 때문에 Mock을 통해 객체를 생성하는 방법

#### CompositeDisposable clear() 와 dispose() 차이점

- clear()
  - clear를 호출한 CompositeDisposable 객체는 재사용 가능
- dispose()
  - dispose를 호출하면 호출한 CompositeDisposable 객체는 재사용이 불가능
  - clear()와는 달리 dipose()함수는 내부구조에서 disposed 라는 flag 변수를 통해 함수가 불릴 때 disposed = true가 되어서 재활용 할 수 없음

#### RecyclerView.Adapter 메소드 

- notifyDataSetChanged
  - 아이템 변경 (데이터가 업데이트 되었지만 위치는 변하지 않았을 때) 또는 구조적 변경 (아이템 간 삽입, 삭제, 이동 발생 시) 사용
- notifyItemChanged
  - notifyItemChanged(int position, Object payload)
  - position 위치의 아이템이 변경되었다고 파라미터를 통해 알려줄 수 있음
- notifyItemInserted
  - notifyItemInserted(int position)
  - position 위치에 아이템이 추가되었다는 뜻
- notifyItemMoved
  - notifyItemMoved(int fromPostion, int toPosition)
  - 인덱스 fromPosition 아이템이 toPosition으로 이동
- notifyItemRangeChanged
  - notifyItemRangeChanged(int positionStart, int itemCount, Object payload)
  - positionStart부터 itemCount개까지 범위에서 변경이 일어남

#### OkHttp Interceptor 개념 / 종류

- 개념
  - API 통신에서 요청에 대해 monitor, rewrite 그리고 retry 할 수 있는 강력한 메커니즘
  - Interceptor를 통해서 우리는 API 통신을 만들 때, 통신 과정을 모니터링 하거나 특별한 작업을 수행 가능
  - Interceptor 기능은 공항 보안 요원이 보안 검사하는 과정과 비슷
  - Interceptor는 중앙에서 API 호출들을 모니터링 하는 것처럼 다양하게 사용됨
  - 일반적으로 우리는 각각의 network 호출에 대해 logger를 달아야 할 필요가 있는데 Interceptor를 이용한다면 하나의 logger를 추가하여 모든 network 호출에 대해 동작하도록 할 수 있음.
  - 다른 경우로는 offline-first app의 build를 위해 network 요청의 response를 캐싱하기도 함
- 종류
  - 2가지 타입 존재
  - Application Interceptors: Application Code(우리가 작성한 코드) 와 OkHttp Core Library 사이에 추가된 Interceptors.
    - addInterceptor()를 이용
  - Network Interceptor: OkHttp Core Library와 server 사이에 추가된 Interceptors
    - addNetworkInterceptor()를 이용
- 실제 사용법
  - OkHttp에 Interceptors 추가
  - Error Interceptor
    - chain.request()로부터 request를 받음
    - chain.proceed()에 request를 담아 보내, 서버로 부터 온 response를 저장
    - proceed(request) 여기서, response code를 확인하고 원하는 동작을 수행
- 기타 응용 사용법
  - 만약 API 통신을 구현해야 하는데 모든 API 통신에 Authorization Header를 포함해야 한다면, 각각의 API에 넣어줄 수도 있고 Interceptor를 이용하는 방향도 가능
  - 순서
    - chain.request()로 부터 request를 받아 .newBuilder() requestBuilder를 생성
    - 다음 local storage에서 header token을 읽어옴
    - requestBuilder에 addHeader(K, V)를 이용하여 헤더 정보를 입력
    - chain.proceed()에 requestBuilder를 담아 요청 송신

#### 안드로이드 전역적인 상태 관리 방법

- Application 클래스 활용
  - MyApplication myApp = (MyApplication)getApplicationContext();
- SharedPreference 사용
- SQLite 데이터베이스 활용
- 단순 파일 생성 및 작성
- Realm (JPA 같은 느낌)
- Activity View Model (액티비티와 다수의 뷰 모델로 구성되어 있는 경우 유용)
- 이벤트 버스 라이브러리 (게시자 / 구독자 개념)

#### 툴팁 구현

- 의존성 추가
  - implementation "com.github.skydoves:balloon:1.4.6"
- Balloon Object 생성
- setArrowPositionRules(ArrowPositionRules.ALIGN_ANCHOR) : 툴팁을 띄울 버튼을 기준으로 화살표 방향을 잡는 것
- 가로길이 컨텐츠 크기에 맞게 동적으로 반응하게 만드는 방법 : setWidth(BalloonSizeSpec.WRAP)
- balloon.showAlignBottom(binding.ibBodyTooltip)
  - 툴팁을 띄울 방향 지정하면서 띄우기 (아래에 표시)

#### 자바에서 코틀린 마이그레이션 시 발생하는 문제

- JVM Signature 충돌 문제
  - 코틀린 변수 사용 시 자동으로 getter / setter 가 생성되어 기존에 이미 정의해놓았던 메소드와 충돌 발생
    - 예. name 이라는 변수가 있고 setName() 이라는 메소드를 또 정의했다면 문제가 발생
    - 해결법: 변수에 @JvmField 애노테이션 설정하여 자동으로 getter / setter를 생성하지 않도록 명시
- BindingAdapter 사용 오류
  - 오류 예제
    - java.lang.IllegalStateException: Required DataBindingComponent is null in class ItemBooksBindingImpl. A BindingAdapter
    - BindingAdapter 사용 메소드는 static으로 작성되어져야 하므로 코틀린 파일에서 클래스 이름 즉 class XXX 부분을 아예 빼버리거나 뺄수가 없는 상태이면 BindingAdapter를 사용하는 메소드에 @JvmStatic 애노테이션을 명시해주면 됨

#### 안드로이드 단일 모듈, 멀티 모듈

- 단일모듈
  - 하나의 앱 모듈로만 구성된 앱을 의미
  - 소규모 앱을 만들 때 취하는 가장 이해하기 쉽고, 간편한 형태
  - 단일 모듈로 구성된 앱은 자연스레 소스코드 간의 결합도가 높아지기 쉬움
  - 거대한 하나의 덩어리 형태로 되어 있어 수정이 어렵게 될 가능성
- 멀티모듈
  - 여러 모듈로 구성된 앱을 의미
  - 앱의 코드베이스가 큰 경우에 다중 모듈 구성을 적용하는 것이 적합
  - 시작하는 사람들에게 다중 모듈 프로젝트는 이해하기 어렵고, 가독성이 떨어질 수 있음
  - 코드의 결합도가 낮기 때문에 앱을 확장하거나 수정할 때, 훨씬 더 유연하게 대응 가능
  - 장점
    - 의존성 줄이기(관심사의 분리)
    - 기존의 단일 모듈에서는 개발자의 실수로 의존성 규칙을 위반할 가능성 높음
    - 멀티 모듈을 사용하면 각각의 모듈의 build.gradle 파일에서 의존성을 추가하지 않으면 다른 모듈의 코드를 사용 자체를 할 수 없기 때문에 의존성 규칙을 쉽게 관리 가능
    - 빌드 속도 단축
    - 전체 모듈을 빌드할 필요가 없으므로 빌드시간을 줄이는데 유리
    - 코드 재사용성 증가
    - 계층, 기능 별로 모듈을 나누어서 코드를 작성하게 되면 해당 기능이 필요할 때 그 기능을 가지고 있는 모듈에 대한 의존성을 추가하여 사용하면 되기 때문에 재사용성이 늘어남

#### 안드로이드 파일 쓰기 / 저장 / External Storage

- Internal Storage
  - Permission 없이 사용 가능
  - 저장된 파일은 자신의 앱에서만 액세스 가능
  - 앱을 지우면 파일도 함께 소멸
  - 캐시파일의 개념과 비슷
- External Storage
  - Permission 필요 (READ / WRITE_EXTERNAL_STORAGE)
  - SD 카드 등의 외부저장소에 파일을 저장
  - 스마트폰의 저장소도 외부 저장소에 포함됨 (Download 폴더 등)
  - getExternalStorageState() 함수를 호출하여 외부 저장소가 사용 가능한지에 대해 확인
  - 예외 사항
    - 안드로이드 10 Q 부터는 보안 정책 강화로 외부 저장소에 접근 불가
    - Manifest에 requestLegacyExternalStorage를 true로 설정해주면 사용은 가능하나 비추천
    - 이전 코드로 시도 시 open failed: EACCES (Permission denied) 에러 발생
    - Environment.getExternalStorageDirectory() 는 만료됨
    - MediaStore 또는 SAF (Storage Access Framework) 사용 추천
      - 이미지 / 동영상 / 오디오 : MediaStore
      - Txt, Pdf 등 기타 파일 : SAF

#### ActionBar, ToolBar, CollapsingToolbarLayout

- CollapsingToolbarLayout
  - Tool Bar의 높이가 높음
  - Tool Bar의 높이를 높게 했다가, ActionBar 혹은 Toolbar의 높이로 좁게 했다가, 동적으로 변환이 가능
  - 보통은 아래 콘텐츠에 보통 스크롤 할 수 있는 뷰가 있으며, 스크롤을 아래로 내리면 크기가 늘어나고, 스크롤을 위로 하면 크기가 줄어들게 사용하곤 함
  - 사용법은 material design 문서 참고 가능
- ToolBar / ActionBar
  - Toolbar를 쓰는것이 권장
  - Toolbar는 v7 appcompat Support Library에 포함되어 있기 때문에 기기별로 동작기능이 같음
  - 반면, ActionBar는 각 버전별로 동작 및 모양이 조금씩 다름

#### 테스트 코드 작성 범위

- 수정/변경되는 모든 기능에 대해 반드시 테스트 코드를 작성
- Presenting logic(MVP 구조 중 Presenter가 담당하는 역할)에 대한 검증은 필수적이며, View에 대한 테스트를 꼭 작성할 필요는 없음
  - 안드로이드 프레임워크나 UI 관련한 테스트 코드는 작성 및 실행에 있어 상대적으로 어려움과 번거로움이 존재한다고 판단
  - MVP에서 View를 아주 수동적으로 작성할 경우 View에 대한 테스트 코드를 작성하는 게 큰 효용이 없음
- View에 Presenting logic이 포함되는 경우에는 아래의 방법으로 테스트 코드를 작성
  - Instrumented test를 작성
  - View로부터 Presenter로 presenting 로직을 분리하는 리팩토링을 수행하며, 이에 대한 Presenter 테스트 코드를 작성
- 관리되지 않던 기존 코드에 대한 테스트 코드
  - 위와 같은 코드에 대한 변경이 있는 경우, 해당 변경으로 인해 영향받는 코드에 대한 테스트 코드는 필수적으로 작성
  - 이 코드가 3번 케이스에 해당하는 경우, 3-1, 3-2의 방법을 따르는 것을 권장

#### Serializable / Parcelable 특징 및 차이점

- 안드로이드에서 객체를 직렬화 (스트림화) 하는 인터페이스
- 객체를 바이트 스트림으로 변환 또는 바이트 스트림을 다시 객체로 변환하는 작업 수행
- 성능
  - Parcelable이 더 빠름
  - Serializable은 자바 리플렉션을 사용하여 객체를 직렬화하고 역직렬화하기 때문에 처리 과정에서 오버헤드가 발생
  - Parcelable은 명시적으로 필드를 읽고 쓰는데에 집중하므로 성능이 향상됨
- 메모리 사용
  - Parcelable은 내부적으로 작동을 위해 안드로이드의 바인더 메커니즘을 사용.
  - 이로 인해 객체를 직렬화하는데 필요한 메모리 사용량 감소가 가능
  - Serializable은 자바 직렬화 메커니즘을 사용하기 때문에 더 많은 메모리 사용
- 명시성
  - Parcelable은 직렬화 / 역직렬화 과정을 명시적으로 작성 필요하나 Serializable은 특별한 메서드 없이 직렬화 가능
  - Parcelable은 개발자가 직렬화 / 역직렬화 방법을 명시적으로 작성해줘야 하므로 클래스의 구조 변경이 복잡해질 수 밖에 없음
- 호환성
  - Serializable은 자바 직렬화 메커니즘을 사용하므로 객체를 직렬화하고 역직렬화하는 데에 제약이 걸릴 수 있음
  - Serializable 클래스 구조가 변경되면 역직렬화에 문제 발생 가능성 있음
  - Parcelable은 명시적으로 작성해야 되고 작성되므로 클래스 구조의 변경에 유연하게 대응 가능

#### Retrofit, Room 의 추가 설명

- Room은 쿼리와 트랜잭션 사용 시 내부적으로 Executor를 사용하여 별도로 suspend function을 구현하고 이를 사용
- Retrofit은 내부적으로 콜백을 생성하고 이를 호출하는 방식으로 suspend function을 구현하여 사용

#### 안드로이드 테스트 - 빌드 - 배포 사이클 설명

- 새로운 요구사항 정립
- 테스트 작성
  - 기획서 기반으로 요구사항을 정리하면서 테스트 케이스를 정의
  - 가장 작은 단위의 유닛 테스트를 작성하여 뷰모델 클래스를 기준으로 테스트 커버리지가 100% 최대한 수렴하는 것을 목표로 작성
  - 유닛테스트 작성 시 해당 로직의 의도 파악이 쉬워짐
  - 테스트 코드 작성 시 Given - When - Then 패턴을 기준으로 작성
- 기능 개발
  - 유닛 테스트를 기반으로 뷰 모델 클래스부터 개발 시작
  - 비즈니스 로직 선개발이 이루어지고 난 후에 UI 개발 진행
  - 개발 도중 추가 테스트 케이스 작성 / 수정 작업이 이루어짐
- PR (Pull Request)
  - 코드 리뷰를 위해 PR 생성
  - feature 브랜치는 Jira 작업 티켓과 1:1로 생성
  - feature/hotfix -> release - master 순으로 코드 반영
  - feature -> release 브랜치로 머지 시도 시 PR 생성
- 빌드 / 배포
  - QA 진행하기 위한 환경 구축
  - 테스트를 위한 앱 빌드와 배포는 fastlane 사용
  - 파이어베이스 앱 Distribution에 앱 업로드 (fastlane 통해 자동화 가능)
  - fastlane 명령어를 입력하면 미리 세팅된 서버와 빌드 타입에 맞게 사이닝이 이루어지고 lokalise 리소스를 자동으로 업데이트 시킨 후 빌드가 완료되면 자동으로 Firebase App Distribution으로 테스터 배포 그리고 슬랙 / 메일 메시지 발송되는 프로세스화 가능
- 프로덕션 출시
  - QA 완료 후 실 배포
  - 앱 수동 빌드 후 먼저 알파 테스트 채널에 먼저 업로드
  - 구글 플레이 콘솔에서 알파 또는 베타 채널에 앱을 게시하면 자동으로 다양한 기기에서 통합 테스트가 진행
  - 프로덕션 채널로 앱 업로드 (하루 이상 시간 소요)
  - 처음에는 5~10% 타겟팅 대상으로 배포 진행
  - 경과를 본 후 이상 없을 시 100%로 변경

#### Android Test Code 작성 관련 처리 사항 정리

- 안드로이드 테스트코드를 작성
- 실행했을 때 Test events 가 들어온 것이 없다는 에러 발생
  - Hilt를 사용하고 인드로이드 모듈을 사용하는 부분이 있어서 androidTest로 코드를 이동
- 코드 이동 후 실행 시 packagingOptions excludes 관련 에러 발생
  - Warning에서 가이드하는 내용들을 excludes 목록에 추가
- Hilt 테스트 관련 에러 발생
- 테스트코드 클래스에 HiltAndroidTest와 Rules 그리고 필요한 객체를 Inject
- 그리고 rules.inject() 수행하여 Hilt 동작 확인
- 기본 Test나 Before, After 어노테이션 동작 이상
  - build.gradle dependencies 재확인 및 등록 처리
- 정상적으로 테스트 케이스 수행은 되는 것 같으나 http 통신이 안되는 이슈 발생
  - 앱 내 필요한 프리퍼런스, 베이스 url등이 제대로 셋팅되지 않아 발생한 이슈
  - 앱 시나리오 적인 코드 적용 후 다시 시도
- 테스트 케이스 정상 수행
- 최소한의 코드 작성으로 기존에 구현한 뷰모델, di 등을 최대한 활용한 테스트 코드 작성법에 대해서는 조금 더 검토 필요

#### 단말 기기 해상도에 따라 레이아웃 처리 분기

- 레이아웃은 기본적으로 ConstraintLayout
- dpi별로 레이아웃 또는 dimens xml 생성
- Guideline view (begin dp / percent)
- ScalableLayout 
- 해상도별 크기 대응
```
class ApplicationClass : Application() {
    companion object {
        var dpHeight = 0.0F
        var dpWidth = 0.0F
    }
 
    override fun onCreate() {
        super.onCreate()
 
        val windowManager = applicationContext.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val display = windowManager.defaultDisplay
        val outMetrics = DisplayMetrics()
        display.getMetrics(outMetrics)
 
        val density = resources.displayMetrics.density
        dpHeight = outMetrics.heightPixels / density
        dpWidth = outMetrics.widthPixels / density
    }
}
```

#### JUnit 테스팅

- 어느 정도 개발이 진행되면 프로그램에 대한 단위 테스트는 반드시 수행해야 하는데, JUnit은 보이지 않고 숨겨진 단위 테스트를 끌어내어 정형화시켜 단위 테스트를 쉽게 해주는 테스트용 Framework
- JDK 1.4에서 추가된 assert...를 사용하여 Test 진행 가능
- JUnit은 테스트 결과를 단순한 텍스트로 남기는 것이 아니라 Test클래스로 남김
- 개발자에게 테스트 방법 및 클래스의 History를 넘겨주는 것 가능
- 특징
  - 단위 테스트 Framework 중 하나 
  - 문자 혹은 GUI 기반으로 실행됨 
  - 단정문으로 테스트 케이스의 수행 결과를 판별함(assertEquals(예상 값, 실제 값)) 
    - assertArrayEquals(a,b) : 배열 a와b가 일치함을 확인  
    - assertEquals(a,b) : 객체 a와b의 값이 같은지 확인  
    - assertSame(a,b) : 객체 a와b가 같은 객체임을 확인  
    - assertTrue(a) : a가 참인지 확인  
    - assertNotNull(a) : a객체가 null이 아님을 확인
  - 어노테이션으로 간결하게 지원함 
  - 결과는 성공(녹색), 실패(붉은색) 중 하나로 표시
- 어노테이션
  - (1) 테스트 메소드 지정
    - @Test가 메소드 위에 선언되면 이 메소드는 테스트 대상 메소드임을 의미
  - (2) 테스트 메소드 수행시간 제한
    - @Test(timeout=5000)를 메소드 위에 선언
    - 시간단위는 밀리 초
    - 이 테스트 메소드가 결과를 반환하는데 5,000밀리 초를 넘긴다면 이 테스트는 실패하는 것
  - (3) 테스트 메소드 Exception 지정
    - @Test(expected=RuntimeException.class)가 메소드 위에 선언되면 이 테스트 메소드는 RuntimeException이 발생해야 테스트가 성공, 그렇지 않으면 실패하는 것
  - (4) 초기화 및 해제
    - @BeforeClass, @AfterClass가 메소드 위에 선언되면 해당 테스트 클래스에서 딱 한 번씩만 수행되도록 지정하는 어노테이션
    - @Before, @After가 메소드 위에 선언되면 해당 테스트 클래스 안에 메소드들이 테스트 되기 전과 후에 각각 실행되게 지정하는 어노테이션

#### Android espresso
- Android Unit Test Framework
- UI 상호작용을 실행할 때 작업을 동기화된 상태로 유지해 주며, 백그라운드 작업이 존재하는 경우 그 작업이 완료 된 뒤에 테스트를 진행함
- 즉, 안정적인 환경에서 UI Test 를 할 수 있게 도와주는 프레임워크
- 의존성 작성 시 발생가능한 예외상황
  - AndroidX 를 사용할 때, com.android.support 와 동시에 사용하게 되면 충돌이 발생하여 정상 동작을 하지 않는 경우가 발생
- UI Test는 androidTest 에서 진행
- @get:Rule 어노테이션을 달고있는 변수
  - ActivityTestRule 을 사용하여 해당 작성할 Test 가 수행 될 Activity 에 대한 설정을 해줌
  - 해당 설정을 해주지 않으면, 수행 할 Acitivity 를 찾지 못하여 빌드 시 에러가 발생
- UI Function
  - onView(ViewMatcher) 에는 동작을 수행할 리소스의 id 값을 넣어주면 됨
  - onView(withId(R.id.text1)) 과 같이 선언해 줌
  - withId(R.id.text1) 를 사용하여 이벤트를 수행할 ID 값을 작성하면 됨
  - perform(ViewAction) 에는 말 그대로 수행할 동작에 대해 작성
  - perform 으로 선언할 때, 한가지의 동작만 수행하는 것이 아니라 , 로 구분하여 순차적으로 여러 개의 동작을 수행하게 작성 가능
- References
  - https://github.com/HeeGyeong/UnitTestSample
  - https://developer.android.com/training/testing/espresso/basics 

#### 안드로이드 화면 밀도

- 화면 공간 안의 픽셀 개수, dpi(dots per inch)에 따라 분류
- ldpi
  - 저밀도(120dpi) 화면에 해당
- mdpi
  - 중밀도(160dpi) 화면에 해당
- hdpi
  - 고밀도(240dpi) 화면에 해당
- xhdpi
  - 초고밀도(320dpi) 화면에 해당
- xxhdpi 	
  - 초초고밀도(480dpi) 화면에 해당
- xxxhdpi
  - 초초초고밀도(640dpi) 화면에 해당
- 기기의 dpi가 기준 되는 dpi와 정확하게 맞아야 하는 것은 아님
- 기기의 dpi와 가장 비슷한 레이아웃으로 자동으로 찾아감
- 이때 고밀도에서 저밀도 순으로 우선순위가 정해짐
- 최소 너비
  - 사용 가능한 화면 영역의 가장 짧은 치수를 기준으로 분류
- sw<N>dp
  - 사용 예 : sw320dp, sw600dp, sw720dp
  - sw600dp로 분류된 레이아웃은 화면의 사용 가능한 영역 중,
  - 가로 또는 세로 중 짧은 치수를 기준으로 600dp가 넘는 경우에만 접근이 가능하도록 함
- 사용 가능한 화면 너비 또는 높이
  - 사용 가능한 최소 너비 또는 높이를 기준으로 분류
- w<N>dp
  - 최소 사용 가능 너비를 dp로 지정
 	- 사용 예 : w720dp, w1024dp 
- h<N>dp
  - 최소 사용 가능 높이를 dp로 지정
 	- 사용 예 : h720dp, h1024dp 
- 이전에 사용하던 화면 크기에 따른 분류(small, normal, large, xlarge)를 대체하여 사용하도록 권장되고 있음
  - 지정된 dp를 기준으로 가로 또는 높이가 기준 dp보다 높을 경우에만 접근이 가능하도록 함
- 흔히 이 방법은 가로 모드와 세로 모드가 다른 레이아웃에 대응하기 위해 사용하기도 함
- 화면 방향
  - 화면 방향에 따라 분류
  - port: 세로 모드에 해당
  - land: 가로 모드에 해당
- 진화된 방법으로 레이아웃은 하나로 통일시키고 dimens.xml을 세분화 하여 사용하는 방법도 가능

#### 리소스 활용 / 스마트폰 크기 호환성

- Display Mertics
  - 안드로이드 스마트폰 크기 호환성을 위해 개발자 코드에서 직접 스마트폰의 크기 정보를 획득해야 하는 경우가 있음
  - 이 때 사용 가능한 클래스
```
DisplayMetrics dm=new DisplayMetrics();
getWindowManager().getDefaultDisplay().getMetrics(dm);
```
- 획득 가능한 화면 정보
  - widthPixels: 가로 화소 수
  - heightPixels: 세로 화소 수
  - densityDpi: 화면 밀도
  - density: mdpi를 기준으로 한 배율. 스케일링 시 곱해지는 값
  - scaledDensity: 문자열 스케일링 시 곱해지는 값
  - xdpi: 정확한 가로 밀도
  - ydpi: 정확한 세로 밀도

#### 화면 사이즈 dp 구하기
```
Display display = getWindowManager().getDefaultDisplay();
DisplayMetrics outMetrics = new DisplayMetrics ();
display.getMetrics(outMetrics);
    
float density = getResources().getDisplayMetrics().density;
float dpHeight = outMetrics.heightPixels / density;
float dpWidth = outMetrics.widthPixels / density;
```

#### 반응형 그리드뷰 구현

- 매터리얼 디자인
  - Columns, Gutters, Margins
  - 레이아웃 그리드는 ①컬럼(열), ②거터, ③여백으로 이루어져 있음
  - 중단점, Break Point
  - 그리드 동작
    - Fluid grids / Fixed grids

#### 네비게이션 컴포넌트 - 목적지 설정

'''
val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
    val inflater = navHostFragment.navController.navInflater
    val graph = inflater.inflate(R.navigation.booking_navigation)

    if (isTrue){
        graph.startDestination = R.id.DetailsFragment
    }else {
        graph.startDestination = R.id.OtherDetailsFragment
    }

    val navController = navHostFragment.navController
    navController.setGraph(graph, intent.extras)
'''
'''
// Configure the navigation
val navHost = nav_host_fragment as NavHostFragment
graph = navHost.navController
        .navInflater.inflate(R.navigation.nav_graph)
graph.startDestination = R.id.welcomeFragment

// This seems to be a magical command. Not sure why it's needed :(
navHost.navController.graph = graph

NavigationUI.setupActionBarWithNavController(this, navHost.navController)
'''

#### ConstraintLayout flow 설명

- androidx.constraintlayout.helper.widget.Flow
- Id만 지정해주면 알아서 정렬
- constraint_referenced_ids 에 아이디 지정
  - backBtn,searchBtn
- flow_horizontalGap
  - 제약을 걸어준 아이템들의 사이 간격(수평) 지정 가능

#### DPI 설명

- PX 최소 단위
- DPI는 Dot Per Inch로 1인치에 들어가는 픽셀을 나타내는 단위
- ldpi : 120dpi
- mdpi : 160dpi (기본)
- hdpi : 240dpi
- xhdpi : 320dpi
- xxhdpi : 480dpi
- xxxhdpi : 640dpi
- 안드로이드의 기준 DPI는 160 DPI
- 160 DPI인 경우 밀도 독립단위 DP와 PX이 같은 크기를 가짐
- 즉, 160 DPI에서는 1dp는 1px이 됨

#### BottomSheetDialog behavior 구현 건

```
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:id="@+id/bottom_view"
    app:behavior_hideable="false"
    app:behavior_peekHeight="0dp"
    app:layout_behavior="com.google.android.material.bottomsheet.BottomSheetBehavior"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:layout_gravity="bottom"
    android:animateLayoutChanges="false"
    android:background="@color/white"
    android:orientation="vertical">
    
    ...
    </LinearLayout>
```
```
class BottomCalendar() : BottomSheetDialogFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.bottom_dialog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
		
        // 팝업 생성 시 전체화면으로 띄우기
        val bottomSheet = dialog?.findViewById<View>(com.google.android.material.R.id.design_bottom_sheet)
        val behavior = BottomSheetBehavior.from<View>(bottomSheet!!)
        behavior.state = BottomSheetBehavior.STATE_EXPANDED

		// 드래그해도 팝업이 종료되지 않도록
        behavior.addBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
            override fun onStateChanged(bottomSheet: View, newState: Int) {
                if (newState == BottomSheetBehavior.STATE_DRAGGING) {
                    behavior.state = BottomSheetBehavior.STATE_EXPANDED
                }
            }

            override fun onSlide(bottomSheet: View, slideOffset: Float) {}
        })
        
    }
}
```
- Bottom Sheet Dialog의 특징 중 하나로 아래로 드래그를 할 경우 팝업이 내려가게 됨
- 드래그 되지 않고, 팝업에 있는 close 버튼이나 확인 버튼을 통해 팝업이 종료되도록 하기 위해서 addBottomSheetCallback을 추가하여 State가 EXPANDED 하도록 설정
- 참고 Behavior 상태
  - STATE_EXPANDED : 완전히 펼쳐진 상태
  - STATE_COLLAPSED : 접혀있는 상태
  - STATE_HIDDEN : 아래로 숨겨진 상태
  - STATE_HALF_EXPANDED : 절반으로 펼쳐진 상태
  - STATE_DRAGGING : 드래깅 되고 있는 상태
  - STATE_SETTING : 드래그/스와이프 직후 고정된 상태

#### RecyclerView ViewType을 지정한 서로 다른 뷰 표시 설명

- 흔한 예제: 좌/우 채팅창 화면
- 보통 데이터 모델 만들 때 그 모델이 뷰 타입을 가지고 있어야 함
- 각각의 뷰 홀더를 정의
- 뷰 타입 구분을 위한 상수 선언
- 아답터 내 onCreateViewHolder & onBindViewHolder 리턴 분기 처리 (뷰 타입으로 분기)
```
override fun getItemViewType(position: Int): Int {
        return items[position].viewType
    }
```
```
// setData
for (i in 0..15) {
            val item = ChatBubble(
                chatText = "chat text$i",
                viewType = if (i % 2 == 0) BubbleViewType.LEFT else BubbleViewType.RIGHT
            )
            data.add(item)
        }
        chatAdapter.setData(list = data)
```

#### 안드로이드 네비게이션 popupto, popuptoinclusive

- popUpTo는 BackStack에서 어디까지 이동할 것인지 결정하는 속성
- popUpToInclusive는 popUpTo로 지정한 fragment까지 pop 시킬 것인지 정하는 속성
- ex)
  - fragment1  -> frgment2 -> frgment3 -> frgment4
  - fragment3에서 fragment4로 이동하는 액션을 아래처럼 만들었다고 가정하면 fragment4에서 popBackStack() 시 fragment2로 이동함
```
<action
      android:id=="@+id/action__fragment3_to_fragment4"
      app:destination="@id/fragment4"
      app:popUpTo="@id/fragment2"
      app:popUpToInclusive="false"/>
```
- 만약 app:popUpToInclusive="true" 였다면 fragment1로 이동함
- popUpToInclusive
  - 지정된 목적지를 포함하지 않고 그 이전의 모든 프래그먼트를 제거함. 이는 대상 목적지 자체도 백 스택에서 제거되는 의미
  - popUpTo의 대상 목적지를 포함하여 제거할 수 있음. 즉, popUpToInclusive="true"로 설정하면 대상 목적지도 함께 제거됨

#### Android Workmanager 관련 설명

- 배경
  - 안드로이드가 버전업을 거듭하며 어느 순간부터 백그라운드 작업이 수월하지 않게 되었음
  - 초기에는 Service를 이용해서 작업하거나 Broadcast Receiver를 통하여 프로세스를 깨우는 것 또한 쉽게 가능
  - 안드로이드 M(API 23)부터 백그라운드 작업을 위한 제약 사항들이 추가되며, 개발자들은 여러 API를 통하여 추가 코드 작성이 필요해졌는데 불가능한 것은 아니지만 구현적인 측면에서 까다로워졌음
- 선택 기준
  - WorkManager는 프로세스 종료 여부와 관계없이 반드시 작업을 실행
  - 하지만 작업이 즉시 실행되는 것을 보장하지 않음으로 적합한 솔루션을 고민해야 함
  - 서버에 로그 또는 분석 데이터를 전송하거나 주기적으로 로컬 데이터를 서버와 동기화하는 작업, 이미지 저장 및 업로드 등의 작업이라면 WorkManager 사용을 선택해도 좋음

#### 딥링크 개념 재정리

- 통상적인 설명
  - 홈페이지 메인 페이지가 아닌 홈페이지 내에 특정 화면에 한 번에 도달할 수 있는 링크
  - https://www.blog.naver.com 일반 링크라면 딥 링크는 https://www.blog.naver.com/xxxxxx 라고 할 수 있음
- 모바일과 웹에서 모두 사용되는 개념
- URL Scheme
  - URL Scheme 방식은 Android와 iOS 모두 사용 가능한 최초의 딥 링크 수단
  - scheme://host_path
  - URL과 market:// 등
  - 참고: URI= 식별자, URL=식별자+위치
  - 단순 설명
    - URL Scheme은 리소스를 구별하기 용도로 사용하기 때문에 우리 앱을 부르는 고유한 수단으로 사용할 수 있음
    - 모바일 기기에서 URL Scheme 링크를 클릭했을 때 우리 앱이 캐치하여 반응하게 만드는 것임
  - 코드 베이스 설명
    - Activity 내 intent-filter 내 data 태그에 URL Scheme을 정의할 수 있음
    - scheme는 mashup, host는 deeplink로 정의하면, mashup://deeplink 가 우리 앱의 딥 링크로 설정된 것이라 보면 됨
  - 매개변수 설정 / 전달 방법
    - mashup://deeplink?date=20231002&message=안녕
```
override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main)

        val action: String? = intent?.action
        val data: Uri? = intent?.data

	if (action == Intent.ACTION_VIEW) {
		val date = data?.getQueryParameter("date")  //20231002
		val message = data?.getQueryParameter("message") //안녕

		...
	}
 }
```
- URL Scheme 한계점
  - Google Play 스토어 앱은 자신들의 앱에서 market:// 사용 중이었는데, 이후 원스토어와 Galaxy Store도 동일한 URL Scheme를 사용하게 되어 유명한 앱의 스킴 값을 알아내서 동일한 스킴으로 앱을 배포를 하는 사람들이 늘어나게 되면서 유명한 앱들이 어려움을 겪게 됨
  - 스킴값 중복 문제(원스토어, 플레이스토어 등의 스킴이 모두 market://)
  - 만약에 사용자가 market:// 에 대한 딥 링크를 통해 열리는 앱을 원스토어로 고정하는 순간 Google Play Store 앱과 Galaxy Store 앱은 이후 딥 링크의 기능을 잃어버리게 됨
  - URL Scheme 방식은 정말 간단한 게 딥 링크를 추가하는 방법이었지만, 간단한 만큼 다른 앱들도 동일하게 추가할 수 있다는 단점이 존재

#### Android Proguard

- 안드로이드에서 ProGuard는 코드 난독화, 최적화, 제거를 수행하는 도구
- ProGuard를 사용하면 앱의 크기를 줄이고, 보안 강화 가능
- ProGuard는 안드로이드 스튜디오에서 쉽게 사용할 수 있으며, 프로젝트의 build.gradle 파일에 설정할 수 있음
- 프로가드는 코드를 난독화 및 최적화를 해주는 무료 오픈소스 툴
- 즉 프로가드는 컴파일된 앱 패키지의 코드를 난독화해서 다른 사람이 해당 패키지를 디컴파일 했을때 해독하기 어렵게 만드는 일종의 보안 장치
- 적용 방법
  - 우선 안드로이드 패키지에서 어플리케이션의 build.gradle에 들어가서 buildTypes를 확인
```
buildTypes {
	release {
    		minifyEnabled false
        	proguardFiles getDefaultProguardFile('proguard-android-optimize.txt'), 'proguard-rules.pro'
            }
}
// release에서 minifyEnabled를 true로 설정하면 proguard가 적용이 됨
// debug 모드에서도 proguard를 적용해 테스트를 해보고싶다면 debug 모드도 추가해줘야 함
```
```
buildTypes {
	release {
    		minifyEnabled true
        	proguardFiles getDefaultProguardFile('proguard-android-optimize.txt'), 'proguard-rules.pro'
            }
	debug {
    		minifyEnabled true
        	proguardFiles getDefaultProguardFile('proguard-android-optimize.txt'), 'proguard-rules.pro'
            }
}
```

#### MVVM ViewModel과 AAC ViewModel 차이점

- MVVM ViewModel은 View와 Model을 바인딩해주는 역할을 함
- AAC ViewModel은 수명주기를 고려해 UI 관련 데이터를 저장하고 관리함

#### RecyclerView DiffUtil 적용 과정

- 배경: 아래 메소드들을 일일이 상황에 맞게 사용하는 것은 공력이 많이 듬
  - notifyItemChanged(int)
  - notifyItemInserted(int)
  - notifyItemRemoved(int)
  - notifyItemRangeChanged(int, int)
  - notifyItemRangeInserted(int, int)
  - notifyItemRangeRemoved(int, int)
- DiffUtil 자체에 대한 설명
  - DiffUtil은 두 데이터셋을 받아서 그 차이를 계산해주는 클래스
  - DiffUtil을 사용하면 두 데이터 셋을 비교한 뒤 그중 변한부분만을 파악하여 Recyclerview에 반영할 수 있음
  - DiffUtil은 Eugene W. Myers의 difference 알고리즘을 이용해서 O(N + D^2)시간 안에 리스트의 비교를 수행
  - 이때 N은 추가 및 제거된 항목의 갯수이고, D는 스크립트의 길이임
- 사용 방법
  - DiffUtil을 사용하기 위해서는 DiffUtil.Callback()을 상속받아 areItemsTheSame으로 비교대상인 두 객체가 동일한지 확인하고,
  - areContentsTheSame으로 두 아이템이 동일한 데이터를 가지는지 확인하면 됨
- 참고 링크
  - https://cliearl.github.io/posts/android/recyclerview-listadapter/

#### BottomSheetDialogFragment vs BottomSheetDialog

- bottomsheetDialogFragment는 fragment를 상속받은 object
- 따라서 bottomsheetDialog에는 없는 lifecycle이 bottomsheetDialogFragment에는 존재
- activity가 destroy 되었는데 dialog가 dismiss되지 않아서 생기는 windowleak 같은 에러가 bottomsheetDialogFragment에는 일어나지 않는다는 장점이
있음
- BottomSheetDialog 종류로는 Modal, Persistent가 존재
  - 모달은 열고 닫기가 끝이나 Persistent는 살짝 또는 많이 펼치는 등의 여러 상태 조절이
가능
- Behavior 내용
  - Behavior 속성
    - app:layout_behavior로 BottomSheetBehavior를 설정했다면 다음과 같은 속성도 사용 가능
    - behavior_hideable : 아래로 드래그했을 때 뷰를 숨길지 여부를 결정. DialogBottomSheet의 경우의 기본값은 true이고 그 외의 경우 기본값은 false
    - behavior_skipCollapsed: 뷰를 숨길 때 접히는 상태를 무시할 지 여부를 결정. 기본값은 false이며 behavior_hideable이 false라면 효과가 없음
    - behavior_draggable : 드래그하여 뷰를 접을 지 펼칠 지 여부를 결정. 기본값은 true.
    - behavior_fitToContents: 펼쳐진 뷰의 높이가 content를 감쌀 것인지의 여부를 결정. false로 설정하게 되면 뷰가 펼쳐졌을 때 아래로 드래그할 경우 부모 컨테이너 높이의 절반으로 먼저 접히고 다시 드래그 하면 완전히 접혀짐. 기본값은 true.
    - behavior_halfExpandedRatio : 절반만 펼쳐졌을 경우 뷰의 높이를 결정. 기본값은 0.5. behavior_fitToContents 가 true라면 효과가 없음.
    - behavior_expandedOffset : 완전히 펼쳐진 상태일 때 뷰의 오프셋을 결정. 마찬가지로 behavior_fitToContents 가 true라면 효과가 없으며 절반으로 접혔을 경우의 오프셋보다 커야함. 기본값은 0dp.
    - behavior_peekHeight : 뷰가 접힌 상태의 높이. 기본값은 auto.

#### 확장함수 사용편

- 추가적인 메소드를 구현하면 이를 확장 함수 라고 하고 추가적인 프로퍼티를 구현하면 확장 프로퍼티
- 마치 기본 클래스에 정의된 함수인 것처럼 새로운 기능을 추가하는 기능!
- 수정할 수 없는 Third-party-libarary의 클래스에 새로운 기능을 확장하고 싶을 때
- Retrofit이나 Glide 같은 외부 라이브러리의 Class는 변형할 수 없지만, 함수나 프로퍼티를 추가하여 확장 가능
- 기존 이미 있는 기본 클래스에 함수 추가
- 예를 들면 아래와 같이 Int, String와 같은 기본 타입(클래스)에도 함수를 추가
- receiver type : 확장 대상이 될 클래스
- receiver object : 확장 함수의 내부 구현 시 this 키워드를 사용하여 receiver type이 가지고 있는 public 인스턴스에 접근하는 객체
- 만약, RecyclerView에서 isShowing이 true인 아이템만 출력하고 싶다면 filter 키워드를 사용하여 items.filter { it.isShowing }. forEach { }와 같은 방식으로 작성하는 방식이 있음
- 하지만 아래 코드처럼 확장 프로퍼티를 사용한다면 items.filterInvisible.forEach { }와 같은 방식으로 작성하여 재사용성을 높일 수 있습니다.
해당 예제를 통해 확장 함수뿐만 아니라 확장 프로퍼티 또한 가능
- data class Item(val value: Int, var isShowing: Boolean)
- val ArrayList<Item>.filterInvisible
- get() = this.filter { it.isShowing }

#### Kotlin Extension Function을 사용하여 더블 클릭 방지 방법

- 클릭리스너 구현
```
class OnSingleClickListener(private val onSingleClick: (View) -> Unit) : View.OnClickListener {
    companion object {
        private const val CLICK_INTERVAL = 500
    }

    private var lastClickedTime: Long = 0L

    override fun onClick(v: View?) {
        if (isSafe() && v != null) {
            lastClickedTime = System.currentTimeMillis()
            onSingleClick(v)
        }  
    }

    private fun isSafe(): Boolean {
        return System.currentTimeMillis() - lastClickedTime > CLICK_INTERVAL
    }
}
```
- 확장함수 정의
```
fun View.setOnSingleClickListener(onSingleClick: (View) -> Unit) {
    val singleClickListener = OnSingleClickListener { onSingleClick(it) }
    setOnClickListener(singleClickListener)
}
```
- 실제 사용
```
textView.setOnSingleClickListener { onClickItem() }
```
- 확장함수 많이 사용하게 되는 경우
  - 종류별로 Extention Function을 모아서 관리하는 것을 추천
  - 코틀린은 파일 == 클래스 가 아니니까 예를 들면, ViewExtentions 에는 View 관련 확장 함수들 / CollectionExtensions에는 collection 관련 확장 함수들을 위치
  - 확장 함수가 늘어난다면, TextViewExtensions, ButtonExtensions / ListExtensions, MapExtensions 등 처럼 더 상세하게 쪼개는 것도 가능

#### TestCode 테스트코드 classicist, Mockist

- 테스트코드 작성 시 고민
  - 테스트를 구성하다 보면 실제 객체를 사용해서 테스트를 구성해야 할 지 아니면 Mock 을 사용해서 구성해야 할 지 고민
- Test Double 테스트더블
  - 개념: 실제 객체를 활용하기에 어렵거나 비용이 많이 들 때 사용하는 가짜 객체를 의미
  - Dummy
    - 가장 기본적인 테스트 더블
    - 인스턴스화 된 객체가 필요하지만 기능은 필요하지 않은 경우에 사용
    - Dummy 객체의 메서드가 호출되었을 때 정상 동작은 보장하지 않음
    - 객체는 전달되지만 사용되지 않는 객체
    - 인스턴스화된 객체가 필요해서 구현한 가짜 객체일 뿐이고, 생성된 Dummy 객체는 정상적인 동작을 보장하지 않음
    - 동작하지 않아도 테스트에는 영향을 미치지 않는 객체를 Dummy 객체
  - Fake
    - 복잡한 로직이나 객체 내부에서 필요로 하는 다른 외부 객체들의 동작을 단순화 하여 구현한 객체
    - 동작의 구현을 갖고 있지만, 실제 프로덕션에는 적합하지 않는 객체를 의미
    - 동작은 하지만 실제 사용하는 객체처럼 정교하게 동작하지는 않는 객체
    - 실제 객체와 동일한 역할을 하지만 실제 사용하는 객체처럼 정교하게는 돌아가지 않는 객체를 Fake
  - Stub
    - Dummy 객체가 실제로 동작하는 것처럼 보이게 만들어 놓은 객체
    - 인터페이스 또는 기본 클래스가 최소한으로 구현된 상태
    - 테스트에서 호출된 요청에 대해 미리 준비해둔 결과를 제공
    - 테스트를 위해 프로그래밍된 내용에 대해서만 준비된 결과를 제공하는 객체
    - 테스트를 위해 의도한 결과만 반환되도록 하기 위한 객체가 Stub
  - Spy
    - Stub 의 역할을 가지면서 호출된 내용에 대해 약간의 정보를 기록
    - 테스트 더블로 구현된 객체에 자기 자신이 호출 되었을 때 확인이 필요한 부분을 기록하도록 구현
    - 실제 객체처럼 동작시킬 수도 있고, 필요한 부분에 대해서는 Stub 으로 만들어서 동작을 지정할 수도 있음
    - 실제 객체로도 사용할 수 있고 Stub 객체로도 활용할 수 있으며 필요한 경우 특정 메서드가 제대로 호출되었는지 여부를 확인 가능
  - Mock
    - 호출 될 것으로 예상되는 메서드에 대해서 반환하는 값의 사양과 기댓값을 미리 프로그래밍 하는 객체를 의미
    - 테스트 대상 클래스
  - SUT 협력객체
    - SUT 가 의존하는 클래스
- 단위 Unit
  - 소프트웨어의 작은 부분에 집중하는 Low-Level 테스트를 다룬다는 것
  - 일반적인 테스트 도구를 사용한다는 점
  - 실행 속도가 빠름
- 종류
  - 더블을 사용하지 않는 테스트는 Sociable Unit Test
  - 더블을 사용하여 실제 의존 클래스로부터 격리된 테스트는 Solitary Unit Test
- Solitary 를 지향하는 사람들을 Mockist
- Sociable 한 테스트도 괜찮다고 생각하는 사람들은 Classicist
- 상태검증
  - Classicist 가 주로 사용하는 검증방법
  - 검증을 위해서 테스트 하는 메서드나 상황이 수행된 다음 객체 내부의 상태를 확인하게 되는데 상태 검증을 사용하게 되면 테스트를 위해서 상태를 드러내야 하는 메서드가 생길 수도 있지만 행위가 끝난 후에 상태를 직접적으로 검증하기 때문에 테스트에 대한 안정감은 더 높아 질 수도 있음
- 행위검증
  - mock 을 사용하면 verify() 메서드를 통해서 테스트 하고자 하는 상황이 수행된 뒤 협력 객체의 특정 메서드가 호출되어 있는지를 검증하고 있는 모습을 볼 수 있음
  - 만약 메서드가 호출되지 않았다면 테스트는 실패
  - 이처럼 객체 내부의 상태를 확인하는 것이 아닌 특정 행동이 이루어졌나를 확인하는 검증을 행위 검증이라고 표현
  - 행위 검증을 하게 되면 상태를 드러내는 메서드를 만들지 않아도 되지만 SUT 에 대한 구현 방식이 드러나게 됨
  - 또한 행위 검증을 끝내지만 상태를 확인한 것이 아니기 때문에 비교적 테스트에 대한 안정감은 낮아질 수도 있음

#### RecyclerView 아이템 깜박임 제거

- recyclerView.apply { itemAnimator = null }
- Glide option에 thumbnail 추가
```
// 아래 코드는 적용해보았으나 (리싸이클러뷰 안에서) 깜빡임 현상은 계속됨
Glide.with(context)
  .load(sound.imgUrl)
  .thumbnail(Glide.with(context).load(sound.imgUrl).override(100, 100))
  .override(100, 100)
  .skipMemoryCache(true)
  .dontAnimate()
  .into(coverImageView)
```
- Adapter 클래스 내에서 getItemViewType(), getItemId()를 오버라이딩받아서 아이템마다 아이디를 부여하는 방법
```
// 아래 코드도 마찬가지로 효과없음
override fun getItemViewType(position: Int): Int {
      return position
  }

  override fun getItemId(position: Int): Long {
      return position.toLong()
  }
```
```
val playListAdapter = PlayListAdapter(requireContext())
playListAdapter.setHasStableIds(true)
```
- 깜빡임 조치를 위한 미검증된 코드 (효과없음)
  - recyclerView로부터 ItemAnimator를 가져와 setSupportsChangeAnimations를 false로 설정하기
  - recyclerView로부터 ItemAnimator를 가져와 setChangeDuration값 0으로 설정하기
```
(fileExplorerList.getItemAnimator() as DefaultItemAnimator).setSupportsChangeAnimations(false)
  recyclerViewPicture?.getItemAnimator()?.setChangeDuration(0)
```
```
// 아래 코드는 효과가 있음
// 효과가 있으나 이슈가 발견된 상황
// 케이스 1: 
// 리싸이클러뷰 (그리드 레이아웃 매니저 사용) 에서 스크롤 하다 보면 엉뚱한 아이템들에 대해 photoUrl이 적용되어 있는 문제가 발생
Glide.with(context).asBitmap().load(photoUrl).transition(
                BitmapTransitionOptions.withCrossFade()
            ).override(200).into(object : CustomTarget<Bitmap?>() {
                override fun onResourceReady(
                    resource: Bitmap,
                    transition: Transition<in Bitmap?>?,
                ) {
                    setImageBitmap(resource)
                }

                override fun onLoadCleared(placeholder: Drawable?) {
                    setImageDrawable(placeholder)
                }

                override fun onLoadFailed(errorDrawable: Drawable?) {
                    setImageDrawable(errorDrawable)
                }
            })
// 그래서 아래와 같이 다시 원복 시키고 테스트하면 다시 이미지 깜빡임 현상이 발생하고 있음
Glide.with(context).asBitmap().load(photoUrl).transition(
                BitmapTransitionOptions.withCrossFade()
            ).override(200).into(this)            
```

#### Glide

- 구글에서 밀고 있는 이미지 로딩 라이브러리
- 특징
  - gif, video등을 로딩하는 것도 가능
  - 빠른 로딩을 위해 내부적으로 cache를 가짐
  - httpUrlConnection 라이브러리를 기반으로 하지만, volley, okHttp 등의 라이브러리를 사용할 수 있는 플러그인도 지원.
  - (때문에 url을 통해 웹서버에 접근하여 file등을 다운로드 받을 수 있고 이를 로딩할 수 있음)
- 구조
  - 요청한 이미지를 불러오기 위해 Glide 내부에서 거치는 과정
    - Request, In Memory, On Disk, Network
  - 1. 요청한 Data가 캐시에 저장되어 있는지 먼저 확인. 만약 한번 이상 로딩했다면 이는 캐시에 저장되어 빠르게 이미지를 로딩 가능
  - 2. 캐시에 저장되어 있지 않다면 load할 데이터를 불러와서 로딩. 이는 로컬에 저장된 데이터가 아닌 network통신(데이터가 url인경우)을 통해서 얻어올 수도 있음
  - 캐시를 사용해서 좋은점도 있지만 반대로 메모리관리도 잘해야 함. 물론 Glide에서는 이를 해결할 수 있도록 메서드를 구현하고 있음
- 캐시 Cache 관리
  - 1. skipMemoryCache(Boolean)
    - 로딩한 데이터를 캐시에 저장하길 원치 않는다면 아규먼트 값으로 true를 전달해주면 됨
  - 2. diskCacheStrategy(DiskCacheStrategy strategy)
    - 동일한 리소스(data)를 다양한 크기로 여러 번 사용하고 대역폭 사용을 줄이는 대신 일부 속도 및 디스크 공간을 절충하려면 DiskCacheStrategy.DATA or DiskCacheStrategy.ALL을 넘겨줄 수 있음
    - 만약 캐시에 어떠한 data도 저장하지 않고싶다면 DiskCacheStrategy.NONE을 사용하면 됨
- 캐시 무효화
  - 간혹가다가 Glide에 다른 이미지 업로드가 되지 않는 경우가 존재
  - 이는 캐시에 남아있는 데이터가 먼저 호출되기 때문임
  - 디스크의 캐시들은 해싱된 키 값이기 때문에 이들을 모두 추적해서 캐시를 삭제하는 방법은 쉽지 않음
  - 따라서 원하는 이미지를 로드하려면 콘텐츠가 변경될 때 이를 식별하는 식별자를 매번 다르게 하여 캐시가 저장하지 않은 데이터라고 인식하게 하는 것
  - signiture(objectkey("metaData"))
  - 해당 메서드를 사용하여 해시키 값을 변경시킬 수 있음
    - "metaData"로는 수정된 날짜, mime type, mediaStore item등 다양한 데이터를 넣어주면 됨
    - .signiture(ObjectKey(System.currentTimeMillis()))
    - 해시키를 수정된 날짜 값을 섞어 캐시를 무효화
    - 또한 로딩되는 데이터들은 캐시에 저장되지 않도록 skipMemoryCache메서드와 diskCacheStrategy메서드를 통해 셋팅
    - 마무리로 로딩될 이미지를 원형으로 만들어 이미지뷰에 셋팅해서 마무리

#### Glide 에서 제공하는 함수 설명

- load(url) : url 로드
- error(url) : 로드 실패시 보여줄 이미지 url
- placeholder(url) : 로드 진행 중 보여줄 이미지 url
- centerCrop() : centerCrop(정사각형 만들고 넘어가는 것은 자르는 작업) 외에도 여러가지 가능
- listener() : 로드 실패시, 준비 완료시 리스너
- into(view) : view에 로드

#### Facebook Sns 로그인 연동 이슈 정리

- 페이스북 로그인 기능을 사용하기 위해서는 해당 페이스북 로그인 버튼에 아래와 같이 퍼미션을 넣어줘야 함
- loginButton.setPermissions("email", "public_profile", "user_friends") Make sure to use a Facebook valid keys
- 기존 자바코드에서 코틀린으로 자동 변환하게 되면 IDE 는 permissions와 setPermissions 함수와 변수 혼동이 있어서 제대로 마이그레이션 안될 수 있음
- permissions 는 테스트 목적의 변수, 스트링 리스트 타입을 인자로 취급
- setPermissions 는 varags string 타입을 인자로 취급
- 둘중 아무거나 써도 무관하나 이왕이면 공식 setPermissions 사용 권장

#### 데이터 바인딩 재정리

- 바인딩 어댑터
  - 바인딩 어댑터 레이아웃 요소에 코드를 바인딩 하는 역할
  - 바인딩 어댑터는 UI의 속성 중 값을 할당하기 위해 setter를 호출하거나, 따로 작성한 로직을 실행하거나 또는 사용자의 인터렉션에 반응하도록 함
- 프로젝트 셋팅
  - DataBinding사용을 위해 buildFeatures{ dataBinding true }를 build.gradle(Module) 파일의 android{} 에 추가
- Custom Binding Adapter
  - Custom 바인딩 아답터 오브젝트 클래스 생성
  - 예제: @BindingAdapter("isVisible") fun isVisible(view: View, isVisible: Boolean)
  - 예제: @BindingAdapter("imageUrl") fun loadImage(view: ImageView, url: String)
- ViewBinding, DataBinding
  - 참고. 액티비티 내 일반 변수는 화면 회전 등의 Configuration 변화 시 값이 초기화되는 문제가 있음. 뷰 모델을 사용하면 이 문제를 해결할 수 있음
    - 레이아웃에서는 text를 초기화 해주는 부분을 빼줘야 하는데 이걸 안 빼주면 화면을 회전할때마다 처음에 무조건 작성한 초기값이 표시됨
    - https://github.com/juhwankim-dev/SelfStudy/tree/master/IncreaseNumber
  - ViewBinding
    - findViewById 사용 불필요
    - binding = ActivityMainBinding.inflate(layoutInflater)
  - DataBinding
    - binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

#### LiveData --> StateFlow 적용

- 라이브데이터 한계
  - 비동기 스트림을 지원하지 않음
  - LiveData는 UI와 밀접하게 연관되어 있어 오직 메인스레드(Main Thread)에서만 읽고 쓸 수 있음
  - 따라서 ViewModel에서 LiveData를 사용하여 View를 업데이트할 때는 사용할 수 있지만, Data Layer에서 데이터를 처리할 때는 사용하기 어려움
  - 데이터를 I/O 할 때에는 메인스레드(Main Thread)가 아닌 작업스레드(Worker Thread)에서 비동기 방식으로 처리되어야 하기 때문임
  - 안드로이드 플랫폼에 종속적
  - LiveData가 안드로이드 생명주기를 인식한다는 점은, Clean Architecture 관점에서 보았을 때 단점이 될 수도 있음
  - Presentation Layer에서는 편리하게 사용할 수 있지만, 플랫폼에 종속적이지 않은 순수한 Kotlin 및 Java 코드로 이루어져야 하는 Domain Layer(Business Layer)에서는 사용하기 어려움
- Flow
  - Flow는 값을 순차적으로 방출(emit)하고 정상적 혹은 예외적으로 완료되는 비동기 데이터 스트림이기 때문에 Data Layer에서 쓸 수 있음
  - 또한, 코틀린의 코루틴 API이기 때문에 안드로이드 플랫폼에 종속적이지도 않음
  - ViewModel에서는 Flow를 직접 쓰는 것이 아니라 StateFlow를 사용하고, View에서는 Lifecycle.repeatOnLifecycle 블록에서 이를 수집하여 사용하여 LiveData처럼 안드로이드의 생명주기를 직접 인식할 수 없는 문제를 해결 가능
- StateFlow의 특징
  - StateFlow는 Flow API 중 하나로 현재 상태와 새로운 상태 업데이트를 collector에 내보내는 관찰 가능한 State Holder Flow
  - LiveData와 마찬가지로 value 속성을 통해 현재 상태 값을 읽을 수 있음
  - Hot stream이기 때문에 생성하자마자 바로 활성화되며, 값이 업데이트 된 경우에만 반환
  - 항상 한 개의 값을 가지고 있기 때문에 초기 상태를 생성자에게 전달해야 함
  - 여러 개의 collector 를 지원하기 때문에 중복 리소스 요청을 방지
  - collector 수에 관계없이 항상 구독하고 있는 것의 최신 값을 받음
- LiveData --> StateFlow 로 변환
  - 참고. MutableLiveData를 쓰면 명시적으로 발행된 이벤트만 전달되는 것이 아니라 이전에 발행되었던 이벤트까지 전달될 수 있기 때문에 MutableLiveData를 확장하여 만든 SingleLiveEvent 클래스를 만들어 화면 이동 처리를 해주는 것이 좋음
    - 클릭 시 호출되는 함수인 경우 MutableLiveData 확장한 SingleLiveEvent 를 만들어서 사용 필요
  - LiveData와 달리 StateFlow에는 초기 값이 필요
  - 따라서 _uiState 객체를 생성할 때 UiState.Loading을 초기값으로 지정
  - 또한 flow 빌더에서 emit() 함수를 통해 Repository에서 수집한 데이터를 방출
  - 이벤트 처리의 경우 SingleLiveEvent 클래스를 따로 만들어 줄 필요 없이 SharedFlow를 사용하여 손쉽게 구현 가능
  - SharedFlow는 StateFlow와 달리 초기값을 가지지 않고, replay 매개변수를 통해 값을 수집할 수 있는 횟수를 결정할 수 있음
  - 여기에서는 replay=0 으로 설정하여 클릭이벤트가 발생했을 때 데이터가 한 번만 수집되도록 하였음
  - 따라서 화면 회전 등 앱의 구성이 변경해도 이벤트는 다시 발생하지 않음
  - 뷰의 생명주기를 인식하는 LiveData와 달리 Flow는 생명주기를 알지 못함
  - 따라서 뷰가 STOPPED 상태가 되면 LiveData.observe()는 소비자 등록을 자동으로 취소하는 반면, StateFlow는 수집을 자동으로 중지하지 않음
  - 따라서 lifeCycleScope 확장함수를 통해 생명주기에 따라 변경된 값을 collect하여 UI를 업데이트 해줄 수 있도록 만듬
  - SharedFlow의 경우도 마찬가지로 collect로 방출된 결과를 받아옴

#### SharedFlow 추가 설명

- Flow -> SharedFlow -> StateFlow로 상속 관계
- SharedFlow는 Flow를 상속 받고 StateFlow는 SharedFlow를 상속 받음
- 핫 스트림, 초기값 가지지 않음
- 보통 StateFlow 사용 시 중복된 리소스 방지 정책으로 인해 이벤트가 오지 않는 문제 발생
  - SharedFlow 사용 하면 이를 해결 가능
- SharedFlow 속성 설명
  - replay : 새로운 구독자들에게 이전 이벤트 방출 여부 (0 = 방출X, 1 = 방출)
  - extraBufferCapacity : 추가 버퍼 생성 여부 (1 = 생성)
  - OnBufferOverflow : 버퍼 초과시 처리 여부 (DROP_OLDEST = oldest 데이터 drop)

#### Delegate pattern

- Delegate Pattern의 의의
  - Delegate Pattern은 보일러 플레이트 코드를 줄여줌
  - 관리 포인트를 일원화시켜 코드 유지보수를 용이하게 해줌
  - 한곳에서 구현하면 다른 곳에서 위임 받아 사용할 수 있기 때문임
- 코틀린 by 키워드
  - 인터페이스 구현에만 사용 가능
  - by 키워드는 interface가 implement되는 경우에만 사용될 수 있음
  - 클래스 상속에는 by 키워드 사용이 불가능
  - 변수(val, var)와 메서드(fun)에 대한 위임만이 가능

#### ViewModel 공유하기

- 액티비티 위에 프래그먼트가 띄워져있는 상황에서 뷰모델을 공유할 상황
  - private val searchViewModel: SearchViewModel by activityViewModels()
  - 프래그먼트들의 부모가 되는 액티비티의 뷰모델을 공유하게 됨으로 한 액티비티에서 파생된 프래그먼트들 끼리는 뷰모델을 공유할수 있고 데이터를 공유하게 됨
  - 당연히 2개의 프래그먼트에서 1개의 뷰모델을 사용하고자 하는 것이기 때문에 두 프래그먼트에서 선언 해야 함
- activityViewModels()의 문제점은 activity가 죽기전까지 viewModel이 계속해서 살아있다는 점
  - 만약 액티비티에 구속되지 않고 프래그먼트들끼리 뷰모델을 공유하고자 한다면
  - private val viewModel: ManageLocationViewModel by viewModels({requireParentFragment()})
  - viewModels를 선언할 때 requireParentFragment를 기준으로 함
  - 액티비티를 기준으로 잡는것과 비슷하지만 이것은 parentfragment가 죽을때 죽음으로써 액티비티에 비해 좀더 완화된 사용법
- 레퍼런스
  - https://zion830.tistory.com/72
  - https://velog.io/@silmxmail/ViewModel-%EA%B3%B5%EC%9C%A0%ED%95%98%EA%B8%B0

#### RecyclerView 의 Adapter 내에서 ViewModel 사용에 대한 내용

- 아답터 뷰 홀더 또는 아답터가 뷰모델 인스턴스를 가지고 있는 경우
  - 안드로이드의 ViewModel은 특히 생명주기와도 밀접해서 이와 관계없는 어댑터나 홀더가 ViewModel의 인스턴스를 가지고 있을 때 잠재적으로 메모리 해제가 안 되거나 하는 문제 발생의 여지가 존재
  - ViewModel에서 관리하는 데이터만 어댑터에 전달하는 것이 좋은 방향
  - 어댑터에서 특정 상황에 ViewModel을 조작하고 싶다면 콜백을 구현해서 조작하는 방향 권장
- 인터페이스 사용해서 처리
  - 만약 아답터 안에 뷰모델을 사용하고 있다면 인터페이스로 분리
  - 만약 어떤 함수가 바로 결과를 뱉는게 아니라 시간이 소요되는 작업인 경우에는 어떤식으로 처리를 해야하는가?

#### Padding 관련 속성 정리

- clipToPadding (RecyclerView)
  - android:clipToPadding="false" 속성을 리사이클러뷰에 주면 패딩공간을 스크롤할 때 공간으로 활용할 수 있음
  - 예
    - 원래 패딩 영역, 아이템1(반쯤가림)
    - 아이템2
    - 아이템3
    - 아이템4
    - 원래 패딩 영역, 아이템5(반쯤가림)
  - 기본적으로 리사이클러뷰에 android:clipToPadding="false" 속성을 주는게 좋다고 함
- cropToPadding (ImageView)
  - 이미지가 레이아웃보다 크다면 잘라 낼 것인지에 확인
  - 보통 레이아웃에서 제공하는 공간(패딩이나 여백을 제외한 공간)에 맞추어 이미지를 잘라내게 됨
- includeFontPadding (TextView)
  - 텍스트 폰트 위/아래 padding 없애기. (includeFontPadding)
  - TextView에 텍스트가 표시될 때 텍스트의 상단에 폰트 자체의 ascent, descent 영역 보다 좀 더 충분한 padding을 추가할지, 아니면 정확하게 ascent, descent 영역만을 사용할지 여부를 지정할 수 있는데 이 때 "includeFontPadding" 속성을 사용
  - 폰트 구조 --> 폰트 메트릭스
    - ascend: baseline에서 위쪽 방향으로 글자까지의 권장 거리. top과 ascend 사이
    - descent: baseline에서 아래쪽 방향으로 글자까지의 권장 거리. bottom과 descent 사이

#### 버튼 쉐도우 효과 제거 방법

- Button, AppCompatButton 등에 해당
- android:stateListAnimator="@null" 추가

#### MVVM 패턴 적용 시 고려해야 사항들

- ViewModel에는 Android Framework가 최대한 없는 방향으로 코드를 작성
- Android Framework에 종속성을 가지지 않아야 lightweight unit test를 진행할 수 있게 되어 leak safety와 modularity가 향상
- 종속성을 가지고 있는지에 대해 쉽게 확인 할 수 있는 방법은 ViewModel 안에 android.* 에 관한 패키지의 import 여부에 대해 확인하면 됨
- ViewModel은 Activity/Fragment 보다 lifecycle이 길기 때문에 Activity/Fragment가 destroy 되고 recreate 되었을 경우 기존에 존재하던 ViewModel을 가지게 됨
- ViewModel은 새로운 Activity/Fragment를 참조하고 있는게 아니라 destroyed된 Activity/Fragment를 참조하고 있기 때문에 memory leak이 일어나거나 crash가 발생하게 됨
- View 뿐만 아니라 Activity의 context를 참조하고 있는 class도 참조해서는 안됨
- ViewModel에서 View랑 통신하고 싶을때
  - ViewModel안에 정의된 LiveData를 활용하여 observer pattern을 이용하여 통신
- Two-way Data Binding 같은 예외적인 케이스를 제외하고 View는 오로지 LiveData를 observe만 해야하기 때문에
- ViewModel에 선언된 MutableLiveData를 getter나 backing properties를 이용하여 캡슐화를 해야함
- Activity/Fragment에 if문이라던지 for문 등 복잡한 로직이 존재하면 안됨
- 이러한 로직은 ViewModel안에 아니면 다른 layer에 존재해야 합니다.
- view는 일반적으로 unit test가 아니므로 view에 존재하는 로직의 유효성을 검사하기 어려움
- Activity/Fragment에는 최소한의 로직만 있어야 함
- 여러 개의 뷰모델을 하나의 뷰에서 사용하는 것 관련해서 우선 Google에서 권장하는 방식은 하나의 ViewModel만을 사용하는것을 권장하고 있음
- 상황에 따라서 여러개의 ViewModel을 사용할 수 있지만
- 하나의 View에 여러개의 ViewModel이 존재했을 경우 복잡도가 높아짐
- 하나의 ViewModel에는 여러 LiveData를 가지는게 더 효율적으로 코드를 관리 할 수 있음
- 뷰모델 내에서 어떤 값을 프리퍼런스에 바로 넣기 보다는 뷰모델에 repository를 주입해서 repository 메소드 안에서 프리퍼런스 업데이트 작업을 하는 것이 테스트와 아키텍쳐 구조 상 좋음
- BindingAdapter나 BindingMethod를 사용하여 사용하고 싶은 attribute를 정의할 수 있음
- BindingAdapter는 주로 extension 형식으로 사용되고
- BindingMethod는 CustomView에서 정의한 setter 메서드를 layout file에서 attribute로 사용할 수 있음
- CustomView를 사용하지 않는 경우에는 BindingAdapter를 사용하고
- CustomView를 사용할 경우에는 최대한 BindingMethod를 사용하는것을 추천
- BindingAdapter를 남발하게되면 setter 메서드를 찾는데 어려움을 겪게 될 수 있음
- CustomView에서 setter 메서드의 parameter가 2개 이상일 경우에는 BindingMethod를 사용할 수 없으므로 이때는 BindingAdapter를 사용해야만 함

#### Atomic Type, Volatile, Synchronized

- 멀티스레드 환경에서 경쟁 상태 (race condition) 고려하기 위한 개념
- Atomic Type
  - Atomic은 CAS 방식에 기반하여 동기화 문제를 해결
  - CAS란: CAS란 변수의 값을 변경하기 전에 기존에 가지고 있던 값이 내가 예상하던 값과 같을 경우에만 새로운 값으로 할당하는 방법
  - Atomic Boolean
    - boolean 자료형을 가지고 있는 wrapping class
    - 동시성 보장
    - compareAndSet(boolean expect, boolean update
    - getAndSet(boolean update). 이 메소드는 이전 값을 리턴하고 새로운 값으로 Atomic하게 update
  - Atomic Integer
    - compareAndSet(int expect, int update)과 getAndSet()을 파라미터나 리턴 타입만 바꿔서 동일하게 제공
    - incrementAndGet(), x만큼 증가시키는 accumulateAndGet(int x, IntBinaryOperator accumulatorFunction)
- Volatile
  - "volatile" 은 Thread1에서 쓰고, Thread2에서 읽는 경우만 동시성을 보장
  - 두개의 쓰레드에서 쓴다면 문제가 될 수 있음. (한쪽에서는 쓰기만하고, 한쪽은 읽기만 하고)
  - 키워드가 붙은 자원은 하나의 thread만이 write하고 나머지는 스레드는 read만 한다는 전제하에만 동시성을 보장
volatile 키워드를 붙인 자원은 read, write 작업이 CPU Cache Memory가 아닌 Main Memory에서 이뤄집니다.
- Synchronized
  - 안전하게 동시성을 보장 가능
  - 하지만 비용이 가장 큼

#### Dokka 문서화

- Dokka로 프로젝트를 문서화하는 법
  - Dokka는 코틀린과 자바로 작성된 프로젝트의 코드를 분석해서 문서화해주는 플러그인
  - Java의 Javadoc과 Kotlin의 Kdoc 구조를 분석 가능
  - 문서는 Javadoc, HTML 형식으로 출력 가능
  - 안드로이드 스튜디오의 예제 프로젝트에 Dokka를 적용 과정
    - 우선 New project > Login Activity를 선택
    - 이 프로젝트는 약간의 구조화가 되어 있고 클래스마다 주석이 달려있기 때문에 Dokka의 예제로 사용하기 좋음
  - Html 문서를 만들고 싶은 경우 ./gradlew dokkaHtml, Javadoc 문서를 작성하고 싶은 경우 ./gradlew dokkaJavadoc을 실행
  - 커맨드를 실행하면 app > build > dokka 폴더에 파일이 생성되기 때문에 index.html을 브라우저에서 실행시키면 됨
  - 그러면 안드로이드 프로젝트 구조에 따라 Html이 보이며 클래스에 달아준 주석의 내용이 같이 표시되게 되
    - noAndroidSdkLink.set(false) 옵션을 적용해서 Dokka 문서가 Android developers의 문서와 연결되지 않도록 했는데 이 외에도 많은 다양한 옵션들이 존재

#### Glide 사용 이슈 및 이미지뷰 관련 정리 내용

- Glide clear 함수로 리소스 해제가 제대로 될 것으로 판단
- 그러나 image view의 포그라운드 이미지가 해제되지 않음
- 그래서 DataBinding된 이미지뷰 확장함수 내에서 강제로 이미지뷰의 이미지 리소스를 초기화
  - setImageResource(0)
  - setBitmapImage(null)
- 이렇게 처리하고 나서 바로 아래 코드에서 background, bitmap image 설정해주니 정상 동작

#### Groovy --> KTS 마이그레이션 과정 재정리

- 마이그레이션 장점
  - kotlin 파일이기 때문에 자동완성이 가능한 점
  - 여러 모듈에서 동일하게 필요한 라이브러리들이 있는데, 그런 것들을 for문으로 한번에 추가할 수 있다는 점
  - gradle에서 Kotlin 문법들을 사용할 수 있다는 점
  - 라이브러리 버전 뿐만 아니라 EndPoint가 변경되었을 때도 수정이 쉽다는 점
- 적용 방법
  - 좌측 프로젝트 패널을 Project Files로 변경
  - 안드로이드 스튜디오에서 File > New > Directory로 프로젝트 root에 buildSrc 폴더를 생성
  - 해당 폴더를 우클릭 후, New > File로 build.gradle.kts 파일을 생성
  - build.gradle.kts 파일 안에 import org.gradle.kotlin.dsl.`kotlin-dsl` plugins {`kotlin-dsl`} repositories {mavenCentral()}
  - 폴더 안에 새로운 directory를 생성하는데, 디렉토리명은 src/main/java 로 설정
  - 생성한 java 폴더 안에 자신의 앱 패키지와 동일하게 폴더를 생성해주고 Configuration object와 Dependencies kotlin파일을 생성
  - Configuration 파일에는 app 단위 gradle의 android 내에 필요한 config 들을 정의
  - Dependencies 파일에는 사용할 플러그인, 라이브러리와 각각의 버전을 작성
    - object Versions/ object Libraries
  - 각 모듈들의 build.gradle 파일의 이름을 build.gradle.kts로 변경
  - KTS 문법을 사용하여 gradle 파일을 수정
- 적용 후기
  - KTS를 적용한 후 buildSrc 한 곳에서 모든 모듈에 적용 중인 라이브러리나 플러그인을 관리함으로써 기존의 작업을 많이 단축시키는 것이 가능
  - gradle에서도 자동완성 기능과 import를 사용할 수 있어서 편리

#### Layout 이름 작명 고찰

- include 되는 레이아웃의 경우 Prefix로 include 또는 inc 를 붙이는게 좋을 듯 함.
  - 예. inc_list_item_xxxx.xml / include_list_item_xxxx.xml
- ConstraintLayout 내 3~4개의 뷰들이 각각 동일한 비율로 자리를 잡으려면
  - start & end를 서로 체인으로 엮어줘야 함
  - start_end, end_start
- 불가피하게 Depth가 깊어지는 레이아웃의 경우 최대한 뎁스없이 구현하거나 또는 include를 사용해서 가독성이라도 높여야 함

#### Android Glide 화질 저하 이슈 및 코너 Radius 적용 건 정리

- 코드에 override 로 강제로 100으로 사이즈 설정이 되어 있는 상태였음
- 해당 코드 삭제 후 아래 코드 추가
```
  Glide.with(context).asBitmap().load(url).transition(
                BitmapTransitionOptions.withCrossFade()
            ).transform(CenterCrop()).transform(RoundedCorners(26)) // <-- transform method 활용하여 이미지 처리
```

#### 텍스트 크기 sp vs dp 재정리

- DP(Density-Independent Pixels)는 UI 레이아웃을 정의할 때 레이아웃 치수나 위치를 지정하기 위해 사용하는 단위
  - 픽셀 독립 단위이며 화면의 크기가 달라도 동일한 비율로 보여주기 위해 안드로이드에서 정의한 단위이며 큰 화면, 작은 화면에 상관없이 같은 크기로 나뉨
  - 밀도 독립형
- SP(Scale-Independent Pixels)는 UI 레이아웃을 정의할 때 텍스트의 크기를 지정하기 위해 사용하는 단위
  - 안드로이드 설정 화면에서 사용자는 안드로이스 시스템 전체에서 보여지는 텍스트의 크기를 선택하여 설정할 수 있는데 SP는 해당 설정에 영향을 받음. 
  - 예를 들어, 시스템 설정에서 텍스트 크기를 "최대 크케"로 설정하게 되면 UI 레이아웃을 정의할 때 SP로 크기를 지정해놓은 TextView의 텍스트 크기가 영향을 받아 커지게 됨.
  - 반면에 TextView의 텍스트 크기를 DP로 설정하게 되면 시스템 설정의 텍스트 크기 값의 변화에 상관없이 일정한 크기를 유지
  - 디자인 명세에 따라서는 텍스트 크기의 값의 단위를 SP를 사용하는 것이 아니라 DP를 사용하는 것이 좋을 경우도 있을 것임.
  - 언제나 일관성 있게 화면에서 똑같은 텍스트 크기를 표현하고자 하는 경우에는 SP가 아닌 DP 단위를 사용하기를 권장

#### marginLeft vs marginStart, start, end가 더 권장되는 이슈 정리

- 일반적인 디자인에서 marginLeft와 marginStart는 동일한 효과
- marginRight와 marginEnd는 동일한 효과
- margin을 주고자 하는 컴포넌트가 textView나 editText와 같은 문자와 관련된 컴포넌트라면 특이사항 발생
- 언어별 특성 차이로 인해 발생하는 불편을 최소화하기 위해 Left대신 Start, Right 대신 End를 사용 권장
- 언어별 특징
  - 대부분의 문자는 왼쪽에서 오른쪽으로 쓰고, 읽음. LTR언어
  - 일부 언어(아랍어, 히브리어, 페르시아어, 우르두어 등)는 오른쪽 -> 왼쪽으로 쓰고, 읽음. RTL언어
- 안드로이드에서는 4.2(API 수준 17)부터 RTL 텍스트 미러링을 지원하기 시작
- 안드로이드 4.2는 2012년에 등장한 것으로 현재 안드로이드 기기에서 대부분 지원한다는 개념
- build.gradle 파일을 확인해보면 targetSdkVersion이 17 이상으로 되어있는지 확인해보아야 함
- 매니페스트에 Rtl를 사용하겠다고 설정되어야 함 (<application ... android:supportsRtl="true")
- 어떤 컴포넌트가 RTL로 표시되었을 때 어떻게 나타나는지 확인하고 싶다면 해당 컴포넌트에 다음 속성 적용
  - android:layoutDirection="rtl"

#### CallbackFlow

- callback을 flow로 변환
- callbackFlow는 Flow라기 보단 flow builder라는 표현이 더 알맞음
- 이름에서 보이듯이 callback을 flow로 변경
- 기존에는 비동기 처리를 위해 callback 구조를 많이 사용하기도 했고, 여타 라이브러리들나 SDK들이 callback으로 응답을 주는 경우가 많기 때문에 이를 중간에서 flow로 converting 하기 위해 사용
- callbackFlow 정의 부분
  - public fun <T> callbackFlow(@BuilderInference block: suspend ProducerScope<T>.() -> Unit): Flow<T> = CallbackFlowBuilder(block)
  - 넘겨받은 block이 CallbackFlowBuilder()의 param으로 들어감
  - 여기서 param의 정의만으로 생성된 block은 ProducerScope이라는 걸 알 수 있음
  - 즉, 내부적으로 channel을 생성
- callbackFlow로 생성되는 coroutine scope은 ProducerScope이므로 기본적인 Channel api를 사용하여 데이터의 방출을 처리
- trySend()를 이용하여 성공과 실패일때 각각 데이터를 전달하도록 처리
- trySend는 coroutine v1.5.0 이후부터 offer를 대신하는 api로 buffer가 꽉 찬 상태에서는 false를 반환
- awaitClose {..}는 ProducerScope block의 코드의 실행이 완료되고 나서 바로 종료되는 걸 막는 코드
- 콜백이 한 번만 올 수도 있으나, addListener(또는 addObserver)로 특정 이벤트를 관찰하는 경우에는 callback이 호출되는 걸 지속적으로 관찰해야 하기 때문에 이 api를 써서 지속적으로 callback을 전달받을 수 있도록 flow를 유지.
- awaitClose는 flow가 cancel 되거나 close 될 때(channel.close()가 명시적으로 호출될 때) 해당 블록을 호출
- 해당 block안에서는 resource를 해체하는 코드가 삽입되어야 함
- 만약 callback을 addObserver()로 등록하여 전달받고 있었다면 removeOvserver()가 들어가야 할 것으로 판단
- awaitClose를 명시하지 않을 경우 observer leak이 발생할 수 있다고 판단하기 때문에 반드시 block의 맨 마지막에 명시해야 하며, 그렇지 않을 경우 exception이 발생하므로 주의 필요
- callbackFlow는 Cold stream
- Cold stream이기 때문에 만약 두 곳에서 collect를 한다면 동일한 결과를 두 번 반환
- 즉 callbackFlow로 구성한 block이 각각 호출
- callbackFlow는 기본적으로 기본 buffer 크기를 사용하도록 고정
- 생성자 param으로 넘겨줄 수 없기 때문에 buffer의 크기를 변경하려면 buffer() operator를 사용 가능

#### onSaveInstanceState & onRestoreInstanceState() 재정리

- onSaveInstanceState()는 onDestroy() 메소드가 호출되기 전에 호출됨
  - onPause --> onStop --> onSaveInstanceState --> onDestroy
- onRestoreInstanceState()는 onCreate() 메소드가 호출된 직후에 호출
  - onCreate --> onStart --> onRestoreInstanceState --> onResume

#### ViewBinding, findViewById 에 대한 근본적인 이유 설명
- 뷰와 상호 작용 하는 코드를 쉽게 작성 가능.
- findViewById 대체. 
- findViewById 의 문제점 리스트업
  - 1. 중복되는 리소스의 존재 문제 (타 레이아웃에 있는 리소스 아이디 참조 가능)
  - 2. 현재 레이아웃이 아닌 다른 레이아웃에 있는 리소스도 참조 가능하기 때문에 컴파일 시점때 에러가 발생하지 않고 런타임때 에러가 발생하는 문제
- ViewBinding 사용 시 타 레이아웃에 있는 아이디는 참조하지 않으므로 오로지 현재 레이아웃에만 집중 가능

#### Coroutine Async / Await / Job Join

- Async 를 사용하면 job join 하는 것보다 훨씬 더 간편하게 사용 가능
  - Job 하나당 3초씩 걸린다 가정 => join 하면 병렬 처리 되어 3초 걸림, join 하지 않으면 6초 걸림
  - val job1 = launch { answer1 = networkCall() },  val job2 = launch { answer2 = networkCall2() }, job1.join(), job2.join()
- Async는 새로운 coroutine을 시작하고 GlobalScope.launch과 비슷하지만, GlobalScope.launch처럼 job(백그라운드 작업)을 리턴하지않고 Deferred를 리턴
- Async를 사용했기 때문에 deferred값을 리턴
  - deferred값을 리턴할 때는 await을 사용해줘야 함.
  - await은 스레드를 방해하지 않고 deferred값이 계산될 때까지, 기다리게 하는 함수
- GlobalScope은 topLevel 코루틴 이고 앱 라이프사이클중 항상 살아있음.
- LifecycleScope은 현재 라이프 사이클에서만 살아있는 코루틴

#### Compose 탄생 이유

- 리스코프 치환 원칙
  - 자식클래스(서브클래스)는 부모클래스(슈퍼클래스)의 역할을 완벽히 수행할 수 있어야 함
  - 상속받은 클래스는 부모클래스가 하는 일을 완벽히 이해를 해야 함
- View
  - 안드로이드 UI 가장 기본클래스
  - View에는 안드로이드가 10년 이상동안 OS가 유지되면서, 다양한 단말들의 예외처리들이 다 포함되어 있음
  - View의 개행수를 찾아보면 31111줄 육박
  - 즉, 커스텀뷰를 만들기 위해서는 31111 라인의 내용을 완벽히 이해해야한다는 애로사항 존재
  - View는 확장이 어려운 클래스라고 판단됨
  - 특정 메소드를 잘못 이해하게 된다면 앱 성능에 안좋은 영향을 미칠 수 있음
  - 기존 체계를 이어가는 형태로는 더 이상은 불가능하다는 판단을 하여 생긴게 Compose
- Compose
  - compose 는 가진 의미 그대로 구성해서 사용 가능
  - 그래서 더 이상 상속이 아니라 내부 컴포넌트를 조합해서 사용할 수 있도록 컴포즈가 나온 것임
    - 상속이 아닌 조합으로 ui 구성

#### HashMap vs LinkedHashMap

- HashMap 은 순서대로 저장되지 않음
- LinkedHashMap 은 순서대로 저장됨 (put한 순서)

#### ARM64-v8a(64), ARMv7, ARMx86 등 ABI(Application binary interface) ?

- 안드로이드 디바이스는 다양한 CPU 를 사용하여 만들고, CPU에서 제공하는 명령셋은 다양
- 대표적인것이 ARMv7 이 있고, 우리가 작성한 코드가 javac에 의해 바이트 코드(.class)로 바뀌고, Dalvik VM(현재는 ART VM) 안에서 JIT 컴파일을 통해 기계어로 번역
- 이때 이 기계어를 해석하고 명령하는데, 이때 CPU 마다 명령을 실행하는 방법이 다르고, 실행 가능한 바이너리 형식, 명령 집합 등이 정의되어 있는 것이 애플리케이션 바이너리 인터페이스(ABI)

#### 안드로이드 빌드 프로세스

- Android asset packaging tool (AAPT) 를 사용하여 리소스(/res 이하 파일들)를 컴파일
  / 이때 R.java 라고 불리는 하나의 클래스로 컴파일
- 두번째로 .java 파일들이 javac 로 부터 .class 파일로 컴파일
- 클래스 파일들은 dx 툴(Android SDK tools 아래 포함)에 의해 달빅 바이트 코드(classes.dex)로 변환
- APKbuilder 에 의해 apk(android packagin key) file 생성
- 현재는 각 디바이스의 해상도, 언어, abi 타입등으로 나눠 들어가 있는 apks 로 제공되어 나중에 디바이스에 필요한 리소스만 가지고, 애플리케이션을 만드는 AAB(android app bundle) 로 사용되기도 함

#### Annotation Retention 설명

- Annotation의 스코프를 제한하는데 사용되고 파라미터에는 3가지 존재
  - SOURCE
    - 컴파일 시에만 유효
    - 빌드된 바이너리에는 미포함 (@Suppress 와 같이 개발 중에만 유효)
  - BINARY
    - 컴파일과 바이너리에도 포함
    - 리플렉션을 통해 접근은 불가능
  - RUNTIME
    - 컴파일과 바이너리에도 포함
    - 리플렉션을 통해 접근도 가능
    - Custom Annotation에 @Retention 표시하지 않는 경우 디폴트 값이 RUNTIME