package cosmetic.mem.info;

import java.sql.SQLException;

import com.ibatis.sqlmap.client.SqlMapClient;

import cosmetic.ibatis.SqlMapConfig;
import cosmetic.vo.MemberVO;

public class MemberInfoDaoImpl implements IMemberInfoDao{
	private SqlMapClient smc;
	private static IMemberInfoDao dao;
	
	private MemberInfoDaoImpl() {
		smc = SqlMapConfig.getSqlMapClient();
	}
	
	public static IMemberInfoDao getInstance() {
		if(dao == null) dao = new MemberInfoDaoImpl();
		return dao;
	}
	
	@Override
	public int infoUpdate(MemberVO vo) {
		int check = 0;
		try {
			check = smc.update("memberInfo.infoUpdate", vo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return check;
	}

	@Override
	public int passUpdate(MemberVO vo) {
		int check = 0;
		try {
			check = smc.update("memberInfo.passUpdate", vo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return check;
	}

	@Override
	public int deleteAccount(String memId) {
		int check = 0;
		try {
			check = smc.delete("memberInfo.memberDelete", memId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return check;
	}

	@Override
	public MemberVO getInfo(String memId) {
		MemberVO vo = null;
		try {
			vo = (MemberVO) smc.queryForObject("memberInfo.getInfo", memId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vo;
	}

}
