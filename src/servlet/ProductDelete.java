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
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDao;

/**
 * 商品情報削除を行なうクラス.
 * @author Masato Yasuda
 */
@WebServlet("/product-delete")
public class ProductDelete extends HttpServlet {

	/**
	 * serialVersionUIDの生成
	 */
	private static final long serialVersionUID = 42L;

	/**
	 * デフォルトコンストラクタ
	 */
	public ProductDelete() {
		super();
	}

	/**
	 * 商品情報削除のdoPost()メソッド.
	 * @param request リクエストオブジェクト
	 * @param response レスポンスオブジェクト
	 * @throws ServletException サーブレットの処理で異常が発生した場合
	 * @throws IOException 入出力例外が発生した場合
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String productId = request.getParameter("productId");

		if (productId != null) {
			ProductDao dao = new ProductDao();
			try {
				dao.delete(Integer.parseInt(productId));
			} catch (NumberFormatException | SQLException | ClassNotFoundException e) {
				e.printStackTrace();
			}
			response.sendRedirect("./product-list");
		} else {
			response.sendRedirect("./product-list");
		}
	}

}
