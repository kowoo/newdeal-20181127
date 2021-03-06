package com.eomcs.lms.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import com.eomcs.lms.dao.BoardDao;
import com.eomcs.lms.domain.Board;

//서블릿을 만들었으면 톰캣 서버에 알려줘야한다.
// => 서블릿에 URL을 부여한다.
// => URL은 항상 '/'로 시작해야 한다.
// 추가했으면 톰캣 서버 재시작!

// 한 번 톰캣 서버에 서블릿을 추가한 후 수정시, 일정 시간 경과후 반영된다.
// 단, 오토 리로딩이 체크되어야 가능함.
//@WebServlet("/board/list")
public class OldBoardListServlet extends HttpServlet{
  private static final long serialVersionUID = 1L;
  //경고 방지용

  BoardDao boardDao;
  
  @Override
  public void init() throws ServletException {
    // 이 메서드는 서블릿 객체가 최초로 생설될 때
    // 생성자 다음으로 바로 호출 됨!
    // 원래는 init(ServletConfig)가 먼저 호출되고 init(ServletConfig)가 이 init()를 호출한다.
    ServletContext sc = this.getServletContext();
    ApplicationContext iocContainer = 
        (ApplicationContext) sc.getAttribute("iocContainer");
    try {
      boardDao = iocContainer.getBean(BoardDao.class);
      
    }catch (Exception e) {
      System.out.println("boardDao 고장");
    }
  }

  public ServletConfig getServletConfig() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void doGet(HttpServletRequest req, HttpServletResponse res)
      throws ServletException, IOException {
    
    res.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = res.getWriter();
    out.println("게시물 목록");
    
    // BoardDao 객체를 꺼내기 위해 IoC 컨테이너를 꺼낸다.
    // 서블릿 컨테이너는 웹 애플리케이션마다 1개다!
    // 서블릿 당 1개가 아님
    
    try {
      List<Board> list = boardDao.findAll();
      
      for (Board board : list) {
        out.printf("%3d, %-20s, %s, %d\n", 
            board.getNo(), 
            board.getContents(), 
            board.getCreatedDate(), 
            board.getViewCount());
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    
  }

}
