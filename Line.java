/*
Instructor: Dr. Mai, Dr. Sidra
Group members:
 Layan Bogari 2106104
Dona Alsudais 2106089
Sarah Alarifi 2105657
Raghad Aljedani 2105691
Section: B9A
 */
package PhoneNetworkApp;

import GraphFramework.Edge;
import GraphFramework.Vertex;

public class Line extends Edge {

    private Integer ILength;

    public Line(Vertex v, Vertex u, int w) {
        super(v, u, w);
        this.ILength = w * 5;
    }

    @Override
    public void displayInfo() {
        System.out.println(" : line length: " + ILength);

    }

}
