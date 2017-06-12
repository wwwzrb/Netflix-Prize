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
            <a href="#" class="brand-logo">Analysis</a>
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
        <div class="col s12 m6">
          <table class="bordered highlight centered responsive-table">
          <thead>
          <tr>
              <th data-field="id">RMSE of dl</th>
              <th data-field="name">ToU</th>
              <th data-field="name"></th>
              <th data-field="price">ToU&CF</th>
          </tr>
          </thead>
          <tbody>
          <tr>
            <td>100</td>
            <td>1.18504650713</td>
            <td><</td>
            <td>1.2657302114</td>
          </tr>
          <tr>
            <td>150</td>
            <td>1.08537819021</td>
            <td>></td>
            <td>1.05107371199</td>
            
          </tr>
          <tr>
            <td>200</td>
            <td>1.07296291722</td>
            <td>></td>
            <td>1.01662343745</td>
          </tr>
          </tbody>
          </table>
        </div>
        <div class="col s12 m6">
          <table class="bordered highlight centered responsive-table">
          <thead>
          <tr>
              <th data-field="id">RMSE no dl</th>
              <th data-field="name">ToU</th>
              <th data-field="name"></th>
              <th data-field="price">ToU&CF</th>
          </tr>
          </thead>
          <tbody>
          <tr>
            <td>100</td>
            <td>1.18147422556</td>
            <td><</td>
            <td>1.29104647521</td>
          </tr>
          <tr>
            <td>150</td>
            <td>1.09317767542</td>
            <td><</td>
            <td>1.17489911066</td>
          </tr>
          <tr>
            <td>200</td>
            <td>1.08754717401</td>
            <td><</td>
            <td>1.163381902</td>
          </tr>
          </tbody>
          </table>
        </div>
      </div>
            <div class="row">
        <div class="col s12 m6">
          <table class="bordered highlight centered responsive-table">
          <thead>
          <tr>
              <th data-field="id">RMSE of ToU&CF</th>
              <th data-field="name">with dl</th>
              <th data-field="name"></th>
              <th data-field="price">without dl</th>
          </tr>
          </thead>
          <tbody>
          <tr>
            <td>100</td>
            <td>1.2657302114</td>
            <td><</td>
            <td>1.29104647521</td>
          </tr>
          <tr>
            <td>150</td>
            <td>1.05107371199</td>
            <td><</td>
            <td>1.17489911066</td>
          </tr>
          <tr>
            <td>200</td>
            <td>1.01662343745</td>
            <td><</td>
            <td>1.163381902</td>
          </tr>
          </tbody>
          </table>
        </div>
        <div class="col s12 m6">
          <table class="bordered highlight centered responsive-table">
          <thead>
          <tr>
              <th data-field="id">RMSE of ToU</th>
              <th data-field="name">with dl</th>
              <th data-field="name"></th>
              <th data-field="price">without dl</th>
          </tr>
          </thead>
          <tbody>
          <tr>
            <td>100</td>
            <td>1.18504650713</td>
            <td>≈</td>
            <td>1.18147422556</td>
          </tr>
          <tr>
            <td>150</td>
            <td>1.08537819021</td>
            <td>≈</td>
            <td>1.09317767542</td>
          </tr>
          <tr>
            <td>200</td>
            <td>1.07296291722</td>
            <td>≈</td>
            <td>1.08754717401</td>
          </tr>
          </tbody>
          </table>
        </div>
      </div>

    </div>
    <div>
        <canvas height="140"></canvas>
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
  <script src="js/Chart.js"></script>

  </body>
</html>
