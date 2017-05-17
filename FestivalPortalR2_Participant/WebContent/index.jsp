<%@ include file="/include.jsp"%>

<html>
<head>
<title>Welcome to Festival Event Registration System</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1"></meta>
<link rel="StyleSheet" href="css/struts2.css" type="text/css"></link>


<script type="text/javascript">
	function validateForm() {
		var uname = document.forms["logForm"]["USERNAME"].value;
		var password = document.forms["logForm"]["PASSWORD"].value;
		if (uname == null || uname == "") {
			alert("Please provide Username");
			return false;
		}
		if (password == null || password == "") {
			alert("Please provide Password");
			return false;
		}
	}
</script>
</head>

<style>
.error {
	color: red;
	font-size: 13px;
	font-weight: bold;
}
</style>


<body
	style="background-image: url(images/festival_dakhla_V3_by_h2o_eyes.jpg); background-repeat: no-repeat; background-size: cover;"> 
	<br />
	<br />
	<%
		HttpSession session = request.getSession();
		session.invalidate();
	%>

	<form method="post" name="logForm" action="searchVisitor.htm"
		onsubmit="return validateForm()">

		<table width="60%" height="80%" align="center">
			<tr>
				<td align="Center">
					<div id="header">
			
						<div align="center">Festival Event Registration System</div>
					</div> <!-- header end --> <br />
				<br /> <br />
				<br /> <br />


					<table style="margin-left: 5%">
						<tr>
							<!--content begin -->
							<td colspan="2" align="center">
								<div id="ab">
									<div id="content">
										<h2>
											<u>Portal Login Page</u>
										</h2>
									</div>
								</div>
							</td>
						</tr>
						<tr>
							<td><div id="a">Visitor Name :</div></td>
							<td><input type="text" name="USERNAME"></td>
						</tr>
						<br/>

						<tr>
							<td><div id="a">Password :</div></td>
							<td><input type="password" name="PASSWORD"></td>
						</tr>
						<tr>
							<td colspan="2" align="right"><input type='submit'
								value=" Login "></input> <br /></td>
						</tr>
						<tr>
							<td colspan="2" align="center"><span class="error">${ERROR}</span></td>
						</tr>
						<tr>
							<td></td>
							
						
						</tr>
						<tr>
							<td></td>
						</tr>
						<tr>
							<td>
								<div id="a">
									<div id="content">New Visitor:</div>
								</div>
								<div id="a">
									<div id="content">
										<a href="/FestivalPortalR2_Participant/registration.jsp">Register
											here</a>
									</div></div>
							</td>
						</tr>
					</table>
				 <br />
				</td>
			</tr>
		</table>

	</form>

</body>

</html>
