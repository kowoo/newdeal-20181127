package com.eomcs.lms.handler;

import java.util.Arrays;
import java.util.Scanner;
import com.eomcs.lms.domain.Member;

public class MemberList {
  static final int LENGTH = 10;
  private Member[] list;
  private int size = 0;

  public MemberList() {
    list = new Member[LENGTH];
  }

  public MemberList(int initialCapacity) {
    if(initialCapacity >= LENGTH)
      list = new Member[initialCapacity];
    else
      list = new Member[LENGTH];
  }

  int memberIdx = 0; 

  public void add(Member member) {
    if(size >= list.length) {
      int oldLength = list.length;
      int newCapacity = oldLength + (oldLength >> 1);
      list = Arrays.copyOf(list, newCapacity);
    }

    list[size] = member; 
    size++;
  }

  public Member[] toArray() {
    return Arrays.copyOf(list, size);
  }
}
