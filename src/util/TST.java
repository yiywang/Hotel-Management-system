package util;

public class TST {

	public static void main(String[] args) {
		
		int a = 1;
		int b = 2;
		int c = 3;
		int d = 4;
		

		MatrixGraph x =new MatrixGraph(4);
		x.addNode(a);
		x.addNode(b);
		x.addNode(c);
		x.addNode(d);
		
		
		x.addEdge(a, b, 1.0);
		x.addEdge(a, c, 2.0);
		x.addEdge(b, d, 3.0);
		x.addEdge(b, c, 1.0);
		x.addEdge(c, d, 4.0);
		System.out.println(x);
		
		LinkedList res = new LinkedList();
		
		res = x.getEveryPath(a, d);
		System.out.println(res);
//		
//		
	
	}

}
