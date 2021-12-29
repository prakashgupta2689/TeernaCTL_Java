package microsoft.graphs.basicDFS;

import microsoft.graphs.basicDFS.GraphRepresentation;

import java.util.ArrayList;

public class FindPathInGraphDFS {

    public static void main(String[] args) {

        ArrayList<GraphRepresentation.Edge>[] list = GraphRepresentation.createGraph(7);
        boolean[] visited = new boolean[7];
        boolean hasPath = checkPath(list, 0, 6, visited);
        System.out.println("hasPath: "+ hasPath);
    }

    private static boolean checkPath(ArrayList<GraphRepresentation.Edge>[] graph, int src, int dest, boolean[] visited) {

        if(src == dest)
            return true;

        //as soon as you visit a node, mark it true
        visited[src] = true;
        //if src!= dest, if the any neighbour of src returns true that means a path from src to dest
        //exists via the src's neighbour

        for(GraphRepresentation.Edge edge: graph[src]){
            //before visiting a node's neighbour, check if it has been visited before
            if(!visited[edge.nbr]) {
                boolean hasPath = checkPath(graph, edge.nbr, dest, visited);
                if (hasPath)
                    return true;
            }
        }

        //if path is not found, return false
        return false;
    }
}
