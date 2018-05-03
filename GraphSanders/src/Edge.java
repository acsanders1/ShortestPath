public class Edge implements Comparable<Edge>
{
	private String source;
	private String target;
	private double weight;
	
	public Edge(String source, String target)
	{
		this.source = source;
		this.target = target;
		weight = 0.0;
	}

	public String getSource() 
	{
		return source;
	}

	public void setSource(String source) 
	{
		this.source = source;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) 
	{
		this.target = target;
	}
	
	public void setWeight(double weight) 
	{
		this.weight = weight;
	}
	
	public double getWeight()
	{
		return weight;
	}
	
	@Override
	public String toString() 
	{
		return "Edge [from=" + source + ", to=" + target + ", weight=" + weight + "]";
	}
	
	@Override
	public int compareTo(Edge edge) 
	{
		// TODO Auto-generated method stub
			double comp = weight - edge.weight;
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
				comp = ((Comparable<String>) source).compareTo(edge.source);
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

	@Override
	public int hashCode() 
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((source == null) ? 0 : source.hashCode());
		result = prime * result + ((target == null) ? 0 : target.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Edge other = (Edge) obj;
		if (source == null) {
			if (other.source != null)
				return false;
		} else if (!source.equals(other.source))
			return false;
		if (target == null) {
			if (other.target != null)
				return false;
		} else if (!target.equals(other.target))
			return false;
		return true;
	}
	
//	class LoopHole 
//	{
//	    public static void main(String[] args) 
//	    {
//	        Edge<String, Double>[] bsa = new Edge<String, Double>[3];
//	        Object[] o = bsa;
//	        o[0] = new Edge<String, Double>(3); 
//	        String s = bsa[0].vertex; // BOOM!
//	    }
//	}
	
}
