<%--
  Created by IntelliJ IDEA.
  User: vasya
  Date: 013 13 03 2017
  Time: 16:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="row">
    <div class="col-sm-24 col-xs-24">
        <form:form class="form-horizontal" action="/registration" method="POST" modelAttribute="user">
            <div class="form-group">
                <label for="email" class="col-sm-offset-4 col-sm-20"><form:errors path="email"/></label>
            </div>
            <div class="form-group">
                <label for="email" class="col-sm-4 control-label">Email</label>
                <div class="col-sm-12">
                    <form:input class="form-control" path="email" id="email"/>
                </div>
            </div>
            <div class="form-group">
                <label for="email" class="col-sm-offset-4 col-sm-20"><form:errors path="password"/></label>
            </div>
            <div class="form-group">
                <label for="password" class="col-sm-4 control-label">Password</label>
                <div class="col-sm-12">
                    <form:password class="form-control" path="password" id="password"/>
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-4 col-sm-20">
                    <button type="submit" class="btn btn-primary">Register</button>
                </div>
            </div>
        </form:form>
    </div>
</div>