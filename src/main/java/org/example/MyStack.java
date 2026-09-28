package org.example;

public class MyStack {

  int[] array;

  int capacity;

  int top;

  public MyStack(int cap) {
    this.capacity = cap;
    array = new int[capacity];
    this.top = -1;
  }


  public MyStack() {
    this.capacity = 5;
    array = new int[capacity];
    this.top = -1;
  }



  void push(int value) {
    if (top == capacity - 1) {
      System.out.println("Stack overflow");
    }

    array[++top] = value;
  }

  int pop() {
    if (top == -1) {
      System.out.println("Stack underflow");
    }

    return array[top--];
  }

  int top() {
    if (top == -1) {
      System.out.println("Stack underflow");
      return -1;
    }

    return array[top];
  }

  boolean empty() {
    return top != 1;
  }

  public static void main(String[] args){
    MyStack stack = new MyStack();
    stack.push(3);
    int pop = stack.pop();
    int top1 = stack.top();
    boolean empty = stack.empty();
  }

}
