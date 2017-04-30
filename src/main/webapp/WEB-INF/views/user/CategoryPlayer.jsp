
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="row">
    <div class="col-md-8">
        <img src="" >
        <a href="/playersOfChosenCategory?categoryIdValue=1"><h3>CD програвачі</h3></a>
        <ul>
            <c:forEach items="${CDbrands}" var="brand">
                <li><a href="">${brand.brand}</a></li>
            </c:forEach>
        </ul>
    </div>
    <div class="col-md-8">
        <img src="" >
        <a href="/playersOfChosenCategory?categoryIdValue=2"><h3>ЦАП</h3></a>
        <ul>
            <c:forEach items="${ZAPbrands}" var="brand">
                <li><a href="">${brand.brand}</a></li>
            </c:forEach>
        </ul>
    </div>
    <div class="col-md-8">
        <img src="" >
        <a href="/playersOfChosenCategory?categoryIdValue=3"><h3>Стерео ресивери</h3></a>
        <ul>
            <c:forEach items="${STEREORESbrands}" var="brand">
                <li><a href="">${brand.brand}</a></li>
            </c:forEach>
        </ul>
    </div>
</div>
<div class="row">
    <div class="col-md-8">
        <img src="" >
        <a href="/playersOfChosenCategory?categoryIdValue=4"><h3>Мережеві плеєри</h3></a>
        <ul>
            <c:forEach items="${MEREZbrands}" var="brand">
                <li><a href="">${brand.brand}</a></li>
            </c:forEach>
        </ul>
    </div>
    <div class="col-md-8">
        <img src="" >
        <a href="/playersOfChosenCategory?categoryIdValue=5"><h3>Міні системи HIFI</h3></a>
        <ul>
            <c:forEach items="${MINIHIFIbrands}" var="brand">
                <li ><a href="">${brand.brand}</a></li>
            </c:forEach>
        </ul>
    </div>
    <div class="col-md-8">
        <img src="" >
        <a href="/playersOfChosenCategory?categoryIdValue=6"><h3>CD ресивери</h3></a>
        <ul>
            <c:forEach items="${CDRESbrands}" var="brand">
                <li><a href="">${brand.brand}</a></li>
            </c:forEach>
        </ul>
    </div>
</div>