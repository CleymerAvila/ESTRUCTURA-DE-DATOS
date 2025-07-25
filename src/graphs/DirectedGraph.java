package graphs;

import java.util.*;

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

    public void hasVertex(String vertexName){
        System.out.println("¿Se encuentra el vertice "+ vertexName + " en el grafo? "
                + (searchVertex(vertexName) != null ? "SÍ" : "NO") );
    }

    public Edge searchEdge(String originName, String destinationName){
        for(Edge edge: edges){
            if (edge.getOrigin().getLabel().equals(originName)
                && edge.getDestination().getLabel().equals(destinationName)){
                return edge;
            }
        }
        return null;
    }

    public void hasEdge(String originName, String destinationName){
        System.out.println("¿Se encuentra la arista de "+ originName + " hasta "
                + destinationName +" en el grafo? " +
                (searchEdge(originName, destinationName) != null ? " Sí " : " NO"));
    }

    public List<Vertex> getNeighbours(String vertexName){
        List<Vertex> neighbours = new LinkedList<>();
        if (searchVertex(vertexName).getLabel() != null){
            for(Edge edge: edges){
                if (edge.getOrigin().getLabel().equals(vertexName)){
                    neighbours.add(edge.getDestination());
                }
            }
        } else {
            System.out.println("El vertice " + vertexName + " no se encuentra en el grafo");
        }
        return neighbours;
    }

    // DEPTH FIRST SEARCH
    public void dfs(String startName){
        System.out.println("Busquedad en profundidad (DFS): ");
        Set<Vertex> visited = new HashSet<>();
        dfsRecursive(new Vertex(startName), visited);
    }

    private void dfsRecursive(Vertex currentVertex, Set<Vertex> visited){
        if (visited.contains(currentVertex)) return;
        visited.add(currentVertex);
        System.out.println("Visitando: " + currentVertex.getLabel());

        for(Edge edge: edges){
            dfsRecursive(edge.getDestination(), visited);
        }
    }

    public void bfs(String startName){
        System.out.println("\nBusquedad en anchura (BFS): ");
        Vertex startVertex = new Vertex(startName);
        Set<Vertex> visited = new HashSet<>();
        Queue<Vertex> queue = new LinkedList<>();

        queue.add(startVertex);
        visited.add(startVertex);

        while(!queue.isEmpty()) {
            Vertex current = queue.poll();
            System.out.println("Visitando: " + current.getLabel());

            for(Edge edge: edges){
                if (!visited.contains(edge.getDestination())){
                    visited.add(edge.getDestination());
                    queue.add(edge.getDestination());
                }
            }
        }
    }

    public Map<Vertex, Integer> dijkstra(String startName){
        Vertex start = new Vertex(startName);
        Map<Vertex, Integer> distances = new HashMap<>();
        PriorityQueue<Map.Entry<Vertex, Integer>> queue = new PriorityQueue<>(Map.Entry.comparingByValue());

        for(Vertex  v : vertexes){
            distances.put(v, Integer.MAX_VALUE);
        }
        distances.put(start, 0);
        queue.add(new AbstractMap.SimpleEntry<>(start, 0));
        while(!queue.isEmpty()){
            Vertex current = queue.poll().getKey();
            int currentDistance = distances.get(start);

            for (Edge edge: edges){
                int newDistance =  currentDistance + (int) edge.getValue();
                if (newDistance < distances.get(edge.getDestination())){
                    distances.put(edge.getDestination(), (int) newDistance);
                    queue.add(new AbstractMap.SimpleEntry<>(edge.getDestination(), newDistance));
                }
            }
        }
        return distances;
    }

    public void printDijkstra(String startName){
        Map<Vertex, Integer> result = dijkstra(startName);
        System.out.println("Distancias desde " + startName + ": ");
        for(Map.Entry<Vertex, Integer> entry: result.entrySet()){
            System.out.println("-> " + entry.getKey() + " = " + entry.getValue());
        }
    }
}

