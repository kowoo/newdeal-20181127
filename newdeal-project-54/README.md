# eomcs-java-project-54

 ## 작업

 ### Spring WebMVC 라이브러리 가져오기
  - mvnrepository.com 에서 'spring-webmvc' 검색 후 라이브러리 등록
  - 기존 'spring-context' 라이브러리를 제거한다.
   - context는 webmvc 라이브러리에 의존하기 때문에 webmvc를 등록하면 함께 가져온다.
  - 이클립스 적용

 ### Spring WebMVC의 프론트 컨트롤러 설정하기
  - MyWebApplicationInitInitializer.java
    - WebApplicationInitInitializer 구현체를 만든다.
    - Spring IoC Container와 DisPatcherServlet을 준비한다.

 ### 기존의 DispatcherServlet을 제거한다.
  - Spring WebMVC의 DispatcherServlet을 사용하기 때문에 기존 클래스 제거.

 ### 기존의 ContextLoaderListener를 제거한다.
   - Spring에서 제공한 DispatcherServlet은 자체적으로
    Spring IoC 컨테이너를 다루기 때문에 더 이상 필요가 없다.
 
 ### PageController 인터페이스 제거
   - Spring의 DispatcherServlet이 페이지 컨트롤러를 실행할 때는 다른 규칙에 따라 실행한다.
   - 따라서 기존에 우리가 만든 규칙은 제거한다.

 ### 기존의 PageController를 변경한다.
   - Spring의 DispatcherServlet에 맞춰서 페이지 컨트롤러를 변경한다.