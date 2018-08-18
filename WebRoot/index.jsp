<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ include file="conn.jsp"%>
</head>

<body>

	<div class="container">

		<%@ include file="hd.jsp"%>


		<div class="row">
			<div class="col-md-3">

				<%@ include file="lf.jsp"%>


			</div>
			<div class="col-md-9">

				<div class="panel panel-danger">
					<div class="panel-heading">
						<span class="glyphicon glyphicon-user" aria-hidden="true"></span>
						汽车
					</div>
					<div class="panel-body">
						<p style="color: red">${errorMsg}</p>

						<div class="row">
							<c:forEach items="${qcList}" var="qc">
								<div class="col-sm-6 col-md-4">
									<div class="thumbnail">
										<img src="qctp/${qc.qctp}" alt="...">
										<div class="caption">
											<h5>
												<a href="QcAction?qcid=${qc.qcid}">${qc.qcmc}</a>
											</h5>


											<p>
												￥： <font color="red">${qc.qcjg}</font> 万元
											</p>


										</div>
									</div>
								</div>
							</c:forEach>

						</div>


					</div>
					<div class="panel-footer">
						<nav aria-label="Page navigation">
						<ul class="pagination">
						<c:if test="${lbid!=null}">
							<li><a href="Index?p=1" aria-label="Previous"> <span
									aria-hidden="true">第一页</span>
							</a></li>
							
								<li><a href="Index?lbid=${lbid}&p=${page.prev}">上一页</a></li>
							
							<li><a href="#">共${page.pageTotal}页，当前为第${page.currentPage}页</a>
							</li>
							<li><a href="Index?lbid=${lbid}&p=${page.next}">下一页</a></li>
							<li><a href="Index?p=${page.lastPage}" aria-label="Next">
									<span aria-hidden="true">最后一页</span>
							</a></li>
							</c:if>
							<c:if test="${lbid==null}">
							<li><a href="Index?p=1" aria-label="Previous"> <span
									aria-hidden="true">第一页</span>
							</a></li>
							
								<li><a href="Index?p=${page.prev}">上一页</a></li>
							
							<li><a href="#">共${page.pageTotal}页，当前为第${page.currentPage}页</a>
							</li>
							<li><a href="Index?p=${page.next}">下一页</a></li>
							<li><a href="Index?p=${page.lastPage}" aria-label="Next">
									<span aria-hidden="true">最后一页</span>
							</a></li>
							</c:if>

						</ul>
						</nav>
					</div>
				</div>


			</div>


		</div>




	</div>



</body>
</html>
