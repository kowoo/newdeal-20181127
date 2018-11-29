package bitcamp.newdeal.lms;

import java.sql.Date;
import java.util.Scanner;

public class App {
  public static void main(String[] args) {
    Scanner keyIn = new Scanner(System.in);

    final int DEFAULT_SIZE = 20;
    int[] no = new int[DEFAULT_SIZE];
    String[] title = new String[DEFAULT_SIZE];
    String[] contents = new String[DEFAULT_SIZE];
    Date[] startDate = new Date[DEFAULT_SIZE];
    Date[] endDate = new Date[DEFAULT_SIZE];
    int[] totalHours = new int[DEFAULT_SIZE];
    int[] dayHours = new int[DEFAULT_SIZE];

    int len = 0;
    for(int i=0; i<DEFAULT_SIZE; i++) {
      System.out.print("번호? "); 
      no[i] = Integer.parseInt(keyIn.nextLine());
      System.out.print("수업명? ");
      title[i] = keyIn.nextLine();
      System.out.print("설명? ");
      contents[i] = keyIn.nextLine();
      System.out.print("시작일? ");
      startDate[i] = Date.valueOf(keyIn.nextLine());
      System.out.print("종료일? ");
      endDate[i] = Date.valueOf(keyIn.nextLine());
      System.out.print("총수업시간? ");
      totalHours[i] = Integer.parseInt(keyIn.nextLine());
      System.out.print("일수업시간? ");
      dayHours[i] = Integer.parseInt(keyIn.nextLine());
      
      len++;
      
      //(Y/n)으로 하는 이유는 그냥 엔터를 치면 y로 알아듣겠다는 뜻.
      System.out.print("계속하시겠습니까?(Y/n)");
      String input = keyIn.nextLine();
      if(input.equals("") || input.equalsIgnoreCase("y")) {
        continue;
      }
      break;
    }
    keyIn.close();

    
    for(int i=0; i<len; i++) {
      System.out.printf("%d, %s, %s ~ %s, %d\n",
          no[i], title[i], startDate[i], endDate[i], totalHours[i]);
    }









  }
}
