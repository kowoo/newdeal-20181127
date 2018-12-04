package com.eomcs.lms.handler;

import java.util.Scanner;
import com.eomcs.lms.dao.MemberDao;
import com.eomcs.lms.domain.Member;

public class LoginCommand implements Command {

  Scanner keyboard;
  MemberDao memberDao;

  public LoginCommand(Scanner keyboard, MemberDao memberDao) {
    this.keyboard = keyboard;
    this.memberDao = memberDao;
  }

  @Override
  public void execute() {
    try {
      System.out.print("이메일? ");
      String email = keyboard.nextLine();
      
      System.out.print("비밀번호? ");
      String password = keyboard.nextLine();

      Member member = memberDao.findByEmailPassword(email, password);
      if (member != null) {
        System.out.println(member.getName()+"님 환영합니다.");
      }else {
        System.out.println("이메일 또는 비밀번호가 일치하지 않습니다.");
      }
    } catch (Exception e) {
      e.printStackTrace();
    } 
  }
}
