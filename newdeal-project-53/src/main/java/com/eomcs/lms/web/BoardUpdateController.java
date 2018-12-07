package com.eomcs.lms.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import com.eomcs.lms.dao.BoardDao;
import com.eomcs.lms.domain.Board;

//Spring IoC 컨테이너가 이 클래스의 인스턴스를 자동 생성하도록 
//클래스에 표시해 둔다.
@Component("/board/update")
public class BoardUpdateController implements PageController {

  BoardDao boardDao;

  public BoardUpdateController(BoardDao boardDao) {
    this.boardDao = boardDao;
  }

  @Override
  public String execute(
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
