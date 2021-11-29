package cosmetic.mem.order;

import java.util.List;
import java.util.Map;

import cosmetic.vo.DetailOrderVO;
import cosmetic.vo.OrderVO;
import cosmetic.vo.RefundVO;
import cosmetic.vo.ShipVO;

public class MemOrderServiceImpl implements IMemOrderService{
	private IMemOrderDao dao;
	private static IMemOrderService service;
	
	private MemOrderServiceImpl() {
		dao = MemOrderDaoImpl.getInstance();
	}
	
	public static IMemOrderService getInstance() {
		if(service == null) service = new MemOrderServiceImpl();
		return service;
	}
	
	
	@Override
	public List<OrderVO> orderList(String memId) {
		return dao.orderList(memId);
	}

	@Override
	public List<DetailOrderVO> detailOrder(String orderId){
		return dao.detailOrder(orderId);
	}

	@Override
	public int insertOrder(String prodId) {
		return dao.insertOrder(prodId);
	}

	@Override
	public int deleteDetailOrder(Map paraMap) {
		return dao.deleteDetailOrder(paraMap);
	}

	@Override
	public int deleteOrder(String orderId) {
		return dao.deleteOrder(orderId);
	}

	@Override
	public int refund(RefundVO vo) {
		return dao.refund(vo);
	}

	@Override
	public ShipVO getDelivery(String orderId) {
		return dao.getDelivery(orderId);
	}

	@Override
	public int cancelOrder(String orderId) {
		return dao.cancelOrder(orderId);
	}

}
