package org.example;

import java.util.Stack;

public class RemoveStars {
  public String removeStars(String s) {
    Stack<Character> stack = new Stack<>();

    for(char c : s.toCharArray()){
      if (c == '*'){
        stack.pop();
      } else {
        stack.add(c);
      }

    }
    StringBuilder sb = new StringBuilder();
    for (char c : stack) {
      sb.append(c);
    }
    return sb.toString();
  }
}
