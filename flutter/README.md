#### 플러터 개념

- 구글에서 만들어 오픈소스로 공개한 모바일 SDK (2017년 발표)
- 크로스 플랫폼 모바일 앱 및 다양한 플랫폼을 쉽게 개발할 수 있도록 구글에서 제공하는 무료 오픈소스
- 렌더링 엔진, UI 컴포넌트, 테스트 프레임워크, 도구, 라우터 등 기능을 모두 제공
- 웹, 모바일 환경, PC, Embedded 환경 지원
- SKIA 라는 그래픽 엔진 사용
  - 번역 작업 없이 작성 코드를 그대로 렌더링 => 속도가 네이티브 앱과 비슷 / 다른 플랫폼들에서 일관된 화면 표시 가능
- Material & Cupertino Component, Widget들을 가지고 있음

#### 크로스 플랫폼 (Cross-Platform Software) 설명

- 단일 코드로 둘 이상의 플랫폼에서 동작 가능

#### 다트 언어 사용 이유

- 구글 사 유지 보수 언어
- JIT (Just-in-time) 과 AOT (Ahead-of-time) 컴파일 모두 지원
  - AOT: 다트 코드를 네이티브 코드로 변경
  - JIT: 핫 리로드 지원, 빠른 개발 속도와 반복을 가능하게 하여 생산성 증가
- 객체 지향 언어, 마크업 언어 없이 시각적 사용자 경험을 쉽게 구현 가능
- 자바, 자바스크립트와 유사
- 간결한 문법

#### 플러터 장점 설명

- 기본 제공되는 많은 위젯
- 코드량 감소
- 크로스 플랫폼 개발 가능
- 핫 리로드 기능 제공
- 네이티브 앱과 비슷한 성능
  - IC(중간 코드)와 해석에 의존 X, 기계코드에 직접 내장되어 해석 프로세스와 관련된 성능문제를 제거
- 다양, 유연한 UI 제작 가능

#### 플러터 단점 설명

- 타사 라이브러리 적고 플러터의 일부 위젯은 하나의 플랫폼에서만 동작
- 릴리즈 사이즈
- 다트 언어 (오직 플러터를 위해 숙달시켜야 하는 언어)
- 3D 모델링, Unity 통합 / 게임 엔진이 부족해 대부분의 광고 모바일 플랫폼도 지원하지 않음

#### 빌드 모드 설명

- 개발단계에 따라 3가지 모드로 코드 컴파일 가능
- 종류
  - Debug Mode: Hot Reload 기능을 제공하는 모드
  - Profile Mode: 성능을 분석할 때 사용하는 모드
  - Release Mode: 앱을 최적화 시키고 작은 크기로 만드는 모드

#### 플러터에서 위젯 설명

- 플러터 = 위젯 모음
- 사용자에게 보이는 인터페이스를 결정하는 부품
- 위젯 조합으로 다양한 유저 인터페이스 구현 가능
- 화면에 보이지 않는 부분도 모두 위젯으로 이루어져 있음

#### 위젯 타입 나열

- StatelessWidget
- StatefulWidget

#### Stateful Widget Lifecycle (생명주기) 설명

- 위젯 구축
  - createState()
  - initState(): 단 한번만 호출됨
  - didChangeDependencies()
- Re-Drawing
  - 화면 드로잉 (dirty): 위젯 트리 구축
  - build(): UI 구축
  - 화면 드로잉 (clean): 위젯 트리 구축
  - didUpdateWidget(): 위젯 구성이 변경될 때마다 호출됨
  - setState(): 상태가 변경되었을 때 프레임워크에 상태가 변경 됨을 알림
- 위젯 소멸
  - deactivate()
  - dispose()

#### main()과 runApp() 차이점

- main(): 프로그램 시작점
  - 플러터는 해당 함수 없이 실행 불가능
- runApp(): 앱 위젯 트리의 루트로 사용될 최상위 위젯을 받아 화면에 보여주는 함수

#### 패키지와 플러그인에 대한 설명

- 개발에 필요한 위젯이나 화면 구현을 위해 직접 구현 작업없이 패키지와 플러그인을 사용해서 손쉽게 사용하는 것도 가능
- 패키지: 순수 다트 언어로만 구현된 코드
- 플러그인: 다른 언어가 포함된 코드

#### Key에 대한 설명

- ElementTree가 WidgetTree의 위젯을 식별할 때 사용
- 위젯 트리에서 위젯이 움직일 때마다 현상태를 보존하는 역할
- 로컬 키
  - 위젯 트리에서 특정 레벨에서 구별할 수 있는 키
- 글로벌 키
  - 앱 어디에서든 사용할 수 있는 고유 키

#### Container 클래스 설명

- 여러 다른 위젯을 담아서 크기, 패딩, 배경 등 다양한 설정을 할 수 있는 위젯

#### Container 와 SizedBox 차이점

