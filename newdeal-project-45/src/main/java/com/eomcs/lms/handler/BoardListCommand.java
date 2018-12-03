package com.eomcs.lms.handler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import org.mariadb.jdbc.Driver;

public class BoardListCommand implements Command {

  Scanner keyboard;

  public BoardListCommand(Scanner keyboard) {
    this.keyboard = keyboard;
  }

  public void execute() {
    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;
    
    try {
      //마리아 DB JDBC Driver(java.sql.Driver) 구현제를 로딩
      //DriverManager.registerDriver(new Driver());
      //사실 마리아DB는 이거 안해도 동작함!!!

      //DBMS 연결
      con = DriverManager.getConnection
          ("jdbc:mariadb://localhost:3306/studydb", "study", "1111");

      //SQL 전송을 담당할 객체 준비
      stmt = con.createStatement();

      //위 3종 모두 java.sql import

      //SQL을 서버에 전송 -> 서버에서 결과를 가져오는 일을 하는 객체를 리턴 (서버에서 객체를 리턴하는게 아님)
      rs = stmt.executeQuery
          ("select bno, cont, cdt, view from board");

      //DBMS에서 한개의 레코드를 가져온다.
      while(rs.next()) {
        System.out.printf("%3d, %-20s, %s, %d\n",
            rs.getInt("bno"), rs.getString("cont"),
            rs.getDate("cdt"), rs.getInt("view"));
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
