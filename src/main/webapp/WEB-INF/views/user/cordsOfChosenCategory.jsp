
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="/WEB-INF/custom.tld" prefix="custom"%>

<div class="row">
    <div class="col-md-3 hidden-xs hidden-sm">
        <div class="row sidebar">
            <div class="row sidebar-top">
                <div class="col-md-24 ">
                    <h3 class="text-center">Фільтр</h3>
                </div>
            </div>

            <div class="row sidebar">
                <div class="sidebar-main col-md-24">
                    <form:form class="form-horizontal filter" action="/cordsOfChosenCategory" method="GET" modelAttribute="filter" >
                        <custom:hiddenInputs excludeParams=" _connectionId, connectionId, maxPrice, minPrice, categoryId,cordLength"/>
                        <div class="form-group">
                            <label class="col-md-4 control-label">Price</label>
                            <div class="col-md-10">
                                <form:input path="minPrice" class="form-control" placeholder="Min"/>
                            </div>
                            <div class="col-md-10">
                                <form:input path="maxPrice" class="form-control" placeholder="Max"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-24">
                                <label class="control-label col-md-24">Довжина кабелю</label>
                                <form:input path="cordLength" class="form-control" placeholder="Довжина"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-md-24">Connections</label>
                            <div class="col-md-24">
                                <form:checkboxes items="${connections}" path="connectionId" itemLabel="connection" itemValue="id"/>
                            </div>
                        </div>
                        <button type="submit" class="btn btn-primary">Ok</button>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
    <div class="col-md-18">
        <form:errors path="*"/>
        <div class="row">
            <c:forEach items="${page.content}" var="cord">
                <div class="col-md-8">
                    <img src="/images/cord/${cord.id}.jpg?version=${cord.version}">
                    <a href="/someCord/${cord.id}">${cord.brand.brand} ${cord.productName}</a>
                    <span>${cord.price}</span>
                </div>
            </c:forEach>
        </div>

    </div>
</div>
<div class="row">
    <div class="col-md-24 col-xs-24 text-center">
        <custom:pageable page="${page}" cell="<li></li>"
                         container="<ul class='pagination'></ul>" />
    </div>
</div>

