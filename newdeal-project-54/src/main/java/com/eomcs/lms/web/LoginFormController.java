package com.eomcs.lms.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//Spring IoC 컨테이너가 이 클래스의 인스턴스를 자동 생성하도록 
//클래스에 표시해 둔다.
@Controller
public class LoginFormController {

  @RequestMapping("/auth/form")
  public String form(
      HttpServletRequest request, HttpServletResponse response)
          throws Exception {
    response.setContentType("text/html;charset=UTF-8");
    return "/auth/form.jsp";
  }
}








