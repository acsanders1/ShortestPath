//import ShortestPath.Node;

public class GraphSandersTester 
{
	public static void main(String[] args) 
	{
		Dummy d = new Dummy(12.0, 5);
		GraphSanders<Dummy, Double> dest = new GraphSanders<Dummy, Double>();
		dest.addVertex("Oskaloosa", d);
		dest.addVertex("Pella", d);
		dest.addVertex("Des Moines", d);
		dest.addVertex("Ottumwa", d);
		dest.addVertex("Fremont", d);
		dest.addVertex("Ames", d);
//		dest.printGraph();
//		dest.removeVertexAndEdges("Oskaloosa");
//		dest.printGraph();
//		dest.addEdge("Oskaloosa", "Ottumwa", 30.0);
//		dest.addEdge("Oskaloosa", "Pella", 11.0);
//		dest.addEdge("Ames", "Nevada", 12.0);
//		dest.addEdge("Pella", "Des Moines", 40.0);
//		dest.addEdge("Pella", "Ottumwa", 41.0);
		dest.addEdge("Oskaloosa", "Pella", 10.0);
		dest.addEdge("Oskaloosa", "Ottumwa", 1.0);
		dest.addEdge("Oskaloosa", "Des Moines", 15.0);
		dest.addEdge("Pella", "Des Moines", 7.0);
		dest.addEdge("Pella", "Ottumwa", 10.0);
		dest.addEdge("Pella","Fremont", 7.0);
		dest.addEdge("Ottumwa", "Fremont", 11.0);
		dest.addEdge("Fremont", "Ames", 9.0);
		dest.addEdge("Ames", "Des Moines", 6.0);
		dest.printGraph();
		System.out.println(dest.getNumVertices());
		System.out.println(dest.getNumEdges());
//		String vertex = "Oskaloosa";
		PrimMST<Dummy, Double> prim = new PrimMST<Dummy, Double>();
		GraphSanders<Dummy, Double> mst = prim.getMST(dest);
		mst.printGraph();
		System.out.println(prim.getCost());
		System.out.println(prim.getEdgePath().toString());
		dest.resetVertices();
		ShortestPath<Dummy, Double> sp = new ShortestPath<Dummy, Double>();
//		PriorityQueueSanders<Node> dijk = sp.findShortestPath("Ames", "Oskaloosa", dest);
		System.out.println(sp.findShortestPath("Ames", "Oskaoosa", dest).toString());

//		dijk.printGraph();

//		System.out.println(sp.getCost());
//		System.out.println(sp.getEdgePath().toString());
//		dest.removeVertexAndEdges("Pella");
//		dest.printGraph();
//		System.out.println(dest.getNumVertices());
//		System.out.println(dest.getNumEdges());
	}
}
