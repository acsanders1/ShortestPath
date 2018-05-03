import java.util.ArrayList;
import java.util.List;

public class PrimMST<V, E> 
{
	private GraphSanders<V, E> tree;
	private List<Edge> edgePath;
	private double totalCost;
	
	public PrimMST() {}
	
	public GraphSanders<V, E> getMST(GraphSanders<V, E> graph)
	{
		tree = new GraphSanders<V, E>();
		if(graph == null)
		{
			throw (new NullPointerException("Graph is Empty."));
		}
		List<String> vertices = graph.getAllVertices();
		edgePath = new ArrayList<Edge>();
		PriorityQueueSanders<Edge> edgesAvailable = new PriorityQueueSanders<Edge>(graph.getNumEdges());
		String vertex = vertices.get(0);
		vertices.remove(vertex);

		while(!vertices.isEmpty())
		{
			for(Edge edge : graph.getAllEdges(vertex))
			{
				if(vertices.contains(edge.getTarget()))
				{
					edgesAvailable.enqueue(edge);
				}
			}
			Edge destinationEdge = edgesAvailable.dequeue();
			if(!graph.getVertexIsVisited(destinationEdge.getTarget()))
			{
				String origin = destinationEdge.getSource();
				String destination = destinationEdge.getTarget();
				tree.addVertex(origin, graph.getVertexData(origin));
				edgePath.add(destinationEdge);
				tree.addEdge(origin, destination, destinationEdge.getWeight());
				totalCost += (double) destinationEdge.getWeight();
				graph.setVertexToVisited(destinationEdge.getTarget());
				vertex = destinationEdge.getTarget();
				vertices.remove(vertex);
			}

		}
		return tree;
	}
	
	public double getCost()
	{
		
		return totalCost;
	}
	
	public List<Edge> getEdgePath()
	{
		return edgePath;
	}
	
}
