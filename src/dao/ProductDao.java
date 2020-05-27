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

/**
 * ProductDtoのデータベース処理を行なうクラス.
 * @author Masato Yasuda
 */
public class ProductDao {

	/** 接続するJDBCのURL名 */
	private final String JDBC_URL = "jdbc:mysql://localhost:3306/wbr_inventory_control?serverTimezone=JST";

	/** 接続するユーザー名 */
	private final String DB_USER = "testuser";

	/** 接続するユーザーのパスワード */
	private final String DB_PASS = "testuser";

	/**
	 * 全てのProductDtoデータを検索して商品情報一覧を戻すメソッド.
	 * @return 商品情報一覧
	 * @throws ClassNotFoundException 指定されたクラスが見つからなかった場合に起こりうる例外 
	 * @throws SQLException DBアクセス時に起こりうる例外
	 */
	public List<ProductDto> findAll() throws ClassNotFoundException, SQLException {

		List<ProductDto> productDtoList = new ArrayList<>();

		getDriver();

		StringBuilder sql = new StringBuilder();
		sql.append("SELECT productId, ");
		sql.append("genre, ");
		sql.append("maker, ");
		sql.append("productName, ");
		sql.append("sellingPrice ");
		sql.append("FROM t_ProductInfo ");
		sql.append("ORDER BY productId ASC");
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
				PreparedStatement pStmt = conn.prepareStatement(sql.toString())) {

			ResultSet rs = pStmt.executeQuery();

			while (rs.next()) {
				ProductDto productDto = new ProductDto();
				productDto.setProductId(rs.getInt("productId"));
				productDto.setGenre(rs.getString("genre"));
				productDto.setMaker(rs.getString("maker"));
				productDto.setProductName(rs.getString("productName"));
				productDto.setSellingPrice(rs.getBigDecimal("sellingPrice"));
				productDtoList.add(productDto);
			}
		} catch (SQLException e) {
			throw e;
		}
		return productDtoList;
	}

	/**
	 * ProductDtoデータを登録するメソッド.
	 * @param productDto 商品情報
	 * @return trueの場合は成功、falseの場合は失敗。
	 * @throws ClassNotFoundException 指定されたクラスが見つからなかった場合に起こりうる例外
	 * @throws SQLException DBアクセス時に起こりうる例外
	 */
	public boolean create(ProductDto productDto) throws ClassNotFoundException, SQLException {

		getDriver();

		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO t_ProductInfo");
		sql.append("(genre, ");
		sql.append("maker, ");
		sql.append("productName, ");
		sql.append("sellingPrice, ");
		sql.append("productDetail) ");
		sql.append("VALUES (?, ?, ?, ?, ?)");
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
				PreparedStatement pStmt = conn.prepareStatement(sql.toString())) {

			conn.setAutoCommit(false);

			pStmt.setString(1, productDto.getGenre());
			pStmt.setString(2, productDto.getMaker());
			pStmt.setString(3, productDto.getProductName());
			pStmt.setBigDecimal(4, productDto.getSellingPrice());
			pStmt.setString(5, productDto.getProductDetail());

			int result = pStmt.executeUpdate();
			if (result != 1) {
				return false;
			}

			conn.commit();

		} catch (SQLException e) {
			throw e;
		}
		return true;
	}

	/**
	 * ProductDtoデータをIDで検索するメソッド.
	 * @param productId 商品ID
	 * @return 商品情報
	 * @throws ClassNotFoundException 指定されたクラスが見つからなかった場合に起こりうる例外
	 * @throws SQLException DBアクセス時に起こりうる例外
	 */
	public ProductDto findById(int productId) throws ClassNotFoundException, SQLException {

		ProductDto productDto = null;

		getDriver();

		StringBuilder sql = new StringBuilder();
		sql.append("SELECT genre, ");
		sql.append("maker, ");
		sql.append("productName, ");
		sql.append("sellingPrice, ");
		sql.append("productDetail ");
		sql.append("FROM t_ProductInfo ");
		sql.append("WHERE productId=?");
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
				PreparedStatement pStmt = conn.prepareStatement(sql.toString())) {

			pStmt.setInt(1, productId);

			ResultSet rs = pStmt.executeQuery();

			while (rs.next()) {
				productDto = new ProductDto();
				productDto.setProductId(productId);
				productDto.setGenre(rs.getString("genre"));
				productDto.setMaker(rs.getString("maker"));
				productDto.setProductName(rs.getString("productName"));
				productDto.setSellingPrice(rs.getBigDecimal("sellingPrice"));
				productDto.setProductDetail(rs.getString("productDetail"));
			}
		} catch (SQLException e) {
			throw e;
		}
		return productDto;
	}

	/**
	 * ProductDtoデータをIDで検索して更新するメソッド.
	 * @param productDto 商品情報
	 * @return trueの場合は成功、falseの場合は失敗。
	 * @throws ClassNotFoundException 指定されたクラスが見つからなかった場合に起こりうる例外 
	 * @throws SQLException DBアクセス時に起こりうる例外
	 */
	public boolean update(ProductDto productDto) throws ClassNotFoundException, SQLException {

		getDriver();

		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE t_ProductInfo ");
		sql.append("SET genre=?, ");
		sql.append("maker=?, ");
		sql.append("productName=?, ");
		sql.append("sellingPrice=?, ");
		sql.append("productDetail=? ");
		sql.append("WHERE productId=?");
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
				PreparedStatement pStmt = conn.prepareStatement(sql.toString())) {

			conn.setAutoCommit(false);

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

			conn.commit();

		} catch (SQLException e) {
			throw e;
		}
		return true;
	}

	/**
	 * ProductDtoデータをIDで検索して削除するメソッド.
	 * @param productId 商品ID
	 * @return trueの場合は成功、falseの場合は失敗。
	 * @throws ClassNotFoundException 指定されたクラスが見つからなかった場合に起こりうる例外 
	 * @throws SQLException DBアクセス時に起こりうる例外
	 */
	public boolean delete(int productId) throws ClassNotFoundException, SQLException {

		getDriver();

		String sql = "DELETE FROM t_ProductInfo WHERE productId=?";
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
				PreparedStatement pStmt = conn.prepareStatement(sql)) {

			conn.setAutoCommit(false);

			pStmt.setInt(1, productId);

			int result = pStmt.executeUpdate();
			if (result != 1) {
				return false;
			}

			conn.commit();

		} catch (SQLException e) {
			throw e;
		}
		return true;
	}

	/**
	 * JDBCをロードするメソッド.
	 * @throws ClassNotFoundException 指定されたクラスが見つからなかった場合に起こりうる例外 
	 */
	public void getDriver() throws ClassNotFoundException {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw e;
		}
	}
}
