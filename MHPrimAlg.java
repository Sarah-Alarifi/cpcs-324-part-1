/*
Instructor: Dr. Mai, Dr. Sidra
Group members:
 Layan Bogari 2106104
Dona Alsudais 2106089
Sarah Alarifi 2105657
Raghad Aljedani 2105691
Section: B9A
 */
package GraphFramework;

import java.util.*;

public class MHPrimAlg extends MSTAlgorithm {

    private int cost = 0;

    public MHPrimAlg(Graph graph) {
        MSTResultList = new Edge[graph.verticesNo];
    }

    @Override
    public void displayResultingMST() {
        for (int i = 0; i < MSTResultList.length - 1; i++) {
            Vertex v = MSTResultList[i].v;
            System.out.println("");
            v.displayInfo();
            System.out.print(" - ");
            Vertex u = MSTResultList[i].u;
            u.displayInfo();
            Edge e = MSTResultList[i];
            e.displayInfo();
            System.out.println();
        }
    }

    @Override
    public void ans(Graph graph) {
        Vertex currentV = graph.vertices[0];
        PriorityQueue<Edge> x; //to store weight
        x = new PriorityQueue<Edge>();
        for (int i = 0; i < MSTResultList.length - 1; i++) {
            for (int j = 0; j < currentV.adjList.size(); j++) {
                Edge edge = currentV.adjList.get(j);
                edge.v.isVisited = true;
                if (!edge.u.isVisited) { //check visited or not
                    x.add(edge);
                }
            }
            while (!x.isEmpty()) {
                Edge edge = x.remove();
                if (!edge.u.isVisited) {
                    edge.u.isVisited = true; //mark as visited
                    MSTResultList[i] = edge; //add it to the list
                    cost += MSTResultList[i].weight;
                    currentV = edge.u;
                    break;
                }
            }
        }
        System.out.println("The cost of designed phone network: " + this.cost);
    }

}
