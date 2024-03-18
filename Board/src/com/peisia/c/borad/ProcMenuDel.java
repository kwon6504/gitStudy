package com.peisia.c.borad;

import com.peisia.c.data.Data;
import com.peisia.c.util.Ci;
import com.peisia.c.util.Cw;

public class ProcMenuDel {
	static void run() {
		Cw.wn("삭제");
		String cmd = Ci.r("삭제할 글 번호");
		
		int tempSearchIndex = 0;
		for(int i=0; i<Data.posts.size(); i++) {
			if(cmd.equals(Data.posts.get(i).instanceNo+"")) {
				tempSearchIndex = i;
			}
		}
		
		Data.posts.remove(tempSearchIndex);
		Cw.wn("글 수:" + Data.posts.size());
	}
}