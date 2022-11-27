<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="bookStore.model.BookDAO , bookStore.controller.AdminBookController" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Admin Update Page</title>
         <!-- CDN-->
         <link rel="stylesheet" href="https://cdn.datatables.net/1.12.1/css/dataTables.bootstrap5.min.css">
         <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
       
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="css/styles.css" rel="stylesheet" />
        <link href="css/custom.css" rel="stylesheet" />
    </head>
    
    
    <body>
       
       

   <div class="container">

    <form action="adminbook" method="post">
        <h2 class="text-center">Update Book</h2>
        
        <input type="hidden" name="mode" value="UPDATE">      
        <input type="hidden" name="id" value="${book.id}">
        
        <h3><c:out value="ID : ${book.id}"></c:out></h3>
        
        <div class="mb-3">
            <label for="author" class="form-label">*Author</label>
            <input type="text" id="author" name="author" value="${book.author}" placeholder="Enter Author Name" class="form-control" autofocus>
        </div>
            
         <div class="mb-3">
            <label for="genre" class="form-label">*Genre</label>
            <input type="text" id="genre" name="genre" value="${book.genre}" placeholder="Enter Book Genre" class="form-control" autofocus>
        </div>
            
         <div class="mb-3">
            <label for="title" class="form-label">*Title</label>
            <input type="text" id="title" name="title" value="${book.title}" placeholder="Enter Book Title" class="form-control" autofocus>
        </div>
            
         <div class="mb-3">
            <label for="price" class="form-label">*Price</label>
            <input type="text" id="price" name="price" value="${book.price}" placeholder="Enter price of book" class="form-control" autofocus>
        </div>
                
            
      
   
     <button type="submit" class="badge rounded-pill bg-info text-dark">Update</button>
     
     
    </form> <!-- /form -->
    
    
</div>
 <!-- ./container -->


		 <!-- Bootstrap core JS-->
		        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
		        <!-- Core theme JS-->
		        <script src="js/scripts.js"></script>
</body>
</html>