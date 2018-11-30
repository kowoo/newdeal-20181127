package com.eomcs.util;

public interface List<E> {
  E[] toArray(E[] a); //인터페이스의 모든 메서드는 퍼블릭이어야한다. 왜? 규칙을 알아야 뭐를 할지 알 수 있잖아.
  void add(E obj);
  E get(int index);
  E set(int index, E obj);
  E remove(int index);
  int size();
}
