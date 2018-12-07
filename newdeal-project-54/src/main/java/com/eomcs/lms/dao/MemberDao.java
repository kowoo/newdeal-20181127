package com.eomcs.lms.dao;

import java.util.Map;
import org.springframework.stereotype.Component;
import com.eomcs.lms.domain.Member;

@Component
public interface MemberDao {
  Member findByEmailPassword(Map<String, Object> params) throws Exception;

}
