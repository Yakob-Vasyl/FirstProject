
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="row">
    <div class="col-md-8">
        <img src="" >
        <a href="/cordsOfChosenCategory?categoryIdValue=16"><h3>Міжблокові</h3></a>
        <ul>
            <c:forEach items="${MZBLOCKbrands}" var="brand">
                <li class="no-list"><a href="">${brand.brand}</a></li>
            </c:forEach>
        </ul>
    </div>
    <div class="col-md-8 ">
        <img src="" >
        <a href="/cordsOfChosenCategory?categoryIdValue=17"><h3>Акустичні</h3></a>
        <ul>
            <c:forEach items="${ACUSTbrands}" var="brand">
                <li class="no-list"><a href="">${brand.brand}</a></li>
            </c:forEach>
        </ul>
    </div>
    <div class="col-md-8 ">
        <img src="" >
        <a href="/cordsOfChosenCategory?categoryIdValue=18"><h3>HDMI</h3></a>
        <ul>
            <c:forEach items="${HDMIbrands}" var="brand">
                <li class="no-list"><a href="">${brand.brand}</a></li>
            </c:forEach>
        </ul>
    </div>
    <div class="col-md-8 ">
        <img src="" >
        <a href="/cordsOfChosenCategory?categoryIdValue=19"><h3>Цифрові</h3></a>
        <ul>
            <c:forEach items="${DIGITbrands}" var="brand">
                <li class="no-list"><a href="">${brand.brand}</a></li>
            </c:forEach>
        </ul>
    </div>
    <div class="col-md-8 ">
        <img src="" >
        <a href="/cordsOfChosenCategory?categoryIdValue=20"><h3>Оптичні</h3></a>
        <ul>
            <c:forEach items="${OPTbrands}" var="brand">
                <li class="no-list"><a href="">${brand.brand}</a></li>
            </c:forEach>
        </ul>
    </div>

</div>