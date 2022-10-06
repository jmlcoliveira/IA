import searchalgorithm.*;
import undirectedgraph.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Graph graph = Romenia.defineGraph();
        Node n;
        ArrayList<String> prov = new ArrayList<>();
        prov.add("Dobrogea");
        //prov.add("Transilvania");
        //prov.add("Banat");
        for(Algorithms a: Algorithms.values()){
            graph.reset();
            n = graph.searchSolution("Arad", "Giurgiu",prov, a);
            System.out.println(a.name());
            graph.showSolution(n);
        }
    }
}
