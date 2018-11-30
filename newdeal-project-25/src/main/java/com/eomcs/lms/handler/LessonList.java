package com.eomcs.lms.handler;

import java.util.Arrays;
import com.eomcs.lms.domain.Lesson;

public class LessonList {
  static final int LENGTH = 10;
  private Lesson[] list;
  private int size = 0;

  public LessonList() {
    this.list = new Lesson[LENGTH];
  }
  
  public LessonList(int initialCapacity) {
    if(initialCapacity > LENGTH)
      this.list = new Lesson[initialCapacity];
    else
      this.list = new Lesson[LENGTH];
  }

  public void add(Lesson lesson) {
    if(size >= list.length) {
      int oldLength = list.length;
      //int newCapacity = oldLength + (int)(oldLength*0.5);
      int newCapacity = oldLength + (oldLength >> 1);
      //위의 방식보다 아래의 비트 연산을 사용하면 쉽게 처리할 수 있다.
      //그리고 부동 소수점 연산은 연산 과정이 복잡한데 비트 연산을 이용하면 연산 과정이 간단해져서
      //속도 개선도 꾀할 수 있게 된다. 무엇보다 '(int)'같은 강제 변환도 필요없고.
      list = Arrays.copyOf(list, newCapacity);
    }
    list[size] = lesson;
    size++;
  }
  
  public Lesson[] toArray() {
    //Arrays.copyOf(배열, 생성할 길이) = 배열을 복사해주는 메서드.
    return Arrays.copyOf(list, size);
  }


}
