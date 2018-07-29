package esc;

import java.util.List;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class GetLoveAction extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		        //获取Session
				HttpSession session=request.getSession();
				//获取session中的用户对象
				Custom custom = (Custom)session.getAttribute("custom");
				if(custom==null)
				{
					response.sendRedirect("Login.jsp");
				}
				else
				{
					long a =QcService.getLoveTotal(custom.getName());
					session.setAttribute("sl", a);
					List<Love> itemlist =QcService.get(custom.getName());
					//跳转收藏页面
					RequestDispatcher rd = request.getRequestDispatcher("love.jsp");

					request.setAttribute("itemlist", itemlist);

					rd.forward(request, response);
				}
			
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request,response);
	}

}
