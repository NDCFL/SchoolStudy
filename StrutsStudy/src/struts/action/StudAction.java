package struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import struts.form.StudForm;

public class StudAction extends Action{
 
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		System.out.println("execute");
		StudForm studForm = (StudForm)form;
		ActionMessages messages = new ActionMessages();
		if(studForm.getSno()==0){
			messages.add("sno",new ActionMessage("error.sno"));
		}
		System.out.println(studForm.getStudentname());
		String [] hobit = studForm.getHobit();
		for (int i = 0; i < hobit.length; i++) {
			System.err.println(hobit[i]);
		}
		return mapping.findForward("reg");
	}
}
