package service;

import java.util.ArrayList;
import java.util.List;

import model.Edge;
import model.Graph;
import model.Vertex;

public class FloydWarshal {
  private double[][] minDistances;
  private List<Vertex> listVertex;

  public FloydWarshal(Graph graph) {
    this.listVertex = new ArrayList<>(graph.getVertices().keySet());
    this.minDistances = new double[listVertex.size()][listVertex.size()];

    for (int i = 0; i < listVertex.size(); i++) {
      for (int j = 0; j < listVertex.size(); j++) {
        minDistances[i][j] = Integer.MAX_VALUE;
      }
      minDistances[i][i] = 0;
    }

    for (Vertex vertex : listVertex) {
      for (Edge edge : graph.getVertices().get(vertex)) {

        System.out.println(vertex.getLabel() + " - " + listVertex.indexOf(vertex));

        System.out.println(vertex + " " + edge.toString());

        minDistances[listVertex.indexOf(vertex)][listVertex.indexOf(edge.getVertex())] = edge.getWeight();
      }
    }

    for (int k = 0; k < listVertex.size(); k++) {
      for (int i = 0; i < listVertex.size(); i++) {
        for (int j = 0; j < listVertex.size(); j++) {
          if (minDistances[i][k] + minDistances[k][j] < minDistances[i][j]) {
            minDistances[i][j] = minDistances[i][k] + minDistances[k][j];
          }
        }
      }
    }
  }

}
