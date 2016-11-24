<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Todo Information</title>
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
                Task Details
            </h3>
        </div>
        <div class="panel-body">
            <form:form id="todoRegisterForm" cssClass="form-horizontal" modelAttribute="todo" method="post"
                       action="saveTodo">

                <div class="form-group">
                    <div class="control-label col-xs-3"><form:label path="shortName">Name</form:label></div>
                    <div class="col-xs-6">
                        <form:hidden path="id" value="${todoObject.id}"/>
                        <form:input cssClass="form-control" path="shortName" value="${todoObject.shortName}"/>
                    </div>
                </div>

                <div class="form-group">
                    <div class="control-label col-xs-3"><form:label path="description">Description</form:label></div>
                    <div class="col-xs-6">
                        <form:input cssClass="form-control" path="description" value="${todoObject.description}"/>
                    </div>
                </div>

                <div class="form-group">
                    <div class="control-label col-xs-3"><form:label path="modifiedDate">ModifiedDate</form:label></div>
                    <div class="col-xs-6">
                        <form:input disabled="true" cssClass="form-control" path="modifiedDate" value="${todoObject.modifiedDate}"/>
                    </div>
                </div>

                <div class="form-group">
                    <div class="control-label col-xs-3"><form:label path="done">Task Is Done</form:label></div>
                    <div class="col-xs-6">
                        <input type="hidden" name="_done"/>
                        <input type="checkbox" path="done" name="done"
                               <c:if test="${todoObject.done}">checked</c:if>/>
                    </div>
                </div>

                <div class="form-group">
                    <div class="row">
                        <div class="col-xs-7"> </div>
                        <div class="col-xs-4"><input type="submit" id="saveTodo" class="btn btn-primary" value="Save" onclick="return submitTodoForm();"/>
                            <input type="button" class="btn btn-primary" value="Cancel" onclick='location.href="getAllTodos"'/>
                        </div>
                        <div class="col-xs-2"></div>
                    </div>
                </div>

            </form:form>
        </div>
    </div>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

<script type="text/javascript">
    function submitTodoForm() {
        // getting the todo form values
        var shortName = $('#shortName').val().trim();
        var description = $('#description').val().trim();
        if (shortName.length == 0 || shortName.length >15) {
            alert('Please enter shortName');
            $('#shortName').focus();
            return false;
        }
        if (description.length == 0 || description.length >60) {
            alert('Please enter description');
            $('#description').focus();
            return false;
        }
        return true;
    };
</script>
</body>
</html>