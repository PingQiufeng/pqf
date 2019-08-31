
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
							我的收藏
						</div>
						<div class="panel-body">
							<p style="color: red">
								
							</p>

							<table class="table">
								<thead>
									<tr>
										<th>
											汽车图片
										</th>
										<th>
											汽车名称
										</th>
										
										<th>
											价格
										</th>
										<th>
											操作
										</th>
									</tr>
								</thead>
								<tbody>
								<c:forEach items="${itemlist}" var="i">
									<tr>
										<th scope="row">
											<img src="qctp/${i.qctp}" height=80px width=80px/> 
										</th>
										<th>
											<p><a href="QcAction?qcid=${i.qcid}">${i.qcmc}</a></p>
											
										</th>
										<th><p>￥${i.qcjg}万元</p></th>
										<th><a class="btn btn-danger" href="RemoveToLove?qcid=${i.qcid}">删除</a></th>
										
									</tr>
									</c:forEach>
								</tbody>
							</table>


						</div>
					</div>


				</div>


			</div>




		</div>



	</body>
</html>

