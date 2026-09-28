package org.example;

import java.util.ArrayList;
import java.util.List;

public class KeyboardRow {

  public String[] findWords(String[] words) {
   String rows = "12210111011122000010020202";
    List<String> result = new ArrayList<>();

    for (String word : words) {
      String lower = word.toLowerCase();
      char target = rows.charAt(lower.charAt(0) - 'a');
      boolean isValid = true;

      for (char c : lower.toCharArray()){
        if (rows.charAt(c - 'a') != target){
          isValid = false;
          break;
        }
      }
      if (isValid) result.add(word);

    }
    return result.toArray(new String[0]);
  }


}
