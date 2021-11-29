package cosmetic.cart;

import java.util.List;
import java.util.Map;

import cosmetic.vo.DetailOrderVO;
import cosmetic.vo.MemberVO;
import cosmetic.vo.OrderVO;
import cosmetic.vo.ProductVO;

public interface ICartService {
	/**
	 * 장바구니에 물건을 담았을 때 주문내역테이블에 새로운 주문번호를 저장한느 메소드
	 * @param memId 사용자 아이디
	 * @return 성공 1, 실패 0
	 */
	public int insertCart(String memId);

	
	/**
	 * 회원이 선택한 상품과 주문번호가 상세주문 테이블에 저장되는 메소드
	 * @param vo 상세주문 정보를 담은 vo
	 * @return 성공 1, 실패 0
	 */
	public int insertDeCart(DetailOrderVO vo);

	/**
	 * 장바구니에서 물건을 삭제하면 상세주문 테이블에서 데이터가 삭제되는 메소드
	 * @param vo 장바구니 삭제를 진행하기 위한 주문 번호와 상품번호 
	 * @return 성공 1, 실패 0
	 */
	public int deleteDetailCart(DetailOrderVO vo);

	/**
	 * 상세 주문이 전부 없어질 경우 주문 테이블에서도 주문 내역을 삭제하기 위한 메소드
	 * @param orderId 
	 * @return
	 */
	public int deleteCart(String orderId);


	/**
	 * 장바구니 내역을 보여주는 메소드
	 * @return vo객체의 list의 형태로 반환
	 */
	public List<DetailOrderVO> getCartList(String memId);

	/**
	 * 찜한 상품을 장바구니에 담는 메소드
	 * @param paraMap 로그인한 회원 아이디 세션과 선택한 상품 번호를 저장하고 있는 map
	 * @return 성공 1, 실패 0
	 */
	public int insertInterest(Map<String, String> paraMap);

	/**
	 * 장바구니에 담긴 상품들의 상세정보를 출력하는 메소드
	 * @param memId 로그인한 회원의 아이디 세션
	 * @return
	 */
	public List<ProductVO> getCartProdInfo(String memId);

	/**
	 * 장바구니(주문상태가 null인)의 전체 주문 정보를 가져오는 메소드
	 * @param memId 로그인 세션 아이디
	 * @return
	 */
	public OrderVO getTotalCart(String memId);

	/**
	 * 장바구니에 담긴 상품의 수량이 변경되었을 경우 테이블의 데이터를 update하는 메소드
	 * @param paraMap 회원아이디, 주문정보, 상품 수량이 담긴 Map객체
	 */
	public void updateQtyCart(Map<String, String> paraMap);

	/**
	 * 회원의 쿠폰 목록을 가져오는 메소드
	 * @param memId 로그인 회원 세션
	 * @return
	 */
	public List<MemberVO> getCupon(String memId);

	/**
	 * 마이 페이지의 order에서 선택한 주문의 상세 주문 내역 정볼르출력하는 메소드
	 * @param orderId 선택한 주문번호
	 * @return
	 */
	public List<ProductVO> orderProduct(String orderId);

	/**
	 * 쿠폰 사용시 쿠폰이 삭제되는 메소드
	 */
	public void updateCupon(String memId);

}
