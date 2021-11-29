package cosmetic.mem.interest;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import cosmetic.ibatis.SqlMapConfig;
import cosmetic.vo.InterestedVO;
import cosmetic.vo.ProductVO;

public class InterestDaoImpl implements IInterestDao{
	private SqlMapClient smc;
	private static IInterestDao dao;
	
	private InterestDaoImpl() {
		smc = SqlMapConfig.getSqlMapClient();
	}
	
	public static IInterestDao getInstance() {
		if(dao == null) dao = new InterestDaoImpl();
		return dao;
	}
	
	@Override
	public List<ProductVO> getInterstList(String memId) {
		List<ProductVO> list = null;
		try {
			list = smc.queryForList("interest.interestList", memId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	@Override
	public int insertInterest(InterestedVO vo) {
		int check = 0;
		try {
			Object insert = smc.insert("interest.insertInterest", vo);
			if(insert == null) {
				check = 1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return check;
	}
	
	@Override
	public int deleteInterest(InterestedVO vo) {
		System.out.println(vo.getMem_id());
		System.out.println(vo.getProd_id());
		int check = 0;
		try {
			check = smc.delete("interest.deleteInterest", vo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return check;
	}

	@Override
	public void insertCart(InterestedVO vo) {
		try {
			smc.insert("interest.insertCart", vo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
