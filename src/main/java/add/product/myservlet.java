package add.product;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class myservlet
 */
public class myservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ServletRequest request;
	public Object rsimg;
       
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		doGet(request, response);
		
		String id = request.getParameter("id");
		String image = request.getParameter("image");
        String name = request.getParameter("name");
        String price = request.getParameter("price");
        String code = request.getParameter("code");
        String description = request.getParameter("dec"); 
        
        boolean isTrue;
        
        isTrue = ProductDBUtil.updateproduct1(id, image, name, price, code, description);
        
        if(isTrue == true) {
        	RequestDispatcher dis4 = request.getRequestDispatcher("AdminPanel.jsp");
        	dis4.forward(request, response);
        }
        else {
        	RequestDispatcher dis2 = request.getRequestDispatcher("UnSuccess.jsp");
    		dis2.forward(request,response);
        } 
}
		
	}


