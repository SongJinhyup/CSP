package cosmetic.webmain.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cosmetic.vo.BoardVO;

@WebServlet("/review/reviewInsert")
public class ReviewInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.setCharacterEncoding("utf-8");
		
		String board_index = request.getParameter("board_index");
		String prod_id = request.getParameter("prod_id");
		String mem_id = request.getParameter("mem_id");
		String board_secrete = request.getParameter("board_secrete");
		String board_content = request.getParameter("board_content");
		
		BoardVO vo = new BoardVO();
		
		vo.setBoard_index(board_index);
		vo.setProd_id(prod_id);
		vo.setMem_id(mem_id);
		vo.setBoard_secrete(board_secrete);
		vo.setBoard_content(board_content);

		System.out.println(vo.getBoard_index());
		System.out.println(vo.getProd_id());
		System.out.println(vo.getMem_id());
		System.out.println(vo.getBoard_secrete());
		System.out.println(vo.getBoard_content());
		
		IBoardService service = BoardServiceImpl.getInstance();
		
		int cnt = service.insertReview(vo);
		
		System.out.println(cnt);
		
		
		response.sendRedirect(request.getContextPath() + "/review/reviewList");

	}

}
