package util;


public class MatrixGraph 
{
	private Matrix data;
	private LinkedList nodes;
	
	
	
	@Override
	public String toString() {
		return "" + data ;
	}

	public MatrixGraph(int nrNodes)
	{
		data = new Matrix(nrNodes);
		nodes = new LinkedList();
		for(int i=0;i<nrNodes;i++) {
			for(int j = 0; j<nrNodes;j++) {
				data.set(i, j, 0); 
			}
		}
	}
	
	public void addNode(Object Node) {
		nodes.addLast(Node);
	}
	
	public void addEdge(Object fromNode, Object toNode, double w)
	{
		int from = nodes.getIndex(fromNode);
		int to =nodes.getIndex(toNode);
		data.set(from, to, w);
		data.set(to,from, w);
	}
	
	public int getID(Object Node) {
		return nodes.getIndex(Node);
	}
	public Object getNode(int Index) {
		return nodes.get(Index);
	}
	public int getEdgeWeight(int from, int to)
	{
		return (int)data.get(from, to);
	}
	
	public LinkedList getAdjadents(Object Node) {
		LinkedList res = new LinkedList();
		int ID=nodes.getIndex(Node);
		for(int i =0; i<nodes.size();i++) {
			if(data.get(ID, i) != 0) {
				Object temp = nodes.get(i);
				res.addLast(temp);
			}
		}
		return res;
	}
	public LinkedList getAdjadentsID(Object Node) {
		LinkedList res = new LinkedList();
		int ID=nodes.getIndex(Node);
		for(int i =0; i<nodes.size();i++) {
			if(data.get(ID, i) != 0) {
				res.addLast(i);
			}
		}
		return res;
	}
	//to get every paths from startN to endN, output is a Linkedlist of Stack ,
	//the total distance of the path is on the top of stack
	// the path from Object to Object is following the top
	public LinkedList getEveryPath(Object startN,Object endN) {
		//to initialize the two stack and the result receiving list
		Stack main = new Stack();
		Stack vice = new Stack();
		int EndNID = nodes.getIndex(endN);
		LinkedList paths = new LinkedList();
		
		// build the stack
		main.push(startN);
		vice.push(getAdjadents(startN));
		
		//the main stack is not empty
		while(main.empty()==false) {
			// get the list from viceTop which is the adjadent node list
			LinkedList viceTop = (LinkedList) vice.top();
			if(viceTop.isEmpty()==false) {
				// get the first adjadent node from the node list  
				//and push it, remove it's first element		
				main.push(viceTop.getFirst());
				viceTop.removeIndex(0);
				//to test if the adjadent node is already in the main stack
				Stack testStack = main.copy();
				LinkedList tosAdjadents = getAdjadents(main.top());
				LinkedList tosAdjadentsIDs = getAdjadentsID(main.top());
				boolean isFlag = true;
				
				while(isFlag==true) {
					
					int tempMainID = getID(testStack.pop());
					
					for(int i =0;i<tosAdjadents.size();i++) {
						int tempAjID =(int) tosAdjadentsIDs.get(i);
						if(tempMainID == tempAjID) {
							Object thisone = nodes.get(tempAjID);
							tosAdjadents.remove(thisone);
						}
						
						
					}
					if(testStack.empty()) {
						isFlag = false;
					}
					
				}
				
				vice.push(tosAdjadents);
			}else {
				//reduce the stack
				main.pop();
				vice.pop();
				continue;
			}
			

			if(nodes.getIndex(main.top())==EndNID) {
				Stack toSumWeight = main.copy();
				double countWeight = 0.0;
				while(toSumWeight.size()>1) {
					Object t1 =toSumWeight.pop();
					Object t2 =toSumWeight.top();
					int t1ID = getID(t1);
					int t2ID = getID(t2);
					countWeight = countWeight + getEdgeWeight(t1ID, t2ID);
				}
				Stack toBeAdd = main.copy();
				toBeAdd.push(countWeight);
				paths.addFirst(toBeAdd);
				//reduce the stack
				main.pop();
				vice.pop();
			}
			
		}
		return paths;
	}
	
	
	
}