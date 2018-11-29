package com.eomcs.lms.test;

public class Test {
  public static void main(String[] args) {
    Patient p1 = new Patient();
    p1.setName("홍길동");
    p1.setAge(10);
    p1.setWeight(100);
    p1.setHeight(170);
    
    System.out.println(p1.getName());
  }

}
