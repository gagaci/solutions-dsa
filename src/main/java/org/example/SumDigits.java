package org.example;

public class SumDigits {

  public int sumDigits(int n) {
    /// if 10 -> get 1, if 9 return it. Add up all stack numbers
    if (n < 10) {
      return n;
    }
    /// 1234 % 10 -> 4
    int lastDigit = n % 10;

    /// 1234 -> 3
    int nextDigit = n / 10;

    return lastDigit + sumDigits(nextDigit);
  }
}
