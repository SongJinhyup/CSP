package cosmetic.mem.payment;

import java.util.List;

import cosmetic.vo.PayVO;
import cosmetic.vo.ShipVO;

public interface IPaymentService {

	/**
	 * 본인의 결제내역을 출력하는 메소드
	 * @param memId 로그인 세션의 데이터를 입력받는다
	 * @return
	 */
	List<PayVO> viewPaymentList(String memId);
	
	/**
	 * 결제 시 결제 테이블에 데이터가 저장되는 메소드
	 * @param vo 결제한 주문번호, 결제방법이 담긴 vo
	 * @return 성공 1, 실패 0
	 */
	int insertPayment(PayVO vo);

	/**
	 * 주문번호를 입력받아서 결제방법과 결제금액을 출력하는 메소드
	 * @param orderId 주문번호를 입력
	 * @return
	 */
	PayVO getPayInfo(String orderId);

	/**
	 * 결제 성공시 주문 테이블에 '배송준비준' 상태를 넣을 메소드
	 * @param shipVo
	 */
	void insertDelivery(ShipVO shipVo);
}
