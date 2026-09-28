package org.example;

/// Add a song to the playlist = done
///
/// Delete a song
///
/// Display the playlist = done
///
/// Play next song
///
/// Play previous song (optional – for doubly linked list)
///
/// Search for a song
///
/// Count total songs

public class ListNode {

  int value;
  ListNode next;
  ListNode prev;


  public ListNode(int value, ListNode next, ListNode prev) {
    this.value = value;
    this.next = next;
    this.prev = prev;
  }

  public ListNode(int value) {
    this.value = value;
  }

  public ListNode(int value, ListNode next) {
    this.value = value;
    this.next = next;
  }

  public int getValue() {
    return value;
  }

  public void setValue(int value) {
    this.value = value;
  }

  public ListNode getNext() {
    return next;
  }

  public void setNext(ListNode next) {
    this.next = next;
  }

  public ListNode getPrev() {
    return prev;
  }

  public void setPrev(ListNode prev) {
    this.prev = prev;
  }
}
