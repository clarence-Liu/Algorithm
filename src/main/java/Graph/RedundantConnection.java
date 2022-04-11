package Graph;

/**
 * 684. Redundant Connection
 * <p>In this problem, a tree is an <strong>undirected graph</strong> that is connected and has no cycles.
 * <p>You are given a graph that started as a tree with {@code n} nodes labeled from 1 to {@code n}, with one additional edge added.
 * The added edge has two different vertices chosen from 1 to n, and was not an edge that already existed.
 * The graph is represented as an array edges of length {@code n} where {@code edges[i] = [ai, bi]} indicates that there is an edge between nodes {@code ai} and {@code bi} in the graph.
 * <p>Return an edge that can be removed so that the resulting graph is a tree of {@code n} nodes. If there are multiple answers, return the answer that occurs last in the input.
 * <p>Constraints:
 *      <br>n == edges.length
 *      <br>3 <= n <= 1000
 *      <br>edges[i].length == 2
 *      <br>1 <= ai < bi <= edges.length
 *      <br>ai != bi
 *      <br>There are no repeated edges.
 *      <br>The given graph is connected.
 */

/*
Input: edges = {{1,2},{1,3},{2,3}}
Output: [2,3]

Input: edges = {{1,2},{2,3},{3,4},{1,4},{1,5}}
Output: [1,4]

Input: edges = {{9,10},{5,8},{2,6},{1,5},{3,8},{4,9},{8,10},{4,10},{6,8},{7,9}}
Output: [4,10]
 */
public class RedundantConnection {

    public int[] findRedundantConnection(int[][] edges) {
        int length = edges.length;
        int[] res = new int[2];
        int[] parent = new int[length + 1];
        for (int i = 0; i <= length; i++) {
            parent[i] = i;
        }
        for (int[] edge : edges) {
            int source = edge[0], target = edge[1];
            int sp = find(parent, source), tp = find(parent, target);
            if (sp == tp) {
                res = edge;
            } else {
                parent[tp] = sp;
            }
        }
        return res;
    }

    private int find(int[] parent, int index) {
        while (parent[index] != index) {
            index = parent[index];
        }
        return parent[index];
    }
}
