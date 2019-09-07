<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>

<head>
	<title>Phone Book Tracker Application</title>
	
	<link type="text/css" rel="stylesheet" href="css/stylePhone.css">
		
</head>


<body>

	<div id="wrapper">
		<div id="header">
			<h2>Company Phone Book</h2>


		</div>
	</div>


	<div id="container">
		<div id="content">
			
			<input type="button" value="Add Phone Number"
			 onclick="window.location.href='add-phone-number-form.jsp';return false;"
			 class="add-phone-button"
			/>
		
		
		<table>
			
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Phone Number</th>
					<th>Action</th>
				</tr>
				
				<c:forEach var="tempPhone" items="${PHONE_LIST}">
				
					<c:url var="tempLink" value="PhoneControllerServlet">
						<c:param name="command" value="LOAD" />
						<c:param name="phoneId" value="${tempPhone.id}" />
					</c:url>
					
					<c:url var="deleteLink" value="PhoneControllerServlet">
						<c:param name="command" value="DELETE" />
						<c:param name="phoneId" value="${tempPhone.id}" />
					</c:url>
				
					<tr>
						<td> ${tempPhone.firstName}  </td>
						<td>${tempPhone.lastName}   </td>
						<td> ${tempPhone.phoneNumber}  </td>
						<td> <a href="${tempLink}">Update</a>
						
						    <a href="${deleteLink}"
						    onclick="if (!(confirm('Are you sure you want to delete this phone number'))) return false">
						    Delete</a>                 
						</td>
						
					</tr>
				
				</c:forEach>
				
			</table>
		
		
		</div>
	</div>
</body>


</html>