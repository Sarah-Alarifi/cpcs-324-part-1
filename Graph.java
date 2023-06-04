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

import PhoneNetworkApp.Line;
import PhoneNetworkApp.Office;
import java.util.*;
import java.io.*;

public class Graph {

    int verticesNo; //number of vertices
    int edgeNo; //number of edges
    Boolean isDigraph; //directed or not
    Vertex[] vertices;

    public Graph(int verticesNo, int edgeNo, boolean isDigraph) {
        this.verticesNo = verticesNo;
        this.edgeNo = edgeNo;
        this.isDigraph = isDigraph;
        this.vertices = new Vertex[verticesNo];
    }

    public Graph() {
    }

    public Edge newEdge(Vertex v, Vertex u, int w) {
        return new Line(v, u, w);
    }

    public Vertex newVertex(int label) {
        return new Office(label);
    }

    public void makeGraph(int verticesNo, int edgeNo) {
        for (int i = 0; i < verticesNo; i++) { //store vertices
            vertices[i] = new Vertex(i);
        }
        for (int i = 0; i < verticesNo - 1; i++) {
            //add edges with random weight
            addEdge(vertices[i].label, vertices[i + 1].label, (int) (Math.random() * 10 + 1));
        }
        int i = 0;
        while (i < (edgeNo - (verticesNo - 1))) {
            int v = (int) (Math.random() * verticesNo);
            int u = (int) (Math.random() * verticesNo);
            if (u == v) { //self loop
                continue;
            }
            for (int j = 0; j < vertices[u].adjList.size(); j++) {
                if (vertices[u].adjList.get(j).u.label != v) {
                    break; //break if not connected with an edge
                }
            }
            //add edges with random weight
            addEdge(vertices[u].label, vertices[v].label, (int) (Math.random() * 10 + 1));
            i++;
        }
    }

    public void readGraphFromFile(File fileName) throws FileNotFoundException {
        Scanner sc = new Scanner(fileName); //read from file
        String digraph = sc.next(); // read "digraph"
        String dire = sc.next();
        if (dire.equals("0")) {
            isDigraph = false; //not directed
        } else if (dire.equals("1")) {
            isDigraph = true; //directed
        }
        int numvert = sc.nextInt(); //total number of vertices
        int numedges = sc.nextInt(); //total number of edges
        if (!isDigraph) {
            numedges *= 2;
        }
        vertices = new Vertex[numvert]; //array of vertices
        while (edgeNo < numedges) { //edge is smaller that total edges
            char v = sc.next().charAt(0); //read source
            char u = sc.next().charAt(0); //read target
            int w = sc.nextInt(); //weight
            addEdge(v - 65, u - 65, w); 
        }
        sc.close(); //close the file
    }

    public Edge addEdge(int v, int u, int w) {
        Graph d = new Graph();
        if (vertices[v] == null) {
            verticesNo++;
            vertices[v] = d.newVertex(v);
        }
        if (vertices[u] == null) {
            verticesNo++; //increase number of vertices
            vertices[u] = d.newVertex(u); //create new target
        }
        Edge edge = d.newEdge(vertices[v], vertices[u], w);
        edgeNo++;
        vertices[v].adjList.add(edge);

        if (!isDigraph) { //if not directed
            edge = d.newEdge(vertices[u], vertices[v], w);
            edgeNo++; //increase number of edges
            vertices[u].adjList.add(edge);
        }
        return edge;
    }
}
