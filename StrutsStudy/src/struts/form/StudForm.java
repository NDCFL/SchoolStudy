package struts.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class StudForm extends ActionForm{
	
	private int sno;
	private String studentname;
	private int sage;
	private String ssex;
	private String shobit;
	private String szhuanye;
	private String[] hobit;
	public String[] getHobit() {
		return hobit;
	}
	public void setHobit(String[] hobit) {
		this.hobit = hobit;
	}
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public String getStudentname() {
		return studentname;
	}
	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}
	public int getSage() {
		return sage;
	}
	public void setSage(int sage) {
		this.sage = sage;
	}
	public String getSsex() {
		return ssex;
	}
	public void setSsex(String ssex) {
		this.ssex = ssex;
	}
	public String getShobit() {
		return shobit;
	}
	public void setShobit(String shobit) {
		this.shobit = shobit;
	}
	public String getSzhuanye() {
		return szhuanye;
	}
	public void setSzhuanye(String szhuanye) {
		this.szhuanye = szhuanye;
	}
	@Override
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		ActionErrors errors = new ActionErrors();
		if(this.studentname==null || this.studentname.equals("")){
			errors.add("studetname",new ActionMessage("error.studentname"));
			return errors;
		}
		if(this.sage<1 || this.sage>100){
			errors.add("age",new ActionMessage("error.sage"));
			return errors;
		}
		if(this.ssex==null || this.ssex.equals("")){
			errors.add("ssex",new ActionMessage("error.ssex"));
			return errors;
		}
		return errors;
	}
	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		super.reset(mapping, request);
	}
}
