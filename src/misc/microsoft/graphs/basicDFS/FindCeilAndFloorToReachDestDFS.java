package misc.microsoft.graphs.basicDFS;

import java.util.ArrayList;

public class FindCeilAndFloorToReachDestDFS {

    static int ceilWeight = Integer.MAX_VALUE;
    static String ceilPath = "";
    static int floorWeight = Integer.MIN_VALUE;
    static String floorPath = "";

    public static void main(String[] args) {
        ArrayList<GraphRepresentation.Edge>[] graph = GraphRepresentation.createGraph(7);

        boolean[] visited = new boolean[7];
        String pathUntilNow = "0";
        int criteria = 42;
        int weightTillNow = 0;

        findCeilAndFloorToReachDest(graph, 0, 6, visited, criteria, pathUntilNow, weightTillNow);
        System.out.println("ceil: "+ ceilWeight + " ceil path: "+ ceilPath);
        System.out.println("floor: "+ floorWeight + " floor path: "+ floorPath);
    }

    private static void findCeilAndFloorToReachDest(ArrayList<GraphRepresentation.Edge>[] graph, int src, int dest, boolean[] visited, int criteria, String pathUntilNow, int weightTillNow) {

        if(src == dest) {

            //finding ceil
            if (weightTillNow > criteria && weightTillNow < ceilWeight) {
                ceilWeight = weightTillNow;
                ceilPath = pathUntilNow;
            }

            //finding floor
            if (weightTillNow < criteria && weightTillNow > floorWeight) {

                floorWeight = weightTillNow;
                floorPath = pathUntilNow;
            }

            return;
        }

            visited[src] = true;

            for(GraphRepresentation.Edge edge : graph[src]){

                if(!visited[edge.nbr]){
                    findCeilAndFloorToReachDest(graph, edge.nbr, dest, visited, criteria, pathUntilNow + edge.nbr, weightTillNow + edge.weight);
                }
            }
            visited[src] = false;
        }
}
