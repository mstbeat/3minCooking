package servlet;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.ProductDto;
import dto.ProductDto.Genre;

/**
 * Servlet implementation class ProductRegistration
 */
@WebServlet("/product-registration")
public class ProductRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductRegistration() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("genres", Genre.values());
		request.getRequestDispatcher("/jsp/ProductRegistration.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		request.setCharacterEncoding("UTF-8");

		String genre = request.getParameter("genre");
		String maker = request.getParameter("maker");
		String productName = request.getParameter("productName");
		java.math.BigDecimal sellingPrice;
		String productDetail = request.getParameter("productDetail");

		if (request.getParameter("sellingPrice") != "") {
			sellingPrice = new java.math.BigDecimal(request.getParameter("sellingPrice"));
		} else {
			sellingPrice = BigDecimal.ZERO;
		}

		if (maker == null || maker.length() == 0 || productName == null || productName.length() == 0) {
			response.sendRedirect("./product-registration");
		} else {
			ProductDto productDto = new ProductDto(genre, maker, productName, sellingPrice, productDetail);
			productDto.execute(productDto);
			response.sendRedirect("./product-list");
		}
	}
}
