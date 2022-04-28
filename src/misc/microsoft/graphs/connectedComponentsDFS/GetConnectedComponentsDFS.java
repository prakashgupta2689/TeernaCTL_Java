package misc.microsoft.graphs.connectedComponentsDFS;

import java.util.ArrayList;
import java.util.List;

public class GetConnectedComponentsDFS {

    public static class Edge{

        int src;
        int nbr;
        int wt;

        public Edge(int src, int nbr, int wt) {
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }
    }
    public static void main(String[] args) {

        //create graph -- forest

        List<Edge>[] graph = new List[7];
        for(int i = 0; i < 7; i++){
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 10));

        graph[1].add(new Edge(1, 0, 10));

        graph[2].add(new Edge(2, 3, 10));

        graph[3].add(new Edge(3, 2, 10));

        graph[4].add(new Edge(4, 5, 20));
        graph[4].add(new Edge(4, 6, 8));

        graph[5].add(new Edge(5, 4, 20));
        graph[5].add(new Edge(5, 6, 3));

        graph[6].add(new Edge(6, 4, 8));
        graph[6].add(new Edge(6, 5, 3));

        ArrayList<ArrayList<Integer>> connectedComponents = findConnectedComponents(graph);
        System.out.println(connectedComponents);

    }

    private static ArrayList<ArrayList<Integer>> findConnectedComponents(List<Edge>[] graph) {

        boolean[] visited = new boolean[graph.length];
        ArrayList<ArrayList<Integer>> connectedComponents = new ArrayList<>();

        for(int i = 0; i < graph.length; i++){
            ArrayList<Integer> comp = new ArrayList<>();
            if(!visited[i]){

                createEachConnectedComponent(graph, i, visited, comp);
                connectedComponents.add(comp);
            }
        }
        return connectedComponents;
    }

    private static void createEachConnectedComponent(List<Edge>[] graph, int src, boolean[] visited, ArrayList<Integer> comp) {

        visited[src] = true;
        comp.add(src);

        for(Edge edge: graph[src]){

            if(!visited[edge.nbr]){
                createEachConnectedComponent(graph, edge.nbr, visited, comp);
            }
        }
    }
}
