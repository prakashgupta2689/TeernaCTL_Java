package microsoft.graphs.basicDFS;

import java.util.ArrayList;

public class FindMaxAndMinWtPaths {

    static int minWeight = Integer.MAX_VALUE;
    static int maxWeight = Integer.MIN_VALUE;
    static String minWeightedPath = "";
    static String maxWeightedPath = "";

    public static void main(String[] args) {
        ArrayList<GraphRepresentation.Edge>[] graph = GraphRepresentation.createGraph(7);

        boolean[] visited = new boolean[7];
        String pathTillNow = "0";
        int weightTillNow = 0;
        findMaxAndMinInGraph(graph, visited, 0, 6, pathTillNow, weightTillNow);
        System.out.println("Min weight covered to reach from src to dest: "+ minWeight + " path covered: "+ minWeightedPath);
        System.out.println("Max weight covered to reach from src to dest: "+ maxWeight + " path covered: "+ maxWeightedPath);

    }

    private static void findMaxAndMinInGraph(ArrayList<GraphRepresentation.Edge>[] graph, boolean[] visited, int src, int dest, String pathTillNow, int weightTillNow) {

        if(src == dest){
            if(maxWeight < weightTillNow){
                maxWeight = weightTillNow;
                maxWeightedPath = pathTillNow;
            }

            if(minWeight > weightTillNow){
                minWeight = weightTillNow;
                minWeightedPath = pathTillNow;
            }
            return;
        }

        visited[src] = true;

        for(GraphRepresentation.Edge edge: graph[src]){

            //before visiting the neighbour check if it is already visited
            if(!visited[edge.nbr]){
                //visit the neighbour
                findMaxAndMinInGraph(graph, visited, edge.nbr, dest, pathTillNow + edge.nbr, weightTillNow + edge.weight);
            }
        }
        visited[src] = false;
    }
}
