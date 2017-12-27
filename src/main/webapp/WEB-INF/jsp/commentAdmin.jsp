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
   <h3 class="col-sm-offset-2" id="articleId" data-id="${aid }">后台管理页</h3>
   
   <hr/>
   
   
   <table class="table table-hover">
  <thead>
    <tr>
      <th>ID</th>
      <th>IP</th>
      <th>内容</th>
      <th>楼层</th>
      <th>喜欢</th>
      <th>时间</th>
      <th>操作</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${list }" var="val">
    <tr>
      <td>${val.id }</td>
      <td>${val.ip }</td>
      <td>${val.content }</td>
      <td>${val.floor }</td>
      <td>${val.loveNum }</td>
      <td><fmt:formatDate value="${val.cDate}" pattern="yyyy.MM.dd HH:mm:ss"/></td>
      <td>
        <button class="btn btn-primary btn-xs delete_btn" title="${val.id }" data-id="${val.articleId }">删除</button>
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

	var id = $('#articleId').attr("data-id");

	$('.delete_btn').click(function(event) {
		event.preventDefault();
		location.href = baseUrl + "deleteComment?cid="+$(this).attr("title")+"&id="+id;
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
    
    $("#a_first").attr("href","commentAdmin?index="+1+"&id="+id);
    $("#a_pre").attr("href","commentAdmin?index="+p_index+"&id="+id);
    $("#a_next").attr("href","commentAdmin?index="+n_index+"&id="+id);
    $("#a_end").attr("href","commentAdmin?index="+num+"&id="+id);
});
</script>
</body></html>