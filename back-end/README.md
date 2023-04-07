#### 백엔드 개념

- 사용자가 볼 수 없는 영역, 데이터베이스나 서버 관리하는 것 의미
- 주로 웹사이트의 서버 관리 / 개발 업무, 부가적으로 DB와 OS 관리

#### 스프링 간략 개념

- 자바 백엔드 개발에 필요한 프레임워크
- 엔터프라이즈용 자바 애플리케이션 개발을 편하게 할 수 있게 해주는 오픈소스 경량급 애플리케이션 프레임워크
- [POJO] 프로그래밍 지향
  - POJO: Plain Old Java Object, 순수 자바만을 통해서 생성한 객체, 자바 / 자바 스펙에 정의된 기술만을 사용
- [IoC] / [DI]
  - Inversion of Control / Dependency Injection
  - 애플리케이션 로직 외부에서 누군가 사용할 객체를 별도로 설정 가능
  - IoC: 개발자가 아닌 스프링이 누군가가 사용할 객체를 생성하여 의존 관계를 맺어주는 것
  - DI:
    - 객체를 사용할 부분에 주입해주는 것
    - 객체 간의 의존성을 사용자가 아닌 스프링 컨테이너가 빈 설정 정보를 바탕으로 자동으로 해주는 것
- [AOP]
  - Aspect Oriented Programming, 관심 지향 프로그래밍
  - 참고.
    - 앱 개발 시 구현해야 되는 기능: 공통 관심 / 핵심 관심 사항
    - 핵심 관심 사항: Ex. 메뉴 등록, 주문, 주문 변경
    - 공통 관심 사항: Ex. 로깅, 보안 등
  - 코드의 중복 문제를 해결하기 위한 프로그래밍
  - 애플리케이션 전반에 걸쳐 적용되는 공통 기능을 비즈니스 로직으로 분리해내는 것
- [PSA]
  - Portable Service Abstraction, 일관된 서비스 추상화
  - DBMS 변경에 따른 공수 절약을 위하여 스프링은 데이터베이스 서비스를 추상화한 인터페이스를 제공
  - 참고. JDBC
    - Java DataBase Connectivity
    - 자바를 사용하여 데이터베이스에 접근하는 방법을 규정한 인터페이스를 제공
    - 각 DB 를 만든 회사들은 자기들의 데이터베이스에 접근하는 드라이버를 자바 코드 형태로 배포하는데 이 드라이버에 해당하는 자바 코드의 클래스가 JDBC를 구현하고 있음 (규약)
  - 특정 기술과 관련된 서비스를 추상화하여 일관된 방식으로 사용될 수 있도록 한 것

#### 스프링 동작 방법

- DispatcherServlet이 브라우저로부터 요청을 받음
- DispatcherServlet은 요청된 URL을 HandlerMapping 객체에 넘기고, 호출해야 할 Controller 메소드(핸들러) 정보를 수집
- HandlerMapping은 DispatcherServlet으로 부터 전달된 URL을 바탕으로 HandlerAdapter 객체를 포함하는 HandlerExecutionChain 객체를 생성
- DispatcherServlet이 HandlerExecutionChain 객체로부터 HandlerAdapter 객체를 가져와서 해당 메소드를 실행
- Controller 객체는 비즈니스 로직 처리
  - Controller는 Handler Adapter 에 의해 실행됨
- 결과를 바탕으로 뷰(JSP)에 전달할 객체를 Model 객체에 저장하고 DispatcherServlet에게 View 이름을 반환
- View 이름 + Header 정보(accept 등)을 View Resolver 에게 전달하여 View 객체를 얻음
- DispatcherServlet은 View 객체에 화면 표시를 의뢰
- View 객체는 해당하는 뷰(JSP, Thymeleaf)를 호출 / 뷰(JSP, Thymeleaf)는 Model 객체에서 화면 표시에 필요한 객체를 가져와 화면 표시를 처리
  - JSP의 경우 JstlView 객체 생성되고 JstlView 객체가 "xxx.jsp"에 포워딩하여 결과를 표시 (JSP 객체를 생성하는 것이 아님)

#### DispatcherServlet 개념

- 규격화된 코드 작성 가능, 개발 시간 줄여줌
- Front Controller 담당
- Servlet / JSP에서 사용자 요청이 발생하면 이 요청 정보를 해석하고, 개발자가 만든 코드를 동작시키는 첫 번째 서블릿
- 모든 HTTP 요청을 받아들여서 다른 객체들 사이의 흐름 제어
- 스프링 MVC 프로젝트 설정에서 가장 최우선 적으로 해야 하는 일은 DispatcherServlet 클래스를 Spring MVC에서 재정의한 클래스로 설정하는 일

#### Servlet 개념

