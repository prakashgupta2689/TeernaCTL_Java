package microsoft.graphs.connectedComponentsDFS;

public class CountNumberOfIslands {

    public static void main(String[] args) {

        int[][] graph = new int[][]{
                {0, 0, 1, 1, 1, 1, 1, 1},
                {0, 0, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 0},
                {1, 1, 0, 0, 0, 1, 1, 0},
                {1, 1, 1, 1, 0, 1, 1, 0},
                {1, 1, 1, 1, 0, 1, 1, 0},
                {1, 1, 1, 1, 1, 1, 1, 0},
                {1, 1, 0, 1, 1, 1, 1, 0}
        };

        int islandCount = countIslands(graph);
        System.out.println("islandCount: "+ islandCount);
    }

    private static int countIslands(int[][] graph) {

        boolean[][] visited = new boolean[graph.length][graph[0].length];
        int countOfConnectedComponents = 0;

        for(int i = 0; i < graph.length; i++){
            for(int j = 0; j < graph[0].length; j++){

                //count a connected component only if it is land and not visited
                //the question mentions that 0 is land and 1 is water
                if(!visited[i][j] && graph[i][j] == 0){

                    //call to create a component
                    connectedComponent(graph, i, j, visited);
                    countOfConnectedComponents++;
                }
            }
        }
        return countOfConnectedComponents;
    }

    private static void connectedComponent(int[][] graph, int i, int j, boolean[][] visited) {

        //cases to handle
        //1. if i or j exceed the matrix limit
        //2. if graph[i][j] is already visited
        //3. if graph[i][j] is water
        //in all the above cases just return
        if(i < 0 || j < 0 || i >= graph.length || j >= graph[0].length || visited[i][j] || graph[i][j] == 1)
            return;

        visited[i][j] = true;

        //the four boundaries of the 2D array are the imaginary edges, so
        //to traverse the neighbouring edges, just traverse the four edges

        connectedComponent(graph, i-1, j, visited);
        connectedComponent(graph, i, j-1, visited);
        connectedComponent(graph, i, j+1, visited);
        connectedComponent(graph, i+1, j, visited);
    }
}
