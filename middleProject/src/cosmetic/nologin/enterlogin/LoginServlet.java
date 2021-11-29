package cosmetic.nologin.enterlogin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

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
import cosmetic.vo.ProductVO;
import cosmetic.webmain.prod.IProdService;
import cosmetic.webmain.prod.ProdServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// 회원 아이디와 패스워드로 로그인
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");

		String mem_id = request.getParameter("mem_id");
		String mem_pass = request.getParameter("mem_pass");

		MemberVO memVo = new MemberVO();

		memVo.setMem_id(mem_id);
		memVo.setMem_pass(mem_pass);

		IMemberLoginService service = MemberLoginServiceImpl.getInstance();

		MemberVO vo = service.logInMember(memVo);

		System.out.println(vo);

		PrintWriter out = response.getWriter();

		// 로그인 실패
		if (mem_id.isEmpty() || mem_pass.isEmpty()) {
			request.setAttribute("login", "no");
			out.println("<script>");
			out.println("alert('입력을 완료하세요');");
			out.println("location.href = '/ShowMainServlet';");
			out.println("</script>");

		} else if (vo == null) {

			request.setAttribute("login", "no");
			out.println("<script>");
			out.println("alert('아이디 또는 비밀번호를 다시 확인해주세요');");
			out.println("location.href = '" + request.getContextPath() + "/ShowMainServlet'");
			out.println("</script>");

			out.close();

		} else if (mem_id.equals("admin") && mem_pass.equals("1234")) {

			HttpSession session = request.getSession();
			session.setAttribute("mem_id", vo.getMem_id());
			session.setMaxInactiveInterval(-1);

			request.setAttribute("login", "yes");

			out.println("<script>");
			out.println("alert('환영합니다 관리자님! 관리자페이지로 이동합니다');");
			out.println("location.href = '" + request.getContextPath() + "/view/AdminHomeMain'");
			out.println("</script>");

		} else {
			HttpSession session = request.getSession();
			session.setAttribute("mem_id", vo.getMem_id());

			session.setMaxInactiveInterval(-1); // 세션의 시간을 무한대로 설정

			request.setAttribute("login", "yes");
			
			String memId = GetSessionId.getSessionId(request);

			IProdService prodService = ProdServiceImpl.getInstance();
			
			String orderId = prodService.countCart(memId);
			
			ICartService cartService = CartServiceImpl.getInstance();
			
			if (orderId == null) {
				cartService.insertCart(memId);
			}

			out.println("<script>");
			out.println("alert('환영합니다!');");
			out.println("location.href = '" + request.getContextPath() + "/ShowMainServlet'");
			out.println("</script>");

			out.close();

		}

	}
}

