package misc.microsoft.graphs.basicDFS;

import java.util.ArrayList;

public class PrintAllPathsDFS {

    public static void main(String[] args) {
        ArrayList<GraphRepresentation.Edge>[] list = GraphRepresentation.createGraph(7);

        boolean[] visited = new boolean[7];
        String psf = "0";
        printAllPaths(list, 0, 6, visited, psf);

    }

    private static void printAllPaths(ArrayList<GraphRepresentation.Edge>[] graph, int src, int dest, boolean[] visited, String psf) {

        if(src == dest) {
            System.out.println(psf);
            return;
        }

        visited[src] = true;

        for(GraphRepresentation.Edge edge: graph[src]){

            if(!visited[edge.nbr]){
                printAllPaths(graph, edge.nbr, dest, visited, psf + edge.nbr);
            }
        }
        visited[src] = false;
    }
}
