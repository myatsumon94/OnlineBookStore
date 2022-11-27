<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>User Login Page</title>
         <!-- CDN-->
         <link rel="stylesheet" href="https://cdn.datatables.net/1.12.1/css/dataTables.bootstrap5.min.css">
         <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
       
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="css/styles.css" rel="stylesheet" />
        <link href="css/custom.css" rel="stylesheet" />
    </head>
    
    
    <body>
       
       

   <div class="container">

    <form action="userlogin" method="post">
        <h2 class="text-center">Please Sign In</h2>
        
        <input type="hidden" name="mode" value="SIGNIN">
        
        <c:if test="${loginFail}">
        <div class="mb-3">
         <span class="alert alert-danger">Authorization Fail!</span>
        </div>
        </c:if>
        
        <div class="mb-3">
            <label for="email" class="form-label">Email</label>
            <input type="text" id="email" name="email" placeholder="Enter Your email" class="form-control" autofocus>
        </div>
        
        
       <div class="mb-3">
            <label for="password" class="form-label">Password</label>
            <input type="password" id="password" name="password" placeholder="Enter your password" class="form-control" autofocus>
        </div>
            
     
     <button type="submit" class="badge rounded-pill bg-info text-dark">Verify</button>
     
     
    </form> <!-- /form -->
    <div>
   <a href="user-signup.jsp"> <p> Don't have an account ? Please Signup!</p></a>
   </div>
    
</div>
 <!-- ./container -->


		 <!-- Bootstrap core JS-->
		        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
		        <!-- Core theme JS-->
		        <script src="js/scripts.js"></script>
</body>
</html>