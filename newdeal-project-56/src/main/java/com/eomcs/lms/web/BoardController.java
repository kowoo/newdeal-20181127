package com.eomcs.lms.web;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.eomcs.lms.dao.BoardDao;
import com.eomcs.lms.dao.LessonDao;
import com.eomcs.lms.domain.Board;
import com.eomcs.lms.domain.Member;

@Controller
@RequestMapping("/board")
public class BoardController {

  BoardDao boardDao;
  LessonDao lessonDao;

  public BoardController(BoardDao boardDao, LessonDao lessonDao) {
    this.boardDao = boardDao;
    this.lessonDao = lessonDao;
  }
  
  @RequestMapping("form")
  public String form(HttpSession session, Model model)
      throws Exception {
    Member loginUser = (Member) session.getAttribute("loginUser");
    List<Map<String, Object>> lessons = 
        lessonDao.findByParticipantNo(loginUser.getNo());
    model.addAttribute("lessons", lessons);
    return "board/form";
  }
  
  @RequestMapping("add")
  public String add(Board board, HttpSession session) throws Exception {
    //스프링이 알아서 보드 객체 만들어서 넣어주고 (프로퍼티가 있어야함),
    //세션도 파라미터로 넣으면 가져와준다. 스프링 꿀!
    Member loginUser = (Member) session.getAttribute("loginUser");
    board.setWriterNo(loginUser.getNo());
    boardDao.insert(board);
    return "redirect:list";
  }

  @RequestMapping("list")
  public String list(Model model) throws Exception {
    /*
     * 아래와 같은 방식도 가능하다.
     * 스프링은 이렇게 여러 방법을 지원하기 때문에 초보자가 어려움을 느낄 수 있다.
     * 
      public ModelAndView list(Model model) throws Exception {
        ModelAndView mv = new ModelAndView();
        
        List<Board> list = boardDao.findAll();
    
        mv.addObject("list", list);
        mv.setViewName("board/list");
        return mv;
      }
    */
    List<Board> list = boardDao.findAll();
    model.addAttribute("list", list);
    return "board/list";
  }
  
  @RequestMapping("detail")
  public String detail(int no, Model model) throws Exception {
    //리퀘스트 대신 모델이라는 빈 그릇에다가 담아버리자
    //근데 기존 리퀘스트에 담는게 더 낫지 않냐고?
    //ㄴㄴ
    //왜?!
    //유지보수!
    //왜?
    //ViewResolver 가 jsp 가 아닌 다른 기술을 쓴다면? Tiles, Velocity라면?
    //페이지 컨트롤러가 작업한 객체를 다른 기술로 공유하려면?
    //걔네는 jsp를 안쓰고 서블릿이 아니라 리퀘스트를 모름.
    //그렇다면 걔네들이 알게 하려면 빼기가 쉬워야겠지?
    //그래서 중간 바구니 겸 model을 쓰는거야.
    //스프링의 장점 중 하나는 jsp가 강조되지 않는다는거지.
    //그래서 Tiles로 데이터를 출력한다던가
    //출력하는 기술은 여러개니 그거에 맞춰서 호환해주는 스프링 찬양해!
    Board board = boardDao.findByNo(no);
    model.addAttribute("board", board);
    return "board/detail";
  }
  
  @RequestMapping("update")
  public String update(Board board, Model model) throws Exception {
      boardDao.update(board);
      return "redirect:list";
  }
  
  @RequestMapping("delete")
  public String delete(int no, Model model) throws Exception {
    model.addAttribute("count", boardDao.delete(no));
    return "board/delete";
  }
  
}