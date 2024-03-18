package com.peisia.c.borad;

import com.peisia.c.Sql.Load;

public class Main {
	public static void main(String[] args) {
		Load.initDb();
		Load.dbInit();
		Board board = new Board();
		board.run();
	}
}