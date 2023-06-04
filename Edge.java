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

public class Edge implements Comparable<Edge> {

    int weight;
    Vertex v; //source
    Vertex u; //target

    public Edge(Vertex v, Vertex u, int w) {
        this.v = v;
        this.u = u;
        this.weight = w;
    }

    public void displayInfo() {

    }

    public int compareTo(Edge edge) {
        if (this.weight > edge.weight) {
            return 1;
        } else if (this.weight == edge.weight) {
            return 0;
        } else {
            return -1;
        }

    }
}
