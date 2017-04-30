
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="row">
    <div class="col-md-8">
        <img src="" >
        <a href="/speakersOfChosenCategory?categoryIdValue=7"><h3>Комплекти акустики 5.1</h3></a>
        <ul>
            <c:forEach items="${KOM5brands}" var="brand">
                <li><a href="">${brand.brand}</a></li>
            </c:forEach>
        </ul>
    </div>
    <div class="col-md-8">
        <img src="" >
        <a href="/speakersOfChosenCategory?categoryIdValue=8"><h3>Настіна акустика</h3></a>
        <ul>
            <c:forEach items="${NASTbrands}" var="brand">
                <li><a href="">${brand.brand}</a></li>
            </c:forEach>
        </ul>
    </div>
    <div class="col-md-8">
        <img src="" >
        <a href="/speakersOfChosenCategory?categoryIdValue=9"><h3>Сабвуфери</h3></a>
        <ul>
            <c:forEach items="${SABbrands}" var="brand">
                <li><a href="">${brand.brand}</a></li>
            </c:forEach>
        </ul>
    </div>
    <div class="col-md-8">
        <img src="" >
        <a href="//speakersOfChosenCategory?categoryIdValue=10"><h3>Вбудована акустика</h3></a>
        <ul>
            <c:forEach items="${VBUDbrands}" var="brand">
                <li><a href="">${brand.brand}</a></li>
            </c:forEach>
        </ul>
    </div>

</div>