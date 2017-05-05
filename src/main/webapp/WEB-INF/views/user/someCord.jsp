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
<%@ taglib uri="/WEB-INF/custom.tld" prefix="custom" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<div class="row">
    <div class="col-md-14 col-md-offset-4">
        <div class="row">
            <div class="col-md-15">
                <img class="img-responsive" src="/images/cord/${cord.id}.jpg?version=${cord.version}">
            </div>
        </div>

        <div class="row">
            <div class="row">
                <div class="col-md-6">
                    <h4> ${cord.brand.brand} - ${cord.productName}</h4>
                </div>
                <div class="col-md-6">
                    <h4> Ціна - ${cord.price} грн</h4>
                </div>
            </div>
            <div class="row">
                <div class="col-md-6">
                    <sec:authorize access="isAuthenticated()">
                        <a role="button" class="btn btn-primary" href="/buy/cord/${cord.id}">Додати до кошика</a>
                    </sec:authorize>
                </div>
            </div>
            <h3>Характеристики</h3>
            <div class="row sidebar-main">

                <div class="col-md-16">

                    <div class="row">
                        <div class="col-md-6"><h4>Тип підключення</h4></div>
                        <div class="col-md-6"><h4>${cord.connection.connection} кГц</h4></div>
                    </div>

                    <div class="row">
                        <div class="col-md-6"><h4>Довжина</h4></div>
                        <div class="col-md-6"><h4>${cord.length} м</h4></div>
                    </div>
                    <div class="row">
                        <div class="col-md-6"><h4>Матеріал провідника</h4></div>
                        <div class="col-md-6"><h4>${cord.material}</h4></div>
                    </div>
                </div>
            </div>
        </div>
    </div>
