import java.sql.Date;
import java.util.Scanner;

public class LessonHandler {
  //업무를 처리하는 클래스명은 보통 ~핸들러, ~컨트롤러
  //이 클래스는 keyboard 객체가 있어야 한다.
  //그러므로 이 클래스의 메서드를 사용하기 전
  //반드시 keyboard 객체를 받아와야한다.
  static Scanner keyboard;
  //집에 전화를 걸려면 전화기가 필요하듯 keyboard를 쓰려면 keyboard를 받아와야한다.
  //이걸 의존 객체라고 함.
  //하지만 이렇게 놔두면 의존성이 강제되지 않기 때문에
  //의존성을 강제하기 위해 생성자를 사용한다.
  //왜? 강제하지 않으면 이상한 방향으로 객체를 사용할 수 있기 때문이다.
  //생성자는 객체를 유효하게 만드는 필수요소를 파라미터로 받아오도록 만드는 녀석이다.

  static final int LENGTH = 10;
  
  static Lesson[] lessons = new Lesson[LENGTH];
  static int lessonIdx = 0;
  
  public static void listLesson() {
    for (int j = 0; j < lessonIdx; j++) {
      System.out.printf("%3d, %-15s, %10s ~ %10s, %4d\n", 
          lessons[j].no, lessons[j].title, lessons[j].startDate, 
          lessons[j].endDate, lessons[j].totalHours);
    }
  }

  public static void addLesson() {
    Lesson lesson = new Lesson();

    System.out.print("번호? ");
    lesson.no = Integer.parseInt(keyboard.nextLine());

    System.out.print("수업명? ");
    lesson.title = keyboard.nextLine();

    System.out.print("설명? ");
    lesson.contents = keyboard.nextLine();

    System.out.print("시작일? ");
    lesson.startDate = Date.valueOf(keyboard.nextLine());

    System.out.print("종료일? ");
    lesson.endDate = Date.valueOf(keyboard.nextLine());

    System.out.print("총수업시간? ");
    lesson.totalHours = Integer.parseInt(keyboard.nextLine());

    System.out.print("일수업시간? ");
    lesson.dayHours = Integer.parseInt(keyboard.nextLine());

    // i 번째 배열에 수업 정보를 담고 있는 Lesson 객체(의 주소)를 보관한다.
    lessons[lessonIdx] = lesson;
    lessonIdx++;

    System.out.println("저장하였습니다.");
  }
}
