package com.eomcs.lms.handler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import org.mariadb.jdbc.Driver;
import com.eomcs.lms.domain.Member;

public class MemberUpdateCommand implements Command {
  Scanner keyboard;

  public MemberUpdateCommand(Scanner keyboard) {
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
      String no = keyboard.nextLine();

      rs = stmt.executeQuery("select name from member where mno=" + no);
      if(rs.next()) {
        String oldName = rs.getString("name");
        String oldEmail = rs.getString("email");
        String oldPhoto = rs.getString("photo");
        String oldTel = rs.getString("tel");

        System.out.printf("이름(%s)? ", oldName);
        String name = keyboard.nextLine();
        System.out.printf("이메일(%s)? ", oldEmail);
        String email = keyboard.nextLine();
        System.out.printf("암호(********)? ");
        String pwd = keyboard.nextLine();
        System.out.printf("사진(%s)? ", oldPhoto);
        String photo = keyboard.nextLine();          
        System.out.printf("전화(%s)? ", oldTel);
        String tel = keyboard.nextLine();
        
        stmt.executeUpdate(
            "update member set"
            +" name =" + name
            +", email =" + email
            +", pwd =" + pwd
            +", photo =" + photo
            +", tel =" + tel
            +" where mno =" + no);

        System.out.println("회원을 변경했습니다.");
      }else {
        System.out.println("해당 회원이 존재하지 않습니다.");
      }
      // 기존 값 복제
      try { rs.close(); } catch (Exception e) {};
    } catch (Exception e) {
      e.getStackTrace();
    } finally {
      try { stmt.close(); } catch (Exception e) {};
      try {con.close(); } catch (Exception e) {};
    }
  }
}





