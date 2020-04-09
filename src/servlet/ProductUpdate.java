package servlet;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDao;
import dto.ProductDto;
import dto.ProductDto.Genre;

/**
 * Servlet implementation class ProductUpdate
 */
@WebServlet("/product-update")
public class ProductUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setAttribute("genres", Genre.values());

		String productId = request.getParameter("productId");
		if (productId == null) {
			response.sendRedirect("./product-list");
		} else {
			ProductDao dao = new ProductDao();
			ProductDto productDto = dao.findById(Integer.parseInt(productId));
			request.setAttribute("productDto", productDto);
			request.getRequestDispatcher("/jsp/ProductUpdate.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		request.setCharacterEncoding("UTF-8");

		int productId = Integer.parseInt(request.getParameter("productId"));
		String genre = request.getParameter("genre");
		String maker = request.getParameter("maker");
		String productName = request.getParameter("productName");
		BigDecimal sellingPrice;
		String productDetail = request.getParameter("productDetail");

		if (request.getParameter("sellingPrice") != "") {
			sellingPrice = new java.math.BigDecimal(request.getParameter("sellingPrice"));
		} else {
			sellingPrice = BigDecimal.ZERO;
		}

		if (maker != null && maker.length() != 0 && productName != null && productName.length() != 0) {
			ProductDto productDto = new ProductDto(productId, genre, maker, productName, sellingPrice, productDetail);
			ProductDao dao = new ProductDao();
			dao.update(productDto);
			response.sendRedirect("./product-list");
		} else {
			ProductDao dao = new ProductDao();
			ProductDto productDto = dao.findById(productId);
			request.setAttribute("productDto", productDto);
			request.getRequestDispatcher("/jsp/ProductUpdate.jsp").forward(request, response);
		}
	}
}
