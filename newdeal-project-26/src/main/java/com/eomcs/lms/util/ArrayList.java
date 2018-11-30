package com.eomcs.lms.util;

import java.util.Arrays;

public class ArrayList<T> {
  final int DEFAULT_CAPACITY = 10;
  Object[] list;
  int size = 0;
  //배열 생성은 T로 만드는게 불가능하다
  //<변수명> : type는 보통 T, 배열은 보통 E 이런식으로 이름을 준다.
  
  public ArrayList() {
    list = new Object[DEFAULT_CAPACITY];
  }
  
  public ArrayList(int initialCapacity) {
    if (initialCapacity > DEFAULT_CAPACITY) 
      list = new Object[initialCapacity];
    else
      list = new Object[DEFAULT_CAPACITY];
  }
  
  @SuppressWarnings("unchecked")
  public T[] toArray(T[] a) {
    if (a.length < size) {
      //Clone가 아닌 Arrays.copyOf를 사용한 이유는
      //Clone는 인스턴스 자체를 복사한다. 그래서 길이가 100이면 100을 그대로 복사.
      //하지만 copyOf는 생성된 사이즈까지만 복사한다.
      
      return (T[]) Arrays.copyOf(list, size, a.getClass());
    }
                //list의 0번째에 a라는 배열의 0번째부터 사이즈까지 저장하라!
    System.arraycopy(list, 0, a, 0, size);
    if (a.length > size) {
      a[size] = null;
    }
    return a;
  }
  
  public void add(T item) {
    if (size >= list.length) {
      int oldCapacity = list.length;
      int newCapacity = oldCapacity + (oldCapacity >> 1);
      list = Arrays.copyOf(list, newCapacity);
    }
    
    list[size++] = item;
  }
  public int size() {
    return this.size;
  }
}
