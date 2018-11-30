package com.eomcs.lms.handler;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;
import com.eomcs.lms.domain.Board;

public class BoardListCommand implements Command {

  Scanner keyboard;
  List<Board> list;
  
  public BoardListCommand(Scanner keyboard, List<Board> list) {
    this.keyboard = keyboard;
    this.list = list;
  }

  public void execute() {
      Board board = new Board();
      
      System.out.print("번호? ");
      board.setNo(Integer.parseInt(keyboard.nextLine()));
      
      System.out.print("내용? ");
      board.setContents(keyboard.nextLine());
      
      board.setCreatedDate(new Date(System.currentTimeMillis())); 
      
      board.setViewCount(0);
      
      list.add(board);
      
      System.out.println("저장하였습니다.");
  }
}
