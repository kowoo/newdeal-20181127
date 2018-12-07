package com.eomcs.lms.servlet;

import java.io.IOException;
import java.util.HashMap;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.context.ApplicationContext;
import com.eomcs.lms.dao.MemberDao;
import com.eomcs.lms.domain.Member;

//Spring IoC 컨테이너가 이 클래스의 인스턴스를 자동 생성하도록 
//클래스에 표시해 둔다.
@WebServlet("/auth/login")
public class LoginServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  MemberDao memberDao;

  public void init() {
    ServletContext sc = this.getServletContext();
    ApplicationContext iocContainer = 
        (ApplicationContext) sc.getAttribute("iocContainer");

    try {
      
      memberDao = iocContainer.getBean(MemberDao.class);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    //forward와 include는 어디로 가야할지 경로를 정해줘야한다.
    //웹 애플리케이션 루트 (서버 입장에서의 경로)
    RequestDispatcher rd = request.getRequestDispatcher("/auth/form.jsp");
    rd.forward(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    try {
      HashMap<String, Object> params = new HashMap<>();
      params.put("email", request.getParameter("email"));
      params.put("password", request.getParameter("password"));
      
      Member member = memberDao.findByEmailPassword(params);
                        //해당 클라이언트를 위한 HttpSession 객체가 있다면 그 객체를 리턴
                        //없다면 새로 만들어서 리턴
      HttpSession session = request.getSession();

      if (member != null) {
        session.setAttribute("loginUser", member);
        response.sendRedirect("../board/list");
      } else {
        session.invalidate();
        response.sendRedirect("login");
      }

    } catch (Exception e) {
      e.printStackTrace();
      throw new ServletException(e);
    }
  }
}








