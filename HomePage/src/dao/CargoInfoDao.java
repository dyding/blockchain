package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.CargoInfo;
import utils.DBUtils;

public class CargoInfoDao {

	/**
	 * 根据车牌号查找是否有记录
	 * 
	 * @param car_id
	 * @return cargo
	 * @throws Exception
	 */
	public CargoInfo infosearch(int id) throws Exception {

		// 获取数据库操作链接
		Connection connection = DBUtils.getConnection();

		// 创建statement并执行sql
		String sql = "SELECT * FROM cargo_info WHERE car_id = ? ";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, id);
		// 获取数据集
		ResultSet resultSet = statement.executeQuery();

		// 创建一个空的货物信息单元用于接收查询到的数据
		CargoInfo cargo = null;

		// 处理结果集
		while (resultSet.next()) {
			cargo = new CargoInfo();
			cargo.setUsername(resultSet.getString("username"));
			cargo.setKind(resultSet.getString("kind"));
			cargo.setId(resultSet.getInt("car_id"));
			cargo.setChecktime(resultSet.getDate("check_time"));
			System.out.println(cargo);
		}

		// 5.关闭资源
		DBUtils.close(resultSet, statement, connection);

		return cargo;
	}

	/**
	 * 货运信息登记
	 * @param cargo
	 * @return row
	 */
	public int addinfo (CargoInfo cargo) throws SQLException{
		// 获取链接
		Connection connection = DBUtils.getConnection();

		String sql = "INSERT INTO cargo_info (kind,car_id,username,isright) VALUES (?,?)";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, cargo.getUsername());
		statement.setString(2, cargo.getKind());
		statement.setDate(3, cargo.getChecktime());
		statement.setInt(4, cargo.getId());
		// 执行sql语句，如果成功添加数据，row>0
		int row = statement.executeUpdate();

		// 关闭资源
		DBUtils.close(null, statement, connection);

		// 返回数据
		return row;
	}

}
