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
<div class="row">
    <div class="col-md-4">
        <h3>Користувач</h3>
    </div>
    <div class="col-md-4">
        <h3>${userName}</h3>
    </div>

</div>
<div class="row">
    <div class="col-md-16  sidebar-main">
        <div class="row" style="padding-left: 40px">
            <div class="col-md-6">
                <h4>Назва товару</h4>
            </div>
            <div class="col-md-6">
                <h4>Ціна</h4>
            </div>
        </div>

        <ul>
            <c:forEach items="${shopingCart}" var="cart">
            <li class="no-list">
                <div class="row">
                    <div class="col-md-6">${cart.getProduct().productName}</div>
                    <div class="col-md-6">${cart.getProduct().price}</div>
                    <a href="/basket/delete/${cart.id}" role="button" class="btn btn-primary">Delete</a>
                </div>
            </li>
            </c:forEach>
        </ul>
    </div>
</div>
