package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ValidParentheses {

  public boolean isValid(String s) {
    Stack<Character> stack = new Stack<>();

    char[] charArray = s.toCharArray();

    if (charArray.length % 2 != 0) {
      return false;
    }

    List<Character> openingParentheses = new ArrayList<>();
    openingParentheses.add('(');
    openingParentheses.add('{');
    openingParentheses.add('[');

    List<Character> closingParentheses = new ArrayList<>();
    closingParentheses.add(')');
    closingParentheses.add('}');
    closingParentheses.add(']');

    List<String> completeParentheses = new ArrayList<>();
    completeParentheses.add("()");
    completeParentheses.add("{}");
    completeParentheses.add("[]");

    for (char c : charArray) {
      if (openingParentheses.contains(c)) {
        stack.add(c);
      }
      if (closingParentheses.contains(c)) {
        if (stack.empty()) {
          return false;
        }
        Character peek = stack.peek();
        String x = "" + peek + c;
        if (completeParentheses.contains(x)) {
          stack.pop();
        } else {
          return false;
        }
      }
    }
    return stack.empty();
  }
}
