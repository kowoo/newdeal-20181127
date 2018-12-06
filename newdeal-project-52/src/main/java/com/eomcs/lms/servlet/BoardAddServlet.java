package com.eomcs.lms.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.context.ApplicationContext;
import com.eomcs.lms.dao.BoardDao;
import com.eomcs.lms.dao.LessonDao;
import com.eomcs.lms.domain.Board;
import com.eomcs.lms.domain.Member;

@WebServlet("/board/add")
public class BoardAddServlet extends HttpServlet{
  private static final long serialVersionUID = 1L;
  BoardDao boardDao;
  LessonDao lessonDao;

  public void init() throws ServletException {
    ServletContext sc = this.getServletContext();
    ApplicationContext iocContainer = 
        (ApplicationContext) sc.getAttribute("iocContainer");

    try {
      this.boardDao = iocContainer.getBean(BoardDao.class);
      this.lessonDao = iocContainer.getBean(LessonDao.class);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    
    HttpSession session = request.getSession();
    Member loginUser = (Member) session.getAttribute("loginUser");
    
    List<Map<String, Object>> lessons = 
        lessonDao.findByParticipantNo(loginUser.getNo());
    
    request.setAttribute("lessons", lessons);
    
                              //forward와 include는 어디로 가야할지 경로를 정해줘야한다.
                              //웹 애플리케이션 루트 (서버 입장에서의 경로)
    RequestDispatcher rd = request.getRequestDispatcher("/board/form.jsp");
    rd.forward(request, response);
  }
  
  @Override
  protected void doPost(
      HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {
    
    try {
      Board board = new Board();
      board.setContents(request.getParameter("contents"));
      
      Member loginUser = (Member) request.getSession().getAttribute("loginUser");
      
      board.setWriterNo(loginUser.getNo());
      board.setLessonNo(Integer.parseInt(
          request.getParameter("lessonNo")));
      boardDao.insert(board);

        //웹 브라우저에 던져주면 웹 브라우저가 현재 위치를 계산해서 요청한다.
        //웹 브라우저 루트 (브라우저 입장에서의 경로)
      response.sendRedirect("list");
      
    } catch (Exception e) {
      e.printStackTrace();
      throw new ServletException(e);
    }
  }
}








