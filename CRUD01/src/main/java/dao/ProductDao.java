package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dto.ProductDto;

public class ProductDao {
	
	public Connection getConnection() {	//DBに接続
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String dbId = "crud01";
		String dbPw = "1234";
		Connection conn = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, dbId, dbPw);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public List<ProductDto> showProductList() {
		List<ProductDto> list = new ArrayList<>();
		
		try {
			Connection conn = getConnection();
			String sql = "SELECT p_code, p_name, price, stock FROM product ORDER BY p_code";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			ResultSet rs = pstmt.executeQuery();

			while(rs.next()) {
					String p_code = rs.getString("p_code");
					String p_name = rs.getString("p_name");
					int price = rs.getInt("price");
					int stock = rs.getInt("stock");
					
					list.add(new ProductDto(p_code, p_name, price, stock));
			}
			
			rs.close();
			pstmt.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
	
	public void deleteProduct(String p_code) {

		try {
			Connection conn = getConnection();
			String sql = "DELETE FROM product WHERE p_code = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, p_code);
			pstmt.executeUpdate();
			
			pstmt.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public void uploadProduct(String p_code, String p_name, int price, int stock) {
		
		try {
			Connection conn = getConnection();
			String sql = "INSERT INTO product(p_code, p_name, price, stock) VALUES(?,?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, p_code);
			pstmt.setString(2, p_name);
			pstmt.setInt(3, price);
			pstmt.setInt(4, stock);
			pstmt.executeUpdate();
			
			pstmt.close();
			conn.close();
			
		} catch(Exception e) {
			e.getStackTrace();
		}
	}
	
	public void editProduct(int price, int stock, String p_code) {
		try {
			Connection conn = getConnection();
			String sql = "UPDATE product SET price=?, stock=? WHERE p_code=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, price);
			pstmt.setInt(2, stock);
			pstmt.setString(3, p_code);
			pstmt.executeUpdate();
			
			pstmt.close();
			conn.close();
			
		} catch(Exception e) {
			e.getStackTrace();
		}
	}
	
	public List<ProductDto> showResult(String keyword) {
		List<ProductDto> list = new ArrayList<>();
		
		try {
			Connection conn = getConnection();
			String sql = "SELECT p_code, p_name, price, stock FROM product WHERE p_name LIKE ? ORDER BY p_code";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+keyword+"%");
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String p_code = rs.getString("p_code");
				String p_name = rs.getString("p_name");
				int price = rs.getInt("price");
				int stock = rs.getInt("stock");
				
				list.add(new ProductDto(p_code, p_name, price, stock));
			}
			
		} catch(Exception e) {
			e.getStackTrace();
		}
		
		return list;
	}
	
	public int countResult(String keyword) {
		int cnt = 0;
		
		try {
			Connection conn = getConnection();
			String sql = "SELECT COUNT(*) cnt FROM product WHERE p_name LIKE ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+keyword+"%");
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				cnt = rs.getInt("cnt");
			}
			
		} catch(Exception e) {
			e.getStackTrace();
		}
		
		return cnt;
	}
}
