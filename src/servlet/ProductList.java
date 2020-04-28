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
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDao;
import dto.ProductDto;

/**
 * 商品情報一覧を行なうクラス.
 * @author Masato Yasuda
 */
@WebServlet("/product-list")
public class ProductList extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * デフォルトコンストラクタ
     */
    public ProductList() {
        super();
    }

    /**
	 * 商品情報一覧のdoGet()メソッド.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ProductDao dao = new ProductDao();
		List<ProductDto> productDtoList;
		try {
			productDtoList = dao.findAll();
			request.setAttribute("productDtoList", productDtoList);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		request.getRequestDispatcher("/jsp/ProductList.jsp").forward(request, response);
	}

	/**
	 * 商品情報一覧のdoPost()メソッド.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String genre = request.getParameter("genre");
		String maker = request.getParameter("maker");
		String productName = request.getParameter("productName");
		BigDecimal sellingPrice = new BigDecimal(request.getParameter("sellingPrice"));
		String productDetail = request.getParameter("productDetail");

		if (genre != null && maker != null && productName != null && sellingPrice != null && productDetail != null) {
			ProductDto productDto = new ProductDto();
		    productDto.setGenre(genre);
		    productDto.setMaker(maker);
		    productDto.setProductName(productName);
		    productDto.setSellingPrice(sellingPrice);
		    productDto.setProductDetail(productDetail);
			productDto.execute(productDto);
		} else {
			System.out.println("編集画面に移動できませんでした");
		}

		response.sendRedirect("./product-update");
	}

}
