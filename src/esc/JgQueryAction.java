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

public class JgQueryAction extends HttpServlet {

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

		doPost(request, response);
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

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		// �������������Ϣ�ı���
		request.setCharacterEncoding("utf-8");

		// 1.��ȡ��������
		String min  = request.getParameter("min");
		String max = request.getParameter("max");
		// 2.���÷��������ҵ���߼�
		try {

			// �������ݵ����ݿ�
			List<qc> qc = QcService.jgQuery(Integer.valueOf(min),
					Integer.valueOf(max));
			request.setAttribute("qcList", qc);
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		} catch (SQLException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();

			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");

			request.setAttribute("errorMsg", "û�иü۸�ļ�¼��");

			rd.forward(request, response);
		}

	}

}
