package Test;

public class StrusNode {

	StudentBean studentBean;
	StrusNode next;
	public StrusNode(StudentBean studentBean) {
		this.studentBean = studentBean;
		next=null;
	}
	public StrusNode() {
	}
}
