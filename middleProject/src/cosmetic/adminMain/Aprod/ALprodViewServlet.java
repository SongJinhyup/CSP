package cosmetic.adminMain.Aprod;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import cosmetic.adminMain.regist.AdminServiceImpl;
import cosmetic.adminMain.regist.IAdminService;
import cosmetic.vo.LprodVO;

@WebServlet("/LprodViewServlet")
public class ALprodViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IAdminService service = AdminServiceImpl.getInstance(); 
		
		List<LprodVO> lprodList = service.getAllLprodList();
//		request.setAttribute("lprodList", lprodList);
		
		System.out.println(lprodList);
		Gson gson = new Gson();
		String jsonData = "";
		
		jsonData = gson.toJson(lprodList);
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=utf-8");
		response.getWriter().print(jsonData);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
