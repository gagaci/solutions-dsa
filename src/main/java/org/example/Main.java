package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    SumDigits sumDigits = new SumDigits();
    System.out.println(sumDigits.sumDigits(1234));

    BinarySearch binarySearch = new BinarySearch();
    int[] array = {1, 2, 3, 4, 5};
    int search = binarySearch.search(array, 3);
    System.out.println(search);

    TowerOfHanoi towerOfHanoi = new TowerOfHanoi();
    towerOfHanoi.towerOfHanoi(4, 'a', 'b', 'c');

    RecursiveSubString recursiveSubString = new RecursiveSubString();
    System.out.println(recursiveSubString.recursiveLength("abcd"));

    RecursiveReverse recursiveReverse = new RecursiveReverse();
    System.out.println(recursiveReverse.recursiveReverse("cat"));

    FibonacciIterative fibonacciIterative = new FibonacciIterative();
    System.out.println(fibonacciIterative.fibonacciIterative(7));

    Fibonacci fibonacci = new Fibonacci();
    System.out.println(fibonacci.fibonacci(6));

    ArrayList<Integer> items = new ArrayList<>();

    items.add(1);
    items.add(2);
    items.add(3);

    AllSubSets allSubSets = new AllSubSets();
    List<List<Integer>> subsets = allSubSets.subsets(items);
    System.out.println(subsets);

    ValidParentheses validParentheses = new ValidParentheses();
    System.out.println(validParentheses.isValid("([]"));

    TwoSumHashMap twoSumHashMap = new TwoSumHashMap();
    int[] array1 = new int[] {2, 7, 11, 54};
    List<Integer> sum = twoSumHashMap.sum(array1, 9);
    System.out.println(sum);

    ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
    ListNode listNode = new ListNode(1);
    ListNode next = new ListNode(2);
    ListNode nextNext = new ListNode(3);
    listNode.setNext(next);
    next.setNext(nextNext);

    int[][] grid = {
      {1, 2, 3},
      {4, 5, 6},
      {7, 8, 9}
    };

    for (int r = 0; r < grid.length; r++) {
      for (int c = 0; c < grid[r].length; c++) {
        System.out.print(grid[r][c] + " ");
      }
      System.out.println();
    }

    System.out.println("\n");

    SpiralMatrixOrder spiral = new SpiralMatrixOrder();
    List<Integer> integers = spiral.spiralOrder(grid);
    System.out.println("\n");
    System.out.println(integers);
  }
}
