package org.example;

public class RecursiveReverse {

  public String recursiveReverse(String text) {
    if (text.isEmpty()) {
      return text;
    }

    return recursiveReverse(text.substring(1)) + text.charAt(0);
  }
}
