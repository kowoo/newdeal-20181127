package com.eomcs.lms.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.eomcs.lms.dao.BoardDao;
import com.eomcs.lms.domain.Board;
import com.eomcs.lms.domain.Member;

@Controller
public class BoardAddController {

  BoardDao boardDao;

  public BoardAddController(BoardDao boardDao) {
    this.boardDao = boardDao;
  }
  @RequestMapping("/board/add")
  public String add(
      HttpServletRequest request, HttpServletResponse response)
          throws Exception {

    Board board = new Board();
    board.setContents(request.getParameter("contents"));

    Member loginUser = 
        (Member) request.getSession().getAttribute("loginUser");

    board.setWriterNo(loginUser.getNo());
    board.setLessonNo(Integer.parseInt(
        request.getParameter("lessonNo")));
    boardDao.insert(board);

    //웹 브라우저에 던져주면 웹 브라우저가 현재 위치를 계산해서 요청한다.
    //웹 브라우저 루트 (브라우저 입장에서의 경로)
    return "redirect:list";
  }
}








