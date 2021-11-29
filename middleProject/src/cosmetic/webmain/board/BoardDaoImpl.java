package cosmetic.webmain.board;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import cosmetic.ibatis.SqlMapConfig;
import cosmetic.vo.BoardVO;

public class BoardDaoImpl implements IBoardDao{
	private SqlMapClient smc;
	private static IBoardDao dao;
	private List<BoardVO> boardList = new ArrayList<>();			// CRUD 반환리스트
	private int cnt = 0;			// CRUD 반환값
	
	private BoardDaoImpl() {
		smc = SqlMapConfig.getSqlMapClient();
	}
	
	public static IBoardDao getInstance() {
		if (dao == null) {
			dao = new BoardDaoImpl();
		}
		return dao;
	}

	@Override
	public int insertBoard(BoardVO vo) {
		try {
			cnt = smc.delete("board.insertBoard", vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int deleteBoard(String boardId) {
		try {
			cnt = smc.delete("board.deleteBoard", boardId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int updateBoard(BoardVO vo) {
		try {
			cnt = smc.update("board.updateBoard", vo);
		} catch (SQLException e) {
			e.printStackTrace();
		};
		return cnt;
	}

	@Override
	public List<BoardVO> getAllBoard() {
		try {
			boardList = smc.queryForList("board.getAllBoard");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return boardList;
	}

	@Override
	public BoardVO getBoard(String boardId) {
		BoardVO vo = new BoardVO();
		try {
			vo = (BoardVO) smc.queryForObject("board.getBoard", boardId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vo;
	}

	@Override
	public List<BoardVO> searchBoard(BoardVO vo) {
		try {
			boardList = smc.queryForList("board.searchBoard", vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return boardList;
	}

	@Override
	public List<BoardVO> getAllReview(String prod_id) {
		try {
			boardList = smc.queryForList("board.getAllReview", prod_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return boardList;
	}

	@Override
	public int updateReview(BoardVO vo) {
		
		try {
			cnt = smc.update("board.updateReview", vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int countReview(String prodId) {
		try {
			 cnt = Integer.valueOf((String) smc.queryForObject("board.countReview", prodId));
			 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public List<BoardVO> reviewList(Map<String, Object> map) {
		try {
			boardList = smc.queryForList("board.reviewList", map);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return boardList;
	}

	@Override
	public int searchOrder(Map<String, String> orderMap) {
		try {
			cnt = Integer.valueOf((String)smc.queryForObject("board.searchOrder", orderMap));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cnt;
	}

	@Override
	public int insertReview(BoardVO vo) {
		try {
			cnt = smc.delete("board.insertReview", vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public List<BoardVO> getAllNotice() {
		try {
			boardList = smc.queryForList("board.getAllNotice");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return boardList;
	}

	@Override
	public int deleteNotice(String board_id) {
		try {
			cnt = smc.delete("board.deleteNotice", board_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int insertNotice(BoardVO vo) {
		try {
			cnt = smc.delete("board.insertNotice", vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int updateNotice(BoardVO vo) {
		try {
			cnt = smc.update("board.updateNotice", vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public BoardVO getNotice(String board_id) {
		BoardVO vo = new BoardVO();
		try {
			vo = (BoardVO) smc.queryForObject("board.getNotice", board_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vo;
	}
}
