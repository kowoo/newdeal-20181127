package bitcamp.newdeal.lms;

import java.text.SimpleDateFormat;
import java.util.Scanner;

public class App3 {
    public static void main(String[] args) {
      Scanner keyIn = new Scanner(System.in);
      
      System.out.print("번호? ");
      int no = Integer.parseInt(keyIn.nextLine());
      System.out.print("내용? ");
      String contents = keyIn.nextLine();
      String writeDate = new SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date());
      
      int viewCount = 0;
      
      
      System.out.printf("번호: %d\n", no);
      System.out.printf("내용: %s\n", contents);
      System.out.printf("작성일: %s\n", writeDate);
      System.out.printf("조회수: %d\n", viewCount);
    }
}
