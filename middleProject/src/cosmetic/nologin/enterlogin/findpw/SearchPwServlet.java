package cosmetic.nologin.enterlogin.findpw;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cosmetic.nologin.enterlogin.IMemberLoginService;
import cosmetic.nologin.enterlogin.MemberLoginServiceImpl;
import cosmetic.vo.MemberVO;
import oracle.net.aso.r;

@WebServlet("/SearchPwServlet")
public class SearchPwServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
	
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");	
		
		String mem_name = request.getParameter("mem_name");
		String mem_id = request.getParameter("mem_id");
		String mem_tel = request.getParameter("mem_tel");
		
		MemberVO vo = new MemberVO();
		
		vo.setMem_name(mem_name);
		vo.setMem_id(mem_id);
		vo.setMem_tel(mem_tel);
	
		IMemberLoginService service = MemberLoginServiceImpl.getInstance();
		String mem_pass = service.findPass(vo);		
		
		if (mem_pass != null) {
			
			request.setAttribute("mem_pass", mem_pass);
			request.setAttribute("match", "yes");

			HttpSession session = request.getSession();
			session.setAttribute("mem_pass", mem_pass);
			
			RequestDispatcher rd = request.getRequestDispatcher("/passResultServlet");
			rd.forward(request, response);

		} else {
			
			request.setAttribute("mem_pass", mem_pass);
			request.setAttribute("match", "no");
			RequestDispatcher rd = request.getRequestDispatcher("/passResultServlet");
			rd.forward(request, response);

			
		}
		
	}

}
