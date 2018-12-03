package com.eomcs.lms.handler;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;
import com.eomcs.lms.domain.Lesson;

public class LessonAddCommand implements Command {
  
  Scanner keyboard;
  List<Lesson> list;
  Lesson lesson = new Lesson();

  public LessonAddCommand(Scanner keyboard, List<Lesson> list) {
    this.keyboard = keyboard;
    this.list = list;
  }
  
  @Override
  public void execute() {
    System.out.print("번호? ");
    lesson.setNo(Integer.parseInt(keyboard.nextLine()));
    
    System.out.print("수업명? ");
    lesson.setTitle(keyboard.nextLine());
    
    System.out.print("설명? ");
    lesson.setContents(keyboard.nextLine());
    
    System.out.print("시작일? ");
    lesson.setStartDate(Date.valueOf(keyboard.nextLine()));
    
    System.out.print("종료일? ");
    lesson.setEndDate(Date.valueOf(keyboard.nextLine()));
    
    System.out.print("총수업시간? ");
    lesson.setTotalHours(Integer.parseInt(keyboard.nextLine()));
    
    System.out.print("일수업시간? ");
    lesson.setDayHours(Integer.parseInt(keyboard.nextLine()));
    
    list.add(lesson);
    
    System.out.println("저장하였습니다.");
  }
  
  private int indexOfLesson(int no) {
    for (int i = 0; i < list.size(); i++) {
      Lesson l = list.get(i);
      if (l.getNo() == no)
        return i;
    }
    return -1;
  }
    
}
