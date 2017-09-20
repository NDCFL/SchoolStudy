package ShowDemo;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Voteservlet extends HttpServlet {
	SQLyujuimp sql = new SQLyujuimp();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if(request.getParameter("order").equals("list")){
			String handle = request.getParameter("handle");
			String currentpage = request.getParameter("currentpage");
 			PageBean page = new PageBean();
 			page.setPagesize(2);
 			page.setBarsum(sql.barsum());
 			if(currentpage==null || currentpage.equals("")){
 				page.setCurrentpage(1);
 			}else {
				page.setCurrentpage(Integer.parseInt(currentpage));
			}
 			if(handle==null || handle.equals("")){
 				page.setHandle("firstpage");
 			}else {
				page.setHandle(handle);
			}
 			List<VoteBean> votelist = sql.votelist(page.getPagesize(), page.getStartpage());
 			request.setAttribute("votelist", votelist);
 			request.setAttribute("pager", page);
 			request.getRequestDispatcher("Show/votelist.jsp").forward(request, response);
		}
	}
}
