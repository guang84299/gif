<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<html><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1,user-scalable=no">
  <title>后台管理页</title>
  <link rel="icon" type="image/png" href="favicon.png" sizes="32x32" />
  <link rel="bookmark" type="image/x-icon" href="favicon.ico" />
  <link rel="shortcut icon" type="image/x-icon" href="favicon.ico"/>
  <link href="${pageContext.request.contextPath }/css/bootstrap.min.css" rel="stylesheet">
 </head>
 <body>
  <div class="container-fluid">
   <h3 class="col-sm-offset-2">后台管理页</h3>
   <hr/>
   
   <form class="form-horizontal" role="form" action="login">
  <div class="form-group">
    <label for="firstname" class="col-sm-2 control-label">用户名</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="firstname" name="name">
    </div>
  </div>
  <div class="form-group">
    <label for="lastname" class="col-sm-2 control-label">密码</label>
    <div class="col-sm-10">
      <input type="password" class="form-control" id="lastname"  name="password">
    </div>
  </div>
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-default">登录</button>
    </div>
  </div>
</form>
   
   
  </div>
  <script src="${pageContext.request.contextPath }/js/jquery.min.js"></script>
  <script src="${pageContext.request.contextPath }/js/bootstrap.min.js"></script>
<script type="text/javascript"> 
var baseUrl =  window.location.protocol + "//" + window.location.host + "/";
</script>
</body></html>