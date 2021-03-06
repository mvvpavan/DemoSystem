<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<html>
<head>
<title>Storing IPADDRESS INFORMATION</title>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<c:if test="${ empty username}">
   <div id="success" class="success">
     <c:redirect url = "login"/>
   </div>
</c:if>
<nav class="navbar navbar-inverse" >
  <div class="container-fluid">
    <ul class="nav navbar-nav ">
     <li class="active"><a href="Dashboard">Home</a></li>
			<li><a href="addhost">ADD HOST</a></li>
			<li><a href="addgroup">ADD GROUP</a></li>
			<li><a href="rungroup">GROUP RUN</a></li>
			<li><a href="singleserver">SINGLE INSTANCE  RUN</a></li>
			<li><a href="messages">BUILD</a></li>
			<li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Settings<span class="caret"></span></a>
        <ul class="dropdown-menu">
               <li><a href="register">ADD Users</a></li>
        </ul>
      </li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="logout"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
    </ul>
  </div>
</nav>
	
	<form method="POST" action="host" class="loginform"  modelAttribute="hostForm">
	<div style="padding-top:20px">&nbsp;</div>
  <p style="text-align:center;font-weight: bold;font-size:17px;margin-top:10px;color:#00558b">${message}</p>
   <div class="form-group">
    <label for="email">Group Name:</label>
  <select path="groupname"  class="form-control" style="width:320px;" id="groupname">
						<c:if test="${not empty grouplist}">
						<option value="NONE">--- Select ---</option>
			<c:forEach var="listValue" items="${grouplist}">
			  <option value="${listValue.getGroupname()}" >${listValue.getGroupname()}</option>
				</c:forEach>

	</c:if>
					</select> </div>
  <div class="form-group">
    <label for="email">hostname:</label>
    <input type="text" class="form-control" id="hostname" name="hostname">
  </div>
  <button type="submit" class="btn btn-default">Submit</button> 
</form>
	
</body>
</html>