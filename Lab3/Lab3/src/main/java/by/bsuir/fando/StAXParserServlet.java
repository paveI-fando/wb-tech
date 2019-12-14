package by.bsuir.fando;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.stream.XMLStreamException;
import by.bsuir.fando.DL.StAXParser;
import by.bsuir.fando.entity.Product;

/**
 * Servlet implementation class StAXParserServlet
 */
public class StAXParserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StAXParserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stubS
		
		request.setAttribute("productList", ParseStart());
		getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
		
	}
	
    private List<Product> ParseStart() {
    	
    	
        try {
        	StAXParser parser = new StAXParser(getServletContext().getResourceAsStream("products.xml"));
            return parser.parse();
        } catch (XMLStreamException e) {
            e.printStackTrace();
            return null;
        }
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
