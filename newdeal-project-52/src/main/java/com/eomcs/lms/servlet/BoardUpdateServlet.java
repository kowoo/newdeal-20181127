package com.eomcs.lms.servlet;

import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import com.eomcs.lms.dao.BoardDao;
import com.eomcs.lms.domain.Board;

//Spring IoC 컨테이너가 이 클래스의 인스턴스를 자동 생성하도록 
//클래스에 표시해 둔다.
@WebServlet("/board/update")
public class BoardUpdateServlet extends HttpServlet{
  private static final long serialVersionUID = 1L;
  BoardDao boardDao;

  @Override
  public void init() throws ServletException {
    ServletContext sc = this.getServletContext();
    ApplicationContext iocContainer = (ApplicationContext) sc.getAttribute("iocContainer");
    try {
      boardDao = iocContainer.getBean(BoardDao.class);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public void doGet(
      HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {

    // POST 요청으로 들어온 데이터는 UTF-8로 인코딩 되어있다.
    // 하지만 request.getParameter()의 리턴 값은 Unicode(2byte)이다.
    // 즉, UTF-8을 JVM이 다루는 Unicode로 변환한 후에 리턴하는 것이다.
    // 문제는 클라이언트가 보낸 데이터가 UTF-8로 되어 있다고 알려주지 않으면
    // getParameter()는 클라이언트가 보낸 데이터가 ISO-8859-1이라고 착각한다.
    // 즉, 영어라고 판단하고 영어를 Unicode로 바꾸게 된다.
    // 그래서 UTF-8로 인코딩 된 한글 데이터가 Unicode로 바뀔 때 깨지는 현상이 발생하게 된다.
    // 이 방법을 해결하려면
    // Get Parameter()를 '최초'로 호출하기 전에
    // 클라이언트가 보낸 데이터가 UTF-8로 되어있다고 알려줘야 한다.
    request.setCharacterEncoding("UTF-8");
    
    try {
      Board board = new Board();
      board.setNo(Integer.parseInt(request.getParameter("no")));
      board.setContents(request.getParameter("contents"));

      boardDao.update(board);

      //데이터를 변경한 후 웹 브라우저에게 url을 다시 요청하라고 응답한다.
      //jsp는 인클루드나 포워드처럼 서버측에서 하는거지 클라이언트는 jsp를 요청해선 안된다.
      //상대경로이므로 (현재위치) list만 붙여도 list를 불러옴.
      response.sendRedirect("list");

    } catch (Exception e) {
      e.printStackTrace();
      throw new ServletException(e);
    }
  }
}
