import model.Graph;
import service.FloydWarshal;
import util.LoadData;

public class Main {

    public final String cellPatern = "%5s |";

    public static void main(String[] args) {
        Graph graph = LoadData.fileToGraph("src/data/data.txt");
        FloydWarshal floydWarshal = new FloydWarshal(graph);
        System.out.println("opa!");
    }
}