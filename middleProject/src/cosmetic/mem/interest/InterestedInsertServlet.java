package cosmetic.mem.interest;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cosmetic.vo.InterestedVO;

@WebServlet("/interest/insert")
public class InterestedInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String prodId = request.getParameter("prodId");
		System.out.println(prodId);
		HttpSession session = request.getSession();
		
		String memId = (String) session.getAttribute("mem_id");
		
		InterestedVO vo = new InterestedVO();
		vo.setProd_id(prodId);
		vo.setMem_id(memId);
		
		IInterestService service = InterestServiceImpl.getInstance();
		
		service.insertInterest(vo);
	}

}
