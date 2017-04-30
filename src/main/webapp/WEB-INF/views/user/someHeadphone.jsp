<%--
  Created by IntelliJ IDEA.
  User: vasya
  Date: 010 10 03 2017
  Time: 14:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="/WEB-INF/custom.tld" prefix="custom"%>

<div class="row">
    <div class="col-md-6">
    </div>

    <div class="col-md-18">
        <img src="">
        <span>${headphone.productName}     ${headphone.brand}</span>
        Характеристики

        <span>${headphone.price}</span>
    </div>
</div>