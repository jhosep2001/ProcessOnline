<%@page import="java.util.List"%>
<%@page import="com.processonline.project.dominio.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" />
        <link href="<%=request.getContextPath()%>/css/bootstrap.css" rel="stylesheet">
        <script type="text/javascript"  src="<%=request.getContextPath()%>/js/jquery-1.9.0.js"></script>
        <script type="text/javascript"  src="<%=request.getContextPath()%>/js/bootstrap.js" ></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
        <title>Nuevo Usuario</title>
    </head>
    <body>
        <div class="row"></div>
        <div class="row-fluid">
            <div class="offset1 span10 well">
                <div class="row-fluid">
                    <div class="container offset1 span10 well">
                        <h3 class="row-fluid container span12">Añade un nuevo usuario con la siguiente información</h3>
                        <form:form  action="newUser.htm" method="POST">
                            <form:label path="id" >Identificador</form:label>
                            <form:input id="id" path="id" value="${user.id}"></form:input>
                            <form:label path="fecha_nacimiento" >Fecha Nacimiento</form:label>
                            <form:input name="fecha_nacimiento" value="${user.fecha_nacimiento}" path="fecha_nacimiento" type="date"></form:input>
                            <form:label path="activo">Estado Activo</form:label>
                            <form:select path="activo" value="${user.activo}">
                                <form:option value="True">Si</form:option>
                                <form:option value="False">No</form:option>
                            </form:select>
                            <form:label path="dependencia">Dependencia</form:label>
                            <form:select path="dependencia" >
                                <c:forEach items="${dependencias}" var="dependencia">
                                    <form:option value="${dependencia}"></form:option>  
                                </c:forEach>
                            </form:select>
                            <form:button class="btn btn-success" type="submit">Continuar</form:button>
                    </form:form>
                            <a href="index.htm"> <button class="btn btn-warning" >Atras</button> </a>
                    </div>
                </div>
            </div>
        </div> 
    </body>
</html>
