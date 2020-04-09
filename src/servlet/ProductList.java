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
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.ProductDto;
import model.GetProductDtoListLogic;

/**
 * Servlet implementation class ProductList
 */
@WebServlet("/product-list")
public class ProductList extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		GetProductDtoListLogic getProductDtoListLogic = new GetProductDtoListLogic();
		List<ProductDto> productDtoList =  getProductDtoListLogic.execute();
		request.setAttribute("productDtoList", productDtoList);

		request.getRequestDispatcher("/jsp/ProductList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		request.setCharacterEncoding("UTF-8");

//		int productId = Integer.parseInt(request.getParameter("productId"));
		String genre = request.getParameter("genre");
		String maker = request.getParameter("maker");
		String productName = request.getParameter("productName");
		BigDecimal sellingPrice = new BigDecimal(request.getParameter("sellingPrice"));
		String productDetail = request.getParameter("productDetail");

		if (genre != null && maker != null && productName != null && sellingPrice != null && productDetail != null) {
			ProductDto productDto = new ProductDto(genre, maker, productName, sellingPrice, productDetail);
			productDto.execute(productDto);
		} else {
			System.out.println("編集画面に移動できませんでした");
		}

		response.sendRedirect("./product-update");
	}

}
