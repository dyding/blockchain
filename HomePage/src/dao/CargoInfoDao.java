package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.CargoInfo;
import utils.DBUtils;

public class CargoInfoDao {

	/**
	 * ���ݳ��ƺŲ����Ƿ��м�¼
	 * 
	 * @param car_id
	 * @return cargo
	 * @throws Exception
	 */
	public CargoInfo infosearch(int id) throws Exception {

		// ��ȡ���ݿ��������
		Connection connection = DBUtils.getConnection();

		// ����statement��ִ��sql
		String sql = "SELECT * FROM cargo_info WHERE car_id = ? ";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, id);
		// ��ȡ���ݼ�
		ResultSet resultSet = statement.executeQuery();

		// ����һ���յĻ�����Ϣ��Ԫ���ڽ��ղ�ѯ��������
		CargoInfo cargo = null;

		// ��������
		while (resultSet.next()) {
			cargo = new CargoInfo();
			cargo.setUsername(resultSet.getString("username"));
			cargo.setKind(resultSet.getString("kind"));
			cargo.setId(resultSet.getInt("car_id"));
			cargo.setChecktime(resultSet.getDate("check_time"));
			System.out.println(cargo);
		}

		// 5.�ر���Դ
		DBUtils.close(resultSet, statement, connection);

		return cargo;
	}

	/**
	 * ������Ϣ�Ǽ�
	 * @param cargo
	 * @return row
	 */
	public int addinfo (CargoInfo cargo) throws SQLException{
		// ��ȡ����
		Connection connection = DBUtils.getConnection();

		String sql = "INSERT INTO cargo_info (kind,car_id,username,isright) VALUES (?,?)";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, cargo.getUsername());
		statement.setString(2, cargo.getKind());
		statement.setDate(3, cargo.getChecktime());
		statement.setInt(4, cargo.getId());
		// ִ��sql��䣬����ɹ�������ݣ�row>0
		int row = statement.executeUpdate();

		// �ر���Դ
		DBUtils.close(null, statement, connection);

		// ��������
		return row;
	}

}
