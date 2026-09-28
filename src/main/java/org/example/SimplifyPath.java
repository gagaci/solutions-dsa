package org.example;

import java.util.ArrayDeque;
import java.util.Deque;

public class SimplifyPath {

  public String simplifyPath(String path) {
    Deque<String> stack = new ArrayDeque<>();
    String[] components = path.split("/");

    for (String component : components) {
      if (component.isEmpty() || component.equals(".")) {
        continue;
      }

      if (component.equals("..")) {
        stack.pollLast();
      } else {
        stack.offerFirst(component);
      }
    }
    return "/" + String.join("/", stack);
  }
}
