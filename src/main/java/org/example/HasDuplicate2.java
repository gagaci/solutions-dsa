package org.example;

import java.util.HashSet;
import java.util.Set;

public class HasDuplicate2 {

  public static boolean hasDuplicate(int[] nums) {
    Set<Integer> numbers = new HashSet<>();
    for (int num : nums) {
      if (!numbers.add(num)) return true;
    }
    return false;
  }

  public static void main(String[] args) {
    int[] nums = new int[] {1, 2, 3, 4};
    System.out.println(hasDuplicate(nums));
  }
}
