package cosmetic.adminMain.regist;

import java.util.List;

import cosmetic.vo.AdminVO;
import cosmetic.vo.LprodVO;
import cosmetic.vo.MemberVO;
import cosmetic.vo.ProductVO;

public interface IAdminService {

		public List<MemberVO> selectMember(String mem_id);
		
		public List<MemberVO> getAllMemberList();
	
		public int deleteMember(String mem_id);

		public List<AdminVO> getAllBlackList();

		public int updateBlackList(String mem_id);
		
		public int deleteBlackList(String mem_id);
		
		public List<ProductVO> selectProdStock(String prod_id);

		public List<ProductVO> getAllProdStock();

		public int updateProdStock(ProductVO productVo);

		public List<LprodVO> selectLprod(String lprod_id);
		
		public List<LprodVO> getAllLprodList();
		
		public int updateLprod(LprodVO lprodVo);

		public int deleteLprod(String lprod_type);

		public int insertLprod(String lprod_type);

		public List<ProductVO> selectProd(String prod_id);

		public List<ProductVO> getAllProd();

		public int updateProd(ProductVO ProductVO);
		
		public int deleteProd(String prod_id);
		
		public int insertProd(ProductVO ProductVO);
		
		public ProductVO getProd(String prodId);

		/**
		 * 해당 상품의 Lprod 리스트를 가져오는 메소드
		 * @param list 상품정보가 담긴 list
		 * @return
		 */
		public List<LprodVO> getLprod();
}
