package DataStructs.Graphs;

import java.util.ArrayList;
import java.util.Scanner;

class Cycle {

    private int nodes,edges;
    private int[][] adjacenyMatrix;
    private boolean[] visited;
    ArrayList<ArrayList<Integer>> cycles = new ArrayList<>();
    private boolean[] finalCycles;

    public Cycle() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the no. of nodes: ");
        nodes = in.nextInt();
        System.out.print("Enter the no. of Edges: ");
        edges = in.nextInt();

        adjacenyMatrix = new int[nodes][nodes];
        visited = new boolean[nodes];

        for (int i = 0; i < nodes; i++) {
            visited[i] = false;
        }

        System.out.println("Enter the details of each edges <Start Node> <End Node>");

        for (int i = 0; i < edges; i++) {
            int start, end;
            start = in.nextInt();
            end = in.nextInt();
            adjacenyMatrix[start][end] = 1;
        }

    }

    public void start() {
        for (int i = 0; i < nodes; i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            dfs(i, i, temp);
            for (int j = 0; j < nodes; j++) {
                adjacenyMatrix[i][j] = 0;
                adjacenyMatrix[j][i] = 0;
            }
        }
    }

    private void dfs(Integer start, Integer curr, ArrayList<Integer> temp) {
        temp.add(curr);
        visited[curr] = true;
        for (int i = 0; i < nodes; i++) {
            if (adjacenyMatrix[curr][i] == 1) {
                if (i == start) {
                    cycles.add(new ArrayList<Integer>(temp));
                } else {
                    if (!visited[i]) {
                        dfs(start, i, temp);
                    }
                }
            }
        }

        if (temp.size() > 0) {
            temp.remove(temp.size() - 1);
        }
        visited[curr] = false;
    }

    public void printAll() {
        for (int i = 0; i < cycles.size(); i++) {
            for (int j = 0; j < cycles.get(i).size(); j++) {
                System.out.print(cycles.get(i).get(j) + " -> ");
            }
            System.out.println(cycles.get(i).get(0));
            System.out.println();
        }

    }

}

public class Cycles {
    public static void main(String[] args) {
        Cycle c = new Cycle();
        c.start();
        c.printAll();
    }
}

















