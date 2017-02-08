package hw2;

import java.util.EmptyStackException;
import java.util.Vector;

public class VectorStack<T> implements StackInterface<T> {

	private Vector<T> stack;
	private boolean initialized = false;
	private static final int DEFAULT_CAPACITY = 20;
	private static final int MAX_CAPACITY = 500;
	
	public VectorStack()
	{
		this(DEFAULT_CAPACITY);
	}
	
	public VectorStack(int capacity)
	{
		checkCapacity(capacity);
		stack = new Vector<>(capacity);
		initialized = true;
	}
	
	private void checkCapacity(int capacity) {
		// TODO Auto-generated method stub
		if(capacity > MAX_CAPACITY)
			throw new IllegalStateException("Attempt to create a stack whose capacity exceeds allowed maximum of " + MAX_CAPACITY);
	}
	
	private void checkInitialization() {
		if(!initialized)
			throw new SecurityException("ArrayStack object is not initialized properly.");
	}

	@Override
	public void push(T newEntry) {
		checkInitialization();
		stack.add(newEntry);
	}

	@Override
	public T pop() {
		checkInitialization();
		if(isEmpty())
			throw new EmptyStackException();
		else
			return stack.remove(stack.size() - 1);
	}

	@Override
	public T peek() {
		checkInitialization();
		if(isEmpty())
			throw new EmptyStackException();
		else
			return stack.lastElement();
	}

	@Override
	public boolean isEmpty() {
		return stack.isEmpty();
	}

	@Override
	public void clear() {
		stack.clear();
	}

} // end class VectorStack
