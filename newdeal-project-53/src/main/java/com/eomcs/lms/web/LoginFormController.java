package com.eomcs.lms.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

//Spring IoC 컨테이너가 이 클래스의 인스턴스를 자동 생성하도록 
//클래스에 표시해 둔다.
@Component("/auth/form")
public class LoginFormController implements PageController {

  public LoginFormController() {
  }

  @Override
  public String execute(
      HttpServletRequest request, HttpServletResponse response)
          throws Exception {
    response.setContentType("text/html;charset=UTF-8");
    return "/auth/form.jsp";
  }
}








