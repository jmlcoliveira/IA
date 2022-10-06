package undirectedgraph;

public class Romenia {

	public static Graph defineGraph() {

		Graph g = new Graph();
		// Define cities:
		g.addVertex("Oradea", 46.98295621538163, 21.81118731326103);
		g.addVertex("Zerind", 46.55632334543228, 21.465700215263368);
		g.addVertex("Bucharest", 44.3029424200058, 26.15035138560295);
		g.addVertex("Urziceni", 44.81476168516159, 26.745870794172287);
		g.addVertex("Arad", 46.18891262467384, 21.414029341382978);
		g.addVertex("Mehadia", 45.02825717078209, 22.455735831041334);
		g.addVertex("Neamt", 46.97594937550545, 26.413222220306395);
		g.addVertex("Iasi", 47.25897622556687, 27.615914362134934);
		g.addVertex("R. Vilcea", 45.24940464442253, 24.3600833125782);
		g.addVertex("Eforie", 43.93737398139953, 28.593022455558778);
		g.addVertex("Pitesti", 44.79236658571243, 24.956709224157333);
		g.addVertex("Timisoara", 45.73686784779548, 21.215008189373016);
		g.addVertex("Craiova", 44.19095747344971, 23.81917156899452);
		g.addVertex("Hirsova", 44.77219061551094, 27.985398661050798);
		g.addVertex("Vaslui", 46.570370651426316, 27.835861666345597);
		g.addVertex("Giurgiu", 43.888874397954936, 25.933190459899905);
		g.addVertex("Sibiu", 45.852364870862964, 24.21705439599037);
		g.addVertex("Dobreta", 44.67250558225632, 22.726696712474823);
		g.addVertex("Fagaras", 45.698117266550064, 24.924891155338287);
		g.addVertex("Lugoj", 45.63560762309074, 21.884844897232053);
		// Define routes:
		g.addEdge("Bucharest","Giurgiu");
		g.addEdge("R. Vilcea","Sibiu");
		g.addEdge("Iasi","Vaslui");
		g.addEdge("Iasi","Neamt");
		g.addEdge("Lugoj","Mehadia");
		g.addEdge("Arad","Timisoara");
		g.addEdge("Arad","Sibiu");
		g.addEdge("Bucharest","Fagaras");
		g.addEdge("Eforie","Hirsova");
		g.addEdge("Fagaras","Sibiu");
		g.addEdge("Bucharest","Urziceni");
		g.addEdge("Craiova","Pitesti");
		g.addEdge("Dobreta","Mehadia");
		g.addEdge("Hirsova","Urziceni");
		g.addEdge("Arad","Zerind");
		g.addEdge("Craiova","R. Vilcea");
		g.addEdge("Craiova","Dobreta");
		g.addEdge("Urziceni","Vaslui");
		g.addEdge("Lugoj","Timisoara");
		g.addEdge("Bucharest","Pitesti");
		g.addEdge("Pitesti","R. Vilcea");
		g.addEdge("Oradea","Zerind");
		g.addEdge("Oradea","Sibiu");
		// Define regions:
		g.addVertexSet("Banat");
		g.addVertexToSet("Banat","Mehadia");
		g.addVertexToSet("Banat","Timisoara");
		g.addVertexToSet("Banat","Lugoj");
		g.addVertexSet("Crisana");
		g.addVertexToSet("Crisana","Oradea");
		g.addVertexToSet("Crisana","Zerind");
		g.addVertexToSet("Crisana","Arad");
		g.addVertexSet("Dobrogea");
		g.addVertexToSet("Dobrogea","Eforie");
		g.addVertexToSet("Dobrogea","Hirsova");
		g.addVertexSet("Moldova");
		g.addVertexToSet("Moldova","Neamt");
		g.addVertexToSet("Moldova","Iasi");
		g.addVertexToSet("Moldova","Vaslui");
		g.addVertexSet("Muntenia");
		g.addVertexToSet("Muntenia","Bucharest");
		g.addVertexToSet("Muntenia","Urziceni");
		g.addVertexToSet("Muntenia","Pitesti");
		g.addVertexToSet("Muntenia","Giurgiu");
		g.addVertexSet("Oltenia");
		g.addVertexToSet("Oltenia","Craiova");
		g.addVertexToSet("Oltenia","Dobreta");
		g.addVertexSet("Transilvania");
		g.addVertexToSet("Transilvania","R. Vilcea");
		g.addVertexToSet("Transilvania","Sibiu");
		g.addVertexToSet("Transilvania","Fagaras");

		return g;
	}

}
