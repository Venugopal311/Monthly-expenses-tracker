

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>



<head>
  <link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet" >
<title> Expense </title>
</head>
<body>

<%@ include file="common/navigation.jspf" %>

    <div class="container"
    <h1> Welcome To Expense Page ${name}</h1>
    <div> Total :  ${total}</div>
    <p style="color:red;"> ${errorMessage}  </p>
    <hr>

       <table class="table">
           <thead>
           <tr>
               <th> </th>
               <th> Name</th>
               <th> Price</th>
               <th> Quantity</th>
               <th> </th>
               <th> </th>

           </tr>

           </thead>


           <tbody>

           <c:forEach items="${items}" var="item" >
               <tr>
                   <td></td>
                   <td>${item.name}</td>
                   <td>${item.price}</td>
                   <td>${item.quantity}</td>
                   <td> <a href="delete-item?serialNo=${item.serialNo}&price=${item.price}" class="btn btn-warning"> delete</a> </td>
                   <td> <a href="update-item?serialNo=${item.serialNo}" class="btn btn-success"> update</a> </td>

               </tr>
           </c:forEach>
           </tbody>


       </table>
                <script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
             <script src="webjars/jquery/3.6.0/jquery.min.js"></script>

    </div>


</body>




</html>