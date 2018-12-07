package com.eomcs.lms.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LogoutController {

  public LogoutController() {
  }

  @RequestMapping("/auth/logout")
  public String logout(
      HttpServletRequest request, HttpServletResponse response)
          throws Exception {
    response.setContentType("text/html;charset=UTF-8");
    HttpSession session = request.getSession();
    session.invalidate();
    return "redirect:../board/list";

  }
}








