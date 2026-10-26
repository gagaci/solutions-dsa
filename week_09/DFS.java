// Name: Bayramov Khabibulloh   Student ID: 4255085
// Graph Algorithms Lab - Task 2: Depth-First Search (DFS), iterative with an explicit stack
//
// Compile and run:  javac DFS.java && java DFS

public class DFS {

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

  // Our own stack built on an array (last in, first out).
  // top = index of the top element, -1 when the stack is empty.
  static class Stack {

    int[] array;

    int top;

    Stack(int capacity) {
      array = new int[capacity];
      top = -1;
    }

    // put on the TOP
    void push(int value) {
      array[++top] = value;
    }

    // take from the TOP
    int pop() {
      return array[top--];
    }

    boolean isEmpty() {
      return top == -1;
    }
  }

  // Runs DFS from start without recursion and returns the visit order.
  static int[] dfs(int start) {
    int n = ADJ.length;
    boolean[] visited = new boolean[n];

    // A node can be pushed once per edge into it, plus the start node,
    // so (sum of all neighbour list sizes + 1) is always enough room.
    int capacity = 1;
    for (int[] list : ADJ) {
      capacity += list.length;
    }
    Stack s = new Stack(capacity);

    int[] order = new int[n];
    int count = 0;

    s.push(start);
    while (!s.isEmpty()) {
      int u = s.pop();

      // A node is marked when it is popped, so a second copy can still be
      // in the stack. Skip it here.
      if (visited[u]) {
        continue;
      }
      visited[u] = true;
      order[count++] = u; // visit u

      // Push neighbours in REVERSE order (Z down to A) so that the
      // alphabetically first neighbour ends up on top and is popped first.
      for (int i = ADJ[u].length - 1; i >= 0; i--) {
        int v = ADJ[u][i];
        if (!visited[v]) {
          s.push(v);
        }
      }
    }

    int[] result = new int[count];
    System.arraycopy(order, 0, result, 0, count);
    return result;
  }

  static int index(String name) {
    for (int i = 0; i < NAMES.length; i++) {
      if (NAMES[i].equals(name)) {
        return i;
      }
    }
    return -1;
  }

  static void printOrder(String start) {
    int[] order = dfs(index(start));
    StringBuilder sb = new StringBuilder("DFS order from " + start + ":");
    for (int v : order) {
      sb.append(" ").append(NAMES[v]);
    }
    System.out.println(sb);
  }

  public static void main(String[] args) {
    printOrder("A");
    printOrder("G");
  }
}
