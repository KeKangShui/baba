<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.opensymphony.com/oscache" prefix="oscache"%>
<html>
  <head>
    <title>$Title$</title>
    <meta http-equiv="content-type" content="text/html;charset=utf-8"/>
  </head>
  <body>
  现在时间：<%=new Date()%><br/>
  <oscache:cache scope="session">
    缓存时间：<%=new Date()%>
  </oscache:cache>
  </body>
</html>
