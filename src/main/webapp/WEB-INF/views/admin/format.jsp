<%--
  Created by IntelliJ IDEA.
  User: vasya
  Date: 016 16 02 2017
  Time: 16:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="/WEB-INF/custom.tld" prefix="custom"%>
<div class="row">
    <div class="col-md-6 col-xs-12">
        <form:form class="form-inline" action="/admin/format" method="GET" modelAttribute="filter">
            <custom:hiddenInputs excludeParams="search"/>
            <div class="form-group">
                <form:input path="search" class="form-controll" placeholder="Search"/>
            </div>
            <button type="submit" class="btn btn-primary">Ok</button>
        </form:form>
    </div>
    <div class="col-md-14 col-xs-12">
        <div class="row">
            <div class="col-md-24 col-xs-12">
                <form:form class="form-horizontal" action="/admin/format" method="POST" modelAttribute="format">
                    <custom:hiddenInputs excludeParams="format"/>
                    <div class="form-group">
                        <label class="col-md-20 col-md-offset-4 control-label" for="name" style="color:red;text-align:left;"><form:errors path="format"/></label>
                    </div>
                    <div class="form-group">
                        <label for="name" class="col-md-4 control-label">Format</label>
                        <div class="col-md-20">
                            <form:input class="form-control" path="format" id="name"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-offset-4 col-md-20">
                            <button type="submit" class="btn btn-default">Create</button>
                        </div>
                    </div>
                </form:form>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6 col-xs-6"><h3>Format</h3></div>
            <div class="col-md-6 col-xs-6"><h3>Update</h3></div>
            <div class="col-md-6 col-xs-6"><h3>Delete</h3></div>
        </div>
        <c:forEach items="${page.content}" var="format">
            <div class="row">
                <div class="col-md-6 col-xs-6">${format.format}</div>
                <div class="col-md-6 col-xs-6"><a class="btn btn-warning" href="/admin/format/update/${format.id}<custom:allParams/>">update</a></div>
                <div class="col-md-6 col-xs-6"><a class="btn btn-danger" href="/admin/format/delete/${format.id}<custom:allParams/>">delete</a></div>
            </div>
        </c:forEach>
        <a href="../admin">Main</a>
    </div>
    <div class="col-md-4 col-xs-12">
        <div class="row">
            <div class="col-md-12 col-xs-12 text-center">
                <div class="dropdown">
                    <button class="btn btn-primary dropdown-toggle" type="button"
                            data-toggle="dropdown">
                        Sort <span class="caret"></span>
                    </button>
                    <ul class="dropdown-menu">
                        <custom:sort innerHtml="Name asc" paramValue="format" />
                        <custom:sort innerHtml="Name desc" paramValue="format,desc" />
                    </ul>
                </div>
            </div>
            <div class="col-md-12 col-xs-12 text-center">
                <custom:size posibleSizes="1,2,5,10" size="${page.size}" />
            </div>
        </div>
    </div>
</div>
<div class="row">
    <div class="col-md-24 col-xs-12 text-center">
        <custom:pageable page="${page}" cell="<li></li>"
                         container="<ul class='pagination'></ul>" />
    </div>
</div>