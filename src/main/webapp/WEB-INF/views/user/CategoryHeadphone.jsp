
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="row">
    <div class="col-md-8">
        <img src="" >
        <a href="/headphonesOfChosenCategory?categoryIdValue=13"><h3>Вкладиші</h3></a>
        <ul>
            <c:forEach items="${VKLDbrands}" var="brand">
                <li><a href="">${brand.brand}</a></li>
            </c:forEach>
        </ul>
    </div>
    <div class="col-md-8">
        <img src="" >
        <a href="/headphonesOfChosenCategory?categoryIdValue=14"><h3>Вакуумні</h3></a>
        <ul>
            <c:forEach items="${VAKUMbrands}" var="brand">
                <li><a href="">${brand.brand}</a></li>
            </c:forEach>
        </ul>
    </div>
    <div class="col-md-8">
        <img src="" >
        <a href="/headphonesOfChosenCategory?categoryIdValue=15"><h3>Накладні</h3></a>
        <ul>
            <c:forEach items="${NAKLADbrands}" var="brand">
                <li><a href="">${brand.brand}</a></li>
            </c:forEach>
        </ul>
    </div>
    <div class="col-md-8">
        <img src="" >
        <a href="/headphonesOfChosenCategory?categoryIdValue=16"><h3>Безпровідні</h3></a>
        <ul>
            <c:forEach items="${BEZPRVDbrands}" var="brand">
                <li><a href="">${brand.brand}</a></li>
            </c:forEach>
        </ul>
    </div>
</div>