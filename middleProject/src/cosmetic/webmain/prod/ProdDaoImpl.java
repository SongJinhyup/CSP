package cosmetic.webmain.prod;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import cosmetic.ibatis.SqlMapConfig;
import cosmetic.vo.InterestedVO;
import cosmetic.vo.LprodVO;
import cosmetic.vo.ProductVO;

public class ProdDaoImpl implements IProdDao {
	private SqlMapClient smc;
	private static IProdDao dao;
	
	private ProdDaoImpl() {
		smc = SqlMapConfig.getSqlMapClient();
	}
	
	public static IProdDao getInstance() {
		if(dao == null) dao = new ProdDaoImpl();
		return dao;
	}
	
	
	@Override
	public int insertProd(ProductVO vo) {
		int result = 0;
		try {
			result = (int)smc.insert("prod.insertProd",vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int deleteProd(String prodId) {
		int result = 0;
		try {
			result = smc.delete("prod.deleteProd", prodId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int updateProd(ProductVO vo) {
		int result = 0;
		try {
			result = smc.update("prod.prodUpdate", vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<ProductVO> getAllProd() {
		List<ProductVO> list = null;
		try {
			list = smc.queryForList("prod.getAllProd");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public ProductVO getProd(String prodId) {
		ProductVO vo = null;
		try {
			vo = (ProductVO) smc.queryForObject("prod.getProd",prodId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vo;
	}

	@Override
	public List<LprodVO> getLprod() {
		List<LprodVO> list = null;
		try {
			list = smc.queryForList("prod.getLprod");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;	}

	@Override
	public String countCart(String memId) {
		String count = null;
		try {
			count = (String)smc.queryForObject("prod.countCart", memId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public List<LprodVO> getAllLprod() {
		List<LprodVO> list = null;
		try {
			list = smc.queryForList("prod.getAllLprod");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int getIntersted(InterestedVO vo) {
		int i = 0;
		try {
			i = (Integer)smc.queryForObject("prod.getIntersted", vo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

}
