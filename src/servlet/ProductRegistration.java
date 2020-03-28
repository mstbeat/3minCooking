package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
		System.out.println("POSTメソッドで呼び出されました");
			String genre = "";
			String maker = "";
			String productName = "";
			String sellingPrice = "";
			String productDetail = "";

			genre = request.getParameter("genre");
			maker = request.getParameter("maker");
			productName = request.getParameter("productName");
			sellingPrice = request.getParameter("sellingPrice");
			productDetail = request.getParameter("productDetail");

			System.out.println(genre);
			System.out.println(maker);
			System.out.println(productName);
			System.out.println(sellingPrice);
			System.out.println(productDetail);
	}

}
