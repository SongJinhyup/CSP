package cosmetic.mem.order;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import cosmetic.ibatis.SqlMapConfig;
import cosmetic.vo.DetailOrderVO;
import cosmetic.vo.OrderVO;
import cosmetic.vo.RefundVO;
import cosmetic.vo.ShipVO;

public class MemOrderDaoImpl implements IMemOrderDao {
	
	private SqlMapClient smc;
	private static IMemOrderDao dao;
	
	private MemOrderDaoImpl() {
		smc = SqlMapConfig.getSqlMapClient();
	}

	public static IMemOrderDao getInstance() {
		if(dao == null) dao = new MemOrderDaoImpl();
		return dao;
	}
	
	@Override
	public List<OrderVO> orderList(String memId) {
		List<OrderVO> list = null;
		try {
			list = smc.queryForList("order.orderList", memId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int insertOrder(String prodId) {
		int insert = 0;
		try {
			insert = (Integer)smc.insert("order.insertOrder", prodId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return insert;
	}

	@Override
	public int deleteDetailOrder(Map paraMap) {
		int delete = 0;
		try {
			delete = smc.delete("order.deletedeOrder", paraMap);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return delete;
		
	}

	@Override
	public List<DetailOrderVO> detailOrder(String orderId) {
		List<DetailOrderVO> list = null;
		try {
			list = smc.queryForList("order.detailOrder", orderId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int deleteOrder(String orderId) {
		int delete = 0;
		try {
			delete = smc.delete("order.deleteOrder", orderId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return delete;
	}

	@Override
	public int refund(RefundVO vo) {
		int insert = 0;
		try {
			Object check = smc.insert("order.insertRefund", vo);
			if(check == null) {
				insert = 1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return insert;
	}

	@Override
	public ShipVO getDelivery(String orderId) {
		ShipVO vo = null;
		try {
			vo = (ShipVO) smc.queryForObject("order.getDelivery", orderId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vo;
	}

	@Override
	public int cancelOrder(String orderId) {
		int update = 0;
		try {
			update = smc.update("order.cancelOrder",orderId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return update;
	}
	
}
