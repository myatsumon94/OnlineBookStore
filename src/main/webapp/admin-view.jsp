<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page import="bookStore.model.BookDAO" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Online Book Store</title>
         <!-- CDN-->
         <link rel="stylesheet" href="https://cdn.datatables.net/1.12.1/css/dataTables.bootstrap5.min.css">
         <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
         <script src="https://cdn.datatables.net/1.12.1/js/jquery.dataTables.min.js"></script>
         <script src="https://cdn.datatables.net/1.12.1/js/dataTables.bootstrap5.min.js"></script>
        
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="css/styles.css" rel="stylesheet" />
        <link href="css/custom.css" rel="stylesheet" />
    </head>
    <body>
      
      	       <div class="container"></div>
        <!-- Responsive navbar-->
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <div class="container">
             
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
                
                     <button type="button" class="btn btn-lg " data-bs-toggle="popover""><a href="admin-create.jsp">Create</a></button>
                    </ul>
                </div>
            </div>
        </nav>
      
        
        <!-- Page content-->
        <div class="container mt-5">
                <table id="bookList" class="table table-striped">
                    <thead>
                        <tr>
                            <th>Id</th>
                            <th>Author</th>
                            <th>Genre</th>
                            <th>Title</th>
                            <th>Price</th>
                            
                        </tr>
                    </thead>
                    
                    <tbody>
	                    <c:forEach var="book" items="${bookList}">
	                    
	                     <c:url var="update" value="adminbook">
	                            <c:param name="mode" value="LOAD"></c:param>
	                            <c:param name="id" value="${book.id}"></c:param>                            
	                       </c:url>
	                 
	                 	 <c:url var="delete" value="adminbook">
	                            <c:param name="mode" value="DELETE"></c:param>
	                            <c:param name="id" value="${book.id}"></c:param>	                            
	                       </c:url>
	                       
	                        <tr>
	                      
	                            <td> <c:out value="${book.id}"></c:out> </td>
	                            <td> <c:out value="${book.author}"></c:out> </td>
	                            <td> <c:out value="${book.genre}"></c:out> </td>
	                            <td> <c:out value="${book.title}"></c:out> </td>
	                            <td> <c:out value="${book.price}"></c:out> </td>
	                            

								 <td>    
	                              <a href="${update}" class="badge rounded-pill bg-warning text-dark">Update</a>
	                              <a href="${delete}" onclick="return confirm('Are you sure to delete this book ? ')" class="badge rounded-pill bg-danger">Delete</a>
	                            </td>
	                            
								
	                        </tr>
	                     </c:forEach>
                    </tbody>
                   
                </table>
           
        </div>
        <!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <script src="js/scripts.js"></script>

        <script>
            $(document).ready(function () {
                 $('#bookList').DataTable();
            });
        </script>
        
      
        
    </body>
</html>
    