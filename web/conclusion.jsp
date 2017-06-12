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
            <a href="#" class="brand-logo">Conclusion</a>
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
          <div class="card blue-grey darken-1">
            <div class="card-content white-text">
              <span class="card-title">结论</span>
              <p class="flow-text">冷启动项目推荐具有挑战性，并且仍是推荐系统中开放性的研究问题。冷启动项目可以分类为完全冷启动项目即没有收到过评价和不完全冷启动项目即收到过非常少的评价。在这片论文中，我们仅仅使用冷启动推荐模型来处理完全冷启动问题。冷启动项目推荐模型将协同过滤模型矩阵因子分解MF和深度学习框架SDAE结合到一起。深度学习神经网络负责项目内容特征的提取，而协同过滤模型负责未知评价的预测。 我们在movie lens数据集上进行了实验并根据推荐预测均方根误差评估使用的模型。结果表明，这种模型在冷启动项目推荐上要优于现存的基准方法。尤其是对于冷启动问题，冷启动推荐模型可以成功的吸取协同过滤潜在因子模型的优点，获得显著的性能改善。</p>
            </div>
            <div class="card-action">
              <a href="#">这是一个链接</a>
              <a href="#">这是一个链接</a>
            </div>
          </div>
        </div>
        <div class="col s12 m6">
          <div class="card blue-grey darken-1">
            <div class="card-content white-text">
              <span class="card-title">展望</span>
              <p class="flow-text">我们计划扩展冷启动项目推荐模型并在下面的研究方向做工作。首先，由于实验环境限制，论文中实验的数据规模较小，希望能够对算法的性能进行改进，在大规模数据下进行实验，才更有说服力；除此之外，我们对有更多系统配置和参数设置下的冷启动项目推荐性能的研究很感兴趣，这是为了进一步揭示它们对于推荐性能和系统优化的影响。其次，我们对针对非完全冷启动项目推荐模型也非常感兴趣。我们计划实现一个推荐模型，可以应用于完全和非完全冷启动项目两者的推荐。第三，推荐模型通过预测评价的均方根误差进行评估，这并不能有效的反映真实推荐系统的性能。我们对另一种性能评估方式很感兴趣，可以将项目推荐决策考虑在内，并量化决策对用户推荐项目接受程度的影响。最后，在这篇论文中，我们在movie lens电影上进行冷启动项目推荐实验。我们对将模型应用于其他产品（例如在线音乐）的推荐十分感兴趣。</p>
            </div>
            <div class="card-action">
              <a href="#">这是一个链接</a>
              <a href="#">这是一个链接</a>
            </div>
          </div>
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

  </body>
</html>
