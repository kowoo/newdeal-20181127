package com.eomcs.lms.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 프론트 컨트롤러(DispatcherServlet)가 페이지 컨트롤러를 실행할 때 호출하는 메서드 규칙을 정의한 클래스.
// 장점 : 코드가 간결해짐!
public interface PageController {
  String execute(
      HttpServletRequest request, 
      HttpServletResponse response) throws Exception;
}
