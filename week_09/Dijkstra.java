// Name: Bayramov Khabibulloh   Student ID: 4255085
// Graph Algorithms Lab - Task 3: Dijkstra's algorithm (cheapest paths)
//
// Compile and run:  javac Dijkstra.java && java Dijkstra

public class Dijkstra {

  // Graph 2 (undirected, weighted). Nodes A..F are mapped to 0..5.
  static final String[] NAMES = {"A", "B", "C", "D", "E", "F"};

  // Edges as {from, to, weight}: A-B 4, A-C 2, B-C 1, B-D 5, C-D 8, C-E 10, D-E 2, D-F 6, E-F 3.
  static final int[][] EDGES = {
      {0, 1, 4}, {0, 2, 2}, {1, 2, 1}, {1, 3, 5}, {2, 3, 8},
      {2, 4, 10}, {3, 4, 2}, {3, 5, 6}, {4, 5, 3}
  };

  // A very large number used as INFINITY.
  static final int INF = Integer.MAX_VALUE;

  // Weight matrix: w[u][v] = weight of edge u-v, or 0 when there is no edge.
  static int[][] w;

  static int[] dist;

  // prev[v] = node before v on the cheapest path, -1 = none.
  static int[] prev;

  static void buildGraph() {
    int n = NAMES.length;
    w = new int[n][n];
    for (int[] e : EDGES) {
      // undirected: store the edge in both directions
      w[e[0]][e[1]] = e[2];
      w[e[1]][e[0]] = e[2];
    }
  }

  static void dijkstra(int source) {
    int n = NAMES.length;
    dist = new int[n];
    prev = new int[n];
    boolean[] settled = new boolean[n];
    for (int v = 0; v < n; v++) {
      dist[v] = INF;
      prev[v] = -1;
    }
    dist[source] = 0;
    System.out.println("init | " + distLine());

    while (true) {
      // Simple linear search for the unsettled node with the SMALLEST dist.
      int u = -1;
      for (int v = 0; v < n; v++) {
        if (!settled[v] && dist[v] != INF && (u == -1 || dist[v] < dist[u])) {
          u = v;
        }
      }
      // No unsettled node with dist < INF is left: we are done.
      if (u == -1) {
        break;
      }

      // Settle u: its dist is now final.
      settled[u] = true;

      // Relax every edge (u, v, weight) to an unsettled neighbour v:
      // if going through u is cheaper than the best known cost of v,
      // update dist[v] and remember u as the previous node.
      // Neighbours are checked in alphabetical order (A to Z).
      for (int v = 0; v < n; v++) {
        if (w[u][v] > 0 && !settled[v] && dist[u] + w[u][v] < dist[v]) {
          dist[v] = dist[u] + w[u][v];
          prev[v] = u;
        }
      }

      System.out.println("settle " + NAMES[u] + " (" + dist[u] + ") | " + distLine());
    }
  }

  // Builds "A=0 B=4 C=2 D=INF ..." from the current dist[].
  static String distLine() {
    StringBuilder sb = new StringBuilder();
    for (int v = 0; v < NAMES.length; v++) {
      if (v > 0) {
        sb.append(" ");
      }
      sb.append(NAMES[v]).append("=").append(dist[v] == INF ? "INF" : String.valueOf(dist[v]));
    }
    return sb.toString();
  }

  // Prints the cheapest path from source to target by walking prev[] back from the target.
  static void printPath(int source, int target) {
    String prefix = NAMES[source] + " to " + NAMES[target] + ": ";
    if (dist[target] == INF) {
      System.out.println(prefix + "no path");
      return;
    }

    int[] path = new int[NAMES.length];
    int len = 0;
    for (int v = target; v != -1; v = prev[v]) {
      path[len++] = v;
    }

    StringBuilder sb = new StringBuilder();
    for (int i = len - 1; i >= 0; i--) {
      sb.append(NAMES[path[i]]);
      if (i > 0) {
        sb.append(" -> ");
      }
    }
    System.out.println(prefix + "cost " + dist[target] + ": " + sb);
  }

  public static void main(String[] args) {
    buildGraph();
    int source = 0; // A
    dijkstra(source);
    for (int v = 0; v < NAMES.length; v++) {
      if (v != source) {
        printPath(source, v);
      }
    }
  }
}
