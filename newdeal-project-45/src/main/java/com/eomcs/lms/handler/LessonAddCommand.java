package com.eomcs.lms.handler;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;
import org.mariadb.jdbc.Driver;

public class LessonAddCommand implements Command {
  
  Scanner keyboard;

  public LessonAddCommand(Scanner keyboard) {
    this.keyboard = keyboard;
  }
  
  @Override
  public void execute() {
    Connection con = null;
    Statement stmt = null;

    try {
      DriverManager.registerDriver(new Driver());
      con = DriverManager.getConnection(
          "jdbc:mariadb://localhost:3306/studydb", "study", "1111");
      stmt = con.createStatement();
      
      System.out.print("수업명? ");
      String title = keyboard.nextLine();
      System.out.print("설명? ");
      String content = keyboard.nextLine();
      System.out.print("시작일? ");
      String sdt = keyboard.nextLine();
      System.out.print("종료일? ");
      String edt = keyboard.nextLine();
      System.out.print("총수업시간? ");
      String tot_hr = keyboard.nextLine();
      System.out.print("일수업시간? ");
      String day_hr = keyboard.nextLine();
      System.out.print("학생번호? ");
      String mno = keyboard.nextLine();
      
      stmt.executeUpdate(
          "insert into lesson (title, cont, sdt, edt, tot_hr, day_hr, mno)"
          + " values('"+ title + "',"
          + " '"+ content + "', "
          + sdt + ", "
          + edt + ", "
          + tot_hr + ", "
          + day_hr + ", "
          + mno + ")" );
      System.out.println("저장하였습니다.");
      
    }catch (Exception e){
      System.out.println(e.getStackTrace());
    }finally {
      try { stmt.close(); } catch (Exception e) {};
      try { con.close(); } catch (Exception e) {};
    }
  }
}
