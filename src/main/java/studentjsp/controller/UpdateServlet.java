package studentjsp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import studentjsp.dao.StudentDao;
import studentjsp.dto.Student;

@WebServlet("/update")
public class UpdateServlet extends HttpServlet{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	int id=Integer.parseInt(req.getParameter("id"));
	StudentDao studentDao=new StudentDao();
	Student student=studentDao.getStudentById(id);
	
	HttpSession httpSession=req.getSession();
	String name=(String) httpSession.getAttribute("name");
	if(name != null) {
//		user is coming from login page
		req.setAttribute("student", student);
		RequestDispatcher dispatcher=req.getRequestDispatcher("Edit.jsp");
		dispatcher.forward(req, resp);
	}
	else {
//		user is scammer
		req.setAttribute("message", "hey scammer first login");
		RequestDispatcher dispatcher=req.getRequestDispatcher("login.jsp");
		dispatcher.forward(req, resp);
	}
}
}
