<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Library</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="resources/css/main.css" rel="stylesheet">
<link href="resources/css/menu.css" rel="stylesheet">
<link href="resources/css/topImage.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.css">
<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.js"></script>
<script>

$(document).ready( function () {
    $('#table_id').DataTable();
} );


</script>

</head>
<body>
	<jsp:include page="topMenu.jsp" />

	<!-- Page content -->

	<div id="react"></div>
	<div class="content">



		<div class="addBook">
			</p>
			<button class="button" onClick="location.href='addBook'"><i class="fa fa-plus" aria-hidden="true" ></i> Add Book</button>
			</p>
		</div>
		<table id ="booksTable" class=table>
			<tr>
				<th>Book Name</th>
				<th>Author Name</th>
				<th>Book Version</th>
				<th>Publication Date</th>
				<th>Availability</th>
				<th>Borrowed</th>
				<th>Action</th>

			</tr>
			<c:forEach var="entry" items="${books}">

				<tr>
					<td><c:out value="${entry.bookName}" /></td>
					<td><c:out value="${entry.authorName}" /></td>
					<td><c:out value="${entry.bookVersion}" /></td>
					<td><c:out value="${entry.publicationDate}" /></td>
					<td><c:out value="${entry.bookInventory.quantity}" /></td>
					<td>
					<c:choose>
							<c:when test="${fn:length(book.borrowDetails) gt 0}">
        
        							Yes 
       							 <br />
							</c:when>
							<c:otherwise>
        							No 
        							<c:forEach var="borrowDetail" items="${book.borrowDetails}">
        								<c:out value="${borrowDetail.book.bookName}" />
        							</c:forEach>
       							<br />
							</c:otherwise>
						</c:choose>
						
						</td>
						<td>
						<button class="btn" onClick="location.href='updateBook?id=${entry.id}'"><i class="fa fa-pencil-square-o" aria-hidden="true"></i>
</button>
							<button class="btn" onClick="location.href='processDelete?id=${entry.id}'"><i class="fa fa-trash"></i></button>
						</td>

				</tr>
			</c:forEach>

		</table>
		..
	</div>


	<script>
		function myFunction() {
			var x = document.getElementById("myTopnav");
			if (x.className === "topnav") {
				x.className += " responsive";
			} else {
				x.className = "topnav";
			}
		}
	</script>
</body>
</html>
