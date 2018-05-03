//import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
//import java.util.ListIterator;
import java.util.Map;

public class ShortestPath<V, E>
{
//	private GraphSanders<V, E> shortestPath;
//	private List<Edge> edgePath;
//	private double totalCost;
	
	class Node implements Comparable<Node>
	{
		private String name;
		private double cost;
		private Map<Node, Edge> edgeMap;
		
		public Node(String name)
		{
			this.name = name;
			this.cost = Double.POSITIVE_INFINITY;
			this.edgeMap = new HashMap<>();
		}

		public String getName() 
		{
			return name;
		}

		public void setName(String name) 
		{
			this.name = name;
		}

		public double getCost() 
		{
			return cost;
		}
		
		public void setCost(double cost)
		{
			this.cost = cost;
		}
		

		public Map<Node, Edge> getEdgeMap() 
		{
			return edgeMap;
		}

		public void setEdge(Node node, Edge edge) 
		{
			edgeMap.put(node, edge);
		}

		@Override
		public String toString() 
		{
			return "Node [name=" + name + ", cost=" + cost + "]";
		}

		@Override
		public int hashCode() 
		{
			final int prime = 31;
			int result = 1;
			long temp;
			temp = Double.doubleToLongBits(cost);
			result = prime * result + (int) (temp ^ (temp >>> 32));
			result = prime * result + ((name == null) ? 0 : name.hashCode());
			return result;
		}

		@SuppressWarnings("unchecked")
		@Override
		public boolean equals(Object obj)
		{
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Node other = (Node) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (Double.doubleToLongBits(cost) != Double.doubleToLongBits(other.cost))
				return false;
			if (edgeMap == null) {
				if (other.edgeMap != null)
					return false;
			} else if (!edgeMap.equals(other.edgeMap))
				return false;
			if (name == null) {
				if (other.name != null)
					return false;
			} else if (!name.equals(other.name))
				return false;
			return true;
		}

		@Override
		public int compareTo(ShortestPath<V, E>.Node o)
		{
			// TODO Auto-generated method stub
			double comp = cost - o.cost;
			if(comp < 0)
			{
				return -1;
			}
			if(comp > 0)
			{
				return 1;
			}
			if(comp == 0)
			{
				comp = ((Comparable<String>) name).compareTo(o.name);
				if(comp < 0)
				{
					return -1;
				}
				if(comp > 0)
				{
					return 1;
				}
				else
				{
					return 0;
				}
			}
		return 0;
		}

		private ShortestPath<V, E> getOuterType() 
		{
			return ShortestPath.this;
		}
	}
	
	public ShortestPath() {}
	
	public List<Node> findShortestPath(String from, String to, GraphSanders<V, E> graph)
	{
		PriorityQueueSanders<Node> vertices = new PriorityQueueSanders<Node>(graph.getNumVertices());
		Node vertex = new Node(from);
		vertex.setCost(0.0);
		vertices.enqueue(vertex);
		LinkedList<Node> path = new LinkedList<Node>();

		if(from.equals(to))
		{
			return path;
		}
		
		while(!vertices.isEmpty())
		{
			Node min = vertices.dequeue();
			if(graph.getVertexIsVisited(min.name))
	        {
	            continue;
	        }
			else
			{
	        	path.add(min);
	        	graph.setVertexToVisited(min.name);
//	        	vertices.enqueue(min);
	        	for(Edge edge : graph.getAllEdges(min.name))
				{
	        		double distance = min.cost + edge.getWeight();
	        		Node toVertex = new Node(edge.getTarget());
	        		if(!graph.getVertexIsVisited(toVertex.name) && toVertex.cost > distance)
	        		{
	        			toVertex.setCost(distance);
	        			toVertex.setEdge(toVertex, edge);
	        			vertices.enqueue(toVertex);
	        		}
				}
	        }
		}
		return path;
	}

//	private GraphSanders<V, E> buildShortestPathGraph(String from, String to, LinkedList<ShortestPath<V, E>.Node> path, GraphSanders<V, E> graph) 
//	{
//		shortestPath = new GraphSanders<V, E>();
//		shortestPath.addVertex(from, graph.getVertexData(from));
//		shortestPath.addVertex(to, graph.getVertexData(to));
//
//		edgePath = new ArrayList<Edge>();
//		totalCost = path.peek().cost;
////		Node cur = path.removeLast();
////		String target = cur.edgeMap.get(cur).getTarget();
////		String source = cur.edgeMap.get(cur).getSource();
////		shortestPath.addVertex(target, graph.getVertexData(target));
////		shortestPath.addEdge(source, target, cur.edgeMap.get(cur).getWeight());
////		ListIterator<Node> iter = path.listIterator(path.size());
//		while(!path.isEmpty())
//		{	
//			Node cur = path.removeLast();
//			if(cur.name.equals(to))
//			{
//				
//			}
//			String target = cur.edgeMap.get(cur).getTarget();
//			String source = cur.edgeMap.get(cur).getSource();
//			if(cur.edgeMap.get(cur).getTarget().equals(source) || cur.edgeMap.get(cur).getTarget().equals(to))
//			{
//				shortestPath.addVertex(target, graph.getVertexData(target));
//				shortestPath.addEdge(source, target, cur.edgeMap.get(cur).getWeight());
////				cur = path.removeLast();
//
//			}
//			else
//			{
//				cur = path.removeLast();
//
////				continue;	
//			}
//		}
//		return shortestPath;
//	}
//
//	public double getCost()
//	{
//		
//		return totalCost;
//	}
//	
//	public List<Edge> getEdgePath()
//	{
//		return edgePath;
//	}
	
}
