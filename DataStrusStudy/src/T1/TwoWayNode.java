package T1;

public class TwoWayNode {

	String name;
	TwoWayNode next;
	TwoWayNode prior;
	public TwoWayNode() {
	
	}
	public TwoWayNode(String name) {
		this.name=name;
		next=null;
		prior=null;
	}
}
