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

import GraphFramework.Vertex;

public class Office extends Vertex {

    private String vertex;

    public Office(int label) {
        super(label);
        this.vertex = String.valueOf((char) (label + 65));
    }

    @Override
    public void displayInfo() {
        System.out.print("office No. " + vertex);

    }

}