- 웹 요청 / 응답의 흐름을 간단한 메소드 호출만으로 체계적으로 다룰 수 있게 해주는 기술
- 자바 클래스로 웹 앱을 작성한 뒤 이후 웹 서버 안에 있는 웹 컨테이너에서 이것을 실행하고, 웹 컨테이너에서는 서블릿 인스턴스를 생성 후 서버에서 실행되다가 웹 브라우저에서 서버에 요청을 하면 요청에 맞는 동작을 수행하고 웹 브라우저에 HTTP형식으로 응답
- 주요 특징
  - 클라이언트의 요청에 대해 동적으로 작동하는 웹 애플리케이션 컴포넌트
  - HTML 이용하여 응답
  - 자바 스레드 이용한 동작
  - MVC 패턴에서의 컨트롤러로 이용
  - HTTP 프로토콜 서비스를 지원하는 javax.servlet.http.HttpServlet 클래스 상속
  - UDP보다 속도 느림
  - HTML 변경 시 Servlet을 재 컴파일해야 하는 단점 존재

#### Servlet Container 설명

- 서블릿을 담고 관리하는 컨테이너
- 클라이언트에서 요청 시 컨테이너는 HttpServletRequest, HttpServletResponse 두 객체를 생성하고 POST / GET 여부에 따라 동적인 페이지를 생성하여 응답을 보냄
- HttpServletRequest
  - HTTP 프로토콜의 요청 정보를 서블릿에게 전달하기 위한 목적으로 사용
  - 헤더 / 파라미터 / 쿠키 / URI / URL 등의 정보를 읽어 들이는 메소드와 Body의 스트림을 읽어 들이는 메소드 존재
- HttpServletResponse
  - WAS가 클라이언트에게 응답을 보내기 위한 객체를 생성하여 서블릿에게 전달하고 이 객체를 활용하여 content type / 응답 코드 / 응답 메세지 등을 전송
- 주요 기능
  - 생명주기 관리
  - 통신 지원 (웹 서버와 소켓 생성하여 통신 수행)
  - 멀티스레딩 관리 (요청 들어오면 스레드 생성하여 작업 수행 / 한번 메모리에 올라간 스레드는 다시 생성할 필요 없으므로 메모리 관리에 효율적)
  - 선언적인 보안관리 (보안 관련 메소드를 자바 또는 서블릿 내에 작성 불필요 / 통상적으로 XML 배포 서술자에 기록)
- 동작 과정
  - Servlet Request / Response 객체 생성
  - 설정 파일 참고하여 매핑할 서블릿 확인
  - 해당 서블릿 인스턴스 존재 유무 파악 후 없으면 init() 호출
  - Servlet Container에 스레드를 생성하고 서비스 실행
  - 응답 처리 완료 후 destroy() 메소드 실행하여 Request / Response 객체 소멸 시킴

#### 스프링 부트 간략 개념

- 기존 스프링 기술의 복잡성을 줄인 프레임워크
- 스프링으로 애플리케이션을 만들 때 필요한 설정을 간편하게 처리해주는 별도의 프레임워크
- 자체적인 웹 서버 내장 => 빠르고 간편한 배포 진행 가능
- 독립적으로 실행 가능한 Jar 파일로 프로젝트 빌드 가능 => 클라우스 / 도커 같은 가상화 환경에 빠른 배포 가능

#### JPA 설명

- Java Persitence API
- 자바 진영에서 ORM (Object-Relational Mapping) 기술 표준으로 사용되는 인터페이스 모음
- 실제 구현이 아닌, 구현된 클래스와 매핑을 해주기 위해 사용되는 프레임워크
  - JPA를 구현한 오픈소스: Hibernate

#### ORM

- Object-Relational Mapping
- 어플리케이션 클래스와 RDB (Relational DataBase)의 테이블을 매핑 (연결)한다는 의미
- 어플리케이션 객체를 RDB 테이블에 자동으로 영속화
- 장점
  - SQL 문이 아닌 메소드를 통해 DB 조작 가능 => 객체 모델 이용한 비즈니스 로직 구성에만 집중 가능
  - 코드 가독성
  - 객체 지향적인 코드 생산 가능
  - 데이터베이스 변경에 유연함
- 단점
  - 프로젝트 규모로 인해 설계가 잘못된 경우 => 속도 저하 / 일관성 해치는 문제점 발생 가능성
  - 러닝커브 높음
  - 속도를 위해 SQL을 사용해야 될 경우 존재
    - 복잡하고 무거운 쿼리는 속도를 위해 별도의 튜닝이 필요

#### WAS와 WS 차이

- WAS (Web Application Server, 웹 어플리케이션 서버)
  - 비즈니스 로직 삽입 가능
  - Tomcat, PHP, ASP, .Net 등
- WS (Web Server, 웹 서버)
  - 비즈니스 로직 삽입 불가능
  - Nginx, Apache 등

#### 많은 트래픽 발생 시 대처 방법 설명

- 스케일 업 (Scale Up): 서버에 CPU나 RAM 등을 추가하여 서버의 하드웨어 스펙을 향상시키는 방법
- 스케일 아웃 (Scale Out): 서버를 여러 대 추가하여 시스템을 증가시키는 방법
