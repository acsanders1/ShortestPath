
public class Vertex<V>
{
	private V vertex;
	private String label;
	private boolean isVisited;

	public Vertex(String label, V vertex)
	{
		this.label = label;
		this.vertex = vertex;
		this.isVisited = false;
	}

	public V getVertex() 
	{
		return vertex;
	}

	public void setVertex(V vertex) 
	{
		this.vertex = vertex;
	}

	public String getLabel()
	{
		return label;
	}

	public void setLabel(String label) 
	{
		this.label = label;
	}

	public boolean getIsVisited() 
	{
		return isVisited;
	}

	public void setIsVisited(boolean isVisited) 
	{
		this.isVisited = isVisited;
	}
	
}
