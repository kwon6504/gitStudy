package com.peisia.c.board;

import com.peisia.c.board.display.DispBoard;
import com.peisia.c.util.Db;

public class ProcBoard {
	public static void run() {
		DispBoard.title();
		Db.getPostCount();
	}
}
