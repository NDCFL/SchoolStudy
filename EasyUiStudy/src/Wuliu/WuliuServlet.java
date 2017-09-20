package Wuliu;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public final class WuliuServlet extends HttpServlet {

	SQLimp sql = new SQLimp();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String order = request.getParameter("order");
		if(order!=null){
			if(order.equals("list")){
				List<WuliuBean> wuliulist = sql.list();
				request.setAttribute("wuliulist",wuliulist);
				System.out.println("===============");
				request.getRequestDispatcher("wu/wlist.jsp").forward(request, response);
			}else if (order.equals("delete")) {
				String id = request.getParameter("id");
				sql.delete(id);
				List<WuliuBean> wuliulist = sql.list();
				request.setAttribute("wuliulist",wuliulist);
				request.getRequestDispatcher("wu/wlist.jsp").forward(request, response);
			}else if (order.equals("update")) {
				String id = request.getParameter("id");
				WuliuBean w = sql.findw(id);
				request.setAttribute("w", w);
				request.getRequestDispatcher("wu/wupdate.jsp").forward(request, response);
			}else if (order.equals("updatesave")) {
				String proname = new String(request.getParameter("proname").getBytes("iso-8859-1"),"utf-8");
				String price = request.getParameter("price");
				String num = request.getParameter("num");
				String date = request.getParameter("date");
				String wuliu = request.getParameter("wuliu");
				WuliuBean w =new WuliuBean();
				w.setDatetime(date);
				w.setNum(Integer.parseInt(num));
				w.setPrice(Integer.parseInt(price));
				w.setProname(proname);
				w.setWuliu(Integer.parseInt(wuliu));
				sql.updatesave(w);
				List<WuliuBean> wuliulist = sql.list();
				request.setAttribute("wuliulist",wuliulist);
				request.getRequestDispatcher("wu/wlist.jsp").forward(request, response);
			}else if (order.equals("add")) {
				String proname = new String(request.getParameter("proname").getBytes("iso-8859-1"),"utf-8");
				String price = request.getParameter("price");
				String num = request.getParameter("num");
				String date = request.getParameter("date");
				WuliuBean w =new WuliuBean();
				w.setDatetime(date);
				w.setNum(Integer.parseInt(num));
				w.setPrice(Integer.parseInt(price));
				w.setProname(proname);
				sql.addw(w);
				List<WuliuBean> wuliulist = sql.list();
				request.setAttribute("wuliulist",wuliulist);
				request.getRequestDispatcher("wu/wlist.jsp").forward(request, response);
			}
		}
			
	}

}
