package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class StackIsValid {

  public boolean isValid(String s) {
    Stack<Character> stack = new Stack<>();

    char[] charArray = s.toCharArray();

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
        Character peek = stack.peek();
        String x = "" + peek + c;
        if (completeParentheses.contains(x)) {
          stack.pop();
        }
      }
    }
    return stack.empty();
  }
}
