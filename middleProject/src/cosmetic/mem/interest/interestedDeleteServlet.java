package cosmetic.mem.interest;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import cosmetic.GetSessionId;
import cosmetic.vo.InterestedVO;

@WebServlet("/interest/delete")
public class interestedDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String memId = GetSessionId.getSessionId(request);
		String prodId = request.getParameter("prod_id");
		
		InterestedVO vo = new InterestedVO();
		vo.setMem_id(memId);
		vo.setProd_id(prodId);
		
		IInterestService service = InterestServiceImpl.getInstance();
		service.deleteInterest(vo);
		
	}
}
