

//DFS uses a Stack. Push onto top and remove from top.
import java.util.*;

public class DirectedGraph {

    public static void main(String[] args) {
        Graph<Character> graphObject = new Graph<>();

        graphObject.addEdge('a', 'b' ,false);
        graphObject.addEdge('a', 'c' ,false);
        graphObject.addEdge('c','e', false);
        graphObject.addEdge('b','d', false);
        graphObject.addEdge('f' ,'d', false);


        System.out.println("Graph:\n"
                + graphObject.printGraph());


    }

    static class Graph<T> {
        private Map<T, List<T>> graph = new HashMap<>();

        public void addEdge(T source, T destination, boolean biDirectional) {
            if (!graph.containsKey(source)) {
                addVertex(source);
            }

            if (!graph.containsKey(destination)) {
                addVertex(destination);
            }

            graph.get(source).add(destination);
            if (biDirectional == true) {
                graph.get(destination).add(source);
            }
        }

        public void hasVertex(T vertex) {
            if (graph.containsKey(vertex)) {
                System.out.println("The Graph contains " + vertex + " as a vertex");
            } else {
                System.out.println("The Graph does not contain " + vertex + " as a vertex");
            }
        }

        public void hasEdge(T source, T destination) {
            if (graph.get(source).contains(destination)) {
                System.out.println("The Graph has an edge between " + source + " and " + destination);
            } else {
                System.out.println("The Graph has no edge between " + source + " and " + destination);
            }
        }

        public String printGraph() {
            StringBuilder builder = new StringBuilder();

            for (T vertex : graph.keySet()) {
                builder.append(vertex.toString() + ": ");
                for (T node : graph.get(vertex)) {
                    builder.append(node.toString() + " ");
                }
                builder.append("\n");
            }
            return builder.toString();
        }

        private void addVertex(T vertex) {
            graph.put(vertex, new LinkedList<T>());
        }

    }
}
