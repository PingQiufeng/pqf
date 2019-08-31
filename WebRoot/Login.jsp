
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
							用户登录
						</div>
						<div class="panel-body">
						<p style="color:red">${msg}</p>
							<form class="form-horizontal" action="LoginAction" mother="post">
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
									<div class="col-sm-offset-2 col-sm-10">
										<div class="checkbox">
											<label>
												<input type="checkbox">
												记住用户名
											</label>
										</div>
									</div>
								</div>
								<div class="form-group">
									<div class="col-sm-offset-2 col-sm-5">
										<button type="submit" class="btn btn-default">
											登录
										</button>
										<button type="reset" class="btn btn-default">
											重置
										</button>
										
									</div >
									<div class="col-sm-5"><a href="Register.jsp">  
											    注册 
										</a></div>
								</div>
							</form>







						</div>
					</div>


				</div>


			</div>




		</div>



	</body>
</html>

