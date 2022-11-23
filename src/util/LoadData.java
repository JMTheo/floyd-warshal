package util;

import model.Graph;
import model.Vertex;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LoadData {
    public static Graph fileToGraph(String filePath) {
        Graph mGraph;
        List<String> mFileLines = getListFromData(filePath);

        // O grafo é direcionado?
        boolean mIsDirected = mFileLines.get(0).contains("S");
        mGraph = new Graph(mIsDirected);

        // Quantos vértices possui o grafo?
        int mLastVertex = Integer.parseInt(mFileLines.get(1)) + 2;

        // Quais os nomes dos vértices?
        for(String vertex : mFileLines.subList(2, mLastVertex)) {
            mGraph.addVertex(new Vertex(vertex));
        }

        // Quais arestas e os seus pesos?
        List<String[]> edges = generateEdges(mFileLines.subList(mLastVertex, mFileLines.size()));
        for(String[] edge : edges) {
            mGraph.addEdge(new Vertex(edge[0]), new Vertex(edge[1]), Double.parseDouble(edge[2]));
        }

        return mGraph;
    }

    private static List<String> getListFromData(String filePath) {
        List<String> mList;

        try {
            BufferedReader mBuffer = new BufferedReader(new FileReader(filePath));
            mList = mBuffer.lines().collect(Collectors.toList());
            mBuffer.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            mList = null;
        }

        return mList;
    }

    private static List<String[]> generateEdges(List<String> edgesAndWeights) {
        List<String[]> edgeList = new ArrayList<>();

        for (String edgesAndWeight : edgesAndWeights) {
            String[] edge = edgesAndWeight.split(",");
            edgeList.add(edge);
        }

        return edgeList;
    }

}
