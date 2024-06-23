<%@page import="studentjsp.dto.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%String name=(String)request.getAttribute("name1"); %>
<%if(name !=null){ %>
<h1><%="Changed by : "+name %></h1>
<%} %>

<%List<Student> students=(List)request.getAttribute("list"); %>
<table border="2px">
<tr>
<th>Id</th>
<th>Name</th>
<th>Address</th>
<th>Email</th>
<th>Password</th>
<th>Course</th>
<th>Fees</th>
<th>Phone</th>
</tr>
<%for(Student student:students){ %>
<tr>
<td><%= student.getId() %></td>
<td><%= student.getName() %></td>
<td><%= student.getAddress() %></td>
<td><%= student.getEmail() %></td>
<td><%= student.getPassword() %></td>
<td><%= student.getCourse() %></td>
<td><%= student.getFees() %></td>
<td><%= student.getPhone() %></td>
<td><a href="delete?id=<%=student.getId()%>">Delete</a></td>
<td><a href="update?id=<%=student.getId()%>">Update</a></td>
<%} %>
</tr>

</table>
</body>
</html>