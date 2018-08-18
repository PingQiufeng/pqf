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
							<p style="color: red">
								${errorMsg}
							</p>

							<div>
								<img src="qctp/${qc.qctp}" height=300px width=400px >
							</div>
							<h3>
								${qc.qcmc}
							</h3>
							<h4>
								￥${qc.qcjg}万元
							</h4>
<p>
								${qc.qccl}
							</p>
							<p>
								${qc.qcjs}
							</p>
							<p>
								<a href="#" class="btn btn-primary" role="button">立即购买</a>
								<c:if test="${lovezt==false }"><a href="AddToLove?qcid=${qc.qcid}" class="btn btn-default" role="button">收藏</a></c:if>
								
								<c:if test="${lovezt==true }"><a href="RemoveToLove?qcid=${qc.qcid}" class="btn btn-default" role="button">取消收藏</a></c:if>
								
							</p>
							<p>该车共有${lovesl}人收藏</p>

						</div>
					</div>


				</div>


			</div>




		</div>



	</body>
</html>
