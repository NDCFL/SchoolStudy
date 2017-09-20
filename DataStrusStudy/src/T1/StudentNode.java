package T1;

public class StudentNode {

	StudentBean studentBean;
	StudentNode next;
	StudentNode prior;
	public StudentNode() {
	
	}
	public StudentNode(StudentBean studentBean) {
		this.studentBean=studentBean;
		next=null;
		prior=null;
	}
}
