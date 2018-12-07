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
public class BoardUpdateController {

  BoardDao boardDao;

  public BoardUpdateController(BoardDao boardDao) {
    this.boardDao = boardDao;
  }

  @RequestMapping("/board/update")
  public String update(
      HttpServletRequest request, HttpServletResponse response)
      throws Exception {
      Board board = new Board();
      board.setNo(Integer.parseInt(request.getParameter("no")));
      board.setContents(request.getParameter("contents"));

      boardDao.update(board);
      response.setCharacterEncoding("text/html;charset=UTF-8");
      
      return "redirect:list";
  }
}
