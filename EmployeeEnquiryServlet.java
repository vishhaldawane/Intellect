package myemp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EmployeeEnquiryServlet extends GenericServlet {
	
	Connection conn; // hasA
	Statement st;
	ResultSet rs; 
	
    public EmployeeEnquiryServlet() {
        super();
        System.out.println("EmployeeEnquiryServlet() constructor...");
    }

	
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init()...LOAD THE DRIVER....");

		try {
			//1 load the driver...
			System.out.println("Trying to load the driver ...");
			//below line will find the driver for eclipse to compile
			//but how about tomcat at runtime???
			DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
			//DriverManager.registerDriver(new org.hsqldb.jdbc.JDBCDriver());
			System.out.println("Driver loaded...");
		//2
			System.out.println("Trying to connect to the database...");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:OSE", "system", "manager");
			//Connection conn = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/mydb", "SA", "");
			System.out.println("Connected to the database..."+conn);
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
	}

	
	public void destroy() {
		
		System.out.println("destroy()...");
		try {
			rs.close();			
			st.close();			
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("DB resources closed...");
	}

	
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		
		try
		{
			System.out.println("\tservice()...Host : "+request.getRemoteHost()+" Port : "+request.getRemotePort());
			PrintWriter pw = response.getWriter();
			
			String whatIsClicked = request.getParameter("submit"); //read the value of the submit button
			
			if(whatIsClicked.equals("Find Employee"))
			{
				String whatIsEmpno = request.getParameter("myempno"); // read the value of the input type
				System.out.println("What is clicked "+whatIsClicked);
				System.out.println("What is empno   "+whatIsEmpno);
				int eno = Integer.parseInt(whatIsEmpno);
				st = conn.createStatement();
				rs = st.executeQuery("select * from emp WHERE empno="+eno);
				//4 process it
				if(rs.next()) 
				{ //if the record is found
					int empno 	 = rs.getInt(1);
					String ename = rs.getString(2);
					String job   =  rs.getString(3);
					int mgr      =  rs.getInt(4);
					java.sql.Date date = rs.getDate(5);
					float salary = rs.getFloat(6);
					float comm   = rs.getFloat(7);
					int deptno   = rs.getInt(8);
					System.out.println("EMPNO  : "+empno);
					System.out.println("NAME   : "+ename);
					System.out.println("JOB    : "+job);
					System.out.println("MGR    : "+mgr);
					System.out.println("DOJ    : "+date);
					System.out.println("SAL    : "+salary);
					System.out.println("COMM   : "+comm);
					System.out.println("DEPTNO : "+deptno);
					System.out.println("-----------------------------");	
				
					pw.println("<html>");
						pw.println("<title>Employee Enquiry Servlet</title>");
						pw.println("<body>");
						pw.println("<h1 align=center> Employee Enquiry Servlet</h1>");
					
						pw.println("</body>");
						pw.println("<table border=5 cellspacing=10 cellpadding=10>");
						pw.println("<tr>");
							pw.println("<td> EMPNO </td>");	pw.println("<td>"+empno+"</td>");
						pw.println("</tr>");
					
						pw.println("<tr>");
							pw.println("<td> EMPNAME </td>");	pw.println("<td>"+ename+"</td>");
						pw.println("</tr>");
				
						pw.println("<tr>");
							pw.println("<td> JOB </td>");	pw.println("<td>"+job+"</td>");
						pw.println("</tr>");
					
						pw.println("<tr>");
							pw.println("<td> MANAGER </td>");	pw.println("<td>"+mgr+"</td>");
						pw.println("</tr>");
					
						pw.println("<tr>");
							pw.println("<td> JOINING </td>");	pw.println("<td>"+date+"</td>");
						pw.println("</tr>");
					
						pw.println("<tr>");
							pw.println("<td> SALARY </td>");	pw.println("<td>"+salary+"</td>");
						pw.println("</tr>");
					
						pw.println("<tr>");
							pw.println("<td> COMM </td>");	pw.println("<td>"+comm+"</td>");
						pw.println("</tr>");
					
						pw.println("<tr>");
							pw.println("<td> DEPTNO </td>");	pw.println("<td>"+deptno+"</td>");
						pw.println("</tr>");	
				}
				else {
					pw.println("<tr>");
						pw.println("<td> EMPNO NOT FOUND : "+eno+"</td>");	
					pw.println("</tr>");
				}
				pw.println("</table>");
				pw.println("<a href='http://localhost:8085/MyEmployeeProject/'>Home</a>");
				pw.println("</html>");
			}
			else if(whatIsClicked.equals("Find All Employees")) {
				st = conn.createStatement();
				rs = st.executeQuery("select * from emp");
				//4 process it
				
				pw.println("<html>");
				pw.println("<title>Employee Enquiry Servlet</title>");
				pw.println("<body>");
				pw.println("<h1 align=center> Employee Enquiry Servlet</h1>");
				pw.println("<table align=center  border=5 cellspacing=10 cellpadding=10>");
				pw.println("<th> EMPNO </th>");	
				pw.println("<th> EMPNAME </th>");
				pw.println("<th> JOB </th>");	
				pw.println("<th> MANAGER </th>");
				pw.println("<th> JOINING </th>");
				pw.println("<th> SALARY </th>");
				pw.println("<th> COMM </th>");	
				pw.println("<th> DEPTNO </th>");
				
				while(rs.next()) 
				{ //if the record is found
					int empno 	 = rs.getInt(1);
					String ename = rs.getString(2);
					String job   =  rs.getString(3);
					int mgr      =  rs.getInt(4);
					java.sql.Date date = rs.getDate(5);
					float salary = rs.getFloat(6);
					float comm   = rs.getFloat(7);
					int deptno   = rs.getInt(8);
					System.out.println("EMPNO  : "+empno);
					System.out.println("NAME   : "+ename);
					System.out.println("JOB    : "+job);
					System.out.println("MGR    : "+mgr);
					System.out.println("DOJ    : "+date);
					System.out.println("SAL    : "+salary);
					System.out.println("COMM   : "+comm);
					System.out.println("DEPTNO : "+deptno);
					System.out.println("-----------------------------");	
				
					
						pw.println("<tr>");
								pw.println("<td>"+empno+"</td>");
								pw.println("<td>"+ename+"</td>");
								pw.println("<td>"+job+"</td>");
								pw.println("<td>"+mgr+"</td>");
								pw.println("<td>"+date+"</td>");
								pw.println("<td>"+salary+"</td>");
								pw.println("<td>"+comm+"</td>");
								pw.println("<td>"+deptno+"</td>");
						pw.println("</tr>");	
				}
				
				pw.println("</table>");
				pw.println("<a href='http://localhost:8085/MyEmployeeProject/'>Home</a>");
				pw.println("</body>");
				pw.println("</html>");
			}
		} // end of try
		catch(Exception e) {
			System.out.println("Some problem : "+e);
		}
	}
	

}
