package microsoft.graphs.connectedComponentsDFS;

import java.util.ArrayList;
import java.util.List;

/*
1. You are given a number n (representing the number of students).
Each student will have an id from 0 to n - 1.
2. You are given a number k (representing the number of clubs)
3. In the next k lines, two numbers are given separated by a space.
 The numbers are ids of students belonging to same club.



You have to find in how many ways can we select a pair of students,
 such that both students are from different clubs.
**/
public class FindPerfectFriends {

        public static class Edge{

            int src;
            int nbr;

            public Edge(int src, int nbr) {
                this.src = src;
                this.nbr = nbr;
            }
        }
        public static void main(String[] args) {
            //create graph -- forest

            List<Edge>[] graph = new List[7];
            for(int i = 0; i < 7; i++){
                graph[i] = new ArrayList<>();
            }

            graph[0].add(new Edge(0, 1));

            graph[1].add(new Edge(1, 0));

            graph[2].add(new Edge(2, 3));

            graph[3].add(new Edge(3, 2));

            graph[4].add(new Edge(4, 5));
            graph[4].add(new Edge(4, 6));

            graph[5].add(new Edge(5, 4));
            graph[5].add(new Edge(5, 6));

            graph[6].add(new Edge(6, 4));
            graph[6].add(new Edge(6, 5));


            int count = countPerfectFriends(graph);
            System.out.println("perfect friends: "+ count);
        }

    private static int countPerfectFriends(List<Edge>[] graph) {

            //first create connected components from the graph
        int perfectFriends = 0;
        boolean[] visited = new boolean[graph.length];
        ArrayList<ArrayList<Integer>> connectedComponents = new ArrayList<>();

        for(int i = 0; i < graph.length; i++){
            ArrayList<Integer> comp = new ArrayList<>();
            if(!visited[i]){

                createComponent(graph, i, visited, comp);
                connectedComponents.add(comp);
            }
        }

        //count the perfect friends
        for(int i = 0; i < connectedComponents.size(); i++){
            for(int j = i+1; j < connectedComponents.size(); j++){

                perfectFriends = perfectFriends + (connectedComponents.get(i).size() * connectedComponents.get(j).size());
            }
        }
        return perfectFriends;
    }

    private static void createComponent(List<Edge>[] graph, int src, boolean[] visited, ArrayList<Integer> comp) {

            visited[src] = true;
            comp.add(src);

            for(Edge edge: graph[src]){

                if(!visited[edge.nbr]){
                    createComponent(graph, edge.nbr, visited, comp);
                }
            }
    }
}
