package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

  public int groupAnagrams(String[] strs) {
    Map<String, List<String>> map = new HashMap<>();

    for (String str : strs) {
      char[] charArray = str.toCharArray();
      Arrays.sort(charArray);
      String sortedKey = String.valueOf(charArray);
      map.computeIfAbsent(sortedKey, key -> new ArrayList<>()).add(str);
    }
    return map.size();
  }
}
