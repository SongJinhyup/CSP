package cosmetic.nologin.enterlogin;

import java.util.Map;

import cosmetic.vo.MemberVO;

public class MemberLoginServiceImpl implements IMemberLoginService {

	private IMemberLoginDao memDao;
	
	private static MemberLoginServiceImpl service;
	
	private MemberLoginServiceImpl() {
		memDao = MemberLoginDaoImpl.getInstance();
		
	}
	
	public static MemberLoginServiceImpl getInstance() {
		if(service==null) service= new MemberLoginServiceImpl();
		return service;
		
	}
	
	@Override
	public MemberVO logInMember(MemberVO memVo) {
		return memDao.logInMember(memVo);
	}


	@Override
	public String findPass(MemberVO membervo) {
		return memDao.findPass(membervo);
	}

	@Override
	public String findId(Map<String, String> paramap) {
		return memDao.findId(paramap);
	}




}
