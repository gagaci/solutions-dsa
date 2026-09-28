package org.example;

import java.util.HashSet;
import java.util.Set;

public class HasCycleLinkedListWithHashSet {

  public boolean hasCycle(ListNode head) {
    Set<ListNode> set = new HashSet<>();
    ListNode temp = head;

    while (temp != null) {

      if (!set.add(temp)) {
        return true;
      }
      temp = temp.next;
    }
    return false;
  }
}
