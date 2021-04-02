package bean;
import util.*;

public class Route implements Comparable{
	@Override
	public String toString() {
		return "Route [totalDistance=" + totalDistance + ", plan=" + plan + "]";
	}


	public double totalDistance;
	public Stack plan;
	
	
	public Route(Stack input) {
		totalDistance = (double)input.pop();
		plan = input;
		}


	@Override
	public int compareTo(Object o) {
		Route n = (Route) o;
		if(n.totalDistance < this.totalDistance) {
			return -1;
		}
		if(n.totalDistance > this.totalDistance) {
			return 1;
		}else {
			return 0;
		}
	}
	
	

}
