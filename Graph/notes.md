# Cycle in Graph
### find cycle in directed graph: using DFS and 3 sets of (unvisited-visiting-visited).
### find cycle in directed graph: using "Disjoint Set" and "DFS".

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

# Topological Sort
- Only exists for DAG(Directed Acyclic Graph)
- All trees are DAG
- will be implemented by using DFS and a boolean array (visited)

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

1. Traverse all vertices in a “graph”;
2. Traverse all paths between any two vertices in a “graph”.