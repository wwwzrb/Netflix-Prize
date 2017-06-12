<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <!-- CSS  -->
  <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
  <link href="css/materialize.css" type="text/css" rel="stylesheet" media="screen,projection"/>
</head>
<body>
   <header>
      <nav class="nav-extended">
        <div class="nav-wrapper">
            <a href="#" class="brand-logo">Clusters</a>
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
        <div class="col s12 m4">
           <canvas id="myChart" width="400" height="400"></canvas>
        </div>
        <div class="col s12 m8">
          <iframe src="out.html" width="1100" height="600"></iframe>
        </div>
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
  <script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
  <script src="js/materialize.js"></script>
  <script src="js/Chart.js"></script>
  <script src="js/cluster.js"></script>

  </body>
</html>
