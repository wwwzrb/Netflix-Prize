<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html >
<head>
  <title>movie</title>

  <!-- CSS  -->
  <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
  <link href="css/materialize.css" type="text/css" rel="stylesheet" media="screen,projection"/>
</head>
<body>
<s:set name="movie" value="#session['movie']"/>
   <header>
      <nav class="nav-extended">
        <div class="nav-wrapper">
            <a href="#" class="brand-logo">Movie details</a>
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
       <div class="nav-content">
          <ul class="tabs tabs-transparent">
             <li class="tab"><a class="active" href="#test1">Rating</a></li>
             <li class="tab"><a href="#test2">ToU</a></li>
             <li class="tab"><a href="#test3">ToA</a></li>
             <li class="tab"><a class="disabled" href="#test4">Test 4</a></li>
         </ul>
       </div>
      </nav>
   </header>



<main>
  


  <div id="test1" class="col s12">
    <div class="container section">
      <div class="row">
        <div class="col s12 m4">
          <div class="card show-on-large hoverable">
            <div class="card-image waves-effect waves-block waves-light">
              <img class="activator" src="<s:property value="#movie.poster"/>">
            </div>
            <div class="card-content">
                <span class="card-title activator grey-text text-darken-4"><a href="getMovie.action?movieId=<s:property value="#movie.movieId"/>"><s:property value="#movie.title"/></a><i class="material-icons right">more_vert</i></span>
               <div class="divider"></div>
              <p><a href="#"></a><s:property value="#movie.genre"/></p>
            </div>
            <div class="card-reveal">
                <span class="card-title grey-text text-darken-4"><s:property value="#movie.title"/><i class="material-icons right">close</i></span>
                <ul class="collection">
                    <li class="collection-item">
                        <blockquote>
                            Released:
                            <span class="blu-text"><s:property value="#movie.released"/></span>
                        </blockquote>
                    </li>
                    <li class="collection-item">
                        <blockquote>
                            Director:
                            <span class="blu-text"><s:property value="#movie.director"/></span>
                        </blockquote>
                    </li>
                    <li class="collection-item">
                        <blockquote>
                            Actors:
                            <span class="blu-text"><s:property value="#movie.actors"/></span>
                        </blockquote>
                    </li>
                    <li class="collection-item">
                        <blockquote>
                            imdbRating:
                            <span class="blu-text"><s:property value="#movie.imdbRating"/></span>
                        </blockquote>
                    </li>
                    <li class="collection-item">
                        <blockquote>
                            imdbVotes:
                            <span class="blu-text"><s:property value="#movie.imdbVotes"/></span>
                        </blockquote>
                    </li>
                    <li class="collection-item">
                        <blockquote>
                            imdbLink:
                            <span class="blu-text"><a href="http://www.imdb.com/title/<s:property value="#movie.imdbId"/>">http://www.imdb.com/title/<s:property value="#movie.imdbId"/></a></span>
                        </blockquote>
                    </li>
                </ul>
            </div>
          </div>
        </div>

        <div class="col s12 m1">
        </div>

        <div class="col s12 m7">
          <table class="bordered highlight centered responsive-table">
          <thead>
          <tr>
              <th data-field="id">UserID</th>
              <th data-field="name">RealRating</th>
              <th data-field="price">ToURating</th>
               <th data-field="price">ToU&CFRating</th>
          </tr>
          </thead>

          <tbody>
          <s:iterator value="#movie.ratingModelList" id="rating">
          <tr>
            <td><s:property value="#rating.userId"/></td>
            <td><s:property value="#rating.rating"/></td>
            <td><s:property value="#rating.toU"/></td>
            <td><s:property value="#rating.toUcf"/></td>
          </tr>
          </s:iterator>
          </tbody>
          </table>
        </div>
      </div>

    </div>
  </div>


   <div id="test2" class="col s12">
       <div class="container section">
           <div class="row">
               <div class="col s12 m3">
                   <div class="card show-on-large hoverable">
                       <div class="card-image waves-effect waves-block waves-light">
                           <img class="activator" src="<s:property value="#movie.poster"/>">
                       </div>
                       <div class="card-content">
                           <span class="card-title activator grey-text text-darken-4"><a href="getMovie.action?movieId=<s:property value="#movie.movieId"/>"><s:property value="#movie.title"/></a><i class="material-icons right">more_vert</i></span>
                           <div class="divider"></div>
                           <p><a href="#"></a><s:property value="#movie.genre"/></p>
                       </div>
                       <div class="card-reveal">
                           <span class="card-title grey-text text-darken-4"><s:property value="#movie.title"/><i class="material-icons right">close</i></span>
                           <ul class="collection">
                               <li class="collection-item">
                                   <blockquote>
                                       Released:
                                       <span class="blu-text"><s:property value="#movie.released"/></span>
                                   </blockquote>
                               </li>
                               <li class="collection-item">
                                   <blockquote>
                                       Director:
                                       <span class="blu-text"><s:property value="#movie.director"/></span>
                                   </blockquote>
                               </li>
                               <li class="collection-item">
                                   <blockquote>
                                       Actors:
                                       <span class="blu-text"><s:property value="#movie.actors"/></span>
                                   </blockquote>
                               </li>
                               <li class="collection-item">
                                   <blockquote>
                                       imdbRating:
                                       <span class="blu-text"><s:property value="#movie.imdbRating"/></span>
                                   </blockquote>
                               </li>
                               <li class="collection-item">
                                   <blockquote>
                                       imdbVotes:
                                       <span class="blu-text"><s:property value="#movie.imdbVotes"/></span>
                                   </blockquote>
                               </li>
                               <li class="collection-item">
                                   <blockquote>
                                       imdbLink:
                                       <span class="blu-text"><a href="http://www.imdb.com/title/<s:property value="#movie.imdbId"/>">http://www.imdb.com/title/<s:property value="#movie.imdbId"/></a></span>
                                   </blockquote>
                               </li>
                           </ul>
                       </div>
                   </div>
               </div>

               <s:iterator value="#movie.similarModelList" id="similarModel">
               <s:iterator value="#similarModel.similarList" id="briefModel">
               <div class="col s12 m3">
                   <div class="card small hoverable">
                       <div class="card-image waves-effect waves-block waves-light">
                           <img class="activator" src="<s:property value="#briefModel.poster"/>">
                       </div>
                       <div class="card-content">
                           <span class="card-title activator grey-text text-darken-4"><a href="getMovie.action?movieId=<s:property value="#briefModel.movieId"/>"><s:property value="#briefModel.title"/></a><i class="material-icons right">more_vert</i></span>
                       </div>
                       <div class="action">
                           <a href="#"><s:property value="#briefModel.genre"/></a>
                           <a href="#">来自用户<s:property value="#similarModel.userId"/></a>
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
                           </ul>
                       </div>
                   </div>
               </div>
               </s:iterator>
               </s:iterator>

           </div>

       </div>
   </div>
   <div id="test3" class="col s12">
       <div class="container section">
           <div class="row">
               <div class="col s12 m3">
                   <div class="card show-on-large hoverable">
                       <div class="card-image waves-effect waves-block waves-light">
                           <img class="activator" src="<s:property value="#movie.poster"/>">
                       </div>
                       <div class="card-content">
                           <span class="card-title activator grey-text text-darken-4"><a href="getMovie.action?movieId=<s:property value="#movie.movieId"/>"><s:property value="#movie.title"/></a><i class="material-icons right">more_vert</i></span>
                           <div class="divider"></div>
                           <p><a href="#"></a><s:property value="#movie.genre"/></p>
                       </div>
                       <div class="card-reveal">
                           <span class="card-title grey-text text-darken-4"><s:property value="#movie.title"/><i class="material-icons right">close</i></span>
                           <ul class="collection">
                               <li class="collection-item">
                                   <blockquote>
                                       Released:
                                       <span class="blu-text"><s:property value="#movie.released"/></span>
                                   </blockquote>
                               </li>
                               <li class="collection-item">
                                   <blockquote>
                                       Director:
                                       <span class="blu-text"><s:property value="#movie.director"/></span>
                                   </blockquote>
                               </li>
                               <li class="collection-item">
                                   <blockquote>
                                       Actors:
                                       <span class="blu-text"><s:property value="#movie.actors"/></span>
                                   </blockquote>
                               </li>
                               <li class="collection-item">
                                   <blockquote>
                                       imdbRating:
                                       <span class="blu-text"><s:property value="#movie.imdbRating"/></span>
                                   </blockquote>
                               </li>
                               <li class="collection-item">
                                   <blockquote>
                                       imdbVotes:
                                       <span class="blu-text"><s:property value="#movie.imdbVotes"/></span>
                                   </blockquote>
                               </li>
                               <li class="collection-item">
                                   <blockquote>
                                       imdbLink:
                                       <span class="blu-text"><a href="http://www.imdb.com/title/<s:property value="#movie.imdbId"/>">http://www.imdb.com/title/<s:property value="#movie.imdbId"/></a></span>
                                   </blockquote>
                               </li>
                           </ul>
                       </div>
                   </div>
               </div>

               <s:iterator value="#movie.briefModelList" id="briefModel">
               <div class="col s12 m3">
                           <div class="card small hoverable">
                               <div class="card-image waves-effect waves-block waves-light">
                                   <img class="activator" src="<s:property value="#briefModel.poster"/>">
                               </div>
                               <div class="card-content">
                                   <span class="card-title activator grey-text text-darken-4"><a href="getMovie.action?movieId=<s:property value="#briefModel.movieId"/>"><s:property value="#briefModel.title"/></a><i class="material-icons right">more_vert</i></span>
                               </div>
                               <div class="action">
                                   <a href="#"><s:property value="#briefModel.genre"/></a>
                                   <a href="#">来自用户?</a>
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
                                   </ul>
                               </div>
                           </div>
               </div>
               </s:iterator>

           </div>

       </div>
   </div>
   <div id="test4" class="col s12">

   </div>



  
  <div class="container section">

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
  <script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
  <script src="js/materialize.js"></script>
  <script>
  $( document ).ready(function(){
    $(".button-collapse").sideNav();
  })
  </script>

  </body>
</html>
