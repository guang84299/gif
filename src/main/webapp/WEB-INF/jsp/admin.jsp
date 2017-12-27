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
   
   <div class="pull-right" style="margin-top:-40px;">
        <button class="btn btn-primary add_btn">添加</button>
    </div>
   <hr/>
   
   
   <table class="table table-hover">
  <thead>
    <tr>
      <th>ID</th>
      <th>标题</th>
      <th>浏览量</th>
      <th>喜欢</th>
      <th>评论</th>
      <th>时间</th>
      <th>操作</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${list }" var="val">
    <tr>
      <td>${val.id }</td>
      <td>${val.title }</td>
      <td>${val.showNum }</td>
      <td>${val.loveNum }</td>
      <td>${val.commentNum }</td>
      <td><fmt:formatDate value="${val.cDate}" pattern="yyyy.MM.dd HH:mm:ss"/></td>
      <td>
      <c:choose> 
      <c:when test="${val.grelease }">
      	<button class="btn btn-primary btn-xs release_btn" title="${val.id }">已发布</button>
      </c:when>
      <c:otherwise>
      	<button class="btn btn-warning btn-xs release_btn" title="${val.id }">发布</button>
      </c:otherwise>
      </c:choose>
        <button class="btn btn-primary btn-xs update_btn" title="${val.id }">更改</button>
        <button class="btn btn-primary btn-xs delete_btn" title="${val.id }">删除</button>
        <button class="btn btn-primary btn-xs comment_btn" title="${val.id }">评论</button>
      </td>
    </tr>
	</c:forEach>
    
    
  </tbody>
</table>
<hr/>
<div class="text-center">
  <p id="ye1" align="center">
    <a href="" id="a_first" class="btn btn-small btn-success" title="First Page">&laquo; 首页</a>
    <a href="" id="a_pre" class="btn btn-small btn-success" title="Previous Page">&laquo;上一页</a>
    <a href="" id="a_curr" class="btn btn-small btn-warning ye1" title="${page}">${page}</a>
    <a href="" id="a_next" class="btn btn-small btn-success" title="Next Page">下一页 &raquo;</a>
    <a href="" id="a_end" class="btn btn-small btn-success" title="Last Page">尾页&raquo;</a>
    <a id="a_num" class="btn btn-small btn-warning yel" title="${num}">共${num} 页</a>
  </p>
</div>

   
   
  </div>
  <script src="${pageContext.request.contextPath }/js/jquery.min.js"></script>
  <script src="${pageContext.request.contextPath }/js/bootstrap.min.js"></script>
<script type="text/javascript"> 
var baseUrl =  "${pageContext.request.contextPath }/";
$(document).ready(function() {
	$('.add_btn').click(function(event) {
		event.preventDefault();
		location.href = baseUrl + "add";
	});
	
	$('.update_btn').click(function(event) {
		event.preventDefault();
		location.href = baseUrl + "toUpdate?id="+$(this).attr("title");
	});
	
	$('.delete_btn').click(function(event) {
		event.preventDefault();
		location.href = baseUrl + "deleteArticle?id="+$(this).attr("title");
	});
	
	$('.release_btn').click(function(event) {
		event.preventDefault();
		location.href = baseUrl + "releaseArticle?id="+$(this).attr("title");
	});
	
	$('.comment_btn').click(function(event) {
		event.preventDefault();
		location.href = baseUrl + "commentAdmin?id="+$(this).attr("title");
	});

	var curr_index = $("#a_curr").attr("title");
    var c_index = parseInt(curr_index);
    var p_index = c_index - 1;
    if(p_index < 1)
    	p_index = 1;
    
    var a_num = $("#a_num").attr("title");
    var num = parseInt(a_num);
    var n_index = c_index + 1;
    if(n_index > num)
    	n_index = num;
    
    $("#a_first").attr("href","admin?index="+1);
    $("#a_pre").attr("href","admin?index="+p_index);
    $("#a_next").attr("href","admin?index="+n_index);
    $("#a_end").attr("href","admin?index="+num);
});
</script>
</body></html>