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
        <title>User Register Page</title>
         <!-- CDN-->
         <link rel="stylesheet" href="https://cdn.datatables.net/1.12.1/css/dataTables.bootstrap5.min.css">
         <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
       
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="css/styles.css" rel="stylesheet" />
        <link href="css/custom.css" rel="stylesheet" />
    </head>
    
    
    <body>
   
   <div class="container">

    <form action="user" method="post">
        <h2 class="mb-3 text-center">User Registration</h2>
        
        <input type="hidden" name="mode" value="SIGNUP">
        
        
        <div class="mb-3">
            <label for="name" class="form-label">*Name</label>
            <input type="text" id="name" name="name" placeholder="Enter Your Name" class="form-control" required="required" autofocus>
        </div>
            
        <div class="mb-3">
            <label for="email" class="form-label">*Email</label>
            <input type="text" id="email" name="email" placeholder="Enter Your email" class="form-control" required="required" autofocus>
        </div>
        
         <div class="mb-3">
            <label for="address" class="form-label">*Address</label>
            <input type="text" id="address" name="address" placeholder="Enter Your address" class="form-control" required="required" autofocus>
        </div>
        
         <div class="mb-3">
            <label for="phoneNo" class="form-label">*Phone Number</label>
            <input type="number" id="phoneNo" name="phoneNo" placeholder="Enter Your Phone Number" class="form-control" required="required" autofocus>
        </div>
        
        
       <div class="mb-3">
            <label for="password" class="form-label">*Password</label>
            <input type="text" id="password" name="password" placeholder="Enter your password" class="form-control" required="required" autofocus>
        </div>
            
        
        <div class="mb-3">
          <div>
           <span class="help-block">*Required Fields</span>
          </div>
        </div>
   
     <button type="submit" class="badge rounded-pill bg-info text-dark">Submit</button>
     
     <button type="reset" class="badge rounded-pill bg-info text-dark">Reset</button>
    </form> <!-- /form -->
    
     <p> Already have an account ? <a href="signin.jsp">Please Login In</a> </p>
</div>
 <!-- ./container -->


		 <!-- Bootstrap core JS-->
		        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
		        <!-- Core theme JS-->
		        <script src="js/scripts.js"></script>
</body>
</html>