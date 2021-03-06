<%--
  Created by IntelliJ IDEA.
  User: vasya
  Date: 019 19 02 2017
  Time: 23:01
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
    <div class="col-md-6 col-xs-24">
        <form:form class="form-horizontal filter form-registration" action="/admin/headphone" method="GET" modelAttribute="filter">

            <custom:hiddenInputs excludeParams=" _brandId, _connectionId, brandId, connectionId, maxPrice, minPrice"/>
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
            <button type="submit" class="btn btn-primary">Ok</button>
        </form:form>
    </div>
    <div class="col-md-14 col-xs-7">
        <div class="row">
            <div class="col-md-24 col-xs-24">
                <form:form class="form-horizontal" action="/admin/headphone" method="POST" modelAttribute="headphone" enctype="multipart/form-data">
                    <custom:hiddenInputs excludeParams="productName,sensitivity, frequency_range,price, resistance,cord_length ,color,file,brand,category"/>
                    <form:errors path="*"/>
                    <div class="form-group">
                        <label class="col-md-20 col-md-offset-4 control-label" for="name" style="color:red;text-align:left;"><form:errors path="productName"/></label>
                    </div>
                    <div class="form-group">
                        <label for="name" class="col-md-4 control-label">Headphone</label>
                        <div class="col-md-14">
                            <form:input type="text" class="form-control" path="productName" id="name"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-4 control-label">Connection</label>
                        <div class="col-md-14">
                            <form:select path="connection" items="${connections}" itemValue="id" itemLabel="connection"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-4 control-label">Brand</label>
                        <div class="col-md-14">
                            <form:select path="brand" items="${brands}" itemLabel="brand" itemValue="id"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-md-20 col-md-offset-4 control-label" for="name" style="color:red;text-align:left;"><form:errors path="category"/></label>
                    </div>
                    <div class="form-group">
                        <label class="col-md-4 control-label">Category</label>
                        <div class="col-md-14">
                            <form:select path="category" class="form-control" items="${categories}" itemLabel="category" itemValue="id"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-md-20 col-md-offset-4 control-label" for="name" style="color:red;text-align:left;"><form:errors path="resistance"/></label>
                    </div>
                    <div class="form-group">
                        <label for="name" class="col-md-4 control-label">Resistance</label>
                        <div class="col-md-14">
                            <form:input type="text" class="form-control" path="resistance" id="name"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-md-20 col-md-offset-4 control-label" for="name" style="color:red;text-align:left;"><form:errors path="frequency_range"/></label>
                    </div>
                    <div class="form-group">
                        <label for="name" class="col-md-4 control-label">Frequency range</label>
                        <div class="col-md-14">
                            <form:input type="text" class="form-control" path="frequency_range" id="name"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-md-20 col-md-offset-4 control-label" for="name" style="color:red;text-align:left;"><form:errors path="sensitivity"/></label>
                    </div>
                    <div class="form-group">
                        <label for="name" class="col-md-4 control-label">Sensitivity</label>
                        <div class="col-md-14">
                            <form:input type="text" class="form-control" path="sensitivity" id="name"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-md-20 col-md-offset-4 control-label" for="name" style="color:red;text-align:left;"><form:errors path="cord_length"/></label>
                    </div>
                    <div class="form-group">
                        <label for="name" class="col-md-4 control-label">Cord length</label>
                        <div class="col-md-14">
                            <form:input type="text" class="form-control" path="cord_length" id="name"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-md-20 col-md-offset-4 control-label" for="name" style="color:red;text-align:left;"><form:errors path="color"/></label>
                    </div>
                    <div class="form-group">
                        <label for="name" class="col-md-4 control-label">Color</label>
                        <div class="col-md-14">
                            <form:input type="text" class="form-control" path="color" id="name"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-md-20 col-md-offset-4 control-label" for="name" style="color:red;text-align:left;"><form:errors path="price"/></label>
                    </div>
                    <div class="form-group">
                        <label for="name" class="col-md-4 control-label">Price</label>
                        <div class="col-md-14">
                            <form:input type="text" class="form-control" path="price" id="name"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-md-20 col-md-offset-4 control-label" for="name" style="color:red;text-align:left;"><form:errors path="have_microphone"/></label>
                    </div>
                    <div class="form-group">
                        <label for="name" class="col-md-4 control-label">Have microphone</label>
                        <div class="col-md-14">
                            <form:checkbox class="form-control" path="have_microphone" id="name"/>
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
            <div class="col-md-6 col-xs-6"><h3>Headphone</h3></div>
            <div class="col-md-6 col-xs-6"><h3>Update</h3></div>
            <div class="col-md-6 col-xs-6"><h3>Delete</h3></div>
        </div>
        <c:forEach items="${page.content}" var="headphone">
            <div class="row">
                <div class="col-md-6 col-xs-6"><img src="/images/headphone/${headphone.id}.jpg?version=${headphone.version}" width="100%"></div>
                <div class="col-md-6 col-xs-6">${headphone.productName}</div>
                <div class="col-md-6 col-xs-6"><a class="btn btn-warning" href="/admin/headphone/update/${headphone.id}<custom:allParams/>">update</a></div>
                <div class="col-md-6 col-xs-6"><a class="btn btn-danger"
                                                  href="/admin/headphone/delete/${headphone.id}<custom:allParams/>">delete</a></div>
            </div>
        </c:forEach>
        <a href="../admin">Main</a>
    </div>
    <div class="col-md-4 col-xs-24"> <div class="row">
        <div class="col-md-12 col-xs-12 text-center">
            <div class="dropdown">
                <button class="btn btn-primary dropdown-toggle" type="button"
                        data-toggle="dropdown">
                    Sort <span class="caret"></span>
                </button>
                <ul class="dropdown-menu">
                    <custom:sort innerHtml="Headphone asc" paramValue="productName" />
                    <custom:sort innerHtml="Headphone desc" paramValue="productName,desc" />
                    <%-- <custom:sort innerHtml="Ingredient name asc" paramValue="ingredient.name" />
                     <custom:sort innerHtml="Ingredient name desc" paramValue="ingredient.name,desc" />--%>
                </ul>
            </div>
        </div>
        <div class="col-md-12 col-xs-12 text-center">
            <custom:size posibleSizes="1,2,5,10" size="${page.size}" />
        </div>
    </div></div>
</div>
<div class="row">
    <div class="col-md-24 col-xs-24 text-center">
        <custom:pageable page="${page}" cell="<li></li>"
                         container="<ul class='pagination'></ul>" />
    </div>
</div>
