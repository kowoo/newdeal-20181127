package bitcamp.newdeal.lms;

import java.sql.Date;
import java.util.Scanner;

public class App3 {
    public static void main(String[] args) {
      Scanner keyIn = new Scanner(System.in);
      
      System.out.print("번호? ");
      int no = Integer.parseInt(keyIn.nextLine());
      System.out.print("내용? ");
      String contents = keyIn.nextLine();
      String writeDate = new Date(System.currentTimeMillis()).toString();
      
      int viewCount = 0;
      
      keyIn.close();
      
      System.out.printf("번호: %d\n", no);
      System.out.printf("내용: %s\n", contents);
      System.out.printf("작성일: %s\n", writeDate);
      System.out.printf("조회수: %d\n", viewCount);
    }
}
