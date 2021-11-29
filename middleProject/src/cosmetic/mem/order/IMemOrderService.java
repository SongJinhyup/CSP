package cosmetic.mem.order;

import java.util.List;
import java.util.Map;

import cosmetic.vo.DetailOrderVO;
import cosmetic.vo.OrderVO;
import cosmetic.vo.RefundVO;
import cosmetic.vo.ShipVO;

public interface IMemOrderService {
	/**
	 * 마이페이지에서 본인의 주문내역을 확인하는 메소드
	 * @param memId 로그인한 아이디 데이터를 세션으로 받아와서 입력
	 * @return 주문 내역vo list의 형태로 받아온다.
	 */
	public List<OrderVO> orderList(String memId);
	
	/**
	 * 주문 상세 정보를 조회하는 메소드 
	 * @param orderId 조회하려는 주문내역의 주문 번호
	 * @return 상세주문vo의 리스트를 반환받는다.
	 */
	public List<DetailOrderVO> detailOrder(String orderId);

	/**
	 * 상품주문을 실행하고 db에 주문내역을 저장하는 메소드
	 * @param prodId 주문하려는 상품의 id를 매개변수로 받아온다.
	 * @return 성공시 1, 실패시 0
	 */
	public int insertOrder(String prodId);
	
	/**
	 * 상품 주문을 취소하면 상세 주문내역이 삭제되는 메소드
	 * @param paraMap 주문내역번호와 삭제하려는 상품의 번호
	 * @return 성공시 1, 실패시 0
	 */
	public int deleteDetailOrder(Map paraMap);
	
	
	/**
	 * 상세주문(장바구니)목록이 전부 지워지면  회원 주문 내역을 삭제하는 메소드
	 * @param orderId 삭제하려는 주문번호
	 * @return 성공시 1, 실패시 0
	 */
	public int deleteOrder(String orderId);

	
	/**
	 * 회원이 환불 요청을 했을 경우 환불요청한 주문내역과 상품 번호를 환불테이블에 저장하는
	 * 메소드
	 * @param 환불신청하는 주문 번화와 환불하려는 상품 번호
	 * @return 성공시 1, 실패시 0
	 */
	public int refund(RefundVO vo);

	/**
	 * 주문 내역 선택시 배송현황을 조회하는 메소드
	 * @param orderId 선택한 주문내역의 주문 번호
	 * @return 배송 vo를 반환
	 */
	public ShipVO getDelivery(String orderId);

	
	/**
	 * 회원이 주문 취소요청을 하는 메소드
	 * @param orderId 취소를 진행하는 주문내역 번호
	 * @return 성공시 1, 실패시 0
	 */
	public int cancelOrder(String orderId);

	
}
