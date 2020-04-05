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

		String productId = request.getParameter("productId");
		if ( productId == null) {
			response.sendRedirect("./product-list");
		} else {
			ProductDao dao = new ProductDao();
			ProductDto productDto = dao.findOne(Integer.parseInt(productId));
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

		System.out.println("更新しました");
		String genre = request.getParameter("genre");
		String maker = request.getParameter("maker");
		String productName = request.getParameter("productName");
		BigDecimal sellingPrice = new BigDecimal(request.getParameter("sellingPrice"));
		String productDetail = request.getParameter("productDetail");

		if (genre != null && maker != null && productName != null && sellingPrice != null && productDetail != null) {
			ProductDto productDto = new ProductDto(genre, maker, productName, sellingPrice, productDetail);
			productDto.execute(productDto);
		} else {
			System.out.println("更新できませんでした");
		}

		response.sendRedirect("./product-list");
	}

}