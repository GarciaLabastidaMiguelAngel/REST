<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="<c:url value="/resources/js/jquery-2.1.1.min.js" />"  type="text/javascript"></script> 
         <script src="<c:url value="/resources/js/funciones.js" />"  type="text/javascript"></script> 
          <script src="<c:url value="/resources/js/Chart.js" />"  type="text/javascript"></script> 
        <link href="<c:url value="/resources/css/bootstrap-3.2.0/bootstrap.min.css" />" rel="stylesheet" media="screen">
        <title>ITO-REST-CLIET</title>
    </head>

    <body>
    <nav class="navbar navbar-default" role="navigation">
        <div>
            <ul class="nav navbar-nav">
                <li><a href="/index">Principal</a></li>
                <li class="active"><a>Cliente</a></li>
                <li><a href="/doc/documentacion">Documentacion</a></li>
                
            </ul>
        </div>
    </nav>
        
        
        <div class="container" id="principal">
           
        </div>
        <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
    </body>
</html>