package main;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Graph {

    private int nNodes;
    private Set<Integer> finised;
    private double[][] matrix;

    public Graph(int nNodes) {
        this.nNodes = nNodes;
        finised = new HashSet<Integer>();
        matrix = new double[nNodes][nNodes];
        for (int i = 0; i < nNodes; i++) {
            for (int j = 0; j < nNodes; j++) {
                matrix[i][j] = -1;
            }
        }
    }

    public double getEdge(int vertexIndex1, int vertexIndex2) {
        return matrix[vertexIndex1][vertexIndex2];
    }

    public void setEdge(double distance, int vertexIndex1, int vertexIndex2) {
        matrix[vertexIndex1][vertexIndex2] = distance;
    }

    public void setEdgeBidirectional(double distance, int vertexIndex1, int vertexIndex2) {
        setEdge(distance, vertexIndex1, vertexIndex2);
        setEdge(distance, vertexIndex2, vertexIndex1);
    }

    public double shortestDistanceBetween(int source, int target) {
        Double[] distancesFromSource = new Double[nNodes];
        Arrays.fill(distancesFromSource, Double.MAX_VALUE);
        distancesFromSource[source] = 0.;

        PriorityQueue myPQ = new PriorityQueue();
        myPQ.enqueue(source, distancesFromSource[source]);


        while (finised.size() != nNodes) {
            myPQ.print();
            int u = myPQ.getNode();
            myPQ.pop();
            finised.add(u);


            for (int i = 0; i < matrix[u].length ; i++) {
                if(matrix[u][i] != -1){
                    double v = matrix[u][i];
                    if(!finised.contains(i)){
                        double dist = distancesFromSource[u] + v;
                        if(dist < distancesFromSource[i]){
                            distancesFromSource[i] = dist;
                        }
                        myPQ.enqueue(i, distancesFromSource[i]);
                    }
                }

            }
        }

        return distancesFromSource[target];
    }

}
