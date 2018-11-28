package bitcamp.newdeal.lms;

import java.sql.Date;
import java.util.Scanner;

public class App {
  public static void main(String[] args) {
    Scanner keyIn = new Scanner(System.in);

    //JVM이 실행될 때 OS로 부터 일정 메모리를 할당 받는다.
    //이 할당받은 메모리를 3개의 영역으로 구분한다.
    //1. Heap
    //2. Method Area
    //3. Stack
    //스택은 여러개로 구성되는데 메인 메서드가 사용하는 스택과
    //각각의 메서드가 가지는 스택으로 나뉘어진다.
    //고로 스택은 쓰레드당 1개


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
