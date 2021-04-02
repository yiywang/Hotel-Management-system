package bean;
import util.*;

public class Wing implements Comparable{
	private String wingName;
	
	public String getWingName() {
		return wingName;
	}

	public void setWingName(String wingName) {
		this.wingName = wingName;
	}

	@Override
	public String toString() {
		return "[" + wingName + "]";
	}

	@Override
	public int compareTo(Object o) {
		Wing n = (Wing) o;
		return n.wingName.compareTo(wingName);
	}
	

}
