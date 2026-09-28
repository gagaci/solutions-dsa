package org.example;

import java.util.HashSet;
import java.util.Set;

public class HasDuplicate {

  public boolean hasDuplicate(int[] nums) {
    Set<Integer> numbers = new HashSet<>();

    for (int num : nums) {
      if (!numbers.add(num))
        return true;
    }
    return false;
  }

}
