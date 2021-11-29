package cosmetic.webmain.prod;

import java.util.List;

import cosmetic.vo.InterestedVO;
import cosmetic.vo.LprodVO;
import cosmetic.vo.ProductVO;

public interface IProdService {
	public int insertProd(ProductVO vo);
	
	public int deleteProd(String prodId);
	
	public int updateProd(ProductVO vo);
	
	public List<ProductVO> getAllProd();
	
	public ProductVO getProd(String prodId);

	/**
	 * 해당 상품의 Lprod 리스트를 가져오는 메소드
	 * @param list 상품정보가 담긴 list
	 * @return
	 */
	public List<LprodVO> getLprod();
	
	/**
	 * 주문 테이블에 로그인한 회원의 상태가 null인 주문이 존재하는지 검사용 메소드
	 * @param memId 로그인 회원 세션
	 * @return 존재 갯수를 반환한다.
	 */
	public String countCart(String memId);
	
	
	/**
	 * lprod테이블의 모든 데이터를 가져오는 메소드	
	 * @return
	 */
	public List<LprodVO> getAllLprod();

	/**
	 * 해당상품이 회원의 찜목록에 존재하는지 검사하는 메소드
	 * @param prodId 검색하는 상품의 id
	 * @return 존재하면 1, 존재하지 않으면 0
	 */
	public int getIntersted(InterestedVO vo);

}
