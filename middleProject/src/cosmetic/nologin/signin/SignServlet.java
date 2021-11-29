package cosmetic.nologin.signin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cosmetic.GetSessionId;
import cosmetic.cart.CartServiceImpl;
import cosmetic.cart.ICartService;
import cosmetic.vo.MemberVO;
import cosmetic.webmain.prod.IProdService;
import cosmetic.webmain.prod.ProdServiceImpl;

/**
 * Servlet implementation class SignServlet
 */
@WebServlet("/SignServlet")
public class SignServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	
	// 회원가입 -> singup.xml과 연결 
	// 회원가입시 받을 정보 -> 이름, 아이디, 비밀번호
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String mem_name = request.getParameter("mem_name");
		String mem_id = request.getParameter("mem_id");
		String mem_pass = request.getParameter("mem_pass");
		
		int n = 4; // n자리 쿠폰
		char[] chs = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S',
				'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
		
		Random rd = new Random();
		
		StringBuilder sb = new StringBuilder();
		

		for (int j = 0; j < n; j++) {
			for (int i = 0; i < n; i++) {
				char ch = chs[rd.nextInt(chs.length)];
				sb.append(ch);
			}
			if(j < 3) {
				sb.append("-");
				System.out.println(sb);
			}
		}
		
		
		MemberVO memVo = new MemberVO();
		
		memVo.setMem_name(mem_name);
		memVo.setMem_id(mem_id);
		memVo.setMem_pass(mem_pass);
		memVo.setMem_cupon(sb.toString());
		
		ISignInService service = SignInServiceImpl.getInstance();
		int cnt= service.insertMeber(memVo);

		PrintWriter out = response.getWriter();

		// 회원가입 실패 
		if (cnt == 0) {
			request.setAttribute("join", "no");
			out.println("<script>");
			out.println("alert('입력을 완료하세요');");
			out.println("location.href = '"+request.getContextPath()+"/showlogin'");
			out.println("</script>");
			out.close();
			
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("mem_name", memVo.getMem_name());
			session.setAttribute("mem_id", memVo.getMem_id());
			session.setAttribute("mem_pass", memVo.getMem_pass());
			
			request.setAttribute("mem_name", memVo.getMem_name());
			request.setAttribute("mem_id", memVo.getMem_id());
			request.setAttribute("mem_pass", memVo.getMem_pass());
			request.setAttribute("join", "yes");
			
			out.println("<script>");
			out.println("alert('회원가입 성공!');");
			out.println("alert('회원가입 쿠폰이 생성되었습니다');");
			out.println("location.href = '"+request.getContextPath()+"/ShowMainServlet'");
			out.println("</script>");
			
			String memId = GetSessionId.getSessionId(request);

			IProdService prodService = ProdServiceImpl.getInstance();
			
			String orderId = prodService.countCart(memId);
			
			ICartService cartService = CartServiceImpl.getInstance();
			
			if (orderId == null) {
				cartService.insertCart(memId);
			}

			
			out.close();
		}
	}

}
