package org.example;

public class PowerFormulas {

  public int power(int n, int x) {
    if (n == 0) {
      return 1;
    }

    return x * power(n - 1, x);
  }
}
