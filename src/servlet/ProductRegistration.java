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

package servlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDao;
import dto.ProductDto;

/**
 * 商品情報登録を行なうクラス.
 * @author Masato Yasuda
 */
@WebServlet("/product-registration")
public class ProductRegistration extends HttpServlet {

	/**
	 * serialVersionUIDの生成
	 */
	private static final long serialVersionUID = 853408544920789521L;

	/**
	 * デフォルトコンストラクタ
	 */
	public ProductRegistration() {
		super();
	}

	/**
	 * 商品情報登録のdoGet()メソッド.
	 * @param request リクエストオブジェクト
	 * @param response レスポンスオブジェクト
	 * @throws ServletException サーブレット実行時に起こりえる例外
	 * @throws IOException 入出力時に起こりえる例外
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("/jsp/ProductRegistration.jsp").forward(request, response);
	}

	/**
	 * 商品情報登録のdoPost()メソッド.
	 * @param request リクエストオブジェクト
	 * @param response レスポンスオブジェクト
	 * @throws ServletException サーブレット実行時に起こりえる例外
	 * @throws IOException 入出力時に起こりえる例外
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		String genre = request.getParameter("genre");
		String maker = request.getParameter("maker");
		String productName = request.getParameter("productName");
		BigDecimal sellingPrice = null;
		String productDetail = request.getParameter("productDetail");

		String price = request.getParameter("sellingPrice");

		if (maker == null || maker.length() == 0 || productName == null || productName.length() == 0) {
			response.sendRedirect("./product-registration");
		} else {
			if (price != null && !(price.isEmpty())) {
				try {
					Integer.parseInt(price);
				} catch (NumberFormatException e) {
					e.printStackTrace();
				}
				sellingPrice = new BigDecimal(price);
			} else {
				sellingPrice = BigDecimal.ZERO;
			}
			ProductDto productDto = new ProductDto();
			productDto.setGenre(genre);
			productDto.setMaker(maker);
			productDto.setProductName(productName);
			productDto.setSellingPrice(sellingPrice);
			productDto.setProductDetail(productDetail);

			ProductDao dao = new ProductDao();
			try {
				dao.create(productDto);
			} catch (SQLException | ClassNotFoundException e) {
				e.printStackTrace();
			}

			response.sendRedirect("./product-list");
		}
	}
}
