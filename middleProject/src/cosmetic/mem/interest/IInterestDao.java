package cosmetic.mem.interest;

import java.util.List;

import cosmetic.vo.InterestedVO;
import cosmetic.vo.ProductVO;

public interface IInterestDao {
	
	/**
	 * 회원의 찜 목록을 가져오는 메소드
	 * @param memId 로그인 세션 아이디
	 * @return
	 */
	List<ProductVO> getInterstList(String memId);
	
	/**
	 * 찜 버튼을 클릭 했을 떄 db interested_item에 데이터가 저장되는 메소드
	 * @param vo
	 * @return
	 */
	public int insertInterest(InterestedVO vo);
	
	/**
	 * 찜버튼을 다시 클릭 했을 때 db에서 데이터를 삭제하는 메소드
	 * @param vo
	 * @return
	 */
	public int deleteInterest(InterestedVO vo);

	/**
	 * 관심 상품 클릭 시 장바구니 테이블에 데이터를 저장하는 메소드
	 * @param vo 로그인 세션 아이디와 관심상품인 상품 아이디를 담고 있
	 */
	public void insertCart(InterestedVO vo);
	
}
