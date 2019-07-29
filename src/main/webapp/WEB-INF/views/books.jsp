<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Hello ${name}!</title>
<link href="${contextPath}/resources/css/main.css" rel="stylesheet">
</head>
<body>
	<h2 class="hello-title">Hello ${name}!</h2>
	<c:forEach var="entry" items="${books}">
		</p>
		<c:out value="${entry.bookName}" />
		</p>

		<c:out value="${entry.authorName}" />
		</p>
		<c:out value="${entry.bookVersion}" />
		</p>
		<c:out value="${entry.bookInventory.quantity}" />
		</p>
		<c:forEach var="borrowedDetail" items="${entry.borrowDetails}">
			<c:out value="${borrowedDetail.borrower.borrowerFirstName}" />
			</p>
			<c:out value="${borrowedDetail.borrower.borrowerLastName}" />
			</p>
			<c:out value="${borrowedDetail.borrower.address.addressLine1}" />
			</p>
			<c:out value="${borrowedDetail.borrower.address.city}" />
			</p>

		</c:forEach>

	</c:forEach>


	<script src="${contextPath}/resources/js/main.js"></script>
</body>
</html>
