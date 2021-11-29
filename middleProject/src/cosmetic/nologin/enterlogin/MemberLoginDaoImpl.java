package cosmetic.nologin.enterlogin;

import java.sql.SQLException;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import cosmetic.ibatis.SqlMapConfig;
import cosmetic.vo.MemberVO;

public class MemberLoginDaoImpl implements IMemberLoginDao {
	private SqlMapClient smc;
	private static MemberLoginDaoImpl dao;
	
	private MemberLoginDaoImpl() {
		smc = SqlMapConfig.getSqlMapClient();
		
	}
	
	public static MemberLoginDaoImpl getInstance(){
		if(dao==null) dao = new MemberLoginDaoImpl();
		return dao;
	}


	@Override
	public MemberVO logInMember(MemberVO memvo) {
	
		MemberVO result = null;
		
		try {
			result = (MemberVO) smc.queryForObject("memberLogin.Login",memvo);
			
			
		} catch (SQLException e) {
			result = null;
		}
		System.out.println(result);
		return result;
		
	}

	@Override
	public String findId(Map<String, String> paramap) {
		
		 String result = null;
		
			try {
				result = (String) smc.queryForObject("memberLogin.findId",paramap);
			} catch (SQLException e) {
				result = null;
				e.printStackTrace();
			}
		
		
		return result;
	}

	@Override
	public String findPass(MemberVO membervo) {
		String result = null;

			try {
				result =  (String) smc.queryForObject("memberLogin.findPass",membervo);
			} catch (SQLException e) {
				result = null;
				e.printStackTrace();
			}
			return result;
	}

	
}
