package bitcamp.newdeal.lms;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class App2 {
    public static void main(String[] args) {
      Scanner keyIn = new Scanner(System.in);
      
      final int DEFAULT_SIZE = 5;
      
      int[] no = new int[DEFAULT_SIZE];
      String[] name = new String[DEFAULT_SIZE];
      String[] email = new String[DEFAULT_SIZE];
      String[] password = new String[DEFAULT_SIZE];
      String[] picture = new String[DEFAULT_SIZE];
      String[] tel = new String[DEFAULT_SIZE];
      String[] signDate = new String[DEFAULT_SIZE];
      
      int len = 0;
      
      for(int i=0; i<DEFAULT_SIZE; i++) {
        System.out.print("번호? "); 
        no[i] = Integer.parseInt(keyIn.nextLine());
        System.out.print("이름? ");
        name[i] = keyIn.nextLine();
        System.out.print("이메일? ");
        email[i] = keyIn.nextLine();
        System.out.print("암호? ");
        password[i] = keyIn.nextLine();
        System.out.print("사진? ");
        picture[i] = keyIn.nextLine();
        System.out.print("전화? ");
        tel[i] = keyIn.nextLine();
        signDate[i] = new SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date());
        len++;
        
        System.out.print("계속 입력하시겠습니까?(Y,n) ");
        String input = keyIn.nextLine();
        if(input.equals("") || input.equalsIgnoreCase("y")) {
          continue;
        }
        break;
      }
      
      keyIn.close();
      
      for(int i=0; i<len; i++) {
        System.out.printf("%d, %-10s, %-20s, %-10s, %s\n"
            , no[i], name[i], email[i], tel[i], signDate[i]);
      }
    }
}
