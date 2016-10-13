import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        String inputFileName = args[0];
        FileReader reader = new FileReader(inputFileName);
        Scanner in = new Scanner(reader);
        String line = in.nextLine();
        Scanner lineScanner = new Scanner(line);
        int numVertices = lineScanner.nextInt();

        // insert code here to build the graph from the input file
        Graph graph = new Graph(numVertices);
        for (int i = 0; i < graph.size(); i++) {
            Vertex v = graph.getVertex(i);
            lineScanner = new Scanner(in.nextLine());
            for (int j = 0; j < graph.size(); j++) {
                if (lineScanner.nextInt() == 1) {
                    v.addToAdjList(j);
                }
            }
        }
        reader.close();

        // conduct the breadth-first search
        graph.bfs();

        String outputFileName = args[1];
        FileWriter writer = new FileWriter(outputFileName);

        // insert code here to output the predecessor information
        for (int i = 0; i < graph.size(); i++) {
            Vertex v = graph.getVertex(i);
            writer.write(String.format("%d ", v.getPredecessor()));
        }

        writer.close();
    }
}
