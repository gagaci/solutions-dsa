package org.example;

import java.util.Objects;

public class LinkedListOperations {

  private ListNode listNode;

  public LinkedListOperations(ListNode listNode) {
    this.listNode = listNode;
  }

  public ListNode getNode() {
    return listNode;
  }

  public void setNode(ListNode listNode) {
    this.listNode = listNode;
  }

  public void traverse() {
    ListNode temp = this.listNode;
    while (temp != null) {
      System.out.println("value : " + temp.value);
      temp = temp.next;
    }
  }

  public void insertValue(ListNode newListNode) {
    newListNode.next = this.listNode;
    this.listNode = newListNode;
  }

//  public String deleteSongByName(String songName) {
//    String song = "";
//    if (this.node == null) {
//      System.out.println("List is empty");
//    } else if (Objects.equals(this.node.songName, songName)) {
//      song = this.node.songName;
//      this.node = this.node.next;
//      return song;
//    }
//    Node curr = this.node;
//    Node prev = null;
//
//    while (curr != null) {
//      if (Objects.equals(curr.songName, songName)) {
//        song = curr.songName;
//        Objects.requireNonNull(prev).next = curr.next;
//        break;
//      }
//      prev = curr;
//      curr = curr.next;
//    }
//
//    return song;
//  }

//  public void playNextSong(Node node) {
//    if (node == null) {
//      System.out.println("PlayList is empty");
//    } else {
//      System.out.println("\n");
//      System.out.println("Song name " + node.next.songName);
//      System.out.println("artist name " + node.next.artistName);
//      System.out.println("duration " + node.next.duration);
//    }
//  }

  public void searchValue(int target) {
    ListNode curr = this.listNode;
    while (curr != null) {
      if (Objects.equals(curr.value, target)) {
        System.out.println("\n");
        System.out.println("value was found :" + target);

      }
      curr = curr.next;
    }
  }
}
