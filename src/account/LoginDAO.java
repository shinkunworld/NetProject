package account;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {

	Connection con = null;
	User user = null;

	//接続メソッド
	public void connection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/account?useSSL=false",
					"root", "root");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	//切断メソッド
	public void disconnection() {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void Login(String id, String pw,String name) {
		connection();
		if (con != null) {
			String sql = "SELECT *FROM ACCOUNT WHERE USER_ID= ? AND PASS= ?";
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				//set
				ps.setString(1, id);
				ps.setString(2, pw);

				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					id=rs.getString("id");
					pw=rs.getString("pw");
					name=rs.getString("name");

				}

				rs.close();
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				disconnection();
			}
		}
	}
}
