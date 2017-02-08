package hw2;

import java.util.EmptyStackException;

/**
 * 
 * @author Jeremy Canning
 * An implementation of the stack interface as a
 * fixed size array of size 10.
 */

public final class ArrayStack<T> implements StackInterface<T>
{
	private T[] stack;
	private int topIndex;
	private boolean initialized = false;
	private static final int DEFAULT_CAPACITY = 10;
	
	public ArrayStack()
	{
		this(DEFAULT_CAPACITY);
	}
	
	private ArrayStack(int capacity)
	{	
		@SuppressWarnings("unchecked")
		T[] tempStack = (T[])new Object[capacity];
		stack = tempStack;
		topIndex = -1;
		initialized = true;
	}
	
	@Override
	public void push(T newEntry) {
		checkInitialization();
		try{
			stack[topIndex + 1] = newEntry;
			topIndex++;
		}catch(ArrayIndexOutOfBoundsException e)
		{
			System.out.println("Stack is full.");
		}
	}

	@Override
	public T pop() {
		checkInitialization();
		if(isEmpty())
			throw new EmptyStackException();
		else
		{
			T top = stack[topIndex];
			stack[topIndex] = null;
			topIndex--;
			return top;
		}
	}

	@Override
	public T peek() {
		// TODO Auto-generated method stub
		checkInitialization();
		if(isEmpty())
			throw new EmptyStackException();
		else
			return stack[topIndex];
	}

	private void checkInitialization() {
		if(!initialized)
			throw new SecurityException("ArrayStack object is not initialized properly.");
		
	}

	@Override
	public boolean isEmpty() {
		return topIndex < 0;
	}

	@Override
	public void clear() {
		while(!isEmpty())
			pop();
		
	}
	
}
