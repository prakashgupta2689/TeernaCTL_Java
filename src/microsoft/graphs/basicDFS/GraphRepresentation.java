package microsoft.graphs.basicDFS;

import java.util.ArrayList;
import java.util.Arrays;

public class GraphRepresentation {

    public static class Edge{

        int src;
        int nbr;
        int weight;

        public Edge(int src, int nbr, int weight) {
            this.src = src;
            this.nbr = nbr;
            this.weight = weight;
        }
    }
    public static void main(String[] args) {

        //array of lists
        int vces = 7;
        ArrayList<Edge> [] graph = createGraph(vces);
        System.out.println(Arrays.toString(graph));
    }

    public static ArrayList<Edge>[] createGraph(int vces) {

        ArrayList<Edge>[] graph = new ArrayList[vces];
        for(int i = 0; i < vces; i++){
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0,1, 10));
        graph[0].add(new Edge(0,3, 40));

        graph[1].add(new Edge(1,0, 10));
        graph[1].add(new Edge(1,2, 10));

        graph[2].add(new Edge(2,3, 10));

        graph[3].add(new Edge(3,0, 40));
        graph[3].add(new Edge(3,2, 10));
        graph[3].add(new Edge(3,4, 2));

        graph[4].add(new Edge(4,3, 2));
        graph[4].add(new Edge(4,5, 3));
        graph[4].add(new Edge(4,6, 8));

        graph[5].add(new Edge(5,4, 3));
        graph[5].add(new Edge(5,6, 3));

        graph[6].add(new Edge(6,4, 8));
        graph[6].add(new Edge(6,5, 3));

        return graph;
    }
}
