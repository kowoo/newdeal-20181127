# eomcs-java-project-52

## 작업

### 웹 프로젝트 관련 빌드 명령을 사용할 수 있도록 준비하기
  - build.gradle
    - 'eclipse' -> 'eclipse-wtp' (weptool plugin의 약자)로 플러그인 변경.
    - 웹 애플리케이션 배치 파일(.war)을 만들 'war' 플러그인 추가.
    - 단독으로 실행할 수 없기 때문에 기존 'application' 플러그인 제거.
    - 'application' 플러그인과 관련된 변수 'mainClassName' 제거.

### 서블릿 애플리케이션 개발에 사용한 라이브러리 추가하기
 - 'mvnrepository.com'에서 'servlet-api'를 검색하여 라이브러리 정보를 알아낸다.
 - build.gradle 파일에 등록
    - 해당 라이브러리는 provided에서 providedCompile로 변경해야한다.
 - '$ gradle eclipse' 실행 (이클립스 설정파일 갱신)
 - 이클립스에서 프로젝트 리프레시.

### 이클립스 웹 프로젝트 설정하기
 - src/main/webapp
    - HTML, CSS, JavaScript, PNG, JPEG, JSP 등 웹 자원을 두는 디렉토리 생성하기
 - index.html
    - 웹 애플리케이션에 대해 간단히 소개하는 웹 페이지를 만든다.
 - '$ gradle eclipse' 실행 (이클립스 설정파일 갱신)
 - 이클립스에서 프로젝트 리프레시.
    - src/main/webapp 폴더가 웹 프로젝트가 정식으로 등록된다.

### 이클립스에 톰캣 서버 등록
 - 환경설정
    - 톰캣 서버를 등록한다. (서버 실행환경에 톰캣 추가)
 - 웹 애플리케이션 테스트 환경 설정
    - 'Servers' 뷰에 톰캣 테스트 환경을 추가한다.

### JSTL 환경 구축
 - JSTL 구현 라이브러리를 가져온다.
    - 'mvnrepository.com'에서 'jstl'를 검색하여 라이브러리 정보를 알아낸다.
    - build.gradle 파일에 등록
    - 라이브러리를 잘 가져왔는지 체크하려면 리소스 폴더 안의 해당 .jar 밑에 클래시스 같은게 없어야한다.
    - jstl은 폴더를 확인해야한다. javax., org., meta 3개 패키지(혹은 폴더)가 있어야함.
    - jstl core를 검색 후 taglib을 가져옴.

### ????
 - 