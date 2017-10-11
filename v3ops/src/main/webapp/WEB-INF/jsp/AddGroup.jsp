<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<html>
<head>
<title>GROUP INFORMATION ADDING</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

	<c:if test="${ empty username}">
		<div id="success" class="success">
			<c:redirect url="login" />
		</div>
	</c:if>

	<div class="section">
		<div class="container">
			<nav class="navbar navbar-inverse">
				<div class="container-fluid"  style="background-color:#2962FF; padding:0;">
					<ul class="nav navbar-nav ">
						<li class="active"><a href="Dashboard">Home</a></li>
						<li><a href="addhost">ADD HOST</a></li>
						<li><a href="addgroup">ADD GROUP</a></li>
						<li><a href="rungroup">GROUP RUN</a></li>
						<li><a href="singleserver">SINGLE INSTANCE RUN</a></li>
						<li><a href="messages">BUILD</a></li>
						<li class="dropdown"><a class="dropdown-toggle"
							data-toggle="dropdown" href="#">Settings<span class="caret"></span></a>
							<ul class="dropdown-menu">
								<li><a href="register">ADD Users</a></li>
							</ul></li>
					</ul>
					<ul class="nav navbar-nav navbar-right">
						<li><a href="logout"><span
								class="glyphicon glyphicon-log-out"></span> Logout</a></li>
					</ul>
				</div>
			</nav>
		</div>
	</div>


	<div class="section">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<form method="POST" action="group" class="loginform"
						modelAttribute="groupForm">
						<div style="padding-top: 20px">&nbsp;</div>
						<p
							style="text-align: center; font-weight: bold; font-size: 17px; margin-top: 10px; color: #00558b">${message}</p>
						<div class="form-group">
							<label for="email">Group Name:</label> <input type="text"
								class="form-control" id="groupname" name="groupname">
						</div>
						<button type="submit" class="btn btn-default">Submit</button>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>