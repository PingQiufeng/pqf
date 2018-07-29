package esc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class QcAction extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		// 获取 数据
		String qcid = request.getParameter("qcid");
		
		HttpSession session = request.getSession();
		Custom custom = (Custom) session.getAttribute("custom");
		long a = QcService.getQcLoveTotal(Integer.parseInt(qcid));
		session.setAttribute("lovesl", a);
		
	
		if (custom == null) {
			response.sendRedirect("Login.jsp");
		} else {
			// 业务处理
			try {
				List<qclb> list = QcService.getQclb();
				qc qc = null;

				qc = QcService.getQcById(Integer.parseInt(qcid));
				qc.setSl(a);
				boolean b = QcService.isLove(qcid, custom.getName());
				session.setAttribute("lovezt", b);
				// 转发
				RequestDispatcher rd = request.getRequestDispatcher("qc.jsp");

				request.setAttribute("qclbList", list);
				request.setAttribute("qc", qc);
				
				rd.forward(request, response);

			} catch (SQLException e) {

				e.printStackTrace();

				RequestDispatcher rd = request
						.getRequestDispatcher("index.jsp");

				request.setAttribute("errorMsg", "查询有误！");

				rd.forward(request, response);
			}
		}
	}

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
