<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet" >
<link href="webjars\bootstrap-datepicker\1.9.0\css\bootstrap-datepicker3.standalone.min.css" rel="stylesheet">
<title> To Filter By Date </title>
</head>


<body>
<%@ include file="common/navigation.jspf" %>
    <div class="container"
      <h1> Please enter Date </h1>
        <form:form method="post" modelAttribute="item">
        <br>
             <fieldSet>
               Date :<form:input type="text" path="localDate"/>
               <form:errors path="localDate" cssClass="text-warning"/>

              </fieldSet>
        <br>

              <form:input type="hidden" path="username"/>
                <form:input type="hidden"  path="serialNo"/>
                <form:input type="hidden" path="name" />
                <form:input type="hidden"  path="price" />
                <form:input type="hidden"  path="quantity" />
          <input type="submit" class="btn btn-success"/>
        </form:form>
                <script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
                <script src="webjars/jquery/3.6.0/jquery.min.js"></script>
                <script src="webjars\bootstrap-datepicker\1.9.0\js\bootstrap-datepicker.min.js"></script>
                <script type="text/javascript">
                $('#localDate').datepicker({
                format:'yyyy-mm-dd'
                });
                </script>

    </div>


</body>




</html>