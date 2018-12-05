package com.eomcs.lms.handler;

import java.util.Scanner;
import com.eomcs.lms.dao.BoardDao;

public class MemberDeleteCommand implements Command {
  Scanner keyboard;
  BoardDao boardDao;
  
  public MemberDeleteCommand(Scanner keyboard, BoardDao boardDao) {
    this.keyboard = keyboard;
    this.boardDao = boardDao;
  }

  @Override
  public void execute() {

    try {
      System.out.print("번호? ");
      String no = keyboard.nextLine();
      

      System.out.println("회원을 삭제했습니다.");
      
    } catch (Exception e) {
      e.getStackTrace();
    }
  }

}
