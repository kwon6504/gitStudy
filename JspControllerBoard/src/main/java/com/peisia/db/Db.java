package com.peisia.db;

public class Db {
	static public String DB_JDBC_DRIVER_PACKAGE_PATH = "com.mysql.cj.jdbc.Driver"; // mysql
	static private String DB_NAME = "my_cat";
	static private String DB_URL_MYSQL = "jdbc:mysql://localhost:3306/" + DB_NAME; // mysql
	static public String DB_URL = DB_URL_MYSQL; // 디비 바뀌면 여기 바꾸시오.
	static public String DB_ID = "root";
	static public String DB_PW = "root";

}