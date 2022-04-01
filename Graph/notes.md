# Cycle in Graph
### find cycle in directed graph: using DFS and 3 states array (unvisited-visiting-visited) for nodes. Example : Course Schedule
### find cycle in UNdirected graph: using "Disjoint Set" or "DFS" and Set<Integer> visited. Example : (261. Graph Valid Tree)

# Number of Connected Components in an Undirected Graph(323)
### using DFS and Visited set, run DFS on each unvisited node and at each start add one to the result.

# Breadth-first Search
# BFS is solution for SHORTEST PATH problems.
- Breadth-first search tells you if there’s a path from A to B.
- If there’s a path, breadth-first search will find the shortest path.
- If you have a problem like “find the shortest X,” try modeling your problem as a graph, and use breadth-first search to solve.
- A directed graph has arrows, and the relationship follows the direction of the arrow (rama -> adit means “rama owes adit money”).
- Undirected graphs don’t have arrows, and the relationship goes both ways (ross - rachel means “ross dated rachel and rachel dated ross”).
- Queues are FIFO (First In, First Out).
- Stacks are LIFO (Last In, First Out).
- You need to check people in the order they were added to the search list, so the search list needs to be a queue. Otherwise, you won’t get the shortest path.
- Once you check someone, make sure you don’t check them again. Otherwise, you might end up in an infinite loop.
- the “breadth-first search” algorithm can traverse all vertices of a “graph” and traverse all paths between two vertices. However,
  the most efficient use case of “breadth-first search” is to quickly find the shortest path between two vertices in a “graph” where all edges have equal and positive weights.

# Topological Sort
- Only exists for DAG (Directed Acyclic Graph)
- All trees are DAG
- if graph is DAG, will be implemented by using stack and visited set

# Dijkstra’s algorithm (Single Source Shortest Path)
- Breadth-first search is used to calculate the shortest path for an unweighted graph.
- Dijkstra’s algorithm is used to calculate the shortest path for a weighted graph.
- Dijkstra’s algorithm works when all the weights are POSITIVE.
- If you have negative weights, use the Bellman-Ford algorithm.


# Minimum Spanning Tree
    - Kruskal Algorithm : using disjoint set
    - Prim Algorithm

# Time Analysis
DFS: Theta (V + E)

# In Graph theory, the depth-first search algorithm (abbreviated as DFS) is mainly used to:

1. Traverse all vertices in a “graph”
2. Traverse all paths between any two vertices in a “graph”. (BACKTRACKING)


# Tree
 any basic text will tell you that an undirected tree with 𝑛 nodes must have exactly "n - 1" edges

# In Graph theory, the primary use cases of the “breadth-first search” (“BFS”) algorithm are:

1. Traversing all vertices in the “graph”
2. Finding the **shortest path** between two vertices in a graph where all edges have equal and positive weights.