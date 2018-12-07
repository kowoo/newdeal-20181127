# eomcs-java-project-53

 ## 작업

 ### 프론트 컨트롤러를 만든다.
  - DispatcherServlet.java

 ### 기존의 서블릿을 페이지 컨트롤러로 만든다.
  - PageController.java
   - DispatcherServlet이 페이지 컨트롤러에 대해 호출하는 규칙 정의.

  - XxxServlet ==> XxxController 변경
   - 기존의 서블릿 클래스를 PageController 구현체로 변경한다.
  
  - x.jsp
   - 변경 사항에 맞춰 링크를 수정한다.

#### 방-식
 - docs.spring 공식 문서에서 Web Servlet 클릭
 (경로: https://docs.spring.io/spring/docs/5.1.3.RELEASE/spring-framework-reference/web.html#spring-web)
 - 디스패처 서블릿(프론트 컨트롤러)과 컨트롤러(페이지 컨트롤러)로 분리.
