package com.lowlist.MasterClass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MasterDao {
	
	protected Connection con = null;
	protected PreparedStatement ps = null;
	
	protected void update(String xx) {
		try {
			connectMySQL();
			ps = con.prepareStatement(xx);
			ps.executeUpdate();
			System.out.println("전송한 sql:"+xx);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	protected ResultSet Query(String xx) {
		ResultSet rs = null;
		try {
			connectMySQL();
			ps = con.prepareStatement(xx);
			rs = ps.executeQuery();
			System.out.println("전송한 sql:"+xx);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	protected void close() {
		try {
			if(ps != null) {
				ps.close();
			}
			if(con != null) {
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	protected void connectMySQL() throws ClassNotFoundException, SQLException {
		if(con == null || con.isClosed()) {
			Class.forName(Db.DB_JDBC_DRIVER_PACKAGE_PATH);
			con = DriverManager.getConnection(Db.DB_URL, Db.DB_ID, Db.DB_PW);
		}
	}
}
