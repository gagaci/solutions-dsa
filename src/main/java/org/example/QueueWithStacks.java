package org.example;

import java.util.Stack;

public class QueueWithStacks {

  Stack<Integer> s1 = new Stack<>();
  Stack<Integer> s2 = new Stack<>();

  void enqueue(int x) {

    while (!s1.empty()) {
      s2.push(s1.pop());
    }

    s1.push(x);

    while (!s2.empty()) {
      s1.push(s2.pop());
    }
  }

  void dequeue() {
    if (s1.empty()) {
      return;
    }

    s1.pop();
  }

  int front() {
    if (s1.isEmpty()) {

      // Queue empty
      return -1;
    }
    return s1.peek();
  }

  int size() {
    return s1.size();
  }

  void display() {

    for (int i = s1.size() - 1; i >= 0; i--) {
      System.out.print(s1.get(i) + " ");
    }
    System.out.println();
  }

  public static void main(String[] args) {
    QueueWithStacks q = new QueueWithStacks();
    q.enqueue(1);
    q.enqueue(2);
    q.enqueue(3);

    q.display();
  }
}
