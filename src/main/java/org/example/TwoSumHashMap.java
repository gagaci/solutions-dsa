package org.example;

import java.util.HashMap;
import java.util.List;

public class TwoSumHashMap {

  public List<Integer> sum(int[] nums, int target) {
    int tempTarget = target;
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length - 1; i++) {
      if (nums[i] < target && tempTarget > 0) {
        map.put(i, nums[i]);
        tempTarget -= nums[i];
      }
    }
    return map.keySet().stream().toList();
  }
}
