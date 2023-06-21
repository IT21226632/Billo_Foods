package add.product;

import jakarta.servlet.RequestDispatcher; 
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import com.mysql.jdbc.Blob;


/**
 * Servlet implementation class p3
 */
@MultipartConfig
public class p3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletRequest request;
	public Object rsimg;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
Part file =request.getPart("image");
		
		String imageFileName = file.getSubmittedFileName();
		String UploadPath = "C:\\Users\\HP\\Desktop\\web\\adminDashBoard\\web content\\Images\\" + imageFileName ;		
		
		try {
		
		FileOutputStream fos = new FileOutputStream(UploadPath);
		InputStream is = file.getInputStream();
		
		byte[] data = new byte[is.available()];
		is.read(data);
		fos.write(data);
		fos.close();
	}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	
	
	String id = request.getParameter("id");
	String name = request.getParameter("name");
	String price  = request.getParameter("price");
	String code  = request.getParameter("code");
	String description  = request.getParameter("dec");
	
	try {
	List<Product> prDetails = ProductDBUtil.getProduct(id);
	request.setAttribute("prdetails", prDetails);
	}
	catch(Exception e){
		e.printStackTrace();
	}
	
	boolean isTrue;
	
	isTrue = ProductDBUtil.insertproduct(imageFileName, name, price, code, description);
	
	if(isTrue == true) {
		RequestDispatcher dis1 = request.getRequestDispatcher("AdminPanel.jsp");
		dis1.forward(request,response);
	}
	else {
		RequestDispatcher dis2 = request.getRequestDispatcher("UnSuccess.jsp");
		dis2.forward(request,response);
	}
	
                          
	
	}

}
