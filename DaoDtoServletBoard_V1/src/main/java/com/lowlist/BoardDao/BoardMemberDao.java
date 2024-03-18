package com.lowlist.BoardDao;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import com.lowlist.Dto.DtoMember;
import com.lowlist.MasterClass.Db;
import com.lowlist.MasterClass.MasterDao;

public class BoardMemberDao extends MasterDao {
	
	//회원가입
		public void signup(DtoMember d){
			if(d.id == null && d.pw == null || d.id.equals("null") && d.pw.equals("null")) {
				System.out.println("아무것도안댐");
			} else {
				String sql = String.format
						(
						"INSERT INTO %s (r_id,r_pw) VALUES ('%s','%s')"
						,Db.TABLE_SIGNUP,d.id,d.pw
						);			
				super.update(sql);
				super.close();
			}
		}
		
		//로그인리스트
		public HashMap<DtoMember,String>loginlist() {
			HashMap<DtoMember,String> login_value = new HashMap<>();
			try {
				String sql = String.format(
						"SELECT * FROM %s",Db.TABLE_SIGNUP);			
				ResultSet rs = super.Query(sql);
				while(rs.next()){
				login_value.put(new DtoMember(rs.getInt("r_no"),(rs.getString("r_id"))),rs.getString("r_pw"));
				}
				super.close();
			}catch(Exception e){
				e.printStackTrace();
			}
			return login_value;
		}
		
		//로그인확인
		private boolean login_boolean(String nowid,String nowpw) {
			boolean login_confirm = false;
			HashMap<DtoMember,String> logindata = loginlist();
			for(Map.Entry<DtoMember,String> loginrun : logindata.entrySet()) {
				if(loginrun.getKey().id.equals(nowid)) {
					if(loginrun.getValue().equals(nowpw)) {
						login_confirm = true;
						break;
					}
				}
			}
			return login_confirm;
		}
		
		public Integer login_no (String nowid, String nowpw) {
			int login_no = 0;
			HashMap<DtoMember,String> login_value = loginlist();
				for(Map.Entry<DtoMember,String>login_value_no : login_value.entrySet() ) {
					if(login_value_no.getKey().id.equals(nowid)){
						if(login_value_no.getValue().equals(nowpw)) {
							login_no = login_value_no.getKey().loginno;
							break;
						}
					}
				}
				return login_no;
		}
		
		//로그인실행
		public boolean login_run(String nowid,String nowpw) {
			if(login_boolean(nowid,nowpw)) {
				return true;
			}else {
				return false;
			}
		} 
		
}
