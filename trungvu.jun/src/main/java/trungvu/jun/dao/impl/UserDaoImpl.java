package trungvu.jun.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import trungvu.jun.configs.DataBaseConnection;
import trungvu.jun.dao.UserDao;
import trungvu.jun.models.UserModel;

public class UserDaoImpl implements UserDao {

	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;
	
	@Override
	public void insert(UserModel user) {
		String sql = "INSERT INTO users(username, fullname, email, phone, password) VALUES (?,?,?,?,?)";
		try {
			conn = new DataBaseConnection().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(3, user.getEmail());
			ps.setString(1, user.getUserName());
			ps.setString(2, user.getFullName());
			ps.setString(5, user.getPassWord());
			ps.setString(4, user.getPhone());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public boolean checkExistEmail(String email) {
		boolean duplicate = false;
		String query = "select * from Users where email = ?";
		try {
			conn = new DataBaseConnection().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, email);
			rs = ps.executeQuery();
			if (rs.next()) {
				duplicate = true;
			}
			ps.close();
			conn.close();
		} catch (Exception ex) {
		}
		return duplicate;
	}

	@Override
	public boolean checkExistUsername(String username) {
		boolean duplicate = false;
		String query = "select * from Users where username = ?";
		try {
			conn = new DataBaseConnection().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, username);
			rs = ps.executeQuery();
			if (rs.next()) {
				duplicate = true;
			}
			ps.close();
			conn.close();
		} catch (Exception ex) {
		}
		return duplicate;
	}

	@Override
	public boolean checkExistPhone(String phone) {
		boolean duplicate = false;
		String query = "select * from Users where phone = ?";
		try {
			conn = new DataBaseConnection().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, phone);
			rs = ps.executeQuery();
			if (rs.next()) {
				duplicate = true;
			}
			ps.close();
			conn.close();
		} catch (Exception ex) {
		}
		return duplicate;
	}

}
