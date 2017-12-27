<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %><%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"
%><%@ page trimDirectiveWhitespaces="true" %><!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=no">
    <c:choose>  
	   <c:when test="${home}">
	<title>天天GIF_动态图片_搞笑死人</title>
	<meta name="keywords" content="搞笑图片,搞笑qq图片,gif,动态图片,搞笑动态图片,gif动态图片,搞笑动态图片,笑死人,搞笑gif">
    <meta name="description" content="天天GIF(www.cgcgx.com)提供各种搞笑动态图片、恶搞gif动态图、雷人傻缺动态图、美女gif动态图、搞笑动物gif图片、体育gif动态图片！">
	   </c:when>  
	   <c:otherwise>
	<title>【天天GIF】${curr.title}</title>
	<meta name="keywords" content="${curr.keywords },搞笑图片,搞笑qq图片,gif,动态图片,搞笑动态图片,gif动态图片,搞笑动态图片,笑死人,搞笑gif">
	<meta name="description" content="${curr.title }天天GIF(www.cgcgx.com)提供各种搞笑动态图片、恶搞gif动态图、雷人傻缺动态图、美女gif动态图、搞笑动物gif图片、体育gif动态图片！">
	   </c:otherwise>  
	</c:choose> 
    <link rel="icon" type="image/png" href="${pageContext.request.contextPath }/img/favicon.png" sizes="48x48" />
	<link rel="bookmark" type="image/x-icon" href="${pageContext.request.contextPath }/img/favicon.ico" />
	<link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath }/img/favicon.ico"/>
    <link href="${pageContext.request.contextPath }/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath }/css/common.css" rel="stylesheet">
  </head>
  <body>
<div class="g-sc">
<header class="navbar navbar-static-top" id="top">
  <div class="container" id="navbar-container">
    <div class="navbar-header">
      <button class="navbar-toggle collapsed" type="button" data-toggle="collapse" data-target="#bs-navbar" aria-controls="bs-navbar" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a href="${pageContext.request.contextPath }"><img src="${pageContext.request.contextPath }/img/logo.png" class="navbar-brand" alt="logo"></a>
    </div>
    <div class="collapse navbar-collapse" id="bs-navbar">
      <ul class="nav navbar-nav">
        <li class="active <c:if test="${pathtag != 'hot/'}">g-active</c:if>">
          <a href="${pageContext.request.contextPath }">推荐</a>
        </li>
        <li class="active <c:if test="${pathtag == 'hot/'}">g-active</c:if>"> 
          <a href="${pageContext.request.contextPath }/hot.html">热门</a>
        </li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li>
          <img src="${pageContext.request.contextPath }/img/logox.png" class="navbar-brand" alt="logo">
        </li>
      </ul>
    </div>
  </div>
</header>

