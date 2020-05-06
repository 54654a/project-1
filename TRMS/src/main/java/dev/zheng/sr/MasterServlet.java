package dev.zheng.sr;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class MasterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MasterServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException,
	IOException {

		addCorsHeader(response);
		RequestHepler.process(request, response);
		
//		HttpSession sess = request.getSession();
//		String value = request.getParameter("eId");
//		value += request.getParameter("fullname");
//		
//		sess.setAttribute("employee", value );
		
		
	}


	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, 
	IOException {
		doGet(request, response);
	}
	
	protected void doOption(HttpServletRequest request, 
			HttpServletResponse response) {
		addCorsHeader(response);
	}
	private void addCorsHeader(HttpServletResponse response) {
		response.addHeader("Access-Control-Allow-Orgin", "http://localhost: 4200");
		response.addHeader("Vary", "Origin");
		
		response.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE, HEAD");
		response.addHeader("Access-Control-Allow-Headers", "X-PINGOTHER, Origin, X-Requested-With, Content-Type, Accept");
        response.addHeader("Access-Control-Allow-Credentials", "true");
        response.addHeader("Access-Control-Max-Age", "1728000");
        response.addHeader("Produces", "application/json");
		
	}


}
