package util;
public class Vector
{
	protected Object data[];
	protected int count;
	protected int capacity;

	public Vector(int capacity)
	{
		data = new Object[capacity];
		count = 0;
	}
	public Vector()
	{
		data = new Object[10];
		count = 0;
	}
	
	public int size()
	{
		return count;
	}

	public boolean isEmpty()
	{
		return size() == 0;
	}

	public Object get(int index)
	{
		return data[index];
	}

	public void set(int index, Object obj)
	{
		data[index] = obj;
	}

	public boolean contains(Object obj)
	{
		for(int i=0;i<count;i++)
		{
			if(data[i] == obj) return true;
		}
		return false;
	}

	public void addFirst(Object item)
	{
		if (capacity == count) {
			extendCapacity();
		}
		for(int i = (count - 2) ; i >= 1;i--) {
			set(i,data[i - 1]);
		}

		data[0] = item;
		count ++;
	}

	public void addLast(Object o)
	{
		if (capacity == count) {
			extendCapacity();
		}
		data[count] = o;
		count++;
	}

	public Object getFirst()
	{
		return data[0];
	}

	public Object getLast()
	{
		return data[count - 1];
	}

	public void removeLast()
	{
		data[count-1] = null;
		count--;
	} 

	public void removeFirst()
	{

		for(int i=0;i<(count-1);i++){
			set(i,data[i + 1]);
		}
		data[count-1] = null;
		count--;
	}
	private void extendCapacity(){

        if(capacity==count){

            Object data2[];
            data2 = new Object[capacity*2];
            for(int i=0;i<capacity;i++){

                data2[i] = data[i];
            }
            data = data2;
            capacity = capacity*2;
        }
    }
}