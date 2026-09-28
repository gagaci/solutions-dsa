package org.example;

public class RecursiveSubString {

  public int recursiveLength(String text) {
    if (text.isEmpty()) {
      return 0;
    }

    return recursiveLength(text.substring(1)) + 1;

    /// [1]: a b c d (count: 0) : substring(1) -> [2] b c d (count: 1) ->: [3] c d (count: 2) -> [4]
    // d (count: 3)
    /// [4] empty (count: 4) -> text is empty -> return accumulated count
  }
}
