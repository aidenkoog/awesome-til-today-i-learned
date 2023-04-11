#### React-Native와 ReactJS 차이점

- 리액트 네이티브
  - 페이스북이 모바일 앱 개발의 증가하는 수요를 맞추기 위해 개발한 자바스크립트 프레임워크
  - 자바스크립트 기반 소스
  - JSX 사용, HTML 태그 사용하지 않음
  - 내장된 내비게이션 라이브러리 사용
  - 애니매이션 API 사용
  - 모바일 응용 프로그램 개발 시 사용
- ReactJS
  - JSX 사용하나 HTML 태그를 사용
  - 리액트 라우터 사용
  - CSS 애니매이션 사용
  - 주로 웹 개발 시 사용

#### JSX 설명

- React 에서 사용하는 XML / HTML 템플릿 구문

#### React Native 구성 내용

- Native Threads
  - iOS에서 Objective-C/Swift 담당, Android에서는 Java/Kotlin 담당하는 곳으로 UI를 생성하는 부분
- JS Thread
  - JS 코드를 통해 비즈니스 로직들이 실행되고 뷰를 언제, 어떻게 표시할 지 실행되는 부분
  - Native Threads는 JS Thread와 직접 상호작용 하지 않음
    - 앱 구현을 위해 이 2개를 소통하기 위해서는 Bridge가 필요
    - 각 부분에서 전달되는 정보는 JSON Object 형태로 변환되어서 전달됨
    - Client => Main Thread / Server => JS Thread의 구조
    - Bridge에서 병목현상이 가장 많이 생김
    - 좋은 성능을 위해서는 이 Bridge를 이용하는 횟수를 최소한으로 해야함

#### React Native 작동원리

- 앱 빌드 시 전체 로직을 갖고 있는 JS Bundle 생성
- Bundle은 각 iOS / Android 플랫폼에 삽입
- 상세 실행 과정
  - 1. 앱이 시작되면 Native Threads 실행
  - 2. Native Threads는 JS Thread 실행시키고 JS Bundle을 로드
  - 3. JS Thread 실행되면서 Virtual DOM을 생성
  - 4. Diffing 알고리즘을 통해 변경사항을 Bridge 경유하여 Shadow Thread로 전달
  - 5. Shadow Thread는 변경사항 메세지를 통해 화면 레이아웃 계산
  - 6. 계산이 끝난 레이아웃 파라미터나 객체를 Native Threads로 전달
  - 7. Native Threads는 UI를 화면에 표시
  - 8. 사용자가 화면에 입력한 UI 이벤트 정보들이 Bridge 경유하여 JS Thread로 보내짐
  - 9. UI 이벤트 메세지를 활용하여 JS Thread에서 비즈니스 로직들이 실행되고 다시 Virtual DOM 생성하며 변경사항을 다시 Bridge 경유하여 Shadow Thread로 전달
  - 10. 5, 6, 7, 8, 9 과정 반복
