package com.eomcs.lms.test;

public class Patient {
  //필드
  private String _name; //필드명: _name
  private int age; //필드명: age
  private int height;
  private int weight;
  
  //getter, setter를 property라 부른다.
  public String getName() { //프로퍼티명: name
    return _name;
  }
  public void setName(String name) { //프로퍼티명: name
    this._name = name;
  }
  public int getAge() {
    return age;
  }
  public void setAge(int age) {
    if(age > 0 && age < 120)
      this.age = age;
  }
  public int getWeight() {
    return weight;
  }
  public void setWeight(int weight) {
    if(weight > 1 && weight < 200)
      this.weight = weight;
  }
  public int getHeight() {
    return height;
  }
  public void setHeight(int height) {
    if(height > 1 && height < 200)
      this.height = height;
  }
  
  
}
