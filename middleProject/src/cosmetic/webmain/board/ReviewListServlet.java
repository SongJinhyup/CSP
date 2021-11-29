package cosmetic.webmain.board;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cosmetic.vo.BoardVO;
@WebServlet("/12dh2h29dh2j232311212")
public class ReviewListServlet extends HttpServlet {
	//사용하지 않는 서블릿
//	private static final long serialVersionUID = 1L;
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("utf-8");
//		
//		String prod_id = request.getParameter("prod_id");
//		
//		if (prod_id == null) {
//			prod_id = "P011";
//		}
//		
//		IBoardService service = BoardServiceImpl.getInstance();
//		
//		List<BoardVO> reviewList = service.getAllReview(prod_id);
//
//		request.setAttribute("reviewList", reviewList);
//		
//		request.getRequestDispatcher("/WEB-INF/view/review/review.jsp").forward(request, response);
//		
//	}
//
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doGet(request, response);
//		
//		
//	}

}
