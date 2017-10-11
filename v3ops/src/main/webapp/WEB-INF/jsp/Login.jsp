<!DOCTYPE html>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml" lang="en-US">

<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>Vitech Systems Group &rsaquo; Log In</title>
    <link href="<c:url value="/asserts/css/main.css" />" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
 <style type="text/css">
 body{font-family:arial;}
html{  background-attachment:fixed;
background-position: inherit !important;
}
.loginform{
  margin-top: 120px; 
  margin-left: 450px;
 width: 360px;
	height: 380px;
  padding: 15px 35px 45px;
  background-color: #fff;
  border: 2px solid rgba(0,0,0,0.1)
  border-radius: 25px;
  box-shadow: 0 1px #5670A4 inset, 0 0 10px 5px rgba(0, 0, 0, 0.1);
  }
#logo {
	text-align: center;
	margin: 0 auto;
}
tr.highlight td {padding-top: 10px; padding-bottom:10px}
  html {
	background-color: #24598f;
	background-image: url('https://portal.vitechinc.com/wordpress/wp-content/uploads/2016/06/app1.jpg');
	background-position: center center;
	background-repeat: no-repeat;
	}
	.div {
                margin-left: 120px;
                background-color: #00ae42;
            }
            body.login {
	background: transparent;
	}
	
	.submit {
	  width: 250px;
	height: 40px;
	clear: both;
	margin-bottom: 20px;
	-webkit-border-radius: 6px 6px 6px 6px;
	border-radius: 6px 6px 6px 6px;
	text-indent: 15px;
	font-size: 12px;
	color: #fff;
	font-weight: bold;
	background: #78BB3E;
	-webkit-border-radius: 6px 6px 6px 6px;
	border-radius: 6px 6px 6px 6px;
	font-size: 16px;
	margin: 0 auto;
	text-align: center;
	padding: 8px 0px;
	border: none;
    }
  </style>
  </head>
<body class="login">
<form method="POST" action="request" class="loginform"  modelAttribute="loginForm">
<div id="logo"><img src="https://portal.vitechinc.com/wordpress/wp-content/uploads/2015/10/Official-Logo.png"  >

	<p style="text-align:center;font-weight: bold;font-size:17px;margin-top:10px;color:#00558b">Login</p>
	</div>
	<div style="padding-top:20px">&nbsp;</div>
  <p style="text-align:center;font-weight: bold;font-size:17px;margin-top:10px;color:#00558b">${message}</p>
   <div class="form-group">
    <label for="email">UserName:</label>
    <input type="text" class="form-control" id="username" name="username">
  </div>
  <div class="form-group">
    <label for="pwd">Password:</label>
    <input type="password" class="form-control" id="password" name="password">
  </div>
 
  <button type="submit" class="btn btn-default">Submit</button> 
</form>
<p style="color:#fff; text-align:center;clear:both;padding-top:10px;">© Vitech Systems Group 2017. All Rights Reserved.</p>
</body>
</html>