/*package com.eomcs.lms;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.eomcs.lms.handler.Command;
import com.eomcs.lms.handler.HelloCommand;
import com.eomcs.lms.handler.LessonAddCommand;
import com.eomcs.lms.handler.LessonDeleteCommand;
import com.eomcs.lms.handler.LessonDetailCommand;
import com.eomcs.lms.handler.LessonListCommand;
import com.eomcs.lms.handler.LessonUpdateCommand;
import com.eomcs.lms.handler.MemberAddCommand;
import com.eomcs.lms.handler.MemberDeleteCommand;
import com.eomcs.lms.handler.MemberDetailCommand;
import com.eomcs.lms.handler.MemberListCommand;
import com.eomcs.lms.handler.MemberUpdateCommand;

public class oldApp {

    static Scanner keyboard;
    static Stack<String> commandHistory = new Stack<>();
    static Queue<String> commandHistory2 = new LinkedList<>();

  public static void main(String[] args) throws Exception {
    //AppConfig 클래스가 메모리에 로딩되어 있지 않다면
    //지금 즉시 로딩한 후 그 로딩된 클래스 정보를 리턴하라!
    //Class<?> clazz = Class.forName("com.eomcs.lms.AppConfig");
    //class는 위에 이미 있으므로 clazz같은 다른 이름으로 변수명을 정한다. 
    //근데 이건 너무 길잖아? 그래서 
    //Class<?> clazz2 = AppConfig.class;
    //둘의 값은 같음.

    //Spring IoC Container 준비하기
    ApplicationContext iocContainer = 
        new AnnotationConfigApplicationContext(AppConfig.class);
    
    System.out.println(iocContainer.getBeanDefinitionCount());
    String[] names = iocContainer.getBeanDefinitionNames();
    for (String name: names) {
      System.out.printf("%s ---> %s\n", name, iocContainer.getBean(name).getClass().getName());
    }
     
    
    keyboard = (Scanner) iocContainer.getBean("keyboard");

    HashMap<String, Command> commandMap = new HashMap<>();

    commandMap.put("/lesson/list", new LessonListCommand(keyboard));
    commandMap.put("/lesson/detail", new LessonDetailCommand(keyboard));
    commandMap.put("/lesson/add", new LessonAddCommand(keyboard));
    commandMap.put("/lesson/update", new LessonUpdateCommand(keyboard));
    commandMap.put("/lesson/delete", new LessonDeleteCommand(keyboard));

    commandMap.put("/member/list", new MemberListCommand(keyboard));
    commandMap.put("/member/detail", new MemberDetailCommand(keyboard));
    commandMap.put("/member/add", new MemberAddCommand(keyboard));
    commandMap.put("/member/update", new MemberUpdateCommand(keyboard));
    commandMap.put("/member/delete", new MemberDeleteCommand(keyboard));

    commandMap.put("/hello", new HelloCommand(keyboard));

    while (true) {
      String command = prompt();

      // 사용자가 입력한 명령을 스택에 보관한다.
      commandHistory.push(command);

      // 사용자가 입력한 명령을 큐에 보관한다.
      commandHistory2.offer(command);

      try {
        Command commandHandler = (Command) iocContainer.getBean(command);
        if(commandHandler!=null) {
          try {
            commandHandler.execute();
          } catch(Exception e) {
            System.out.println("오류 발생");
          }

        }else if (command.equals("quit")) {
          System.out.println("안녕!");
          break;

        } else if (command.equals("history")) {
          printCommandHistory();

        } else if (command.equals("history2")) {
          printCommandHistory2();

        } else {
          System.out.println("실행할 수 없는 명령입니다.");
        }

        System.out.println(); 
        

      } catch (Exception e) {

      }

      keyboard.close();
    }


  }

    private static void printCommandHistory() {
      Iterator<String> iterator = commandHistory.iterator();
  
      while (iterator.hasNext()) {
        System.out.println(iterator.next());
      }
    }
  
    private static void printCommandHistory2() {
      Iterator<String> iterator = commandHistory2.iterator();
  
      while (iterator.hasNext()) {
        System.out.println(iterator.next());
      }
    }
  
    private static String prompt() {
      System.out.print("명령> ");
      return keyboard.nextLine().toLowerCase();
    }
}
*/