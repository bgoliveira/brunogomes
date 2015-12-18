package me.brunogomes.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import me.brunogomes.daos.ProductDao;

@WebServlet("/search")
public class Search extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Autowired ProductDao productDao;
	
	public void init(ServletConfig config) throws ServletException {
	    super.init(config);
	    SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this,
	      config.getServletContext());
	  }

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException
	{
		PrintWriter writer =  resp.getWriter();
		
		writer.println("<html><body>");
		writer.println(productDao.all().toString());
		writer.println("</html></body>");
		
	}
	

}
