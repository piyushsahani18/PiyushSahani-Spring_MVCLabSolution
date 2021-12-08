<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">



<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">
<title>Save Student</title>
</head>

<body>

	<div class="container">

		<h3>Student Record Directory</h3>
		<hr>

		<p class="h4 mb-4">Add Record</p>
		
		

		<form action="/College_Fest/Students/insert"  method="POST">

			<!-- Add hidden form field to handle update -->
			<input type="hidden" name="Student_id" value="${Student.student_id}" />


			<div class="form-inline">
				<input type="text" name="StudentName" value="${Student.studentName}"
					class="form-control mb-4 col-4" placeholder="StudentName">

			</div>

			<div class="form-inline">

				<input type="text" name="department" value="${Student.department}"
					class="form-control mb-4 col-4" placeholder="Department">

			</div>

			<div class="form-inline">

				<input type="text" name="country" value="${Student.country}"
					class="form-control mb-4 col-4" placeholder="Country">

			</div>
			
			<div class="form-inline">

			<button type="submit" class="btn btn-info col-2"  style="margin-right: 16px" >Save</button>
		<!-- <button type="submit" class="btn btn-info col-2"  style="margin-right: 16px" ><a href="/College_Fest/Students/list"/>Student List</button> -->
		   
			
            </div>
		</form>
		<hr>
		     <form action="/College_Fest/Students/list" >
					<button type="submit" class="btn btn-info col-2">Student List</button>
			 </form>
		<hr>
	</div>
</body>

</html>
