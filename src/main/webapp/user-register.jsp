<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

    <form action="bookList" method="post">
        <h2 class="text-center">User Registration</h2>
        
        <input type="hidden" name="mode" value="CREATE">
        
        
        <div class="mb-3">
            <label class="form-label">*Name</label>
            <input type="text" placeholder="Enter Your name" class="form-control" autofocus>
        </div>
            
        <div class="mb-3">
            <label class="form-label">*Email</label>
            <input type="text" placeholder="Enter Your email" class="form-control" autofocus>
        </div>
        
         <div class="mb-3">
            <label class="form-label">*Address</label>
            <input type="text" placeholder="Enter Your address" class="form-control" autofocus>
        </div>
        
         <div class="mb-3">
            <label class="form-label">*Phone Number</label>
            <input type="tel" placeholder="Enter Your Phone Number" class="form-control" autofocus>
        </div>
        
        
       <div class="mb-3">
            <label class="form-label">*Password</label>
            <input type="password" placeholder="Enter your password" class="form-control" autofocus>
        </div>
            
      
   
     <button type="submit" class="badge rounded-pill bg-info text-dark">Submit</button>
     
     <button type="reset" class="badge rounded-pill bg-info text-dark">Reset</button>
    </form> <!-- /form -->
    
    
</div>
 <!-- ./container -->


		 <!-- Bootstrap core JS-->
		        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
		        <!-- Core theme JS-->
		        <script src="js/scripts.js"></script>
</body>
</html>