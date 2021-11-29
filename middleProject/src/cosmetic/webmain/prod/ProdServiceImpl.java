package cosmetic.webmain.prod;

import java.util.List;

import cosmetic.vo.InterestedVO;
import cosmetic.vo.LprodVO;
import cosmetic.vo.ProductVO;
import cosmetic.webmain.prod.IProdDao;
import cosmetic.webmain.prod.IProdService;
import cosmetic.webmain.prod.ProdDaoImpl;

public class ProdServiceImpl implements IProdService {
	private IProdDao dao;
	private  static IProdService service;
	
	private ProdServiceImpl() {
		dao = ProdDaoImpl.getInstance();
	}
	
	public static IProdService getInstance() {
		if(service == null) service = new ProdServiceImpl();
		return service;
	}
	
	
	@Override
	public int insertProd(ProductVO vo) {
		return dao.insertProd(vo);
	}

	@Override
	public int deleteProd(String boardId) {
		return dao.deleteProd(boardId);
	}

	@Override
	public int updateProd(ProductVO vo) {
		
		return dao.updateProd(vo);
	}

	@Override
	public List<ProductVO> getAllProd() {
		return dao.getAllProd();
	}

	@Override
	public ProductVO getProd(String boardId) {
		return dao.getProd(boardId);
	}

	@Override
	public List<LprodVO> getLprod() {
		return dao.getLprod();
	}

	@Override
	public String countCart(String memId) {
		return dao.countCart(memId);
	}

	@Override
	public List<LprodVO> getAllLprod() {
		return dao.getAllLprod();
	}

	@Override
	public int getIntersted(InterestedVO vo) {
		return dao.getIntersted(vo);
	}

}
