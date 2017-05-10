<%--
  Created by IntelliJ IDEA.
  User: vasya
  Date: 008 08 02 2017
  Time: 16:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%--<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container-fluid">
        <div class="navbar-header">
            <h2>Header</h2>
        </div>
        <ul class="nav navbar-nav">
            <!--       	<li><a>Home</a></li> -->
            <!--       	<li><a>Page 1</a></li> -->
            <!--      	<li><a>Page 2</a></li> -->
        </ul>
        <ul class="nav navbar-nav navbar-right">
        </ul>
    </div>
</nav>--%>
<header>
    <nav class="navbar navbar-default ">
        <div class="container-fluid">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#one" aria-expanded="false">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a href="/" class="navbar-brand" style="padding-top:0"><img class="img-thumbnail" width="50" src="/images/logo.png" ></a>
            </div>
            <div class="collapse navbar-collapse" id="one">
                <ul class="nav navbar-nav">
                    <li class="dropdown">
                        <a href="" class="dropdown-toggle"
                           data-toggle="dropdown"
                           role="button"
                           aria-haspopup="true"
                           aria-expanded="false">
                            <span class="glyphicon glyphicon-hdd" aria-hidden="true"></span>
                            <span>Програвачі</span>
                            <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="/playersOfChosenCategory?categoryIdValue=1">CD програвачі</a></li>
                            <li><a href="/playersOfChosenCategory?categoryIdValue=2">ЦАП</a></li>
                            <li><a href="/playersOfChosenCategory?categoryIdValue=3">Стерео ресивери</a></li>
                            <li><a href="/playersOfChosenCategory?categoryIdValue=4">Мережеві плеєри</a></li>
                            <li><a href="/playersOfChosenCategory?categoryIdValue=5">Міні системи HIFI</a></li>
                            <li><a href="/playersOfChosenCategory?categoryIdValue=6">CD ресивери</a></li>

                        </ul>
                    </li>

                    <li class="dropdown">
                        <a href="" class="dropdown-toggle"
                           data-toggle="dropdown"
                           role="button"
                           aria-haspopup="true"
                           aria-expanded="false">
                            <span class="glyphicon glyphicon-sound-dolby" aria-hidden="true"></span>
                            <span>Акустичні системи</span>
                            <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="/speakersOfChosenCategory?categoryIdValue=7">Комплекти акустики 5.1</a></li>
                            <li><a href="/speakersOfChosenCategory?categoryIdValue=8">Настінна акустика</a></li>
                            <li><a href="/speakersOfChosenCategory?categoryIdValue=9">Сабвуфери</a></li>
                            <li><a href="/speakersOfChosenCategory?categoryIdValue=10">Вбудована акустика</a></li>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a href="" class="dropdown-toggle"
                           data-toggle="dropdown"
                           role="button"
                           aria-haspopup="true"
                           aria-expanded="false">
                            <span class="glyphicon glyphicon-headphones" aria-hidden="true"></span>
                            <span>Наушники</span>
                            <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="/headphonesOfChosenCategory?categoryIdValue=13">Вкладиші</a></li>
                            <li><a href="/headphonesOfChosenCategory?categoryIdValue=14">Вакуумні</a></li>
                            <li><a href="/headphonesOfChosenCategory?categoryIdValue=15">Накладні</a></li>
                            <li><a href="/headphonesOfChosenCategory?categoryIdValue=16">Безпровідні</a></li>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a href="" class="dropdown-toggle"
                           data-toggle="dropdown"
                           role="button"
                           aria-haspopup="true"
                           aria-expanded="false">
                            <span class="glyphicon glyphicon-resize-small"></span>
                            <span>Кабелі</span>
                            <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="/cordsOfChosenCategory?categoryIdValue=17">Міжблокові кабелі</a></li>
                            <li><a href="/cordsOfChosenCategory?categoryIdValue=18">Акустичні кабелі</a></li>
                            <li><a href="/cordsOfChosenCategory?categoryIdValue=19">HDMI кабелі</a></li>
                            <li><a href="/cordsOfChosenCategory?categoryIdValue=20">Цифрові кабелі</a></li>
                            <li><a href="/cordsOfChosenCategory?categoryIdValue=21">Оптичні кабелі</a></li>

                        </ul>
                    </li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li class="dropdown">
                        <a href="" class="dropdown-toggle"
                           data-toggle="dropdown"
                           role="button"
                           aria-haspopup="true"
                           aria-expanded="false">
                            <span class="glyphicon glyphicon-log-in" aria-hidden="true"></span>
                            <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <sec:authorize access="isAuthenticated()">

                                <sec:authorize access="hasRole('ROLE_ADMIN')">
                                 <li><a href="/admin">admin</a></li>
                                </sec:authorize>

                                <form:form action="/logout" method="POST">
                                   <li> <button type="submit" class="btn btn-link">Logout</button></li>
                                </form:form>

                            </sec:authorize>

                            <sec:authorize access="!isAuthenticated()">
                                <li><a href="/login">Login</a></li>
                                <li><a href="/registration">Registration</a></li>
                            </sec:authorize>
                        </ul>
                    </li>
                    <sec:authorize access="isAuthenticated()">
                        <li><a href="/basket" role="button"><span class="glyphicon glyphicon-shopping-cart" aria-hidden="true" style="padding-right:5px"></span></a></li>
                    </sec:authorize>
                </ul>
            </div>
        </div>
    </nav>
</header>
