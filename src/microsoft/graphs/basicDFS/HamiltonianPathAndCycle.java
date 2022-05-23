package microsoft.graphs.basicDFS;

import java.util.ArrayList;
import java.util.HashSet;

public class HamiltonianPathAndCycle {

    public static void main(String[] args) {

        ArrayList<GraphRepresentation.Edge>[] graph = GraphRepresentation.createGraph(7);

        int src = 0;
        int osrc = 0;
        HashSet<Integer> visited = new HashSet<>();
        String psf = src+"";
        hamiltonian(graph, src, visited, psf, osrc);

    }

    private static void hamiltonian(ArrayList<GraphRepresentation.Edge>[] graph, int src, HashSet<Integer> visited, String psf, int osrc) {

        if(visited.size() == graph.length-1){

            boolean isCycle = false;
            //check for hamiltonian cycle
            //if the last vertex has an edge to the osrc, then it's a hamiltonian cycle
            for(GraphRepresentation.Edge edge: graph[src]){
                if(edge.nbr == osrc){
                    isCycle = true;
                }else{
                    isCycle = false;
                }
            }
            if(isCycle)
                System.out.println(psf + "*");
            else
                System.out.println(psf + ".");

            return;
        }


        visited.add(src);

        //visit all it's neighbouring edges
        for(GraphRepresentation.Edge edge: graph[src]){

            if(!visited.contains(edge.nbr)){
                hamiltonian(graph, edge.nbr, visited, psf + edge.nbr, osrc);
            }
        }
        visited.remove(src);
    }
}
