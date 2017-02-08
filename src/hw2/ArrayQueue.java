package hw2;
//////////////////////////////////////////////////////////
public class ArrayQueue<T> implements QueueInterface<T> 
{
	private T[] queue;
	
	private int frontIndex;
	private int backIndex;
	private boolean initialized = false;
	private static final int DEFAULT_CAPACITY = 10;
	private static final int MAX_CAPACITY = 500;
	
	public ArrayQueue()
	{
		this(DEFAULT_CAPACITY);
	} // end default constructor
	
	public ArrayQueue(int capacity)
	{
		checkCapacity(capacity);
		@SuppressWarnings("unchecked")
		T[] tempQueue = (T[]) new Object[capacity + 1];
		queue = tempQueue;
		frontIndex = 0;
		backIndex = capacity;
		initialized = true;
	} // end constructor
	
	private void checkCapacity(int capacity) {
		// TODO Auto-generated method stub
		if(capacity > MAX_CAPACITY)
			throw new IllegalStateException("Attempt to create a stack whose capacity exceeds allowed maximum of " + MAX_CAPACITY);
	} // end checkCapacity
	
	private void checkInitialization() {
		if(!initialized)
			throw new SecurityException("ArrayStack object is not initialized properly.");
	} // end checkInitialization
	
	@Override
	public void enqueue(T newEntry) 
	{
		checkInitialization();
		try{
			backIndex = (backIndex + 1 % queue.length);
			queue[backIndex] = newEntry;
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("Queue is full.");
		}
	} // end enqueue

	@Override
	public T dequeue() 
	{
		checkInitialization();
		if(isEmpty())
			throw new EmptyQueueException("The queue is empty");
		else
		{
			T front = queue[frontIndex];
			queue[frontIndex] = null;
			frontIndex = (frontIndex + 1) % queue.length;
			return front;
		}
	} // end dequeue

	@Override
	public T getFront() 
	{
		checkInitialization();
		if(isEmpty())
			throw new EmptyQueueException("The queue is empty.");
		else
			return queue[frontIndex];
	} // end getFront

	@Override
	public boolean isEmpty() 
	{
		return frontIndex == ((backIndex + 1) % queue.length);
	} // end isEmpty

	@Override
	public void clear() 
	{
		while(!isEmpty())
			dequeue();
	} // end clear

} // end class ArrayQueue
//////////////////////////////////////////////////////////
