package by.bsuir.fando;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

import by.bsuir.fando.DL.DOMParser;
import by.bsuir.fando.DL.SAXParser;
import by.bsuir.fando.entity.Product;

/**
 * Servlet implementation class DOMParserServlet
 */
public class DOMParserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DOMParserServlet() {
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
    	DOMParser parser = null;
        try {
            parser = new DOMParser();
            return parser.parse(getServletContext().getResourceAsStream("products.xml"));

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
            return null;
        } catch (SAXException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
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
