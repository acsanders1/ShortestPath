import java.util.Arrays;

//import java.util.ArrayList;
//import java.util.List;

/**
 * This class implements a queue using a linked list.
 * @author Alan
 */
public class PriorityQueueSanders<S> 
{
	private S[] queue;
	private int numItems;
	private int maxSize;
//	private Comparable comp;
	/**
	 * This constructor creates a linked list of objects and 
	 * and initializes the number of objects in the list to zero.
	 */
	@SuppressWarnings("unchecked")
	public PriorityQueueSanders(int maxSize)
	{
		this.maxSize = maxSize;
		queue = (S[]) new Comparable[maxSize];
		numItems = 0;
	}
	
	/**
	 * This method adds an object to the end of the queue.
	 * @param o Object to be inserted into queue
	 */
	@SuppressWarnings("unchecked")
	public boolean enqueue(S edge)
	{
		if(numItems==maxSize)
		{
			return false;
		}	
		queue[numItems] = edge;
		numItems++;
		int index = numItems - 1;
		int parent = (index - 1)/2;
		while(parent != index && ((Comparable<S>) queue[index]).compareTo(queue[parent]) < 0)
		{
			S temp = queue[parent];
			queue[parent] = queue[index];
			queue[index] = temp;
			index = parent;
			parent = (index - 1)/2;
		}
		return true;
	}
	/**
	 * This method removes an object from the beginning of the 
	 * queue.
	 * @return o
	 */
	@SuppressWarnings("unchecked")
	public S dequeue()
	{
		if(numItems == 1)
		{
			numItems--;
			return queue[0];
		}
		int min = 0;
	    S edgeToDequeue = queue[min];
	    S lastEdge = queue[--numItems];
	    queue[numItems] = null;
	    queue[min] = lastEdge;
	    int index = 0;

	    int leftChild = 2*index+1;
	    int rightChild = 2*leftChild+2;
	    int smallerChild = -1;
	    if(leftChild <= numItems-1 && ((Comparable<S>) queue[leftChild]).compareTo(queue[index]) < 0)
	    {
	    	smallerChild = leftChild;
	    }
	    else
	    {
	    	smallerChild = index;
	    }
	    if(rightChild <= numItems-1 && ((Comparable<S>) queue[rightChild]).compareTo(queue[smallerChild]) < 0)
	    {
	    	smallerChild = rightChild;
	    }
	    if(smallerChild != index)
	    {
	    	S temp = queue[smallerChild];
	    	queue[smallerChild] = queue[index];
		    queue[index] = temp;
	    }
	    return edgeToDequeue;
	}
	/**
	 * This method determines whether or not there are any objects
	 * in the queue.
	 * @return true or false
	 */
	public boolean isEmpty()
	{
		return numItems == 0;
	}
	
	public int size()
	{
		return numItems;
	}

	public S peek() 
	{
		return queue[0];
	}
	
	@Override
	public String toString() 
	{
		return "PriorityQueueSanders [queue=" + Arrays.toString(queue) + "]";
	}
	
}
