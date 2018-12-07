package com.eomcs.lms.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.eomcs.lms.dao.BoardDao;
import com.eomcs.lms.domain.Board;

//Spring IoC 컨테이너가 이 클래스의 인스턴스를 자동 생성하도록 
//클래스에 표시해 둔다.
@Controller
public class BoardDetailController {

  BoardDao boardDao;

  public BoardDetailController(BoardDao boardDao) {
    this.boardDao = boardDao;
  }
  @RequestMapping("/board/detail")
  public String detail(
      HttpServletRequest request, HttpServletResponse response)
      throws Exception {

    int no = Integer.parseInt(request.getParameter("no"));
    System.out.println(no);
    Board board = boardDao.findByNo(no);
    System.out.println(board);

    request.setAttribute("board", board);
    response.setContentType("text/html;charset=UTF-8");

    return "/board/detail.jsp";
  }

}
