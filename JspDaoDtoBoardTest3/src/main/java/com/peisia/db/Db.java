package com.peisia.db;

public class Db {
	//db접속 객체선언
	public static String DB_JDBC_DRIVER_PACKAGE_PATH = "com.mysql.cj.jdbc.Driver";
	private static String DB_NAME = "my_cat";
	private static String DB_URL_MYSQL = "jdbc:mysql://localhost:3306/"+DB_NAME;
	public static String DB_URL = DB_URL_MYSQL;
	public static String DB_ID = "root";
	public static String DB_PW = "root";
	
	//table 연결 객체선언
	public static final String TABLE_PS_BOARD_FREE = "PS_BOARD_FREE";
}
