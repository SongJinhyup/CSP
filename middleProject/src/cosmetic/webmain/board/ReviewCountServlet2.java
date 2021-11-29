package cosmetic.webmain.board;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cosmetic.vo.BoardVO;

@WebServlet("/review/reviewList2")
public class ReviewCountServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String page = request.getParameter("page");
		String memId = request.getParameter("mem_id");
		String prodId = request.getParameter("prod_id");
		
		int spage; //현재 페이지
		if (page == null ) {
			spage = 1;
		} else {
			spage = Integer.parseInt(page);
		}
		
		//------------------테스트용---------------------
		if (prodId == null) {
			System.out.println("널값이 들어왔네잉..");
			prodId = "P002";
		} else {
			System.out.println("겟파라메터로 값 잘 불러옴" + prodId);
		}
		
		if (memId == null) {
			System.out.println("아이디도 널값");
			memId = "a002";
		} else {
			System.out.println("아이디는" + memId);
		}
		//---------------끝나면 지우기---------------------
		
		IBoardService service = BoardServiceImpl.getInstance();
		
		
		//====================여기서부터 페이징처리 시작
		//1. 전체 글 갯수 조회
		int count = service.countReview(prodId);
		System.out.println("전체리뷰수" + count);
		//2. 전체 페이지수를 정한다.
		int perList = 6;	//한 화면에 출력할 리뷰수는 6개
		//따라서 전체페이지수는 그걸 나누어서 인트로 강제캐스팅한 값
		int ttpage = (int) Math.ceil((double)count/perList);
		System.out.println("전체페이지" +ttpage);
		//3.현재 페이지와 마지막 페이지 번호를 정한다.
		//한 화면 리뷰수가 6개니까.. 첨엔 1~6, 두번째는 7~12 이런식으로!
		int start = (spage - 1) * perList + 1;
		int end = start + perList - 1;
		Map<String, Object> pagingMap = new HashMap<>();
		
		pagingMap.put("start", start);
		pagingMap.put("end", end);
		pagingMap.put("prod_id", prodId);
		//=================여기까지가 paging finish! and setattribute!
		
		//리뷰내용을 6개 단위로 담기
		List<BoardVO> list = service.reviewList(pagingMap);
		request.setAttribute("reviewList", list);
		request.setAttribute("start", spage);
		request.setAttribute("ttpage", ttpage);
		request.setAttribute("prod_id", prodId);
		//담아서 넘겨줄 준비 끝!!
		
		//리뷰작성을 위한 서비스 호출
		Map<String, String> orderMap = new HashMap<>();
		orderMap.put("mem_id", memId);
		orderMap.put("prod_id", prodId);
		int orderCnt = service.searchOrder(orderMap);
		System.out.println("주문했니?" + orderCnt);
		
		request.setAttribute("ordercnt", orderCnt);
		
		request.getRequestDispatcher("/WEB-INF/view/review/review2.jsp").forward(request, response);
		
		//service종류 : 리뷰 전체 개수 조회(페이징처리)/ 리뷰전체출력 / 리뷰작성용 조회
		
	
		
		
	}


}
