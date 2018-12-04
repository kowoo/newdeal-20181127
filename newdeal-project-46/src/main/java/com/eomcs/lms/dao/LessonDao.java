package com.eomcs.lms.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.List;
import org.mariadb.jdbc.Driver;
import com.eomcs.lms.domain.Lesson;

public class LessonDao {

  public List<Lesson> findAll() throws Exception {
    
    return null; 
  }
  
  public Lesson findByNo(int no) throws Exception {
    
    return null;
  }
  
  public int insert(Lesson lesson) throws Exception {
    DriverManager.registerDriver(new Driver());

    try (Connection con = DriverManager.getConnection(
        "jdbc:mariadb://localhost:3306/studydb", "study", "1111");
        Statement stmt = con.createStatement();) {

      return stmt.executeUpdate(
          "insert into lesson (title, cont, sdt, edt, tot_hr, day_hr, mno)"
              + " values('"+ lesson.getTitle() + "',"
              + " '"+ lesson.getTitle() + "', "
              + lesson.getStartDate() + ", "
              + lesson.getEndDate() + ", "
              + lesson.getTotalHours() + ", "
              + lesson.getDayHours() + ", "
              + lesson.getMno() + ")" );
    }
  }


  public int update(Lesson lesson) throws Exception {

    return 0;
  }

  public int delete(int no) throws Exception {

    return 0;
  }

}
