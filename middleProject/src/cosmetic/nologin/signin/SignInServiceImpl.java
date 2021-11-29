package cosmetic.nologin.signin;

import cosmetic.vo.MemberVO;

public class SignInServiceImpl implements ISignInService {
	private static ISignInService service;
	private ISignInDao dao;
	
	private SignInServiceImpl() {
		dao = SignInDaoImpl.getInstance();
	}
	
	public static ISignInService getInstance() {
		if(service == null) service = new SignInServiceImpl();
		return service;
	}

	@Override
	public int insertMeber(MemberVO memVo) {
		return dao.insertMeber(memVo);
	}

	@Override
	public int countMemeber(String mem_id) {
		return dao.countMemeber(mem_id);
	}



}
