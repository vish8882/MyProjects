<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/include.jsp"%>
<%@ taglib prefix="spring"
	uri="http://www.springframework.org/tags/form"%>


<%@page import="com.accenture.adf.businesstier.entity.Visitor"%>
<html>
<head>
<title>Welcome to Festival Event Registration System</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<link rel="StyleSheet" href="css/struts2.css" type="text/css" />

<script type="text/javascript">
	function isNumeric(value) {
		if (value == null || !value.toString().match(/^[-]?\d*\.?\d*$/)) {
			return false;
		}
		return true;
	}
	function echeck(str) {
		var emailPattern = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
		return emailPattern.test(str);
	}
	function validateForm() {
		
		var ck_uname =  /^[A-Za-z0-9@*()_]+$/;
		
		var feedback = document.forms["feedback"]["feedback"].value;
		

		if (feedback == "") {
			alert("Please provide Feedback");
			return false;
		}
		
		
	}
	function cancelUpdate() {
		alert("Your request to update info has been cancelled");
		//window.location.replace("visitormain.jsp");
		document.forms[0].action = "searchVisitor.htm";
		document.forms[0].submit();
	}
	function displayStatus() {
		var updstatus = document.forms["updateVisitor"]["status"].value;
		if (updstatus == "success") {
			alert("Visitor details succesfully updated.. Please Login again..");
			window.location.replace("index.jsp");
		}
	}
</script>
<style>
.error {
	color: red;
}
</style>
</head>

<body style="background-image: url(images/BackBack071.jpg); background-size:cover; "onload="displayStatus()">

	<%
	    String vid=request.getParameter("vid");
		String fname = request.getParameter("fname");
	%>
	<form method="post" name="feedback" action="feedback.htm" onsubmit="return validateForm()">
		<input type="hidden" name="status" value="${status}">
		<table width="60%" height="70%" align="center">
			<tr>
				<td>
					<div id="header">
						&nbsp;
						<div align="center" style="color:#996666;  font-family: Algerian">
							Festival Registration System</a>
						</div>
					</div>

					<table align="center">
						<tr>
							<td width="100%">
								<table align="right" cellpadding="2">
									<tr>
										<td width="90">
											<div id="menu" align="center">
												<a href="<jstlcore:url value="/index.jsp"/>"> Logout </a>
											</div>
										</td>
										<td width="90">
											<div id="menu" align="center">
												<a href="<jstlcore:url value="/about.jsp"/>"> About</a><br />
											</div>
										</td>

									</tr>
								</table>
							</td>
						</tr>
						<tr>
							<td width="900">
								<div id="style1" align="center">
								
									<br />
								</div>
								


<h2>Feedback</h2>
<table border="1" width="20" height="80">
<thead>
<tr>
<td><u>Id</u></td>
<td><u>Name</u></td>
<td><u>Feedback</u></td>

</tr>
</thead>


 <jstlcore:forEach items="${feedback}" var="feedback">
<tr> 
 <td><jstlcore:out value="${feedback[0]}"></jstlcore:out>
 </td>
  <td><jstlcore:out value="${feedback[1]}"></jstlcore:out>
 </td>
  <td ><jstlcore:out value="${feedback[2]}"></jstlcore:out>
 </td>
 </tr>
 </jstlcore:forEach>
</table>
							</td>
							<!-- content end -->
						</tr>
						<tr>
							<td colspan="2" align="center" style="">${updatestatus}</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>

	</form>
</body>

</html>
