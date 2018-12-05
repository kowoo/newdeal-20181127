# eomcs-java-project-50

## 작업

### Spring IoC Container 라이브러리 추가

 - 'mvnrepository.com'에서 'spring context'를 검색하여 라이브러리 정보를 알아낸다.
 - build.gradle 파일에 등록
 - '$ gradle eclipse' 실행 (이클립스 설정파일 갱신)
 - 이클립스에서 프로젝트 리프레시.

### Spring IoC 설정

 - AppConfig 클래스 작성
    - 경로 : com.eomcs.lms (App 클래스와 동일)
    - SqlSessionFactory 객체를 생성하는 메서드 추가.
      - Spring IoC Container가 자동으로 객체를 생성할 수 없는 경우
         메서드를 정의하여 직접 객체를 생성한다.
      - DAO나 Command의 경우 내가 정의한 것이므로 Spring IoC Container를 통해
         객체를 자동으로 생성되게 설정할 수 있다.
         하지만, MyBatis 관련 객체는 내가 정의하지 않은 클래스이므로
         Spring IoC Container가 객체를 자동으로 생성하게 설정할 수 없다.
         따라서 MyBatis 관련 클래스는 직접 인스턴스를 생성해야 한다.
    - DAO, Command 클래스에 객체 자동생성 설정
      - 클래스 선언부에 Annotation 추가. (@Component)
      * @Component : 스프링 IoC 컨테이너가 이 클래스의 인스턴스를 자동 생성하도록 표시해주는 것.ㅣ

### Spring IoC Container 준비

 - App.java
    - Spring IoC Container 객체를 준비한다.
    -

### SqlSessionFactory 인스턴스 생성

 - 'App' 클래스에서 MyBatis의 SqlSessionFactory 객체를 준비한다.
 - DAO 객체가 사용할 수 있게 생성자에 주입해준다.

### DAO에 적용