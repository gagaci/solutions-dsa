package org.example;

public class BinarySearch {

  public int search(int[] array, int target) {
    int low = 0;
    int high = array.length;

    while (low <= high) {
      int mid = low + (high - low) / 2;

      if (array[mid] == target) {
        return mid;
      } else if (array[mid] < target) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }
    return -1;
  }
}
