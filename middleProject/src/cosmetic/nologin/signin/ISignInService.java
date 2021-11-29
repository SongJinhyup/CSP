package cosmetic.nologin.signin;

import cosmetic.vo.MemberVO;

public interface ISignInService {
	public int insertMeber(MemberVO memVo);
	
	public int countMemeber(String mem_id);
}
