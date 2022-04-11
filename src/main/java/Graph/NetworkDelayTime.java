package Graph;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 743. Network Delay Time
 * You are given a network of n nodes, labeled from 1 to n. You are also given times,
 * a list of travel times as directed edges times[i] = (ui, vi, wi), where
 *      ui is the source node,
 *      vi is the target node, and
 *      wi is the time it takes for a signal to travel from source to target.
 *
 * We will send a signal from a given node k.
 * Return the time it takes for all the n nodes to receive the signal.
 * If it is impossible for all the n nodes to receive the signal, return -1.
 */

/*
Example 1:
Input: times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
Output: 2

Example 2:
Input: times = [[1,2,1]], n = 2, k = 1
Output: 1

Example 3:
Input: times = [[1,2,1]], n = 2, k = 2
Output: -1
 */

public class NetworkDelayTime {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String timesString = in.nextLine();
        timesString = timesString.substring(2, timesString.length() - 2);
        String[] timesArray = timesString.split("],\\[");
        int length = timesArray.length;
        int[][] times = new int[length][3];
        for (int i = 0; i < length; ++i) {
            String[] array = timesArray[i].split(",");
            times[i][0] = Integer.parseInt(array[0]);
            times[i][1] = Integer.parseInt(array[1]);
            times[i][2] = Integer.parseInt(array[2]);
        }
        System.out.println("Given the node number n :");
        int n = in.nextInt();
        System.out.println("Given the start node k :");
        int k = in.nextInt();
        NetworkDelayTime delayTime = new NetworkDelayTime();
        System.out.println("Output: " + delayTime.networkDelayTime(times, n, k));

    }

    public int networkDelayTime(int[][] times, int n, int k) {
        int row = times.length;
        int[] distance = new int[n];
        boolean[] visited = new boolean[n];
        int[][] graph = new int[n][n];
        for (int[] ints : graph) {
            Arrays.fill(ints, Integer.MAX_VALUE);
        }
        for (int[] time : times) {
            int x = time[0] - 1, y = time[1] - 1;
            graph[x][y] = time[2];
        }
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[k - 1] = 0;
        for (int i = 0; i < n; ++i) {
            int min = Integer.MAX_VALUE;
            int index = 0;
            for (int j = 0; j < n; ++j) {
                if (!visited[j] && distance[j] < min) {
                    min = distance[j];
                    index = j;
                }
            }
            visited[index] = true;
            for (int j = 0; j < n; ++j) {

            }
        }
        return -1;
    }
}
