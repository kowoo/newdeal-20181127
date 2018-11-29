package com.eomcs.lms.handler;
import java.sql.Date;
import java.util.Scanner;
import com.eomcs.lms.domain.Board;

public class BoardHandler {
  
  static final int LENGTH = 10;
  
  public Scanner keyboard;
  Board[] boards = new Board[LENGTH];
  int boardIdx = 0;

  public BoardHandler(Scanner keyboard) {
    //파라미터로 키보드를 받아 오게 되면 클래스 변수의 키보드 부분에서 static을 뺄 수 있다.
  }
  
  //static이 있으면 인스턴스 없이 이름을 호출한다.
  //하지만 static이 없으면 해당 메소드는 인스턴스 주소없이 호출할 수 없게 된다.
  public void listBoard() {
    for (int j = 0; j < this.boardIdx; j++) {
      System.out.printf("%3d, %-20s, %s, %d\n", 
          this.boards[j].no, this.boards[j].contents, this.boards[j].createdDate, this.boards[j].viewCount);
    }
  }

  
  public void addBoard() {
    Board board = new Board();
    
    System.out.print("번호? ");
    board.no = Integer.parseInt(keyboard.nextLine());
    
    System.out.print("내용? ");
    board.contents = keyboard.nextLine();
    
    board.createdDate = new Date(System.currentTimeMillis()); 
    
    board.viewCount = 0;
    
    this.boards[boardIdx] = board;
    this.boardIdx++;
    
    System.out.println("저장하였습니다.");
  }

}
