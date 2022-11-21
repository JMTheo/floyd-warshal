package model;

public class Edge {
    private Vertex vertex;
    private double weight;

    private void setVertex(Vertex vertex) {
        this.vertex = vertex;
    }

    private void setWeight(double weight) {
        this.weight = weight;
    }

    private Vertex getVertex() {
        return this.vertex;
    }

    private double getWeight() {
        return this.weight;
    }

    public Edge(Vertex vertex, double weight) {
        setVertex(vertex);
        setWeight(weight);
    }
}
