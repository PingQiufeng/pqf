package esc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RegisterAction extends HttpServlet {

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
		//int id =Integer.parseInt(request.getParameter("id")) ;
		String name =request.getParameter("name");
		String pwd =request.getParameter("pwd");
		String phone =request.getParameter("phone");
		String location =request.getParameter("location");
		
		
		if(QcService.Register(name, pwd, phone, location))
		{
			
			response.sendRedirect("Index");
			
		}
		else
		{
			RequestDispatcher rd = request.getRequestDispatcher("Register.jsp");

			request.setAttribute("msg", "注册失败，请重新注册");
			
			
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
