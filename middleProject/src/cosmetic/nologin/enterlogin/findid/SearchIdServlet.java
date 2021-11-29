package cosmetic.nologin.enterlogin.findid;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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


@WebServlet("/SearchIdServlet")
public class SearchIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");	
		
		String mem_name = request.getParameter("mem_name");
		String mem_tel = request.getParameter("mem_tel");

		Map<String, String> map = new HashMap<String, String>(); 
		map.put("mem_name", mem_name);
		map.put("mem_tel", mem_tel);
		
		IMemberLoginService service = MemberLoginServiceImpl.getInstance();
		String mem_id = service.findId(map);
		System.out.println(mem_id);
		
		if (mem_id != null) { // 일치하는 회원 아이디가 발견됐을때 
			
			request.setAttribute("mem_id", mem_id);
			request.setAttribute("match", "yes");
			
			HttpSession session = request.getSession();
			session.setAttribute("mem_id", mem_id);
			
			RequestDispatcher rd = request.getRequestDispatcher("/idResultServlet");
			rd.forward(request, response);
			
		} else {	// 일치하는 회원 아이디가 발견되지않았을때
			
			request.setAttribute("mem_id", mem_id);
			request.setAttribute("match", "no");

			RequestDispatcher rd = request.getRequestDispatcher("/idResultServlet");
			rd.forward(request, response);
			
		}
		
		
		
		
	}

}
