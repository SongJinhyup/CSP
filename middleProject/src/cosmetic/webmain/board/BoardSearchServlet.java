package cosmetic.webmain.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cosmetic.vo.BoardVO;

@WebServlet("/board/boardSearch")
public class BoardSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String searchData = request.getParameter("searchData");
		String searchMenId = request.getParameter("searchmenid");
		
		BoardVO vo = new BoardVO();
		vo.setMem_id(searchMenId);
		vo.setBoard_title(searchData);
		vo.setBoard_content(searchData);
		
		IBoardService service = BoardServiceImpl.getInstance();
		
		List<BoardVO> boardList = service.searchBoard(vo);
		
		request.setAttribute("boardList", boardList);
		
		response.setCharacterEncoding("utf-8");
		
		request.getRequestDispatcher("/WEB-INF/view/QnA/qna_u.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}


}
