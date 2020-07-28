# Minesweeper
## Exercise description
Minesweeper game was a classic game on Windows 3.1. Now you don't need to implement the entire game, but to use 
the same logic and work with two-dimensional character array (in Java: char[][]).

###Step 1
Write a method, which generates a two-dimensional char array, randomly filled up with points (=empty fields) and stars 
(=mines).

This is just an example for the 3x3 table, but you should write the method first, which generates a similar array - a bigger one - and with random values:

    char[][] table = {{'.', '.', '*'}, {'.', '.', '.'}, {'*', '.', '.'}};
You could visualise like this:
```
 . . *
 . . .
 * . .
```

###Step 2
Write another method, which replaces the points (empty fields) with a number, where the number is the sum of mines around that position (in the 8 nearby cells).

Example solution:
```
0 1 *
1 2 1
* 1 0
```
###Step 3
Write another method, which print out the result table.

## Execution
The code has four main methods for: generating empty board of given size, add mines randomly (specified amount), calculating points for remaining fields and printing result.

The methods have been created in procedural way for simplification. Basic exceptions have been handled and main logic tested.