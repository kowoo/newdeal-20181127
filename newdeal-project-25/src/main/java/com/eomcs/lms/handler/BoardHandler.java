package com.eomcs.lms.handler;
import java.sql.Date;
import java.util.Scanner;
import com.eomcs.lms.domain.Board;

public class BoardHandler {
  
  static final int LENGTH = 10;
  
  Scanner keyboard;
  Board[] boards = new Board[LENGTH];
  BoardList list;

  public BoardHandler(Scanner keyboard) {
    this.keyboard = keyboard;
    this.list = new BoardList();
  }

  public void listBoard() {
    boards = list.toArray();
    for (int j = 0; j < boards.length; j++) {
      System.out.printf("%3d, %-20s, %s, %d\n", 
          this.boards[j].getNo(), this.boards[j].getContents(), 
          this.boards[j].getCreatedDate(), this.boards[j].getViewCount());
    }
  }
  
  public void addBoard() {
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
