package cosmetic.mem.payment;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import cosmetic.ibatis.SqlMapConfig;
import cosmetic.vo.PayVO;
import cosmetic.vo.ShipVO;

public class PaymentDaoImpl implements IPaymentDao{
	private static IPaymentDao dao;
	private SqlMapClient smc;
	
	private PaymentDaoImpl() {
		smc = SqlMapConfig.getSqlMapClient();
	}
	
	public static IPaymentDao getInstance() {
		if(dao == null) dao = new PaymentDaoImpl();
		return dao;
	}

	@Override
	public List<PayVO> viewPaymentList(String memId) {
		List<PayVO> list = null;
		try {
			list = smc.queryForList("payment.viewList", memId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int insertPayment(PayVO vo) {
		int check = 0;
		try {
			Object insert = smc.insert("payment.insertPayment",vo);
			if(insert == null) check = 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return check;
	}

	@Override
	public PayVO getPayInfo(String orderId) {
		PayVO vo = null;
		try {
			vo = (PayVO) smc.queryForObject("payment.getPayInfo", orderId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vo;
	}

	@Override
	public void insertDelivery(ShipVO shipVo) {
		try {
			smc.insert("payment.insertDelivery",shipVo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
