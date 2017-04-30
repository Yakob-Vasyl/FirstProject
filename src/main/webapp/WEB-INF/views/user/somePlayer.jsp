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
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<div class="row">
    <div class="col-md-4">
    </div>
    <%--    private String productName;
    private Category category;
    private Brands brand;
    private List<Format> formats;
    private List<Connection> connections;
    private String sample_rate;
    private String bandwidth;
    private String signal_noise;
    private String power;
    private String weight;
    private String price;--%>
    <div class="col-md-14">
        <div class="row">
            <div class="col-md-15">
                <img class="img-responsive" src="/images/player/${player.id}.jpg?version=${player.version}">
            </div>
        </div>

       <div class="row">
           <div class="row">
               <div class="col-md-2">
                   ${player.brand.brand}

               </div>
               <div class="col-md-2">
                   ${player.productName}
               </div>
           </div>
           <sec:authorize access="isAuthenticated()">
               <div class="row">
                   <a role="button" href="/buy/player/${player.id}">Додати до кошика</a>
               </div>
           </sec:authorize>

            Характеристики
            <div class="row sidebar-main">
                <h4>Частота дискретизації</h4>
                <span>${player.sample_rate}</span>
                <h4>Інтерфейси підключення</h4>
                <ul>
                    <c:forEach items="${connections}" var="connection">
                        <li>${connection.connection}</li>
                    </c:forEach>
                </ul>
                <h4>Підтримуванні формати</h4>
                <ul>
                    <c:forEach items="${formats}" var="format">
                        <li>${format.format}</li>
                    </c:forEach>
                </ul>
            </div>
       </div>
    </div>
</div>