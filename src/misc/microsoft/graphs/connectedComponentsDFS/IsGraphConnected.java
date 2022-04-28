package misc.microsoft.graphs.connectedComponentsDFS;

import java.util.ArrayList;
import java.util.List;

//a graph is said to be connected if it has only one component
public class IsGraphConnected {

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

        boolean isGraphConnected = checkGraphConnected(graph);
        System.out.println("isGraphConnected: "+ isGraphConnected);
    }

    private static boolean checkGraphConnected(List<Edge>[] graph) {

        boolean[] visited = new boolean[graph.length];
        ArrayList<ArrayList<Integer>> connectedComponents = new ArrayList<>();

        for(int i = 0; i < graph.length; i++){
            ArrayList<Integer> comp = new ArrayList<>();

            if(!visited[i]){

                //create components
                createComponent(graph, i, visited, comp);
                //add the component to the main list
                connectedComponents.add(comp);
            }
        }

        if(connectedComponents.size() > 1)
            return false;

        return true;
    }

    private static void createComponent(List<Edge>[] graph, int src, boolean[] visited, ArrayList<Integer> comp) {

        visited[src] = true;
        //add the src to the comp arraylist
        comp.add(src);

        //travel the neighbours and add the components
        for(Edge edge: graph[src]){

            //if neighbour is not visited, call recursive to create components for neighbour
            if(!visited[edge.nbr]){
                createComponent(graph, edge.nbr, visited, comp);
            }
        }
    }
}
