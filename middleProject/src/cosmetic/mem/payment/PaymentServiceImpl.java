package cosmetic.mem.payment;

import java.util.List;

import cosmetic.vo.PayVO;
import cosmetic.vo.ShipVO;

public class PaymentServiceImpl implements IPaymentService{
	private IPaymentDao dao;
	private static IPaymentService service;
	
	private PaymentServiceImpl() {
		dao = PaymentDaoImpl.getInstance();
	}
	
	public static IPaymentService getInstance() {
		if(service == null) service = new PaymentServiceImpl();
		return service;
	}

	@Override
	public List<PayVO> viewPaymentList(String memId) {
		return dao.viewPaymentList(memId);
	}

	@Override
	public int insertPayment(PayVO vo) {
		return dao.insertPayment(vo);
	}

	@Override
	public PayVO getPayInfo(String orderId) {
		return dao.getPayInfo(orderId);
	}

	@Override
	public void insertDelivery(ShipVO shipVo) {
		dao.insertDelivery(shipVo);
	}
	
	
	
	
}
