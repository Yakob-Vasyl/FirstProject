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
                <img class="img-responsive" src="/images/speakers/${speakers.id}.jpg?version=${speakers.version}">
            </div>
        </div>

        <div class="row">
            <div class="row">
                <div class="col-md-6">
                    <h4> ${speakers.brand.brand} - ${speakers.productName}</h4>
                </div>
                <div class="col-md-6">
                    <h4> Ціна - ${speakers.price} грн</h4>
                </div>
            </div>
            <div class="row">
                <div class="col-md-6">
                    <sec:authorize access="isAuthenticated()">
                        <a role="button" class="btn btn-primary" href="/buy/speakers/${speakers.id}">Додати до кошика</a>
                    </sec:authorize>
                </div>
            </div>
            <h3>Характеристики</h3>
            <div class="row sidebar-main">

                <div class="col-md-16">
                    <div class="row">
                        <div class="col-md-6"><h4>Тип підключення</h4></div>
                        <div class="col-md-6"><h4>${speakers.connection.connection}</h4></div>
                    </div>
                    <div class="row">
                        <div class="col-md-6"><h4>Діапазон частот</h4></div>
                        <div class="col-md-6"><h4>${speakers.frequency_range} Гц</h4></div>
                    </div>
                    <div class="row">
                        <div class="col-md-6"><h4>Опір</h4></div>
                        <div class="col-md-6"><h4>${speakers.impedance} Ом</h4></div>
                    </div>
                    <div class="row">
                        <div class="col-md-6"><h4>Чутливість</h4></div>
                        <div class="col-md-6"><h4>${speakers.sensitivity} Дб</h4></div>
                    </div>
                    <div class="row">
                        <div class="col-md-6"><h4>Потужність</h4></div>
                        <div class="col-md-6"><h4>${speakers.power} Вт</h4></div>
                    </div>
                    <div class="row">
                        <div class="col-md-6"><h4>Колір</h4></div>
                        <div class="col-md-6"><h4>${speakers.color}</h4></div>
                    </div>
                    <div class="row">
                        <div class="col-md-6"><h4>Вага</h4></div>
                        <div class="col-md-6"><h4>${speakers.weight} кг</h4></div>
                    </div>
                    <%-- private String product_name;
   private Category category;
   private Brands brand;
   private Connection connection;
   private String frequency_range;
   private String impedance;
   private String sensitivity;
   private String power;
   private String color;
   private String weight;
   private String price;--%>
                </div>
            </div>
        </div>
    </div>
</div>