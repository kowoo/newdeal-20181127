package com.eomcs.lms.handler;
import java.sql.Date;
import java.util.Scanner;
import com.eomcs.lms.domain.Board;
import com.eomcs.lms.util.ArrayList;

public class BoardHandler {
  
  Scanner keyboard;
  ArrayList<Board> list;
  
  public BoardHandler(Scanner keyboard) {
    this.keyboard = keyboard;
    this.list = new ArrayList<>(20);
  }
  
  public void listBoard() {
    Board[] boards = new Board[list.size()];
    list.toArray(boards);
    
    for (Board board : boards) {
      System.out.printf("%3d, %-20s, %s, %d\n", 
          board.getNo(), board.getContents(), 
          board.getCreatedDate(), board.getViewCount());
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
    
    int i = 100;
    Integer obj = new Integer(100);
    obj = 200; // auto-boxing ==> new Integer(100)
    int j = obj.intValue(); // auto-unboxing ==> obj.intValue();
    //오토박싱, 오토언박싱 기능.
    //int i라고 하고 값을 집어넣으면 해당 값이 들어가는게 아니라 주소가 들어간다.
    //왜냐하면 오토박싱으로 인해 인티저에다가 넣어버리기 때문.
    //집에서 정
    
    System.out.println("저장하였습니다.");
  }

}
