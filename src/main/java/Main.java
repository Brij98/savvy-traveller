import java.text.DecimalFormat;
import java.util.*;

/*Our main contains two major parts.
    In the first part, input values are hard coded.
    You may add vertices as you wish below the comments that says add vertices.
    You may also add edges as you wish in switch cases.

    The second part will call member functions of java classes we created, and all algorithms will be performed using those functions.
    After we find target output of the problem, it will then output value we found.
    You can find details of those classes in files containing them (GraphOperations.java and Graph.java)
*/

public class Main {
    public static void main(String[] args) {

        // uncomment this if you want to run from command prompt and comment this code if you want to run in IDE
        if (Objects.equals(args[0], "")){
            throw (new NullPointerException("No arguments passed"));
        }
        String param = args[0].toLowerCase(Locale.ROOT);

        // uncomment this if you want to run from IDE and comment the above code
//        String param = "ExaMplE3".toLowerCase(Locale.ROOT);

        Graph graph = new Graph();
        GraphOperations graphOperations = null;
        GraphOperations.HighestProbPathProperty pathProperty = null;

        // add vertices
        Graph.Vertex a = graph.createVertex("A");
        Graph.Vertex b = graph.createVertex("B");
        Graph.Vertex c = graph.createVertex("C");
        Graph.Vertex d = graph.createVertex("D");
        Graph.Vertex e = graph.createVertex("E");
        Graph.Vertex f = graph.createVertex("F");
        Graph.Vertex g = graph.createVertex("G");
        Graph.Vertex h = graph.createVertex("H");

        switch (param){
            case "example1": {
                // add edges for example1
                graph.addEdge(a,b,0.8);
                graph.addEdge(a,c,0.7);
                graph.addEdge(a,d,0.9);
                graph.addEdge(b,c,0.8);
                graph.addEdge(b,f,0.6);
                graph.addEdge(b,e,0.6);
                graph.addEdge(c,f,0.9);
                graph.addEdge(d,g,0.8);
                graph.addEdge(d,f,0.6);
                graph.addEdge(e,f,0.8);
                graph.addEdge(e,h,0.6);
                graph.addEdge(f,g,0.7);
                graph.addEdge(f,h,0.7);
                graph.addEdge(g,h,0.9);

                graphOperations = new GraphOperations(graph);
                pathProperty = graphOperations.findHighestProbPath(graph.findVertex("A"),
                        graph.findVertex("F"));
            }
            break;
            case "example2":  {
                // add edges for example 2
                graph.addEdge(a,b,0.8);
                graph.addEdge(a,d,0.9);
                graph.addEdge(b,c,0.6);
                graph.addEdge(b,e,0.7);
                graph.addEdge(c,f,0.8);
                graph.addEdge(d,e,0.8);
                graph.addEdge(d,g,0.8);
                graph.addEdge(e,f,0.9);
                graph.addEdge(e,h,0.6);
                graph.addEdge(g,h,0.9);

                graphOperations = new GraphOperations(graph);
                pathProperty = graphOperations.findHighestProbPath(graph.findVertex("C"),
                        graph.findVertex("A"));
            }
            break;
            case "example3": {
                // add edges for example3
                graph.addEdge(a,b,0.8);
                graph.addEdge(a,d,0.9);
                graph.addEdge(a,e,0.8);
                graph.addEdge(b,c,0.6);
                graph.addEdge(b,f,0.7);
                graph.addEdge(c,d,0.9);
                graph.addEdge(c,g,0.6);
                graph.addEdge(d,h,0.7);
                graph.addEdge(e,f,0.6);
                graph.addEdge(e,h,0.8);
                graph.addEdge(f,g,0.9);
                graph.addEdge(h,g,0.6);

                graphOperations = new GraphOperations(graph);
                pathProperty = graphOperations.findHighestProbPath(graph.findVertex("E"),
                        graph.findVertex("C"));
            }
            case "example4": {
                // add edges for example4


//                graphOperations = new GraphOperations(graph);
//                pathProperty = graphOperations.findHighestProbPath(graph.findVertex("A"),
//                        graph.findVertex("B"));
            }
            break;
            default: {
                System.err.println("Invalid argument received. Check arguments and rerun");
                throw (new NullPointerException("pathProperty null and graphOperations null"));
            }
        }

        System.out.println(
                "Output:\n" +"i) path " + pathProperty.toString() +
                        ", probability " + new DecimalFormat("#.####").format(pathProperty.getProbability()) +
                        "\nii) city " + graphOperations.findMostReliableDest().getValue()
        );
    }

}