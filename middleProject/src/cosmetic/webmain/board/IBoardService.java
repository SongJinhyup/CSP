package cosmetic.webmain.board;

import java.util.List;
import java.util.Map;

import cosmetic.vo.BoardVO;

public interface IBoardService {
	public int insertBoard(BoardVO vo);
	
	public int deleteBoard(String prodId);
	
	public int updateBoard(BoardVO vo);
	
	public List<BoardVO> getAllBoard();
	
	public BoardVO getBoard(String prodId);

	public List<BoardVO> searchBoard(BoardVO vo);

	public List<BoardVO> getAllReview(String prod_id);

	public int updateReview(BoardVO vo);

	public int countReview(String prodId);

	public List<BoardVO> reviewList(Map<String, Object> map);

	public int searchOrder(Map<String, String> orderMap);

	public int insertReview(BoardVO vo);

	public List<BoardVO> getAllNotice();

	public int deleteNotice(String board_id);

	public int updateNotice(BoardVO vo);

	public int insertNotice(BoardVO vo);

	public BoardVO getNotice(String board_id);
	
}
