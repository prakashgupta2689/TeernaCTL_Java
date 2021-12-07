package recursion;

/**
 * we are required to print the path from the top left corner to the bottom right corner of a 2-D array with avoiding obstacles present in the array.
 * In this problem, only one move is allowed at a time and can be moved in the top, left, down or right direction.
 * */
public class FloodFill {

    public static void main(String[] args) {

        int[][] arr = new int[][]{
                {0,1,0,0,0,0,0},
                {0,1,0,1,1,1,0},
                {0,0,0,0,0,0,0},
                {1,0,1,1,0,1,1},
                {1,0,1,1,0,1,1},
                {1,0,0,0,0,0,0}
        };
        boolean[][] visited = new boolean[arr.length][arr[0].length];

        floodFill(arr,0, 0, visited, " ");
    }

    private static void floodFill(int[][] maze, int row, int column, boolean[][] visited, String ans) {

        if(row < 0 || column < 0 || row == maze.length || column == maze[0].length || maze[row][column] == 1 || visited[row][column] == true){
            return;
        }
        else if(row == (maze.length - 1) && column == (maze[0].length - 1)){
            System.out.println(ans);
            return;
        }
        visited[row][column] = true;
        floodFill(maze, row-1, column, visited, ans + "t");
        floodFill(maze, row, column-1, visited, ans+"l");
        floodFill(maze, row+1, column, visited,ans+"d");
        floodFill(maze, row, column+1,visited, ans + "r");
        visited[row][column] = false;
    }
}
