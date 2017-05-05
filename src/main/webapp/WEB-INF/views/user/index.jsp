<%--
  Created by IntelliJ IDEA.
  User: vasya
  Date: 008 08 02 2017
  Time: 16:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>



<div class="row">
    <div class="col-md-24 ">
        <div class="row">
            <div class="col-md-12 main-container">
                <a href="/CategoryPlayer">
                    <img class="img-responsive center-block" src="images/Player.jpg">
                    <h3 class="text-center">Програвачі</h3>
                </a>
            </div>
            <div class="col-md-12 main-container">
                <a href="/CategorySpeakers">
                    <img class="img-responsive center-block" src="images/Speakers.jpg">
                    <h3 class="text-center">Акустичні системи</h3>
                </a>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12 main-container">
                <a href="/CategoryHeadphone">
                    <img class="img-responsive center-block" src="images/Headphone.jpeg">
                    <h3 class="text-center">Наушники</h3>
                </a>
            </div>
            <div class="col-md-12 main-container">
                <a href="/CategoryCord">
                    <img class="img-responsive center-block" src="images/Cord.jpg">
                    <h3 class="text-center">Кабелі</h3>
                </a>
            </div>
        </div>

    </div>
</div>


<%--
<sec:authorize access="isAuthenticated()">
    <sec:authorize access="hasRole('ROLE_ADMIN')">
        <a href="/admin">admin</a>
    </sec:authorize>
    <form:form action="/logout" method="POST">
        <button type="submit" class="btn btn-danger">Logout</button>
    </form:form>
</sec:authorize>

<sec:authorize access="!isAuthenticated()">
    <a href="/login">Login</a>
    <a href="/registration">Registration</a>
</sec:authorize>
--%>
