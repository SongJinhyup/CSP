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

@WebServlet("/view/detail1")
public class ViewProductDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		IProdService service = ProdServiceImpl.getInstance();
		InterestedVO vo = new InterestedVO();
		String prodId = request.getParameter("prod_id");
		vo.setProd_id(prodId);
		String memId = GetSessionId.getSessionId(request);
		vo.setMem_id(memId);
		
		
		
		int check = service.getIntersted(vo);
		
		request.setAttribute("check", check);
		request.getRequestDispatcher("/WEB-INF/view/detail/detail1.jsp").forward(request, response);
	}

}
