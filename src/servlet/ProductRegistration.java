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
	private static final long serialVersionUID = 1L;

    /**
     * デフォルトコンストラクタ
     */
    public ProductRegistration() {
        super();
    }

    /**
	 * 商品情報登録のdoGet()メソッド.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("/jsp/ProductRegistration.jsp").forward(request, response);
	}

	/**
	 * 商品情報登録のdoPost()メソッド.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		String genre = request.getParameter("genre");
		String maker = request.getParameter("maker");
		String productName = request.getParameter("productName");
		BigDecimal sellingPrice;
		String productDetail = request.getParameter("productDetail");

		if (request.getParameter("sellingPrice") != "") {
			sellingPrice = new BigDecimal(request.getParameter("sellingPrice"));
		} else {
			sellingPrice = BigDecimal.ZERO;
		}

		if (maker == null || maker.length() == 0 || productName == null || productName.length() == 0) {
			response.sendRedirect("./product-registration");
		} else {
			ProductDto productDto = new ProductDto();
		    productDto.setGenre(genre);
		    productDto.setMaker(maker);
		    productDto.setProductName(productName);
		    productDto.setSellingPrice(sellingPrice);
		    productDto.setProductDetail(productDetail);
			this.execute(productDto);
			response.sendRedirect("./product-list");
		}
	}
	
    /**
	 * 商品情報をデータベースに登録するメソッド.
	 * @param productDto 商品情報データオブジェクト
	 */
    public void execute(ProductDto productDto) {
    	
    	ProductDao dao = new ProductDao();
    	
    	try {
			dao.create(productDto);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
    }
    
}
