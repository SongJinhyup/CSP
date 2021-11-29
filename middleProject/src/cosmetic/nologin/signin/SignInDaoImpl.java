package cosmetic.nologin.signin;

import java.sql.SQLException;

import com.ibatis.sqlmap.client.SqlMapClient;

import cosmetic.ibatis.SqlMapConfig;
import cosmetic.vo.MemberVO;

public class SignInDaoImpl implements ISignInDao {
	private SqlMapClient smc;
	private static ISignInDao dao;

	private SignInDaoImpl() {
		smc = SqlMapConfig.getSqlMapClient();
	}

	public static ISignInDao getInstance() {
		if (dao == null)
			dao = new SignInDaoImpl();
		return dao;
	}

	@Override
	public int insertMeber(MemberVO memVo) {
		int check=0;
		
		try {
			Object obj = smc.insert("signup.insertMember", memVo);
			
			if(obj==null) check=1;
		} catch (SQLException e) {
			check =0;
			e.printStackTrace();
		}
		
		return check;
	}

	@Override
	public int countMemeber(String mem_id) {
		int count =0; 
		
		try {
			count = (int) smc.queryForObject("signup.countMemberId",mem_id);
		} catch (SQLException e) {
			count =0;
			e.printStackTrace();
		}
		
		return count;
	}



}
