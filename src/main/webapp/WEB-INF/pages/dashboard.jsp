<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML>
<!--
	Ion by TEMPLATED
	templated.co @templatedco
	Released for free under the Creative Commons Attribution 3.0 license (templated.co/license)
-->
<html>
	<head>
		<title>Funfit</title>
		<meta http-equiv="content-type" content="text/html; charset=utf-8" />
		<meta name="description" content="" />
		<meta name="keywords" content="" />
		<!--[if lte IE 8]><script src="js/html5shiv.js"></script><![endif]-->
		<script src="<c:url value="resources/js/jquery.min.js"/>"></script>
		<script src="<c:url value="resources/js/skel.min.js"/>"></script>
		<script src="<c:url value="resources/js/skel-layers.min.js"/>"></script>
		<script src="<c:url value="resources/js/init.js"/>"></script>
			<link rel="stylesheet" href="<c:url value="resources/css/skel.css"/>" />
			<link rel="stylesheet" href="<c:url value="resources/css/style.css"/>" />
			<link rel="stylesheet" href="<c:url value="resources/css/style-xlarge.css"/>" />
		<link rel="stylesheet" href="<c:url value="resources/css/akoa.css"/>" />
			<link rel="stylesheet" href="<c:url value="resources/css/bootstrap.css"/>" />
	</head>
	<body id="top">



<script>


var service = 'http://192.168.254.104:8081/funfit-backend';
var i = 0;

$(document).ready(function(){

    jQuery.support.cors = true;

    $.ajax(
    {
        type: "GET",
        url: service + '/getEvents',
        data: "{}",
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        cache: false,
        success: function (data) {
        $.each(data,function(i,item){			
            $("#eventTable").append(
                "<tr>"
                	+"<td>"+(++i)+"</td>"
                    +"<td>"+item.eventName+"</td>"
                    +"<td>"+item.locationName+"</td>"
                    +"<td>"+new Date(item.eventDate)+"</td>"
                    +"<td>"+item.vertices+"</td>"
                +"</tr>" )
             
            });
        },

        error: function (msg) {

            //alert(msg.responseText);
        }
    });
})

</script>




		<!-- Header -->
			<header id="header" class="skel-layers-fixed">
				<h1><a href="dashboard"><img id="logo-header" src="<c:url value="resources/images/funfit_header.png"/>"/></a></h1>
				<nav id="nav">
					<ul>
						<li><a href="dashboard">Dashboard</a></li>
							<li><a href="events">Create Event</a></li>
							<li><a href="marker">Create Marker</a></li>
						<li><a href="index" class="button special">Log Out</a></li>
					</ul>
				</nav>
			</header>

		<!-- Tables -->
		<div class="container">
			<img class="title-icon" src="<c:url value="resources/images/event.png"/>"/>
			<h2>EVENTS</h2>
<div class="table-responsive">
<table class="table" id="eventTable">
	<thead>
		<tr>
			<th>#</th>
			<th>Event Name</th>
			<th>Location</th>
			<th>Event Date</th>
			<th>Promotional Image</th>
		</tr>
</table>
</div>
</div>

<div class="container">
	<img class="medal-icon" src="<c:url value="resources/images/medal.png"/>"/>
	<h2>LEADERBOARD</h2>
<div class="table-responsive">
<table class="table">
<thead>
<tr>
	<th>#</th>
	<th>Username</th>
	<th>Points</th>
</tr>
<tbody>
</thead>
<tr>
	<td>1</td>
	<td>Runscapade</td>
	<td>8000</td>
</tr>
	<tr>
		<td>2</td>
		<td>Get Hike</td>
		<td>7000</td>
	</tr>
		<tr>
			<td>3</td>
			<td>Trackn'field</td>
			<td>6000</td>
		</tr>
			<tr>
				<td>4</td>
				<td>Rise & Shine</td>
				<td>5000</td>
			</tr>
</tbody>
</table>
</div>
</div>

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
