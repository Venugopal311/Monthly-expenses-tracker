<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<html>

<head>
<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet" >
<title> Budget page </title>
</head>


<body>
<%@ include file="common/navigation.jspf" %>
    <div class="container"
      <h1> Welcome</h1>

            <form method="post">
                      <div> Enter  the budget you want to continue with</div>
                      <p>${errormessage} </p>
                        Budget:<input type="number" min="1" name="budget" required="required"/>

                        <input type="submit" class="btn btn-success"/>

                         <input type="hidden" name="${_csrf.parameterName}"
                            value="${_csrf.token}"/>
                        </form>
                        <script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
                      <script src="webjars/jquery/3.6.0/jquery.min.js"></script>
    </div>


</body>




</html>