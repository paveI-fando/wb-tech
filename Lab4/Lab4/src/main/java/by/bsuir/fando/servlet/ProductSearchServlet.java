package by.bsuir.fando.servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.bsuir.fando.dataLayer.DBSingleton;
import by.bsuir.fando.entity.Product;

/**
 * Servlet implementation class ProductSearchServlet
 */
public class ProductSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("productList", SelectProducts(request));
		getServletContext().getRequestDispatcher("/UserPage.jsp").forward(request, response);
	}
	
	private List<Product> SelectProducts(HttpServletRequest request) {
    	List<Product> list = new ArrayList<Product>();
        try {
    		Statement stmt = DBSingleton.connect().createStatement();
    		String query = request.getParameter("query");
    		ResultSet rs = stmt.executeQuery("SELECT * FROM products WHERE product_id='"+query+"' or title='"+query+"' or manufacturer='"+
    		query+"' or model='"+query+"' or price='"+query+"' or amount='"+query+"'");
    		while (rs.next()) {
    			  String product_id = rs.getString("product_id");
    			  String title = rs.getString("title");
    			  String manufacturer = rs.getString("manufacturer");
    			  String model = rs.getString("model");
    			  Double price = Double.parseDouble(rs.getString("price"));
    			  Integer amount = Integer.parseInt(rs.getString("amount"));
    			  list.add(new Product(product_id, title, manufacturer, model, price, amount));
    			}
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
