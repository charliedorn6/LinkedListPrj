package LinkedListPrj;

public class DoubleLinkedList<E>  {
	protected NodeD<E> top;      // The first NodeD<E> in the list
	protected NodeD<E> tail;

    // This instance variable is not required, however if you
    // find it useful, then you are welcome to use it
	protected NodeD<E> cursor;  // The current NodeD<E> in the list

	public DoubleLinkedList() {
		top = null;
		tail = null;
		cursor = null;
	}

	public E get(int position) {
		cursor = top;
		for (int i = 0; i < position; i++)
			cursor = cursor.getNext();
		return cursor.getData();

	}

	public String toString() {
		String retVal = "";
		NodeD<E> cur = top;
		while (cur != null) {
			retVal += cur.getData();
			cur = cur.getNext();
		}

		return retVal;
	}

	public int getLen() {
		int count = 0;

		NodeD<E> temp = top;
		while(temp != null)	{
			count++;
			temp = temp.getNext();
		}
		return count;
	}

	public void addTop(E data)	{
		if(top == null)	{
			top = tail = new NodeD<E>(data, null, null);
		}
		else	{
			top = new NodeD<E>(data, top, null);
			top.getNext().setPrev(top);
		}
	}

	public void addBottom(E data)	{
		if(top == null)	{
			addTop(data);
		}
		else	{
			tail = new NodeD<E>(data, null, tail);
			tail.getPrev().setNext(tail);
		}
	}

	public void insertBefore(E data, int index)	{
		if(index < 0 || index > getLen() - 1)
			throw new IllegalArgumentException();
		else if(top == null || index == 0)
			addTop(data);
		else {
			cursor = top;
			for(int i=0; i<index; i++)
				cursor = cursor.getNext();
			cursor.setPrev(new NodeD<E>(data, cursor, cursor.getPrev()));
			cursor.getPrev().getPrev().setNext(cursor.getPrev());
		}

	}


	// Create the rest of the needed methods.


}
