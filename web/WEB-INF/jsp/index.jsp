<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="<c:url value="/resources/js/jquery-2.1.1.min.js" />"  type="text/javascript"></script> 
        <link href="<c:url value="/resources/css/bootstrap-3.2.0/bootstrap.min.css" />" rel="stylesheet" media="screen">
        <script src="<c:url value="/resources/js/d3.min.js" />" ></script>
        <style>

            body {
              background: #000;
            }

            ellipse {
              fill: #fff;
            }

            path {
              fill: none;
              stroke: #fff;
              stroke-linecap: round;
            }

            .mid {
              stroke-width: 4px;
            }

            .tail {
              stroke-width: 2px;
            }

</style>

        <title>ITO-REST</title>
    </head>

    <body>
         <nav class="navbar navbar-default" role="navigation">
        <div>
            <ul class="nav navbar-nav">
                <li class="active"><a>Principal</a></li>
                <li><a href="/cliente/grafica.html">Cliente</a></li>
                <li><a href="/doc/documentacion">Documentacion</a></li>
                
            </ul>
        </div>
    </nav>
        
        <div class="container">
            <script>

                var width = 1450,
                    height = 600;

                var n = 100,
                    m = 12,
                    degrees = 180 / Math.PI;

                var spermatozoa = d3.range(n).map(function() {
                  var x = Math.random() * width,
                      y = Math.random() * height;
                  return {
                    vx: Math.random() * 2 - 1,
                    vy: Math.random() * 2 - 1,
                    path: d3.range(m).map(function() { return [x, y]; }),
                    count: 0
                  };
                });

                var svg = d3.select("body").append("svg")
                    .attr("width", width)
                    .attr("height", height);

                var g = svg.selectAll("g")
                    .data(spermatozoa)
                  .enter().append("g");

                var head = g.append("ellipse")
                    .attr("rx", 6.5)
                    .attr("ry", 4);

                g.append("path")
                    .datum(function(d) { return d.path.slice(0, 3); })
                    .attr("class", "mid");

                g.append("path")
                    .datum(function(d) { return d.path; })
                    .attr("class", "tail");

                var tail = g.selectAll("path");

                d3.timer(function() {
                  for (var i = -1; ++i < n;) {
                    var spermatozoon = spermatozoa[i],
                        path = spermatozoon.path,
                        dx = spermatozoon.vx,
                        dy = spermatozoon.vy,
                        x = path[0][0] += dx,
                        y = path[0][1] += dy,
                        speed = Math.sqrt(dx * dx + dy * dy),
                        count = speed * 10,
                        k1 = -5 - speed / 3;

                    // Bounce off the walls.
                    if (x < 0 || x > width) spermatozoon.vx *= -1;
                    if (y < 0 || y > height) spermatozoon.vy *= -1;

                    // Swim!
                    for (var j = 0; ++j < m;) {
                      var vx = x - path[j][0],
                          vy = y - path[j][1],
                          k2 = Math.sin(((spermatozoon.count += count) + j * 3) / 300) / speed;
                      path[j][0] = (x += dx / speed * k1) - dy * k2;
                      path[j][1] = (y += dy / speed * k1) + dx * k2;
                      speed = Math.sqrt((dx = vx) * dx + (dy = vy) * dy);
                    }
                  }

                  head.attr("transform", headTransform);
                  tail.attr("d", tailPath);
                });

                function headTransform(d) {
                  return "translate(" + d.path[0] + ")rotate(" + Math.atan2(d.vy, d.vx) * degrees + ")";
                }

                function tailPath(d) {
                  return "M" + d.join("L");
                }

</script>
        </div>
        <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
    </body>
</html>
