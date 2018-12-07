package com.eomcs.lms.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.eomcs.lms.dao.BoardDao;

//Spring IoC 컨테이너가 이 클래스의 인스턴스를 자동 생성하도록 
//클래스에 표시해 둔다.

//웹 서블릿을 붙이면 서블릿 컨테이너가 관리하겠지?
@Controller
public class BoardDeleteController {

  BoardDao boardDao;

  public BoardDeleteController(BoardDao boardDao) {
    this.boardDao = boardDao;
  }

  @RequestMapping("/board/delete")
  public String delete(
      HttpServletRequest request, HttpServletResponse response)
          throws Exception {
    int no = Integer.parseInt(request.getParameter("no"));
    request.setAttribute("count", boardDao.delete(no));
    response.setContentType("text/html;charSet=UTF-8");

    request.getRequestDispatcher("/board/delete.jsp");
    return "/board/delete.jsp";


  }
}
