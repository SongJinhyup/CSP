package cosmetic.webmain.board;

import java.util.List;
import java.util.Map;

import cosmetic.vo.BoardVO;

public interface IBoardDao {
	/**
	 * 게시글을 작성하는 메소드
	 * @param vo
	 * @return
	 */
	public int insertBoard(BoardVO vo);
	
	/**
	 * 게시글을 삭제하는 메소드
	 * @param vo
	 * @return
	 */
	public int deleteBoard(String boardId);

	/**
	 * 게시글을 수정하는 메소드
	 * @param vo
	 * @return
	 */
	public int updateBoard(BoardVO vo);
	
	/**
	 * 전체 게시글을 가져오는 메소드
	 * @param board_idx
	 * @return
	 */
	public List<BoardVO> getAllBoard();
	
	/**
	 * 하나의 게시글을 가져올 때 사용하는 메소드
	 * @param boardId
	 * @return
	 */
	public BoardVO getBoard(String boardId);

	/**
	 * 게시글을 검색하는 메소드
	 * @param vo
	 * @return
	 */
	public List<BoardVO> searchBoard(BoardVO vo);
	
	
	/**
	 * 해당 제품의 리뷰를 모두 가져오는 메소드
	 * @param prod_id
	 * @return
	 */
	public List<BoardVO> getAllReview(String prod_id);

	
	/**
	 * 리뷰를 수정하는 메소드
	 * @param vo
	 * @return
	 */
	public int updateReview(BoardVO vo);
	
	/**
	 * 페이징처리를 위한 리뷰수를 구하는 메소드
	 * @param prodId
	 * @return
	 */
	public int countReview(String prodId);

	/**
	 * 페이징처리를 위한 리뷰페이지 수를 구하는 메소드
	 * @param map
	 * @return
	 */
	public List<BoardVO> reviewList(Map<String, Object> map);

	/**
	 * 리뷰작성을 위한 '배송 완료'목록 조회하는 메소드
	 * @param orderMap
	 * @return
	 */
	public int searchOrder(Map<String, String> orderMap);
	
	/**
	 * 작성된 리뷰를 DB에 업로드하는 메소드
	 * @param vo
	 * @return
	 */
	public int insertReview(BoardVO vo);
	
	/**
	 * notice 리스트를 호출하는 메소드
	 * @return
	 */
	public List<BoardVO> getAllNotice();

	/**
	 * notice 게시글을 지우는 메소드
	 * @param board_id
	 * @return
	 */
	public int deleteNotice(String board_id);

	/**
	 * notice 게시글을 등록하는 메소드
	 * @param vo
	 * @return
	 */
	public int insertNotice(BoardVO vo);

	/**
	 * notice 게시글을 수정하는 메소드
	 * @param vo
	 * @return
	 */
	public int updateNotice(BoardVO vo);
	
	/**
	 * notice 수정할 글을 호출하는 메소드
	 * @param board_id
	 * @return
	 */
	public BoardVO getNotice(String board_id);
}
