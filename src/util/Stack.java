package util;

public class Stack {
	
	

    private LinkedList data;
    
    
    
    

    @Override
	public String toString() {
		return "[" + data + "]";
	}

	public Stack(){

        data = new LinkedList();
    }

    public void push(Object o){

        data.addLast(o);
    }

    public Object pop(){

        Object element = data.getLast();
        data.removeLast();
        return element;
    }

    public Object top(){

        return data.getLast();
    }

    public int size(){

        return data.size();
    }

    public boolean empty(){

        return data.size()==0;
    }

    public Stack copy(){

        Stack newStack = new Stack();
        LinkedList newList = data.copy();
        newStack.data = newList;
        return newStack;
    }
    
}