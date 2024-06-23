package studentjsp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import studentjsp.dao.StudentDao;
import studentjsp.dto.Student;

@WebServlet("/edit")
public class EditServlet extends HttpServlet{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	int id=Integer.parseInt(req.getParameter("id"));
	String name=req.getParameter("name");
	String email=req.getParameter("email");
	String password=req.getParameter("password");
	String address=req.getParameter("address");
	long phone=Long.parseLong(req.getParameter("phone"));
	String course=req.getParameter("course");
	
	Student student=new Student();
	student.setAddress(address);
	student.setCourse(course);
	student.setEmail(email);
	student.setId(id);
	student.setName(name);
	student.setPassword(password);
	student.setPhone(phone);
	
	ServletContext context=getServletContext();
	double dfees=Double.parseDouble(context.getInitParameter("developmentfees"));
	double tfees=Double.parseDouble(context.getInitParameter("testingfees"));
	
	if(course.equals("Development")) {
		student.setFees(dfees);
	}else {
		student.setFees(tfees);
	}
	
	StudentDao dao=new StudentDao();
	dao.updateStudent(student);
	
	Cookie [] cookies=req.getCookies();
	String namewhochagedthedetails=null;
	for(Cookie cookie:cookies) {
		if(cookie.getName().equals("namewhologgedin")) {
			namewhochagedthedetails=cookie.getValue();
		}
	}
//	PrintWriter printWriter=resp.getWriter();
//	printWriter.print(namewhochagedthedetails);
	
	
	req.setAttribute("list", dao.getAllStudents());
	req.setAttribute("name1", namewhochagedthedetails);
	RequestDispatcher dispatcher=req.getRequestDispatcher("Display.jsp");
	dispatcher.forward(req, resp);
}
}
