package cosmetic.mem.info;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import cosmetic.vo.MemberVO;

@WebServlet("/member/passUpdate")
public class MemberPassUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String memId = request.getParameter("memId");
		String memPass = request.getParameter("memPass");
		
		MemberVO vo = new MemberVO();
		
		vo.setMem_id(memId);
		vo.setMem_pass(memPass);
		
		System.out.println(vo);
		
		IMemberInfoDao service = MemberInfoDaoImpl.getInstance();
		int check = service.passUpdate(vo);
		String json = new Gson().toJson(check);
		
		response.setContentType("application/json; charset=utf-8");
		response.getWriter().print(json);
		response.flushBuffer();
	}


}
