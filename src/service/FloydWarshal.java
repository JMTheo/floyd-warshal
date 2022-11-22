package service;

import java.util.ArrayList;
import java.util.List;

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

  }

}