<div class="g-sc-2 row">
  <div class="col-xs-24 col-sm-4 col-md-4 col-lg-4 hidden-xs imgload1" style="background:#fff;">
    <h5 class="text-muted l-title"><span class="glyphicon glyphicon-heart"></span>大家都在看</h5>
    <hr>
	<c:forEach items="${list_love}" var="val">
      <div class="l-box-item">
	      <a href="${val.id }.htm">
	      <img src="/upload/gif${val.headPath }" class="img-responsive" alt="${val.title }">
	      <div class="l-box-item-bg"></div>
	      <div class="l-box-item-bg-2"><p>${val.title }</p></div>
	      </a>
	    </div>
    </c:forEach>
  </div>

  <div class="col-xs-24 col-sm-14 col-md-14 col-lg-14">
    <h4 class="text-muted c-title"><span class="glyphicon glyphicon-picture"></span>
    ${curr.title}
    </h4>
    <hr>

    <div class="c-box">

      <div id="myCarousel" class="carousel slide">
          <div class="carousel-inner">
              <div class="item active imgload">
                  <img src="/upload/gif${curr.picPath}" class="img-responsive center-block" alt="${curr.title}" style="max-height:360px;min-height:320px;">
              </div>
          </div>
          <c:if test="${pre!=null}">
          	<a class="carousel-control left" href="${pageContext.request.contextPath }/${pathtag}${pre.id}.htm" data-slide="prev">
	            <span class="glyphicon glyphicon-arrow-left"></span>
	        </a>
          </c:if>
          <c:if test="${next!=null}">
          	<a class="carousel-control right" href="${pageContext.request.contextPath }/${pathtag}${next.id}.htm" data-slide="next">
	            <span class="glyphicon glyphicon-arrow-right"></span>
	         </a>
          </c:if>
      </div>
      <div class="g-con-exp">
        <a href="${tag.namePy}.html"><span class="glyphicon glyphicon-bookmark"></span><small> ${tag.name}</small></a>
        <span class="pull-right"><span class="glyphicon glyphicon-time"></span><small> <fmt:formatDate value="${curr.cDate}" pattern="yyyy-MM-dd"/></small></span>
      </div>
      <hr>
      <div class="g-con-share">
        <span class="g-con-share-heart <c:if test="${curr.meLove}">g-con-share-heart-love</c:if>" data-id="${curr.id}">
          <span class="glyphicon glyphicon-heart-empty"></span> 喜欢  &nbsp;|&nbsp; <span class="loveNum">${curr.loveNum}</span>
        </span>
        <div class="bdsharebuttonbox pull-right"><a href="#" class="bds_more" data-cmd="more"></a><a href="#" class="bds_weixin" data-cmd="weixin" title="分享到微信"></a><a href="#" class="bds_qzone" data-cmd="qzone" title="分享到QQ空间"></a><a href="#" class="bds_tsina" data-cmd="tsina" title="分享到新浪微博"></a></div>
      </div>

    <hr>


    <div class="row g-con-pinglun">
      <textarea class="col-xs-24" id="ta_pinglun" data-id="${curr.id}" rows="3" placeholder="写下您的评论..."></textarea> 
      <label>IP:${ip}</label>
      <button type="button" class="btn btn-warning pull-right g-btn-pinglun">发表</button>
    </div>

    <div class="g-con-pinglun-con">
      <h4><span class="commentNum">0</span>条评论</h4>
      <hr>
	  <div id="commets">
	  	<c:forEach items="${comments}" var="val">
	      <div>
	        <p><strong>${val.xip }</strong>&nbsp;&nbsp;&nbsp;<small class="text-muted">${val.floor }楼 · <fmt:formatDate value="${val.cDate}" pattern="yyyy.MM.dd HH:mm"/></small></p>
	        <p>${val.content }</p>
	        <div class="text-right g-con-pinglun-con-zan <c:if test="${val.meLove}">g-con-pinglun-con-zan-love</c:if>" data-id="${val.id }"><span class="glyphicon glyphicon-thumbs-up"></span> <span class="commentloveNum">${val.loveNum }</span>人赞</div>
	        <hr>
	      </div>
	    </c:forEach>
	  </div>
	  <c:if test="${more}"><span class="g-label"><div class="g-label-bg">更多评论</div></span></c:if>
    </div>
    


    </div>
    

  </div>

  
  <div class="col-xs-24 col-sm-6 col-md-6 col-lg-6 hidden-xs">

    <img src="${pageContext.request.contextPath }/img/gzh.png" class="img-responsive">
    <br>
    <strong class="text-muted">热门标签</strong>
    <hr>
    <div>
    <c:forEach items="${list_tag}" var="val">
      <a href="${pageContext.request.contextPath }/${val.namePy}.html" class="label label-default">${val.name}</a>
    </c:forEach>
    </div>

    <br>
    <strong class="text-muted">相关推荐</strong>
    <hr>
    <div class="row imgload1">

      <div class="col-sm-12">
		<c:forEach items="${list_tuijian1}" var="val">
	      <div class="r-box-item g-hot-con">
	          <img src="/upload/gif${val.headPath }" class="img-responsive" alt="${val.title }">
	          <div class="dot-ellipsis dot-resize-update dot-height-40">
	            <p class="wrapper2"><small><a href="${pageContext.request.contextPath }/${val.id }.htm" >${val.title }</a></small></p>
	          </div>
	        </div>
	    </c:forEach>
      </div>

      <div class="col-sm-12">
		<c:forEach items="${list_tuijian2}" var="val">
	      <div class="r-box-item g-hot-con">
	          <img src="/upload/gif${val.headPath }" class="img-responsive" alt="${val.title }">
	          <div class="dot-ellipsis dot-resize-update dot-height-40">
	            <p class="wrapper2"><small><a href="${pageContext.request.contextPath }/${val.id }.htm">${val.title }</a></small></p>
	          </div>
	        </div>
	    </c:forEach>
      </div>

    </div>

  </div>
</div>

<hr>
<div class="col-sm-24 g-foot">
  <p class="text-center"><small>友情链接： <a href="http://www.tutiaoba.com/" target="_blank">程序员网</a></small></p>
  <p class="text-center"><small>© 2017 (<a href="http://www.cgcgx.com/">www.cgcgx.com</a>) 天天GIF 版权所有 <a href="http://www.miitbeian.gov.cn/" target="_blank">豫ICP备17017459号</a></small></p>
</div>

</div>


  <script src="${pageContext.request.contextPath }/js/jquery.min.js"></script>
  <script src="${pageContext.request.contextPath }/js/bootstrap.min.js"></script>
  <script src="${pageContext.request.contextPath }/js/jquery.dotdotdot.min.js"></script>
  <script src="${pageContext.request.contextPath }/js/common.js"></script>
  <script src="${pageContext.request.contextPath }/js/imgloading.js"></script>
  <script type="text/javascript">
      $(document).ready(function() {
    	  $(".imgload").ImgLoading({
	    		  errorimg: "${pageContext.request.contextPath }/img/loading.gif",
	    		  loadimg: "${pageContext.request.contextPath }/img/loading.gif",
              timeout: 100
              });
      });
  </script>
  <script>window._bd_share_config={"common":{"bdSnsKey":{},"bdText":"","bdMini":"2","bdMiniList":false,"bdPic":"","bdStyle":"0","bdSize":"32"},"share":{}};with(document)0[(getElementsByTagName('head')[0]||body).appendChild(createElement('script')).src='http://bdimg.share.baidu.com/static/api/js/share.js?v=89860593.js?cdnversion='+~(-new Date()/36e5)];</script>
  
  </body>
</html>