$( document ).ready(function(){
    $(".button-collapse").sideNav();
    var ctx = document.getElementById("myChart").getContext("2d");
    var data = {
    labels: ["1", "2", "3", "4", "5"],
    datasets: [
        {
            label: "Clusters",
            backgroundColor: "rgba(255,99,132,0.2)",
            borderColor: "rgba(255,99,132,1)",
            pointBackgroundColor: "rgba(255,99,132,1)",
            pointBorderColor: "#fff",
            pointHoverBackgroundColor: "#fff",
            pointHoverBorderColor: "rgba(255,99,132,1)",
            data: [37, 107, 16, 19, 21]
        }
    ]
    };
    var myNewChart = new Chart(ctx, {
    type: "radar",
    data: data,
    options: {
            scale: {
                ticks: {
                    min: 10,
                    max: 110
                }
            }
    }
    });
  })
