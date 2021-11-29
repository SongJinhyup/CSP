package cosmetic.mem.info;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import cosmetic.GetSessionId;
import cosmetic.vo.MemberVO;

@WebServlet("/member/getInfo")
public class MeberGetInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String memId = GetSessionId.getSessionId(request);
		
		IMemberInfoService service = MemberInfoServiceImpl.getInstance();
		
		MemberVO vo = service.getInfo(memId);
		
		String json = new Gson().toJson(vo);
		
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
