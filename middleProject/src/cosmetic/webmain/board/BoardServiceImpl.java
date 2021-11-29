package cosmetic.webmain.board;

import java.util.List;
import java.util.Map;

import cosmetic.vo.BoardVO;

public class BoardServiceImpl implements IBoardService {
	private IBoardDao dao;
	private  static IBoardService service;
	
	private BoardServiceImpl() {
		dao = BoardDaoImpl.getInstance();
	}
	
	public static IBoardService getInstance() {
		if(service == null) service = new BoardServiceImpl();
		return service;
	}

	@Override
	public int insertBoard(BoardVO vo) {
		// TODO Auto-generated method stub
		return dao.insertBoard(vo);
	}

	@Override
	public int deleteBoard(String boardId) {
		// TODO Auto-generated method stub
		return dao.deleteBoard(boardId);
	}

	@Override
	public int updateBoard(BoardVO vo) {
		// TODO Auto-generated method stub
		return dao.updateBoard(vo);
	}

	@Override
	public List<BoardVO> getAllBoard() {
		// TODO Auto-generated method stub
		return dao.getAllBoard();
	}

	@Override
	public BoardVO getBoard(String boardId) {
		// TODO Auto-generated method stub
		return dao.getBoard(boardId);
	}

	@Override
	public List<BoardVO> searchBoard(BoardVO vo) {
		// TODO Auto-generated method stub
		return dao.searchBoard(vo);
	}

	@Override
	public List<BoardVO> getAllReview(String prod_id) {
		// TODO Auto-generated method stub
		return dao.getAllReview(prod_id);
	}

	@Override
	public int updateReview(BoardVO vo) {
		// TODO Auto-generated method stub
		return dao.updateReview(vo);
	}

	@Override
	public int countReview(String prodId) {
		// TODO Auto-generated method stub
		return dao.countReview(prodId);
	}

	@Override
	public List<BoardVO> reviewList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return dao.reviewList(map);
	}

	@Override
	public int searchOrder(Map<String, String> orderMap) {
		// TODO Auto-generated method stub
		return dao.searchOrder(orderMap);
	}

	@Override
	public int insertReview(BoardVO vo) {
		// TODO Auto-generated method stub
		return dao.insertReview(vo);
	}

	@Override
	public List<BoardVO> getAllNotice() {
		// TODO Auto-generated method stub
		return dao.getAllNotice();
	}

	@Override
	public int deleteNotice(String board_id) {
		// TODO Auto-generated method stub
		return dao.deleteNotice(board_id);
	}

	@Override
	public int updateNotice(BoardVO vo) {
		// TODO Auto-generated method stub
		return dao.updateNotice(vo);
	}

	@Override
	public int insertNotice(BoardVO vo) {
		// TODO Auto-generated method stub
		return dao.insertNotice(vo);
	}

	@Override
	public BoardVO getNotice(String board_id) {
		// TODO Auto-generated method stub
		return dao.getNotice(board_id);
	}

	
}
