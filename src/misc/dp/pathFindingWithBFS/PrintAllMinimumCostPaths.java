package misc.dp.pathFindingWithBFS;

/**
 * 1. You are given a number n, representing the number of rows.
 * 2. You are given a number m, representing the number of columns.
 * 3. You are given n*m numbers, representing elements of 2d array a, which represents a maze.
 * 4. You are standing in top-left cell and are required to move to bottom-right cell.
 * 5. You are allowed to move 1 cell right (h move) or 1 cell down (v move) in 1 motion.
 * 6. Each cell has a value that will have to be paid to enter that cell (even for the top-left and bottom-right cell).
 * 7. You are required to traverse through the matrix and print the cost of the path which is least costly.
 * 8. Also, you have to print all the paths with minimum cost.
 *
 * Each cell says: yaha se arr[l][l] jane mein kitne paise lagenge
 * arr[l][l] jane mein lagega 1 as given in the arr
 * First fill the dp matrix and then find the minimum paths by reverse engineering
 * Use BFS for this
 * remove from queue, if it is not the destination, then add the minimum of the horizontal and vertical. Add both if they are equal
 * */
public class PrintAllMinimumCostPaths {

    public static void main(String[] args) {


    }
}
