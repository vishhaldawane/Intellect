import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SelectTest {
	public static void main(String[] args) {
		
		try {
			//1 load the driver...
			System.out.println("Trying to load the driver ...");
			DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
			System.out.println("Driver loaded...");

			//2
			System.out.println("Trying to connect to the database...");
												//url							username	password
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:OSE", "system", "manager");
			System.out.println("Connected to the database..."+conn);

			System.out.println("For which job ? ");
			Scanner scan = new Scanner(System.in);
			String vjob = scan.nextLine();
			//3
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from emp WHERE job="+"'"+vjob+"'");
			
			// EMPNO ENAME      JOB              MGR HIREDATE         
				//SAL       COMM     DEPTNO
			
			
			//4 process it
			while(rs.next()) {
				
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
			}
			rs.close();			st.close();			conn.close();
			System.out.println("DB resources closed...");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
