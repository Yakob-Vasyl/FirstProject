<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="/WEB-INF/custom.tld" prefix="custom" %>

<div class="row">

    <div class="col-md-5 hidden-xs hidden-sm">
        <div class="row sidebar">
            <div class="row sidebar-top">
                <div class="col-md-24 ">
                    <h3 class="text-center">Фільтр</h3>
                </div>
            </div>
            <div class="row sidebar">
                <div class="sidebar-main col-md-24">
                    <form:form class="form-horizontal filter" action="/playersOfChosenCategory" method="GET"
                               modelAttribute="filter">
                        <custom:hiddenInputs
                                excludeParams=" _formatId, _connectionId, formatId, connectionId, maxPrice, minPrice,categoryIdValue,sampleRate,signalNoise"/>
                        <input type="hidden" name="categoryIdValue" value="${param.categoryIdValue}">
                        <div class="form-group">
                            <label class="col-md-4 control-label">Ціна</label>
                            <div class="col-md-10">
                                <form:input path="minPrice" class="form-control" placeholder="Min"/>
                            </div>
                            <div class="col-md-10">
                                <form:input path="maxPrice" class="form-control" placeholder="Max"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-md-24">Інтерфейси підключення</label>
                            <div class="col-md-24">
                                <form:checkboxes items="${connections}" path="connectionId" itemLabel="connection"
                                                 itemValue="id"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-md-24">Підтримуванні формати</label>
                            <div class="col-md-24">
                                <form:checkboxes items="${formats}" path="formatId" itemLabel="format" itemValue="id"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-24 control-label">Сигнал/шум</label>
                            <div class="col-md-24">
                                <form:input path="signalNoise" class="form-control"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-24 control-label">Частота дискретизації</label>
                            <div class="col-md-24">
                                <form:input path="sampleRate" class="form-control"/>
                            </div>
                        </div>
                        <button type="submit" class="btn btn-primary">Ok</button>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
    <div class="col-md-19">
        <div class="row">
            <c:forEach items="${page.content}" var="player">
                <div class="col-md-8">
                    <div class="row">
                        <div class="col-md-24"><img class="img-responsive"
                                                    src="/images/player/${player.id}.jpg?version=${player.version}">
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-24"><a
                                href="/somePlayer/${player.id}">${player.brand.brand} ${player.productName}</a></div>
                    </div>
                    <div class="row">
                        <div class="col-md-24"><span>Ціна - ${player.price}</span></div>
                    </div>

                </div>
            </c:forEach>
        </div>
    </div>
</div>
<div class="row">
    <div class="col-md-24 col-xs-24 text-center">
        <custom:pageable page="${page}" cell="<li></li>" container="<ul class='pagination'></ul>"/>
    </div>
</div>

