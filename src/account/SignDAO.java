package account;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SignDAO {
	Connection con = null;
	User user=null;
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


public int insert(String id,String pw,String name) {
	int rs=0;
	//InsertMiniの内容をペーストする
	connection();
	if (con != null) {
		String sql = "insert into  account (id,pw,name) values (?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,id);
			ps.setString(2,pw);
			ps.setString(3,name);
//			ps.setString(3, "2010/10/10 9:5:1");
			rs = ps.executeUpdate();

			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnection();
		}
	}
	return rs;
}
}