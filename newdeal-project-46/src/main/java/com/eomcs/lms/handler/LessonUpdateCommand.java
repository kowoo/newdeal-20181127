package com.eomcs.lms.handler;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.Scanner;
import org.mariadb.jdbc.Driver;
import com.eomcs.lms.domain.Lesson;

public class LessonUpdateCommand implements Command {

  Scanner keyboard;

  public LessonUpdateCommand(Scanner keyboard) {
    this.keyboard = keyboard;
  }

  @Override
  public void execute() {
    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;

    try {
      DriverManager.registerDriver(new Driver());
      con = DriverManager.getConnection(
          "jdbc:mariadb://localhost:3306/studydb", "study", "1111");
      stmt = con.createStatement();
      
      System.out.print("번호? ");
      int no = Integer.parseInt(keyboard.nextLine());
      rs = stmt.executeQuery("select title from lesson where lno="+no);
      
      if (rs.next()) {
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
        
        stmt.executeUpdate(
            "update lesson set title='"+ title + "',"
            + " cont='" + content + "',"
            + " sdt=" + sdt + ","
            + " edt=" + edt + ","
            + " tot_hr=" + tot_hr + ","
            + " day_hr=" + day_hr + ","
            + " where lno="+ no);
        System.out.println("수업을 변경했습니다.");
      }else {
        System.out.println("해당 수업을 찾을 수 없습니다.");
      }
    }catch (Exception e){
      System.out.println(e.getStackTrace());
    }finally {
      try { rs.close(); } catch (Exception e) {};
      try { stmt.close(); } catch (Exception e) {};
      try { con.close(); } catch (Exception e) {};
    }
  }
}
