# Project 1 Breakdown

I have three classes that I am submitting: 
- [Sudoku](./Soduku) 
- CheckerThread 
- Board

Board is simply a class with a 2x2 array which holds the representation of the sudoku board. The board class can read from a CSV file and write to its integer array. 

I then designed three different types of threads to be derived from CheckerThread such that one would check rows, another columns and the last sub-grids. This made most sense to me as when looking at a sudoku puzzle that is how I would divide up looking at the board. Another reason for this is because this divides the processing time up equally as each thread has 9 sets of 9 objects to iterate through. I initially attempted to make this thread generic as there are many similarities between checks. Column check is just a row check with a rotated board (`board[i][j]` to `board[j][i]`). I wanted to be able to pass different parameters depending on if I wanted to check rows, columns, or grids but that ended up being too difficult. The CheckerThread class runs through the board array and returns another “boolean” array with zeros for valid numbers and negative ones for repeat numbers. This “boolean” array then has the missing numbers put behind their possible locations in this 3x3 array. 

The driver class, Sudoku, passes a filename to board for it to read in. Sudoku then creates three threads; one for rows, one for columns and one for grids. These threads return their respective 3x3 arrays which then get compared to each other and if there is a similar point in all of them then that is the correct number for that point on the board. 

I programmed in this manner because it was the easiest for me to visualize what was happening and what needed to be executed next. Both for the thread design as well as the 3x3 array.
