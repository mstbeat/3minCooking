package servlet;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.ProductDto;

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
		request.getRequestDispatcher("/jsp/ProductRegistration.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		request.setCharacterEncoding("UTF-8");

		System.out.println("登録しました");
		String genre = request.getParameter("genre");
		String maker = request.getParameter("maker");
		String productName = request.getParameter("productName");
		BigDecimal sellingPrice = new BigDecimal(request.getParameter("sellingPrice"));
		String productDetail = request.getParameter("productDetail");

		if (genre != null && maker != null && productName != null && sellingPrice != null && productDetail != null) {
			ProductDto productDto = new ProductDto(genre, maker, productName, sellingPrice, productDetail);
			productDto.execute(productDto);
		} else {
			System.out.println("登録できませんでした");
		}

		response.sendRedirect("./product-list");

//		System.out.println(genre);
//		System.out.println(maker);
//		System.out.println(productName);
//		System.out.println(sellingPrice);
//		System.out.println(productDetail);
	}

}
