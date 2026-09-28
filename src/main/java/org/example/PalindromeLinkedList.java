package org.example;

public class PalindromeLinkedList {

  public ListNode findMiddleOfLinkedList(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;

    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }

    return slow;
  }

  public ListNode reverseMiddleNode(ListNode middleNode) {
    return ReverseLinkedList.reverseList(middleNode);
  }

  public boolean isPalindrome(ListNode head) {
    ListNode currMiddle = findMiddleOfLinkedList(head);
    ListNode left = head;
    ListNode right = reverseMiddleNode(currMiddle);
    while (right != null) {
      if (left.value != right.value) {
        return false;
      }
      left = left.next;
      right = right.next;
    }
    return true;
  }

  public static void main(String[] args){
    ListNode head = new ListNode(1);
    ListNode second = new ListNode(2);
    ListNode third = new ListNode(3);
    ListNode fourth = new ListNode(4);
    head.setNext(second);
    second.setNext(third);
    third.setNext(fourth);

    PalindromeLinkedList palindromeLinkedList = new PalindromeLinkedList();

    boolean palindrome = palindromeLinkedList.isPalindrome(head);

    System.out.println("result: " +  palindrome);
  }
}
