package com.eomcs.lms.dao;

import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Component;

@Component
public interface LessonDao {
  List<Map<String, Object>> findByParticipantNo(int memberNo);

}
