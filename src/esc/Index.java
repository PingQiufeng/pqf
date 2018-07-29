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

public class Index extends HttpServlet {

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
		String lbid = request.getParameter("lbid");
		

		// 业务处理
		try {
			List<qclb> list = QcService.getQclb();
			List<qcCount> qcslList = null;
			List<qc> qcList = null;
			
			qcslList=QcService.csQuery();
			if (lbid != null) {
				qcList = QcService.getQc(Integer.parseInt(lbid));
				
			} else {
				qcList = QcService.getQc();
				
			}
			// 转发
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");

			request.setAttribute("qclbList", list);
			request.setAttribute("qcList", qcList);
			request.setAttribute("lbid", lbid);
			request.setAttribute("qcslList", qcslList);
			rd.forward(request, response);

		} catch (SQLException e) {

			e.printStackTrace();

			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");

			request.setAttribute("errorMsg", "查询有误！");

			rd.forward(request, response);
		}

//		String lbid = request.getParameter("lbid");
//
//		String p = request.getParameter("p");
//		int pageNo = 1;
//
//		PageTool page = null;
//		
//		
//		// 如果p不为空，则获取页数
//		if (p != null)
//			pageNo = Integer.parseInt(p);
//
//		try {
//
//			List<qc> qcList = null;
//			List<qcCount> qcslList = null;
//			if (lbid == null) {
//				
//
//				// 获取当前页的商品数据
//				qcList = QcService.getQc(pageNo, 6);
//				qcslList=QcService.csQuery();
//				
//				// 获取总的商品数量
//				long total = QcService.getQcTotal();
//
//
//				page = new PageTool(total, 6, pageNo);
//
//			} else {
//
//				// 获取该类别的商品数量
//				long total = QcService.getQcTotal(Integer.parseInt(lbid));
//
//				page = new PageTool(total, 3, pageNo);
//
//				page.setParam("lbid=" + lbid);
//
//				qcList = QcService.getQc(Integer.parseInt(lbid), pageNo,
//						 3);
//
//			}
//
//			// 获取所有的类别数据
//			List<qclb> list = QcService.getQclb();
//
//			// 转发
//			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
//
//			request.setAttribute("qclbList", list);
//			request.setAttribute("qcList", qcList);
//			request.setAttribute("lbid", lbid);
//			request.setAttribute("page", page);
//			request.setAttribute("qcslList", qcslList);
//			rd.forward(request, response);
//
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

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
