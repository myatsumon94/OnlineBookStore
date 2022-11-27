
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
	                    <c:forEach var="bookList" items="${bookList}">
	                    
	                   
	                 
	                        <tr>
	                      
	                            <td> <c:out value="${bookList.id }"></c:out> </td>
	                            <td> <c:out value="${bookList.author }"></c:out> </td>
	                            <td> <c:out value="${bookList.genre }"></c:out> </td>
	                            <td> <c:out value="${bookList.title }"></c:out> </td>
	                            <td> <c:out value="${bookList.price }"></c:out> </td>
	                            
	                          <td>  <a href="cart.jsp" class="badge rounded-pill bg-warning text-dark">Add to Cart</a></td>

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
    