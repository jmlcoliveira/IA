import searchalgorithm.*;
import undirectedgraph.*;

public class Main {
    public static void main(String[] args) {
        Graph graph = Romenia.defineGraph();
        graph.showLinks();
        graph.showSets();
        Node n;
        for(Algorithms a: Algorithms.values()){
            graph.reset();
            n = graph.searchSolution("Arad", "Bucharest", "Dobrogea",a);
            System.out.println(a.name());
            graph.showSolution(n);
        }
    }
}
