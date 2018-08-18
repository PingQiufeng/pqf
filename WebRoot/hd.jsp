<<<<<<< HEAD
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expanded="false">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="Index">二手车商城</a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="col-sm-6" id="bs-example-navbar-collapse-1">

			<form class="navbar-form navbar-right" method="post"
				action="QueryAction" align="center">
				<div class="form-group">
					<input name="key" type="text" class="form-control"
						placeholder="Search">
				</div>

				<button type="submit" class="btn btn-default">二手车搜索</button>
			</form>
		</div>
		
			<ul class="nav navbar-nav navbar-right">
				<li><a href="GetLoveAction">收藏</a></li>
				<c:if test="${custom==null}">
					<li><a href="Login.jsp">登录</a></li>
				</c:if>
				<c:if test="${custom!=null}">
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">${custom.name}<span class="caret"></span>
					</a>
						<ul class="dropdown-menu">
							<li><a href="GetLoveAction">我的收藏   共${sl}辆车</a></li>

							<li role="separator" class="divider"></li>
							<li><a href="LoginOutAction">退出登录</a></li>
						</ul></li>

				</c:if>
			</ul>
		

		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container-fluid -->
=======
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expanded="false">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="Index">二手车商城</a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="col-sm-6" id="bs-example-navbar-collapse-1">

			<form class="navbar-form navbar-right" method="post"
				action="QueryAction" align="center">
				<div class="form-group">
					<input name="key" type="text" class="form-control"
						placeholder="Search">
				</div>

				<button type="submit" class="btn btn-default">二手车搜索</button>
			</form>
		</div>
		
			<ul class="nav navbar-nav navbar-right">
				<li><a href="GetLoveAction">收藏</a></li>
				<c:if test="${custom==null}">
					<li><a href="Login.jsp">登录</a></li>
				</c:if>
				<c:if test="${custom!=null}">
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">${custom.name}<span class="caret"></span>
					</a>
						<ul class="dropdown-menu">
							<li><a href="GetLoveAction">我的收藏   共${sl}辆车</a></li>

							<li role="separator" class="divider"></li>
							<li><a href="LoginOutAction">退出登录</a></li>
						</ul></li>

				</c:if>
			</ul>
		

		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container-fluid -->
>>>>>>> origin/master
</nav>