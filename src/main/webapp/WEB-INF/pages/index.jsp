<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Funfit</title>
		<meta http-equiv="content-type" content="text/html; charset=utf-8" />
		<meta name="description" content="" />
		<meta name="keywords" content="" />
		<!--[if lte IE 8]><script src="js/html5shiv.js"></script><![endif]-->
				
		<script src="<c:url value="/funfit-backend/resources/js/jquery.min.js" />"></script>	
		<script src="<c:url value="/resources/js/skel.min.js" />"></script>
		<script src="<c:url value="/resources/js/skel-layers.min.js" />"></script>
		<script src="<c:url value="/resources/js/init.js" />"></script>
			<link rel="stylesheet" href="<c:url value="/resources/css/skel.css" />" />
			<link rel="stylesheet" href="<c:url value="/resources/css/style.css" />" />
			<link rel="stylesheet" href="<c:url value="/resources/css/style-xlarge.css" />" />
	</head>
	<body id="top">

		<!-- Header -->
			<header id="header" class="skel-layers-fixed">
				<h1><a href="home"><img id="logo-header" src="<c:url "value=/funfit-backend/resources/images/funfit_header.png" />"/></a></h1>
				<nav id="nav">
					<ul>
						<li><a href="home">Home</a></li>
						<li><a href="login" class="button special">Login</a></li>
					</ul>
				</nav>
			</header>

		<!-- Banner -->
			<section id="banner">
				<div class="inner">				
				<img id="logo" src="<c:url value="/resources/images/funfit_logo.png" />"/>
					<h2>FUNFIT</h2>
					<p>The world is your battlefield.</p>
				</div>
			</section>

		<!-- Footer -->
			<footer id="footer">
				<div class="container">

					<ul class="copyright">
						<li>&copy; 2016 Funfit All rights reserved.</li>
						<li>Design: <a href="http://templated.co">TEMPLATED</a></li>
					</ul>
				</div>
			</footer>

	</body>
</html>
