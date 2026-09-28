package org.example;

public class RemoveNthNodeLinkedList {

  public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode dummy = head.next;
    ListNode slow = dummy;
    ListNode fast = dummy;

    while (n > 0){
      fast = fast.next;
      n--;
    }

    while (fast.next != null){
      slow = slow.next;
      fast = fast.next;
    }

    slow.next = slow.next.next;

    return dummy.next;
  }
}
