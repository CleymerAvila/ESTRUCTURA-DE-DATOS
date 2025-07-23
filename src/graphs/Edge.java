package graphs;

public class Edge {
    private double value;
    private Vertex origin;
    private Vertex destination;

    public Edge(Vertex origin, Vertex destination, double value){
        this.origin = origin;
        this.destination = destination;
        this.value = value;
    }


    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public Vertex getOrigin() {
        return origin;
    }

    public void setOrigin(Vertex origin) {
        this.origin = origin;
    }

    public Vertex getDestination() {
        return destination;
    }

    public void setDestination(Vertex destination) {
        this.destination = destination;
    }

}
