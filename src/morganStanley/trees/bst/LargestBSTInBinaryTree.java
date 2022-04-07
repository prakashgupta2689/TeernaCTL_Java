package morganStanley.trees.bst;

// Java program to find largest BST in a
// Binary Tree.
import java.io.*;
import java.math.*;
import java.util.*;

/* misc.A binary tree node has data,
pointer to left child and a
pointer to right child */
class Node {
    int data;
    Node left, right;

    public Node(int d){
        data = d;
        left = right = null;
    }
}

public class LargestBSTInBinaryTree
{
    public static void main (String[] args)
    {
        Node node = new Node(60);
        node.left = new Node(65);
        node.right = new Node(70);
        node.left.left = new Node(50);

        System.out.println("Size of the largest BST is " +
                Solution.largestBst(node)+ "\n");

    }
}

class Solution
{
    static int MAX = Integer.MAX_VALUE;
    static int MIN = Integer.MIN_VALUE;

    static class nodeInfo
    {
        int size; // Size of subtree
        int max; // Min value in subtree
        int min; // Max value in subtree
        int ans; // Size of largest BST which
        // is subtree of current node
        boolean isBST; // If subtree is BST

        nodeInfo(){} // empty constructor

        nodeInfo(int size, int max, int min,
                 int ans, boolean isBST)
        {
            this.size = size;
            this.max = max;
            this.min = min;
            this.ans = ans;
            this.isBST = isBST;
        }
    }

    static nodeInfo largestBST(Node root)
    {

        // misc.Base cases : When tree is empty or it has
        // one child.
        if(root == null)
            return new nodeInfo(0, MIN, MAX, 0, true);
        if(root.left == null && root.right == null)
            return new nodeInfo(1, root.data, root.data, 1, true);

        // Recur for left subtree and right subtrees
        nodeInfo left = largestBST(root.left);
        nodeInfo right = largestBST(root.right);

        // Create a return variable and initialize its size.
        nodeInfo returnInfo = new nodeInfo();
        returnInfo.size = 1 + Math.max(left.size, right.size);

        // If whole tree rooted under current root is BST.
        if(left.isBST && right.isBST
                && left.max < root.data
                && right.min > root.data)
        {
            returnInfo.min = Math.min(Math.min(left.min, right.min), root.data);
            returnInfo.max = Math.max(Math.max(left.max, right.max), root.data);

            // Update answer for tree rooted under
            // current 'root'
            returnInfo.ans = returnInfo.size;
            returnInfo.isBST = true;
            return returnInfo;
        }

        // If whole tree is not BST, return maximum
        // of left and right subtrees
        returnInfo.ans = Math.max(left.ans, right.ans);
        returnInfo.isBST = false;
        return returnInfo;
    }

    // Return the size of the largest sub-tree which is also a BST
    static int largestBst(Node root)
    {
        return largestBST(root).ans;
    }
}
// This code is contributed by Ayush Choudhary

