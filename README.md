#Project Title:web-phone_directory-app

#Incuded
.java,.jsp files 

#Description:
This sample application demonstrates how to generate a phone directory for a company and based on Java EE and JavaServer Pages(JSP).


#Usage:With this application the user can add,remove and update phone numbers on the phone directory.  

#Instructions:This application runs with Eclipse IDE on server Tomcat.You must select the project from Eclipse and then
with right clik "Run as" --->> "run on Server".




#Requirements:
For building and running the application you need:

-JDK 12.0.2
-MySQL Workbench 8.0 CE
-Eclipse Jee 2019-06
-Tomcat9w

#Database 

-In my application I created a new MySql database with one table phone_book.This table has four fields(id,first_name,last_name,phone).
I used the sql command below:

CREATE TABLE `phone_book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=latin1




AND libraries
-javax.servlet.jsp.jstl-api-1.2.1.jar
javax.servlet.jsp.jstl-1.2.1.jar
-mysql-connector-java-8.0.13.jar




#My context.xml.file

The context.xml file is an optional file which contains a <Context> tag (Context Fragment) for a single Tomcat web application. This can be used to define certain behaviours for your application, JNDI resources and other settings.
  
  <Context>

  <Resource name="jdbc/web_phone_tracker" 
  			auth="Container" type="javax.sql.DataSource"
               maxActive="20" maxIdle="5" maxWait="10000"
               username="webphone" password="webphone" 
               driverClassName="com.mysql.jdbc.Driver"
                url="jdbc:mysql://localhost:3306/web_phone_tracker?useSSL=false&amp;serverTimezone=UTC">
  </Resource>             
</Context>
