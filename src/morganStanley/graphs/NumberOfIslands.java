package morganStanley.graphs;

public class NumberOfIslands {

    /**
     * 1. You are given a 2d array where 0's represent land and 1's represent water. Assume every cell is linked to it's north, east, west and south cell.
     * 2. You are required to find and count the number of islands.
     * */
    public static void main(String[] args) {

        int[][] arr = new int[][]{
                {0,0, 1, 1, 1, 1, 1, 1},
                {0, 0, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 0},
                {1, 1, 0, 0, 0, 1, 1, 0},
                {1, 1, 1, 1, 0, 1, 1, 0},
                {1, 1, 1, 1, 0, 1, 1, 0},
                {1, 1, 1, 1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1, 1, 1, 0}
        };

        getNumberOfIslands(arr);
    }

    private static void getNumberOfIslands(int[][] arr) {

        boolean[][] visited = new boolean[arr.length][arr[0].length];
        int count = 0;
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){

                //should be a land and visited[i][j] must be false
                if(arr[i][j] == 0 && !visited[i][j]){
                    drawTreeComponent(arr, i, j, visited);
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    private static void drawTreeComponent(int[][] arr, int i, int j, boolean[][] visited) {

        if(i < 0 || j < 0 || i >= arr.length || j >= arr[0].length || arr[i][j] == 1 || visited[i][j]){
            return;
        }
        visited[i][j] = true;
        //North, south, east, west
        drawTreeComponent(arr, i-1, j, visited);
        drawTreeComponent(arr, i, j-1, visited);
        drawTreeComponent(arr, i+1, j, visited);
        drawTreeComponent(arr, i, j+1, visited);
    }
}
