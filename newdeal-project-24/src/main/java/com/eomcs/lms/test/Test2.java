package com.eomcs.lms.test;

public class Test2 {
  public static void main(String[] args) {
    Score s1 = new Score();
    s1.setName("홍길동");
    s1.setKor(10);
    s1.setMath(100);
    s1.setEng(170);
    
    System.out.println(s1.getSum());
    System.out.println(s1.getAver());
  }

}