- 공통: 다른 위젯들을 담을 수 있고 가로, 세로 크기 지정 가능
- SizedBox: 위젯을 담고 가로, 세로 크기 변경 / 배치만 가능
- Container: 위젯을 담고 가로, 세로 크기 변경 / 배치 + 꾸미기 기능

#### Mixins 용도 설명

- 다중상속 지원 X
- 자바에서 클래스, 인터페이스 활용한 유사 다중상속 구현을 하듯이 플러터에서는 Mixins를 사용해서 다중상속 구현이 가능

#### GetX 라이브러리 상태 관리 방식 설명

- 단순 상태 관리
  - 기존의 데이터와 변경되는 데이터가 같은지 확인하지 않음
- 반응형 상태 관리
  - 데이터 변화가 있을 때만 재랜더링 수행
  - 추가 기능 worker
    - Ever
    - Once
    - Interval
    - Debounce

#### Provider 라이브러리 상태 관리 방식 설명

- 상태 변화된 것이 여러 개인 경우 여러개의 Provider를 추가하여 처리 가능
- Provider 는 제공자 / Consumer 는 소비자
- 어떤 데이터를 제공할 때는 Provider로 제공

#### (참고) 앱 기획 과정 관련 정보

- 기획의 방향
  - 제작하고 싶은 서비스를 구체화 시켜나가는 기획 필요
  - 완성까지 속도를 높여주는 기획
- 서비스 기획
  - 문제를 정의하고 정의한 문제를 해결해 나가는 것
  - 대상: 서비스를 만드는 개발자, 기획자 그리고 디자이너 모두에게 해당
- 문제 정의 및 해결 방법
  - 불편함에 집중, 사용성 등에 대해 예민하게 생각
    - Pain Point 찾아내기, Pain Point 기반으로 문제 도출 시작, 좋은 문제를 정의하는 것이 해결 방안보다 중요
  - 최대한 많은 앱 서비스 경험 필요
    - 경험 + 다운로드 수 + 플랫폼(iOS/Android) + 평점 + 구매형태 + 평가 + 앱 이름 + 검색 키워드 + 단점 + 장점 + 특징
    - 스토어 설명에 대한 느낀점
    - 앱 실제 사용 시나리오 (스플래시 -> 권한 -> 온보딩/튜토리얼 -> 로그인 또는 메인)
    - 메뉴 바 또는 바텀 시트 다이얼로그 메뉴 구성 파악
    - UI의 계층 파악 (Depth1 => Depth2 ...)
    - 유저 스토어 리뷰 반응
  - 여러 앱들이 같은 문제를 어떻게 풀었는지에 포커스
    - 유사한 앱들에 대한 경험 테스트 및 기록
    - 같은 상황 또는 문제에 대한 해결법 검토
  - 자신이 첫번째 유저라고 생각하고 접근
    - 유저들이 어디에서 유입되고 어디에서 만족을 느낄 것인지 등이 예상되는 서비스인지 판단
  - 오프라인 행동 관찰
    - 반복적으로 하는 행위가 있다면 이 행동을 앱을 사용한 자동화가 가능할 지에 대해 생각
  - 자주 릴리즈 하는 것이 중요
    - 서비스의 주기능만 집중하여 작은 단위로 노출 필요
    - 최소한의 리소스로 가설 검증 후 개선하는 방향 (핵심 플로우에만 집중)
  - 작은 문제에 집중
    - Ex. 중고거래 중 모든 것을 풀려고 하지 말고 일단 직거래 문제부터 푸는 것

#### 플랫폼 비즈니스 모델

- 공급자 (사업자) 그룹과 사용자 그룹을 서로 연결해주는 서비스
  - 서버 환경 구축 필수

#### 앱 기획 아이디어 도출 과정 설명

- 타겟유저 설정 / 정의
- 앱의 핵심 기능
- 앱의 차별성
- 목표 수립 (유저 목표, 비즈니스 목표)
- 앱 서비스를 한마디로 정의

#### 프로젝트 이름 정하는 방법

- 서비스 이름
  - 앱 이름
  - 웹 이름
  - 보통 브랜딩 디자인으로 결정 / 앱 출시 전, 앱을 거의 다 제작한 시점에 작명
- 프로젝트 이름
  - 개발 프로그램에서 불릴 이름
  - 앱 개발 시작할 때 이름이 결정됨
  - 타이핑 수월하고 발음에 용이한 간단한 영문 이름 채택 (Ex. Dox, Dog, Candy 등)
    - 일명 코드명 같은 느낌

#### 프로젝트 구축

