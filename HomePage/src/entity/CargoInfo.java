package entity;

import java.sql.Date;

public class CargoInfo {

	// ����ȶ����ݿ���е��ֶΣ����д�����id,username,password����
		// kind
		private String kind;
		// username
		private String username;
		//car_id 
		private int id;
		//check_time;
		private Date checktime;
		
		
		// ����get��set����
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getKind() {
			return kind;
		}
		public void setKind(String kind) {
			this.kind = kind;
		}
		public Date getChecktime(){
			return checktime;
		}
		public void setChecktime(Date checktime){
			this.checktime=checktime;
		}
		
		// ��дtoString����
		@Override
		public String toString() {
			return "CargoInfo [id=" + id + ", username=" + username + ", kind=" + kind + ", checktime= " + checktime +"]";
		}

}
