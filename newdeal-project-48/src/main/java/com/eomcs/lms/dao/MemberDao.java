package com.eomcs.lms.dao;

import java.util.List;
import com.eomcs.lms.domain.Member;

public interface MemberDao {
  Member findByEmailPassword(String email, String password) throws Exception;
  Member findByNo(String no) throws Exception;
  List<Member> findAll() throws Exception;
  void insert(Member member) throws Exception;
  void update(Member member) throws Exception;
  void delete(String no) throws Exception;
}
