package StudentManger;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.JTableHeader;
public class StudentFace extends JFrame implements ActionListener{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton add,close,delete,update,btfind,ponegrade,psumgrade,pavegrade,pstudid,maxgrade,mingrade,youxiu,notjige;
	JTable table;
	JPanel panel;
	JLabel lb1;
	JTextField find;
	JTableHeader head;
	String title[]={"学号","姓名","班级","语文成绩","数学成绩","英语成绩"};
	String data[][]=new String[90][6];
	JScrollPane js;
	BaseDAOimp sql = new BaseDAOimp();
	String dataString=null;
	public StudentFace() {
		setTitle("学生管理系统");
		data();
		panel = new JPanel(null);
		table = new JTable(data,title);
		table.setBounds(0, 50, 500, 300);
		table.setRowHeight(30);
		table.setFont(new Font("楷体",Font.BOLD,16));
		// 滚动面板
		js = new JScrollPane(table);
		js.setBounds(0,50,780, 292);
		panel.add(js);
		lb1 = new JLabel("学生管理系统");
		lb1.setBounds(320, 10, 200, 30);
		lb1.setFont(new Font("楷体",Font.BOLD,24));
		panel.add(lb1);
		
		btfind = new JButton("搜索");
		btfind.setBounds(230, 360, 60, 30);
		panel.add(btfind);
		
		maxgrade = new JButton("最高分");
		maxgrade.setBounds(300, 360, 80, 30);
		panel.add(maxgrade);
		
		mingrade = new JButton("最低分");
		mingrade.setBounds(390, 360, 80, 30);
		panel.add(mingrade);

		youxiu = new JButton("优秀率");
		youxiu.setBounds(480, 360, 80, 30);
		panel.add(youxiu);
		
		notjige = new JButton("不及格率");
		notjige.setBounds(570, 360, 100, 30);
		panel.add(notjige);
		
		find = new JTextField();
		find.setBounds(20, 360, 200, 30);
		panel.add(find);
		
		delete = new JButton("删除");
		delete.setBounds(20, 400, 60, 30);	
		panel.add(delete);
		
		update = new JButton("修改");
		update.setBounds(100, 400, 60, 30);
		panel.add(update);
		
		add = new JButton("新增");
		add.setBounds(180, 400, 60, 30);
		panel.add(add);
		
		ponegrade = new JButton("单科排序");
		ponegrade.setBounds(260, 400, 120, 30);
		panel.add(ponegrade);
		
		psumgrade = new JButton("总成绩排序");
		psumgrade.setBounds(390, 400, 120, 30);
		panel.add(psumgrade);
		
		pavegrade = new JButton("平均成绩排序");
		pavegrade.setBounds(520, 400, 120, 30);
		panel.add(pavegrade);
		
		pstudid = new JButton("学号排序");
		pstudid.setBounds(650, 400, 120, 30);
		panel.add(pstudid);
		
		add(panel);
		setSize(800, 500);
		delete.addActionListener(this);
		update.addActionListener(this);
		add.addActionListener(this);
		maxgrade.addActionListener(this);
		mingrade.addActionListener(this);
		youxiu.addActionListener(this);
		notjige.addActionListener(this);
		ponegrade.addActionListener(this);
		psumgrade.addActionListener(this);
		pavegrade.addActionListener(this);
		pstudid.addActionListener(this);
		
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new StudentFace();
	}
	public void data(){
		List<StudentVo> student=null;
		student = sql.studentlist();
		for (int i = 0; i < student.size(); i++) {
			StudentVo studentVo = student.get(i);
			data[i][0]=studentVo.getSno()+"";
			data[i][1]=studentVo.getStudentname();
			data[i][2]=studentVo.getSsex();
			data[i][3]=studentVo.getSage()+"";
			data[i][4]=studentVo.getShobit();
			data[i][5]=studentVo.getSzhuanye();
		}
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==delete){
			int index=table.getSelectedRow();
			sql.deletestudent(data[index][0]);
			dispose();
			new StudentFace();
		}
		if(e.getSource()==update){
			int index=table.getSelectedRow();
			StudentVo studentVo = sql.findStudentVo(data[index][0]);
			new studentupdate(studentVo);
		}
		if(e.getSource()==add){
			dispose();
			new studentadd();
		}
		if(e.getSource()==maxgrade){
			List<StudentVo> student=null;
			student = sql.find("select * from studentmanager where sage =(select max(sage) from  studentmanager)  or shobit = (select max(shobit) from  studentmanager) or szhuanye= (select max(szhuanye) from  studentmanager)");
			new Studentdata(student,"各科最高分");
		}
		if(e.getSource()==mingrade){
			List<StudentVo> student=null;
			student = sql.find("select * from studentmanager where sage =(select min(sage) from  studentmanager)  or shobit = (select min(shobit) from  studentmanager) or szhuanye= (select min(szhuanye) from  studentmanager)");
			new Studentdata(student,"各科最低分");
		}
		if(e.getSource()==youxiu){
			List<StudentVo> student=null;
			student = sql.find("select * from studentmanager where sage>90  or shobit >90 or szhuanye>90 ");
			List<StudentVo> student1=sql.studentlist();
			String youiu = student.size()/student1.size()+"%";
			if(youiu==null || youiu.equals(""))
				youiu="0";
			JOptionPane.showMessageDialog(null, "优秀率\n优秀人数："+student.size()+"\n优秀率="+youiu);
			
		}
		if(e.getSource()==notjige){
			List<StudentVo> student=null;
			student = sql.find("select * from studentmanager where sage<60  or shobit<60 or szhuanye<60 ");
			List<StudentVo> student1=sql.studentlist();
			String youiu = (float)student.size()/(float)student1.size()+"%";
			if(youiu==null || youiu.equals(""))
				youiu="0";
			JOptionPane.showMessageDialog(null, "不及格率\n不及格人数："+student.size()+"\n不及格率="+youiu);
		}
		if(e.getSource()==pstudid){
			List<StudentVo> student=null;
			student = sql.find("select * from studentmanager order by sno");
			new Studentdata(student,"学号排序如下");
		}
		if(e.getSource()==ponegrade){
			List<StudentVo> student=null;
			student = sql.find("select * from studentmanager order by sno");
			new Studentdata(student,"单科排序如下");
			
		}
		if(e.getSource()==psumgrade){
			List<StudentVo> student=null;
			student = sql.find("select * from studentmanager order by sage,shobit,szhuanye desc");
			new Studentdata(student,"总分排序如下");
		}
		if(e.getSource()==pavegrade){
			List<StudentVo> student=null;
			student = sql.find("select * from studentmanager order by sage,shobit,szhuanye desc");
			new Studentdata(student,"平均分排序如下");
		}
	}
}
