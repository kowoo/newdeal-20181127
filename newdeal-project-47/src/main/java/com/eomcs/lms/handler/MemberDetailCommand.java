package com.eomcs.lms.handler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class MemberDetailCommand implements Command {

  Scanner keyboard;

  public MemberDetailCommand(Scanner keyboard) {
    this.keyboard = keyboard;
  }

  @Override
  public void execute() {
    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;
    try {
      System.out.print("번호? ");
      int no = Integer.parseInt(keyboard.nextLine());
      
      con = DriverManager.getConnection
          ("jdbc:mariadb://localhost:3306/studydb", "study", "1111");
      stmt = con.createStatement();
      rs = stmt.executeQuery
          ("select mno, name, email, pwd, photo, tel, cdt from member where mno=" + no);
      
      if(rs.next()) {
        System.out.printf("번호:  %d\n", rs.getInt("mno"));
        System.out.printf("이름:  %s\n", rs.getString("name"));
        System.out.printf("이메일: %s\n", rs.getString("email"));
        System.out.printf("비밀번호: %s\n", rs.getString("pwd"));
        System.out.printf("사진: %s\n", rs.getString("photo"));
        System.out.printf("전화번호: %s\n", rs.getString("tel"));
        System.out.printf("등록일: %s\n", rs.getString("cdt"));
      }else {
        System.out.println("해당 회원을 찾을 수 없습니다.");
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try { rs.close();} catch (Exception e) {}
      try { stmt.close();} catch (Exception e) {}
      try { con.close();} catch (Exception e) {}
    }
  }
}
