package entity;

import java.sql.Date;

public class CargoInfo {

	// 这里比对数据库表中的字段，表中创建了id,username,password三个
		// kind
		private String kind;
		// username
		private String username;
		//car_id 
		private int id;
		//check_time;
		private Date checktime;
		
		
		// 生成get和set方法
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
		
		// 重写toString方法
		@Override
		public String toString() {
			return "CargoInfo [id=" + id + ", username=" + username + ", kind=" + kind + ", checktime= " + checktime +"]";
		}

}
