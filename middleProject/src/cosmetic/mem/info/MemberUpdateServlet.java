package cosmetic.mem.info;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import cosmetic.vo.MemberVO;

/**
 * Servlet implementation class MemberUpdateServlet
 */
@WebServlet("/member/infoUpdate")
public class MemberUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String memId = request.getParameter("memId");
		String memTel = request.getParameter("tel");
		String memBirth = request.getParameter("birth");
		String memEmail = request.getParameter("email");
		String location = request.getParameter("location");
		
		System.out.println(memId);
		
		IMemberInfoDao service = MemberInfoDaoImpl.getInstance();
		
		MemberVO vo = new MemberVO();

		vo.setMem_id(memId);
		vo.setMem_tel(memTel);
		vo.setMem_birth(memBirth);
		vo.setMem_email(memEmail);
		vo.setMem_blocation(location);
		
		System.out.println(vo.toString());
		
		int check = service.infoUpdate(vo);
		
		String json = new Gson().toJson(check);
		System.out.println(json);
		PrintWriter out = response.getWriter();
		response.setContentType("application/json; charset=utf-8");
		out.print(json);
		response.flushBuffer();
	}


}
