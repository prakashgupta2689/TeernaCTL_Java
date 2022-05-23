package microsoft.graphs.basicDFS;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class KthLargestPathFromSrcToDestDFS {

    public static class Pair implements Comparable<Pair>{

        int wsf;
        String psf;

        public Pair(int wsf, String psf) {
            this.wsf = wsf;
            this.psf = psf;
        }

        @Override
        public int compareTo(Pair o) {
            return this.wsf - o.wsf;
        }
    }
    static PriorityQueue<Pair> pq = new PriorityQueue<>();
    public static void main(String[] args) {

        ArrayList<GraphRepresentation.Edge>[] graph = GraphRepresentation.createGraph(7);

        boolean[] visited = new boolean[7];
        String pathUntilNow = "0";
        int weightUntilNow = 0;
        int k = 3;

        findKthLargestPathFromSrcToDest(graph, 0, 6, k, visited, pathUntilNow, weightUntilNow);

        if(!pq.isEmpty()){
            System.out.println(k + "th largest weight: "+ pq.remove().wsf + ", path: "+ pq.remove().psf);
        }
    }

    private static void findKthLargestPathFromSrcToDest(ArrayList<GraphRepresentation.Edge>[] graph, int src, int dest, int k, boolean[] visited, String pathUntilNow, int weightUntilNow) {

        if(src == dest){


                if (pq.size() < k) {
                    pq.add(new Pair(weightUntilNow, pathUntilNow));
                } else {
                    if(!pq.isEmpty()) {
                        if (weightUntilNow > pq.peek().wsf) {
                            pq.remove();
                            pq.add(new Pair(weightUntilNow, pathUntilNow));
                        }
                }
            }
            return;
        }

        visited[src] = true;

        for(GraphRepresentation.Edge edge: graph[src]){

            if(!visited[edge.nbr]){

                findKthLargestPathFromSrcToDest(graph, edge.nbr, dest, k, visited, pathUntilNow + edge.nbr, weightUntilNow + edge.weight);
            }
        }
        visited[src] = false;
    }
}
