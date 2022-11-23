package service;

import java.util.ArrayList;
import java.util.List;

import model.Edge;
import model.Graph;
import model.Vertex;

public class FloydWarshal {
  private double[][] minDistance;
  private double[][] graphSentence;
  private List<Vertex> listVertex;

  public FloydWarshal(Graph graph) {
    this.listVertex = new ArrayList<>(graph.getVertices().keySet());
    this.minDistance = new double[listVertex.size()][listVertex.size()];
    this.graphSentence = new double[listVertex.size()][listVertex.size()];

    for (int i = 0; i < listVertex.size(); i++) {
      for (int j = 0; j < listVertex.size(); j++) {
        minDistance[i][j] = Integer.MAX_VALUE;
        graphSentence[i][j] = 0;
      }
      minDistance[i][i] = 0;
      graphSentence[i][i] = i;
    }

    instanceMinDistance(graph);

    showMatrixResult();    
  }

  private void instanceMinDistance(Graph graph) {
    System.out.println("Grafo inicial");

    for (Vertex vertex : listVertex) {
      for (Edge edge : graph.getVertices().get(vertex)) {

        System.out.println(vertex.getLabel() + " - " + listVertex.indexOf(vertex));

        System.out.println(vertex + " " + edge.toString());

        minDistance[listVertex.indexOf(vertex)][listVertex.indexOf(edge.getVertex())] = edge.getWeight();
        graphSentence[listVertex.indexOf(vertex)][listVertex.indexOf(edge.getVertex())] = edge.getWeight();
      }
    }

    System.out.println("\n");

    calculateMinDistance();
  }

  private void calculateMinDistance() {
    for (int k = 0; k < listVertex.size(); k++) {
      for (int i = 0; i < listVertex.size(); i++) {
        for (int j = 0; j < listVertex.size(); j++) {
          if ((minDistance[i][k] + minDistance[k][j]) < minDistance[i][j]) {
            minDistance[i][j] = minDistance[i][k] + minDistance[k][j];
            graphSentence[i][j] = graphSentence[i][k];
          }
        }
      }
    }
  }

  private void showMatrixResult() {
    System.out.println("Matriz resultante");

    for (int i = 0; i < listVertex.size(); i++) {
      for (int j = 0; j < listVertex.size(); j++) {
        System.out.print(minDistance[i][j] + "\t");
      }

      System.out.println("\n");
    }

    System.out.println("Percursos resultante");

    for (int i = 0; i < listVertex.size(); i++) {
      for (int j = 0; j < listVertex.size(); j++) {
        System.out.print(graphSentence[i][j] + "\t");
      }

      System.out.println("\n");
    }
  }
}
