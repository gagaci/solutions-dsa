package org.example;

public class FibonacciIterative {

  public int fibonacciIterative(int n) {
    if (n <= 1) {
      return n;
    }

    int prevPrev = 0;
    int prev = 1;
    int current = 0;

    for (int i = 2; i <= n; i++) {
      current = prevPrev + prev;
      prevPrev = prev;
      prev = current;
    }

    return current;
  }
}
