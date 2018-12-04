package com.eomcs.lms.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.mariadb.jdbc.Driver;
import com.eomcs.lms.dao.BoardDao;
import com.eomcs.lms.domain.Board;

public class MariaDBBoardDao implements BoardDao {
  public MariaDBBoardDao() {};

  public List<Board> findAll() throws Exception {
    //바로 이 문법!
    //AutoCloseable을 구현한 함수만 넣을 수 있음. String s 이런건 안돼있으니 안됨.
    try (
        Connection con = DriverManager.getConnection(
            "jdbc:mariadb://localhost:3306/studydb", "study", "1111");
        //인파라미터가 없으니 statement써도 괜찮을거 같지만
        //정부 기관 검수는 프로그램이 자동으로 검사하는 것이기 때문에 넣으면 경고가 발생한다.
        PreparedStatement stmt = con.prepareStatement(
            "select bno, cont, cdt, view from board");
        ResultSet rs = stmt.executeQuery();){

      ArrayList<Board> list = new ArrayList<>();

      while(rs.next()) {
        Board board = new Board();
        board.setNo(rs.getInt("bno"));
        board.setContents(rs.getString("cont"));
        board.setCreatedDate(rs.getDate("cdt"));
        board.setViewCount(rs.getInt("view"));
        list.add(board);
      }
      return list;

    } catch (Exception e) {
      throw e;
    } 
    //    finally {
    //      //이 방법 말고 최신 문법 중 좋은게 있대요. 위에 try 참고.
    //      try { rs.close();} catch (Exception e) {}
    //      try { stmt.close();} catch (Exception e) {}
    //      try { con.close();} catch (Exception e) {}
    //    }
  }
  //왜 findByNo로 하냐면 jpa에서 이렇게 쓰기 때문에 차후 jpa를 쓰는 경우를 대비해서 익숙해지기 위함.
  public Board findByNo(int no) throws Exception {
    DriverManager.registerDriver(new Driver());

    //finally가 없음에도 try문을 쓰는건
    //Autocloseable을 통해 close를 자동으로 호출해야하기 때문.
    try (        
        Connection con = DriverManager.getConnection(
            "jdbc:mariadb://localhost:3306/studydb", "study", "1111");
        PreparedStatement stmt = con.prepareStatement("select bno, cont, cdt, view, mno, lno"
            + " from board"
            + " where bno=?")){
      stmt.setInt(1, no);
      try(ResultSet rs = stmt.executeQuery()) {
        if(rs.next()) {
          Board board = new Board();
          board.setNo(rs.getInt("bno"));
          board.setContents(rs.getString("cont"));
          board.setCreatedDate(rs.getDate("cdt"));
          board.setViewCount(rs.getInt("view"));
          board.setWriterNo(rs.getInt("mno"));
          board.setLessonNo(rs.getInt("lno"));
          return board;
        } else {
          return null;
        }

      }

      //DBMS에서 한개의 레코드를 가져온다.
    } 
  }

  public int insert(Board board) throws Exception {
    DriverManager.registerDriver(new Driver());

    try ( 
        Connection con = DriverManager.getConnection(
            "jdbc:mariadb://localhost:3306/studydb", "study", "1111");
        PreparedStatement stmt = con.prepareStatement(
            "insert into board(cont, mno, lno) values(?,?,?)");) {
      stmt.setString(1, board.getContents());
      stmt.setInt(2, board.getWriterNo());
      stmt.setInt(3, board.getLessonNo());
      
      return stmt.executeUpdate();
    }
  }

  public int update(Board board) throws Exception {
    Connection con = null;
    PreparedStatement stmt = null;

    try {
      DriverManager.registerDriver(new Driver());
      con = DriverManager.getConnection
          ("jdbc:mariadb://localhost:3306/studydb", "study", "1111");
      stmt = con.prepareStatement(
          "update board set cont=? where bno=?"
          );
      stmt.setString(1, board.getContents());
      stmt.setInt(2, board.getNo());
      return stmt.executeUpdate();
    } finally {
      try { stmt.close();} catch (Exception e) {}
      try { con.close();} catch (Exception e) {}
    }
  }

  public int delete(int no) throws Exception {
    Connection con = null;
    PreparedStatement stmt = null;

    try {
      DriverManager.registerDriver(new Driver());
      con = DriverManager.getConnection
          ("jdbc:mariadb://localhost:3306/studydb", "study", "1111");
      stmt = con.prepareStatement(
          "delete from board where bno=?");
      stmt.setInt(1, no);
      return stmt.executeUpdate();
    } finally {
      try { stmt.close();} catch (Exception e) {}
      try { con.close();} catch (Exception e) {}
    }
  }
}
