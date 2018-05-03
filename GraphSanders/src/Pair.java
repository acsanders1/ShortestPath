//import java.util.Objects;

/**
 * @author Alan Sanders
 *This class makes pairs of generic types
 * @param <E>
 */
public class Pair<E> 
{
	private E first;
	private E second;
	
	public static <E> Pair<E> of(E e1, E e2) 
	{
	    return new Pair<E>(e1, e2);
	}
    /**
     * constructor that takes a first generic and a second generic
     * @param first
     * @param second
     */
    public Pair(E first, E second)
	{
		this.first(first);
		this.second(second);
	}
    
    private Pair<E> first(E e) 
	{
		// TODO Auto-generated method stub
		this.first = e;
		return this;
	}
    
    private Pair<E> second(E e) 
    {
		// TODO Auto-generated method stub
		return this;
	}
	/**
     * @return
     */
    public E getFirst()
    {
    	return first;
    }
    /**
     * @return
     */
    public E getSecond()
    {
    	return second;
    }
    /**
     * @param pfirst
     */
    public void setFirst(E first)
    {
    	this.first = first;
    }
    /**
     * @param psecond
     */
    public void setSecond(E second)
    {
    	this.second = second;
    }	
    /* 
     * overrides the toString method to print a Pair
     */
    @Override
    public String toString()
    {
    	return String.format(first + " " + second);
    }
	/* 
	 * overrides the compareTo method to compare Pairs
	 */
	@Override
	public int hashCode() 
	{
		return ((getFirst() == null) ? 0 : getFirst().hashCode()) ^ ((getSecond() == null) ? 0 : getSecond().hashCode());
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
		Pair<E> other = (Pair<E>) obj;
		if (first == null) {
			if (other.first != null)
				return false;
		} else if (!first.equals(other.first))
			return false;
		if (second == null) {
			if (other.second != null)
				return false;
		} else if (!second.equals(other.second))
			return false;
		return true;
	}


}

