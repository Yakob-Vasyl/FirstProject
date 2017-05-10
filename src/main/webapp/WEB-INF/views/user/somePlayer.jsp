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
                <img class="img-responsive" src="/images/player/${player.id}.jpg?version=${player.version}">
            </div>
        </div>

        <div class="row">
            <div class="row">
                <div class="col-md-6">
                    <h4> ${player.brand.brand} - ${player.productName}</h4>
                </div>
                <div class="col-md-6">
                    <h4> Ціна - ${player.price} грн</h4>
                </div>
            </div>
            <div class="row">
                <div class="col-md-6">
                    <sec:authorize access="isAuthenticated()">
                        <a role="button" class="btn btn-primary" href="/buy/player/${player.id}">Додати до кошика</a>
                    </sec:authorize>
                </div>
            </div>
            <div class="row">
                <div class="col-md-24"><h3>Характеристики</h3></div>
            </div>
            <div class="row sidebar-main">

                <div class="col-md-16">
                    <div class="row">
                        <div class="col-md-6">
                            <h4>Інтерфейси підключення</h4>
                        </div>
                        <div class="col-md-6">
                            <ul>
                                <c:forEach items="${connections}" var="connection">
                                    <li class="no-list"><h4>${connection.connection}</h4></li>
                                </c:forEach>
                            </ul>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-6">
                            <h4>Підтримуванні формати</h4>
                        </div>
                        <div class="col-md-6">
                            <ul>
                                <c:forEach items="${formats}" var="format">
                                    <li class="no-list"><h4>${format.format}</h4></li>
                                </c:forEach>
                            </ul>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-6"><h4>Частота дискретизації</h4></div>
                        <div class="col-md-6"><h4>${player.sample_rate} кГц</h4></div>
                    </div>
                    <div class="row">
                        <div class="col-md-6"><h4>Смуга пропускання</h4></div>
                        <div class="col-md-6"><h4>${player.bandwidth} Гц</h4></div>
                    </div>
                    <div class="row">
                        <div class="col-md-6"><h4>Відношення шум/сигнал</h4></div>
                        <div class="col-md-6"><h4>${player.signal_noise} Дб</h4></div>
                    </div>
                    <div class="row">
                        <div class="col-md-6"><h4>Потужність</h4></div>
                        <div class="col-md-6"><h4>${player.power} Вт</h4></div>
                    </div>
                    <div class="row">
                        <div class="col-md-6"><h4>Вага</h4></div>
                        <div class="col-md-6"><h4>${player.weight} кг</h4></div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>