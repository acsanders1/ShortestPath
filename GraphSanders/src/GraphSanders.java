import java.util.ArrayList;
//import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphSanders<V, E> 
{
	private Map<String, List<Edge>> adjList;
	private Map<String, Vertex<V>> vertices;
	private Map<Pair<String>, Double> costs;

	private int numVertices;
	private int numEdges;
	
	public GraphSanders()
	{
		adjList = new HashMap<>();
		vertices = new HashMap<>();
		costs = new HashMap<>();
	}
	
	public void addVertex(String label, V vertexData) 
	{
		Vertex<V> vertexToAdd = new Vertex<V>(label, vertexData);
		vertices.put(label, vertexToAdd);
		numVertices++;
	}
	
	public void setVertexToVisited(String label)
	{
		vertices.get(label).setIsVisited(true);
	}
	
	public boolean getVertexIsVisited(String label)
	{
		return vertices.get(label).getIsVisited();
	}
	
	public void resetVertices()
	{
		for(String vertex : vertices.keySet())
		{
			vertices.get(vertex).setIsVisited(false);
		}
	}
	
	public V getVertexData(String label)
	{
		return (V) vertices.get(label).getVertex();
	}
	
	public void addEdge(String origin, String destination, double weight)
	{
		List<Edge> temp = new ArrayList<>();
		if(!adjList.containsKey(origin))
		{
			adjList.put(origin, temp);
			addEdge(origin, destination, weight);
		}
		else if(!adjList.containsKey(destination))
		{
			adjList.put(destination, temp);
			addEdge(origin, destination, weight);
		}
		else
		{
			addEdgeHelper(origin, destination, weight);
			addEdgeHelper(destination, origin, weight);
		}	
	}
	
	public void addEdgeHelper(String origin, String destination, double weight)
	{
		Edge edgeToAdd = new Edge(origin, destination);
		costs.put(new Pair<String>(origin, destination), weight);
		edgeToAdd.setWeight(weight);
		adjList.get(origin).add(edgeToAdd);
		numEdges++;
	}
	
	public void removeVertexAndEdges(String vertexToRemove)
	{
		numEdges -= adjList.get(vertexToRemove).size();
		adjList.remove(vertexToRemove);
		numVertices--;
		for(String vertex : getAllVertices())
		{
			for(Edge edge : getAllEdges(vertex))
			{
				if(edge.getSource().equals(vertexToRemove) || edge.getTarget().equals(vertexToRemove))
				{
					adjList.get(vertex).remove(edge);
					numEdges--;
				}
			}
		}
	}

	public List<String> getAllVertices()
	{
		List<String> vertices =  new ArrayList<String>();
		vertices.addAll(adjList.keySet());
		return vertices;
	}
	
	public List<Edge> getAllEdges(String label)
	{
		List<Edge> neighbors = new ArrayList<Edge>();
		neighbors = adjList.get(label);
		return neighbors;
	}
	
	public int getNumVertices()
	{
		return numVertices;
	}
	
	public int getNumEdges()
	{
		return numEdges;
	}
	
	public Map<String, List<Edge>> getGraph()
	{
		return adjList;
	}

	public void printGraph() 
	{
		for (String vertex : adjList.keySet())
		{
		    System.out.println("Vertex: " + vertex + "; Edges: " + adjList.get(vertex));
		}
	}

	public double getEdgeWeight(String source, String destination) 
	{
		return costs.get(new Pair<String>(source, destination));
	}
	
}