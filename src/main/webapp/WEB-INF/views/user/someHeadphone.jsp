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
                <img class="img-responsive" src="/images/headphone/${headphone.id}.jpg?version=${headphone.version}">
            </div>
        </div>

        <div class="row">
            <div class="row">
                <div class="col-md-6">
                    <h4> ${headphone.brand.brand} - ${headphone.productName}</h4>
                </div>
                <div class="col-md-6">
                    <h4> Ціна - ${headphone.price} грн</h4>
                </div>
            </div>
            <div class="row">
                <div class="col-md-6">
                    <sec:authorize access="isAuthenticated()">
                        <a role="button" class="btn btn-primary" href="/buy/headphone/${headphone.id}">Додати до кошика</a>
                    </sec:authorize>
                </div>
            </div>
            <div class="row">
                <div class="col-md-24"><h3>Характеристики</h3></div>
            </div>
            <div class="row sidebar-main">

                <div class="col-md-16">
                    <div class="row">
                        <div class="col-md-6"><h4>Тип коннектора</h4></div>
                        <div class="col-md-6"><h4>${headphone.connection.connection}</h4></div>
                    </div>
                    <div class="row">
                        <div class="col-md-6"><h4>Опір</h4></div>
                        <div class="col-md-6"><h4>${headphone.resistance} Ом</h4></div>
                    </div>
                    <div class="row">
                        <div class="col-md-6"><h4>Діапазон частот</h4></div>
                        <div class="col-md-8"><h4>${headphone.frequency_range} Гц</h4></div>
                    </div>
                    <div class="row">
                        <div class="col-md-6"><h4>Чутливість</h4></div>
                        <div class="col-md-6"><h4>${headphone.sensitivity} Дб</h4></div>
                    </div>
                    <div class="row">
                        <div class="col-md-6"><h4>Наявність мікрофона</h4></div>
                        <div class="col-md-6"><h4>${headphone.have_microphone}</h4></div>
                    </div>
                    <div class="row">
                        <div class="col-md-6"><h4>Довжина шнура</h4></div>
                        <div class="col-md-6"><h4>${headphone.cord_length} м</h4></div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>