<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Starter Template - Materialize</title>

  <!-- CSS  -->
  <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
  <link href="css/materialize.css" type="text/css" rel="stylesheet" media="screen,projection"/>
</head>
<body>
<s:action name="getBriefList" namespace="/"/>
   <header>
      <nav class="nav-extended">
        <div class="nav-wrapper">
            <a href="#" class="brand-logo">DF&CF based recommendation</a>
            <a href="#" data-activates="mobile-demo" class="button-collapse"><i class="material-icons">menu</i></a>
            <ul id="nav-mobile" class="right hide-on-med-and-down">
                <li><a href="index.jsp">movies</a></li>
                <li><a href="cluster.jsp">clusters</a></li>
                <li><a href="analysis.jsp">analysis</a></li>
                <li><a href="conclusion.jsp">conclusion</a></li>
           </ul>
           <ul class="side-nav" id="mobile-demo">
               <li><a href="index.jsp">movies</a></li>
               <li><a href="cluster.jsp">clusters</a></li>
               <li><a href="analysis.jsp">analysis</a></li>
               <li><a href="conclusion.jsp">conclusion</a></li>
           </ul>
       </div>
      </nav>
   </header>



<main>
  
  
  <div class="container section">
    <div class="row">
        <s:iterator value="#session['briefList']" id="briefModel">
        <div class="col s12 m3">
          <div class="card show-on-large hoverable">
            <div class="card-image waves-effect waves-block waves-light">
              <img class="activator" src="<s:property value="#briefModel.poster"/>">
            </div>
            <div class="card-content">
                <span class="card-title activator grey-text text-darken-4"><a href="getMovie.action?movieId=<s:property value="#briefModel.movieId"/>"><s:property value="#briefModel.title"/></a><i class="material-icons right">more_vert</i></span>
               <div class="divider"></div>
              <p><s:property value="#briefModel.shortPlot"/></p>
            </div>
            <div class="card-reveal">
              <span class="card-title grey-text text-darken-4"><s:property value="#briefModel.title"/><i class="material-icons right">close</i></span>
              <ul class="collection">
                  <li class="collection-item">
                    <blockquote>
                      Released:
                      <span class="blu-text"><s:property value="#briefModel.released"/></span>
                    </blockquote>
                  </li>
                  <li class="collection-item">
                    <blockquote>
                      Director:
                      <span class="blu-text"><s:property value="#briefModel.director"/></span>
                    </blockquote>
                  </li>
                  <li class="collection-item">
                    <blockquote>
                      Actors:
                      <span class="blu-text"><s:property value="#briefModel.actors"/></span>
                    </blockquote>
                  </li>
                  <li class="collection-item">
                    <blockquote>
                      Genre:
                      <span class="blu-text"><s:property value="#briefModel.genre"/></span>
                    </blockquote>
                  </li>
              </ul>
            </div>
          </div>
        </div>
        </s:iterator>
    </div>

    <div class="row fixed">
        <ul class="pagination">
            <s:set name="page" value="#session['page']"/>
            <s:if test="#page.hasPre">
                <li class="waves-effect"><a href="getBriefList.action?pageNow=<s:property value="#page.pageNow-1"/>"><i class="material-icons">chevron_left</i></a></li>
            </s:if>
            <s:else>
                <li class="disabled"><a href="#!"><i class="material-icons">chevron_left</i></a></li>
            </s:else>

            <s:iterator value="#session['nums']" id="num">
                <s:if test="#num.now">
                    <li class="active"><a href="#!"><s:property value="#num.number"/></a></li>
                </s:if>
                <s:else>
                    <li class="waves-effect"><a href="getBriefList.action?pageNow=<s:property value="#num.number"/>"><s:property value="#num.number"/></a></li>
                </s:else>
            </s:iterator>


            <s:if test="#page.hasNext">
                <li class="waves-effect"><a href="getBriefList.action?pageNow=<s:property value="#page.pageNow+1"/>"><i class="material-icons">chevron_right</i></a></li>
            </s:if>
            <s:else>
                <li class="disabled"><a href="#!"><i class="material-icons">chevron_right</i></a></li>
            </s:else>
        </ul>

    </div>

 </div>



</main>

<footer class="page-footer">
    <div class="container">
        <div class="row">
            <div class="col l6 s12">
                <h5 class="white-text">基于深度学习和协同过滤的冷启动项目推荐</h5>
                <p class="grey-text text-lighten-4">关键词：深度学习、协同过滤、冷启动项目、推荐</p>
            </div>
            <div class="col l4 offset-l2 s12">
                <h5 class="white-text">相关引用</h5>
                <ul>
                    <li><a class="grey-text text-lighten-3" href="#!">链接 1</a></li>
                    <li><a class="grey-text text-lighten-3" href="#!">链接 2</a></li>
                    <li><a class="grey-text text-lighten-3" href="#!">链接 3</a></li>
                    <li><a class="grey-text text-lighten-3" href="#!">链接 4</a></li>
                </ul>
            </div>
        </div>
    </div>
    <div class="footer-copyright">
        <div class="container">
            © 2017 Copyright 文本
            <a class="grey-text text-lighten-4 right" href="#!">更多链接</a>
        </div>
    </div>
</footer>


  



  <!--  Scripts-->
  <script src="js/jquery-2.2.3.min.js"></script>
  <script src="js/materialize.js"></script>
  <script>
  $( document ).ready(function(){
    $(".button-collapse").sideNav();
  })
  </script>

  </body>
</html>
