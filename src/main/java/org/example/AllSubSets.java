package org.example;

import java.util.ArrayList;
import java.util.List;

public class AllSubSets {

  public List<List<Integer>> subsets(List<Integer> items) {
    if (items.isEmpty()) {
      List<List<Integer>> base = new ArrayList<>();
      base.add(new ArrayList<>());        // one subset exists: the empty one
      return base;
    }

    int first = items.get(0);
    List<List<Integer>> rest = subsets(items.subList(1, items.size()));

    List<List<Integer>> all = new ArrayList<>(rest);   // the "without first" half
    for (List<Integer> s : rest) {                     // the "with first" half
      List<Integer> copy = new ArrayList<>(s);
      copy.add(0, first);
      all.add(copy);
    }
    return all;
  }


}
