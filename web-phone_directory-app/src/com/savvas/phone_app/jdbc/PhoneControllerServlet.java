package com.savvas.phone_app.jdbc;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.sun.javadoc.ThrowsTag;

import java.util.List;

@WebServlet("/PhoneControllerServlet")
public class PhoneControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private PhoneDbUtil phoneDbUtil;

	@Resource(name = "jdbc/web_phone_tracker")
	private DataSource dataSource;

	@Override
	public void init() throws ServletException {

		super.init();

		try {
			phoneDbUtil = new PhoneDbUtil(dataSource);

		} catch (Exception exc) {
			throw new ServletException();
		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			String theCommand = request.getParameter("command");

			if (theCommand == null) {
				theCommand = "LIST";

			}

			switch (theCommand) {

			case "LIST":
				listPhones(request, response);
				break;

			case "ADD":
				addPhone(request, response);
				break;
			
			case "LOAD":
				loadPhone(request,response);
				break;
					
			case "UPDATE":
				updatePhone(request,response);
				break;
				
			case "DELETE":
				deletePhone(request,response);
				break;
				
			default:
				listPhones(request, response);
			}

		} catch (Exception exc) {
			throw new ServletException(exc);
		}

	}

	private void deletePhone(HttpServletRequest request, HttpServletResponse response) 
	throws Exception{
		
		String thePhoneId = request.getParameter("phoneId");
		
		phoneDbUtil.deletePhone(thePhoneId);
		
		listPhones(request, response);
		
	}

	private void updatePhone(HttpServletRequest request, HttpServletResponse response)
	throws Exception {

		int id = Integer.parseInt(request.getParameter("phoneId"));
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String phoneNumber = request.getParameter("phoneNumber");
		
		Phone thePhone =new Phone(id, firstName, lastName, phoneNumber);
		
		phoneDbUtil.updatePhone(thePhone);
		
		listPhones(request, response);
		
	}

	private void loadPhone(HttpServletRequest request, HttpServletResponse response)
	throws Exception{
		
		String thePhoneId = request.getParameter("phoneId");
		
		Phone thePhone = phoneDbUtil.getPhone(thePhoneId);
		
		request.setAttribute("THE_PHONE", thePhone);
		
		RequestDispatcher dispatcher =
				request.getRequestDispatcher("/update-phone-form.jsp");
			dispatcher.forward(request, response);

	}

	private void addPhone(HttpServletRequest request, HttpServletResponse response)
	throws Exception{
		
		String firstName=request.getParameter("firstName");
		String lastName=request.getParameter("lastName");
		String phoneNumber=request.getParameter("phoneNumber");
		
		Phone thePhone=new Phone(firstName, lastName, phoneNumber);
		
		phoneDbUtil.addPhones(thePhone);
		
		 
		listPhones(request, response);
		
	
	}

	private void listPhones(HttpServletRequest request, HttpServletResponse response) throws Exception {

		List<Phone> phones = phoneDbUtil.getPhones();

		request.setAttribute("PHONE_LIST", phones);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/list-phones.jsp");
		dispatcher.forward(request, response);

	}

}
