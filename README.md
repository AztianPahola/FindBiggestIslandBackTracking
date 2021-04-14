# Problem Statement
Given a matrix where each element can be 0 or 1. Two cells are said to be connected if they are adjacent to each other horizontally, vertically, or diagonally. The connected cells that are filled with 1s form a region (also called island or cluster).  There may be several regions in the matrix.  Design a backtracking algorithm to find the largest region.

# Solution Statement
Input: Matrix 'islands' of size n x m  made up of 1's and 0's
Output: Matrix 'biggestIsland' of size n x m, all flipped to 0's except 1's where the biggest island is.

There is two important parts to the solution: the 'discovered' matrix and the 'separateIslands' matrix.  
The 'discovered' matrix is be a n x m matrix which will contain all 0's in the beginning, but when a plot of land is found through iteration, it it is flipped to a 1. This matrix is referenced to make sure we do not count the same plot of land multiple times.  
The 'biggestIsland' matrix is a n x m matrix which contains the biggest island discovered through an iteration.

In summary: the algorithm will iterate through the islands matrix, decide if a given plot of land is promising based on if it's a 1 or 0 and if it has already been discovered or not. If a given island is found, it's size is compared to the current biggest and replaces it if it is bigger.

# Testing

## Test Case 1
| 1 | 1 | 0 | 0 | 0 |
|---|---|---|---|---|
| 0 | 1 | 1 | 0 | 0 |
| 0 | 0 | 1 | 0 | 1 |
| 1 | 0 | 0 | 0 | 1 |
| 0 | 1 | 0 | 1 | 1 |
| 1 | 0 | 0 | 0 | 0 |

### Results in
The biggest island is of size 5

Isolated on the map it appears as below:
1 1 0 0 0 
0 1 1 0 0 
0 0 1 0 0 
0 0 0 0 0 
0 0 0 0 0 
0 0 0 0 0 

## Test Case 2
| 1 | 1 | 0 | 0 | 0 |
|---|---|---|---|---|
| 0 | 1 | 1 | 0 | 0 |
| 0 | 0 | 1 | 0 | 1 |
| 1 | 0 | 0 | 0 | 1 |
| 1 | 1 | 0 | 0 | 1 |
| 1 | 1 | 1 | 0 | 0 |

### Results in
The biggest island is of size 6

Isolated on the map it appears as below:
0 0 0 0 0 
0 0 0 0 0 
0 0 0 0 0 
1 0 0 0 0 
1 1 0 0 0 
1 1 1 0 0 

## Test Case 3
| 1 | 1 | 0 | 0 | 0 |
|---|---|---|---|---|
| 0 | 1 | 1 | 0 | 0 |
| 0 | 0 | 1 | 0 | 1 |
| 1 | 0 | 1 | 0 | 1 |
| 1 | 1 | 0 | 1 | 1 |
| 1 | 1 | 1 | 0 | 0 |

### Results in
The biggest island is of size 16

Isolated on the map it appears as below:
1 1 0 0 0 
0 1 1 0 0 
0 0 1 0 1 
1 0 1 0 1 
1 1 0 1 1 
1 1 1 0 0
