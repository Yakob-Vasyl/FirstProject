<%--
  Created by IntelliJ IDEA.
  User: vasya
  Date: 019 19 02 2017
  Time: 14:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/custom.tld" prefix="custom"%>
<style>
    .filter .control-label{
        text-align: left;
    }
    .filter span{
        display: block;
    }
</style>
<div class="row">
    <div class="col-md-3 col-xs-12">
        <form:form class="form-horizontal filter" action="/admin/player" method="GET" modelAttribute="filter" >

            <custom:hiddenInputs excludeParams=" _formatId, _connectionId, formatId, connectionId, maxPrice, minPrice,file,categoryIdValue,_categoryIdValue"/>
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
                <label class="control-label col-md-24">Connections</label>
                <div class="col-md-24">
                    <form:checkboxes items="${connections}" path="connectionId" itemLabel="connection" itemValue="id"/>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-md-24">Formats</label>
                <div class="col-md-24">
                    <form:checkboxes items="${formats}" path="formatId" itemLabel="format" itemValue="id"/>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-md-24">Categories</label>
                <div class="col-md-24">
                    <form:select items="${categories}" path="categoryIdValue" itemLabel="category" itemValue="id"/>
                </div>
            </div>
            <button type="submit" class="btn btn-primary">Ok</button>
        </form:form>

    </div>
    <div class="col-md-14 col-xs-12">
        <div class="row">
            <div class="col-md-24 col-xs-12">
                <form:form class="form-horizontal" action="/admin/player" method="POST" modelAttribute="player" enctype="multipart/form-data">
                    <custom:hiddenInputs excludeParams="productName, signal_noise ,sample_rate,price, power,bandwidth ,weight,file,version,brand,category"/>
                    <form:errors path="*"/>
                    <div class="form-group">
                        <label class="col-sm-20 col-sm-offset-4 control-label" for="name" style="color:red;text-align:left;"><form:errors path="productName"/></label>
                    </div>
                    <div class="form-group">
                        <label for="name" class="col-md-4 control-label">Player</label>
                        <div class="col-md-14">
                            <form:input class="form-control" path="productName" id="name"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-20 col-sm-offset-4 control-label" for="name" style="color:red;text-align:left;"><form:errors path="sample_rate"/></label>
                    </div>
                    <div class="form-group">
                        <label for="name" class="col-md-4 control-label">Sample rate</label>
                        <div class="col-md-14">
                            <form:input class="form-control" path="sample_rate" id="name"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-20 col-sm-offset-4 control-label" for="name" style="color:red;text-align:left;"><form:errors path="signal_noise"/></label>
                    </div>
                    <div class="form-group">
                        <label for="name" class="col-md-4 control-label">Signal noise</label>
                        <div class="col-md-14">
                            <form:input class="form-control" path="signal_noise" id="name"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-20 col-sm-offset-4 control-label" for="name" style="color:red;text-align:left;"><form:errors path="power"/></label>
                    </div>
                    <div class="form-group">
                        <label for="name" class="col-md-4 control-label">Power</label>
                        <div class="col-md-14">
                            <form:input class="form-control" path="power" id="name"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-20 col-sm-offset-4 control-label" for="name" style="color:red;text-align:left;"><form:errors path="bandwidth"/></label>
                    </div>
                    <div class="form-group">
                        <label for="name" class="col-md-4 control-label">Bandwidth</label>
                        <div class="col-md-14">
                            <form:input class="form-control" path="bandwidth" id="name"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-20 col-sm-offset-4 control-label" for="name" style="color:red;text-align:left;"><form:errors path="weight"/></label>
                    </div>
                    <div class="form-group">
                        <label for="name" class="col-md-4 control-label">Weight</label>
                        <div class="col-md-14">
                            <form:input class="form-control" path="weight" id="name"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-20 col-sm-offset-4 control-label" for="name" style="color:red;text-align:left;"><form:errors path="price"/></label>
                    </div>
                    <div class="form-group">
                        <label for="name" class="col-md-4 control-label">Price</label>
                        <div class="col-md-14">
                            <form:input class="form-control" path="price" id="name"/>
                        </div>
                    </div>


                    <div class="form-group">
                        <label class="col-md-4 control-label">Connection</label>
                        <div class="col-md-14">
                            <form:select path="connections" class="form-control" items="${connections}" itemLabel="connection" itemValue="id"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-md-4 control-label">Brand</label>
                        <div class="col-md-14">
                            <form:select path="brand" class="form-control" items="${brands}" itemLabel="brand" itemValue="id"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-4 control-label">Format</label>
                        <div class="col-md-14">
                            <form:select path="formats" items="${formats}" class="form-control" itemLabel="format" itemValue="id"   />
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-20 col-sm-offset-4 control-label" for="name" style="color:red;text-align:left;"><form:errors path="category"/></label>
                    </div>
                    <div class="form-group">
                        <label class="col-md-4 control-label">Category</label>
                        <div class="col-md-14">
                            <form:select path="category" class="form-control" items="${categories}" itemLabel="category" itemValue="id"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="file" class="col-sm-4 control-label">Image</label>
                        <div class="col-sm-20">
                            <input type="file" name="file" id="file">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-4 col-sm-20">
                            <button type="submit" class="btn btn-default">Create</button>
                        </div>
                    </div>
                </form:form>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6 col-xs-6"><h3>Image</h3></div>
            <div class="col-md-6 col-xs-6"><h3>Player</h3></div>
            <div class="col-md-6 col-xs-6"><h3>Update</h3></div>
            <div class="col-md-6 col-xs-6"><h3>Delete</h3></div>
        </div>
        <c:forEach items="${page.content}" var="player">
            <div class="row">
                <div class="col-md-6 col-xs-6"><img src="/images/player/${player.id}.jpg?version=${player.version}" width="100%"></div>
                <div class="col-md-6 col-xs-6">${player.productName}</div>
                <div class="col-md-6 col-xs-6"><a class="btn btn-warning" href="/admin/player/update/${player.id}<custom:allParams/>">update</a></div>
                <div class="col-md-6 col-xs-6"><a class="btn btn-danger"
                                                  href="/admin/player/delete/${player.id}<custom:allParams/>">delete</a></div>
            </div>
        </c:forEach>
        <a href="../admin">Main</a>
    </div>
    <div class="col-md-4 col-xs-12">
        <div class="row">
            <div class="col-md-6 col-xs-6 text-center">
                <div class="dropdown">
                    <button class="btn btn-primary dropdown-toggle" type="button"
                            data-toggle="dropdown">
                        Sort <span class="caret"></span>
                    </button>
                    <ul class="dropdown-menu">
                        <custom:sort innerHtml="Page asc" paramValue="productName" />
                        <custom:sort innerHtml="Page desc" paramValue="productName,desc" />
                        <%-- <custom:sort innerHtml="Ingredient name asc" paramValue="ingredient.name" />
                         <custom:sort innerHtml="Ingredient name desc" paramValue="ingredient.name,desc" />--%>
                    </ul>
                </div>
            </div>
            <div class="col-md-12 col-xs-6 text-center">
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
