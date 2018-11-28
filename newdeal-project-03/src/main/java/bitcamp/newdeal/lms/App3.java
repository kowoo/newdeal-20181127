package bitcamp.newdeal.lms;

import java.text.SimpleDateFormat;
import java.util.Scanner;

public class App3 {
    public static void main(String[] args) {
      Scanner keyIn = new Scanner(System.in);
      
      final int DEFAULT_SIZE = 5;
      
      
      int[] no = new int[DEFAULT_SIZE];
      String[] contents = new String[DEFAULT_SIZE];
      String[] writeDate = new String[DEFAULT_SIZE];
      int[] viewCount = new int[DEFAULT_SIZE];
      
      int len = 0;
      
      for(int i=0; i<DEFAULT_SIZE; i++) {
        System.out.print("번호? ");
        no[i] = Integer.parseInt(keyIn.nextLine());
        System.out.print("내용? ");
        contents[i] = keyIn.nextLine();
        writeDate[i] = new SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date());
        viewCount[i] = 0;
        
        len++;
        
        System.out.print("게속 입력하시겠습니까?(Y/n) ");
        String input = keyIn.nextLine();
        if(input.equals("") || input.equalsIgnoreCase("y")) {
          continue;
        }
        break;
      }
      
      keyIn.close();
      
      for(int i=0; i<len; i++) {
        System.out.printf("%d, %s, %s, %d\n", no[i], contents[i], writeDate[i], viewCount[i]);
      }
    }
}
