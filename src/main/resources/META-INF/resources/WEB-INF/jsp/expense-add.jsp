<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet" >
<link href="webjars\bootstrap-datepicker\1.9.0\css\bootstrap-datepicker3.standalone.min.css" rel="stylesheet">
<title> To add Expense </title>
</head>


<body>
<%@ include file="common/navigation.jspf" %>
    <div class="container"
      <h1> Please enter details </h1>
        <form:form method="post" modelAttribute="item">
            <fieldSet>
               Item : <form:input type="text" path="name"  required="required"/>
                 <form:errors path="name" cssClass="text-warning"/>
            </fieldSet>
            <br>
            <fieldSet>
                Price :<form:input type="number"  path="price" />
                <form:errors path="price" cssClass="text-warning"/>
             </fieldSet>
             <br>
             <fieldSet>
               Date :<form:input type="text" path="localDate"/>
              </fieldSet>
            <br>
              <fieldSet>
              Quantity :<form:input type="number"  path="quantity" />
               <form:errors path="quantity" cssClass="text-warning"/>
               </fieldSet>
               <br>
              <form:input type="hidden" path="username"/>
                <form:input type="hidden"  path="serialNo"/>

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