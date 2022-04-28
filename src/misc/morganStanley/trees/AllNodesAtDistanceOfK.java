package misc.morganStanley.trees;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class AllNodesAtDistanceOfK {

    public static void main(String[] args) {

        Tree.Node n1 = new Tree.Node(-10);
        Tree.Node n2 = new Tree.Node(2);
        Tree.Node n3 = new Tree.Node(3);
        Tree.Node n4 = new Tree.Node(4);
        Tree.Node n5 = new Tree.Node(5);
        Tree.Node n6 = new Tree.Node(6);
        Tree.Node n7 = new Tree.Node(7);

        Tree.constructBinaryTree(n1,n2,"left");
        Tree.constructBinaryTree(n1,n3,"right");
        Tree.constructBinaryTree(n2,n4,"left");
        Tree.constructBinaryTree(n2, n5, "right");
        Tree.constructBinaryTree(n3, n6, "right");
        Tree.constructBinaryTree(n3, n7, "left");

        int distance = 2;
        printAllNodesAtDistanceK(n1, n3, distance);
    }

    private static void printAllNodesAtDistanceK(Tree.Node node, Tree.Node target, int distance) {

        //1. create a parent_track hash map to store the node (key) and it's parent (value)
        //2. Maintain a queue and a visited hash map with node (key) and isVisited (a boolean value).
        //3. Traverse left, right and check parent of the node. If they are not visited add in queue and visited map
        //4. once the value is equal to distance break

        //creating a parent_track hash map
        HashMap<Tree.Node, Tree.Node> parent_track = new HashMap<>();
        createParentTrackMap(parent_track, node);

        Queue<Tree.Node> queue = new LinkedList<>();
        HashMap<Tree.Node, Boolean> visited = new HashMap<>();
        queue.add(node);
        visited.put(target, true);
        int currentLevel = 1;

        while(!queue.isEmpty()){

            int size = queue.size();

            if(currentLevel == distance)
                break;

            currentLevel++;

            for(int i = 0; i < size; i++){

                Tree.Node currentNode = queue.remove();

                //if left is not null and not visited
                if(currentNode.left != null && visited.get(currentNode.left) == null){
                    queue.add(currentNode.left);
                    visited.put(currentNode, true);
                }
                //if right is not null and not visited
                if(currentNode.right != null && visited.get(currentNode.right) == null){
                    queue.add(currentNode.right);
                    visited.put(currentNode, true);
                }
                //if parent is not null and not visited
                if(parent_track.get(currentNode) != null && visited.get(parent_track.get(currentNode)) == null){
                    queue.add(parent_track.get(currentNode));
                    visited.put(parent_track.get(currentNode),true);
                }

            }
        }

        //print whatever element is left in the queue
        while(!queue.isEmpty()){
            System.out.println(queue.remove().data);
        }

    }

    private static void createParentTrackMap(HashMap<Tree.Node, Tree.Node> parent_track, Tree.Node node) {

        if(node == null)
            return;

        if(node.left != null){
            parent_track.put(node.left, node);
            createParentTrackMap(parent_track, node.left);
        }
        if(node.right != null){
            parent_track.put(node.right, node);
            createParentTrackMap(parent_track, node.right);
        }
    }
}
