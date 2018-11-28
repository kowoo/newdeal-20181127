package bitcamp.newdeal.lms;

import java.sql.Date;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
      
      //따로 필기
      //키보드 주소는 system이라는 클래스의 static 변수인 in이다.
      //스캐너는 입력한 문자열을 enter 단위로 식별한다.
      //윈도우는 엔터를 2바이트로 취급한다. 유닉스는 1바이트.
      //변수명은 줄이지 말고 길게 만들자. 그래야 유지보수에 용이함.
      //단 전화(tel), 팩스(fax)같이 누구나 알아보는건 그냥 줄여도 됨
      
      Scanner keyIn = new Scanner(System.in);
      //여기서 Scanner는 System.in에게 의존한다.
      //System.in이 없으면 Scanner는 아무것도 못하잖아?
      //이걸 dependency라고 부른다.
      //스프링에서 했던 DI, 의존성주입과 같음.
      
      //메서드가 인스턴스에 있는 변수를 다룬다면
      //스태틱을 붙이면 안된다.
      //인스턴스와 상관없이 보편적인 값을 가지고 있다면
      //스태틱을 붙인다.
      
      //project-02를 복사해서 project-03으로 만들면
      //이클립스에서 임포트가 안된다.
      //왜? 이클립스는 .project 안에 있는 name의 이름으로
      //폴더를 구분하는데 이건 복사해도 같은 값이기 때문
      //하지만 여기 있는 정보를 03으로 바꿔도 다시 실행하면
      //02로 돌아가버린다.
      //이런 현상을 방지하려면
      //settings.gradle의 name를 수정하고 03 폴더로 간 뒤
      //gradle eclipse를 하면 된다.
      
      
      
//      String str = keyIn.nextLine();
//      System.out.println(str);
      
      
      System.out.print("번호? "); 
      int no = Integer.parseInt(keyIn.nextLine());
      System.out.print("수업명? ");
      String title = keyIn.nextLine();
      System.out.print("설명? ");
      String contents = keyIn.nextLine();
      System.out.print("시작일? ");
      Date startDate = Date.valueOf(keyIn.nextLine());
      
      
      
      System.out.print("종료일? ");
      Date endDate = Date.valueOf(keyIn.nextLine());
      System.out.print("총수업시간? ");
      int totalHours = Integer.parseInt(keyIn.nextLine());
      System.out.print("일수업시간? ");
      int dayHours = Integer.parseInt(keyIn.nextLine());
      
      keyIn.close();
      
      System.out.println("번호 : " + no);
      System.out.printf("수업명 : %s\n", title);
      System.out.printf("설명 : %s\n", contents);
      System.out.printf("시작일 : %s\n", startDate);
      System.out.printf("종료일 : %s\n", endDate);
      System.out.printf("총수업시간 : %d\n", totalHours);
      System.out.printf("일수업시간 : %d\n", dayHours);
      
      
      
      
      
      
      
       
      
    }
}
