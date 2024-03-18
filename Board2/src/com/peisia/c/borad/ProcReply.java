package com.peisia.c.borad;

import com.peisia.c.Sql.Load;
import com.peisia.util.Ci;
import com.peisia.util.Cw;

public class ProcReply {
	public static void list(int oriNo) {
		Cw.wn("==========댓글 리스트==========");
		String sql = "select*from board where b_reply_ori=" + oriNo + " and b_del=0";
		try {
			Cw.wn("전송한sql문" + sql);
			Load.result = Load.st.executeQuery(sql);
			while(Load.result.next()) {
				String b_reply_text = Load.result.getString("b_reply_text");
				String b_id = Load.result.getString("b_id");
				Cw.wn(b_reply_text+" - "+b_id);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void write(int b_reply_ori) {
		String b_reply_text = Ci.rl("댓글달기");
		Load.dbExecuteUpdate("insert into board " 
		+ "(b_id,b_datetime,b_reply_ori,b_reply_text) values " 
		+ "('"
		+ Member.idname 
		+ "', now()," + b_reply_ori + ",'" + b_reply_text + "');");
	}
}
