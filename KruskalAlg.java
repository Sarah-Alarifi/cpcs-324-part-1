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

public class KruskalAlg extends MSTAlgorithm {

    private int cost = 0;

    public KruskalAlg(Graph graph) {
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
            Edge edge = MSTResultList[i];
            edge.displayInfo();
            System.out.println();
        }
        System.out.println("The cost of designed phone network: " + this.cost);
    }

    @Override
    public void ans(Graph graph) {
        Vertex v; //source
        Vertex u; //target
        Edge e; //edge
        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < graph.verticesNo; i++) {
            v = graph.vertices[i];
            for (int j = 0; j < v.adjList.size(); j++) {
                edges.add(v.adjList.get(j));
            }
        }
        Collections.sort(edges);
        Vertex[] z = new Vertex[graph.verticesNo];
        makeSet(z); //make set for each vertix
        int x = 0;
        while (x < MSTResultList.length - 1) {
            e = edges.remove(0);
            v = e.v;
            u = e.u;
            if (!findSet(z[v.label].label, z[u.label].label)) {
                union(z, v, u);
                MSTResultList[x] = e;
                cost += MSTResultList[x].weight;
                x++;
            }
        }
        System.out.println("The cost of designed phone network: " + this.cost);
    }

    public void union(Vertex[] x, Vertex A, Vertex B) {

        int AR = x[A.label].label;
        int BR = x[B.label].label;
        boolean ANR = findSet(A.label, AR);
        boolean BNR = findSet(B.label, BR);

        for (int i = 0; i < x.length; i++) {
            if (AR == x[i].label && (i != A.label)) {
                ANR = false;
            }
            if (BR == x[i].label && (i != B.label)) {
                BNR = false;
            }
        }
        if ((!ANR) && (BNR)) {
            x[B.label] = x[A.label];
        } else if (ANR && (!BNR)) {
            x[A.label] = x[B.label];
        } else if ((ANR && BNR)) {
            x[B.label] = x[A.label];
        } else {
            int max = Math.max(AR, BR);
            int min = Math.min(AR, BR);
            for (int i = 0; i < x.length; i++) {
                if (x[i].label == max) {
                    x[i] = x[min];
                }
            }
        }
    }

    public void makeSet(Vertex[] DS) {
        for (int i = 0; i < DS.length; i++) {
            Vertex v = new Vertex(i);
            DS[i] = v;
        }
    }

    public boolean findSet(int x, int y) {
        return x == y;
    }

}
