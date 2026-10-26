# Week 09 – Graph Algorithms Lab: BFS, DFS, Dijkstra

Name: ____________________   Student ID: ____________________

| Task | File | Run |
|------|------|-----|
| 1 – BFS | `BFS.java` | `javac BFS.java && java BFS` |
| 2 – DFS | `DFS.java` | `javac DFS.java && java DFS` |
| 3 – Dijkstra | `Dijkstra.java` | `javac Dijkstra.java && java Dijkstra` |

Graph 1 (Tasks 1, 2): A-B, A-C, B-D, B-E, C-F, E-F, F-G (undirected, unweighted).
Graph 2 (Task 3): A-B 4, A-C 2, B-C 1, B-D 5, C-D 8, C-E 10, D-E 2, D-F 6, E-F 3 (undirected).

---

## Task 1 – BFS

### A. Hand trace on Graph 1, start A

| Step | Node dequeued | Newly enqueued | Queue after the step (front ... back) |
|------|---------------|----------------|---------------------------------------|
| init | –             | A              | A |
| 1    | A             | B, C           | B C |
| 2    | B             | D, E           | C D E |
| 3    | C             | F              | D E F |
| 4    | D             | –              | E F |
| 5    | E             | – (F already discovered) | F |
| 6    | F             | G              | G |
| 7    | G             | –              | (empty) |

**Visit order:** A B C D E F G

### B. Program output

```
BFS order from A: A B C D E F G
Shortest A -> G: distance 3, path A -> C -> F -> G
Shortest D -> G: distance 4, path D -> B -> E -> F -> G
```

### C. Short answers

- **Why mark on enqueue, not on dequeue?** If we only marked a node when it is dequeued, it could be
  added to the queue several times by different neighbours before it is processed (e.g. F would be
  enqueued by both C and E). That wastes time and memory, and the later copies could overwrite
  `dist`/`parent` with a worse value. Marking on enqueue guarantees each node enters the queue exactly
  once, and the first `dist`/`parent` assigned (the one with the fewest edges) is kept.
- **Running time:** O(V + E). Each node is enqueued and dequeued once (O(V)), and each adjacency list is
  scanned once, so every edge is looked at a constant number of times (O(E)).
- **Why BFS fails on weighted graphs:** BFS minimises the *number of edges*, not the *sum of weights*.
  In Graph 2, BFS from A reaches B directly (1 edge, cost 4), but the cheapest path is A -> C -> B
  (2 edges, cost 3). BFS fixes a node's distance the first time it sees it and never improves it.

---

## Task 2 – DFS (iterative, explicit stack)

### A. Hand trace on Graph 1, start A

Neighbours are pushed in reverse order (Z down to A), skipping already-visited nodes.

| Step | Node popped | Action | Pushed (in this order) | Stack after (top first) |
|------|-------------|--------|------------------------|-------------------------|
| init | –           | push start | A        | A |
| 1    | A           | visit A | C, B             | B C |
| 2    | B           | visit B | E, D  (A visited) | D E C |
| 3    | D           | visit D | – (B visited)    | E C |
| 4    | E           | visit E | F  (B visited)   | F C |
| 5    | F           | visit F | G, C  (E visited) | C G C |
| 6    | C           | visit C | – (F, A visited) | G C |
| 7    | G           | visit G | – (F visited)    | C |
| 8    | C           | **skip** (already visited) | – | (empty) |

**Visit order:** A B D E F C G

### B. Program output

```
DFS order from A: A B D E F C G
DFS order from G: G F C A B D E
```

### C. Short answers

- **Why can a node be in the stack twice?** A node is only marked visited when it is *popped*, not when
  it is pushed. So two different visited nodes can each push the same unvisited neighbour before it is
  popped. Here C is pushed by A in step 1 and again by F in step 5. The copy pushed by F is popped first
  (step 6) and C is visited; the older copy from step 1 is popped in **step 8** and skipped.
- **BFS vs DFS order:** BFS gives A B C D E F G (level by level: A, then B C, then D E F, then G).
  DFS gives A B D E F C G (goes deep A -> B -> D, backtracks to E -> F, then C, then G).
  The difference comes from the data structure: BFS uses a **queue** (FIFO), so the oldest discovered
  node is processed next, which spreads out in layers; DFS uses a **stack** (LIFO), so the most recently
  discovered node is processed next, which keeps going deeper along one branch.

---

## Task 3 – Dijkstra

### A. Hand trace on Graph 2, source A

| Step | Node settled (its dist) | Updates made (node = new dist via previous node) |
|------|-------------------------|--------------------------------------------------|
| init | –                       | A = 0, all others = INF |
| 1    | A (0)                   | B = 4 via A, C = 2 via A |
| 2    | C (2)                   | B = 3 via C, D = 10 via C, E = 12 via C |
| 3    | B (3)                   | D = 8 via B |
| 4    | D (8)                   | E = 10 via D, F = 14 via D |
| 5    | E (10)                  | F = 13 via E |
| 6    | F (13)                  | – (no unsettled neighbours) |

| Node       | A | B | C | D | E  | F  |
|------------|---|---|---|---|----|----|
| Final dist | 0 | 3 | 2 | 8 | 10 | 13 |
| Final prev | – | C | A | B | D  | E  |

### B. Program output

```
init | A=0 B=INF C=INF D=INF E=INF F=INF
settle A (0) | A=0 B=4 C=2 D=INF E=INF F=INF
settle C (2) | A=0 B=3 C=2 D=10 E=12 F=INF
settle B (3) | A=0 B=3 C=2 D=8 E=12 F=INF
settle D (8) | A=0 B=3 C=2 D=8 E=10 F=14
settle E (10) | A=0 B=3 C=2 D=8 E=10 F=13
settle F (13) | A=0 B=3 C=2 D=8 E=10 F=13
A to B: cost 3: A -> C -> B
A to C: cost 2: A -> C
A to D: cost 8: A -> C -> B -> D
A to E: cost 10: A -> C -> B -> D -> E
A to F: cost 13: A -> C -> B -> D -> E -> F
```

### C. Short answers

- **Relaxation (why B changes from 4 to 3):** After settling A, dist[B] = 4 (direct edge A-B). In step 2
  we settle C with dist[C] = 2 and relax edge C-B (weight 1): dist[C] + 1 = 3 < 4 = dist[B], so we found
  a cheaper way to B. We set dist[B] = 3 and prev[B] = C. Relaxation means: "if going through u is
  cheaper than the best known cost of v, update v's cost and remember u as its previous node."
  The same happens to D in step 3: dist[B] + 5 = 8 < 10, so D changes from 10 (via C) to 8 (via B).
- **Negative weights:** Dijkstra assumes that once a node is settled with the smallest dist, no later
  path can be cheaper, because any other path must go through an unsettled node with dist >= current
  and then add non-negative weights. With a negative edge this is false: a path through a node settled
  later could reach an already-settled node more cheaply, but settled nodes are never updated again,
  so the result is wrong. (Bellman-Ford handles negative weights.)
- **BFS vs Dijkstra when every weight is 1:** With all weights equal to 1, the cost of a path equals its
  number of edges, so Dijkstra computes exactly the BFS distances. Dijkstra settles nodes in the order
  0, 1, 2, ... — the same level-by-level order BFS produces, and the priority queue behaves like a
  plain FIFO queue. BFS is simply Dijkstra specialised to unit weights, running in O(V + E) instead of
  O(V^2) (simple min search) or O((V + E) log V) (heap).
