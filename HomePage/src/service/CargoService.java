package service;

import java.sql.SQLException;

import dao.CargoInfoDao;
import entity.CargoInfo;

public class CargoService {

	// 创建cargoDao对象
		private CargoInfoDao cargodao = new CargoInfoDao();
		
		/**
		 * 查询该车辆是否有前科
		 * @param carID
		 * @return cargo
		 */
		
		public CargoInfo infosearch(int id){
			
			CargoInfo cargo = null;
			
			try{
				cargo = cargodao.infosearch(id);				
			}catch(Exception e){
				e.printStackTrace();
			}
			
			return cargo;
			
		}
		

		/**
		 * 货运信息登记
		 * @param cargo
		 * @return row
		 */
		public int addinfo(CargoInfo cargo) {
			// 首先定义row=0，若有新用户注册，row>0,如果没有注册返回0
			int row = 0;
			try {
				row = cargodao.addinfo(cargo);
			} catch (SQLException e) {
				e.printStackTrace();
			}		
			return row;
		}
}
