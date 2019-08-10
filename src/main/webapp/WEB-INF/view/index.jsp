<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html lang="en">
<body>
    <div>
        <div>
            <h1>Spring Boot JSP Example</h1>
            <h2>Hello </h2>
             
<%--        	<c:forEach items="${pensiune}" var="obiectPensiune"> --%>
<%--        		<c:out value="${obiectPensiune.id }"/> --%>
<%--        		<c:out value="${obiectPensiune.nume_pensiune }" /> --%>
<%--        	</c:forEach> --%>

<%-- 	${pensiune.nume_pensiune } --%>

 <tr th:each = "pensiuni : ${pensiuni }">
 	<td th:text="${pensiuni.nume_pensiuni }">
 </tr>
             
            Click on this <strong><a href="next">link</a></strong> to visit another page.
        </div>
    </div>
</body>
</html>