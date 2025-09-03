package quoctrung.dao.UserDaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import quoctrung.dao.UserDao;
import quoctrung.models.UserModel;
import quoctrung.configs.DataBaseConnection;

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
			ps.setString(1, user.getUserName());
			ps.setString(2, user.getFullName());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getPhone());
			ps.setString(5, user.getPassWord());
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

	public UserModel login(String username, String password) {
		UserModel user = null;
		String sql = "SELECT * FROM Users WHERE userName = ? AND passWord = ?";
		try {
			conn = new DataBaseConnection().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			rs = ps.executeQuery();
			if (rs.next()) {
				user = new UserModel(
					rs.getInt("id"),
					rs.getString("userName"),
					rs.getString("fullname"),
					rs.getString("email"),
					rs.getString("phone"),
					rs.getString("passWord")
				);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll();
		}
		return user;
	}
	
	private void closeAll() {
		try { if (rs != null) rs.close(); } catch (Exception e) {}
		try { if (ps != null) ps.close(); } catch (Exception e) {}
		try { if (conn != null) conn.close(); } catch (Exception e) {}
	}
}
