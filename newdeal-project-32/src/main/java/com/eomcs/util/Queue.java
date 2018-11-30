package com.eomcs.util;

public class Queue<E> extends LinkedList<E> implements Cloneable {

  private int maxSize;
  
  public Queue() {
    maxSize = 100;
  }
  
  public Queue(int maxSize) {
    this.maxSize = maxSize;
  }
  
  @Override
  public Queue<E> clone() {
    Queue<E> temp = new Queue<>();
    for (int i = 0; i < size(); i++) {
      temp.add(get(i));
    }
    return (Queue<E>) temp;
  }
  
  public void offer(E value) {
    if (size() == maxSize)
      remove(0); // 꽉차면 맨 앞에 입력된 값을 제거한다.
    add(value);
  }
  
  public E poll() {
    if (size() > 0)
      return remove(0);
    return null;
  }
  
  //중첩 클래스 중 익명 클래스
  public Iterator<E> iterator() {
    //실무에서는 이렇게 쓴다. 연습좀 하자.
    return new Iterator<>() {
      Queue<?> queue;
      int count;
      {
        this.queue = Queue.this.clone();
      }
      public boolean hasNext() {
        return this.count < Queue.this.size();
      }
      @SuppressWarnings("unchecked")
      public E next() {
        this.count++;
        return (E)queue.poll();
      }
    };
  }
  
  //중첩 클래스 만들기!
  //중첩 클래스는 해당 클래스 내에서만 사용되는 것들을 따로 패키지를 만들지 않고
  //해당 클래스 내에서 사용되도록 만드는 것.
  //얘는 중첩 클래스 중 이너 클래스
  class IteratorImpl<T> implements Iterator<T>{
    //바깥 클래스가 <E>를 쓰고 있어서 헷갈리지 않기위해 <T>로 진행하자. 별다른 뜻x
    Queue<?> queue;
    int count;
    
    { //instance block
      //생성자가 실행될 떄마다 실행되는 블록
      //생성자 보다 먼저 실행된다.
      
      //그냥 this로 하면 현재 클래스를 가르키게 되므로 클래스를 명시하자.
      this.queue = Queue.this.clone();
    }
    
    @Override
    public boolean hasNext() {
      return this.count < Queue.this.size();
    }

    @SuppressWarnings("unchecked")
    @Override
    public T next() {
      this.count++;
      return (T)queue.poll();
    }
    
  }
  /*
  public static void main(String[] args) throws Exception {
    Stack<String> stack = new Stack<>();
    stack.push("aaa");
    stack.push("bbb");
    stack.push("ccc");
    stack.push("ddd");
    stack.push("eee");
    stack.push("fff");
    
    Stack<String> temp1 = stack.clone();
    while (temp1.size() > 0) {
      System.out.println(temp1.pop());
    }
    System.out.println("----------------------");
    
    Stack<String> temp2 = stack.clone();
    while (temp2.size() > 0) {
      System.out.println(temp2.pop());
    }
  }*/
}
