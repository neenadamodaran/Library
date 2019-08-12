<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Library</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="resources/css/main.css" rel="stylesheet">
<link href="resources/css/menu.css" rel="stylesheet">
<link href="resources/css/topImage.css" rel="stylesheet">
<link href="resources/css/errors.css" rel="stylesheet">
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.css">
<script type="text/javascript" charset="utf8"
	src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.js"></script>

</head>
<body>

	<jsp:include page="topMenu.jsp" />



	<div class="container">
		<form:form action="processAddBook" modelAttribute="book" method="POST">

			<spring:bind path="book">
				<form:errors path="*" cssClass="isa_error" element="div" />
			</spring:bind>

			<c:if test="${not empty successMessage}">
				<div id="successMessage" class="isa_success">
					<spring:message code="${successMessage}" />
				</div>
			</c:if>

			<form:label for="bookName" path="bookName">Book Name</form:label>
			<form:input type="text" id="bookName" path="bookName"
				placeholder="Book's name.." />


			<form:label for="authorName" path="authorName">Author Name</form:label>
			<form:input type="text" id="authorName" path="authorName"
				placeholder="Book's Author name.." />


			<form:label for="bookVersion" path="bookVersion">Book Version</form:label>
			<form:input type="text" id="bookVersion" path="bookVersion"
				placeholder="Books's Version." />


			<form:label for="publicationDate" path="publicationDate">Publication Date</form:label>
			<form:input type="date" id="publicationDate" path="publicationDate"
				placeholder="Book's publication date.." />
			</br>


			<form:label for="quantity" path="bookInventory.quantity">Quantity of Book</form:label>
			<form:input type="text" id="Quantity" path="bookInventory.quantity"
				placeholder="Quantity of the book to add" />



			<input type="submit" value="Submit">
		</form:form>
	</div>

</body>
</html>