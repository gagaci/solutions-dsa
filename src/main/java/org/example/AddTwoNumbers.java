package org.example;

public class AddTwoNumbers {

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

    // dummyHead helps us to create final list
    ListNode dummyHead = new ListNode(0);

    // carry is needed to track sums which exceed than 10
    int carry = 0;

    // current tracks the node's position
    ListNode current = dummyHead;

    while (l1 != null || l2 != null || carry != 0){
      int digit1 = (l1 == null) ? 0 : l1.value;
      int digit2 = (l2 == null) ? 0 : l2.value;

      // we are adding here
      int sum = (digit1 + digit2 + carry);

      // this helps us to determine the carrier, | 7 / 10 = 0 |  10 / 10 = 1 < carrier |
      carry = sum / 10;


      current.next = new ListNode(sum % 10); // this line constructs a final result. example: 7 % 10 = 7 <- new node

      current = current.next; // pointing the current to newly added node

      l1 = (l1 != null) ? l1.next : null;
      l2 = (l2 != null) ? l2.next : null;

    }
      return dummyHead.next;
  }


}
