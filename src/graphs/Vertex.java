package graphs;

public class Vertex {

    private String label;
    private double value;

    public Vertex(String name){
        this.label = name;
        value = 0;
    }

    public Vertex(String name, double value){
        this.label = name;
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "[ "+ label + " ]  --> \n |"  ;
    }
}
