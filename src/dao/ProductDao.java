package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dto.ProductDto;

public class ProductDao {
	private final String JDBC_URL = "jdbc:mysql://localhost:3306/wbr_inventory_control";
	private final String DB_USER = "root";
	private final String DB_PASS = "";

	public boolean create(ProductDto productDto) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException d) {
            System.out.println("ドライバがありません" + d.getMessage());
		}

		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			String sql = "INSERT INTO t_ProductInfo(genre, maker, productName, sellingPrice, productDetail) VALUES (?, ?, ?, ?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setString(1, productDto.getGenre());
			pStmt.setString(2, productDto.getMaker());
			pStmt.setString(3, productDto.getProductName());
			pStmt.setBigDecimal(4, productDto.getSellingPrice());
			pStmt.setString(5, productDto.getProductDetail());

			int result = pStmt.executeUpdate();
			if (result != 1) {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
