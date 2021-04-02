package util;
public class LinkedList {
	
	private class ListElement {
		private Object el1;
		private ListElement el2;

		public ListElement(Object el, ListElement nextElement) {
			el1 = el;
			el2 = nextElement;
		}

		public ListElement(Object el) {
			this(el, null);
		}

		public Object first() {
			return el1;
		}

		public ListElement rest() {
			return el2;
		}

		public void setFirst(Object value) {
			el1 = value;
		}

		public void setRest(ListElement value) {
			el2 = value;
		}
	}
	
	private ListElement head;

	public LinkedList() {
		head = null;
	}

	public void addFirst(Object o) {
		head = new ListElement(o, head);
	}

	public Object getFirst() {
		return head.first();
	}

	public Object get(int n) {
		ListElement a = head;
		while (n > 0) {
			a = a.rest();
			n--;
		}
		return a.first();
	}
	
	public String toString() {
		String s = "(";
		ListElement a = head;
		while (a != null) {
			s += a.first().toString();
			s += " ";
			a = a.rest();
		}
		s += ")";
		return s;
	}
	
	public int size(){

		int count = 0;
		
		ListElement a = head;
		
		while(a!=null){

			count++;
			a = a.rest();
		}
		return count;
	}
	
	public void set(int n,Object o){

        ListElement a = head;
        while(n > 1){

            a = a.rest();
            
            n--;
        }
        
        a.setFirst(o);
        
    }
	
	public Object getLast(){

        ListElement d = head;
        while(d.rest()!=null){

            d = d.rest();
        }
        return d.first();
    }
	
	public void addLast(Object o){

		if (head == null) {

			head = new ListElement(o, null);
		} else {

			ListElement a = head;
			while (a.rest() != null) {

				a = a.rest();
			}
			ListElement addElement = new ListElement(o);
			a.setRest(addElement);
		}
	}
	
	public Boolean contain(Object element){

		ListElement a = head;
		while (a != null) {

			if (element == a.first()) {

				return true;
			}else{
				a = a.rest();
			}
		}
        return false;
    }
	
	public Boolean isEmpty(){

		return head == null;
	}
	public void removeIndex(int index){

		if(index == 0){

			head = head.el2;
			return;
		}
		ListElement h = head;
		while(index > 1){

			h = h.el2;
			index --;
		}
		h.setRest(h.rest().rest());
	}
	public int getIndex(Object element){

		ListElement d = head;
		int index = 1;
		while(d!=null){

			if(element==d.first()){

				return index-1;
			}
			else{
				index++;
				d = d.rest();
			}
		}
		return 0;
	}
	public void remove(Object o){

		int index = getIndex(o);
		if(index == -1)
			return;
		else{

			removeIndex(index);
		}
	}
    public LinkedList copy(){

        LinkedList newLinkedList = new LinkedList();
        ListElement d = head;
        while(d != null){

            newLinkedList.addLast(d.el1);
            d = d.el2;
        }
        return newLinkedList;
    }
    public void removeLast(){

        ListElement d = head;
        if(d.rest() == null){
            head = null;
        }
        else{
            while(d.rest().rest() != null){
                d = d.rest();
            }
            d.setRest(null);
        }
    }

}
