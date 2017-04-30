<%--
  Created by IntelliJ IDEA.
  User: vasya
  Date: 028 28 04 2017
  Time: 18:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="/WEB-INF/custom.tld" prefix="custom" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<c:forEach items="products" var="product">
    <li>${product}</li>
</c:forEach>