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
							用户注册
						</div>
						<div class="panel-body">
						<p style="color:red">${msg}</p>
							<form class="form-horizontal" action="RegisterAction" mother="post">
								<div class="form-group">
									<label for="inputEmail3" class="col-sm-2 control-label">
										用户名
									</label>
									<div class="col-sm-10">
										<input type="text" name ="name" class="form-control" id="inputEmail3"
											placeholder="Email">
									</div>
								</div>
								<div class="form-group">
									<label for="inputPassword3" class="col-sm-2 control-label">
										密码
									</label>
									<div class="col-sm-10">
										<input type="password" name="pwd" class="form-control"
											id="inputPassword3" placeholder="Password">
									</div>
								</div>
								<div class="form-group">
									<label for="inputPassword3" class="col-sm-2 control-label">
										电话
									</label>
									<div class="col-sm-10">
										<input type="text" name="phone" class="form-control"
											id="inputPassword3" placeholder="phone">
									</div>
								</div>
								<div class="form-group">
									<label for="inputPassword3" class="col-sm-2 control-label">
										地址
									</label>
									<div class="col-sm-10">
										<input type="text" name="location" class="form-control"
											id="inputPassword3" placeholder="location">
									</div>
								</div>
								
								<div class="form-group">
									<div class="col-sm-offset-2 col-sm-10">
										<button type="submit" class="btn btn-default">
											注册
										</button>
										<button type="reset" class="btn btn-default">
											重置
										</button>
										
									</div>
								</div>
							</form>







						</div>
					</div>


				</div>


			</div>




		</div>



	</body>
</html>
