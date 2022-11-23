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

    public Vertex getVertex() {
        return this.vertex;
    }

    public double getWeight() {
        return this.weight;
    }

    public Edge(Vertex vertex, double weight) {
        setVertex(vertex);
        setWeight(weight);
    }

    @Override
    public String toString() {
        return "vertex= " + vertex + ", weight= " + weight;
    }
}
