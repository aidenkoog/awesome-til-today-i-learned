#### 디자인 패턴 (Design Pattern) 개념

- 소프트웨어 공학의 소프트웨어 설계에서 공통으로 발생하는 문제에 대해 자주 쓰이는 설계 방법을 정리한 패턴
- 개발 효율성, 유지보수성 그리고 운용성이 높아지고 프로그램 최적화에 도움

#### 디자인 패턴 유형 설명

- 목적
  - 생성: 객체 인스턴스 생성하는 패턴
    - Builder
    - Prototype
    - Factory Method
    - Abstract Method
    - Singleton
  - 구조: 클래스와 객체를 더 큰 구조로 만들 수 있게 구성을 사용하는 패턴
    - Bridge
    - Decorator
    - Facade
    - Flyweight
    - Proxy
    - Composite
    - Adapter
  - 행위: 클래스와 객체들이 상호작용하는 방법과 역할을 분담하는 방법을 다루는 패턴
    - Interpreter
    - Template Method
    - Chain of Responsibility
    - Command
      - 특정 기능 / 요청들을 캡슐화 시키는 패턴
    - Iterator
    - Mediator
    - Memento
    - Observer
    - State
    - Strategy
    - Visitor
- 범위
  - 클래스
  - 객체

#### Observer 패턴 설명

- 어떤 이벤트가 일어나는 것을 감시하여 특정 이벤트 발생 시 어떠한 동작을 즉각 수행하게 해줌
- 다른 객체의 상태 변화를 별도의 함수 호출 없이 즉각적으로 알 수 있어 효율적인 프로그래밍 가능
