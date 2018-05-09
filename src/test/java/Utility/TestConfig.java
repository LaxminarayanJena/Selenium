package Utility;

public class TestConfig{


	
	public static String server="smtp.gmail.com";
	public static String from = "heardm14@gmail.com";
	public static String password = "123heard";
	public static String[] to ={"heardm15@gmail.com","heardm16@gmail.com"};
	public static String subject = "Test Report";
	
	public static String messageBody ="test message";
	public static String attachmentPath=System.getProperty("user.dir")+"\\src\\test\\resources\\screenshots\\2016_10_9_10_49_36.jpeg";
	public static String attachmentName="error.jpg";
	
	
	
	//SQL DATABASE DETAILS	
	public static String driver="net.sourceforge.jtds.jdbc.Driver"; 
	public static String dbConnectionUrl="jdbc:jtds:sqlserver://192.101.44.22;DatabaseName=30oct"; 
	public static String dbUserName="sa"; 
	public static String dbPassword="$ql$!!1"; 
	
	
	//MYSQL DATABASE DETAILS
	public static String mysqldriver="com.mysql.jdbc.Driver";
	public static String mysqluserName = "root";
	public static String mysqlpassword = "admin";
	public static String mysqlurl = "jdbc:mysql://localhost:3306/11sept";
	
	
	
	
	
	
	
	
	
}