package cosmetic.adminMain.regist;

import java.util.List;
import java.util.Map;


import cosmetic.vo.AdminVO;
import cosmetic.vo.LprodVO;
import cosmetic.vo.MemberVO;
import cosmetic.vo.ProductVO;

public interface IAdminDao {
	
// 회원	
	/**
	 * 선택한 회원 조회 메소드
	 * @param id
	 * @return
	 */
	public List<MemberVO> selectMember(String mem_id);
	
	/**
	 * 회원 전체 조회 메소드
	 * @return
	 */
	public List<MemberVO> getAllMemberList();
	
	/**
	 * 회원 정보 삭제 메소드
	 * @param mem_Id
	 * @return
	 */
	public int deleteMember(String mem_id);
	
	
//	/**
//	 * 회원 Id를 매개변수로 받아서 해당 회원 ID의 정보를 가져오는 메서드
//	 * @param mem_id
//	 * @return
//	 */
//	public AdminVO getMember(String mem_id);
	

// 블랙리스트
	/**
	 * 블랙리스트 전체 조회 메소드
	 * @param mem_id
	 * @return
	 */
	public List<AdminVO> getAllBlackList();

	/**
	 * 블랙리스트 추가 메소드
	 * @param mem_Id
	 * @return
	 */
	public int updateBlackList(String mem_id);
	
	/**
	 * 블랙리스트 삭제 메소드
	 * @param mem_id
	 * @return
	 */
	public int deleteBlackList(String mem_id);
	
	
	
// 상품 재고
	/**
	 * 선택된 상품 재고 조회 메소드
	 * @param prod_id
	 * @return
	 */
	public List<ProductVO> selectProdStock(String prod_id);
	
	/**
	 * 전체 상품 재고 조회 메소드
	 * @return
	 */
	public List<ProductVO> getAllProdStock();
	
	/**
	 * 상품 재고 수량 업데이트 메소드
	 * @param prod_id
	 * @return
	 */
	public int updateProdStock(ProductVO productVo);
	


// 상품 카테고리	
	/**
	 * 하나의 상품 카테고리만 보여주는 메소드 
	 * @param lprod_id
	 * @return
	 */
	public List<LprodVO> selectLprod(String lprod_id);
	
	/**
	 * 상품 카테코리 전체 출력 메소드
	 * @return
	 */
	public List<LprodVO> getAllLprodList();
	
	/**
	 * 상품카테고리 수정 메소드
	 * @param lprodVo
	 * @return
	 */
	public int updateLprod(LprodVO lprodVo);
	
	/**
	 * 상품카테고리 삭제 메소드
	 * @param lprod_id
	 * @return
	 */
	public int deleteLprod(String lprod_id);

	/**
	 * 상품카테고리 추가 메소드
	 * @param lprodVo
	 * @return
	 */
	public int insertLprod(String lprod_type);
	
//	/**
//	 * 상품 분류 ID를 매개변수로 받아서 카테고리 ID의 정보를 가져오는 메서드
//	 * @param lprod_id
//	 * @return
//	 */
//	public LprodVO getLprod(String lprod_id);

	
	
	
// 상품 관리
	/**
	 * 선택된 상품 조회 메소드
	 * @param prod_id
	 * @return
	 */
	public List<ProductVO> selectProd(String prod_id);
	
	/**
	 *	상품 전체조회 메소드
	 */
	public List<ProductVO> getAllProd();
	
	public ProductVO getProd(String prodId);

	/**
	 * 해당 상품의 Lprod 리스트를 가져오는 메소드
	 * @param list 상품정보가 담긴 list
	 * @return
	 */
	public List<LprodVO> getLprod();
	
	/**
	 * 원하는 상품 수정 메소드
	 * @param prodVo
	 * @return
	 */
	public int updateProd(ProductVO prodVo);
	
	/**
	 * 상품 삭제 메소드
	 * @param prod_id
	 * @return
	 */
	public int deleteProd(String prod_id);
	
	/**
	 * 등록 상품 추가 메소드
	 * @param prodVO
	 * @return
	 */
	public int insertProd(ProductVO prodVo);
	
//	/**
//	 * 상품 ID를 매개변수로 받아서 해당 상품ID의 정보를 가져오는 메서드
//	 * @param prod_id
//	 * @return
//	 */
//	public ProdVO getProd(String prod_id);
}
