package com.eomcs.lms.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Component;

@Component("/auth/logout")
public class LogoutController implements PageController {

  public LogoutController() {
  }

  @Override
  public String execute(
      HttpServletRequest request, HttpServletResponse response)
          throws Exception {
    response.setContentType("text/html;charset=UTF-8");
    HttpSession session = request.getSession();
    session.invalidate();
    return "redirect:../board/list";

  }
}








