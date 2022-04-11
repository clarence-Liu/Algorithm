package BinarySearch;

import java.util.Scanner;

public class BST {
    private static Node BSTree;
    static class Node {
        private Node leftChild, rightChild;
        private int nodeCount;
        private final long content;

        public Node(Node leftChild, Node rightChild, int nodeCount, long content) {
            this.leftChild = leftChild;
            this.rightChild = rightChild;
            this.nodeCount = nodeCount;
            this.content = content;
        }

        public Node getLeftChild() {
            return leftChild;
        }

        public void setLeftChild(Node leftChild) {
            this.leftChild = leftChild;
        }

        public Node getRightChild() {
            return rightChild;
        }

        public void setRightChild(Node rightChild) {
            this.rightChild = rightChild;
        }

        public int getNodeCount() {
            return nodeCount;
        }

        public void setNodeCount(int nodeCount) {
            this.nodeCount = nodeCount;
        }

        public long getContent() {
            return content;
        }
    }
    public static void main(String[] args){
      Scanner scanner = new Scanner(System.in);
      int Q = scanner.nextInt();
      while (Q-- > 0) {
          int operate = scanner.nextInt();
          long numb = scanner.nextLong();
          if (operate == 1) insert(numb);
          else search(numb);
      }
//      Node root = new Node(BSTree);
//      inOrder(root);
    }
    public static void insert (long x){
        Node current = BSTree;
        while (true) {
            if (BSTree == null){
                BSTree = new Node(null, null, 1, x);
                System.out.println("current");
                return;
            } else if(x > current.getContent()){
                if (current.getLeftChild() != null) {
                    current.setNodeCount(current.getNodeCount() + 1);
                    current = current.getLeftChild();
                } else {
                    current.setLeftChild(new Node(null, null, 1, x));
                    return;
                }
            } else {
                if (current.getRightChild() != null) {
                    current.setNodeCount(current.getNodeCount() + 1);
                    current = current.getRightChild();
                } else {
                    current.setRightChild(new Node(null, null, 1, x));
                    return;
                }
            }
        }
    }

//    public static void inOrder(Node root) {
//        if (root != null) {
//            inOrder(root.getLeftChild());
//            System.out.println(root.getContent());
//            inOrder(root.getRightChild());
//        }
//    }

    public static void search (long x) {
        Node current = BSTree;
        Node parent = null;
        while (current != null) {
            if (current.getContent() == x) {
                if (parent != null) {
                    if (parent.getLeftChild() == current) {
                        System.out.println(current.getLeftChild() == null? 1 : current.getLeftChild().getNodeCount() + 1);
                        return;
                    } else {
                        System.out.println(current.getLeftChild() == null? 1 : current.getLeftChild().getNodeCount() + 1);
                        return;
                    }
                } else {
                    System.out.println("1");
                    return;
                }
            } else if (current.getContent() < x) {
                parent = current;
                current = current.getLeftChild();
            } else {
                parent = current;
                current = current.getRightChild();
            }
        }
    }
}
