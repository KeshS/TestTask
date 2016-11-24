<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>List of tasks</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <style type="text/css">
        .myrow-container {
            margin: 20px;
        }
    </style>
</head>
<body class=".container-fluid">
<div class="container myrow-container">
    <div class="panel panel-success">
        <div class="panel-heading">
            <h3 class="panel-title">
                <div align="left"><a href="getAllTodos"> <b>List of tasks</b> </a></div>
                <div align="right"><a href="createTodo">Add New Task</a></div>
            </h3>
        </div>
        <div class="panel-body">
            <form action="searchTodo">
                <div class="col-md-12" style="margin-top:3px;">
                    <div class="row">
                        <div class="col-md-10">
                            <div class="col-md-5" align="center">
                                <input type="radio" name="searchIsDone" value="true"
                                       <c:if test="${searchIsDone==true}">checked</c:if>> Completed
                                <input type="radio" name="searchIsDone" value="false"
                                       <c:if test="${searchIsDone==false}">checked</c:if>> Only Incompleted
                                <input type="radio" name="searchIsDone" value=""
                                       <c:if test="${searchIsDone==null}">checked</c:if>> All tasks
                            </div>
                            <div class="col-md-3" style="margin-bottom:3px;" align="center"><input
                                    class="btn btn-success" type='submit' value='Search'/></div>
                        </div>
                    </div>
                </div>
            </form>

            <c:if test="${empty todoList}">
                <div class="col-xs-10" style="margin-top:20px;">
                    <div class="row">
                        <div class="col-md-6">
                            <b> There are no Todo's </b>
                        </div>
                    </div>
                </div>

            </c:if>
            <c:if test="${not empty todoList}">
                <table class="table table-hover table-bordered">
                    <thead style="background-color: #bce8f1;">
                    <tr>
                        <th>Name</th>
                        <th>Description</th>
                        <th style="text-align: center;">Task Is Done</th>
                        <th>ModifiedDate</th>
                        <th>Edit</th>
                        <th>Delete</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${todoList}" var="emp">
                        <tr>
                            <th><c:out value="${emp.shortName}"/></th>
                            <th><c:out value="${emp.description}"/></th>
                            <td style="text-align: center; vertical-align: middle;">
                                <input type="hidden" name="_isDone"/>
                                <input type="checkbox" disabled name="isDone" value="true"
                                       <c:if test="${emp.done}">checked</c:if>/>
                            </td>
                            <th><c:out value="${emp.modifiedDate}"/></th>
                            <th><a href="editTodo?id=<c:out value='${emp.id}'/>">Edit</a></th>
                            <th><a href="deleteTodo?id=<c:out value='${emp.id}'/>">Delete</a></th>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </c:if>
        </div>
    </div>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</body>
</html>