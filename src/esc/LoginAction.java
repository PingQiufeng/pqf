package esc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginAction extends HttpServlet {

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

		//获取数据
				request.setCharacterEncoding("Utf-8");
				String username =request.getParameter("name");
				String password =request.getParameter("pwd");
				
				Custom custom =QcService.Login(username, password);
				if(custom!=null)
				{
					HttpSession session=request.getSession(); 
					session.setAttribute("custom", custom);
					long a =QcService.getLoveTotal(custom.getName());
					session.setAttribute("sl", a);
					response.sendRedirect("Index");
					
				}
				else
				{
					RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");

					request.setAttribute("msg", "用户名密码错误");
					
					
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
