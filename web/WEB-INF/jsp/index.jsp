<%@page import="com.processonline.project.dominio.Usuario"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" />
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
        <link href="<%=request.getContextPath()%>/css/bootstrap.css" rel="stylesheet">
        <script type="text/javascript"  src="<%=request.getContextPath()%>/js/jquery-1.9.0.js"></script>
        <script type="text/javascript"  src="<%=request.getContextPath()%>/js/bootstrap.js" ></script>
        
        <title>Spring hibernate project</title>
    </head>

    <body>
        <h3>Pagina Principal - Observa los Usuarios que se encuentran almacenados</h3>
        <div class="row-fluid">
            <div class="span12">&nbsp;</div>
        </div>
        <div class="row-fluid">
            <div class="offset1  span10">
                <div class="row-fluid">
                    <div class="span12">
                        <a id="btnNuevo" class="btn btn-primary" href="<%=request.getContextPath()%>/usuario.htm">Nuevo Usuario</a>
                        <a id="btnNuevo" class="btn btn-warning" href="<%=request.getContextPath()%>/index.htm">Actualizar</a>
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                        <table class="table table-bordered table-hover table-condensed">
                            <thead>
                                <tr>
                                    <th>#</th>
                                    <th>Fecha Nacimiento</th>
                                    <th>Activo</th>
                                    <th>Dependencia</th>
                                    <th>Opciones</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${usuarios}" var="usuario">
                                <tr>
                                    <th>${usuario.id}</th>
                                    <th>${usuario.fecha_nacimiento}</th>
                                    <th>${usuario.activo}</th>
                                    <th>${usuario.dependencia}</th>
                                    <th>
                                        <a href="<%=request.getContextPath()%>/borrar.htm?id=${usuario.id}" title="Borrar" ><i class="btn-danger ">Borra</i></a>
                                        <a href="<%=request.getContextPath()%>/actualizar.htm?id=${usuario.id}" title="update" ><i class="btn-info ">Actualiza</i></a>
                                    </th>
                                </tr>
                                </c:forEach>
                            </tbody>
                        </table>
            </div>
        </div>
    </body>
</html>
