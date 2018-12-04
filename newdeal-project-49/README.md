# eomcs-java-project-49

## 작업

### MyBatis 라이브러리 추가

 - 'mvnrepository.com'에서 'mybatis'를 검색하여 라이브러리 정보를 알아낸다.
 - build.gradle 파일에 등록
 - '$ gradle eclipse' 실행 (이클립스 설정파일 갱신)
 - 이클립스에서 프로젝트 리프레시.

### MyBatis 설정 파일 추가

 - mybatis.org 사이트의 문서를 참고하여 'mybatis-config.xml' 파일을 작성한다.
    -mybatis.org -> Github project -> mybatis-3 -> see the docs
 - 'src/main/resources/com/eomcs/lms/conf' 디렉토리에 파일을 둔다.
 - jdbc.properties 파일을 작성한다.
    - DBMS 연결 정보를 둔다.
    - MyBatis 설정 파일에서 참고한다.
 - 'src/main/resources' 폴더를 추가한 후 자바 소스 폴더로 등록해야 한다. (== gradle eclipse)
 - 이클립스에서 프로젝트 리프레시.

### SQL 분리

 - 'src/main/resources/com/eomcs/lms/mapper' 디렉토리에 파일을 둔다.
 - BoardMapper.xml 파일을 작성한다.
    - 'BoardDao' 클래스에 있는 SQL을 옮긴다.
    - 작성 방식은 MyBatis를 참고한다.

### SqlSessionFactory 인스턴스 생성

 - 'App' 클래스에서 MyBatis의 SqlSessionFactory 객체를 준비한다.
 - DAO 객체가 사용할 수 있게 생성자에 주입해준다.

### DAO에 적용