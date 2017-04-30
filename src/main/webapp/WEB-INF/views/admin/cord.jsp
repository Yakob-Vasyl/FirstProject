<%--
  Created by IntelliJ IDEA.
  User: vasya
  Date: 017 17 02 2017
  Time: 16:21
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
    <div class="col-md-6 col-xs-12">
        <form:form class="form-horizontal filter" action="/admin/cord" method="GET" modelAttribute="filter">

            <custom:hiddenInputs excludeParams=" _brandId, _connectionId, brandId, connectionId, maxPrice, minPrice,cordLength,file,brand,category"/>
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
                    <form:input path="cordLength" class="form-control" placeholder="Length"/>
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
    <div class="col-md-14 col-xs-7">
        <div class="row">
            <div class="col-md-24 col-xs-12">

                <form:form class="form-horizontal" action="/admin/cord" method="POST" modelAttribute="cord" enctype="multipart/form-data">
                    <custom:hiddenInputs excludeParams="productName, length, material,price,file"/>

                    <div class="form-group">
                        <label class="col-md-20 col-md-offset-4 control-label" for="name" style="color:red;text-align:left;"><form:errors path="productName"/></label>
                    </div>
                    <div class="form-group">
                        <label for="name" class="col-md-2 control-label">Cord</label>
                        <div class="col-md-14">
                            <form:input type="text" class="form-control" path="productName" id="name"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-20 col-md-offset-4 control-label" for="name" style="color:red;text-align:left;"><form:errors path="connection"/></label>
                    </div>
                    <div class="form-group">
                        <label class="col-md-2 control-label">Connection</label>
                        <div class="col-md-14">
                            <form:select path="connection" class="form-control" items="${connections}" itemLabel="connection" itemValue="id"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-20 col-md-offset-4 control-label" for="name" style="color:red;text-align:left;"><form:errors path="brand"/></label>
                    </div>
                    <div class="form-group">
                        <label class="col-md-2 control-label">Brand</label>
                        <div class="col-md-14">
                            <form:select path="brand" class="form-control" items="${brands}" itemLabel="brand" itemValue="id"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-20 col-md-offset-4 control-label" for="name" style="color:red;text-align:left;"><form:errors path="category"/></label>
                    </div>
                    <div class="form-group">
                        <label class="col-md-2 control-label">Category</label>
                        <div class="col-md-14">
                            <form:select path="category" class="form-control" items="${categories}" itemLabel="category" itemValue="id"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-20 col-md-offset-4 control-label" for="name" style="color:red;text-align:left;"><form:errors path="length"/></label>
                    </div>
                    <div class="form-group">
                        <label for="category" class="col-md-2 control-label">Length</label>
                        <div class="col-md-14">
                            <form:input type="text" class="form-control" path="length" id="category"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-20 col-md-offset-4 control-label" for="name" style="color:red;text-align:left;"><form:errors path="material"/></label>
                    </div>
                    <div class="form-group">
                        <label for="category" class="col-md-2 control-label">Material</label>
                        <div class="col-md-14">
                            <form:input type="text" class="form-control" path="material" id="category"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-20 col-md-offset-4 control-label" for="name" style="color:red;text-align:left;"><form:errors path="price"/></label>
                    </div>
                    <div class="form-group">
                        <label for="category" class="col-md-2 control-label">Price</label>
                        <div class="col-md-14">
                            <form:input type="text" class="form-control" path="price" id="category"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="file" class="col-md-4 control-label">Image</label>
                        <div class="col-md-20">
                            <input type="file" name="file" id="file">
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

            <div class="col-md-6 col-xs-6"><h3>Image</h3></div>
            <div class="col-md-6 col-xs-6"><h3>Cord</h3></div>
            <div class="col-md-6 col-xs-6"><h3>Update</h3></div>
            <div class="col-md-6 col-xs-6"><h3>Delete</h3></div>
        </div>
        <c:forEach items="${page.content}" var="cord">
            <div class="row">
                <div class="col-md-6 col-xs-6"><img src="/images/cord/${cord.id}.jpg?version=${cord.version}" width="100%"></div>
                <div class="col-md-6 col-xs-6">${cord.productName}</div>
                <div class="col-md-6 col-xs-6"><a class="btn btn-warning" href="/admin/cord/update/${cord.id}<custom:allParams/>">update</a></div>
                <div class="col-md-6 col-xs-6"><a class="btn btn-danger"
                                                  href="/admin/cord/delete/${cord.id}<custom:allParams/>">delete</a></div>
            </div>
        </c:forEach>
        <a href=".../admin">Main</a>
    </div>
        <div class="col-md-4 col-xs-24">
            <div class="row">
                <div class="col-md-12 col-xs-12 text-center">
                    <div class="dropdown">
                        <button class="btn btn-primary dropdown-toggle" type="button"
                                data-toggle="dropdown">
                            Sort <span class="caret"></span>
                        </button>
                        <ul class="dropdown-menu">
                            <custom:sort innerHtml="Cord asc" paramValue="productName" />
                            <custom:sort innerHtml="Cord desc" paramValue="productName,desc" />
                           <%-- <custom:sort innerHtml="Ingredient name asc" paramValue="ingredient.name" />
                            <custom:sort innerHtml="Ingredient name desc" paramValue="ingredient.name,desc" />--%>
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
    <div class="col-md-24 col-xs-24 text-center">
        <custom:pageable page="${page}" cell="<li></li>"
                         container="<ul class='pagination'></ul>" />
    </div>
</div>
