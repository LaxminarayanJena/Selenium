package rough;

import java.sql.SQLException;

import Utility.DbManager;

public class DataBaseConnection {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		DbManager.setMysqlDbConnection();
		System.out.println(DbManager.getMysqlQuery("select tutorial_author from selenium where tutorial_id =2;"));
	}

}
