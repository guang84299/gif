<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
  <style type="text/css">
  .warning
  {
  	display: none;
  }
  </style>
 </head>
 <body>
  <div class="container-fluid">
   <h5 class="col-sm-offset-2">后台管理页</h5>
     
   <div class="pull-right" style="margin-top:-30px;margin-right:10px">
   		<input type="text" class="form-control" id="auto-caiji" placeholder="自动采集">
   </div>
   
   <hr/>
   
   <div class="row">
   
   <div class="col-sm-2">
   </div>
   
    <div class="col-sm-12">
    <div class="form-horizontal" role="form">
		<div class="form-group">
			<label class="control-label col-sm-3">标题</label>
	        <div class="col-sm-14">
	         <input type="text" name="title" value="" title="" class="form-control">
	         <p class="bg-warning warning" id="title-warn">标题不能为空！</p>
	        </div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-3">关键词</label>
	        <div class="col-sm-14">
	         <input type="text" name="keywords" value="" title="" class="form-control">
	         <p class="bg-warning warning" id="keywords-warn">关键词不能为空！</p>
	        </div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-3">标签</label>
	        <div class="col-sm-6">
			    <select name="tag" value="" class="form-control">
			    <c:forEach items="${tags}" var="val">
			      <option data-tagid="${val.id }">${val.name }</option>
			     </c:forEach>
			    </select>
	         <p class="bg-warning warning" id="tag-warn">标签不能为空！</p>
	        </div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-3">新增标签</label>
	        <div class="col-sm-6">
	         <input type="text" name="addTag" value="" title="" class="form-control">
	         <p class="bg-warning warning" id="addTag-warn">添加成功！</p>
	        </div>
	        <div class="col-sm-2">
			     <button class="btn btn-warning addTag">添加</button>
		    </div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-3">图片</label>
			<div class="col-sm-7">
			 <img src="" id="img-upload">
		     <input type="file" id="uploadfile">
		     <p class="bg-warning warning" id="picPath-warn">图片不能为空！</p> 
	    		</div>
	    		<div class="col-sm-2">
			     <button class="btn btn-warning btn-upload">上传</button>
		    </div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-3"></label>
			<div class="col-sm-14">
		     <button class="btn btn-warning save">保存</button>
		     <p class="bg-warning warning" id="btn-tishi"></p> 
	    		</div>
		</div>
		
	</div>

    </div>
    
    <div class="col-sm-10">
   </div>
    
   </div>
  </div>
  

  
  <script src="${pageContext.request.contextPath }/js/jquery.min.js"></script>
  <script src="${pageContext.request.contextPath }/js/bootstrap.min.js"></script>

<script type="text/javascript">  
var baseUrl =  "${pageContext.request.contextPath }/";
var uploadUrl = window.location.protocol + "//" + window.location.host + "/upload/gif";
//加载编辑器  
$(document).ready(function() {  
  
  $(".save").click(function(){
  	
    var article = {};
	article.title = $("[name='title']").val();
	article.tagId = parseInt($("[name='tag']").find("option:selected").attr("data-tagid"));
	article.keywords = $("[name='keywords']").val();
	article.picPath = $("#img-upload").attr("src");
	article.picPath = article.picPath.replace(uploadUrl,"");
	
	if(article.title == "" || article.title == null || article.title == undefined)
	{
		$("#title-warn").show();
		$("[name='title']").focus();
		return;
	}
	if(article.keywords == "" || article.keywords == null || article.keywords == undefined)
	{
		$("#keywords-warn").show();
		$("[name='keywords']").focus();
		return;
	}
	
	if(article.picPath == "" || article.picPath == null || article.picPath == undefined)
	{
		$("#picPath-warn").show();
		return;
	} 
	
    var datas = JSON.stringify(article);
    $.ajax({
			type: "post",
			data: datas,
			url: baseUrl + "addArticle",
			contentType : "application/json;charset=UTF-8",//发送数据的格式
			success: function(data) { 
				location.href = baseUrl + "add";
			}, 
			error: function(e) { 
				$("#btn-tishi").text("保存失败！");
				$("#btn-tishi").show();
				setTimeout(function(){
					$("#btn-tishi").hide();
				},2000);
			} 
		});
	});
  
  $("[name='title']").blur(function(){
  	$("#title-warn").hide();
  });
   $("[name='keywords']").blur(function(){
  	$("#keywords-warn").hide();
  });
  
  
  //添加标签
  $(".addTag").click(function(){
  		var name = $("[name='addTag']").val();
  		var tagdata = '{"name":"'+ name+ '"}';
  		$.ajax({
				type: "post",
				data: tagdata,
				url: baseUrl + "addTag",
				contentType : "application/json;charset=UTF-8",//发送数据的格式
				dataType : "json",//回调
				success: function(data) { 
					var str = '<option>'+data.name+'</option>';
					$("[name='tag']").append(str);
					$("#addTag-warn").text("添加成功！");
					$("#addTag-warn").show();
					setTimeout(function(){
						$("#addTag-warn").hide();
					},2000);
				}, 
				error: function(e) { 
					$("#addTag-warn").text("添加失败！");
					$("#addTag-warn").show();
					setTimeout(function(){
						$("#addTag-warn").hide();
					},2000);
				} 
			});
  });
  
  //上传图片
  $("#img-upload").hide();
  $(".btn-upload").click(function(){
	  var file = $("#uploadfile").prop('files');
	  var data = new FormData();  
	  data.append("pic", file[0]);
	  $.ajax({  
	        data: data,  
	        type: "POST",  
	        url: baseUrl+'uploadFile',
	        cache: false,  
	        contentType: false,  
	        processData: false,  
	        success: function(res) {  
	        		$("#img-upload").attr("src",uploadUrl+res);
	        		$("#img-upload").show();
	        		$("#uploadfile").hide();
	        		$(".btn-upload").hide();
	        		$("#picPath-warn").hide();
	        }  
	    });  
  });
  //自动采集
   	$("#auto-caiji").keydown(function() {
       if (event.keyCode == "13") {//keyCode=13是回车键
       	var durl = $("#auto-caiji").val();
       	if(durl == null || durl == '' || !durl)
       		return;
       		
       	$("#auto-caiji").attr("disabled","disabled");
       	$("#auto-caiji").val("信息采集中...");
       	
       	$.ajax({
			type: "post",
			data: {url: durl},
			url: baseUrl + "autoAdd"
		}).done(function(results) {
			location.href = baseUrl + "admin";
		})
       }
   });
   
});  
 
  
</script>  
</body></html>