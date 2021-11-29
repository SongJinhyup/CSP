package cosmetic.webmain.prod;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cosmetic.GetSessionId;
import cosmetic.vo.InterestedVO;

@WebServlet("/view/detail3")
public class ViewProductDetailServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		IProdService service = ProdServiceImpl.getInstance();
		InterestedVO vo = new InterestedVO();
		vo.setProd_id(request.getParameter("prod_id"));
		HttpSession session = request.getSession();
		String memId = GetSessionId.getSessionId(request);
		vo.setMem_id(memId);
		int check = service.getIntersted(vo);
		
		request.setAttribute("check", check);
		request.getRequestDispatcher("/WEB-INF/view/detail/detail3.jsp").forward(request, response);;
		
	}

}
