package cosmetic.nologin.signin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;

import com.google.gson.Gson;

@WebServlet("/IdCheck")
public class IdCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String mem_id = request.getParameter("mem_id");
		
		ISignInService service = SignInServiceImpl.getInstance();
		int cnt = service.countMemeber(mem_id);
		
		Gson gson = new Gson();
		String idCheckResult = null;
		if (cnt>0) {
			idCheckResult = "no";
		} else {
			idCheckResult = "ok";
		}
		String json = gson.toJson(idCheckResult);
		PrintWriter out = response.getWriter();
		out.print(json);
		response.flushBuffer();
		
	}
   
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
