package hw2;

import java.util.EmptyStackException;

public class LinkedStack<T> implements StackInterface<T> 
{
	private Node topNode;
	
	public LinkedStack()
	{
		topNode = null;
	}
	
	private class Node
	{
		private T data;
		private Node next;
		
		private Node(T dataPortion)
		{
			this(dataPortion, null);
		}
		
		public Node(T dataPortion, Node nextNode) 
		{
			data = dataPortion;
			next = nextNode;
		}
		
		public T getData() 
		{
			return data;
		}
		
		private void setData(T newData) 
		{
			data = newData;
		}

		public Node getNextNode() 
		{
			return next;
		}
		
		public void setNextNode(Node nextNode) 
		{
			next = nextNode;
		}
		
	} // End inner class Node.
	
	@Override
	public void push(T newEntry) 
	{
		Node newNode = new Node(newEntry, topNode);
		topNode = newNode;
	}

	@Override
	public T pop() 
	{
		T top = peek();
		assert topNode != null;
		topNode = topNode.getNextNode();
		return top;
	}

	@Override
	public T peek() 
	{
		if(isEmpty())
			throw new EmptyStackException();
		else
			return topNode.getData();
	}

	@Override
	public boolean isEmpty() 
	{
		return topNode == null;
	}

	@Override
	public void clear() 
	{
		topNode = null;
	}
	
} // End class LinkedStack