- homebrew / brew install git 명령 실행
- flutter SDK 설치
  - https://www.flutter.dev
  - visit https://docs.flutter.dev/development/tools/sdk/releases?tab=macos
  - download the latest flutter of stable channel.
  - execute export PATH="\$PATH:`pwd`/flutter/bin" on console or Modify bash_profile. (Add export PATH="\$PATH:/Users/admin/flutter/bin to .bash_profile or .zshrc)
  - flutter precache
  - flutter doctor
  - if you encounter this error ---> Flutter - Unable to find bundled Java version.
  - cd /Applications/Android\ Studio.app/Contents/jre
  - [Not Electric Eel] ln -s ../jre jdk
  - [Not Electric Eel] ln -s "/Library/Internet Plug-Ins/JavaAppletPlugin.plugin" jdk
  - [Electric Eel] cd /Applications/Android\ Studio.app/Contents
  - [Electric Eel] ln -s jbr jre
  - 안드로이드 라이센스 동의 에러 발생하면 flutter doctor --android-licenses 명령 실행
  - flutter doctor
- Visual Studio Code 설치
  - Flutter, Flutter Intl, Dart, dart-import
- Xcode 설치
  - open a Simulator 명령으로 시뮬레이터 실행 가능
- Android Studio 설치
  - (참고) Android Platform 종속성을 제공하기 위해 Android Studio의 전체 설치에 의존
- flutter run 명령으로 플러터 앱 실행
- Android 기기에서 USB 설정을 '파일 전송' 모드로 설정
- 참고. 스마트폰 미러링 위한 설치
  - brew install scrcpy
  - brew install --cask android-platform-tools
  - scrcpy (scrcpy -s SERIAL_NUMBER)
- iOS 빌드 시 3가지 버전 관리
  - flutter
  - Xcode
  - Cocoapods
- iOS 는 QuickTime Player 로 화면 미러링
- Flutter 앱을 실제 iOS 기기에 Deploy 하려면 Apple 계정 필요. 또한 Xcode 에서 실제 기기 Deploy 설정 필요. 앱이 Flutter Plugin을 사용하는 경우 써ㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇ드 파티 Cocoapods 의존성 관리도 필요

#### 변수 선언 관련 설명

- var 사용한 변수 선언 시 초기화 된 값 형태에 따라 자동적으로 타입 추론이 이루어짐
- int 형 변수값에 double 값 연산 불가능 (Ex. double test = 23.444, test += 1)
- double 형 변수값에 int 값 연산 가능 (double 형 값들은 int 형 값들보다 범위가 넓음)
- double 형 변수에 int 타입 값이 초기화될 때 double 형 변수는 그 값을 double 형으로 인식
  - Ex. double num1 = 30 <== 30.0
- 4 == 4.0 <== true
- 변수 중복 선언 불가능
- 변수명은 소문자로 시작, 띄어쓰기 불가능, 띄어쓰기가 필요하다면 카멜표기법으로 작성
- List 는 순서가 보장됨 / Set 은 순서 보장 안됨
  - Set[0] 이런 식의 접근이 안되는 이유는 순서 보장 안되는 열거 타입이므로 안됨
  - Set은 인덱스 접근 안됨
  - Set은 중복 허용하지 않음, Ex. 1, 2, 3, 2 ==> 1, 2, 3
  - Set은 리스트보다 접근 속도 빠름 (처리 속도 빠름)
- 맵에서 존재하지 않는 키로 접근했을 때 null 값 출력
- Any 타입에 해당하는 것은 dynamic, Object
- 맵 선언, 초기화 그리고 사용법
  - Ex. Map<String, dynamic> testMap = { 'name': 'Koo' } / testMap['name']
- toList(), toSet()의 결과값은 각각 [ ... ], { ... }
- 타입 추론이 아닌 타입을 명시하는 것이 권장 사항
- ? 유무에 따른 Non-nullable, Nullable 처리
  - 일반적으로 타입을 가진 변수 선언 시 초기화를 하지 않으면 에러 발생, Null을 허용하지 않으므로.

#### Object, dynamic, var 설명

- Object
  - 모든 타입의 공통 부모
  - 다른 타입 대입 가능
- dynamic
  - 컴파일 시간에 오류를 잡아내는 Static Checking을 하지 않음
  - 컴파일 시간에 오류를 잡아내지 않으므로 어떤 값이 들어오는지 정확히 알 때만 사용해야 함
- var
  - 모든 타입이 될 수 있지만 초기화 값에 따라 타입이 정해짐

#### final, const 차이점

- final
  - 한번 값을 대입하면 변경 불가능
  - 런타임에 값이 할당
- const
  - 한번 값을 대입하면 변경 불가능
  - 컴파일 타임에 값이 할당
- 차이점 예
  - DateTime.now()
  - 실행 시에 시간이 결정되므로 final 키워드는 사용가능
  - 실행 시에 시간이 결정되는 기능이므로 const 키워드는 사용 불가능

#### if, switch 설명

- switch가 if 보다 가독성 및 처리 속도가 더 빠름

#### 함수 설명

- 반환타입 + 함수명 + 매개변수 + 실행문 으로 구성
