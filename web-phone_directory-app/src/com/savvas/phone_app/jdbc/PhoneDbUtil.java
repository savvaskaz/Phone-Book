package com.savvas.phone_app.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class PhoneDbUtil {

	private DataSource dataSource;

	public PhoneDbUtil(DataSource theDataSource) {
		dataSource = theDataSource;

	}

	public List<Phone> getPhones() throws Exception {

		List<Phone> phones = new ArrayList<>();

		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;

		try {

			myConn = dataSource.getConnection();

			String sql = "select * from phone_book order by last_name";

			myStmt = myConn.createStatement();

			myRs = myStmt.executeQuery(sql);

			while (myRs.next()) {

				int id = myRs.getInt("id");
				String firstName = myRs.getString("first_name");
				String lastName = myRs.getString("last_name");
				String phoneNumber = myRs.getString("phone");

				Phone tempPhone = new Phone(id, firstName, lastName, phoneNumber);

				phones.add(tempPhone);

			}

			return phones;
		}

		finally {
			close(myConn, myStmt, myRs);

		}
	}

	private void close(Connection myConn, Statement myStmt, ResultSet myRs) {

		try {
			if (myRs != null) {
				myRs.close();
			}
			if (myStmt != null) {
				myStmt.close();
			}

			if (myConn != null) {
				myConn.close();
			}
		}

		catch (Exception exc) {
			exc.printStackTrace();
		}

	}

	public void addPhones(Phone thePhone) throws Exception {

		Connection myConn = null;
		PreparedStatement myStmt = null;

		try {
			myConn = dataSource.getConnection();

			String sql = "insert into phone_book " + "(first_name, last_name ,phone) " + "values(?, ?, ?)";

			myStmt = myConn.prepareStatement(sql);

			myStmt.setString(1, thePhone.getFirstName());
			myStmt.setString(2, thePhone.getLastName());
			myStmt.setString(3, thePhone.getPhoneNumber());

			myStmt.execute();

		}

		finally {
			close(myConn, myStmt, null);

		}

	}

	public Phone getPhone(String thePhoneId) throws Exception {

		Phone thePhone = null;

		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;

		int phoneId;

		try {

			phoneId = Integer.parseInt(thePhoneId);

			myConn = dataSource.getConnection();

			String sql = "select * from phone_book where id=? ";

			myStmt = myConn.prepareStatement(sql);

			myStmt.setInt(1, phoneId);

			myRs = myStmt.executeQuery();

			if (myRs.next()) {
				String firstName = myRs.getString("first_name");
				String lastName = myRs.getString("last_name");
				String phoneNumber = myRs.getString("phone");

				thePhone = new Phone(phoneId, firstName, lastName, phoneNumber);

			} else {
				throw new Exception("Could not find phone id: " + phoneId);
			}

			return thePhone;
		}

		finally {
			close(myConn, myStmt, myRs);

		}

	}

	public void updatePhone(Phone thePhone) throws Exception {

		Connection myConn = null;
		PreparedStatement myStmt = null;

		try {

			myConn = dataSource.getConnection();

			String sql = "update phone_book " + "set first_name=?, last_name=?,phone=? " + "where id=?";

			myStmt = myConn.prepareStatement(sql);

			myStmt.setString(1, thePhone.getFirstName());
			myStmt.setString(2, thePhone.getLastName());
			myStmt.setString(3, thePhone.getPhoneNumber());
			myStmt.setInt(4, thePhone.getId());

			myStmt.execute();
			
		} finally {
			close(myConn, myStmt, null);
		}

	}

	public void deletePhone(String thePhoneId) throws Exception {
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			
			int phoneId = Integer.parseInt(thePhoneId);
			
			myConn = dataSource.getConnection();
			
			String sql = "delete from phone_book where id=?";
			
			myStmt = myConn.prepareStatement(sql);
			
			myStmt.setInt(1, phoneId);
			
			myStmt.execute();
				
		}
		
		finally {
			close(myConn, myStmt, null);
			
		}
	
		
	}
}
