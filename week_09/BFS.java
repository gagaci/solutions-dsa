// Name: ____________________   Student ID: ____________________
// Graph Algorithms Lab - Task 1: Breadth-First Search (BFS)
//
// Compile and run:  javac BFS.java && java BFS

public class BFS {

  // Graph 1 (undirected, no weights). Nodes A..G are mapped to 0..6.
  static final String[] NAMES = {"A", "B", "C", "D", "E", "F", "G"};

  // Neighbour lists, already sorted alphabetically (A before B).
  static final int[][] ADJ = {
      {1, 2},       // A: B, C
      {0, 3, 4},    // B: A, D, E
      {0, 5},       // C: A, F
      {1},          // D: B
      {1, 5},       // E: B, F
      {2, 4, 6},    // F: C, E, G
      {5}           // G: F
  };

  // Our own queue built on an array (first in, first out).
  // front = index of the next element to dequeue, back = index where the next element is added.
  static class Queue {

    int[] array;

    int front;

    int back;

    Queue(int capacity) {
      array = new int[capacity];
      front = 0;
      back = 0;
    }

    // add at the BACK
    void enqueue(int value) {
      array[back++] = value;
    }

    // take from the FRONT
    int dequeue() {
      return array[front++];
    }

    boolean isEmpty() {
      return front == back;
    }
  }

  // Results of one BFS run.
  static int[] dist;

  static int[] parent;

  // Runs BFS from start, fills dist[] and parent[] and returns the visit order.
  static int[] bfs(int start) {
    int n = ADJ.length;
    boolean[] discovered = new boolean[n];
    dist = new int[n];
    parent = new int[n];
    for (int i = 0; i < n; i++) {
      dist[i] = -1;    // -1 = not reached
      parent[i] = -1;  // -1 = no parent
    }

    // Every node is enqueued at most once, so capacity n is enough.
    Queue q = new Queue(n);
    int[] order = new int[n];
    int count = 0;

    // Mark the start as discovered when it is put in the queue.
    discovered[start] = true;
    dist[start] = 0;
    q.enqueue(start);

    while (!q.isEmpty()) {
      int u = q.dequeue();
      order[count++] = u; // visit u

      // Neighbours are examined in alphabetical order.
      for (int v : ADJ[u]) {
        if (!discovered[v]) {
          // Mark at enqueue time so v is never added to the queue twice.
          discovered[v] = true;
          dist[v] = dist[u] + 1;
          parent[v] = u;
          q.enqueue(v);
        }
      }
    }

    int[] result = new int[count];
    System.arraycopy(order, 0, result, 0, count);
    return result;
  }

  // Runs BFS from 'from' and prints the shortest path (fewest edges) to 'to'.
  // The path is rebuilt from the target back to the start using parent[].
  static void printShortest(int from, int to) {
    bfs(from);
    String prefix = "Shortest " + NAMES[from] + " -> " + NAMES[to] + ": ";
    if (dist[to] == -1) {
      System.out.println(prefix + "no path");
      return;
    }

    // Walk back along parent[] and store the nodes, then print them in reverse.
    int[] path = new int[ADJ.length];
    int len = 0;
    for (int v = to; v != -1; v = parent[v]) {
      path[len++] = v;
    }

    StringBuilder sb = new StringBuilder();
    for (int i = len - 1; i >= 0; i--) {
      sb.append(NAMES[path[i]]);
      if (i > 0) {
        sb.append(" -> ");
      }
    }
    System.out.println(prefix + "distance " + dist[to] + ", path " + sb);
  }

  static int index(String name) {
    for (int i = 0; i < NAMES.length; i++) {
      if (NAMES[i].equals(name)) {
        return i;
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    int a = index("A");
    int[] order = bfs(a);
    StringBuilder sb = new StringBuilder("BFS order from A:");
    for (int v : order) {
      sb.append(" ").append(NAMES[v]);
    }
    System.out.println(sb);

    printShortest(a, index("G"));
    printShortest(index("D"), index("G"));
  }
}
