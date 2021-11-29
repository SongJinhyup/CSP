package cosmetic.cart;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.xml.soap.Detail;

import com.ibatis.sqlmap.client.SqlMapClient;

import cosmetic.ibatis.SqlMapConfig;
import cosmetic.vo.DetailOrderVO;
import cosmetic.vo.MemberVO;
import cosmetic.vo.OrderVO;
import cosmetic.vo.ProductVO;

public class CartDaoImpl implements ICartDao {
	private SqlMapClient smc;
	private static ICartDao dao;

	private CartDaoImpl() {
		smc = SqlMapConfig.getSqlMapClient();
	}

	public static ICartDao getInstance() {
		if (dao == null)
			dao = new CartDaoImpl();
		return dao;
	}

	@Override
	public int insertCart(String memId) {
		int check = 0;
		try {
			String insert = (String) smc.insert("cart.insertCart", memId);
			if (insert == null)
				check = 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return check;
	}

	@Override
	public int insertDeCart(DetailOrderVO vo) {
		int check = 0;
		try {
			Object insert = smc.insert("cart.insertDeCart", vo);
			if (insert == null)
				check = 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return check;
	}

	@Override
	public int deleteDetailCart(DetailOrderVO vo) {
		int delete = 0;
		try {
			delete = smc.delete("cart.deleteDetailCart", vo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return delete;
	}

	@Override
	public List<DetailOrderVO> getCartList(String memId) {
		List<DetailOrderVO> list = null;
		try {
			list = smc.queryForList("cart.getCartList", memId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int deleteCart(String orderId) {
		int delete= 0;
		try {
			delete = smc.delete("cart.deleteCart", orderId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return delete;
	}

	@Override
	public int insertInterest(Map<String, String> paraMap) {
		int check = 0;
		try {
			Object insert = smc.insert("cart.insertInter", paraMap);
			check = 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return check;
	}

	@Override
	public List<ProductVO> getCartProdInfo(String memId) {
		List<ProductVO> list = null;
		try {
			list = smc.queryForList("cart.getCartProd",memId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public OrderVO getTotalCart(String memId) {
		OrderVO vo = null;
		try {
			vo = (OrderVO) smc.queryForObject("cart.getTotalCart", memId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vo;
	}

	@Override
	public void updateQtyCart(Map paraMap) {
		try {
			smc.update("cart.updateQtyCart", paraMap);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<MemberVO> getCupon(String memId) {
		List<MemberVO> list = null;
		try {
			list = smc.queryForList("memberInfo.getInfo",memId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<ProductVO> orderProduct(String orderId) {
		List<ProductVO> list = null;
		try {
			list = smc.queryForList("cart.getOrderProduct", orderId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public void updateCupon(String memId) {
		try {
			smc.update("cart.cuponUpdate", memId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
