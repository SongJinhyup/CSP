package cosmetic.mem.interest;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import cosmetic.vo.ProductVO;

@WebServlet("/interest/view")
public class InterestedViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String memId = request.getParameter("memId");
		
		IInterestService service = InterestServiceImpl.getInstance();
		
		List<ProductVO> list = service.getInterstList(memId);
		
		Gson gson = new Gson();
		
		String json = gson.toJson(list);
		
		response.setCharacterEncoding("utf-8");
		
		PrintWriter out = response.getWriter();
		response.setContentType("application/json; charset=utf-8");
		out.print(json);
		response.flushBuffer();
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
