package cosmetic.adminMain.regist;

import java.util.List;

import cosmetic.vo.AdminVO;
import cosmetic.vo.LprodVO;
import cosmetic.vo.MemberVO;
import cosmetic.vo.ProductVO;
import cosmetic.webmain.board.BoardServiceImpl;

public class AdminServiceImpl implements IAdminService{
	private IAdminDao adminDao;
	private static AdminServiceImpl service;
	
	private AdminServiceImpl() {
		adminDao = AdminDaoImpl.getInstance();
	}
	
	public static AdminServiceImpl getInstance() {
		if(service==null) service = new AdminServiceImpl();
		return service;
	}

	@Override
	public List<MemberVO> selectMember(String mem_id) {
		return adminDao.selectMember(mem_id);
	}

	@Override
	public List<MemberVO> getAllMemberList() {
		return adminDao.getAllMemberList();
	}

	@Override
	public int deleteMember(String mem_id) {
		return adminDao.deleteMember(mem_id);
	}

	@Override
	public List<AdminVO> getAllBlackList() {
		return adminDao.getAllBlackList();
	}

	@Override
	public int updateBlackList(String mem_id) {
		return adminDao.updateBlackList(mem_id);
	}

	@Override
	public int deleteBlackList(String mem_id) {
		return adminDao.deleteBlackList(mem_id);
	}

	@Override
	public List<ProductVO> selectProdStock(String prod_id) {
		return adminDao.selectProdStock(prod_id);
	}

	@Override
	public List<ProductVO> getAllProdStock() {
		return adminDao.getAllProdStock();
	}

	@Override
	public int updateProdStock(ProductVO productVo) {
		return adminDao.updateProdStock(productVo);
	}

	@Override
	public List<LprodVO> selectLprod(String lprod_id) {
		return adminDao.selectLprod(lprod_id);
	}

	@Override
	public List<LprodVO> getAllLprodList() {
		return adminDao.getAllLprodList();
	}

	@Override
	public int updateLprod(LprodVO lprodVo) {
		return adminDao.updateLprod(lprodVo);
	}

	@Override
	public int deleteLprod(String lprod_type) {
		return adminDao.deleteLprod(lprod_type);
	}

	@Override
	public int insertLprod(String lprod_type) {
		return adminDao.insertLprod(lprod_type);
	}

	@Override
	public List<ProductVO> selectProd(String prod_id) {
		return adminDao.selectProd(prod_id);
	}

	@Override
	public List<ProductVO> getAllProd() {
		return adminDao.getAllProd();
	}

	@Override
	public int updateProd(ProductVO prodVo) {
		return adminDao.updateProd(prodVo);
	}

	@Override
	public int deleteProd(String prod_id) {
		return adminDao.deleteProd(prod_id);
	}

	@Override
	public int insertProd(ProductVO prodVo) {
		return adminDao.insertProd(prodVo);
	}
	
	@Override
	public ProductVO getProd(String boardId) {
		return adminDao.getProd(boardId);
	}

	@Override
	public List<LprodVO> getLprod() {
		return adminDao.getLprod();
	}
	

}
