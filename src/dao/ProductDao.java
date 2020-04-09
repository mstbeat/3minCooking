/**
* Copyright (c) Proud Data Co., Ltd. All Rights Reserved.
* Please read the associated COPYRIGHTS file for more details. *
* THE SOFTWARE IS PROVIDED BY Proud Group
* WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING
* BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
* FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
* IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDER BE LIABLE FOR ANY
* CLAIM, DAMAGES SUFFERED BY LICENSEE AS A RESULT OF USING, MODIFYING
* OR DISTRIBUTING THIS SOFTWARE OR ITS DERIVATIVES. */

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

	public ProductDto findById(int productId) {
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

	public boolean update(ProductDto productDto) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException d) {
            System.out.println("ドライバがありません" + d.getMessage());
		}

		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			String sql = "UPDATE t_ProductInfo SET genre=?, maker=?, productName=?, sellingPrice=?, productDetail=? WHERE productId=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setString(1, productDto.getGenre());
			pStmt.setString(2, productDto.getMaker());
			pStmt.setString(3, productDto.getProductName());
			pStmt.setBigDecimal(4, productDto.getSellingPrice());
			pStmt.setString(5, productDto.getProductDetail());
			pStmt.setInt(6, productDto.getProductId());

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

	public boolean delete(int productId) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException d) {
            System.out.println("ドライバがありません" + d.getMessage());
		}

		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			String sql = "DELETE FROM t_ProductInfo WHERE productId=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setInt(1, productId);

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
