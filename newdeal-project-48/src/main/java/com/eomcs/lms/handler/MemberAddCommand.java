package com.eomcs.lms.handler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;
import org.mariadb.jdbc.Driver;
import com.eomcs.lms.dao.MemberDao;
import com.eomcs.lms.domain.Member;

public class MemberAddCommand implements Command {

  Scanner keyboard;
  MemberDao memberDao;

  public MemberAddCommand(Scanner keyboard, MemberDao memberDao) {
    this.keyboard = keyboard;
    this.memberDao = memberDao;
  }

  @Override
  public void execute() {
    Connection con = null;
    Statement stmt = null;

    try {
      Member member = new Member();

      System.out.print("이름? ");
      member.setName(keyboard.nextLine());

      System.out.print("이메일? ");
      member.setEmail(keyboard.nextLine());

      System.out.print("암호? ");
      member.setPassword(keyboard.nextLine());

      System.out.print("사진? ");
      member.setPhoto(keyboard.nextLine());

      System.out.print("전화? ");
      member.setTel(keyboard.nextLine());

      memberDao.insert(member);
      System.out.println("등록하였습니다.");

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
