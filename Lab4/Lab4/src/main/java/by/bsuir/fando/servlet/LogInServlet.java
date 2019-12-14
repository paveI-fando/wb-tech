package by.bsuir.fando.servlet;

import com.mysql.jdbc.Driver;
import java.sql.Statement;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

import by.bsuir.fando.dataLayer.DBSingleton;
import by.bsuir.fando.dataLayer.SAXParser;
import by.bsuir.fando.entity.Product;
import by.bsuir.fando.entity.User;

/**
 * Servlet implementation class LogInServlet
 */
public class LogInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Connection conn = DBSingleton.connect();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub	
		Statement stmt;
		try {
			stmt = DBSingleton.connect().createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
		try {
			ResultSet rs = stmt.executeQuery("SELECT * FROM users where login='" + request.getParameter("login")
					+ "' and password='" + request.getParameter("password") + "'");
			if (rs.next()) {
				if (rs.getString("status").equals("admin")) {
					request.setAttribute("productList", SelectStart());
					request.setAttribute("userList", SelectUsers());
					getServletContext().getRequestDispatcher("/AdminPage.jsp").forward(request, response);
				} else if (rs.getString("status").equals("active")) {
					request.setAttribute("productList", SelectStart());
					getServletContext().getRequestDispatcher("/UserPage.jsp").forward(request, response);
				}
			} else {
				response.sendRedirect(request.getContextPath() + "/LogInPage.jsp");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
    private List<Product> SelectStart() {
    	List<Product> list = new ArrayList<Product>();
        try {
    		Statement stmt = conn.createStatement();
    		ResultSet rs = stmt.executeQuery("SELECT * FROM products");
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
    private List<User> SelectUsers() {
    	List<User> list = new ArrayList<User>();
        try {
    		Statement stmt = conn.createStatement();
    		ResultSet rs = stmt.executeQuery("SELECT * FROM users");
    		while (rs.next()) {
    			  String login = rs.getString("login");
    			  String email = rs.getString("email");
    			  String status = rs.getString("status");
    			  list.add(new User(login, email, status, null));
    			}
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
