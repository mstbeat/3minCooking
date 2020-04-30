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
import dto.ProductDto;

/**
 * 商品情報更新画面を表示するクラス.
 * @author Masato Yasuda
 */
@WebServlet("/product-edit")
public class ProductEdit extends HttpServlet {
	
	/**
	 * serialVersionUIDの生成
	 */ 
	private static final long serialVersionUID = 1L;

    /**
     * デフォルトコンストラクタ
     */
    public ProductEdit() {
        super();
    }

	/**
	 * 商品情報更新画面のdoPost()メソッド.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String productId = request.getParameter("productId");
		
		if (productId == null) {
			response.sendRedirect("./product-list");
		} else {
			ProductDao dao = new ProductDao();
			ProductDto productDto;
			try {
				productDto = dao.findById(Integer.parseInt(productId));
				request.setAttribute("productDto", productDto);
				request.getRequestDispatcher("/jsp/ProductUpdate.jsp").forward(request, response);
			} catch (NumberFormatException | SQLException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
	}
	
}
