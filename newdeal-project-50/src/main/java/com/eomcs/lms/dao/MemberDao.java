package com.eomcs.lms.dao;

import org.springframework.stereotype.Component;
import com.eomcs.lms.domain.Member;

@Component
public interface MemberDao {
  Member findByEmailPassword(String email, String password) throws Exception;

}
