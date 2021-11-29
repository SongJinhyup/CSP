package cosmetic.cart;

import java.util.List;
import java.util.Map;

import cosmetic.vo.DetailOrderVO;
import cosmetic.vo.MemberVO;
import cosmetic.vo.OrderVO;
import cosmetic.vo.ProductVO;

public class CartServiceImpl implements ICartService{
	private ICartDao dao;
	private static ICartService service;
	
	private CartServiceImpl() {
		dao = CartDaoImpl.getInstance();
	}
	
	public static ICartService getInstance() {
		if(service == null) service = new CartServiceImpl();
		return service;
	}

	@Override
	public int insertCart(String memId) {
		return dao.insertCart(memId);
	}

	@Override
	public int insertDeCart(DetailOrderVO vo) {
		return dao.insertDeCart(vo);
	}

	@Override
	public int deleteDetailCart(DetailOrderVO vo) {
		return dao.deleteDetailCart(vo);
	}

	@Override
	public int deleteCart(String orderId) {
		return dao.deleteCart(orderId);
	}

	@Override
	public List<DetailOrderVO> getCartList(String orderId) {
		return dao.getCartList(orderId);
	}

	@Override
	public int insertInterest(Map<String, String> paraMap) {
		return dao.insertInterest(paraMap);
	}

	@Override
	public List<ProductVO> getCartProdInfo(String memId) {
		return dao.getCartProdInfo(memId);
	}

	@Override
	public OrderVO getTotalCart(String memId) {
		return dao.getTotalCart(memId);
	}

	@Override
	public void updateQtyCart(Map<String, String> paraMap) {
		dao.updateQtyCart(paraMap);
	}

	@Override
	public List<MemberVO> getCupon(String memId) {
		return dao.getCupon(memId);
	}

	@Override
	public List<ProductVO> orderProduct(String orderId) {
		return dao.orderProduct(orderId);
	}

	@Override
	public void updateCupon(String memId) {
		dao.updateCupon(memId);
		
	}
}
