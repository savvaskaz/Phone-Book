<!DOCTYPE html>
<html>

<head>
<title>Add Phone Number</title>
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
		<h3>Add Phone Number</h3>

		<form action="PhoneControllerServlet" method="GET">

			<input type="hidden" name="command" value="ADD" />

			<table>
				<tbody>

					<tr>
						<td><label>First name:</label></td>
						<td><input type="text" name="firstName"></td>
					</tr>

					<tr>
						<td><label>Last name:</label></td>
						<td><input type="text" name="lastName"></td>
					</tr>

					<tr>
						<td><label>Phone Number:</label></td>
						<td><input type="text" name="phoneNumber"></td>
					</tr>
					
					<tr>
					<td><label></label></td>
					<td><input type="submit" value="Save" class="save" /> </td>
					
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