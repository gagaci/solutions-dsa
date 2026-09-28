package org.example;

public class TowerOfHanoi {
  int count = 0;

  void towerOfHanoi(int n, char source, char aux, char dest) {
    if (n == 1) {
      System.out.println(++count + ": Move disk 1 from " + source + " to " + dest);
      return;
    }
    towerOfHanoi(n - 1, source, dest, aux);
    System.out.println(++count + ": Move disk " + n + " from " + source + " to " + dest);
    towerOfHanoi(n - 1, aux, source, dest);
  }
}
