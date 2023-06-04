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

public class Vertex {

    int label;
    boolean isVisited;
    LinkedList<Edge> adjList;

    public Vertex() {
        adjList = new LinkedList<Edge>();
    }

    public Vertex(int label) {
        this.label = label;
        this.isVisited = false;
        adjList = new LinkedList<Edge>();
    }

    public void displayInfo() {

    }

}
