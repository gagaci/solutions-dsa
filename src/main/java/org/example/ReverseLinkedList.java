package org.example;

public class ReverseLinkedList {

  static ListNode reverseList(ListNode head) {
    ListNode curr = head;
    ListNode prev = null;
    ListNode next;

    while (curr != null) {
      next = curr.next;

      curr.next = prev;

      prev = curr;
      curr = next;
    }

    return prev;
  }

  static ListNode findMiddleOfLinkedList(ListNode head) {
    ListNode fast = head;
    ListNode slow = head;

    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
    }

    return slow;
  }

  private static void display(ListNode head) {
    ListNode curr = head;
    while (curr != null) {
      System.out.println(curr.value);
      curr = curr.next;
    }
  }

  public static void main(String[] args) {
    ListNode head = new ListNode(1);
    ListNode second = new ListNode(2);
    ListNode third = new ListNode(3);
    ListNode fourth = new ListNode(4);
    head.setNext(second);
    second.setNext(third);
    third.setNext(fourth);

    ListNode reversed = reverseList(head);
    display(reversed);
  }
}
