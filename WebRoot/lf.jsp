<<<<<<< HEAD
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<div class="list-group">
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	<c:forEach items="${qclbList}" var="lb">
		<a href="Index?lbid=${lb.qclb}"
			class="list-group-item <c:if test="${lb.qclb==lbid}">active</c:if>">${lb.lbmc}</a>

	</c:forEach>


</div>

<div class="panel panel-danger">
	<div class="panel-heading">
		<span class="glyphicon glyphicon-user" aria-hidden="true"></span>
		按价格查询
	</div>
	<div class="panel-body">
		<form class="form-horizontal" method="post" action="JgQueryAction">
			<div class="form-group">
				<div class="col-sm-6">
					<label >
						最小价格 </label>
				</div>
				<div class="col-sm-6">
					
					
						<input type="text" name="min" class="form-control"
							id="inputEmail3">
				
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-6">
					<label >
						最大价格 </label>
					
					
				</div>
				<div class="col-sm-6">
					
					
						<input type="text" name="max" class="form-control"
							id="inputEmail3">
				
				</div>
			</div>

			<div class="form-group">
				<div class="col-sm-6">
					<button type="submit" class="btn btn-default">查询</button>
				</div>
				<div class=" col-sm-6">
					<button type="reset" class="btn btn-default">重置</button>

				</div>
			</div>
		</form>



	</div>
</div>
<div class="panel panel-danger">
	<div class="panel-heading">
		<span class="glyphicon glyphicon-user" aria-hidden="true"></span>
		收藏排行
	</div>
	<div class="panel-body">
		
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
										  数量
										</th>
									</tr>
								</thead>
								<tbody>
								<c:forEach items="${qcslList}" var="i">
									<tr>
										<th scope="row">
											<img src="qctp/${i.qctp}" height=80px width=80px/> 
										</th>
										<th>
											<p>${i.qcmc}</p>
											
										</th>
										
										<th>${i.sl} </th>
										
									</tr>
									</c:forEach>
								</tbody>
							</table>
			
		


	</div>
</div>



=======
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<div class="list-group">
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	<c:forEach items="${qclbList}" var="lb">
		<a href="Index?lbid=${lb.qclb}"
			class="list-group-item <c:if test="${lb.qclb==lbid}">active</c:if>">${lb.lbmc}</a>

	</c:forEach>


</div>

<div class="panel panel-danger">
	<div class="panel-heading">
		<span class="glyphicon glyphicon-user" aria-hidden="true"></span>
		按价格查询
	</div>
	<div class="panel-body">
		<form class="form-horizontal" method="post" action="JgQueryAction">
			<div class="form-group">
				<div class="col-sm-6">
					<label >
						最小价格 </label>
				</div>
				<div class="col-sm-6">
					
					
						<input type="text" name="min" class="form-control"
							id="inputEmail3">
				
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-6">
					<label >
						最大价格 </label>
					
					
				</div>
				<div class="col-sm-6">
					
					
						<input type="text" name="max" class="form-control"
							id="inputEmail3">
				
				</div>
			</div>

			<div class="form-group">
				<div class="col-sm-6">
					<button type="submit" class="btn btn-default">查询</button>
				</div>
				<div class=" col-sm-6">
					<button type="reset" class="btn btn-default">重置</button>

				</div>
			</div>
		</form>



	</div>
</div>
<div class="panel panel-danger">
	<div class="panel-heading">
		<span class="glyphicon glyphicon-user" aria-hidden="true"></span>
		收藏排行
	</div>
	<div class="panel-body">
		
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
										  数量
										</th>
									</tr>
								</thead>
								<tbody>
								<c:forEach items="${qcslList}" var="i">
									<tr>
										<th scope="row">
											<img src="qctp/${i.qctp}" height=80px width=80px/> 
										</th>
										<th>
											<p>${i.qcmc}</p>
											
										</th>
										
										<th>${i.sl} </th>
										
									</tr>
									</c:forEach>
								</tbody>
							</table>
			
		


	</div>
</div>



>>>>>>> origin/master
