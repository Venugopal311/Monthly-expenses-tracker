<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<html>

<head>
  <link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet" >
<title> login </title>

</head>

<body>
    <div class="container">
     <pre> ${errorMessage} </pre>
        <h1> Welcome to Login Page!</h1>
        <hr>
        <form method="post">
        Name : <input type="text" name="name"  required="required"/>
        Password: <input type="password"  name="password" required="required"/>
        <input type="submit" value="login" class="btn btn-success"/>
        </form
         <script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
                    <script src="webjars/jquery/3.6.0/jquery.min.js"></script>
    </div>

</body>



</html>