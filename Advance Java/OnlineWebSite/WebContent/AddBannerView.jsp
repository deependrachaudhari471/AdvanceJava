<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@page import = "javax.servlet.http.HttpSession" %>
 <%
    if(session.getAttribute("adminLogin") == null){
    	response.sendRedirect("admin.jsp");
    }
 %>
 
 <div align="center" >
    <table border="2">
    <h3>Welcome: ${adminLogin}</h3>
    <h3>Add Products</h3>
       <form action="AddBannerImagesCtl" method="post" enctype="multipart/form-data">
           <tr>
             <td>Banner id</td>
             <td><input type="text" name = "bannerid" id = "bannerid"></td>
           </tr>
           
          <td>Banner Image : </td>
          <td><input type= "file" name ="bannerimg"></td>
        </tr>
           <tr >
             <td colspan="2"><input type="submit" value = "Submit"></td>
           </tr>
       </form>
    </table>
     <a href="dashboard.jsp">Go To dashBoard</a>
    </div>  
</body>
</html>