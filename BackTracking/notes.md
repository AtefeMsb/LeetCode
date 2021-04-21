BackTracking Notes:

Usage: 
backtracking is when you want all the answres (exhasting all the solution)
while dynamic programming is when solving an optimization problem

- Brute Force approach finds all the possible solutions and selects desired solution per given the constraints.
- Dynamic Programming also uses Brute Force approach to find the OPTIMUM solution, either maximum or minimum.
- Backtracking also uses Brute Force approach but to find ALL the solutions.
- Solutions to the Backtracking problems can be represented as "State-Space Tree".
- The constrained applied to find the solution is called Bounding function.
- Backtracking follows Depth-First Search method.
- Branch and Bound is also a Brute Force approach, which uses Breadth-First Search method.

3 Keys To Backtracking:
- choice: pick one of the choices
- constraints: check with constraints and if it did break any rules, remove the last choice
- goal