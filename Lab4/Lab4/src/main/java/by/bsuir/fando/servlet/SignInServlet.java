package by.bsuir.fando.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.bsuir.fando.dataLayer.DBSingleton;
import by.bsuir.fando.entity.User;

/**
 * Servlet implementation class SignInServlet
 */
public class SignInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	private static void insert(Connection conn, User user) throws SQLException {
		String sql = "INSERT INTO users(login, email, status, password) VALUES(?,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, user.getLogin());
		pstmt.setString(2, user.getEmail());
		pstmt.setString(3, user.getStatus());
		pstmt.setString(4, user.getPassword());
		pstmt.executeUpdate();

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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
			ResultSet rs = stmt.executeQuery("SELECT * FROM users where login='" + request.getParameter("login") + "'");
			if (rs.next()) {
				getServletContext().getRequestDispatcher("/SignInPage.jsp").forward(request, response);
			} else {
				insert(DBSingleton.connect(), new User(request.getParameter("login"), request.getParameter("email"), "active",
						request.getParameter("password")));
				response.sendRedirect(request.getContextPath() + "/LogInPage.jsp");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
