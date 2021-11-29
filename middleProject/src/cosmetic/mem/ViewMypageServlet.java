package cosmetic.mem;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cosmetic.GetSessionId;
import cosmetic.mem.interest.IInterestService;
import cosmetic.mem.interest.InterestServiceImpl;
import cosmetic.vo.ProductVO;

@WebServlet("/view/myPage")
public class ViewMypageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String memId = GetSessionId.getSessionId(request);
		
		IInterestService service = InterestServiceImpl.getInstance();
		List<ProductVO> list = service.getInterstList(memId);
		
		request.setAttribute("interest", list);
		response.setCharacterEncoding("utf-8");
		request.getRequestDispatcher("/WEB-INF/view/mypage/mypage.jsp").forward(request, response);;
	}


}
