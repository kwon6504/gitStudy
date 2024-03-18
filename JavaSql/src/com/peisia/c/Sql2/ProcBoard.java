package com.peisia.c.Sql2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class ProcBoard {
	Connection con = null;
	Statement st = null;
	ResultSet result = null;
	Scanner sc = new Scanner(System.in);
	void run() {
		Display.showTitle();
	}
}
