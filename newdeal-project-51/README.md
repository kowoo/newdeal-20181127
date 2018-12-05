# eomcs-java-project-50

## 작업

### MyBatis-Spring 연동 라이브러리 추가

 - 'mvnrepository.com'에서 'mybatis-spring'를 검색하여 라이브러리 정보를 알아낸다.
 - build.gradle 파일에 등록
 - '$ gradle eclipse' 실행 (이클립스 설정파일 갱신)
 - 이클립스에서 프로젝트 리프레시.

### SqlSessionFactory 객체 생성

 - AppConfig 클래스 작성
    - 경로 : com.eomcs.lms (App 클래스와 동일)
    - SqlSessionFactory 객체를 생성하는 메서드 변경
    - 'mybatis.org'에서 github project -> spring -> See the docs -> SqlSessionFactoryBean
    - SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
      SqlSessionFactory sessionFactory = factoryBean.getObject(); 를
      AppConfig 클래스의 sqlSessionFactory 메서드에 추가 후 기존 방식 삭제
    - spring-javaconfig-demos AppConfig 검색
      (  https://github.com/gordonad/spring-javaconfig-demos/blob/master/02-enable-tx/src/main/java/com/gordondickens/javaconfig/AppConfig.java
      )
    - DataSource 메서드 추가
       - docs.spring.io -> data access에서 dataSource 예제 가져오기.
    - TransactionManager 객체를 생성하는 메서드 추가
    
   가져오기

    - apache common-dbcp 라이브러리 추가
       - DataSource 구현체(DB 커넥션풀 객체)
       - 'mvnrepository.com'에서 'common-dbcp'를 검색하여 라이브러리 정보를 알아낸다.
       - build.gradle 파일에 등록
       - '$ gradle eclipse' 실행 (이클립스 설정파일 갱신)
       - 이클립스에서 프로젝트 리프레시.

      




### Spring IoC Container 준비

 - 'src/main/resources/com/eomcs/lms/mapper' 디렉토리에 파일을 둔다.
 - BoardMapper.xml 파일을 작성한다.
    - 'BoardDao' 클래스에 있는 SQL을 옮긴다.
    - 작성 방식은 MyBatis를 참고한다.

### SqlSessionFactory 인스턴스 생성

 - 'App' 클래스에서 MyBatis의 SqlSessionFactory 객체를 준비한다.
 - DAO 객체가 사용할 수 있게 생성자에 주입해준다.

### DAO에 적용