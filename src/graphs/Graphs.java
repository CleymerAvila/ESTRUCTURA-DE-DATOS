package graphs;

import java.util.Arrays;

public class Graphs {

    public static void main(String[] args) {
        DirectedGraph graph = new DirectedGraph();

        Vertex vertex1 = new Vertex("A");
        Vertex vertex2 = new Vertex("B");
        Vertex vertex3 = new Vertex("C");
        Vertex vertex4 = new Vertex("D");
        Vertex vertex5 = new Vertex("E");
        Vertex vertex6 = new Vertex("H");

        Arrays.asList(vertex1, vertex2, vertex3, vertex4, vertex5, vertex6).forEach(graph::addVertex);

        graph.addEdge(vertex1.getLabel(), vertex2.getLabel(), 10);
        graph.addEdge(vertex1.getLabel(), vertex3.getLabel(), 12);
        graph.addEdge(vertex1.getLabel(), vertex4.getLabel(), 5);
        graph.addEdge(vertex2.getLabel(), vertex4.getLabel(), 7);
        graph.addEdge(vertex2.getLabel(), vertex5.getLabel(), 3);
        graph.addEdge(vertex3.getLabel(), vertex6.getLabel(), 13);
        graph.addEdge(vertex3.getLabel(), vertex1.getLabel(), 9);
        graph.addEdge(vertex4.getLabel(), vertex6.getLabel(), 6);


        graph.showVertexes();
        graph.showEdges();
        graph.showGraph();


    }
}
