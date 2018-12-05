package com.eomcs.lms.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import org.mariadb.jdbc.Driver;
import com.eomcs.lms.dao.MemberDao;
import com.eomcs.lms.domain.Member;

public class MariaDBMemberDao implements MemberDao {

  @Override
  public Member findByEmailPassword(String email, String password) throws Exception {
    DriverManager.registerDriver(new Driver());
    //preparedstament를 사용하는 이유 = sql 삽입 공격 방어
    //왜? 인파라미터 안에 ''를 넣어봤자 문자열로 취급하기 때문에
    //user04@test.com' and 'a'='a' or 'x'='x 같은 공격이 안통한다.
    try (        
        Connection con = DriverManager.getConnection(
            "jdbc:mariadb://localhost:3306/studydb", "study", "1111");
        PreparedStatement stmt = con.prepareStatement(
            "select mno, name, email, photo from member"
                + " where email=? and pwd=?");) {
      //?를 인파라미터라고 부름. 왜? in parameter. 파라미터가 들어가는 곳이라서
      stmt.setString(1, email);
      stmt.setString(2, password);
      //왜 위에 못가는지는 알지?

      //이렇게 이중 try문을 만들면 finally안써도 돼서 좋아
      try (ResultSet rs = stmt.executeQuery()) {
        if(rs.next()) {
          Member member = new Member();
          member.setNo(rs.getInt("mno"));
          member.setName(rs.getString("name"));
          member.setEmail(rs.getString("email"));
          member.setPhoto(rs.getString("photo"));
          return member;
        } else {
          return null;
        }
      }

    } 
  }

  @Override
  public Member findByNo(String no) throws Exception {


    return null;
  }

  @Override
  public List<Member> findAll() throws Exception {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void insert(Member member) throws Exception {
    // TODO Auto-generated method stub
    DriverManager.registerDriver(new Driver());
    try(
        Connection con = DriverManager.getConnection
        ("jdbc:mariadb://localhost:3306/studydb", "study", "1111");
        Statement stmt = con.createStatement();) {

      stmt.executeUpdate("insert into member (name, email, pwd, photo, tel)"
          + "values ("
          + " '"+ member.getName()+ "',"
          + " '"+ member.getEmail() + "',"
          + " '"+ member.getPassword() + "',"
          + " '"+ member.getPassword() + "',"
          + " '"+ member.getTel() + "')");
    }
  }

  @Override
  public void update(Member member) throws Exception {


  }

  @Override
  public void delete(String no) throws Exception {
    DriverManager.registerDriver(new Driver());

    try(
        Connection con = DriverManager.getConnection
          ("jdbc:mariadb://localhost:3306/studydb", "study", "1111");
        Statement stmt = con.createStatement()) {
      
      stmt.executeUpdate("delete from member where mno=" + no);
      System.out.println("회원을 삭제했습니다.");
    }

  }


}
