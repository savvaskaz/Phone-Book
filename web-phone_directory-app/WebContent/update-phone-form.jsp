<!DOCTYPE html>
<html>

<head>
<title>Update Phone Number</title>
<link type="text/css" rel="stylesheet" href="css/stylePhone.css">
<link type="text/css" rel="stylesheet" href="css/add-phone-style.css">


</head>


<body>
	<div id="wrapper">
		<div id="header">
			<h2>Phone Book</h2>


		</div>
	</div>

	<div id="container">
		<h3>Update Phone Number</h3>

		<form action="PhoneControllerServlet" method="GET">

			<input type="hidden" name="command" value="UPDATE" />
		<input type="hidden" name="phoneId" value="${THE_PHONE.id}" />
		
			<table>
				<tbody>

					<tr>
						<td><label>First name:</label></td>
						<td><input type="text" name="firstName"
							value="${THE_PHONE.firstName}" /></td>
					</tr>

					<tr>
						<td><label>Last name:</label></td>
						<td><input type="text" name="lastName"
							value="${THE_PHONE.lastName}" /></td>
					</tr>

					<tr>
						<td><label>Phone Number:</label></td>
						<td><input type="text" name="phoneNumber"
							value="${THE_PHONE.phoneNumber}" /></td>
					</tr>

					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>

					</tr>

				</tbody>
			</table>
		</form>
		<div style="clear: both;"></div>

		<p>

			<a href="PhoneControllerServlet">Back to List</a>

		</p>


	</div>





</body>



</html>