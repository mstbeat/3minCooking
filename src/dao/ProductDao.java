package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.ProductDto;

public class ProductDao {
	private final String JDBC_URL = "jdbc:mysql://localhost:3306/wbr_inventory_control";
	private final String DB_USER = "root";
	private final String DB_PASS = "";

	public List<ProductDto> findAll() {
		List<ProductDto> productDtoList = new ArrayList<>();

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException d) {
            System.out.println("ドライバがありません" + d.getMessage());
		}

		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			String sql = "SELECT productId, genre, maker, productName, sellingPrice, productDetail FROM t_ProductInfo ORDER BY productId ASC";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			ResultSet rs = pStmt.executeQuery();

			while (rs.next()) {
				int productId = rs.getInt("productId");
			    String genre = rs.getString("genre");
			    String maker = rs.getString("maker");
			    String productName = rs.getString("productName");
			    java.math.BigDecimal sellingPrice = rs.getBigDecimal("sellingPrice");
			    String productDetail = rs.getString("productDetail");
			    ProductDto productDto = new ProductDto(productId, genre, maker, productName, sellingPrice, productDetail);
			    productDtoList.add(productDto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return productDtoList;
	}

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

	public ProductDto findOne(int productId) {
		ProductDto productDto = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException d) {
            System.out.println("ドライバがありません" + d.getMessage());
		}

		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			String sql = "SELECT * FROM t_ProductInfo WHERE productId=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, productId);

			ResultSet rs = pStmt.executeQuery();

			while (rs.next()) {
			    String genre = rs.getString("genre");
			    String maker = rs.getString("maker");
			    String productName = rs.getString("productName");
			    java.math.BigDecimal sellingPrice = rs.getBigDecimal("sellingPrice");
			    String productDetail = rs.getString("productDetail");
			    productDto = new ProductDto(productId, genre, maker, productName, sellingPrice, productDetail);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return productDto;
	}
}
