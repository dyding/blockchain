package service;

import java.sql.SQLException;

import dao.CargoInfoDao;
import entity.CargoInfo;

public class CargoService {

	// ����cargoDao����
		private CargoInfoDao cargodao = new CargoInfoDao();
		
		/**
		 * ��ѯ�ó����Ƿ���ǰ��
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
		 * ������Ϣ�Ǽ�
		 * @param cargo
		 * @return row
		 */
		public int addinfo(CargoInfo cargo) {
			// ���ȶ���row=0���������û�ע�ᣬrow>0,���û��ע�᷵��0
			int row = 0;
			try {
				row = cargodao.addinfo(cargo);
			} catch (SQLException e) {
				e.printStackTrace();
			}		
			return row;
		}
}
