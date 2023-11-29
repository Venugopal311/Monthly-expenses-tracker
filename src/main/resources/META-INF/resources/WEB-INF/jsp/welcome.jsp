

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>

<head>
<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet" >
<title> welcome </title>
</head>


<body>
    <%@ include file="common/navigation.jspf" %>
    <div class="container"
                <h1> Welcome ${name}</h1>
                <br>
                <img src="https://media.licdn.com/dms/image/D5612AQGplp7JKG6Iiw/article-cover_image-shrink_720_1280/0/1673950361361?e=2147483647&v=beta&t=NxzErCoXqQ-xwkHJZZkKGKYNA21hJh3oNMUJzNKQr9M" />
                <%-- these are called comments  <div> <a href="/goto-expense"  > Click here </a> To manage  your expenses </div> --%>

                   <%--   <div> <a href="/goto-budget"  > Click here </a> To Set  your budget </div> --%>
                    <script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
                      <script src="webjars/jquery/3.6.0/jquery.min.js"></script>
    </div>


</body>




</html>