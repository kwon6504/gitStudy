package com.lowlist.MasterClass;

public class Db {

	public static String DB_JDBC_DRIVER_PACKAGE_PATH = "com.mysql.cj.jdbc.Driver";
	
	private static String DB_NAME = "my_dog";
	
	private static String DB_URL_MYSQL =  "jdbc:mysql://localhost:3306/"+DB_NAME;
	
	public static String DB_URL = DB_URL_MYSQL;
	
	public static String DB_ID = "root";
	public static String DB_PW = "root";
	
	public static final String TABLE_PS_BOARD_FREE = "dog_board";
	public static final String TABLE_SIGNUP = "idpw";

		public static final String DB_LINK =   "com.mysql.cj.jdbc.Driver";
		public static final String DB_SQL_URL = "jdbc:mysql://localhost:3306/" + DB_NAME;
		public static final String DB_TABLE = "Friends_List";
		public static final String DB_TABLE_CHECKBOX = "friend_checkbox";
		public static final String DB_TABLE_USERNAME = "login";

}
