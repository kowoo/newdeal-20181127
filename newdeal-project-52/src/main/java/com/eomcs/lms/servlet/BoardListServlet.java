package com.eomcs.lms.servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import com.eomcs.lms.dao.BoardDao;
import com.eomcs.lms.domain.Board;

// 서블릿을 만들었으면 톰캣 서버에 알려줘야 한다.
// => 서블릿에 URL을 부여한다.
// => URL은 항상 '/'로 시작해야 한다.
// => 서블릿을 추가했으면 톰캣 서버를 재시작해야 사용할 수 있다.
// => 한 번 톰캣 서버에 서블릿을 추가한 후 서블릿을 변경한다면
//    일정 시간이 지난 후에 자동으로 해당 서블릿을 재적재한다.
//    즉 서버를 재시작할 필요가 없다.
@WebServlet("/board/list")
public class BoardListServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  BoardDao boardDao;

  // 이런 녀석을 남겨두면 터진다.
  //  public ServletConfig getServletConfig() {
  //    // TODO Auto-generated method stub
  //    return null;
  //  }

  public void init() throws ServletException {
    // 이 메서드는 서블릿 객체가 최초로 생성될 때 생성자 다음에 
    // 바로 호출된다.
    // => 원래는 init(ServletConfig)가 먼저 호출되고,
    //    init(ServletConfig)가 이 init()를 호출한다.
    // 
    // BoardDao 객체를 꺼내기 위해 먼저 IoC 컨테이너를 꺼낸다.
    ServletContext sc = this.getServletContext();
    ApplicationContext iocContainer = 
        (ApplicationContext) sc.getAttribute("iocContainer");

    try {
      boardDao = iocContainer.getBean(BoardDao.class);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public void doGet(
      HttpServletRequest req, HttpServletResponse res)
          throws ServletException, IOException {
    
                            //plain 부분이 MIME(Multi-purpose Mail Extension) 타입이다.
    //res.setContentType("text/plain;charset=UTF-8");
    try {
      List<Board> list = boardDao.findAll();
      
      //게시물 목록을 JSP가 사용할 수 있도록 보관소에 저장한다.
      req.setAttribute("list", list);
      res.setContentType("text/html;charset=UTF-8");
      
      //JSP로 실행을 위임한다.
      RequestDispatcher rd = req.getRequestDispatcher("/board/list.jsp");
      //contentType은 include하는 쪽에서 지정해야 한다.
      //include를 사용하면 jsp에 실행을 위임한 후 다시 여기로 돌아온다.
      //forward를 하면 실행이후 종료.
      rd.include(req, res);
      
    } catch (Exception e) {
      e.printStackTrace();
      throw new ServletException(e);
    }
  }
} 