package graphs;

import java.util.LinkedList;

public class DirectedGraph {

    private final LinkedList<Vertex> vertexes;
    private final LinkedList<Edge> edges;

    public DirectedGraph(){
        vertexes = new LinkedList<>();
        edges = new LinkedList<>();
    }

    public void addVertex(Vertex vertex){
        if (searchVertex(vertex.getLabel()) == null){
            vertexes.add(vertex);
        } else {
            System.out.println("El Vertice con el nombre " + vertex.getLabel() + " ya existe!");
        }
    }

    public Vertex searchVertex(String vertexName){
        for(Vertex vertex: vertexes){
            if(vertex.getLabel().equals(vertexName))
                return vertex;
        }
        return null;
    }

    public void addEdge(String originName, String destinationName, double value){
        Vertex origin = searchVertex(originName);
        Vertex destination = searchVertex(destinationName);

        if(origin != null && destination != null){
            edges.add(new Edge(origin, destination, value));
        } else {
            System.out.println("Error: Vertice origin o destino no existe!!!");
        }
    }

    public void showVertexes(){
        System.out.println("Los vertices del grafo son: ");
        for(Vertex vertex: vertexes){
            System.out.println("Nombre: " + vertex.getLabel() + " Valor: "+ vertex.getValue());
        }
    }

    public void showEdges(){
        System.out.println("Las aristas del grafo son: ");
        for(Edge edge : edges){
            System.out.println("[Origen: " + edge.getOrigin().getLabel() +  " ---> Destino : " + edge.getDestination().getLabel() + "] : Valor: " + edge.getValue());
        }
    }

    public void showGraph(){
        System.out.println("Lista de adyacencia: ");
        for(Vertex vertex : vertexes){
            System.out.print("[ " + vertex.getLabel() + " : --> [");
            for(Edge edge : edges){
                if (edge.getOrigin().getLabel().equals(vertex.getLabel())){
                    System.out.print(edge.getDestination().getLabel() + "("+ edge.getValue()+"), ");
                };
            }
            System.out.print("]]");
            System.out.println();
        }
    }
}
